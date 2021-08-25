package nfp121_project4_2021;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;
import org.json.simple.*;

/**
 *
 * @author DELL LATITUDE
 */
class SauvegarderButtonMatieres_Command extends JButton implements CommandInterface_Command {

    NFP121_Project4_2021 editor;

    public SauvegarderButtonMatieres_Command(String name, NFP121_Project4_2021 editor) {
        super(name);
        this.editor = editor;

    }

    @Override
    public void execute() {
        //Cheque si les textFields sont vide, s'ils sont vide il ya un alert pour eviter les erreurs et les exceptions
        if (editor.textFiled_CodeMatiere.getText().length() == 0) {
            editor.jop.showMessageDialog(this, "please fill out all fields", "Alert", JOptionPane.WARNING_MESSAGE);

        } else {
            // prend les donnees et les stockees dans des variables 
            String codeMatiere = editor.textFiled_CodeMatiere.getText();

            String compus = editor.ComboBox_CampusMatiere.getSelectedItem().toString();

            Matieres matiere = new Matieres(codeMatiere, compus);

            // Creation d'un FileWriter object qui prend dans leur parametres : le fichier "matieres.json" et true 
            // pour que le fichier ouvrit est en mode append
            FileWriter file;
            int lines;

            try {
                File f = new File("matieres.json");

                file = new FileWriter(f, true);
                // Creation un BufferedWriter
                BufferedWriter buffer = new BufferedWriter(file);
                // Creation un objet de type JSONObject
                JSONObject obj = new JSONObject();

                //compter le number des lignes enregistrer actuellement dans le fichier
                Path path = Paths.get("matieres.json");
                //si le fichier n'est pas vide, on prend le number des lignes est on ajout 1 pour le nouvelle objet 
                lines = (int) Files.lines(path).count();
                if (f.length() != 0) {
                    matiere.setNumeroSerie(++lines);
                }
                // ajouter les donnees dans l'objet json specifier par salle

                obj.put("MatiereId", matiere.getNoMatiere());
                obj.put("codeMatiere", codeMatiere);
                obj.put("compus", compus);

                buffer.write(obj.toJSONString());
                buffer.newLine();

                // Closes the writer
                buffer.close();
            } catch (IOException ex) {
                //JoptionPane pour fermer le programme
                editor.alert.JOptionPaneClose("clique sur yes pour fermer l'application");

            }

        }

    }

}
