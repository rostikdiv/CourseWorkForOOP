package com.CourseWork.CourseWorkForOOP;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;

public class WorkWithExel {
    static String nameOfWorkBookToArrivedTruck="";
    static String nameOfSheetToArrivedTruck="";
    static String nameOfWorkBookToSentTruck="";
    static String nameOfSheetToSentTruck="";
    static String createWorkBook(String nameOfWorkBook) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        try (FileOutputStream fileOutputStream = new FileOutputStream(nameOfWorkBook+".xlsx")) {
            workbook.write(fileOutputStream);
            System.out.println("Excel file " + nameOfWorkBook + " created ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameOfWorkBook;
    }

    static void createSheet(String nameOfSheet,String nameOfWorkBook) throws FileNotFoundException {
        System.out.println("name of work book "+nameOfWorkBook);
         try{
             FileInputStream fileInputStream=new FileInputStream(nameOfWorkBook+".xlsx");

             Workbook workbook=WorkbookFactory.create(fileInputStream);
             Sheet newSheet= workbook.createSheet(nameOfSheet);
             try(FileOutputStream fileOutputStream =new FileOutputStream(nameOfWorkBook+".xlsx")){
                 workbook.write(fileOutputStream);
                 System.out.println("New sheet " + nameOfSheet + " created in Excel file " + nameOfWorkBook + " ");
             }
         } catch (FileNotFoundException e){
             throw e;
         } catch (IOException c){
             c.printStackTrace();
         }

    }
     static boolean isSheetEmpty(String nameOfWorkBook,String nameOfSheet){
         try{
             FileInputStream fileInput = new FileInputStream(nameOfWorkBook+".xlsx");
             Workbook workbook= WorkbookFactory.create(fileInput);
             Sheet sheet=workbook.getSheet(nameOfSheet);
             return sheet.getPhysicalNumberOfRows()==0;
         } catch (IOException e){
             e.printStackTrace();
         }
         return false;
     }

     static int getLastRowNumber(String nameOfWorkBook,String nameOfSheet){
         try {
             FileInputStream fileInput = new FileInputStream(nameOfWorkBook+".xlsx");
             Workbook workbook= WorkbookFactory.create(fileInput);
             Sheet sheet=workbook.getSheet(nameOfSheet);
             return sheet.getLastRowNum();
         } catch (IOException e){
             e.printStackTrace();
         }
         return -1;
     }
    static void saveWorkbook(Workbook workbook, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath+".xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void addDataToSheet(String[][] data, Sheet sheet, int rowNum){

        for (String[] rowValues : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (String value : rowValues) {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(value);
            }
        }
    }

     static void addData(ArrivedTruck arrivedTruck){
         try{
             FileInputStream fileInput = new FileInputStream(nameOfWorkBookToArrivedTruck+".xlsx");
             Workbook workbook= WorkbookFactory.create(fileInput);
             Sheet sheet=workbook.getSheet(nameOfSheetToArrivedTruck);

             if (isSheetEmpty(nameOfWorkBookToArrivedTruck,nameOfSheetToArrivedTruck)){
                 String[][] data={
                         {"Number of truck","weight of truck ","Truck came from","Arrival date","Arrival time"}};
                 addDataToSheet(data,sheet,0);
                 saveWorkbook(workbook,nameOfWorkBookToArrivedTruck);
             }

             String[][] data={
                     {arrivedTruck.getTruckNumber(),String.valueOf(arrivedTruck.getWeightOfTruck())
                             ,arrivedTruck.getArrivedFrom(), String.valueOf(arrivedTruck.getArrivalDate())
                             ,String.valueOf(arrivedTruck.getArrivalTime())}};
             addDataToSheet(data,sheet,(getLastRowNumber(nameOfWorkBookToArrivedTruck,nameOfSheetToArrivedTruck))+1);
             saveWorkbook(workbook,nameOfWorkBookToArrivedTruck);



         } catch (IOException e){
             e.printStackTrace();
         }
     }
    static void addData(SentTruck sentTruck){
        try{
            FileInputStream fileInput = new FileInputStream(nameOfWorkBookToSentTruck+".xlsx");
            Workbook workbook= WorkbookFactory.create(fileInput);
            Sheet sheet=workbook.getSheet(nameOfSheetToSentTruck);

            if (isSheetEmpty(nameOfWorkBookToSentTruck,nameOfSheetToSentTruck)) {
                String[][] data = {
                        {"Number of truck", "weight of truck ", "Truck sent to", "Arrival date", "Arrival time"}};
                addDataToSheet(data, sheet, 0);
                saveWorkbook(workbook,nameOfWorkBookToSentTruck);
            }
            String[][] data={
                    {sentTruck.getTruckNumber(),String.valueOf(sentTruck.getWeightOfTruck())
                            ,sentTruck.getSentTo(), String.valueOf(sentTruck.getSentDate())
                            ,String.valueOf(sentTruck.getSentTime())}};
            addDataToSheet(data,sheet,(getLastRowNumber(nameOfWorkBookToSentTruck,nameOfSheetToSentTruck)+1));

            saveWorkbook(workbook,nameOfWorkBookToSentTruck);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
    static boolean workBookIsExist(String nameOfWorkBook){
        File file =new File(nameOfWorkBook+".xlsx");
        return file.exists();
    }
    static boolean sheetIsExist(String nameOfWorkBook,String nameOfSheet){
        if (workBookIsExist(nameOfWorkBook)){
            try{
                FileInputStream fileInputStream=new FileInputStream(nameOfWorkBook+".xlsx");
                Workbook workbook= WorkbookFactory.create(fileInputStream);
                return workbook.getSheetIndex(nameOfSheet) !=-1;

            }catch (IOException e){
                e.printStackTrace();
            }
        } else {
            return false;
        }
        return false;
    }




}

