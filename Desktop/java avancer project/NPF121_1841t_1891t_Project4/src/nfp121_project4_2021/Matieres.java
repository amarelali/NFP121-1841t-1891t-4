package nfp121_project4_2021;

import java.io.*;

public class Matieres implements Serializable{

    private static int numeroSerie = 1;
    private static int noMatiere;
    private String codeMatiere;
    private String compus;

    public Matieres(String codeMatiere, String compus) {
        this.noMatiere = numeroSerie++;
        this.codeMatiere = codeMatiere;
        this.compus = compus;

    }
    public static void setNumeroSerie(int numeroSerie) {
        noMatiere = numeroSerie;
    }

    public int getNoMatiere() {
        return noMatiere;
    }

    public void setNoMatiere(int noMatiere) {
        this.noMatiere = noMatiere;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public String getCompus() {
        return compus;
    }

    public void setCompus(String compus) {
        this.compus = compus;
    }

    public String afficheMatiere() {
        return "Matieres{" + "noMatiere=" + noMatiere + ", codeMatiere=" + codeMatiere + ", compus=" + compus + '}';
    }

}
