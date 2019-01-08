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
@DatabaseTable(tableName = "Ubezpieczenie")
public class Ubezpieczenie implements BaseModel {
    
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "Ubezpieczenie", canBeNull = false)
    private double name;
    
    @DatabaseField(columnName = "Data od :")
    private Date DataOD;
    @DatabaseField(columnName = "Data do :")
    private Date DataDO;

    public Ubezpieczenie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getName() {
        return name;
    }

    public void setName(double name) {
        this.name = name;
    }

    public Date getDataOD() {
        return DataOD;
    }

    public void setDataOD(Date DataOD) {
        this.DataOD = DataOD;
    }

    public Date getDataDO() {
        return DataDO;
    }

    public void setDataDO(Date DataDO) {
        this.DataDO = DataDO;
    }
    
}