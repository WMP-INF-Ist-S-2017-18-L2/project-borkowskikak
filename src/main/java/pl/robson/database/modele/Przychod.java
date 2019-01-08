/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.database.modele;

/**
 *
 * @author Mati
 */

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;
@DatabaseTable(tableName = "Przychod")
public class Przychod {
    
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "Przychod", canBeNull = false)
    private int wartosc;
    
    @DatabaseField(columnName = "Data :")
    private Date Data;  

    public Przychod() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }
    
}
