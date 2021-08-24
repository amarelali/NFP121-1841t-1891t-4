/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import javax.swing.*;

/**
 *
 * @author DELL LATITUDE
 */
public class Alerts {
    public static void JOptionPane(String message) {

        JOptionPane.showConfirmDialog(null, message, "Faite Attention ", JOptionPane.DEFAULT_OPTION);

    }
    public static void JOptionPaneClose(String message) {

        int result = JOptionPane.showConfirmDialog(null,
                message,
                "Confirm pour Quittez", JOptionPane.CLOSED_OPTION);
        if (result == JOptionPane.CLOSED_OPTION) {
            System.exit(0);

        }

    }
}
