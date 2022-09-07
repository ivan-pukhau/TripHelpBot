package org.trip.help.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpMessageHandler implements TelegramMessageHandler {

    @Override
    public SendMessage handleMessage(Update update) {
        System.out.println("Handle help message: " + update.getUpdateId());
        return SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text("helpMessageHandler. " + update.getMessage().getText())
                .build();
    }
}
