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
public class ResetButtonMatieres_Command extends JButton implements CommandInterface_Command {
    NFP121_Project4_2021 editor;
   
        public ResetButtonMatieres_Command(String name,NFP121_Project4_2021 editor) {
            super(name);
            this.editor = editor;
        }

        @Override
        public void execute() {             
             
             editor.textFiled_cleMatiere.setText("");
             editor.textFiled_CodeMatiere.setText("");

             editor.ComboBox_CampusMatiere.setSelectedIndex(0);
       
        
        }
    }