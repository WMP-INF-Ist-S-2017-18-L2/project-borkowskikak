package pl.robson.database.modele;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

@DatabaseTable(tableName = "FIRMA")
public class Firma implements BaseModel{

    public Firma() {
    }

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "FIRMA", canBeNull = false)
    private String name;
    
    @DatabaseField(columnName = "Data od :")
    private Date DataOD;
    @DatabaseField(columnName = "Data do :")
    private Date DataDO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirma() {
        return name;
    }

    public void setFirma(String name) {
        this.name = name;
    }
}
