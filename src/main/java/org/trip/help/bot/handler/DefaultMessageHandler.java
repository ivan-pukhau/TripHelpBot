package org.trip.help.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class DefaultMessageHandler implements TelegramMessageHandler {

    @Override
    public SendMessage handleMessage(Update update) {
        System.out.println("Default message Handler");
        return SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text("defaultMessageHandler. " + update.getMessage().getText())
                .build();
    }
}
