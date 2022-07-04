package demo.common.helper;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
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
                System.out.println("File doesn't exist. Then created " + excelPath);
            }
            fIn = new FileInputStream(excelPath);
            wb = WorkbookFactory.create(fIn);
            sh = wb.getSheet(sheetName);
            if(sh == null){
                sh = wb.createSheet(sheetName);
               // System.out.println("File doesn't exist. Then created " + excelPath);
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
            String cellData = null;
            switch (cell.getCellType()){
                case STRING:
                    cellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if(DateUtil.isCellDateFormatted(cell)){
                        cellData = String.valueOf(cell.getDateCellValue());
                    }else{
                        cellData = String.valueOf((long)cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    cellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    cellData = "";
                    break;
            }
            return cellData;
        }catch (Exception e){
            return "";
        }
    }
    public String getCellData(String columnName, int rownum) throws Exception{
        return getCellData(rownum, columns.get(columnName));
    }
    public void setCellData(String text, int rownum, int colnum) throws Exception{
        try{
            row = sh.getRow(rownum);
            if(row == null){
                row = sh.createRow(rownum);
            }
            cell = row.getCell(colnum);
            if(cell == null){
                cell = row.createCell(colnum);
            }
            cell.setCellValue(text);
            fOut = new FileOutputStream(excelFilePath);
            wb.write(fOut);
            fOut.flush();
            fOut.close();
        }
        catch(Exception e){
            throw (e);
        }
    }

}
