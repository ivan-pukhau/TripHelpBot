package org.trip.help.bot.service;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.trip.help.bot.handler.DefaultMessageHandler;
import org.trip.help.bot.handler.HelpMessageHandler;
import org.trip.help.bot.handler.TelegramMessageHandler;
import org.trip.help.bot.repository.TripRepository;

import java.util.UUID;

public class TripHelpBotService {

    private static final String HELP_MESSAGE = "/help";

    private TripRepository tripRepository;

    public TripHelpBotService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public void processMessage(Update message) {
        String text = message.getMessage().getText();
        System.out.println("Process message: " + message.getUpdateId() + " : " + text);
        TelegramMessageHandler handler = getHandler(text);
        handler.handleMessage(message);
    }

    private TelegramMessageHandler getHandler(String message) {
        if (message.startsWith(HELP_MESSAGE)) {
            return new HelpMessageHandler();
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
