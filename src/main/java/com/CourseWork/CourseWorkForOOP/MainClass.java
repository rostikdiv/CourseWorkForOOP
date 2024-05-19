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
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.starter.TelegramBotStarterConfiguration;




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
        botCommands.add(new BotCommand("/delete_row", "Delete row in sheet"));
        botCommands.add(new BotCommand("/delete_sheet", "Delete sheet in work book"));
        botCommands.add(new BotCommand("/delete_workbook", "Delete work book"));
        botCommands.add(new BotCommand("/get_history_of_truck", "Get history of truck"));
        botCommands.add(new BotCommand("/rename_sheet", "Change the name of sheet"));
        botCommands.add(new BotCommand("/get_workbook", "get workbook"));
        botCommands.add(new BotCommand("/back_to_menu", "beck to menu recommended during incorrect work of bot"));





        try {
            this.execute(new SetMyCommands(botCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpdateReceived(Update update) {

        Message message=update.getMessage();
        SendMessage sendMessage=new SendMessage();

        if(update.hasMessage()&&message.getText().equals("/start")){
            sendMessage.setText("привіт я бот призначений для обліку транспорт в логістичні компанії");
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.welcomeKeyboard());


        } else if (update.hasMessage()&&update.getMessage().getText().equals("/back_to_menu")) {
            InterfaceBackground.WorkWithExelInterface.clear();
            sendMessage=new SendMessage(String.valueOf(update.getMessage().getChatId()),"please enter a new command");

        } else if (update.hasMessage()&&message.getText().equals("/create_excel_workbook")||InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/create_excel_workbook")) {
            sendMessage=InterfaceBackground.WorkWithExelInterface.createWorkBook(update);

        } else if (update.hasMessage()&&message.getText().equals("/create_excel_sheet")||InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/create_excel_sheet")) {
            sendMessage=InterfaceBackground.WorkWithExelInterface.createSheet(update);

        }else if (update.hasMessage()&&message.getText().equals("/choose_sheet_for_work")
                || InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/choose_sheet_for_work")
                || InterfaceBackground.WorkWithExelInterface.systemParameter.equals("chose Arrived truck")
                || InterfaceBackground.WorkWithExelInterface.systemParameter.equals("chose Sent truck")){

            sendMessage=InterfaceBackground.WorkWithExelInterface.choseSheetInWorkBook(update);

        } else if (update.hasMessage()&&message.getText().equals("/add_arrived_truck_to_list")
                ||InterfaceBackground.systemParameter.equals("/add_arrived_truck_to_list")
        ){
            sendMessage=InterfaceBackground.addArrivedTruck(update,listOfArrivedTrucks);

        } else if (update.hasMessage()&&message.getText().equals("/add_sent_truck_to_list")
                ||InterfaceBackground.systemParameter.equals("/add_sent_truck_to_list")

        ){
            sendMessage=InterfaceBackground.addSentTruck(update,listOfSentTrucks);

        } else if (update.hasMessage()&&message.getText().equals("/delete_row")
                || update.hasCallbackQuery()&&InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/delete_row")
                ||update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/delete_row")) {

            sendMessage=InterfaceBackground.WorkWithExelInterface.deleteRow(update);

        } else if (update.hasMessage()&&update.getMessage().getText().equals("/delete_sheet")
        || update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/delete_sheet")) {

            sendMessage=InterfaceBackground.WorkWithExelInterface.deleteSheet(update);

        } else if (update.hasMessage() && update.getMessage().getText().equals("/delete_workbook")
        ||update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/delete_workbook")) {

            sendMessage=InterfaceBackground.WorkWithExelInterface.deleteWorkbook(update);

        } else if (update.hasMessage()&&update.getMessage().getText().equals("/get_history_of_truck")
             ||update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/get_history_of_truck")){

            sendMessage=InterfaceBackground.WorkWithExelInterface.getHistory(update);

        } else if (update.hasMessage() && update.getMessage().getText().equals("/rename_sheet")
        ||update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/rename_sheet")){

            sendMessage=InterfaceBackground.WorkWithExelInterface.renameSheet(update);

        } else if (update.hasMessage()&&update.getMessage().getText().equals("/get_workbook")
                ||update.hasCallbackQuery()&&InterfaceBackground.WorkWithExelInterface.systemParameter.equals("/get_workbook")
                ||InterfaceBackground.WorkWithExelInterface.systemParameter.equals("sendArrived")
                ||InterfaceBackground.WorkWithExelInterface.systemParameter.equals("sendSent")
                ||InterfaceBackground.WorkWithExelInterface.systemParameter.equals("send same workbook")) {

            sendMessage=InterfaceBackground.WorkWithExelInterface.sendWorkBook(update);
            System.out.println("system parametr "+InterfaceBackground.WorkWithExelInterface.systemParameter);
            SendDocument sendDocument=new SendDocument();

            if (InterfaceBackground.WorkWithExelInterface.systemParameter.equals("sendArrived")){
                sendDocument=InterfaceBackground.WorkWithExelInterface.sendExcelDocument(
                        WorkWithExel.nameOfWorkBookToArrivedTruck,String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
                try {
                    execute(sendDocument);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                } finally {
                    InterfaceBackground.WorkWithExelInterface.clear();
                }

            } else if (InterfaceBackground.WorkWithExelInterface.systemParameter.equals("sendSent")) {
                sendDocument=InterfaceBackground.WorkWithExelInterface.sendExcelDocument(
                        WorkWithExel.nameOfWorkBookToSentTruck,String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
                try {
                    execute(sendDocument);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                } finally {
                    InterfaceBackground.WorkWithExelInterface.clear();
                }

            } else if (InterfaceBackground.WorkWithExelInterface.systemParameter.equals("send same workbook")&&!InterfaceBackground.WorkWithExelInterface.nameOfWorkBook.isEmpty()) {
                sendDocument=InterfaceBackground.WorkWithExelInterface.sendExcelDocument(
                        InterfaceBackground.WorkWithExelInterface.nameOfWorkBook,String.valueOf(update.getMessage().getChatId()));
                try {
                    execute(sendDocument);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                } finally {
                    InterfaceBackground.WorkWithExelInterface.clear();
                }

            }


        }

        if (update.hasMessage()&&!sendMessage.getText().equals("not")
                ||update.hasCallbackQuery()&&!sendMessage.getText().equals("not")){
            try {
                execute(sendMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (NullPointerException c){
                c.printStackTrace();
            }
        }

        System.out.println("__________________________________");

    }



}
