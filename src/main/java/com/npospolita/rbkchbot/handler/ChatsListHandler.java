package com.npospolita.rbkchbot.handler;

import com.npospolita.rbkchbot.api.TelegramApi;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class ChatsListHandler implements Handler {

    private static final String COMMAND = "/chats";

    private final TelegramApi api;

    @Value("${rbkch.chats}")
    String chatList;

    @Override
    public boolean canHandle(Update update) {
        Message message = update.message();
        return !StringUtils.isEmpty(message.text())
                &&  message.text().contains(COMMAND);
    }

    @Override
    public void handle(Update update) {
        api.sendMessage(update, chatList);
    }

}
