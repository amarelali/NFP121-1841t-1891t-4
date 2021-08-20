/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import java.awt.event.*;

/**
 *
 * @author DELL LATITUDE
 */
public class ButtonHandler_Command implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      CommandInterface_Command CommandObj = (CommandInterface_Command) e.getSource();
      CommandObj.execute();
    }
}

