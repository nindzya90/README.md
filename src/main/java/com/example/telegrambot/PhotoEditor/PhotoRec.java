package com.example.telegrambot.PhotoEditor;

import org.telegram.telegrambots.api.objects.Update;

public interface PhotoRec {
    void onUpdateReceived(Update update);
}
