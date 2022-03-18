package utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    XSSFWorkbook excelWBook;
    XSSFSheet excelWSheet;
    XSSFCell cell;


    public List<String> getEntireColumnData(String path,String sheet, int colNum) throws IOException {
        List<String> columnData = new ArrayList<>();
            FileInputStream excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheet);

        int i = 0;
        while ((excelWSheet.getRow(i)).getCell(colNum).getStringCellValue() !=null){
            columnData.add(excelWSheet.getRow(i).getCell(colNum).getStringCellValue());
            i++;
        }

            cell = excelWSheet.getRow(i).getCell(colNum);
            String cellValue = cell.getStringCellValue();


            excelFile.close();
            return columnData;

    }

    public static void main(String[] args) throws IOException {
        DataReader dataReader = new DataReader();
        System.out.println(dataReader.getEntireColumnData("/Users/farid/eclipse-workspace/SecondAfterSchool/Amazon/src/data/Book1.xlsx","sheet1",1));
    }
}
