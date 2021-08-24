/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;
import org.json.simple.JSONObject;

/**
 *
 * @author DELL LATITUDE
 */
public class SauvegarderButtonEnseignant_Command extends JButton implements CommandInterface_Command {

    NFP121_Project4_2021 editor;

    public SauvegarderButtonEnseignant_Command(String name, NFP121_Project4_2021 editor) {
        super(name);
        this.editor = editor;

    }

    @Override
    public void execute() {

        if (editor.textFiled_NameEnseignant.getText().length() == 0) {
            editor.jop.showMessageDialog(this, "please fill out all fields", "Alert", JOptionPane.WARNING_MESSAGE);

        } else {
            // get text filed

            String NomEnseignant = editor.textFiled_NameEnseignant.getText();

            String specialite = editor.ComboBox_sepcialite_Enseignant.getSelectedItem().toString();

            Enseignant enseignant = new Enseignant(NomEnseignant, specialite);

            // Creates a FileWriter
            FileWriter file;
            int lines;

            try {
                File f = new File("enseignant.json");

                file = new FileWriter(f, true);
                // Creates a BufferedWriter
                BufferedWriter buffer = new BufferedWriter(file);
                // Writes the string to the file
                JSONObject obj = new JSONObject();

                Path path = Paths.get("enseignant.json");

                lines = (int) Files.lines(path).count();
                if (f.length() != 0) {
                    enseignant.setNumeroSerie(++lines);
                }

                obj.put("enseignantId", enseignant.getNoEnseignant());
                obj.put("NomEnseignant", NomEnseignant);
                obj.put("specialite", specialite);

                buffer.write(obj.toJSONString());
                buffer.newLine();

                // Closes the writer
                buffer.close();
            } catch (IOException ex) {
                //JoptionPane close programme
                editor.alert.JOptionPaneClose("clique sur yes pour fermer l'application");
            }

        }

    }

}
