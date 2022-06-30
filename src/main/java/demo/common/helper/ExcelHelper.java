package demo.common.helper;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;


public class ExcelHelper {
    private FileInputStream fIn;
    private FileOutputStream fOut;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellStyle;
    private Color color;
    private String excelFilePath;
    private Map<String, Integer> columns = new HashMap<>();
    public void setExcelFile(String excelPath, String sheetName){
        try{
            File f = new File(excelPath);
            if(!f.exists()){
                f.createNewFile();
                System.out.println("File doesn't exist");
            }
            fIn = new FileInputStream(excelPath);
            wb = WorkbookFactory.create(fIn);
            sh = wb.getSheet(sheetName);
            if(sh == null){
                sh = wb.createSheet(sheetName);
            }
            this.excelFilePath = excelPath;

            sh.getRow(0).forEach(cell ->{
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String getCellData(int rownum, int colnum) throws Exception{
        try{
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()){
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if(DateUtil.isCellDateFormatted(cell)){
                        CellData = String.valueOf(cell.getDateCellValue());
                    }else{
                        CellData = String.valueOf((long)cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        }catch (Exception e){
            return "";
        }
    }
    public String getCellData(String columnName, int rownum) throws Exception{
        return getCellData(rownum, columns.get(columnName));
    }
}
