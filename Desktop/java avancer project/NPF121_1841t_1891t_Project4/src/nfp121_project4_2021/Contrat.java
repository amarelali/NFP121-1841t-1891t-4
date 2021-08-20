
package nfp121_project4_2021;

import java.io.Serializable;


public class Contrat implements Serializable{
   private Enseignant enseignant;
   private Matieres matiere;

    public Contrat(Enseignant enseignant, Matieres matiere) {
        this.enseignant = enseignant;
        this.matiere = matiere;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Matieres getMatiere() {
        return matiere;
    }

    public void setMatiere(Matieres matiere) {
        this.matiere = matiere;
    }

    
    public String afficheContrat() {
        return "Contrat{" + "enseignant=" + enseignant + ", matiere=" + matiere + '}';
    }
   
   
}
