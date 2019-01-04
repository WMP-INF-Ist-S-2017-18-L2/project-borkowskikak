/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.database.modele;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/**
 *
 * @author Mati
 */
@DatabaseTable(tableName="Paliwo Inne List View")
public class paliwoInne implements BaseModel{
    
    
    @DatabaseField(columnName="ID",generatedId = true)
    private int id;
    
    @DatabaseField(columnName = "Data")
    private Date releaseDate;
    
    @DatabaseField(columnName = "Pobieraj�cy", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private PobierajacyInne pobierajacy;
    
    @DatabaseField(columnName = "Ilo�� litr�w")
    private String iloscLitrowPaliwoInne ;
    
    @DatabaseField(columnName = "Cena netto")
    private String cenaNettoPaliwoInne ;

    public paliwoInne() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getIloscLitrowPaliwoInne() {
        return iloscLitrowPaliwoInne;
    }

    public void setIloscLitrowPaliwoInne(String iloscLitrowPaliwoInne) {
        this.iloscLitrowPaliwoInne = iloscLitrowPaliwoInne;
    }

    public String getCenaNettoPaliwoInne() {
        return cenaNettoPaliwoInne;
    }

    public void setCenaNettoPaliwoInne(String cenaNettoPaliwoInne) {
        this.cenaNettoPaliwoInne = cenaNettoPaliwoInne;
    }
    public PobierajacyInne getPobierajacy() {
        return pobierajacy;
    }

    public void setPobierajacy(PobierajacyInne pobierajacy) {
        this.pobierajacy = pobierajacy;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    
}
