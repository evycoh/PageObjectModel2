package helper.utils;

import helper.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataUtils {

    public static Object[][]getExcelData(String sheetName)  {
        Object[][]data;
        try {
            FileInputStream fis=new FileInputStream(FrameworkConstants.getDataPath());
            XSSFWorkbook workbook=new XSSFWorkbook(fis);
            XSSFSheet sheet=workbook.getSheet(sheetName);
            int rows=sheet.getLastRowNum();
            int cols=sheet.getRow(0).getLastCellNum();
            data=new Object[rows][cols];
            for(int i=1;i<=rows;i++){
                for(int j=0;j<cols;j++){
                    data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    @DataProvider(name = "loginData" ,parallel = true)
    public   Object[][] getLoginData(){
        Object[][] data=getExcelData("login");
        return data;
    }
    @DataProvider(name = "addTask")
    public Object[][]getAddTaskData(){
        Object[][]data=getExcelData("addTask");
        return data;
    }
    @DataProvider(name = "addTicket")
    public Object[][]getTicketData(){
        Object[][]data=getExcelData("addTicket");
        return data;
    }


}
