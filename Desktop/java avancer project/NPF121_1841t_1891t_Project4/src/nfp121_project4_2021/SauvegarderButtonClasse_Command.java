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
        
        if ( editor.textFiled_compte_Class.getText().length() == 0 ){
                  editor.jop.showMessageDialog(this,"please fill out all fields","Alert",JOptionPane.WARNING_MESSAGE);     
            
        }else{
        // get text filed
        String codeMatieres = editor.ComboBox_Matiereclass.getSelectedItem().toString();
        String compus = getCenterfromCombobox(editor.ComboBox_campus_Class.getSelectedItem().toString());
        String semester;
        if (editor.RadioButton_semester1_Class.isSelected()) {
            semester = "Sem1";
        } else {
            semester = "Sem2";
        }
        String annee = editor.textFiled_annee_Class.getText();
        String codeClass = codeMatieres + "-" + compus + "-" + semester + "_" + annee;
        String compte = editor.textFiled_compte_Class.getText();

        Classe classe = new Classe(codeClass, compte);

        // Creates a FileWriter
        FileWriter file;
        int lines;

        try {
            File f = new File("class.json");

            file = new FileWriter(f, true);
            // Creates a BufferedWriter
            BufferedWriter buffer = new BufferedWriter(file);
            // Writes the string to the file
            JSONObject obj = new JSONObject();

            Path path = Paths.get("class.json");

            lines = (int) Files.lines(path).count();
            if (f.length() != 0) {
                classe.setNumeroSerie(++lines);
            }
            
            obj.put("classId", classe.getNoClass());
            obj.put("codeClass", codeClass);
            obj.put("compteClasse", Integer.parseInt(compte));

            buffer.write(obj.toJSONString());
            buffer.newLine();

            // Closes the writer
            buffer.close();
        } catch (IOException ex) {
            //JoptionPane close programme
        }

    }
    }

    public String getCenterfromCombobox(String selectedItem) {

        return CenterFactoryDemo.getCenterDemo(selectedItem);

    }

}