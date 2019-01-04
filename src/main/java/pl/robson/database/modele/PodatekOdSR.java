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
@DatabaseTable(tableName = "PodatekOdSR")
public class PodatekOdSR {
    
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "PodatekOdSR", canBeNull = false)
    private int leasing;
    
    @DatabaseField(columnName = "Data od :")
    private Date DataOD;
    @DatabaseField(columnName = "Data do :")
    private Date DataDO;

    public PodatekOdSR() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeasing() {
        return leasing;
    }

    public void setLeasing(int leasing) {
        this.leasing = leasing;
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
