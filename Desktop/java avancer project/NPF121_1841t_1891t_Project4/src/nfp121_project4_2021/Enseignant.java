package nfp121_project4_2021;

import java.io.Serializable;

public class Enseignant implements Serializable {

    private static int numeroSerie = 1;
    private static int noEnseignant;
    private String NomEnseignant;
    private String specialite;

    public Enseignant(String NomEnseignant, String specialite) {
        this.NomEnseignant = NomEnseignant;
        this.specialite = specialite;
        this.noEnseignant = numeroSerie++;
    }

    public static void setNumeroSerie(int numeroSerie) {
        noEnseignant = numeroSerie;
    }

    public int getNoEnseignant() {
        return noEnseignant;
    }

    public String getNomEnseignant() {
        return NomEnseignant;
    }

    public void setNomEnseignant(String NomEnseignant) {
        this.NomEnseignant = NomEnseignant;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String afficheEnseignantFromfile(String enseignantId) {
        
        return "{\"NomEnseignant\":\"'"+this.NomEnseignant+"'\",\"specialite\":\"'"+this.specialite+"'\",\"enseignantId\":"+enseignantId+"}";
    }
}
