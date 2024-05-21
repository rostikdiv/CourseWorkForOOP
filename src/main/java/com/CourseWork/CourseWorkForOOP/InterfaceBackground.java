package com.CourseWork.CourseWorkForOOP;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class InterfaceBackground {

    public static class Keyboard{
        static ReplyKeyboardMarkup welcomeKeyboard(){

        ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows =new ArrayList<>();
        KeyboardRow keyboardRow1=new KeyboardRow();
        keyboardRow1.add("/add_arrived_truck_to_list");
        KeyboardRow keyboardRow2=new KeyboardRow();
        keyboardRow1.add("/add_sent_truck_to_list");

        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
        static public InlineKeyboardMarkup createInlineKeyboard(String[] values,int buttonPerRows) {
            List<List<InlineKeyboardButton>> rows = new ArrayList<>();

            for (int i = 0; i < values.length; i += buttonPerRows) {
                List<InlineKeyboardButton> row = new ArrayList<>();
                for (int j = 0; j < buttonPerRows; j++) {
                    if (i + j < values.length) {
                        InlineKeyboardButton button = InlineKeyboardButton.builder()
                                .text(values[i + j])
                                .callbackData(values[i + j])
                                .build();
                        row.add(button);
                    }
                }
                rows.add(row);
            }

            return InlineKeyboardMarkup.builder().keyboard(rows).build();
        }

        static InlineKeyboardMarkup getButtonsToTruckNumber(){
            String[] carNumbers = {
                    "AB01CD", "AB02CD", "AB03CD", "AB04CD", "AB05CD", "AB06CD", "AB07CD", "AB08CD",
                    "AB09CD", "AB10CD", "AB11CD", "AB12CD"
            };
            return (createInlineKeyboard(carNumbers,3));
        }
        static InlineKeyboardMarkup getButtonsToLocations(){
            String[] locations = {
                    "North Freight Hub","East Logistics Center","West Storage Complex"
                    ,"South Transport Node","Central Transshipment Point","International Trade Terminal"
            };
            return createInlineKeyboard(locations,2);
        }
        static InlineKeyboardMarkup toChoseWorkBookAndSheet(){
            String[] toChose = {
                    "Arrived truck", "Sent truck"
            };
            return createInlineKeyboard(toChose,1);
        }
        static InlineKeyboardMarkup toChoseWorkBookForRetaining(){
            String[] toChose = {
                    "Arrived trucks", "Sent trucks", "same else"
            };
            return createInlineKeyboard(toChose,1);

        }
        static InlineKeyboardMarkup toChoseDeleteRow(){
            String[] toChose = {
                    "Arrived truck", "Sent truck", "same else"
            };
            return createInlineKeyboard(toChose,1);

        }



    }
    static class WorkWithExelInterface{
        private static String systemParameter="";
        private static int systemParameterInt=0;
        private static String nameOfWorkBook="";
        private static String nameOfSheet="";
        private static String truckNumber="";

        static void clear(){
            systemParameter="";
            systemParameterInt=0;
            nameOfWorkBook="";
            nameOfSheet="";
            truckNumber="";
            System.out.println("parameters: systemParameter,systemParameterInt,nameOfWorkBook,nameOfSheet,truckNumber have cleared");
        }
        static SendMessage startMessage(Update update){
            SendMessage sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Hi i'm bot created for help with accounting data in logistic company. If you want to know info about commands please enter /help ");
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.welcomeKeyboard());

            return sendMessage;
        }
        static SendMessage helpInfo(Update update){
            SendMessage sendMessage= new SendMessage(String.valueOf(update.getMessage().getChatId()),"Explanation fo commands.\n\n" +
                    "/create_excel_workbook - creates an Excel workbook, to create it, you only need to enter its name.\n\n" +
                    "/create_excel_sheet - creates a sheet in an Excel workbook, to create it, you need to enter the name of the existing workbook and the name of the new sheet.\n\n" +
                    "/choose_sheet_for_work - is used to chose the sheet in which the data will be entered. To select, you need to specify record arriving or sent trucks, the name of the workbook, the name of the sheet.\n\n" +
                    "/add_arrived_truck_to_list - adds data about the arriving truck to the selected sheet. To add, you need to enter the truck number by tapping or chose number by button , weight, place from arrived, time and date are specified automatically.\n\n" +
                    "/add_sent_truck_to_list - adds data about the sent truck to the selected sheet. To add, you need to enter the truck number by tapping or chose number by button , weight, place sent to, time and date are specified automatically.\n\n" +
                    "/delete_workbook - deletes the workbook. To delete, you need to enter the name of the existing workbook.\n\n" +
                    "/delete_sheet -deletes a sheet in a workbook. To delete, you need to enter the names of the existing workbook and letter in the workbook.\n\n" +
                    "/delete_row -deletes a row in a letter. To delete, select the workbook and the sheet in it. To do this, you need to press one of the three buttons\n" +
                    "\"arrived truck\" - selects a sheet for working with arriving trucks, \n\"sent truck\" - selects a sheet for working with sent trucks, \n\"same else truck\" you need to specify the name of the existing workbook and the sheet in it yourself. Next, indicate the row number in the sheet if it exists then it is deleted.\n\n" +
                    "/get_history_of_truck -gives the history of a certain truck, for this you need to specify the number of the truck, the data is taken from the sheets selected for entering data for the arriving and departing trucks. To receive it, you need to specify the name of the workbook and the letter in it for recording in this history and the truck number.\n\n" +
                    "/rename_sheet - renames a sheet in the workbook. To do this, you need to enter the Name of the workbook and the sheet in it and the new name of sheet.\n\n" +
                    "/get_workbook -sends the selected workbook. To do this, you need to specify which workbook to send by clicking on the button \"arrived truck\", \"sent truck\", \"same else truck\"\n" +
                    "when pressing the button \"arrived truck\" or \"sent truck\" the workbook selected for work is sent, and when pressing the \"same else truck\" button, the name of the workbook must be specified.\n\n" +
                    "/back_to_menu - resets all commands except selected sheets. It is recommended to use in case of incorrect operation.\n"
            );
            return sendMessage;
        }
        static SendMessage createWorkBook(Update update){
            SendMessage sendMessage=new SendMessage();
            if (update.getMessage().getText().equals("/create_excel_workbook")){
                systemParameter="/create_excel_workbook";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of exel work book");
            } else if(systemParameter.equals("/create_excel_workbook")){
                if (!WorkWithExel.workBookIsExist(update.getMessage().getText())){
                    if (WorkWithExel.createWorkBook(update.getMessage().getText())){
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book created");
                        clear();
                    } else {
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book haven't created");
                    }
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book with this name have exist");
                }
            }
            return sendMessage;
        }
        static SendMessage createSheet(Update update){
            SendMessage sendMessage=new SendMessage();
            if (update.getMessage().getText().equals("/create_excel_sheet")){
                systemParameter="/create_excel_sheet";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of work book where sheet will be created ");
            } else if(systemParameter.equals("/create_excel_sheet")&&nameOfWorkBook.isEmpty()){
                if (WorkWithExel.workBookIsExist(update.getMessage().getText())){
                    nameOfWorkBook=update.getMessage().getText();
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter name of new sheet");

                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book with this name is not exist please enter correct name");
                }

            } else if (systemParameter.equals("/create_excel_sheet")&&!nameOfWorkBook.isEmpty()){
                try {
                    WorkWithExel.createSheet(update.getMessage().getText(),nameOfWorkBook);
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"exel sheet have created");
                    clear();

                }catch (FileNotFoundException e) {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book with name"+nameOfWorkBook+"is not exist please enter correct name of work book");
                    nameOfWorkBook="";
                }catch (IllegalArgumentException l){
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"sheet with name"+nameOfSheet+"is exist please enter correct name of sheet");
                    nameOfSheet="";
                }
            }

            return sendMessage;
        }
        static SendMessage choseSheetInWorkBook (Update update){
            SendMessage sendMessage= new SendMessage();
            if (update.hasMessage()&&systemParameter.isEmpty()){
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"do you wanna chose sheet for Arrived truck or Sent truck");
                sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.toChoseWorkBookAndSheet());
                systemParameter="/choose_sheet_for_work";
            } else if (update.hasCallbackQuery()){
                if (update.getCallbackQuery().getData().equals("Arrived truck")){
                    systemParameter="chose Arrived truck";
                } else if (update.getCallbackQuery().getData().equals("Sent truck")){
                    systemParameter="chose Sent truck";
                }
                sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"please enter the name of work book");

            } else if (nameOfWorkBook.isEmpty()) {
                nameOfWorkBook=update.getMessage().getText();
                if(!WorkWithExel.workBookIsExist(nameOfWorkBook)){
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"this workbook is not exist please enter the correct name of work book");
                    nameOfWorkBook="";
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of Sheet");

                }
            } else if (nameOfSheet.isEmpty()) {
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"sheet have chosen");
                nameOfSheet=update.getMessage().getText();
                if (!WorkWithExel.sheetIsExist(nameOfWorkBook,update.getMessage().getText())){
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"this sheet is not exist please enter correct name of sheet");
                } else {
                    if (systemParameter.equals("chose Arrived truck")){

                        WorkWithExel.setNameOfWorkBookToArrivedTruck(nameOfWorkBook);
                        WorkWithExel.setNameOfSheetToArrivedTruck(nameOfSheet);
                        clear();
                    } else if (systemParameter.equals("chose Sent truck")) {

                        WorkWithExel.setNameOfWorkBookToSentTruck(nameOfWorkBook);
                        WorkWithExel.setNameOfSheetToSentTruck(nameOfSheet);
                        clear();
                    }
                }
            }
            return sendMessage;
        }
        static SendMessage addTruck(Update update,ListOfArrivedTrucks listOfArrivedTrucks){
            InterfaceBackground interfaceBackground=new InterfaceBackground();
            Message message=update.getMessage();
            SendMessage sendMessage=new SendMessage();
            if(update.hasMessage()&&message.getText().equals("/add_arrived_truck_to_list")){
                systemParameter="/add_arrived_truck_to_list";
                sendMessage.setText("Please send a number of truck");
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToTruckNumber());
                listOfArrivedTrucks.add(new ArrivedTruck());
                System.out.println(listOfArrivedTrucks.getSize());

            } else if(update.hasCallbackQuery()&& listOfArrivedTrucks.getLast().isTruckNumberEmpty() ||
                    update.hasMessage()&& listOfArrivedTrucks.getLast().isTruckNumberEmpty()){
                if (update.hasCallbackQuery()){
                    listOfArrivedTrucks.getLast().setTruckNumber(update.getCallbackQuery().getData());
                    sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
                } else {
                    listOfArrivedTrucks.getLast().setTruckNumber(message.getText());
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                }
                System.out.println(listOfArrivedTrucks.getLast().getTruckNumber());
                sendMessage.setText("Please send from arrived truck ");
                sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToLocations());


            } else if(listOfArrivedTrucks.getLast().isArrivedFromEmpty() && update.hasCallbackQuery()||
                    listOfArrivedTrucks.getLast().isArrivedFromEmpty() && update.hasMessage()) {
                if (update.hasCallbackQuery()) {
                    listOfArrivedTrucks.getLast().setArrivedFrom(update.getCallbackQuery().getData());
                    sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
                } else {
                    listOfArrivedTrucks.getLast().setArrivedFrom(message.getText());
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                }
                System.out.println(listOfArrivedTrucks.getLast().getArrivedFrom());
                sendMessage.setText("Please send waigth of truck ");

            } else if (!listOfArrivedTrucks.getLast().isWeightOfTruckEmpty()&& update.hasMessage()){
                try {
                    listOfArrivedTrucks.getLast().setWeightOfTruck(Double.parseDouble(message.getText()));
                    systemParameter="";
                    if (WorkWithExel.addData(listOfArrivedTrucks.getLast())){
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"the truck have recorded ");
                    } else {
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"the truck haven,t recorded ");
                    }

                } catch (NumberFormatException e){
                    sendMessage.setText("you entered the weight incorrectly ");
                } finally {
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                    System.out.println(message.getText());
                }
            }


            return sendMessage;
        }
        static SendMessage addTruck(Update update,ListOfSentTrucks listOfSentTrucks ){
            InterfaceBackground interfaceBackground=new InterfaceBackground();
            Message message=update.getMessage();
            SendMessage sendMessage=new SendMessage();

            if(update.hasMessage()&&message.getText().equals("/add_sent_truck_to_list")){
                systemParameter="/add_sent_truck_to_list";
                sendMessage.setText("Please send a number of truck");
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToTruckNumber());
                listOfSentTrucks.add(new SentTruck());
                System.out.println(listOfSentTrucks.getSize());

            } else if(update.hasCallbackQuery()&& listOfSentTrucks.getLast().isTruckNumberEmpty() ||
                    update.hasMessage()&& listOfSentTrucks.getLast().isTruckNumberEmpty()){
                if (update.hasCallbackQuery()){
                    listOfSentTrucks.getLast().setTruckNumber(update.getCallbackQuery().getData());
                    sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
                } else {
                    listOfSentTrucks.getLast().setTruckNumber(message.getText());
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                }
                System.out.println(listOfSentTrucks.get(listOfSentTrucks.getSize() - 1).getTruckNumber());
                sendMessage.setText("Please send truck number where truck have sent ");
                sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToLocations());


            } else if(listOfSentTrucks.getLast().isSentToEmpty() && update.hasCallbackQuery()||
                    listOfSentTrucks.getLast().isSentToEmpty() && update.hasMessage()) {
                if (update.hasCallbackQuery()) {
                    listOfSentTrucks.getLast().setSentTo(update.getCallbackQuery().getData());
                    sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
                } else {
                    listOfSentTrucks.getLast().setSentTo(message.getText());
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                }

                sendMessage.setText("Please send waigth of truck ");

            } else if (!listOfSentTrucks.getLast().isWeightOfTruckEmpty()&& update.hasMessage()){
                try {
                    listOfSentTrucks.getLast().setWeightOfTruck(Double.parseDouble(message.getText()));

                    sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.welcomeKeyboard());
                    systemParameter="";
                    if(WorkWithExel.addData(listOfSentTrucks.getLast())){
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"the truck have recorded");
                    } else{
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"the truck haven't recorded");

                    }
                } catch (NumberFormatException e){
                    sendMessage.setText("you entered the weight incorrectly ");
                } finally {
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                    System.out.println(message.getText());
                }
            }

            return sendMessage;
        }


        static SendMessage deleteWorkbook(Update update){
            SendMessage sendMessage=new SendMessage();
            if (update.hasMessage()&&systemParameter.isEmpty()){
                systemParameter="/delete_workbook";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Please enter the name of workbook");
            } else if (update.hasMessage()&&nameOfWorkBook.isEmpty()){
                if (WorkWithExel.workBookIsExist(update.getMessage().getText())){
                    nameOfWorkBook=update.getMessage().getText();
                    if (WorkWithExel.deleteWorkbook(nameOfWorkBook)){
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Work book have removed");
                    } else {
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Work book haven't removed");
                    }
                    clear();
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Work book with this name is not exist");
                }
            }

            return sendMessage;

        }
        static SendMessage deleteSheet(Update update){
            SendMessage sendMessage=new SendMessage();

            if (systemParameter.isEmpty()){
                systemParameter="/delete_sheet";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Please enter the name of the workbook where the sheet is located");
            }else if (update.hasMessage()&&nameOfWorkBook.isEmpty()){
                if (WorkWithExel.workBookIsExist(update.getMessage().getText())){
                    nameOfWorkBook=update.getMessage().getText();
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Please enter the name of sheet");
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book with this name is not exist");
                }
            } else if (update.hasMessage()&&nameOfSheet.isEmpty()) {
                if (WorkWithExel.sheetIsExist(nameOfWorkBook,update.getMessage().getText())){
                    nameOfSheet=update.getMessage().getText();
                    if (WorkWithExel.deleteSheet(nameOfWorkBook,nameOfSheet)){
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"sheet have removed");
                    } else {
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"sheet haven't removed");
                    }
                    clear();
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"sheet with this name is not exist");
                }
            }
            return sendMessage;
        }

        static SendMessage deleteRow(Update update){
            SendMessage sendMessage = new SendMessage();
            if (update.hasMessage()&&systemParameter.isEmpty()){
                systemParameter="/delete_row";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"in which workbook do you vanna delete row");
                sendMessage.setReplyMarkup(Keyboard.toChoseDeleteRow());
                System.out.println("1__________");
            } else if (update.hasCallbackQuery()) {
                if (update.getCallbackQuery().getData().equals("Arrived truck")){
                    nameOfWorkBook=WorkWithExel.getNameOfWorkBookToArrivedTruck();
                    nameOfSheet=WorkWithExel.getNameOfSheetToArrivedTruck();
                    sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"please enter the number of row for deleting");


                } else if (update.getCallbackQuery().getData().equals("Sent truck")) {
                    nameOfWorkBook=WorkWithExel.getNameOfWorkBookToSentTruck();
                    nameOfSheet=WorkWithExel.getNameOfSheetToSentTruck();
                    sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"please enter the number of row for deleting");


                } else if (update.getCallbackQuery().getData().equals("same else")) {
                    sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"Please enter the name of workbook");
                    System.out.println("2__________");

                }
            } else if (update.hasMessage()&&nameOfWorkBook.isEmpty()) {
                if (WorkWithExel.workBookIsExist(update.getMessage().getText())){
                    nameOfWorkBook=update.getMessage().getText();
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of sheet");
                } else {
                    System.out.println("3__________");

                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book with this name haven't exist please enter correct name");
                }
            } else if (update.hasMessage()&&nameOfSheet.isEmpty()) {
                if (WorkWithExel.sheetIsExist(nameOfWorkBook,update.getMessage().getText())){
                    nameOfSheet=update.getMessage().getText();
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the number of row for deleting");

                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"sheet with this name haven't exist please enter correct name");
                }
            } else if (systemParameterInt==0) {
                try{
                    systemParameterInt=Integer.parseInt(update.getMessage().getText());
                } catch (NumberFormatException e){
                    System.out.println("incorrect type of data");
                }
                if (systemParameterInt!=0){
                    if (WorkWithExel.rowIsExist(nameOfWorkBook,nameOfSheet,systemParameterInt-1)){
                        if (WorkWithExel.deleteRow(nameOfWorkBook,nameOfSheet,systemParameterInt-1)){
                            sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"row have removed");
                        } else {
                            sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"row haven't removed");
                        }
                        clear();
                    } else {
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"this row is empty");
                    }
                }
            }

            return sendMessage;
        }
        
        public static SendMessage getHistory(Update update){
            SendMessage sendMessage = new SendMessage();
            if (update.hasMessage()&&update.getMessage().getText().equals("/get_history_of_truck")){
                systemParameter="/get_history_of_truck";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of Workbook for typing history");
            } else if (nameOfWorkBook.isEmpty()) {
                if (WorkWithExel.workBookIsExist(update.getMessage().getText())){
                    nameOfWorkBook=update.getMessage().getText();
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of sheet for typing history");
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"workbook with this name have not exist");
                }
            } else if (nameOfSheet.isEmpty()) {
                if (WorkWithExel.sheetIsExist(nameOfWorkBook,update.getMessage().getText())){
                    nameOfSheet=update.getMessage().getText();
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the truck number for typing history");
                    sendMessage.setReplyMarkup(Keyboard.getButtonsToTruckNumber());
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"sheet with this name have not exist");
                }
            } else if (truckNumber.isEmpty()) {
                if (update.hasMessage()){
                    truckNumber=update.getMessage().getText();
                    if (WorkWithExel.getHistoryOfTruck(nameOfWorkBook,nameOfSheet,truckNumber)){
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"history was created successfully");
                    } else {
                        sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"something went wrong history are not created");
                    }
                    clear();
                } else if (update.hasCallbackQuery()) {
                    truckNumber=update.getCallbackQuery().getData();
                    if (WorkWithExel.getHistoryOfTruck(nameOfWorkBook,nameOfSheet,truckNumber)){
                        sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"history was created successfully");
                    } else {
                        sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"something went wrong history are not created");
                    }
                    clear();
                }
            }

            return sendMessage;
        }
        static SendMessage renameSheet(Update update){
            SendMessage sendMessage=new SendMessage();
            if (update.hasMessage()&&systemParameter.isEmpty()){
                systemParameter="/rename_sheet";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Please send the name of work book");
            } else if (update.hasMessage()&&nameOfWorkBook.isEmpty()){
                if (WorkWithExel.workBookIsExist(update.getMessage().getText())){
                    nameOfWorkBook=update.getMessage().getText();
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please send the name of the sheet to rename it");
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Work book with this name haven't exist");
                }
            } else if (update.hasMessage()&&nameOfSheet.isEmpty()){
                if (WorkWithExel.sheetIsExist(nameOfWorkBook,update.getMessage().getText())){
                    nameOfSheet=update.getMessage().getText();
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Please send a new name of sheet");
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Sheet with this name haven't exist");
                }
            } else if ( update.hasMessage()&&!nameOfWorkBook.isEmpty()&&!nameOfSheet.isEmpty()) {
                if (WorkWithExel.renameSheet(nameOfWorkBook,nameOfSheet,update.getMessage().getText())){
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"name of sheet have changed");
                    clear();
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"name of sheet haven't changed");
                }
            }
            return sendMessage;
        }

        public static SendMessage sendWorkBook(Update update){
            SendMessage sendMessage=new SendMessage();
            if (update.hasMessage()&&systemParameter.isEmpty()){
                systemParameter="/get_workbook";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"Which workbook do you wanna get");
                sendMessage.setReplyMarkup(Keyboard.toChoseWorkBookForRetaining());
            } else if (update.hasCallbackQuery()){
                if (update.getCallbackQuery().getData().equals("Arrived trucks")){
                    if (!WorkWithExel.getNameOfWorkBookToArrivedTruck().isEmpty()&&!WorkWithExel.getNameOfSheetToArrivedTruck().isEmpty()){
                        systemParameter="sendArrived";
                    } else {
                        sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"workbook for arrived tucks haven't chosen");
                        clear();
                    }
                } else if (update.getCallbackQuery().getData().equals("Sent trucks")) {

                    if (!WorkWithExel.getNameOfWorkBookToSentTruck().isEmpty()&&!WorkWithExel.getNameOfSheetToSentTruck().isEmpty()){
                        systemParameter="sendSent";
                    } else {
                        sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"workbook for sent tucks haven't chosen");
                        clear();
                    }

                } else if (update.getCallbackQuery().getData().equals("same else")) {
                    sendMessage =new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"please enter the name of workbook");
                    systemParameter="send same workbook";
                }
            } else if (update.hasMessage()&&systemParameter.equals("send same workbook")){
                if (WorkWithExel.workBookIsExist(update.getMessage().getText())){
                    nameOfWorkBook=update.getMessage().getText();
                } else {
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book with this name is not exist please enter correct name");
                }
            }

            return sendMessage;
        }
        public static SendDocument sendExcelDocument (String nameOfWorkBook,String chatId){
            File file=new File(nameOfWorkBook+".xlsx");
            SendDocument sendDocument=new SendDocument();
            if(file.exists()){
                sendDocument.setDocument(new InputFile(file));
                sendDocument.setChatId(chatId);
            } else System.out.println("File haven't exist");
            return sendDocument;
        }

        public static String getSystemParameter() {
            return systemParameter;
        }

        public static void setSystemParameter(String systemParameter) {
            WorkWithExelInterface.systemParameter = systemParameter;
        }

        public static int getSystemParameterInt() {
            return systemParameterInt;
        }

        public static void setSystemParameterInt(int systemParameterInt) {
            WorkWithExelInterface.systemParameterInt = systemParameterInt;
        }

        public static String getNameOfWorkBook() {
            return nameOfWorkBook;
        }

        public static void setNameOfWorkBook(String nameOfWorkBook) {
            WorkWithExelInterface.nameOfWorkBook = nameOfWorkBook;
        }

        public static String getNameOfSheet() {
            return nameOfSheet;
        }

        public static void setNameOfSheet(String nameOfSheet) {
            WorkWithExelInterface.nameOfSheet = nameOfSheet;
        }

        public static String getTruckNumber() {
            return truckNumber;
        }

        public static void setTruckNumber(String truckNumber) {
            WorkWithExelInterface.truckNumber = truckNumber;
        }
    }

}
