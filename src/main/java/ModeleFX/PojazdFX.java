/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleFX;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mati
 */
public class PojazdFX {
    
    private ObjectProperty<FirmaFX> Firma = new SimpleObjectProperty<>();
    private ObjectProperty<TypPojazduFX> TypPojazdu = new SimpleObjectProperty<>();
    private ObjectProperty<PaliwoFX> PaliwoPojazdu = new SimpleObjectProperty<>();
    private IntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty numerRejestracyjny = new SimpleStringProperty();
    private ObjectProperty<UbezpieczenieFX> Ubezpieczenie = new SimpleObjectProperty<>();
    private SimpleStringProperty Leasing = new SimpleStringProperty();
    private SimpleStringProperty Amortyzacja = new SimpleStringProperty();
    private SimpleStringProperty PodatekSrodki = new SimpleStringProperty();
    
    

    public void setNumerRejestracyjny(String numerRejestracyjny) {this.numerRejestracyjny.set(numerRejestracyjny);}
    public void setAmortyzacja(String Amortyzacja) {this.Amortyzacja.set(Amortyzacja);  }
    public void setPodatekSrodki(String PodatekSrodki) {this.PodatekSrodki.set(PodatekSrodki); }
    public void setLeasing(String Leasing) {this.Leasing.set(Leasing);}
    public ObjectProperty<FirmaFX> getFirmaProperty() {return Firma; }
    public void setFirmaProperty(ObjectProperty<FirmaFX> Firma) {this.Firma = Firma;}
    public void setFirmaFX(FirmaFX Firma){this.Firma.set(Firma);}
    public void setIDFX(int id){ this.id.set(id);}
    public void setTypPojazduFX(TypPojazduFX TypPojazdu){this.TypPojazdu.set(TypPojazdu);}
    public ObjectProperty<TypPojazduFX> getTypPojazduProperty() {return TypPojazdu;}
    public void setTypPojazdu(ObjectProperty<TypPojazduFX> TypPojazdu) {this.TypPojazdu = TypPojazdu;}
    public IntegerProperty getIdProperty() {return id;}
    public void setId(IntegerProperty id) {this.id = id;}
    public SimpleStringProperty getNumerRejestracyjnyProperty() {return numerRejestracyjny;}
    public void setNumerRejestracyjny(SimpleStringProperty numerRejestracyjny) {this.numerRejestracyjny = numerRejestracyjny;}
    public SimpleStringProperty getLeasingProperty() {return Leasing;}
    public String getLeasing(){return Leasing.get();}
    public String getAmortyzacja(){return Amortyzacja.get();}
    public String getPodatekSrodki(){return PodatekSrodki.get();}
    public String getNumerRejestracyjny(){return numerRejestracyjny.get();}
    public FirmaFX getFirma(){return Firma.get();}
    public TypPojazduFX getTypPojazdu(){return TypPojazdu.get();}
    public void setLeasing(SimpleStringProperty Leasing) {this.Leasing = Leasing;}
    public SimpleStringProperty getAmortyzacjaProperty() {return Amortyzacja;}
    public void setAmortyzacja(SimpleStringProperty Amortyzacja) {this.Amortyzacja = Amortyzacja;}
    public SimpleStringProperty getPodatekSrodkiProperty() {return PodatekSrodki;}
    public void setPodatekSrodki(SimpleStringProperty PodatekSrodki) {this.PodatekSrodki = PodatekSrodki;}    
    public UbezpieczenieFX getUbezpieczenie() {return Ubezpieczenie.get();}
    public ObjectProperty<UbezpieczenieFX> ubezpieczenieProperty() {return Ubezpieczenie;}
    public void setUbezpieczenie(UbezpieczenieFX ubezpieczenie) {this.Ubezpieczenie.set(ubezpieczenie);}    
    public PaliwoFX getPaliwoPojazdu() {return PaliwoPojazdu.get();}
    public ObjectProperty<PaliwoFX> paliwoPojazduProperty() {return PaliwoPojazdu;}
    public void setPaliwoPojazdu(PaliwoFX paliwoPojazdu) {this.PaliwoPojazdu.set(paliwoPojazdu);}

    @Override
    public String toString() { return PaliwoPojazdu.getValue().toString();}
    
    
    
}
