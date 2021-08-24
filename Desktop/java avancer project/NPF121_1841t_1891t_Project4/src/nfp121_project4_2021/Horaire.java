
package nfp121_project4_2021;

public class Horaire {
  private Classe classe ;
  private JourSemaine jour;
  private Seance seance;

    public Horaire(Classe classe, JourSemaine jour, Seance seance) {
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

    public JourSemaine getJour() {
        return jour;
    }

    public void setJour(JourSemaine jour) {
        this.jour = jour;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

   
    public String afficheHoraire() {
        return "Horaire{" + "classe=" + classe + ", jour=" + jour + ", seance=" + seance + '}';
    }
  
  
  
}
