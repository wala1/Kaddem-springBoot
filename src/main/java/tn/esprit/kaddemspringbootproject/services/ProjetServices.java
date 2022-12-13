package tn.esprit.kaddemspringbootproject.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Projet;
import tn.esprit.kaddemspringbootproject.entities.Tache;
import tn.esprit.kaddemspringbootproject.repositories.IProjetRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service("ProjetServices")
@RequiredArgsConstructor
public class ProjetServices implements IProjetServices{
    private final IProjetRepository projetRepository;
    @Override
    public List<Projet> retrieveAllProjects() {
        return projetRepository.retrieveAllProjet();
    }
    @Override
    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }
    @Override
    public Projet updateProjet(Projet projet,Integer idProjet) {
        return projetRepository.save(projet);
    }
    @Override
    public void removeProjet(Integer idProjet) {
        projetRepository.deleteById(idProjet);
    }
    @Override
    public Projet retrieveProjet(Integer idProjet) {
        return projetRepository.findByIdProjet(idProjet);
    }

    @Override
    public void removeAllProjet() {
        projetRepository.deleteAll();
    }
    @Override
    public ByteArrayInputStream projetsPDEFReport(List<Projet> projets){
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document,out);
            document.open();

            //add text to pdf file
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph("Projects List", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(3);

            //make column
            Stream.of("Name", "Description","Slogan").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorder(1);
                header.setPhrase(new Phrase(headerTitle,headFont));
                table.addCell(header);
            });
            for (Projet projet: projets){
                PdfPCell titleCell = new PdfPCell(new Phrase(projet.getNomProjet()));
                titleCell.setPadding(1);
                titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell);

                PdfPCell desCell = new PdfPCell(new Phrase(projet.getDescriptionProjet()));
                desCell.setPadding(1);
                desCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                desCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(desCell);

                PdfPCell sloganCell = new PdfPCell(new Phrase(projet.getSlogan()));
                sloganCell.setPadding(1);
                sloganCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                sloganCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(sloganCell);
            }
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream((out.toByteArray()));
    }


    @Override
    public ByteArrayInputStream projetsExcelFReport(List<Projet> projets) throws IOException {
        String[] columns = {"Title","Description"};
        try(Workbook workbook = new XSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();){
            CreationHelper creationHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.getSheet("Products");
            sheet.autoSizeColumn(columns.length);

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(headerFont);

            //Row for header
            Row headerRow = sheet.createRow(0);

            //Header
            for(int col=0;col <columns.length; col++){
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(cellStyle);
            }
            CellStyle cellStyle1 = workbook.createCellStyle();
            cellStyle1.setDataFormat(creationHelper.createDataFormat().getFormat("#"));
            int rowIndex = 1;
            for(Projet projet:projets){
                Row row = sheet.createRow(rowIndex++);

                row.createCell(0).setCellValue(projet.getNomProjet());
                row.createCell(1).setCellValue(projet.getDescriptionProjet());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }


}
