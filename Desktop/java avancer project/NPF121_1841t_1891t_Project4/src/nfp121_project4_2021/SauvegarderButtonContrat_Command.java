/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author DELL LATITUDE
 */
public class SauvegarderButtonContrat_Command extends JButton implements CommandInterface_Command {

    NFP121_Project4_2021 editor;

    public SauvegarderButtonContrat_Command(String name, NFP121_Project4_2021 editor) {
        super(name);
        this.editor = editor;

    }
        @Override
        public void execute() {
            
            //new class 
              String nomEnseignant = editor.ComboBox_EnseignantContart.getSelectedItem().toString();
              String codeMatieres = editor.ComboBox_matiereContart.getSelectedItem().toString();
//              Enseignant enseignant = new Enseignant(nomEnseignant);

            
            
            
            
//                if (editor.textFiled_CodeMatiere.getText().length() != 0) {
//                     
////                     // get text filed
////                    String cleMatiere = editor.textFiled_cleMatiere.getText();
////                    String codeMatiere = editor.textFiled_CodeMatiere.getText();
////                    
//                    //new class 
//                    String nomEnseignant = editor.ComboBox_EnseignantContart.getSelectedItem().toString();
//                    String codeMatieres = editor.ComboBox_EnseignantContart.getSelectedItem().toString();
//
//        Enseignant enseignant = new Enseignant(nomEnseignant);
//        Contrat contrat = new Contrat(Enseignant enseignant, Matieres matiere);
//                   
//                    // pour l numero auto
//                    editor.textFiled_cleMatiere.setText("" + contrat.getNoMatiere());
//                   System.out.println(contrat.afficheContrat());
//                    //push dans HashMap
//                    MapContrat.put(contrat.getMatiere(), contrat);
//                     System.out.println(MapContrat);
//                    Collection<Matieres> matieresCollection = MapMatiere.values();
//                    try {
//                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Contrat.obj"));
//                        for (Matieres x : matieresCollection) {
//                            
//                            out.writeObject(x);
//                            System.out.println(x);
//                        }
//                        out.close();
//                    } catch (FileNotFoundException ex) {
//
//                    } catch (IOException ex) {
//                        
//                    }
                    
               
                 }
              
        }

//}
