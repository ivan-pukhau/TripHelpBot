package org.trip.help.bot.handler;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramMessageHandler {

    void handleMessage(Update update);
}
