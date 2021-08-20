/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

import java.io.Serializable;

/**
 *
 * @author DELL LATITUDE
 */
public class Classe implements Serializable {

    private static int numeroSerie = 1;
    private static int noClass;
    private String codeClass;
    private String compte;

    public Classe(String codeClass, String compte) {
        this.noClass = numeroSerie++;
        this.codeClass = codeClass;
        this.compte = compte;
    }

    public static void setNumeroSerie(int numeroSerie) {
        noClass = numeroSerie;
    }

    public int getNoClass() {
        return noClass;
    }

    public String getCodeClass() {
        return codeClass;
    }

    public String afficheClasse() {
        return "Classe{" + "noClass=" + noClass + ", codeClass=" + codeClass + ", compte=" + compte + '}';
    }
}
