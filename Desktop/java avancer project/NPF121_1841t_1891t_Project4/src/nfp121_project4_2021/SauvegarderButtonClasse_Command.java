/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.*;
import javax.swing.*;
import org.json.simple.*;

/**
 *
 * @author DELL LATITUDE
 */
public class SauvegarderButtonClasse_Command extends JButton implements CommandInterface_Command {

    NFP121_Project4_2021 editor;

    public SauvegarderButtonClasse_Command(String name, NFP121_Project4_2021 editor) {
        super(name);
        this.editor = editor;

    }

    @Override
    public void execute() {
        //Cheque si les textFields sont vide, s'ils sont vide il ya un alert pour eviter les erreurs et les exceptions

        if (editor.textFiled_compte_Class.getText().length() == 0) {
            editor.jop.showMessageDialog(this, "please fill out all fields", "Alert", JOptionPane.WARNING_MESSAGE);

        } else {
            // prend les donnees et les stockees dans des variables 
            String codeMatieres = editor.ComboBox_Matiereclass.getSelectedItem().toString();
            //le code si dessous prend le centre selected du combobox et le donnee comme parametre dans la fonction 
            //declarer en utilisant le pattrons factory
            String compus = getCenterfromCombobox(editor.ComboBox_campus_Class.getSelectedItem().toString());
            String semester;
            if (editor.RadioButton_semester1_Class.isSelected()) {
                semester = "Sem1";
            } else {
                semester = "Sem2";
            }
            String annee = editor.textFiled_annee_Class.getText();
            //Reformuler le class 
            String codeClass = codeMatieres + "-" + compus + "-" + semester + "_" + annee;

            String compte = editor.textFiled_compte_Class.getText();

            //Creation d'une objet enseignant pour prendre d'elle l'id 
            Classe classe = new Classe(codeClass, compte);

            // Creation d'un FileWriter object qui prend dans leur parametres : le fichier "matieres.json" et true 
            // pour que le fichier ouvrit est en mode append
            FileWriter file;
            int lines;

            try {
                File f = new File("class.json");

                file = new FileWriter(f, true);
                // Creation un BufferedWriter
                BufferedWriter buffer = new BufferedWriter(file);
                // Creation un objet de type JSONObject
                JSONObject obj = new JSONObject();

                //compter le number des lignes enregistrer actuellement dans le fichier
                Path path = Paths.get("class.json");

                lines = (int) Files.lines(path).count();
                //si le fichier n'est pas vide, on prend le number des lignes est on ajout 1 pour le nouvelle objet 

                if (f.length() != 0) {
                    classe.setNumeroSerie(++lines);
                }
                // ajouter les donnees dans l'objet json specifier par salle

                obj.put("classId", classe.getNoClass());
                obj.put("codeClass", codeClass);
                obj.put("compteClasse", Integer.parseInt(compte));

                buffer.write(obj.toJSONString());
                buffer.newLine();

                // Closes writer
                buffer.close();
            } catch (IOException ex) {
                //JoptionPane pour fermer le programme
                editor.alert.JOptionPaneClose("clique sur yes pour fermer l'application");
            }

        }
    }

    //Fonction qui utilise factory pattern
    public String getCenterfromCombobox(String selectedItem) {

        return CenterFactoryDemo.getCenterDemo(selectedItem);

    }

}
