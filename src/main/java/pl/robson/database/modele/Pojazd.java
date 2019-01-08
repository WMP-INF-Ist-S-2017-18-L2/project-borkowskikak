package pl.robson.database.modele;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "POJAZD")
public class Pojazd implements BaseModel{

   
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "REJESTRACJA" , canBeNull = true)
    private String numerRejestracyjny;

    @DatabaseField(columnName = "TYP POJAZDU", canBeNull = true,foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private TypPojazdu typPojazdu;

    @DatabaseField(columnName = "FIRMA",canBeNull = true,foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Firma firma;

    @DatabaseField(columnName = "PALIWO[L}", canBeNull = true)
    private String iloscPaliwa;

    @DatabaseField(columnName = "PRZEBIEG",canBeNull = true)
    private String przebieg;

    @DatabaseField(columnName = "ZUZYCIE PALIWA", canBeNull = true)
    private String zuzyciePaliwa;

    @DatabaseField(columnName = "UBEZPIECZENIE",canBeNull = true,foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Ubezpieczenie ubezpieczenie;

    @DatabaseField(columnName = "LEASING", canBeNull = true)
    private String leasing;

    @DatabaseField(columnName = "ZUS", canBeNull = true)
    private String zus;

    @DatabaseField(columnName = "PDDOF", canBeNull = true)
    private String pddof;

    @DatabaseField(columnName = "AMORTYZACJA", canBeNull = true)
    private String amortyzacja;

    @DatabaseField(columnName = "OPLATY DROGOWE", canBeNull = true)
    private String oplatyDrogowe;

    @DatabaseField(columnName = "PODATEK OD SR", canBeNull = true)
    private String podatek;

    @DatabaseField(columnName = "WYPLATA", canBeNull = true)
    private String wyplata;

    @DatabaseField(columnName = "PRZYCHOD", canBeNull = true)
    private String przychod;
    
    public Pojazd() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public TypPojazdu getTypPojazdu() {
        return typPojazdu;
    }

    public void setTypPojazdu(TypPojazdu typPojazdu) {
        this.typPojazdu = typPojazdu;
    }

    

    public String getIloscPaliwa() {
        return iloscPaliwa;
    }

    public void setIloscPaliwa(String iloscPaliwa) {
        this.iloscPaliwa = iloscPaliwa;
    }

    public String getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(String przebieg) {
        this.przebieg = przebieg;
    }

    public String getZuzyciePaliwa() {
        return zuzyciePaliwa;
    }

    public void setZuzyciePaliwa(String zuzyciePaliwa) {
        this.zuzyciePaliwa = zuzyciePaliwa;
    }

    public Ubezpieczenie getUbezpieczenie() {
        return ubezpieczenie;
    }

    public void setUbezpieczenie(Ubezpieczenie ubezpieczenie) {
        this.ubezpieczenie = ubezpieczenie;
    }

    public String getLeasing() {
        return leasing;
    }

    public void setLeasing(String leasing) {
        this.leasing = leasing;
    }

    public String getZus() {
        return zus;
    }

    public void setZus(String zus) {
        this.zus = zus;
    }

    public String getPddof() {
        return pddof;
    }

    public void setPddof(String pddof) {
        this.pddof = pddof;
    }

    public String getAmortyzacja() {
        return amortyzacja;
    }

    public void setAmortyzacja(String amortyzacja) {
        this.amortyzacja = amortyzacja;
    }

    public String getOplatyDrogowe() {
        return oplatyDrogowe;
    }

    public void setOplatyDrogowe(String oplatyDrogowe) {
        this.oplatyDrogowe = oplatyDrogowe;
    }

    public String getPodatek() {
        return podatek;
    }

    public void setPodatek(String podatek) {
        this.podatek = podatek;
    }

    public String getWyplata() {
        return wyplata;
    }

    public void setWyplata(String wyplata) {
        this.wyplata = wyplata;
    }

    public String getPrzychod() {
        return przychod;
    }

    public void setPrzychod(String przychod) {
        this.przychod = przychod;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;

    
   }

    public Firma getFirma() {
        return firma;
    }
    
    
}
