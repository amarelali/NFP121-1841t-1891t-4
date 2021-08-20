package nfp121_project4_2021;

import java.io.Serializable;

public class Salle implements Serializable {

    private static int numeroSerie = 1;
    private static int noSalle;
    private String nomSalle;
    private String compus;
    private int capacite;

    public Salle(String nomSalle, String compus, int capacite) {
        this.nomSalle = nomSalle;
        this.compus = compus;
        this.capacite = capacite;
        noSalle = numeroSerie++;
    }

    public static void setNumeroSerie(int numeroSerie) {
        noSalle = numeroSerie;
    }

    public String afficherSalle() {
        return "Salle{" + "noSalle=" + noSalle + ", nomSalle=" + nomSalle + ", compus=" + compus + ", capacite=" + capacite + '}';
    }

    public int getNoSalle() {
        return noSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getCompus() {
        return compus;
    }

    public void setCompus(String compus) {
        this.compus = compus;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

}
