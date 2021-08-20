package nfp121_project4_2021;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.swing.*;
import org.json.simple.*;

/**
 *
 * @author DELL LATITUDE
 */
 class ResetButtonSalle_Command extends JButton implements CommandInterface_Command {
    NFP121_Project4_2021 editor;
   
        public ResetButtonSalle_Command(String name,NFP121_Project4_2021 editor) {
            super(name);
            this.editor = editor;
        }

        @Override
        public void execute() {             
             
             editor.textFiled_cleSalle.setText("");
             editor.textFiled_NameSalle.setText("");
             editor.textFiled_CapaciteSalle.setText("");

             editor.ComboBox_CampusSalle.setSelectedIndex(0);
             
            
          
        }

    }