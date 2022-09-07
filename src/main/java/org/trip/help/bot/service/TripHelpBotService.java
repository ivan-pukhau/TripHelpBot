package org.trip.help.bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.trip.help.bot.handler.ButtonHandler;
import org.trip.help.bot.handler.DefaultMessageHandler;
import org.trip.help.bot.handler.HelpMessageHandler;
import org.trip.help.bot.handler.TelegramMessageHandler;
import org.trip.help.bot.repository.TripRepository;

import java.util.UUID;

public class TripHelpBotService {

    private static final String HELP_MESSAGE = "/help";
    private static final String BUTTON_MESSAGE = "/button";

    private TripRepository tripRepository;

    public TripHelpBotService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public SendMessage processMessage(Update message) {
        String text = message.getMessage().getText();
        System.out.println("Process message: " + message.getUpdateId() + " : " + text);
        TelegramMessageHandler handler = getHandler(text);
        return handler.handleMessage(message);

    }

    private TelegramMessageHandler getHandler(String message) {
        if (message.startsWith(HELP_MESSAGE)) {
            return new HelpMessageHandler();
        } else if (message.startsWith(BUTTON_MESSAGE)) {
            return new ButtonHandler();
        } else {
            return new DefaultMessageHandler();
        }
    }

    private String addTrip(Update message) {
        System.out.println("Try to add trip. Message: " + message.getUpdateId());
        return UUID.randomUUID().toString();
    }

    private String removeTrip(Update message) {
        System.out.println("Try to remove trip. Message: " + message.getUpdateId());
        return UUID.randomUUID().toString();
    }


}
