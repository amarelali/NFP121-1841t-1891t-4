/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import java.io.*;
import java.util.*;
import javax.swing.*;
import org.json.simple.*;

/**
 *
 * @author DELL LATITUDE
 */
class VoirHoraireButton_Command extends JButton implements CommandInterface_Command {

    NFP121_Project4_2021 editor;
    
    HashMap<String, Integer> JourDesSemaines = new HashMap<String, Integer>();
    HashMap<String, Integer> tempEnHeure = new HashMap<String, Integer>();

    public VoirHoraireButton_Command(String name, NFP121_Project4_2021 editor) {
        super(name);
        this.editor = editor;
        JourDesSemaines.put(JourSemaine.Lundi.toString(), 1);
        JourDesSemaines.put(JourSemaine.Mardi.toString(), 2);
        JourDesSemaines.put(JourSemaine.Mercredi.toString(), 3);
        JourDesSemaines.put(JourSemaine.Jeudi.toString(), 4);
        JourDesSemaines.put(JourSemaine.Vendredi.toString(), 5);
        JourDesSemaines.put(JourSemaine.Samedi.toString(), 6);

        tempEnHeure.put(Seance.seance1, 0);
        tempEnHeure.put(Seance.seance2, 1);
        tempEnHeure.put(Seance.seance3, 2);
    }

    @Override
    public void execute() {
        clearTable(editor.table);

        String specialiteSelected = editor.ComboBox_HoraireSpecialite.getSelectedItem().toString();
        String centreSelected = editor.ComboBox_HoraireCenter.getSelectedItem().toString();
        
        //code
        File file;
        String Linefile;
        try {
            file = new File(centreSelected + "-" + specialiteSelected + ".json");
            FileReader fr = new FileReader(file);

            BufferedReader buffer = new BufferedReader(fr);

            while ((Linefile = buffer.readLine()) != null) {
                
                Object obj = JSONValue.parse(Linefile);
                JSONObject jsonObject = (JSONObject) obj;
                // lire data du fichier et l'afficher comme un seul string dans le tableaux d'horaire 
                String data = "Enseignant : \n";
                String NomEnseignant = (String) jsonObject.get("NomEnseignant");
                data += NomEnseignant + "\n";
                data += "Matiere : \n";
                String classes = (String) jsonObject.get("class");
                data += classes + "\n";
                String salle = (String) jsonObject.get("salle");
                data += "Salle : \n";
                data += salle;
                
                String jour = (String) jsonObject.get("jour");
                int indiceColumn = this.JourDesSemaines.get(jour);
                
                String temp = (String) jsonObject.get("seance");
                int indiceRow = this.tempEnHeure.get(temp);
                
                editor.table.setValueAt(data, indiceRow, indiceColumn);

            }
            // Closes the writer
            buffer.close();
        } catch (IOException ex) {
            //JOPtionPane close 
            editor.alert.JOptionPaneClose("Il n'ya pas horaire pour center : "+editor.ComboBox_HoraireCenter.getSelectedItem() +
                    "\net specialite : "+editor.ComboBox_HoraireSpecialite.getSelectedItem());
            System.out.println(ex.getMessage());

        }

    }

    public void clearTable(JTable table) {

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j <= 2; j++) {
                editor.table.setValueAt("", j, i);
            }
        }

    }
}
