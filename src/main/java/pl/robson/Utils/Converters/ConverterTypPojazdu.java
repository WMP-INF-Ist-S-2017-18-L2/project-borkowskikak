/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Utils.Converters;

import ModeleFX.TypPojazduFX;
import pl.robson.database.modele.TypPojazdu;

/**
 *
 * @author Mati
 */
public class ConverterTypPojazdu {
    public static TypPojazdu convertToTypPojazdu(TypPojazduFX typPojazduFX){
    TypPojazdu typPojazdu = new TypPojazdu();
    typPojazdu.setId(typPojazduFX.getId());
    typPojazdu.setTypPojazdu(typPojazduFX.getName());
     return typPojazdu;    
    }
    
    
    
    public static TypPojazduFX convertToTypPojazduFX(TypPojazdu typPojazdu){
       TypPojazduFX typPojazduFX = new TypPojazduFX();
       typPojazduFX.setId(typPojazdu.getId());
       typPojazduFX.setName(typPojazdu.getTypPojazdu());
         return typPojazduFX;    
    }
}
