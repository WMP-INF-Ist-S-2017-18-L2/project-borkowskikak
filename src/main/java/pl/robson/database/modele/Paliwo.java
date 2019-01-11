package pl.robson.database.modele;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

@DatabaseTable(tableName = "PALIWO")
public class Paliwo implements BaseModel{

    public Paliwo() {
    }

    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(columnName = "Data dodania : ", canBeNull = true)
    private Date dataDodaniaPaliwa;

    @DatabaseField(columnName = "PALIWO[L]", canBeNull = true)
    private double iloscPaliwa;
    
    @DatabaseField(columnName = "Cena za litr", canBeNull = true)
    private double cenazaLitr;

    @DatabaseField(columnName = "Przebieg",canBeNull = true)
    private double przebieg;

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public double getIloscPaliwa() {
        return iloscPaliwa;
    }

    public void setIloscPaliwa(double iloscPaliwa) {
        this.iloscPaliwa = iloscPaliwa;
    }

    public double getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(double przebieg) {
        this.przebieg = przebieg;
    }


    public Date getDataDodaniaPaliwa() {
        return dataDodaniaPaliwa;
    }

    public void setDataDodaniaPaliwa(Date dataDodaniaPaliwa) {
        this.dataDodaniaPaliwa = dataDodaniaPaliwa;
    }

    public double getCenazaLitr() {
        return cenazaLitr;
    }

    public void setCenazaLitr(double cenazaLitr) {
        this.cenazaLitr = cenazaLitr;
    }
    
    

   
}



