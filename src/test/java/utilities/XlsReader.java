package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XlsReader {
	
	private Workbook workbook;

	public XlsReader(String filePath){
        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		
    }
    
		
	public Map<String, String> getPythonCodeAndOutput(String sheetName, String testName) {
        Map<String, String> result = new HashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            System.out.println("Sheet not found.");
            return result;
        }

        // Get header row
        Row headerRow = sheet.getRow(0);
        int testNameCol = -1, pythonCodeCol = -1, outputCol = -1;

        // Map column headers to indices
        for (Cell cell : headerRow) {
            String header = cell.getStringCellValue().trim();
            if (header.equalsIgnoreCase("TestName")) testNameCol = cell.getColumnIndex();
            if (header.equalsIgnoreCase("pythonCode")) pythonCodeCol = cell.getColumnIndex();
            if (header.equalsIgnoreCase("output")) outputCol = cell.getColumnIndex();
        }

        // Validate column indices
        if (testNameCol == -1 || pythonCodeCol == -1 || outputCol == -1) {
            System.out.println("One or more required columns are missing.");
            return result;
        }

        // Search for the row with matching testName
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // skip header

            Cell testNameCell = row.getCell(testNameCol);
            if (testNameCell != null && testNameCell.getStringCellValue().trim().equalsIgnoreCase(testName)) {
                result.put("pythonCode", getCellValue(row.getCell(pythonCodeCol)));
                result.put("output", getCellValue(row.getCell(outputCol)));
                return result;
            }
        }

        System.out.println("TestName not found.");
        return result;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA: return cell.getCellFormula();
            default: return "";
        }
    }

    public void close() {
        try {
            if (workbook != null) workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
