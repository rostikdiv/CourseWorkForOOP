package com.CourseWork.CourseWorkForOOP;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InterfaceBackground {

    public static class Keyboard{
        static ReplyKeyboardMarkup welcomeKeyboard(){

            ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(false);
            List<KeyboardRow> keyboardRows =new ArrayList<>();
            KeyboardRow keyboardRow1=new KeyboardRow();
            keyboardRow1.add("Add arrived truck to list");
            KeyboardRow keyboardRow2=new KeyboardRow();
            keyboardRow1.add("Add sent truck to list");
            KeyboardRow keyboardRow3=new KeyboardRow();
            keyboardRow2.add("get list of arrived trucks");
            KeyboardRow keyboardRow4=new KeyboardRow();
            keyboardRow2.add("get list of trucks that was send ");

            keyboardRows.add(keyboardRow1);
            keyboardRows.add(keyboardRow2);
            keyboardRows.add(keyboardRow3);
            keyboardRows.add(keyboardRow4);



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


    }
    static String systemParameter="";
    static SendMessage addArrivedTruck(Update update,ListOfArrivedTrucks listOfArrivedTrucks){
        InterfaceBackground interfaceBackground=new InterfaceBackground();
        Message message=update.getMessage();
        SendMessage sendMessage=new SendMessage();
        if(update.hasMessage()&&message.getText().equals("Add arrived truck to list")){
            systemParameter="Add arrived truck to list";
            sendMessage.setText("Please send a number of truck");
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToTruckNumber());
            listOfArrivedTrucks.add(new ArrivedTruck());
            System.out.println(listOfArrivedTrucks.getSize());

        } else if(!listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).isTruckNumberInitiated()&& update.hasCallbackQuery()||
                !listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).isTruckNumberInitiated()&& update.hasMessage()){
            if (update.hasCallbackQuery()){
                listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).setTruckNumber(update.getCallbackQuery().getData());
                sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
            } else {
                listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).setTruckNumber(message.getText());
                sendMessage.setChatId(String.valueOf(message.getChatId()));
            }
            System.out.println(listOfArrivedTrucks.get(listOfArrivedTrucks.getSize() - 1).getTruckNumber());
            sendMessage.setText("Please send from arrived truck ");
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToArrivedFrom());


        } else if(!listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).isArrivedFromInitiated()&& update.hasCallbackQuery()||
                !listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).isArrivedFromInitiated()&& update.hasMessage()) {
            if (update.hasCallbackQuery()) {
                listOfArrivedTrucks.get(listOfArrivedTrucks.getSize() - 1).setArrivedFrom(update.getCallbackQuery().getData());
                sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
            } else {
                listOfArrivedTrucks.get(listOfArrivedTrucks.getSize() - 1).setArrivedFrom(message.getText());
                sendMessage.setChatId(String.valueOf(message.getChatId()));
            }
            System.out.println(listOfArrivedTrucks.get(listOfArrivedTrucks.getSize() - 1).getArrivedFrom());
            sendMessage.setText("Please send waigth of truck ");

        } else if (!listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).isWeightOfTruckInitiated()&& update.hasMessage()){
            try {
                listOfArrivedTrucks.get(listOfArrivedTrucks.getSize() - 1).setWeightOfTruck(Double.parseDouble(message.getText()));
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

        if(update.hasMessage()&&message.getText().equals("Add sent truck to list")){
            systemParameter="Add sent truck to list";
            sendMessage.setText("Please send a number of truck");
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToSentTo());
            listOfSentTrucks.add(new SentTruck());
            System.out.println(listOfSentTrucks.getSize());

        } else if(update.hasCallbackQuery()&&!listOfSentTrucks.get(listOfSentTrucks.getSize()-1).isTruckNumberInitiated()||
                update.hasMessage()&&!listOfSentTrucks.get(listOfSentTrucks.getSize()-1).isTruckNumberInitiated()){
            if (update.hasCallbackQuery()){
                listOfSentTrucks.get(listOfSentTrucks.getSize()-1).setTruckNumber(update.getCallbackQuery().getData());
                sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
            } else {
                listOfSentTrucks.get(listOfSentTrucks.getSize()-1).setTruckNumber(message.getText());
                sendMessage.setChatId(String.valueOf(message.getChatId()));
            }
            System.out.println(listOfSentTrucks.get(listOfSentTrucks.getSize() - 1).getTruckNumber());
            sendMessage.setText("Please send truck where truck have sent ");
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.getButtonsToSentTo());


        } else if(!listOfSentTrucks.get(listOfSentTrucks.getSize()-1).isSentToInitiated()&& update.hasCallbackQuery()||
                !listOfSentTrucks.get(listOfSentTrucks.getSize()-1).isSentToInitiated()&& update.hasMessage()) {
            if (update.hasCallbackQuery()) {
                listOfSentTrucks.get(listOfSentTrucks.getSize() - 1).setSentTo(update.getCallbackQuery().getData());
                sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
            } else {
                listOfSentTrucks.get(listOfSentTrucks.getSize() - 1).setSentTo(message.getText());
                sendMessage.setChatId(String.valueOf(message.getChatId()));
            }
            System.out.println(listOfSentTrucks.get(listOfSentTrucks.getSize() - 1).getSentTo());
            sendMessage.setText("Please send waigth of truck ");

        } else if (!listOfSentTrucks.get(listOfSentTrucks.getSize()-1).isWeightOfTruckInitiated()&& update.hasMessage()){
            try {
                listOfSentTrucks.get(listOfSentTrucks.getSize() - 1).setWeightOfTruck(Double.parseDouble(message.getText()));
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
        static String nameOfWorkBook="";
        static String nameOfSheet="";
        static String nameOfList="";

        static SendMessage createWorkBook(Update update){
            SendMessage sendMessage=new SendMessage();
            if (update.getMessage().getText().equals("create exel work book")){
                systemParameter="create exel work book";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of exel work book");
            } else if(systemParameter.equals("create exel work book")){

                WorkWithExel.createWorkBook(update.getMessage().getText());
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book created");
                systemParameter="";
            }
            return sendMessage;
        }
        static SendMessage createSheet(Update update){
            SendMessage sendMessage=new SendMessage();
            if (update.getMessage().getText().equals("create exel sheet")){
                systemParameter="create exel sheet";
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter the name of work book where sheet will be created ");
            } else if(systemParameter.equals("create exel sheet")&&nameOfWorkBook.isEmpty()){
                nameOfWorkBook=update.getMessage().getText();
                sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter name of new sheet");

            } else if (systemParameter.equals("create exel sheet")&&!nameOfWorkBook.isEmpty()){
               try {
                   WorkWithExel.createSheet(update.getMessage().getText(),nameOfWorkBook);
                   sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"exel sheet created");
                   systemParameter="";
                   nameOfWorkBook="";
               }catch (FileNotFoundException e) {
                  sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"work book with name"+nameOfWorkBook+"is not exist please enter correct name of work book");
                  nameOfWorkBook="";
               }
            }

            return sendMessage;
        }
        static SendMessage choseSheetInWorkBook (Update update){
            SendMessage sendMessage= new SendMessage();
            if (update.hasCallbackQuery()){
                if (update.getCallbackQuery().getData().equals("Arrived truck")){
                    systemParameter="chose Arrived truck";
                } else {
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
                        nameOfWorkBook="";
                        nameOfSheet="";
                        systemParameter="";
                    } else if (systemParameter.equals("chose Sent truck")) {
                        System.out.println("initiation_______________________");
                        WorkWithExel.nameOfWorkBookToSentTruck=nameOfWorkBook;
                        WorkWithExel.nameOfSheetToSentTruck=nameOfSheet;
                        nameOfWorkBook="";
                        nameOfSheet="";
                        systemParameter="";
                    }
                }
            }
            return sendMessage;
        }


    }
}
