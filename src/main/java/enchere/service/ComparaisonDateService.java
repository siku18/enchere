/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ok
 */
public class ComparaisonDateService {

    Date d1 = new GregorianCalendar(2011,9,11,03, 30).getTime();
    Date aujourdhui = new Date();
 
    // Obtenir la difference en milliseconde
    long diff = aujourdhui.getTime() - d1.getTime();
    public void difference(){
    System.out.println("La difference entre les 2 dates: "+ (diff / (1000 * 60 * 60 * 24)));
  }
}
