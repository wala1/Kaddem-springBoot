package tn.esprit.kaddemspringbootproject.controllers;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tn.esprit.kaddemspringbootproject.entities.Projet;

public class ScategorieExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Projet> listProjet;

    public ScategorieExcel(List<Projet> projets){
        this.listProjet = projets;
        workbook = new XSSFWorkbook();
    }
    private void writeHeaderLine(){
        sheet = workbook.createSheet("Project");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0 , "ID°", style);
        createCell(row, 1 , "Project Name", style);
        createCell(row, 2 , "Start Date", style);
        createCell(row, 3 , "Finished Date", style);
        createCell(row, 4 , "Price", style);
        createCell(row, 5 , "Slogan", style);
        createCell(row, 6 , "Methodology", style);
    }
    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        cell.setCellValue((String) value);
        cell.setCellStyle(style);
    }
    private void writeDataLines(){
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(Projet projet: listProjet){
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++,projet.getIdProjet()+"", style);
            createCell(row, columnCount++,projet.getNomProjet(), style);
            createCell(row, columnCount++,projet.getDateDebutProjet()+"", style);
            createCell(row, columnCount++,projet.getDateFinProjet()+"", style);
            createCell(row, columnCount++,projet.getPrixProjet()+"", style);
            createCell(row, columnCount++,projet.getSlogan()+"", style);
            createCell(row, columnCount++,projet.getMethodologie()+"", style);
        }
    }

    public void export(HttpServletResponse response) throws IOException{
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}