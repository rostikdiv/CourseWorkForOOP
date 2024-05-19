package com.CourseWork.CourseWorkForOOP;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    static void saveWorkbook(Workbook workbook, String nameOfWorkBook) {
        try (FileOutputStream fileOut = new FileOutputStream(nameOfWorkBook+".xlsx")) {
            workbook.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException c){
            c.printStackTrace();
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
    static boolean rowIsExist(String nameOfWorkBook, String nameOfSheet, int rowNum){
        if (sheetIsExist(nameOfWorkBook,nameOfSheet)){
            try{
                FileInputStream fileInputStream=new FileInputStream(nameOfWorkBook+".xlsx");
                Workbook workbook=WorkbookFactory.create(fileInputStream);
                Sheet sheet=workbook.getSheet(nameOfSheet);
                Row row=sheet.getRow(rowNum);
                if (row!=null){
                    return true;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static Boolean isCellExist(String nameOfWorkBook, String nameOfSheet, int rowNumber, int cellNumber){
        try (FileInputStream fileInputStream = new FileInputStream(nameOfWorkBook + ".xlsx")) {
            Workbook workbook=WorkbookFactory.create(fileInputStream);
            Sheet sheet=workbook.getSheet(nameOfSheet);
            Row row=sheet.getRow(rowNumber);
            Cell cell=row.getCell(cellNumber);

            if (cell!=null){
                return true;
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean deleteWorkbook(String nameOfWorkBook){
        if (workBookIsExist(nameOfWorkBook)){

            File file=new File(nameOfWorkBook+".xlsx");
            return file.delete();
        }
        return false;
    }
    public static Boolean deleteSheet(String nameOfWorkBook,String nameOfSheet){
        if (sheetIsExist(nameOfWorkBook,nameOfSheet)){
            try{
                FileInputStream fileInputStream=new FileInputStream(nameOfWorkBook+".xlsx");
                Workbook workbook=WorkbookFactory.create(fileInputStream);
                int index =workbook.getSheetIndex(nameOfSheet);
                workbook.removeSheetAt(index);
                saveWorkbook(workbook,nameOfWorkBook);
                return true;


            }catch (IOException e){
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
    public static Boolean deleteRow(String nameOfWorkBook, String nameOfSheet, int rowNum) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nameOfWorkBook + ".xlsx");
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet(nameOfSheet);



            if (rowNum < 0 || rowNum > sheet.getLastRowNum()) {
                return false;
            }

            Row row = sheet.getRow(rowNum);
            if (row != null) {
                sheet.removeRow(row);

                for (int i = rowNum; i < sheet.getLastRowNum(); i++) {
                    Row rowToShiftUp = sheet.getRow(i + 1);
                    Row rowToShiftDown = sheet.createRow(i);

                    if (rowToShiftUp != null) {
                        for (int cellNum = 0; cellNum < rowToShiftUp.getLastCellNum(); cellNum++) {
                            Cell oldCell = rowToShiftUp.getCell(cellNum);
                            Cell newCell = rowToShiftDown.createCell(cellNum);

                            if (oldCell != null) {
                                newCell.setCellStyle(oldCell.getCellStyle());
                                switch (oldCell.getCellType()) {
                                    case STRING:
                                        newCell.setCellValue(oldCell.getStringCellValue());
                                        break;
                                    case NUMERIC:
                                        newCell.setCellValue(oldCell.getNumericCellValue());
                                        break;
                                    case BOOLEAN:
                                        newCell.setCellValue(oldCell.getBooleanCellValue());
                                        break;
                                    case FORMULA:
                                        newCell.setCellFormula(oldCell.getCellFormula());
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                }


                int lastRowNum = sheet.getLastRowNum();
                Row lastRow = sheet.getRow(lastRowNum);
                if (lastRow != null) {
                    sheet.removeRow(lastRow);
                }
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(nameOfWorkBook + ".xlsx")) {
                workbook.write(fileOutputStream);
            }

            workbook.close();
            fileInputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean getHistoryOfTruck(String nameOfWorkBookForHistory,String nameOfSheetForHistory,String truckNumber){
        try{
            boolean iterate=true;
            FileInputStream fileInputArrived=new FileInputStream(nameOfWorkBookToArrivedTruck+".xlsx");
            FileInputStream fileInputSent=new FileInputStream(nameOfWorkBookToSentTruck+".xlsx");
            FileInputStream fileInputHistory=new FileInputStream(nameOfWorkBookForHistory+".xlsx");

            Workbook workbookArrived=WorkbookFactory.create(fileInputArrived);
            Workbook workbookSent=WorkbookFactory.create(fileInputSent);
            Workbook workbookHistory=WorkbookFactory.create(fileInputHistory);

            Sheet sheetArrived=workbookArrived.getSheet(nameOfSheetToArrivedTruck);
            Sheet sheetSent=workbookSent.getSheet(nameOfSheetToSentTruck);
            Sheet sheetHistory=workbookHistory.getSheet(nameOfSheetForHistory);

            int arrivedSheetIndex=0,sentSheetIndex=0,historySheetIndex=1;
            if ((sheetArrived.getLastRowNum()+1)+(sheetSent.getLastRowNum()+1)<3){
                return false;
            }

            String[][] data={
                    {"Number of truck","weight of truck ","Truck came from","truck sent to","date","time"}};
            addDataToSheet(data,sheetHistory,0);


            while(iterate){
                iterate=false;
                for(;arrivedSheetIndex<sheetArrived.getLastRowNum()+1;){
                    System.out.println("arrivedSheetIndex "+arrivedSheetIndex);
                    Row row=sheetArrived.getRow(arrivedSheetIndex++);
                    Cell cell=row.getCell(0);
                    if (cell.getStringCellValue().equals(truckNumber)){
                        sheetHistory.createRow(historySheetIndex);
                        Row row1=sheetHistory.getRow(historySheetIndex++);
                        row1.createCell(0).setCellValue(String.valueOf(row.getCell(0)));
                        row1.createCell(1).setCellValue(String.valueOf(row.getCell(1)));
                        row1.createCell(2).setCellValue(String.valueOf(row.getCell(2)));
                        row1.createCell(4).setCellValue(String.valueOf(row.getCell(3)));
                        row1.createCell(5).setCellValue(String.valueOf(row.getCell(4)));
                        iterate=true;
                        break;

                    }

                }

                for(;sentSheetIndex<sheetSent.getLastRowNum()+1;){
                    System.out.println("sentSheetIndex "+sentSheetIndex);
                    Row row=sheetSent.getRow(sentSheetIndex++);
                    Cell cell=row.getCell(0);
                    if (cell.getStringCellValue().equals(truckNumber)){
                        sheetHistory.createRow(historySheetIndex);
                        Row row1=sheetHistory.getRow(historySheetIndex++);
                        row1.createCell(0).setCellValue(String.valueOf(row.getCell(0)));
                        row1.createCell(1).setCellValue(String.valueOf(row.getCell(1)));
                        row1.createCell(3).setCellValue(String.valueOf(row.getCell(2)));
                        row1.createCell(4).setCellValue(String.valueOf(row.getCell(3)));
                        row1.createCell(5).setCellValue(String.valueOf(row.getCell(4)));
                        iterate=true;
                        break;

                    }

                }
                System.out.println("---------While");

            }

            saveWorkbook(workbookHistory,nameOfWorkBookForHistory);
            return true;

        }catch (IOException e){
            e.printStackTrace();

        }
        return false;
    }
    public static boolean renameSheet(String nameOfWorkBook, String nameOfSheet, String newNameOfSheet) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nameOfWorkBook + ".xlsx");

            Workbook workbook = WorkbookFactory.create(fileInputStream);
            int sheetIndex = workbook.getSheetIndex(nameOfSheet);

            if (sheetIndex != -1) {
                workbook.setSheetName(sheetIndex, newNameOfSheet);
                saveWorkbook(workbook,nameOfWorkBook);
                return true;
            } else {
                System.out.println("Sheet with name " + nameOfSheet + " does not exist.");
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }




}

