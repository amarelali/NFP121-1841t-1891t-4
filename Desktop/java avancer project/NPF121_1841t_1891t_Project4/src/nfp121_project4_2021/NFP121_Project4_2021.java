package nfp121_project4_2021;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class NFP121_Project4_2021 {

    Alerts alert;
    JOptionPane jop;
    private JMenuBar mbar;
    private JFrame frame;
    private JPanel panel_NORTH, panel_WEST, panel_Contart, panelTable, panel_Salle, panel_Matiere, panel_Enseignant, panel_class, panel_background;

    //salle 
    private JPanel panel_NameSalle, panel_campus, panel_capacite, panle_textFileds, panel_buttons_Salle, contenu1_Salle, panel_combox, contenu2_Salle;
    private JLabel label_NameSalle, label_campus, label_Capacite;
    JTextField textFiled_cleSalle, textFiled_NameSalle, textFiled_CapaciteSalle;

    JComboBox ComboBox_CampusSalle;
    private JButton button_Salle;

    SauvegarderButtonSalle_Command button_Enr_Salle;
    ResetButtonSalle_Command button_Reset_Salle;

    //matiere 
    private JLabel label_CodeMatiere, label_campus_Matiere;
    private JButton button_Next_Matiere;
    private JPanel panle_textFileds_Matiere, panel_buttons_Matiere, contenu1_Matiere, contenu2_Matiere, panel_NameMatiere, panel_campus_Matiere;
    JTextField textFiled_cleMatiere, textFiled_CodeMatiere;
    JComboBox ComboBox_CampusMatiere;

    SauvegarderButtonMatieres_Command button_Enr_Matieres;
    ResetButtonMatieres_Command button_Reset_Matieres;
    // Enseignant
    private JLabel label_NameEnseignant, label_sepcialite_Enseignant;
    private JButton button_Next_Enseignant;
    private JPanel panle_textFileds_Enseignant, panel_buttons_Enseignant, contenu1_Enseignant, contenu2_Enseignant, panel_NameEnseignant, panel_specialite_Enseignant;
    JTextField textFiled_cleEnseignant, textFiled_NameEnseignant;
    JComboBox ComboBox_sepcialite_Enseignant;
    //class
    private JLabel label_matiere_Class, label_campus_Class, label_semester1_Class, label_année_Class, label_compte_Class, label_semester2_Class;
    ResetButtonClasse_Command button_Reset_Class;
    SauvegarderButtonClasse_Command button_Enr_Class;
    private JButton button_Class;
    private JPanel panle_textFileds_Class, panel_buttons_Class, contenu1_Class, panel_matiere_Class, panel_campus_Class, panel_semester_Class, panel_annee_Class, panel_compte_Class;
    JTextField textFiled_annee_Class, textFiled_compte_Class;
    JRadioButton RadioButton_semester1_Class, RadioButton_semester2_Class;
    JComboBox ComboBox_Matiereclass, ComboBox_campus_Class, ComboBox__année_Class;
    ButtonGroup bg;
    // contract
    private JLabel label_Enseignant, label_matiere, label_Class, label_jour, label_seance, label_salle;
    ResetButtonContrat_Command button_Reset_Contart;
    SauvegarderButtonContrat_Command button_Enr_Contart;
    private JButton button_Contart, button_voireHoraire;
    private JPanel panel_EnseignantContart, panle_textFileds_Contart, panel_buttons_Contart, contenu1_Class_Contart, panel_matiere_Contart, panel_Class_contrat, panel_jour_contrat, panel_seance_contrat, panel_salle_contrat;
    JComboBox ComboBox_EnseignantContart, ComboBox_matiereContart, ComboBox_seance, ComboBox_Class, ComboBox_salle, ComboBox_jour;
    private JButton button_voireHoraireBar;
    VoirHoraireButton_Command button_voire_Horaire;
    private JLabel label_sepcialite, label_Center;
    JComboBox ComboBox_HoraireCenter, ComboBox_HoraireSpecialite;
    JPanel panel_top, panel_ComboBox_HoraireCenter, panel_ComboBox_HoraireSpecialite;
    JTable table;

    public NFP121_Project4_2021() {
        frame = new JFrame("Gestion de system  universitaire");

        panel_NORTH = new JPanel(new BorderLayout());
        panel_WEST = new JPanel(new BorderLayout());
        panel_background = new JPanel();
        panelTable = new JPanel(new BorderLayout());

        //////////////////          Salle          //////////////////////////      
        panel_Salle = new JPanel(new BorderLayout());
        panel_Salle.setVisible(true);
        panel_buttons_Salle = new JPanel();
        contenu1_Salle = new JPanel(new BorderLayout());

        panel_NameSalle = new JPanel(new FlowLayout());
        panel_campus = new JPanel(new FlowLayout());
        panel_capacite = new JPanel(new FlowLayout());
        panle_textFileds = new JPanel(new GridLayout(0, 1));
        panel_combox = new JPanel(new FlowLayout());
        contenu2_Salle = new JPanel(new BorderLayout());

        mbar = new JMenuBar();

        button_Reset_Salle = new ResetButtonSalle_Command("Reset", this);
        button_Enr_Salle = new SauvegarderButtonSalle_Command("Enregister", this);

        ButtonHandler_Command button = new ButtonHandler_Command();
        button_Enr_Salle.addActionListener(button);
        button_Reset_Salle.addActionListener(button);

        button_Salle = new JButton("Salle");
        button_Salle.setBackground(Color.white);

        String center[] = {"Beirut", "Tripoli", "Naher Ibrahim", "Baalbak"};

        ComboBox_CampusSalle = new JComboBox(center);
        Dimension size = new Dimension(170, 23);
        ComboBox_CampusSalle.setPreferredSize(size);
        ComboBox_CampusSalle.setSelectedIndex(0);

        label_NameSalle = new JLabel("Name Salle");
        label_campus = new JLabel("     Campus  ");
        label_Capacite = new JLabel("Capaciter  ");

        textFiled_cleSalle = new JTextField(15);
        textFiled_cleSalle.enable(false);

        textFiled_NameSalle = new JTextField(15);

        textFiled_CapaciteSalle = new JTextField(15);

        textFiled_CapaciteSalle.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                    alert.JOptionPane("Insert a number");

                }
            }
        });

        panel_buttons_Salle.add(button_Reset_Salle);
        panel_buttons_Salle.add(button_Enr_Salle);

        panel_NameSalle.add(label_NameSalle);
        panel_NameSalle.add(textFiled_NameSalle);

        panel_campus.add(label_campus);
        panel_campus.add(ComboBox_CampusSalle);

        panel_capacite.add(label_Capacite);
        panel_capacite.add(textFiled_CapaciteSalle);

        panle_textFileds.add(panel_NameSalle);
        panle_textFileds.add(panel_campus);
        panle_textFileds.add(panel_capacite);

        contenu1_Salle.add(panle_textFileds, BorderLayout.NORTH);
        contenu1_Salle.add(panel_buttons_Salle, BorderLayout.CENTER);

        panel_Salle.add(contenu1_Salle, BorderLayout.WEST);
        panel_Salle.add(contenu2_Salle, BorderLayout.EAST);

        mbar.setPreferredSize(new Dimension(150, 30));
        panel_WEST.setPreferredSize(new Dimension(750, 600));

        panel_Salle.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SALLE"));

        panel_Salle.setPreferredSize(new Dimension(700, 200));
        panel_background.add(panel_Salle);

        ////////////////////Actions /////////////////////////
        button_Salle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                panel_Salle.setVisible(true);
                panel_Matiere.setVisible(false);
                panel_Enseignant.setVisible(false);
                panel_class.setVisible(false);
                panel_Enseignant.setVisible(false);
                panel_Contart.setVisible(false);
                panelTable.setVisible(false);
            }

        });
        mbar.add(button_Salle);

        ////////////////////////  Matiere  ////////////////////////////
        panel_Matiere = new JPanel(new BorderLayout());
        panel_Matiere.setVisible(false);
        panel_buttons_Matiere = new JPanel();
        contenu1_Matiere = new JPanel(new BorderLayout());
        panel_NameMatiere = new JPanel(new FlowLayout());
        panel_campus_Matiere = new JPanel(new FlowLayout());
        panle_textFileds_Matiere = new JPanel(new GridLayout(0, 1));

        contenu2_Matiere = new JPanel(new BorderLayout());

        button_Reset_Matieres = new ResetButtonMatieres_Command("Reset", this);
        button_Reset_Matieres.addActionListener(button);

        button_Enr_Matieres = new SauvegarderButtonMatieres_Command("Enregister", this);
        button_Enr_Matieres.addActionListener(button);

        button_Next_Matiere = new JButton("Matiere");
        button_Next_Matiere.setBackground(Color.white);

        mbar.add(button_Next_Matiere);

        label_CodeMatiere = new JLabel("Code                ");
        label_campus_Matiere = new JLabel(" Campus          ");

        textFiled_cleMatiere = new JTextField(15);
        textFiled_cleMatiere.enable(false);
        textFiled_CodeMatiere = new JTextField(15);

        ComboBox_CampusMatiere = new JComboBox(center);

        ComboBox_CampusMatiere.setPreferredSize(size);

        panel_buttons_Matiere.add(button_Reset_Matieres);
        panel_buttons_Matiere.add(button_Enr_Matieres);

        panel_NameMatiere.add(label_CodeMatiere);
        panel_NameMatiere.add(textFiled_CodeMatiere);

        panel_campus_Matiere.add(label_campus_Matiere);
        panel_campus_Matiere.add(ComboBox_CampusMatiere);

        panle_textFileds_Matiere.add(panel_NameMatiere);
        panle_textFileds_Matiere.add(panel_campus_Matiere);

        contenu1_Matiere.add(panle_textFileds_Matiere, BorderLayout.NORTH);
        contenu1_Matiere.add(panel_buttons_Matiere, BorderLayout.CENTER);

        panel_Matiere.add(contenu1_Matiere, BorderLayout.WEST);
        panel_Matiere.add(contenu2_Matiere, BorderLayout.EAST);

        panel_Matiere.setPreferredSize(new Dimension(700, 200));
        panel_background.add(panel_Matiere);

        panel_Matiere.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Matiere"));

        ////////////////////////  Actions  //////////////////////////////
        button_Next_Matiere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                panel_Salle.setVisible(false);
                panel_Matiere.setVisible(true);
                panel_Enseignant.setVisible(false);
                panel_class.setVisible(false);
                panel_Enseignant.setVisible(false);
                panel_Contart.setVisible(false);
                panelTable.setVisible(false);

            }

        });

        ///////////////////////    Enseignant  ////////////////////////////////
        panel_Enseignant = new JPanel(new BorderLayout());
        panel_Enseignant.setVisible(false);
        panel_buttons_Enseignant = new JPanel();
        contenu1_Enseignant = new JPanel(new BorderLayout());
        panel_NameEnseignant = new JPanel(new FlowLayout());
        panel_specialite_Enseignant = new JPanel(new FlowLayout());
        panle_textFileds_Enseignant = new JPanel(new GridLayout(0, 1));

        contenu2_Enseignant = new JPanel(new BorderLayout());

        ResetButtonEnseignant_Command button_Reset_Enseignant = new ResetButtonEnseignant_Command("Reset", this);
        button_Reset_Enseignant.addActionListener(button);

        SauvegarderButtonEnseignant_Command button_Enr_Enseignant = new SauvegarderButtonEnseignant_Command("Enregister", this);
        button_Enr_Enseignant.addActionListener(button);

        button_Next_Enseignant = new JButton("Enseignant");
        button_Next_Enseignant.setBackground(Color.white);

        mbar.add(button_Next_Enseignant);

        label_NameEnseignant = new JLabel("Name                     ");
        label_sepcialite_Enseignant = new JLabel(" Specialite             ");

        textFiled_cleEnseignant = new JTextField(15);
        textFiled_cleEnseignant.enable(false);
        textFiled_NameEnseignant = new JTextField(15);

        ComboBox_sepcialite_Enseignant = new JComboBox();
        ComboBox_sepcialite_Enseignant.setPreferredSize(size);
        ComboBox_sepcialite_Enseignant.addItem(Specialite.Informatique);
        ComboBox_sepcialite_Enseignant.addItem(Specialite.Gestion);
        ComboBox_sepcialite_Enseignant.addItem(Specialite.Genie_civil);
        ComboBox_sepcialite_Enseignant.addItem(Specialite.Mecanique);

        panel_buttons_Enseignant.add(button_Reset_Enseignant);
        panel_buttons_Enseignant.add(button_Enr_Enseignant);

        panel_NameEnseignant.add(label_NameEnseignant);
        panel_NameEnseignant.add(textFiled_NameEnseignant);

        panel_specialite_Enseignant.add(label_sepcialite_Enseignant);
        panel_specialite_Enseignant.add(ComboBox_sepcialite_Enseignant);

        panle_textFileds_Enseignant.add(panel_NameEnseignant);
        panle_textFileds_Enseignant.add(panel_specialite_Enseignant);

        contenu1_Enseignant.add(panle_textFileds_Enseignant, BorderLayout.NORTH);
        contenu1_Enseignant.add(panel_buttons_Enseignant, BorderLayout.CENTER);

        panel_Enseignant.add(contenu1_Enseignant, BorderLayout.WEST);
        panel_Enseignant.add(contenu2_Enseignant, BorderLayout.EAST);

        panel_Enseignant.setPreferredSize(new Dimension(700, 200));
        panel_background.add(panel_Enseignant);

        panel_Enseignant.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Enseignant"));
        ////////////////////////////  Action  ////////////////////////////////

        button_Next_Enseignant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                panel_Salle.setVisible(false);
                panel_Matiere.setVisible(false);
                panel_Enseignant.setVisible(true);
                panel_class.setVisible(false);
                panelTable.setVisible(false);

            }

        });

        //////////////////////   Classes     /////////////////////
        panel_class = new JPanel(new BorderLayout());
        panel_class.setVisible(false);
        panel_buttons_Class = new JPanel();
        contenu1_Class = new JPanel(new BorderLayout());
        panel_matiere_Class = new JPanel(new FlowLayout());
        panel_campus_Class = new JPanel(new FlowLayout());
        panel_semester_Class = new JPanel(new FlowLayout());
        panel_annee_Class = new JPanel(new FlowLayout());
        panel_annee_Class = new JPanel(new FlowLayout());
        panel_compte_Class = new JPanel(new FlowLayout());
        panle_textFileds_Class = new JPanel(new GridLayout(0, 1));

        button_Reset_Class = new ResetButtonClasse_Command("Reset", this);
        button_Reset_Class.addActionListener(button);

        button_Enr_Class = new SauvegarderButtonClasse_Command("Enregister", this);
        button_Enr_Class.addActionListener(button);

        button_Class = new JButton("Class");
        button_Class.setBackground(Color.white);

        mbar.add(button_Class);

        label_matiere_Class = new JLabel(" Matiere            ");
        label_campus_Class = new JLabel("Campus             ");
        label_semester1_Class = new JLabel("Semester 1   ");
        label_semester2_Class = new JLabel("Semester 2       ");
        label_année_Class = new JLabel("Année Actuelle      ");
        label_compte_Class = new JLabel("Compte             ");

        textFiled_annee_Class = new JTextField(15);
        textFiled_annee_Class.enable(false);
        textFiled_compte_Class = new JTextField(15);
        textFiled_compte_Class.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                    alert.JOptionPane("Insert a number");
                }
            }
        });
        ComboBox_Matiereclass = new JComboBox();
        ComboBox_Matiereclass.setPreferredSize(size);

        ComboBox_campus_Class = new JComboBox(center);
        ComboBox_campus_Class.setPreferredSize(size);

        int year = Calendar.getInstance().get(Calendar.YEAR);
        textFiled_annee_Class.setText(Integer.toString(year));

        bg = new ButtonGroup();

        RadioButton_semester1_Class = new JRadioButton();
        RadioButton_semester2_Class = new JRadioButton();

        //Default radio button
        RadioButton_semester1_Class.setSelected(true);

        bg.add(RadioButton_semester1_Class);
        bg.add(RadioButton_semester2_Class);

        panel_buttons_Class.add(button_Reset_Class);
        panel_buttons_Class.add(button_Enr_Class);

        panel_matiere_Class.add(label_matiere_Class);
        panel_matiere_Class.add(ComboBox_Matiereclass);

        panel_campus_Class.add(label_campus_Class);
        panel_campus_Class.add(ComboBox_campus_Class);

        panel_semester_Class.add(label_semester1_Class);
        panel_semester_Class.add(RadioButton_semester1_Class);

        panel_semester_Class.add(label_semester2_Class);
        panel_semester_Class.add(RadioButton_semester2_Class);

        panel_annee_Class.add(label_année_Class);
        panel_annee_Class.add(textFiled_annee_Class);

        panel_compte_Class.add(label_compte_Class);
        panel_compte_Class.add(textFiled_compte_Class);

        panle_textFileds_Class.add(panel_matiere_Class);
        panle_textFileds_Class.add(panel_campus_Class);
        panle_textFileds_Class.add(panel_semester_Class);
        panle_textFileds_Class.add(panel_annee_Class);
        panle_textFileds_Class.add(panel_compte_Class);

        contenu1_Class.add(panle_textFileds_Class, BorderLayout.NORTH);
        contenu1_Class.add(panel_buttons_Class, BorderLayout.CENTER);

        panel_class.add(contenu1_Class, BorderLayout.WEST);

        panel_class.setPreferredSize(new Dimension(700, 300));
        panel_background.add(panel_class);

        panel_class.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Class"));
        //////////////////////  Action //////////////////////////

        button_Class.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Matiere 
                ComboBox_Matiereclass.removeAllItems();
                File fileMatieres;
                String LineMatieres;
                try {
                    fileMatieres = new File("matieres.json");
                    FileReader frMatieres = new FileReader(fileMatieres);
                    // Creates a BufferedWriter
                    BufferedReader buffer = new BufferedReader(frMatieres);
                    // Writes the string to the file
                    while ((LineMatieres = buffer.readLine()) != null) {
                        System.out.println(LineMatieres);

                        Object obj = JSONValue.parse(LineMatieres);
                        JSONObject jsonObject = (JSONObject) obj;
                        String codeMatiere = (String) jsonObject.get("codeMatiere");
                        ComboBox_Matiereclass.addItem(codeMatiere);

                    }
                    // Closes the writer
                    buffer.close();
                } catch (IOException ex) {
                    //JOPtionPane close 
                }

                panel_Salle.setVisible(false);
                panel_Matiere.setVisible(false);
                panel_Enseignant.setVisible(false);
                panel_class.setVisible(true);
                panel_Contart.setVisible(false);
                panelTable.setVisible(false);

            }

        });
        //////////////////////////// contart ////////////////////            
        panel_Contart = new JPanel(new BorderLayout());
        panel_Contart.setVisible(false);
        panel_buttons_Contart = new JPanel();
        contenu1_Class_Contart = new JPanel(new BorderLayout());
        panel_EnseignantContart = new JPanel(new FlowLayout());
        panel_matiere_Contart = new JPanel(new FlowLayout());
        panel_Class_contrat = new JPanel(new FlowLayout());
        panel_jour_contrat = new JPanel(new FlowLayout());
        panel_seance_contrat = new JPanel(new FlowLayout());
        panel_salle_contrat = new JPanel(new FlowLayout());
        panle_textFileds_Contart = new JPanel(new GridLayout(0, 1));

        button_Reset_Contart = new ResetButtonContrat_Command("Reset", this);
        button_Reset_Contart.addActionListener(button);
        button_Enr_Contart = new SauvegarderButtonContrat_Command("Enregister", this);
        button_Enr_Contart.addActionListener(button);

        button_Contart = new JButton("Contart");
        button_Contart.setBackground(Color.white);
        button_voireHoraire = new JButton("Voire Horaire");
        button_voireHoraireBar = new JButton("Voire Horaire");
        button_voireHoraireBar.setBackground(Color.white);

        mbar.add(button_Contart);

        label_Enseignant = new JLabel(" Enseignant");
        label_matiere = new JLabel(" Matiere        ");
        label_Class = new JLabel("Class            ");
        label_jour = new JLabel("Jour             ");
        label_seance = new JLabel("Seance         ");
        label_salle = new JLabel("Salle             ");

        ComboBox_EnseignantContart = new JComboBox();
        ComboBox_EnseignantContart.setPreferredSize(size);

        ComboBox_matiereContart = new JComboBox();
        ComboBox_matiereContart.setPreferredSize(size);

        ComboBox_Class = new JComboBox();
        ComboBox_Class.setPreferredSize(size);

        ComboBox_jour = new JComboBox();
        ComboBox_jour.setPreferredSize(size);
        ComboBox_jour.addItem(JourSemaine.Lundi);
        ComboBox_jour.addItem(JourSemaine.Mardi);
        ComboBox_jour.addItem(JourSemaine.Mercredi);
        ComboBox_jour.addItem(JourSemaine.Jeudi);
        ComboBox_jour.addItem(JourSemaine.Vendredi);
        ComboBox_jour.addItem(JourSemaine.Samedi);

        ComboBox_seance = new JComboBox();
        ComboBox_seance.setPreferredSize(size);
        //// 
        ComboBox_seance.addItem(Seance.seance1);
        ComboBox_seance.addItem(Seance.seance2);
        ComboBox_seance.addItem(Seance.seance3);

        ////
        ComboBox_salle = new JComboBox();
        ComboBox_salle.setPreferredSize(size);

        panel_buttons_Contart.add(button_Reset_Contart);
        panel_buttons_Contart.add(button_Enr_Contart);
        panel_buttons_Contart.add(button_voireHoraire);

        panel_EnseignantContart.add(label_Enseignant);
        panel_EnseignantContart.add(ComboBox_EnseignantContart);

        panel_matiere_Contart.add(label_matiere);
        panel_matiere_Contart.add(ComboBox_matiereContart);

        panel_Class_contrat.add(label_Class);
        panel_Class_contrat.add(ComboBox_Class);

        panel_jour_contrat.add(label_jour);
        panel_jour_contrat.add(ComboBox_jour);

        panel_seance_contrat.add(label_seance);
        panel_seance_contrat.add(ComboBox_seance);

        panel_salle_contrat.add(label_salle);
        panel_salle_contrat.add(ComboBox_salle);

        panle_textFileds_Contart.add(panel_EnseignantContart);
        panle_textFileds_Contart.add(panel_matiere_Contart);
        panle_textFileds_Contart.add(panel_Class_contrat);
        panle_textFileds_Contart.add(panel_jour_contrat);
        panle_textFileds_Contart.add(panel_seance_contrat);
        panle_textFileds_Contart.add(panel_salle_contrat);

        contenu1_Class_Contart.add(panle_textFileds_Contart, BorderLayout.NORTH);
        contenu1_Class_Contart.add(panel_buttons_Contart, BorderLayout.CENTER);

        panel_Contart.add(contenu1_Class_Contart, BorderLayout.WEST);

        panel_Contart.setPreferredSize(new Dimension(700, 300));
        panel_background.add(panel_Contart);

        panel_Contart.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Contart"));

        ////////////////   Action   //////////////////
        button_Contart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Enseignant 
                ComboBox_EnseignantContart.removeAllItems();

                File fileEnseignant;
                String LinefileEnseignant;
                try {
                    fileEnseignant = new File("enseignant.json");
                    FileReader frEnseignant = new FileReader(fileEnseignant);
                    // Creates a BufferedWriter
                    BufferedReader buffer = new BufferedReader(frEnseignant);
                    // Writes the string to the file

                    while ((LinefileEnseignant = buffer.readLine()) != null) {
                        Object obj = JSONValue.parse(LinefileEnseignant);
                        JSONObject jsonObject = (JSONObject) obj;

                        String NomEnseignant = (String) jsonObject.get("NomEnseignant");
                        ComboBox_EnseignantContart.addItem(NomEnseignant);

                    }
                    // Closes the writer
                    buffer.close();
                } catch (IOException ex) {
                    //JOPtionPane close 
                }
                //Matiere 
                ComboBox_matiereContart.removeAllItems();

                File fileMatieres;
                String LineMatieres;
                try {
                    fileMatieres = new File("matieres.json");
                    FileReader frMatieres = new FileReader(fileMatieres);
                    // Creates a BufferedWriter
                    BufferedReader buffer = new BufferedReader(frMatieres);
                    // Writes the string to the file

                    while ((LineMatieres = buffer.readLine()) != null) {
                        Object obj = JSONValue.parse(LineMatieres);
                        JSONObject jsonObject = (JSONObject) obj;
                        String codeMatiere = (String) jsonObject.get("codeMatiere");
                        ComboBox_matiereContart.addItem(codeMatiere);

                    }
                    // Closes the writer
                    buffer.close();
                } catch (IOException ex) {
                    //JOPtionPane close 
                }
                //Class
                ComboBox_Class.removeAllItems();

                File fileClass;
                String LineClass;
                try {
                    fileClass = new File("class.json");
                    FileReader frClass = new FileReader(fileClass);
                    // Creates a BufferedWriter
                    BufferedReader buffer = new BufferedReader(frClass);
                    // Writes the string to the file

                    while ((LineClass = buffer.readLine()) != null) {
                        Object obj = JSONValue.parse(LineClass);
                        JSONObject jsonObject = (JSONObject) obj;
                        String codeMatiere = (String) jsonObject.get("codeClass");
                        ComboBox_Class.addItem(codeMatiere);

                    }
                    // Closes the writer
                    buffer.close();
                } catch (IOException ex) {
                    //JOPtionPane close 
                }

                //remplir le combobox dans le panel responsable au contrat des objets SALLE
                ComboBox_salle.removeAllItems();
                // Creates a FileWriter
                File fileSalle;
                String LineSalle;
                try {
                    fileSalle = new File("salle.json");
                    FileReader frSalle = new FileReader(fileSalle);
                    // Creates a BufferedWriter
                    BufferedReader buffer = new BufferedReader(frSalle);
                    // Writes the string to the file
                    while ((LineSalle = buffer.readLine()) != null) {
                        Object obj = JSONValue.parse(LineSalle);
                        JSONObject jsonObject = (JSONObject) obj;

                        String nomSalle = (String) jsonObject.get("nomSalle");
                        ComboBox_salle.addItem(nomSalle);

                    }
                    // Closes the writer
                    buffer.close();
                } catch (IOException ex) {
                }

                panel_Salle.setVisible(false);
                panel_Matiere.setVisible(false);
                panel_Enseignant.setVisible(false);
                panel_class.setVisible(false);
                panel_Contart.setVisible(true);
                panelTable.setVisible(false);

            }

        });
        button_voireHoraire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

