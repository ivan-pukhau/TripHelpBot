package org.trip.help.bot;

public class Main {

    private static final String BOT_USER_NAME = "CompanyTripHelpBot";
    private static final String TOKEN = "5506163364:AAFnlsPeaRCDYFlLF-bY06R2WZ3KVw8Zd6s";

    public static void main(String[] args) {
        TripHelpBot tripHelpBot = new TripHelpBot(BOT_USER_NAME, TOKEN);
        tripHelpBot.botConnect();
    }
}
