/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import java.io.*;
import java.util.*;
import javax.swing.*;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.*;

/**
 *
 * @author DELL LATITUDE
 */
public class ResetButtonClasse_Command extends JButton implements CommandInterface_Command {

    NFP121_Project4_2021 editor;

    public ResetButtonClasse_Command(String name, NFP121_Project4_2021 editor) {
        super(name);
        this.editor = editor;
    }

    @Override
    public void execute() {

        editor.textFiled_compte_Class.setText("");
        editor.bg.clearSelection();
        editor.ComboBox_Matiereclass.setSelectedIndex(0);
        editor.ComboBox_campus_Class.setSelectedIndex(0);

        
    }

}
