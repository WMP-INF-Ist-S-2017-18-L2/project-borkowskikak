/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emek.pdfgenerator;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Emek
 */
public class Pdf {

    private final String LOKALIZACJAINAZWA;
    private final String LOGOROBSON = "src/main/resources/obrazy/logoRobson.jpg";
    private final String LOGOMAKROSAN = "src/main/resources/obrazy/logoMakrosan.png";
    private Document document;
    private PdfDocument pdf;
    private final char firma;
    private final List<String> listaPojazdow;
    private final LocalDate dataStartowa, dataKoncowa;
    int wysokoscDokumentu, szerokoscDokumentu, rozmiarListyPojazdow;
    PageSize ps;
    private final Table table;
    private Cell cell;
    private final String grupaPojazdow;
    private final int szerokoscKolumny = 150;
    
        public static final String FONT
            = "src/main/resources/font/Amble-Regular.ttf";
        PdfFont f = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);

    public Pdf(String LOKALIZACJAINAZWA, char firma, List<String> listaPojazdow, LocalDate dataStartowa, LocalDate dataKoncowa, String grupaPojazdow) throws FileNotFoundException, MalformedURLException, IOException {
        this.LOKALIZACJAINAZWA = LOKALIZACJAINAZWA;
        this.firma = firma;
        this.listaPojazdow = listaPojazdow;
        this.dataStartowa = dataStartowa;
        this.dataKoncowa = dataKoncowa;
        this.grupaPojazdow = grupaPojazdow;
        this.rozmiarListyPojazdow = listaPojazdow.size();
        this.table = new Table(2+rozmiarListyPojazdow);
        this.szerokoscDokumentu = liczSzerokosc(rozmiarListyPojazdow);
        this.wysokoscDokumentu = liczWysokosc(20); //---------------------
        this.ps = new PageSize(new Rectangle(szerokoscDokumentu, wysokoscDokumentu));
        this.generujPdf();
    }

    public void generujPdf() throws FileNotFoundException, MalformedURLException, IOException {
        File file = new File(LOKALIZACJAINAZWA);
        file.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(LOKALIZACJAINAZWA);
        PdfWriter writer = new PdfWriter(fos);

        pdf = new PdfDocument(writer);

        document = new Document(pdf, ps);
        //
        
        document.setFont(f);
        
        //
        this.dodajZnakWodny();
        this.dodajPoczatekTabeli();
        this.dodajWiersze();
        document.add(table);
        document.close();

    }

    private int liczSzerokosc(int ileKolumn) {
        int szerokosc = 0;
        szerokosc = 300 + (ileKolumn * szerokoscKolumny) + 200;
        return szerokosc;
    }

    private int liczWysokosc(int ileWierszy) {

        return 22*ileWierszy;
    }

    public void dodajZnakWodny() throws MalformedURLException {
        PdfCanvas canvas = new PdfCanvas(pdf.addNewPage());
        ImageData image = null;

        boolean mamyZnakWodny = false;
        if (firma == 'r') {
            image = ImageDataFactory.create(LOGOROBSON);
            mamyZnakWodny = true;
        } else if (firma == 'm') {
            image = ImageDataFactory.create(LOGOMAKROSAN);
            mamyZnakWodny = true;
        }
        if (mamyZnakWodny == true) {
            canvas.saveState();
            PdfExtGState state = new PdfExtGState();
            state.setFillOpacity(0.5f);
            canvas.setExtGState(state);
            PageSize pageSize = new PageSize(ps);
            canvas.addImage(image, (pageSize.getWidth() - image.getWidth()) / 2, (pageSize.getHeight() - image.getHeight()) / 2, true);
            canvas.restoreState();
        }
    }

    public void dodajPoczatekTabeli() {

        String zeroprzedstart, zeroprzedkoniec;

        if ((dataStartowa.getMonthValue()) < 10) {
            zeroprzedstart = "0";
        } else {
            zeroprzedstart = "";
        }
        if ((dataStartowa.getMonthValue()) < 10) {
            zeroprzedkoniec = "0";
        } else {
            zeroprzedkoniec = "";
        }
        cell = new Cell(2, 1).add(new Paragraph("od: " + dataStartowa.getDayOfMonth()+ "." + zeroprzedstart + (dataStartowa.getMonthValue()) + "." + (dataStartowa.getYear()) + "r"
                + "\ndo: " + (dataKoncowa.getDayOfMonth())+ "." + zeroprzedkoniec + (dataKoncowa.getMonthValue()) + "." + (dataKoncowa.getYear()) + "r"));
        cell.setWidth(180);
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setPaddingTop(10);
        table.addCell(cell);

        cell = new Cell(1, rozmiarListyPojazdow+2).add(new Paragraph(grupaPojazdow));
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setBold();
        cell.setFontSize(18);
        table.addCell(cell);
        
        //lista nr rejestracyjnych
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph(listaPojazdow.get(i)));
            cell.setBackgroundColor(WebColors.getRGBColor("#C0C0C0"), 0.6f);
            cell.setWidth(szerokoscKolumny);
            cell.setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);
        }
        cell = new Cell().add(new Paragraph("Suma"));
        cell.setBackgroundColor(WebColors.getRGBColor("#C0C0C0"), 0.6f);
        cell.setWidth(200);
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        //koniec

    }
    
    
    private void dodajWiersze(){
        //paliwo
        int sumaPaliwa = 0;
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
       
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
     
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
    
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
     
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
     
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
     
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
      
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
    
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
    
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo
 
        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyklad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);
        
                //paliwo

        cell = new Cell().add(new Paragraph("Paliwo"));
        table.addCell(cell);
        for (int i = 0; i < rozmiarListyPojazdow; i++) {
            cell = new Cell().add(new Paragraph("przyk³ad" + listaPojazdow.get(i)));
            table.addCell(cell);
            sumaPaliwa += i;
        }
        cell = new Cell().add(new Paragraph("Suma" + sumaPaliwa));
        table.addCell(cell);


    
        
    
    
    
    }

}