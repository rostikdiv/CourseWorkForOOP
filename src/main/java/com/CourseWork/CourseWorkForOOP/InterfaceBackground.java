package com.CourseWork.CourseWorkForOOP;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
            keyboardRow1.add("/Add arrived truck to list");
            KeyboardRow keyboardRow2=new KeyboardRow();
            keyboardRow1.add("/Add sent truck to list");


            keyboardRows.add(keyboardRow1);
            keyboardRows.add(keyboardRow2);



            replyKeyboardMarkup.setKeyboard(keyboardRows);

            return replyKeyboardMarkup;
        }
        static InlineKeyboardMarkup getButtonsToTruckNumber(){
            InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
            List<InlineKeyboardButton> buttonRow1=new ArrayList<>();
            List<InlineKeyboardButton> buttonRow2=new ArrayList<>();
            List<List<InlineKeyboardButton>> buttonRows=new ArrayList<>();
            InlineKeyboardButton button1=new InlineKeyboardButton();
            button1.setText("AA0997BB");
            button1.setCallbackData("AA0997BB");
            InlineKeyboardButton button2=new InlineKeyboardButton();
            button2.setText("AB4544AC");
            button2.setCallbackData("AB4544AC");
            InlineKeyboardButton button3=new InlineKeyboardButton();
            button3.setText("AI6556CC");
            button3.setCallbackData("AI6556CC");
            InlineKeyboardButton button4=new InlineKeyboardButton();
            button4.setText("BC1010AA");
            button4.setCallbackData("BC1010AA");
            buttonRow1.add(button1);
            buttonRow1.add(button2);
            buttonRow2.add(button3);
            buttonRow2.add(button4);
            buttonRows.add(buttonRow1);
            buttonRows.add(buttonRow2);

            inlineKeyboardMarkup.setKeyboard(buttonRows);

            return inlineKeyboardMarkup;
        }
        static InlineKeyboardMarkup getButtonsToArrivedFrom(){
            InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
            List<InlineKeyboardButton> buttonRow1=new ArrayList<>();
            List<InlineKeyboardButton> buttonRow2=new ArrayList<>();
            List<List<InlineKeyboardButton>> buttonRows=new ArrayList<>();
            InlineKeyboardButton button1=new InlineKeyboardButton();
            button1.setText("storage number 1");
            button1.setCallbackData("storage number 1");
            InlineKeyboardButton button2=new InlineKeyboardButton();
            button2.setText("storage number 2");
            button2.setCallbackData("storage number 2");
            InlineKeyboardButton button3=new InlineKeyboardButton();
            button3.setText("storage number 3");
            button3.setCallbackData("storage number 3");
            InlineKeyboardButton button4=new InlineKeyboardButton();
            button4.setText("storage number 4");
            button4.setCallbackData("storage number 4");
            buttonRow1.add(button1);
            buttonRow1.add(button2);
            buttonRow2.add(button3);
            buttonRow2.add(button4);
            buttonRows.add(buttonRow1);
            buttonRows.add(buttonRow2);

            inlineKeyboardMarkup.setKeyboard(buttonRows);

            return inlineKeyboardMarkup;
        }

        static InlineKeyboardMarkup getButtonsToSentTo(){
            InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
            List<InlineKeyboardButton> buttonRow1=new ArrayList<>();
            List<InlineKeyboardButton> buttonRow2=new ArrayList<>();
            List<List<InlineKeyboardButton>> buttonRows=new ArrayList<>();
            InlineKeyboardButton button1=new InlineKeyboardButton();
            button1.setText("storage number 1");
            button1.setCallbackData("storage number 1");
            InlineKeyboardButton button2=new InlineKeyboardButton();
            button2.setText("storage number 2");
            button2.setCallbackData("storage number 2");
            InlineKeyboardButton button3=new InlineKeyboardButton();
            button3.setText("storage number 3");
            button3.setCallbackData("storage number 3");
            InlineKeyboardButton button4=new InlineKeyboardButton();
            button4.setText("storage number 4");
            button4.setCallbackData("storage number 4");
            buttonRow1.add(button1);
            buttonRow1.add(button2);
            buttonRow2.add(button3);
            buttonRow2.add(button4);
            buttonRows.add(buttonRow1);
            buttonRows.add(buttonRow2);

            inlineKeyboardMarkup.setKeyboard(buttonRows);

            return inlineKeyboardMarkup;
        }
        static InlineKeyboardMarkup toChoseWorkBookAndSheet(){
            InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
            List<InlineKeyboardButton> buttonRow1=new ArrayList<>();
            List<List<InlineKeyboardButton>> buttonRows=new ArrayList<>();
            InlineKeyboardButton button1=new InlineKeyboardButton();
            button1.setText("Arrived truck");
            button1.setCallbackData("Arrived truck");
            InlineKeyboardButton button2=new InlineKeyboardButton();
            button2.setText("Sent truck");
            button2.setCallbackData("Sent truck");

            buttonRow1.add(button1);
            buttonRow1.add(button2);
            buttonRows.add(buttonRow1);


            inlineKeyboardMarkup.setKeyboard(buttonRows);

            return inlineKeyboardMarkup;

        }
        static InlineKeyboardMarkup toChoseWorkBookForRetaining(){
            InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
            List<InlineKeyboardButton> buttonRow1=new ArrayList<>();
            List<List<InlineKeyboardButton>> buttonRows=new ArrayList<>();
            InlineKeyboardButton button1=new InlineKeyboardButton();
            button1.setText("Arrived truck");
            button1.setCallbackData("Arrived trucks");
            InlineKeyboardButton button2=new InlineKeyboardButton();
            button2.setText("Sent trucks");
            button2.setCallbackData("Sent trucks");
            InlineKeyboardButton button3=new InlineKeyboardButton();
            button3.setText("same else");
            button3.setCallbackData("same else");

            buttonRow1.add(button1);
            buttonRow1.add(button2);
            buttonRow1.add(button3);
            buttonRows.add(buttonRow1);


            inlineKeyboardMarkup.setKeyboard(buttonRows);

            return inlineKeyboardMarkup;

        }



    }
    static String systemParameter="";
    static SendMessage addArrivedTruck(Update update,ListOfArrivedTrucks listOfArrivedTrucks){
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
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToArrivedFrom());


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
                sendMessage.setText("the truck is recorded ");
                sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.welcomeKeyboard());
                systemParameter="";
                System.out.println("initiation_______________________");
                WorkWithExel.addData(listOfArrivedTrucks.getLast());

            } catch (NumberFormatException e){
                sendMessage.setText("you entered the weight incorrectly ");
            } finally {
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                System.out.println(message.getText());
            }
        }


        return sendMessage;
    }
    static SendMessage addSentTruck(Update update,ListOfSentTrucks listOfSentTrucks ){
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
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToSentTo());


        } else if(listOfSentTrucks.getLast().isSentToEmpty() && update.hasCallbackQuery()||
                listOfSentTrucks.getLast().isSentToEmpty() && update.hasMessage()) {
            if (update.hasCallbackQuery()) {
                listOfSentTrucks.getLast().setSentTo(update.getCallbackQuery().getData());
                sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
            } else {
                listOfSentTrucks.getLast().setSentTo(message.getText());
                sendMessage.setChatId(String.valueOf(message.getChatId()));
            }
            System.out.println(listOfSentTrucks.getLast().getSentTo());
            sendMessage.setText("Please send waigth of truck ");

        } else if (!listOfSentTrucks.getLast().isWeightOfTruckEmpty()&& update.hasMessage()){
            try {
                listOfSentTrucks.getLast().setWeightOfTruck(Double.parseDouble(message.getText()));
                sendMessage.setText("the truck is recorded ");
                sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.welcomeKeyboard());
                systemParameter="";
                WorkWithExel.addData(listOfSentTrucks.getLast());
            } catch (NumberFormatException e){
                sendMessage.setText("you entered the weight incorrectly ");
            } finally {
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                System.out.println(message.getText());
            }
        }

        return sendMessage;
    }

    static class WorkWithExelInterface{
        static String systemParameter="";
        static int systemParameterInt=0;
        static String nameOfWorkBook="";
        static String nameOfSheet="";
        static String truckNumber="";

        static void clear(){
            systemParameter="";
            systemParameterInt=0;
            nameOfWorkBook="";
            nameOfSheet="";
            truckNumber="";
            System.out.println("parameter systemParameter,systemParameterInt,nameOfWorkBook,nameOfSheet,truckNumber have cleared");
        }

        public static String getChatId(Update update) {
            if (update.hasMessage()){
                return String.valueOf(update.getMessage().getChatId());
            } else if (update.hasCallbackQuery()){
                return String.valueOf(update.getCallbackQuery().getMessage().getChatId());
            }
            return null;
        }

        static SendMessage createWorkBook(Update update){
            SendMessage sendMessage=new SendMessage();
            if (update.getMessage().getText().equals("/create_excel_workbook")){
                systemParameter="/create_excel_workbook";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of exel work book");
            } else if(systemParameter.equals("/create_excel_workbook")){

                WorkWithExel.createWorkBook(update.getMessage().getText());
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book created");
                clear();
            }
            return sendMessage;
        }
        static SendMessage createSheet(Update update){
            SendMessage sendMessage=new SendMessage();
            if (update.getMessage().getText().equals("/create_excel_sheet")){
                systemParameter="/create_excel_sheet";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of work book where sheet will be created ");
            } else if(systemParameter.equals("/create_excel_sheet")&&nameOfWorkBook.isEmpty()){
                nameOfWorkBook=update.getMessage().getText();
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter name of new sheet");

            } else if (systemParameter.equals("/create_excel_sheet")&&!nameOfWorkBook.isEmpty()){
               try {
                   WorkWithExel.createSheet(update.getMessage().getText(),nameOfWorkBook);
                   sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"exel sheet created");
                   clear();
               }catch (FileNotFoundException e) {
                  sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book with name"+nameOfWorkBook+"is not exist please enter correct name of work book");
                  nameOfWorkBook="";
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
                        System.out.println("initiation_______________________");
                        WorkWithExel.nameOfWorkBookToArrivedTruck=nameOfWorkBook;
                        WorkWithExel.nameOfSheetToArrivedTruck=nameOfSheet;
                        clear();
                    } else if (systemParameter.equals("chose Sent truck")) {
                        System.out.println("initiation_______________________");
                        WorkWithExel.nameOfWorkBookToSentTruck=nameOfWorkBook;
                        WorkWithExel.nameOfSheetToSentTruck=nameOfSheet;
                        clear();
                    }
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
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"do you vanna delete row in arrived or sent truck");
                sendMessage.setReplyMarkup(Keyboard.toChoseWorkBookAndSheet());
            }

            if (update.hasCallbackQuery()) {
                if (update.getCallbackQuery().getData().equals("Arrived truck")){
                    nameOfWorkBook=WorkWithExel.nameOfWorkBookToArrivedTruck;
                    nameOfSheet=WorkWithExel.nameOfSheetToArrivedTruck;
                } else if (update.getCallbackQuery().getData().equals("Sent truck")) {
                    nameOfWorkBook=WorkWithExel.nameOfWorkBookToSentTruck;
                    nameOfSheet=WorkWithExel.nameOfSheetToSentTruck;

                }
                sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"please enter the number of row for deleting");
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
                    systemParameter="sendArrived";
                    sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"not");
                } else if (update.getCallbackQuery().getData().equals("Sent trucks")) {
                    systemParameter="sendSent";
                    sendMessage=new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"not");

                } else if (update.getCallbackQuery().getData().equals("same else")) {
                    sendMessage =new SendMessage(String.valueOf(update.getCallbackQuery().getMessage().getChatId()),"please enter the name of workbook");
                    systemParameter="send same workbook";
                }
            } else if (update.hasMessage()&&systemParameter.equals("send same workbook")){
                if (WorkWithExel.workBookIsExist(update.getMessage().getText())){
                    nameOfWorkBook=update.getMessage().getText();
                    sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"not");
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
            } else System.out.println("фал не існує");
            return sendDocument;
        }

    }

}
