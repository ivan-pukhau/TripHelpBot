package org.trip.help.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.menubutton.MenuButton;
import org.telegram.telegrambots.meta.api.objects.menubutton.MenuButtonCommands;
import org.telegram.telegrambots.meta.api.objects.menubutton.MenuButtonDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.trip.help.bot.action.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ButtonHandler implements TelegramMessageHandler {
    @Override
    public SendMessage handleMessage(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setText("Configure trip.");
        message.setChatId(update.getMessage().getChatId());

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> buttons = new ArrayList<>();
        InlineKeyboardButton addTripButton= new InlineKeyboardButton("Add my trip");
        addTripButton.setCallbackData(Action.ADD_TRIP.toString() + UUID.randomUUID() + "Vitebsk Minsk Lodz");
        addTripButton.setText("ffffffffffff");
        buttons.add(addTripButton);

        InlineKeyboardButton testButton = new InlineKeyboardButton("Find trip");
        testButton.setCallbackData("test_callback");
        buttons.add(testButton);

        MenuButtonCommands buttonCommands = MenuButtonCommands.builder()
                .build();


        keyboard.add(buttons);
        inlineKeyboardMarkup.setKeyboard(keyboard);

        message.setReplyMarkup(inlineKeyboardMarkup);
        return message;
    }
}
