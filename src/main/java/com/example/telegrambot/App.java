package com.example.telegrambot;

import com.example.telegrambot.bot.Bot;
import com.example.telegrambot.service.MessageReciever;
import com.example.telegrambot.service.MessageSender;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.api.methods.send.SendMessage;

public class App {
    private static final Logger log = Logger.getLogger(App.class);
    private static final int PRIORITY_FOR_SENDER = 1;
    private static final int PRIORITY_FOR_RECEIVER = 3;
    private static final String BOT_ADMIN = "297258904";

    public static void main(String[] args) {
        ApiContextInitializer.init();
        Bot TestJava_bot = new Bot("TestJava_bot", "5292457825:AAEiB2jIsAB-3fYZ3QDSr-1TZSB53vRLmsA");

        MessageReciever messageReciever = new MessageReciever(TestJava_bot);
        MessageSender messageSender = new MessageSender(TestJava_bot);

        TestJava_bot.botConnect();

        Thread receiver = new Thread(messageReciever);
        receiver.setDaemon(true);
        receiver.setName("MsgReciever");
        receiver.setPriority(PRIORITY_FOR_RECEIVER);
        receiver.start();

        Thread sender = new Thread(messageSender);
        sender.setDaemon(true);
        sender.setName("MsgSender");
        sender.setPriority(PRIORITY_FOR_SENDER);
        sender.start();

        sendStartReport(TestJava_bot);
    }

    private static void sendStartReport(Bot bot) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(BOT_ADMIN);
        sendMessage.setText("Запустился");
        bot.sendQueue.add(sendMessage);
    }
}
