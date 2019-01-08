/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Utils.Converters;

import ModeleFX.UbezpieczenieFX;
import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import pl.robson.Utils.Utils;
import pl.robson.database.modele.Ubezpieczenie;

/**
 *
 * @author Mati
 */
public class ConverterUbezpieczenie {
    public static UbezpieczenieFX convertToubezpieczenieFX(Ubezpieczenie ubezpieczenie){
        UbezpieczenieFX ubezpieczenieFX = new UbezpieczenieFX();
        ubezpieczenieFX.setId(ubezpieczenie.getId());
        ubezpieczenieFX.setUbezpieczenie(ubezpieczenie.getName());
        ubezpieczenieFX.setOdDate(LocalDate.MIN);
        ubezpieczenieFX.setDoDate(LocalDate.MAX);     
        return ubezpieczenieFX;   
    }

  public static Ubezpieczenie convertToubezpieczenie(UbezpieczenieFX ubezpieczenieFX){
      Ubezpieczenie ubezpieczenie = new Ubezpieczenie();
      ubezpieczenie.setId(ubezpieczenieFX.getId());
      ubezpieczenie.setName(ubezpieczenieFX.getUbezpieczenie());
      ubezpieczenie.setDataOD(Utils.convertToDate(ubezpieczenieFX.getOdDate()));
      ubezpieczenie.setDataDO(Utils.convertToDate(ubezpieczenieFX.getDoDate()));
      return ubezpieczenie;
  }
}
