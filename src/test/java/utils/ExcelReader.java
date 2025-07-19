package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    public String locatorColumnValue;
    public static String locatorName;
    public static String locatorValue;
    public static String keywordColumnValue;
    public static String dataColumnValue;
    public static int totalRows;


    public void readExcelFile(String location) throws IOException {
        fis = new FileInputStream(location);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Sheet1");
        totalRows = sheet.getLastRowNum();
    }


    public void getAllValuesFromExcelSheet(int row, int locatorColumn, int keywordColumn, int dataColumn) {
        try {
            // Read locator column value
            locatorColumnValue = sheet.getRow(row).getCell(locatorColumn) != null ?
                    sheet.getRow(row).getCell(locatorColumn).toString().trim() : "";


            if (locatorColumnValue != null && locatorColumnValue.contains("=")) {
                String[] parts = locatorColumnValue.split("=");
                if (parts.length == 2) {
                    locatorName = parts[0].trim();
                    locatorValue = parts[1].trim();
                } else {
                    locatorName = "NA";
                    locatorValue = "NA";
                }
            } else {
                locatorName = "NA";
                locatorValue = "NA";
            }

            // Read keyword column safely
            keywordColumnValue = sheet.getRow(row).getCell(keywordColumn) != null ?
                    sheet.getRow(row).getCell(keywordColumn).toString().trim() : "NA";

            // Read data column safely
            dataColumnValue = sheet.getRow(row).getCell(dataColumn) != null ?
                    sheet.getRow(row).getCell(dataColumn).toString().trim() : "NA";


        } catch (Exception e) {
            System.out.println("Error reading row " + row + ": " + e.getMessage());
            locatorName = "NA";
            locatorValue = "NA";
            keywordColumnValue = "NA";
            dataColumnValue = "NA";
        }
    }


}
