package org.trip.help.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.trip.help.bot.repository.TripRepository;

public class AddTripHandler implements TelegramMessageHandler {

    private static final String DELIMETER = "=";
    private static final String START_POINT_KEY = "startPoint";
    private static final String END_POINT_KEY = "endPoint";
    private static final String START_TRIP_DATE_KEY = "startTripDate";
    private static final String END_TRIP_DATE_KEY = "endTripDate";
    private static final String DATE_FORMAT = "DD-MM-YYYY";

    private TripRepository tripRepository;

    public AddTripHandler(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public SendMessage handleMessage(Update update) {
        String message = update.getMessage().getText();
        String startPoint = getStartPoint(message);
        String endPoint = getEndPoint(message);


        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(startPoint + " " + endPoint);
        return sendMessage;
    }

    private String getStartPoint(String message) {
        return getParameterByKey(message, START_POINT_KEY);
    }

    private String getEndPoint(String message) {
        return getParameterByKey(message, END_POINT_KEY);
    }


    private String getParameterByKey(String message, String keyParameter) {
        int startIndex = message.indexOf(keyParameter + DELIMETER);
        int startPointStartIndex = startIndex + keyParameter.length() + DELIMETER.length();
        int endPointEndIndex = message.indexOf(" ", startPointStartIndex);
        String startPoint = message.substring(startPointStartIndex, endPointEndIndex);
        return startPoint;
    }
}
