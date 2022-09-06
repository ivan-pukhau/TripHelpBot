package org.trip.help.bot;

public class Main {

    private static final String BOT_USER_NAME = "";
    private static final String TOKEN = "";

    public static void main(String[] args) {
        TripHelpBot tripHelpBot = new TripHelpBot(BOT_USER_NAME, TOKEN);
        tripHelpBot.botConnect();
    }
}
