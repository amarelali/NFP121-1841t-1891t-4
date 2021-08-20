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
import org.json.simple.JSONObject;

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
        if (editor.textFiled_CodeMatiere.getText().length() == 0) {
            editor.jop.showMessageDialog(this, "please fill out all fields", "Alert", JOptionPane.WARNING_MESSAGE);

        } else {
            // get text filed

            String codeMatiere = editor.textFiled_CodeMatiere.getText();

            String compus = editor.ComboBox_CampusMatiere.getSelectedItem().toString();

            Matieres matiere = new Matieres(codeMatiere, compus);

            // Creates a FileWriter
            FileWriter file;
            int lines;

            try {
                File f = new File("matieres.json");

                file = new FileWriter(f, true);
                // Creates a BufferedWriter
                BufferedWriter buffer = new BufferedWriter(file);
                // Writes the string to the file
                JSONObject obj = new JSONObject();

                Path path = Paths.get("matieres.json");

                lines = (int) Files.lines(path).count();
                if (f.length() != 0) {
                    matiere.setNumeroSerie(++lines);
                }

                obj.put("MatiereId", matiere.getNoMatiere());
                obj.put("codeMatiere", codeMatiere);
                obj.put("compus", compus);

                buffer.write(obj.toJSONString());
                buffer.newLine();

                // Closes the writer
                buffer.close();
            } catch (IOException ex) {
                //JoptionPane close programme
            }

        }

    }

}
