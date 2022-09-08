package org.trip.help.bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.trip.help.bot.action.Action;
import org.trip.help.bot.handler.AddTripHandler;
import org.trip.help.bot.handler.ButtonHandler;
import org.trip.help.bot.handler.DefaultMessageHandler;
import org.trip.help.bot.handler.HelpMessageHandler;
import org.trip.help.bot.handler.TelegramMessageHandler;
import org.trip.help.bot.repository.TripRepository;

import java.util.UUID;

public class TripHelpBotService {

    private static final String HELP_COMMAND = "/help";
    private static final String BUTTON_COMMAND = "/button";

    private static final String ADD_TRIP_BUTTON_CALLBACK = "add_trip_button";

    private TripRepository tripRepository;

    public TripHelpBotService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public SendMessage processUpdatedMessage(Update message) {
        if (message.hasCallbackQuery()) {
            return processCallbackQuery(message);
        } else if (message.hasMessage()) {
            return processMessage(message);
        } else {
            throw new IllegalStateException("Unsupported message. hasMessage() and hasCallbackQuery() are supported");
        }
    }

    private SendMessage processMessage(Update message) {
        String text = message.getMessage().getText();
        System.out.println("Process message: " + message.getUpdateId() + " : " + text);
        TelegramMessageHandler handler = getCommandHandler(text);
        return handler.handleMessage(message);

    }

    private SendMessage processCallbackQuery(Update message) {
        System.out.println("Process callback query...");
        String text = message.getCallbackQuery().getMessage().getText();
        String data = message.getCallbackQuery().getData();
        System.out.println(text);
        return SendMessage.builder()
                .chatId(message.getCallbackQuery().getMessage().getChatId())
                .text("Callback query")
                .build();
    }

    private TelegramMessageHandler getCommandHandler(String message) {
        if (message.startsWith(HELP_COMMAND)) {
            return new HelpMessageHandler();
        } else if (message.startsWith(BUTTON_COMMAND)) {
            return new ButtonHandler();
        } else {
            return new DefaultMessageHandler();
        }
    }

    private TelegramMessageHandler getActionHandler(String data) {
        /*
        if (data.startsWith(Action.ADD_TRIP)) {

        }
        */
        return new AddTripHandler();
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
