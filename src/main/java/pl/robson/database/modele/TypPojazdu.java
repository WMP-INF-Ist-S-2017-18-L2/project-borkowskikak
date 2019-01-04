package pl.robson.database.modele;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "TYP POJAZDU")
public class TypPojazdu implements BaseModel{

    public TypPojazdu() {
    }

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "TYP POJAZDU", canBeNull = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypPojazdu() {
        return name;
    }

    public void setTypPojazdu(String name) {
        this.name = name;
    }
}
