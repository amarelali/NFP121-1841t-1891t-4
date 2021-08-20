/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_project4_2021;

/**
 *
 * @author DELL LATITUDE
 */
public class CenterFactory {
    public CenterInterface_Factory getCenter(String center){
      if(center == null) return null;
      if(center.equalsIgnoreCase("Beirut")) return new BeirutCenter_Factory();
      if(center.equalsIgnoreCase("Baalbak")) return new BaalbakCenter_Factory();
      if(center.equalsIgnoreCase("Tripoli")) return new TripoliCenter_Factory();
      if(center.equalsIgnoreCase("Naher Ibrahim")) return new NaherIbrahimCenter_Factory();
      return null;
   }
}
