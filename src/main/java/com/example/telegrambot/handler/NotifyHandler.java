package com.example.telegrambot.handler;

import com.example.telegrambot.ability.Notify;
import com.example.telegrambot.bot.Bot;
import com.example.telegrambot.command.ParsedCommand;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.objects.Update;

public class NotifyHandler extends AbstractHandler {
    private static final Logger log = Logger.getLogger(NotifyHandler.class);

    public NotifyHandler(Bot bot) {
        super(bot);
    }

    @Override
    public String operate(String chatId, ParsedCommand parsedCommand, Update update) {
        String text = parsedCommand.getText();
        if ("".equals(text))
            return "You must specify the delay time. Like this:\n" +
                    "/notify 30";
        long timeInSec;
        String WRONG_INPUT_MESSAGE = "Wrong input. Time must be specified as an integer greater than 0";
        try {
            timeInSec = Long.parseLong(text.trim());
        } catch (NumberFormatException e) {
            return WRONG_INPUT_MESSAGE;
        }
        if (timeInSec > 0) {
            long MILLISEC_IN_SEC = 1000;
            Thread thread = new Thread(new Notify(bot, chatId, timeInSec * MILLISEC_IN_SEC));
            thread.start();
        } else return WRONG_INPUT_MESSAGE;
        return "";
    }
}