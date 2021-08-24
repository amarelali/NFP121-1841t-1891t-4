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

        if (editor.textFiled_NameSalle.getText().length() == 0 && editor.textFiled_CapaciteSalle.getText().length() == 0) {
            editor.jop.showMessageDialog(this, "please fill out all fields", "Alert", JOptionPane.WARNING_MESSAGE);

        } else {
            // get text filed
            String nomSalle = editor.textFiled_NameSalle.getText();
            int capaciteSalle = Integer.parseInt(editor.textFiled_CapaciteSalle.getText());
            String compus = editor.ComboBox_CampusSalle.getSelectedItem().toString();
            String capaciter = editor.textFiled_CapaciteSalle.getText();
            Salle salle = new Salle(nomSalle, compus, capaciteSalle);

            // Creates a FileWriter
            FileWriter file;
            int lines;

            try {
                File f = new File("salle.json");

                file = new FileWriter(f, true);
                // Creates a BufferedWriter
                BufferedWriter buffer = new BufferedWriter(file);
                // Writes the string to the file
                JSONObject obj = new JSONObject();

                Path path = Paths.get("salle.json");

                lines = (int) Files.lines(path).count();
                if (f.length() != 0) {
                    salle.setNumeroSerie(++lines);
                }

                obj.put("salleId", salle.getNoSalle());
                obj.put("nomSalle", nomSalle);
                obj.put("compus", compus);
                obj.put("capaciter", Integer.parseInt(capaciter));

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
