/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Utils.Converters;

import ModeleFX.pobierajacyInneFX;
import pl.robson.database.modele.PobierajacyInne;

/**
 *
 * @author Mati
 */
public class ConverterPobierajacyInne {
    public static pobierajacyInneFX convertToPobierajacyFx(PobierajacyInne pobierajacyInne){
        pobierajacyInneFX pobierajacyInneFX1 = new pobierajacyInneFX();
        pobierajacyInneFX1.setId(pobierajacyInne.getId());
        pobierajacyInneFX1.setName(pobierajacyInne.getName());
        return pobierajacyInneFX1;
    }
}
