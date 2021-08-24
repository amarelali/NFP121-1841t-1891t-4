/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import java.io.*;
import javax.swing.*;
import org.json.simple.*;

/**
 *
 * @author DELL LATITUDE
 */
public class ResetButtonContrat_Command extends JButton implements CommandInterface_Command {

    NFP121_Project4_2021 editor;

    public ResetButtonContrat_Command(String name, NFP121_Project4_2021 editor) {
        super(name);
        this.editor = editor;
    }

    @Override
    public void execute() {

        editor.ComboBox_EnseignantContart.setSelectedIndex(0);
        editor.ComboBox_matiereContart.setSelectedIndex(0);
        editor.ComboBox_seance.setSelectedIndex(0);
        editor.ComboBox_Class.setSelectedIndex(0);
        editor.ComboBox_salle.setSelectedIndex(0);
        editor.ComboBox_jour.setSelectedIndex(0);

        File fileMatieres;
        String Line;
        try {
            fileMatieres = new File("Beirut-Informatique.json");
            FileReader frMatieres = new FileReader(fileMatieres);
            // Creates a BufferedWriter
            BufferedReader buffer = new BufferedReader(frMatieres);
            // Writes the string to the file

            while ((Line = buffer.readLine()) != null) {
                System.out.println(Line);
                Object obj = JSONValue.parse(Line);
                JSONObject jsonObject = (JSONObject) obj;

                String compusfromfile = (String) jsonObject.get("compus");
                String compusfromCombobox = editor.ComboBox_HoraireCenter.getSelectedItem().toString();
//                System.out.println(compusfromfile);
                writeContratDataGroupByCenter(compusfromCombobox, compusfromfile, jsonObject);

                String specialitefromfile = (String) jsonObject.get("specialite");
                String specialitefromCombobox = editor.ComboBox_HoraireSpecialite.getSelectedItem().toString();
                writeContratDataGroupBySpecialite( specialitefromCombobox ,  specialitefromfile ,  jsonObject);
            }
            // Closes the writer
            buffer.close();
        } catch (IOException ex) {
            //JOPtionPane close 
             editor.alert.JOptionPaneClose("clique sur yes pour fermer l'application");
        }

    }

    private void writeContratDataGroupByCenter(String compus, String center, JSONObject jsonObject) {
        try {
            FileWriter file;

            File f = new File(center + ".json");

            file = new FileWriter(f, true);
            // Creates a BufferedWriter
            BufferedWriter buffer = new BufferedWriter(file);
            // Writes the string to the file
            if (compus.equals(center)) {

                buffer.write(jsonObject.toJSONString());
                buffer.newLine();
            }
            // Closes the writer
            buffer.close();
        } catch (IOException ex) {
            //JoptionPane close programme
            editor.alert.JOptionPaneClose("clique sur yes pour fermer l'application");
        }

    }

    private void writeContratDataGroupBySpecialite(String speciatilefromCombobox, String speciatilefromfile, JSONObject jsonObject) {
        try {
            FileWriter file;

            File f = new File(speciatilefromCombobox + ".json");

            file = new FileWriter(f, true);
            // Creates a BufferedWriter
            BufferedWriter buffer = new BufferedWriter(file);
            // Writes the string to the file
            if (speciatilefromCombobox.equals(speciatilefromfile)) {

                buffer.write(jsonObject.toJSONString());
                buffer.newLine();
            }
            // Closes the writer
            buffer.close();
        } catch (IOException ex) {
            //JoptionPane close programme
            editor.alert.JOptionPaneClose("clique sur yes pour fermer l'application");
        }

    }

}
