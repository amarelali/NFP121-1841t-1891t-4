
package nfp121_project4_2021;

import java.io.Serializable;

public class Groupe implements Serializable{
      private Classe classe;
      private Matieres matiere;

    public Groupe(Classe classe, Matieres matiere) {
        this.classe = classe;
        this.matiere = matiere;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Matieres getMatiere() {
        return matiere;
    }

    public void setMatiere(Matieres matiere) {
        this.matiere = matiere;
    }

  
    public String afficheGroup(){
        return "Groupe{" + "classe=" + classe + ", matiere=" + matiere + '}';
    }
      
      
}
