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
class SauvegarderButtonSalle_Command extends JButton implements CommandInterface_Command {

    NFP121_Project4_2021 editor;

    public SauvegarderButtonSalle_Command(String name, NFP121_Project4_2021 editor) {
        super(name);
        this.editor = editor;

    }

    @Override
    public void execute() {
        
        //Cheque si les textFields sont vide, s'ils sont vide il ya un alert pour eviter les erreurs et les exceptions
        
        if (editor.textFiled_NameSalle.getText().length() == 0 && editor.textFiled_CapaciteSalle.getText().length() == 0) {
            editor.jop.showMessageDialog(this, "please fill out all fields", "Alert", JOptionPane.WARNING_MESSAGE);

        } else {
            // prend les donnees et les stockees dans des variables 
            String nomSalle = editor.textFiled_NameSalle.getText();
            int capaciteSalle = Integer.parseInt(editor.textFiled_CapaciteSalle.getText());
            String compus = editor.ComboBox_CampusSalle.getSelectedItem().toString();
            String capaciter = editor.textFiled_CapaciteSalle.getText();
            
            //Creation d'une objet salle pour prendre d'elle l'id 
            Salle salle = new Salle(nomSalle, compus, capaciteSalle);

            // Creation d'un FileWriter object qui prend dans leur parametres : le fichier "salle.json" et true 
            // pour que le fichier ouvrit est en mode append
            FileWriter file;
            int lines;

            try {
                File f = new File("salle.json");

                file = new FileWriter(f, true);
                // Creation un BufferedWriter
                BufferedWriter buffer = new BufferedWriter(file);
                // Creation un objet de type JSONObject
                JSONObject obj = new JSONObject();

                //compter le number des lignes enregistrer actuellement dans le fichier
                Path path = Paths.get("salle.json");
                lines = (int) Files.lines(path).count();
                
                //si le fichier n'est pas vide, on prend le number des lignes est on ajout 1 pour le nouvelle objet 
                if (f.length() != 0) {
                    salle.setNumeroSerie(++lines);
                }
                // ajouter les donnees dans l'objet json specifier par salle
                
                obj.put("salleId", salle.getNoSalle());
                obj.put("nomSalle", nomSalle);
                obj.put("compus", compus);
                obj.put("capaciter", Integer.parseInt(capaciter));

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

}
