package com.CourseWork.CourseWorkForOOP;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
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

    @Override
    public void onUpdateReceived(Update update) {
        InterfaceBackground interfaceBackground=new InterfaceBackground();
        Message message=update.getMessage();
        SendMessage sendMessage=new SendMessage();



        if(update.hasMessage()&&message.getText().equals("/start")){
            sendMessage.setText("привіт я бот призначений для обліку транспорт в логістичні компанії");
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.welcomeKeyboard());

        } else if (update.hasMessage()&&message.getText().equals("create exel work book")||InterfaceBackground.WorkWithExelInterface.systemParameter.equals("create exel work book")) {
            sendMessage=InterfaceBackground.WorkWithExelInterface.createWorkBook(update);
        } else if (update.hasMessage()&&message.getText().equals("create exel sheet")||InterfaceBackground.WorkWithExelInterface.systemParameter.equals("create exel sheet")) {
            sendMessage=InterfaceBackground.WorkWithExelInterface.createSheet(update);
        }else if (update.hasMessage()&&message.getText().equals("chose sheet for work")){
            sendMessage=new SendMessage(String.valueOf(message.getChatId()),"do you wanna chose sheet for Arrived truck or Sent truck");
            sendMessage.setReplyMarkup(InterfaceBackground.Keyboard.toChoseWorkBookAndSheet());
        } else if (update.hasMessage()&&message.getText().equals("Add arrived truck to list")
                ||InterfaceBackground.systemParameter.equals("Add arrived truck to list")&&!listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).isTruckNumberInitiated()
                ||InterfaceBackground.systemParameter.equals("Add arrived truck to list")&&!listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).isArrivedFromInitiated()
                ||InterfaceBackground.systemParameter.equals("Add arrived truck to list")&&!listOfArrivedTrucks.get(listOfArrivedTrucks.getSize()-1).isWeightOfTruckInitiated()
        ){
            sendMessage=InterfaceBackground.addArrivedTruck(update,listOfArrivedTrucks);
        } else if (update.hasMessage()&&message.getText().equals("Add sent truck to list")
                ||InterfaceBackground.systemParameter.equals("Add sent truck to list")&&!listOfSentTrucks.get(listOfSentTrucks.getSize()-1).isTruckNumberInitiated()
                ||InterfaceBackground.systemParameter.equals("Add sent truck to list")&&!listOfSentTrucks.get(listOfSentTrucks.getSize()-1).isSentToInitiated()
                ||InterfaceBackground.systemParameter.equals("Add sent truck to list")&&!listOfSentTrucks.get(listOfSentTrucks.getSize()-1).isWeightOfTruckInitiated()
        ){
            sendMessage=InterfaceBackground.addSentTruck(update,listOfSentTrucks);
        }

        if (update.hasCallbackQuery()&&update.getCallbackQuery().getData().equals("Arrived truck")
        || update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.systemParameter.equals("chose Arrived truck")){
            sendMessage=InterfaceBackground.WorkWithExelInterface.choseSheetInWorkBook(update);
        } else if (update.hasCallbackQuery()&&update.getCallbackQuery().getData().equals("Sent truck")
                || update.hasMessage()&&InterfaceBackground.WorkWithExelInterface.systemParameter.equals("chose Sent truck")) {
            sendMessage=InterfaceBackground.WorkWithExelInterface.choseSheetInWorkBook(update);

        }

        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        System.out.println("__________________________________");

    }



}
