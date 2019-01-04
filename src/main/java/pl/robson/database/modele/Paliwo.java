package pl.robson.database.modele;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PALIWO")
public class Paliwo implements BaseModel{

    public Paliwo() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "PALIWO[L]", canBeNull = false)
    private int iloscPaliwa;

    @DatabaseField(columnName = "Przebieg",canBeNull = false)
    private int przebieg;

    @DatabaseField(columnName = "Zuzycie paliwa", canBeNull = false)
    private int zuzyciePaliwa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIloscPaliwa() {
        return iloscPaliwa;
    }

    public void setIloscPaliwa(int iloscPaliwa) {
        this.iloscPaliwa = iloscPaliwa;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public int getZuzyciePaliwa() {
        return zuzyciePaliwa;
    }

    public void setZuzyciePaliwa(int zuzyciePaliwa) {
        this.zuzyciePaliwa = zuzyciePaliwa;
    }

   
}



