package org.trip.help.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.trip.help.bot.repository.TripRepository;
import org.trip.help.bot.service.TripHelpBotService;

public class TripHelpBot extends TelegramLongPollingBot {

    private final String token;
    private final String botName;
    private final TripHelpBotService tripHelpBotService;
    private final TripRepository tripRepository;

    public TripHelpBot(String botName, String token) {
        this.botName = botName;
        this.token = token;
        tripRepository = new TripRepository();
        tripHelpBotService = new TripHelpBotService(tripRepository);

    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("OnUpdateReceived: " + update.getUpdateId());
        SendMessage result = tripHelpBotService.processUpdatedMessage(update);
        try {
            execute(result);
        } catch (TelegramApiException e) {
            System.out.println("TelegramApiException: " + e.getClass().getName() + " : " + e.getMessage());
        }

    }

    @Override
    public String getBotUsername() {
        return botName;
    }


    public void botConnect() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(this);

            System.out.println("TelegramAPI started. Look for messages");
        } catch (TelegramApiException e) {
            System.out.println("Can't Connect. Pause : " + e.getMessage());
        }
    }
}
