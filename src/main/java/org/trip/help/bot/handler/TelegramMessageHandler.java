package org.trip.help.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramMessageHandler {

    SendMessage handleMessage(Update update);
}