//                //code
//                File file;
//                String Linefile;
//                try {
//                    file = new File("Beirut.json");
//                    FileReader frEnseignant = new FileReader(file);
//                    // Creates a BufferedWriter
//                    BufferedReader buffer = new BufferedReader(frEnseignant);
//                    // Writes the string to the file
//                    System.out.println(buffer.readLine());
//
//                    while ((Linefile = buffer.readLine()) != null) {
//                        System.out.println(Linefile);
//                        Object obj = JSONValue.parse(Linefile);
////                        JSONObject jsonObject = (JSONObject) obj;
//
//                    }
//                    // Closes the writer
//                    buffer.close();
//                } catch (IOException ex) {
//                    //JOPtionPane close 
//                }
                panel_Salle.setVisible(false);
                panel_Matiere.setVisible(false);
                panel_Enseignant.setVisible(false);
                panel_class.setVisible(false);
                panel_Contart.setVisible(false);
                panelTable.setVisible(true);

            }

        });
        button_voireHoraireBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

//                //code
//                File file;
//                String Linefile;
//                try {
//                    file = new File("Beirut.json");
//                    FileReader frEnseignant = new FileReader(file);
//                    // Creates a BufferedWriter
//                    BufferedReader buffer = new BufferedReader(frEnseignant);
//                    // Writes the string to the file
//                    System.out.println(buffer.readLine());
//
//                    while ((Linefile = buffer.readLine()) != null) {
//                        System.out.println(Linefile);
//                        Object obj = JSONValue.parse(Linefile);
////                        JSONObject jsonObject = (JSONObject) obj;
//
//                    }
//                    // Closes the writer
//                    buffer.close();
//                } catch (IOException ex) {
//                    //JOPtionPane close 
//                }
                panel_Salle.setVisible(false);
                panel_Matiere.setVisible(false);
                panel_Enseignant.setVisible(false);
                panel_class.setVisible(false);
                panel_Contart.setVisible(false);
                panelTable.setVisible(true);

            }

        });
        //////////////////////     Horaire    //////////////////////////
        panelTable.setVisible(false);
        mbar.add(button_voireHoraireBar);
        // panelTable.setPreferredSize(new Dimension(780, 700));
        panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Horaire"));

        ComboBox_HoraireCenter = new JComboBox(center);
        ComboBox_HoraireCenter.setPreferredSize(size);

        ComboBox_HoraireSpecialite = new JComboBox();
        ComboBox_HoraireSpecialite.setPreferredSize(size);

        ComboBox_HoraireSpecialite.addItem(Specialite.Informatique);
        ComboBox_HoraireSpecialite.addItem(Specialite.Gestion);
        ComboBox_HoraireSpecialite.addItem(Specialite.Genie_civil);
        ComboBox_HoraireSpecialite.addItem(Specialite.Mecanique);

        label_sepcialite = new JLabel("Sepcialite");
        label_Center = new JLabel("Center");

        panel_top = new JPanel();
        panel_ComboBox_HoraireCenter = new JPanel(new FlowLayout());
        panel_ComboBox_HoraireSpecialite = new JPanel(new FlowLayout());

        button_voire_Horaire = new VoirHoraireButton_Command("Affiche Horaire", this);
        button_voire_Horaire.addActionListener(button);

        panel_ComboBox_HoraireCenter.add(label_Center);
        panel_ComboBox_HoraireCenter.add(ComboBox_HoraireCenter);

        panel_ComboBox_HoraireSpecialite.add(label_sepcialite);
        panel_ComboBox_HoraireSpecialite.add(ComboBox_HoraireSpecialite);
        panel_ComboBox_HoraireSpecialite.add(button_voire_Horaire);

        panel_top.add(panel_ComboBox_HoraireCenter, BorderLayout.NORTH);
        panel_top.add(panel_ComboBox_HoraireSpecialite, BorderLayout.WEST);
        //headers for the table
        String[] columns = new String[]{
            "temps \\ jour ", JourSemaine.Lundi.toString(), JourSemaine.Mardi.toString(), JourSemaine.Mercredi.toString(), JourSemaine.Jeudi.toString(), JourSemaine.Vendredi.toString(), JourSemaine.Samedi.toString()
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][]{
            {Seance.seance1, "", "", "", "", "", ""},
            {Seance.seance2, "", "", "", "", "", ""},
            {Seance.seance3, "", "", "", "", "", ""},};

        //create table with data
        TableModel model = new DefaultTableModel(data, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        table = new JTable(model) {
            public TableCellRenderer getCellRenderer(int row, int col) {

                return new MyRenderer();

            }

            public TableCellEditor getCellEditor(int row, int col) {

                return new MyEditor();

            }
        };

        table.setFont(new Font("serif", 0, 10));
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        table.setRowHeight(120);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        DefaultTableCellRenderer renderer_AlignCenter = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4, int arg5) {
                Component tableCellRendererComponent = super.getTableCellRendererComponent(arg0, arg1, arg2, arg3, arg4, arg5);
                int align = DefaultTableCellRenderer.CENTER;

                ((DefaultTableCellRenderer) tableCellRendererComponent).setHorizontalAlignment(align);
                return tableCellRendererComponent;
            }
        };
        for (int i = 0;
                i < table.getColumnModel()
                        .getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer_AlignCenter);
        }
        //add the table to the frame

        panelTable.add(
                new JScrollPane(table));
        panelTable.add(panel_top, BorderLayout.NORTH);

        panel_background.add(panelTable, BorderLayout.WEST);

        panel_WEST.add(panel_background, BorderLayout.WEST);

        panel_NORTH.add(mbar);

        frame.add(panel_NORTH, BorderLayout.NORTH);

        frame.add(panel_WEST, BorderLayout.WEST);

        frame.pack();

        frame.setLocation(
                250, 50);
        frame.setVisible(
                true);

        frame.setSize(
                800, 600);
        frame.setResizable(
                false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class MyRenderer extends JTextArea implements TableCellRenderer {

        public MyRenderer() {
            setOpaque(true);
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            this.setText(value == null ? "" : value.toString());
            return this;
        }

    }

    private class MyEditor extends AbstractCellEditor implements TableCellEditor {

        JTextArea comp = new JTextArea();
        JTable table;
        int row;

        public MyEditor() {
            comp.setLineWrap(true);
            comp.setWrapStyleWord(true);
            comp.addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    super.componentResized(e);
                    table.setRowHeight(row, (int) (comp.getPreferredSize().getHeight()));
                }
            });
            comp.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    table.setRowHeight(row, (int) (comp.getPreferredSize().getHeight()));
                }
            });
            
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            this.table = table;
            this.row = row;

            comp.setText((String) value);
            comp.setFont(table.getFont());
            
            return comp;
        }

        public Object getCellEditorValue() {
            return comp.getText();
        }
    }

    public static void main(String[] args) {
        new NFP121_Project4_2021();

    }

}
