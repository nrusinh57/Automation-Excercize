package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility
{
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    String path;

    public ExcelUtility(String path)
    {
        this.path = path;
    }

    // ================================
    // GET ROW COUNT
    // ================================
    public int getRowCount(String sheetName) throws IOException
    {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        int rowcount = sheet.getLastRowNum();

        workbook.close();
        fi.close();
        return rowcount;
    }

    // ================================
    // GET CELL COUNT
    // ================================
    public int getCellCount(String sheetName, int rownum) throws IOException
    {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rownum);
        int cellcount = row.getLastCellNum();

        workbook.close();
        fi.close();
        return cellcount;
    }

    // ================================
    // GET CELL DATA (SAFE VERSION)
    // ================================
    public String getCellData(String sheetName, int rownum, int colnum) throws IOException
    {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rownum);
        if(row == null) {
            workbook.close();
            fi.close();
            return "";
        }

        cell = row.getCell(colnum);
        if(cell == null) {
            workbook.close();
            fi.close();
            return "";
        }

        // Safe formatter — prevents NULL values
        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);

        workbook.close();
        fi.close();
        return data.trim();
    }
}
