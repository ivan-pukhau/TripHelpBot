package org.trip.help.bot.handler;

import org.telegram.telegrambots.meta.api.objects.Update;

public class DefaultMessageHandler implements TelegramMessageHandler {

    @Override
    public void handleMessage(Update update) {
        System.out.println("Default message Handler");
    }
}