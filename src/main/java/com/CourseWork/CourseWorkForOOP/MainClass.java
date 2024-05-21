package com.CourseWork.CourseWorkForOOP;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;





import java.util.ArrayList;
import java.util.List;


@Component
public class MainClass extends TelegramLongPollingBot {

    public String getBotUsername() {
        return "accounting_system_Bot";
    }

    @Override
    public String getBotToken() {
        return "6860097644:AAHLIyZk8DU3etF4jvj8bW7fiqVfDk_j1co";
    }
    ListOfArrivedTrucks listOfArrivedTrucks=new ListOfArrivedTrucks();
    ListOfSentTrucks listOfSentTrucks=new ListOfSentTrucks();
    public MainClass() {
        ArrayList<BotCommand> botCommands = new ArrayList<>();
        botCommands.add(new BotCommand("/create_excel_workbook", "Create Excel workbook"));
        botCommands.add(new BotCommand("/create_excel_sheet", "Create Excel sheet"));
        botCommands.add(new BotCommand("/choose_sheet_for_work", "Choose sheet for work"));
        botCommands.add(new BotCommand("/add_arrived_truck_to_list", "Add arrived truck to list"));
        botCommands.add(new BotCommand("/add_sent_truck_to_list", "Add sent truck to list"));
        botCommands.add(new BotCommand("/delete_workbook", "Delete work book"));
        botCommands.add(new BotCommand("/delete_sheet", "Delete sheet in work book"));
        botCommands.add(new BotCommand("/delete_row", "Delete row in sheet"));
        botCommands.add(new BotCommand("/get_history_of_truck", "Get history of truck"));
        botCommands.add(new BotCommand("/rename_sheet", "Change the name of sheet"));
        botCommands.add(new BotCommand("/get_workbook", "get workbook"));
        botCommands.add(new BotCommand("/back_to_menu", "beck to menu recommended during incorrect work of bot"));
        botCommands.add(new BotCommand("/help", "info about commands"));






        try {
            this.execute(new SetMyCommands(botCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()&&update.getMessage().hasText()){
            System.out.println("update has message "+update.getMessage().getText()+"\n");
        } else if (update.hasCallbackQuery()&&update.getCallbackQuery().getMessage().hasText()) {
            System.out.println("update has callbackData "+update.getCallbackQuery().getMessage().getText()+"\n");
        }

        Message message=update.getMessage();
        SendMessage sendMessage=new SendMessage();

        if(update.hasMessage()&&message.getText().equals("/start")){
            sendMessage=InterfaceBackground.WorkWithExelInterface.startMessage(update);

        } else if (update.hasMessage()&&message.getText().equals("/help")) {
            sendMessage=InterfaceBackground.WorkWithExelInterface.helpInfo(update);

        } else if (update.hasMessage()&&update.getMessage().getText().equals("/back_to_menu")) {
            InterfaceBackground.WorkWithExelInterface.clear();
            sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter a new command");

        } else if (update.hasMessage()&&message.getText().equals("/create_excel_workbook")||InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/create_excel_workbook")) {
            sendMessage=InterfaceBackground.WorkWithExelInterface.createWorkBook(update);

        } else if (update.hasMessage()&&message.getText().equals("/create_excel_sheet")||InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/create_excel_sheet")) {
            sendMessage=InterfaceBackground.WorkWithExelInterface.createSheet(update);

        }else if (update.hasMessage()&&message.getText().equals("/choose_sheet_for_work")
                || InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/choose_sheet_for_work")
                || InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("chose Arrived truck")
                || InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("chose Sent truck")){

            sendMessage=InterfaceBackground.WorkWithExelInterface.choseSheetInWorkBook(update);

        } else if (update.hasMessage()&&message.getText().equals("/add_arrived_truck_to_list")
                ||InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/add_arrived_truck_to_list")
        ){
            sendMessage=InterfaceBackground.WorkWithExelInterface.addTruck(update,listOfArrivedTrucks);

        } else if (update.hasMessage()&&message.getText().equals("/add_sent_truck_to_list")
                ||InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/add_sent_truck_to_list")

        ){
            sendMessage=InterfaceBackground.WorkWithExelInterface.addTruck(update,listOfSentTrucks);

        } else if (update.hasMessage()&&message.getText().equals("/delete_row")
                ||InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/delete_row")) {

            sendMessage=InterfaceBackground.WorkWithExelInterface.deleteRow(update);

        } else if (update.hasMessage()&&update.getMessage().getText().equals("/delete_sheet")
        || update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/delete_sheet")) {

            sendMessage=InterfaceBackground.WorkWithExelInterface.deleteSheet(update);

        } else if (update.hasMessage() && update.getMessage().getText().equals("/delete_workbook")
        ||update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/delete_workbook")) {
            sendMessage=InterfaceBackground.WorkWithExelInterface.deleteWorkbook(update);

        } else if (update.hasMessage()&&update.getMessage().getText().equals("/get_history_of_truck")
             ||InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/get_history_of_truck")){

            sendMessage=InterfaceBackground.WorkWithExelInterface.getHistory(update);

        } else if (update.hasMessage() && update.getMessage().getText().equals("/rename_sheet")
        ||update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/rename_sheet")){

            sendMessage=InterfaceBackground.WorkWithExelInterface.renameSheet(update);

        } else if (update.hasMessage()&&update.getMessage().getText().equals("/get_workbook")
                ||update.hasCallbackQuery()&&InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("/get_workbook")
                ||InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("sendArrived")
                ||InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("sendSent")
                ||InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("send same workbook")) {

            sendMessage=InterfaceBackground.WorkWithExelInterface.sendWorkBook(update);

            SendDocument sendDocument=new SendDocument();

            if (InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("sendArrived")){
                sendDocument=InterfaceBackground.WorkWithExelInterface.sendExcelDocument(
                        WorkWithExel.getNameOfWorkBookToSentTruck(),String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
                try {
                    execute(sendDocument);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                } finally {
                    InterfaceBackground.WorkWithExelInterface.clear();
                }

            } else if (InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("sendSent")) {
                sendDocument=InterfaceBackground.WorkWithExelInterface.sendExcelDocument(
                        WorkWithExel.getNameOfWorkBookToSentTruck(),String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
                try {
                    execute(sendDocument);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                } finally {
                    InterfaceBackground.WorkWithExelInterface.clear();
                }

            } else if (InterfaceBackground.WorkWithExelInterface.getSystemParameter().equals("send same workbook")
                    &&!InterfaceBackground.WorkWithExelInterface.getNameOfWorkBook().isEmpty()) {

                sendDocument=InterfaceBackground.WorkWithExelInterface.sendExcelDocument(
                        InterfaceBackground.WorkWithExelInterface.getNameOfWorkBook(),String.valueOf(update.getMessage().getChatId()));
                try {
                    execute(sendDocument);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                } finally {
                    InterfaceBackground.WorkWithExelInterface.clear();
                }

            }


        }

        if (sendMessage.getChatId()!=null){
            try {
                try{
                    execute(sendMessage);
                }catch (NullPointerException c){
                    System.out.println("_-_-_-_-_-_-");
                    c.printStackTrace();
                }

            } catch (TelegramApiException e) {
                e.printStackTrace();
                System.out.println("-_-_");

            }
        }

        System.out.println("__________________________________");

    }



}
