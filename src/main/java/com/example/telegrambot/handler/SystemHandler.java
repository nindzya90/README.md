package com.example.telegrambot.handler;

import com.example.telegrambot.bot.Bot;
import com.example.telegrambot.command.Command;
import com.example.telegrambot.command.ParsedCommand;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class SystemHandler extends AbstractHandler {
    private static final Logger log = Logger.getLogger(SystemHandler.class);
    private final String END_LINE = "\n";

    public SystemHandler(Bot bot) {
        super(bot);
    }

    @Override
    public String operate(String chatId, ParsedCommand parsedCommand, Update update) {
        Command command = parsedCommand.getCommand();

        switch (command) {
            case START:
                bot.sendQueue.add(getMessageStart(chatId));
                break;
            case HELP:
                bot.sendQueue.add(getMessageHelp(chatId));
                break;
            case ID:
                return "Your telegramID: " + update.getMessage().getFrom().getId();
            case STICKER:
                return "StickerID: " + parsedCommand.getText();
            case PASSWORDS1:
                return "101\tУчитель\tRibnayaLavka123#*\n" +
                        "102\tУчитель\tMasnayaLavka123#*\n" +
                        "103\tУчитель\tHlebnayaPolka123#*\n" +
                        "104\tУчитель\tAngliyskiyZavtrak123#*\n" +
                        "105\tУчитель\tOvoshnoyRinok123#*\n" +
                        "106\tУчитель\tMolochniyProdukt123#*\n" +
                        "107\tУчитель\tFruktoviyRinok123#*\n" +
                        "108\tУчитель\tVkusniyObed123#*\n" +
                        "120\tУчитель\tSredniyBall123#*\n" +
                        "120\tУчитель\tDlinnayaLenta123#*\n" +
                        "Спортзал\tУчитель\tKoganniyMyach123#*\n";
            case PASSWORDS2:
                return "201\tУчитель\tBitovayaElektronika123#*\n" +
                        "202\tУчитель\tBitovayaHimiya123#*\n" +
                        "203\tУчитель\tRusskayaKuhnya123#*\n" +
                        "204\tУчитель\tKusichekSira123#*\n" +
                        "205\tУчитель\tSgorevshayaLampa123#*\n" +
                        "206\tУчитель\tSilniyDogdik123#*\n" +
                        "207\tУчитель\tBolshayaLuga123#*\n" +
                        "208\tУчитель\tKrasiviyCvetok123#*\n" +
                        "209\tУчитель\tYasnoeSolnce123#*\n" +
                        "213\tУчитель\tRozoviyZakat123#*\n" +
                        "215\tУчитель\tBelayaBerezka123#*\n" +
                        "217\tУчитель\tSilniyVeter123#*\n" +
                        "219\tУчитель\tBelayaNoch123#*\n" +
                        "Библиотека1\tУчитель\tInteresnieKnigi123#*\n" +
                        "Библиотека2\tУчитель\tPrekrasniyRaskaz123#*\n" +
                        "229\tУчитель\tKrasnayaKniga123#*\n" +
                        "Актовый зал\tУчитель\tKorobkaKonfet123#*\n" +
                        "ОБЖ Трунов\tУчитель\tPolarnayaZvezda123#*\n" +
                        "Лаборантская М.И.\tУчитель\tPustayaKolba123#*\n" +
                        "Лаборантская Е.А.\tУчитель\tVkusniySup123#*\n";
            case PASSWORDS3:
                return "301\tУчитель\tSladkiySahar123#*\n" +
                        "302\tУчитель\tKrepkiyCofe123#*\n" +
                        "303\tУчитель\tGguchiyPerchik123#*\n" +
                        "304\tУчитель\tNastenniyPlakat123#*\n" +
                        "305\tУчитель\tVisokayaStena123#*\n" +
                        "306\tУчитель\tSkolzkiePirila123#*\n" +
                        "307\tУчитель\tSeriyVorobey123#*\n" +
                        "308\tУчитель\tBeloeMore123#*\n" +
                        "312\tУчитель\tVisokiyFlagshtok123#*\n";
            case PASSWORDS4:
                return "401\tУчитель\tLetnayaPora123#*\n" +
                        "405\tУчитель\tSiniyEkran123#*\n" +
                        "406\tУчитель\tListokBumagi123#*\n" +
                        "407\tУчитель\tStihiPushkina123#*\n" +
                        "408\tУчитель\tBeliyProvod123#*\n" +
                        "412\tУчитель\tChistoeNebo123#*\n";
        }
        return "";
    }

    private SendMessage getMessageHelp(String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableMarkdown(true);

        StringBuilder text = new StringBuilder();
        text.append("*Это справочное сообщение*").append(END_LINE).append(END_LINE);
        text.append("[/start](/start) - Показать стартовое сообщение").append(END_LINE);
        text.append("[/help](/help) - показать справочное сообщение").append(END_LINE);
        text.append("[/id](/id) - узнай свой id в телеграмм ").append(END_LINE);
        text.append("/*notify* _time-in-sec_  - получать от меня уведомления по истечении указанного времени").append(END_LINE);
        text.append("[/passwords1](/passwords1) - Пароли от 1 этажа").append(END_LINE);
        text.append("[/passwords2](/passwords2) - Пароли от 2 этажа").append(END_LINE);
        text.append("[/passwords3](/passwords3) - Пароли от 3 этажа").append(END_LINE);
        text.append("[/passwords4](/passwords4) - Пароли от 4 этажа").append(END_LINE);

        sendMessage.setText(text.toString());
        return sendMessage;
    }

    private SendMessage getMessageStart(String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableMarkdown(true);
        StringBuilder text = new StringBuilder();
        text.append("Здравствуй дорогой коллега. Я  *").append(bot.getBotName()).append("*").append(END_LINE);
        text.append("Я умею выдавать пароли от АРМ").append(END_LINE);
        text.append("Все что я умею делать - ты можешь увидеть нажав команду [/help](/help)");
        sendMessage.setText(text.toString());
        return sendMessage;
    }
}
