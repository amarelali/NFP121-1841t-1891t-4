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
public class CenterFactoryDemo {
    public static String getCenterDemo(String center) {
    	CenterFactory centerFactory = new CenterFactory();
        CenterInterface_Factory ci = centerFactory.getCenter(center);
      	CenterInterface_Factory center1 = ci; 
        return center1.studentCenter(); 
   	
    }
}
