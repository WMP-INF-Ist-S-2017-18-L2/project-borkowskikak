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
@DatabaseTable(tableName = "Zus")
public class Zus {
    
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "Zus", canBeNull = false)
    private int name;
    
    @DatabaseField(columnName = "Data :")
    private Date Data;

    public Zus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    
}
