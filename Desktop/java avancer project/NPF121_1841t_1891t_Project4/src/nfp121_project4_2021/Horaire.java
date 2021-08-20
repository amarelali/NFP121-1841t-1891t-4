
package nfp121_project4_2021;

public class Horaire {
  private Classe classe ;
  private jourSemain jour;
  private seance seance;

    public Horaire(Classe classe, jourSemain jour, seance seance) {
        this.classe = classe;
        this.jour = jour;
        this.seance = seance;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public jourSemain getJour() {
        return jour;
    }

    public void setJour(jourSemain jour) {
        this.jour = jour;
    }

    public seance getSeance() {
        return seance;
    }

    public void setSeance(seance seance) {
        this.seance = seance;
    }

   
    public String afficheHoraire() {
        return "Horaire{" + "classe=" + classe + ", jour=" + jour + ", seance=" + seance + '}';
    }
  
  
  
}
