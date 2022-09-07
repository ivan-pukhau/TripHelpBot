package org.trip.help.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class ButtonHandler implements TelegramMessageHandler {
    @Override
    public SendMessage handleMessage(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setText("Inline model below.");
        message.setChatId(update.getMessage().getChatId());

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        // Create the keyboard (list of InlineKeyboardButton list)
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        // Create a list for buttons
        List<InlineKeyboardButton> Buttons = new ArrayList<InlineKeyboardButton>();
        // Initialize each button, the text must be written
        InlineKeyboardButton youtube= new InlineKeyboardButton("youtube");
        // Also must use exactly one of the optional fields,it can edit  by set method
        youtube.setUrl("https://www.youtube.com");
        // Add button to the list
        Buttons.add(youtube);
        // Initialize each button, the text must be written
        InlineKeyboardButton github= new InlineKeyboardButton("github");
        // Also must use exactly one of the optional fields,it can edit  by set method
        github.setUrl("https://github.com");
        // Add button to the list
        Buttons.add(github);
        keyboard.add(Buttons);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(inlineKeyboardMarkup);

        return message;
    }
}
