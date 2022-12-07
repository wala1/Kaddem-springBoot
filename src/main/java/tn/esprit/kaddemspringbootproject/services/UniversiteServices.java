package tn.esprit.kaddemspringbootproject.services;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Departement;
import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.entities.categorieUniv;
import tn.esprit.kaddemspringbootproject.repositories.IDepartementsRepository;
import tn.esprit.kaddemspringbootproject.repositories.IUniversiteRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UniversiteServices implements IUniversiteServices{
    private final IUniversiteRepository ur;
    private final IDepartementsRepository departementsRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return ur.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return ur.findById(idUniversite).orElse(null);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite univ=retrieveUniversite(idUniversite);
        Departement department=departementsRepository.findById(idDepartement).orElse(null);
        univ.getDepartements().add(department);
        /*Set<Departements> departements =new HashSet<>();
        departements.add(department);
        univ.setDepartements(departements);*/
        ur.save(univ);
    }

    @Override
    public void removeUniv(Integer idUniv) {
        ur.deleteById(idUniv);
    }

    @Override
    public List<Universite> findUnivByCategorie(categorieUniv cat) {
        return ur.findByCategorieUniv(cat);
    }

    @Override
    public ByteArrayInputStream univesritiesPDF(List<Universite> univ) {
        Document document=new Document();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            //add text to pdf
            com.itextpdf.text.Font font= FontFactory.getFont(FontFactory.COURIER,14, BaseColor.BLACK);
            Paragraph para=new Paragraph("Universities List",font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);
            PdfPTable table=new PdfPTable(7);
            //make colum titles
            Stream.of("Image","Name","Email","Number","Adress","URL","Categorie").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                 com.itextpdf.text.Font headerFont= FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                 header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                 header.setHorizontalAlignment(Element.ALIGN_CENTER);
                 header.setPhrase(new Phrase(headerTitle,headerFont));
                 table.addCell(header);
            });
            for(Universite u:univ){
                PdfPCell imageCell = new PdfPCell(new Phrase(u.getLogoUniv()));
                imageCell.setPaddingLeft(1);
                imageCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                imageCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(imageCell);
                PdfPCell titleCell = new PdfPCell(new Phrase(u.getNomUniv()));
                titleCell.setPaddingLeft(1);
                titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell);
                PdfPCell EmailCell = new PdfPCell(new Phrase(u.getEmailUniv()));
                EmailCell.setPaddingLeft(1);
                EmailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                EmailCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(EmailCell);
                PdfPCell numCell = new PdfPCell(new Phrase(u.getNumUniv()));
                numCell.setPaddingLeft(1);
                numCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                numCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(numCell);
                PdfPCell addressCell = new PdfPCell(new Phrase(u.getAdresseUniv()));
                addressCell.setPaddingLeft(1);
                addressCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                addressCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(addressCell);

            }
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

}
