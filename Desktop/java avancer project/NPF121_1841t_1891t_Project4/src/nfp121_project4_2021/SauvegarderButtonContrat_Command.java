/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;
import org.json.simple.*;

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

        JSONObject obj = new JSONObject();

        String nomEnseignant = editor.ComboBox_EnseignantContart.getSelectedItem().toString();

        String codeMatieres = editor.ComboBox_matiereContart.getSelectedItem().toString();

        //Enseignant 
        String specialite = getSpecialiteFromNomEnseignant(nomEnseignant, obj);
        obj.put("specialite", specialite);

        String compus = getCompusFromCodeMatieres(codeMatieres, obj);
        obj.put("compus", compus);

        String jour = editor.ComboBox_jour.getSelectedItem().toString();
        obj.put("jour", jour);

        String _class = editor.ComboBox_Class.getSelectedItem().toString();
        obj.put("class", _class);

        String seance = editor.ComboBox_seance.getSelectedItem().toString();
        obj.put("seance", seance);

        String salle = editor.ComboBox_salle.getSelectedItem().toString();
        obj.put("salle", salle);
        File tempFile = new File(compus + "-" + specialite + ".json");
        boolean exists = tempFile.exists();

        if (exists) {
            boolean b = checkContrat(compus, specialite, salle, jour, seance);// bye2der ya3ml creation l json mn dun tadarob

            if (b) {
                FileWriter file;
                try {
                    File f = new File(compus + "-" + specialite + ".json");

                    file = new FileWriter(f, true);

                    BufferedWriter buffer = new BufferedWriter(file);

                    buffer.write(obj.toJSONString());
                    buffer.newLine();

                    // Closes the writer
                    buffer.close();
                } catch (IOException ex) {
                    //JoptionPane close programme
                    editor.alert.JOptionPaneClose("clique sur yes pour fermer l'application");
                }

            }
        } else {
            FileWriter file;
            try {
                File f = new File(compus + "-" + specialite + ".json");

                file = new FileWriter(f, true);

                BufferedWriter buffer = new BufferedWriter(file);

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

    private String getSpecialiteFromNomEnseignant(String nomEnseignant, JSONObject obj) {
        String specialite;
        File fileEnseignant;
        String LinefileEnseignant;
        try {

            fileEnseignant = new File("enseignant.json");
            FileReader frEnseignant = new FileReader(fileEnseignant);

            BufferedReader buffer = new BufferedReader(frEnseignant);

            while ((LinefileEnseignant = buffer.readLine()) != null) {

                Object object = JSONValue.parse(LinefileEnseignant);
                JSONObject jsonObject = (JSONObject) object;

                String NomEnseignant = (String) jsonObject.get("NomEnseignant");

                if (NomEnseignant.equals(nomEnseignant)) {

                    specialite = (String) jsonObject.get("specialite");

                    obj.put("NomEnseignant", (String) jsonObject.get("NomEnseignant"));
                    obj.put("specialite", (String) jsonObject.get("specialite"));

                    return specialite;

                }

            }
            // Closes the writer
            buffer.close();
        } catch (IOException ex) {
            //JOPtionPane close
            editor.alert.JOptionPane("Something went wrong");
        }
        return "";
    }

    private String getCompusFromCodeMatieres(String codeMatieres, JSONObject obj) {
        String compus;
        File fileMatieres;
        String LineMatieres;
        try {
            fileMatieres = new File("matieres.json");
            FileReader frMatieres = new FileReader(fileMatieres);
            // Creates a BufferedWriter
            BufferedReader buffer = new BufferedReader(frMatieres);
            // Writes the string to the file

            while ((LineMatieres = buffer.readLine()) != null) {

                Object object = JSONValue.parse(LineMatieres);
                JSONObject jsonObject = (JSONObject) object;
                String codeMatiere = (String) jsonObject.get("codeMatiere");
                if (codeMatiere.equals(codeMatieres)) {

                    compus = (String) jsonObject.get("compus");

                    obj.put("compus", (String) jsonObject.get("compus"));
                    obj.put("codeMatiere", (String) jsonObject.get("codeMatiere"));

                    return compus;
                }

            }
            // Closes the writer
            buffer.close();
        } catch (IOException ex) {
            //JOPtionPane close 
            editor.alert.JOptionPane("Something went wrong");

        }
        return "";

    }

    //cheque contrat pour eviter la conflit 
    private boolean checkContrat(String compus, String specialite, String salleSelected, String jourSelected, String tempSelected) {
        FileReader file;
        String Linefile;
        try {
            File f = new File(compus + "-" + specialite + ".json");

            file = new FileReader(f);
            // Creates a BufferedWriter
            BufferedReader buffer = new BufferedReader(file);

            while ((Linefile = buffer.readLine()) != null) {
                System.out.println(Linefile);
                Object obj = JSONValue.parse(Linefile);
                JSONObject jsonObject = (JSONObject) obj;

                String salle = (String) jsonObject.get("salle");
                String jour = (String) jsonObject.get("jour");
                String temps = (String) jsonObject.get("seance");

                if (salle.equals(salleSelected) && jour.equals(jourSelected) && temps.equals(tempSelected)) {
                    editor.alert.JOptionPane("il ya conflit");
                    return false;
                }

            }

            // Closes the writer
            buffer.close();
        } catch (IOException ex) {
            //JoptionPane close programme
            editor.alert.JOptionPaneClose("clique sur OK pour fermer l'application " + ex.getMessage());
            return false;

        }
        return true;
    }

}
