package com.npospolita.rbkchbot.handler;

import com.npospolita.rbkchbot.api.TelegramApi;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChantHandler implements Handler {

    private static final String COMMAND = "/spartak";

    private final TelegramApi api;

    @Override
    public boolean canHandle(Update update) {
        Message message = update.message();
        return !StringUtils.isEmpty(message.text())
                && (message.text().contains(COMMAND) || (!message.from().isBot() && message.text().toLowerCase().contains("спартак")));
    }

    @Override
    public void handle(Update update) {
        api.sendMessage(update, randomChant());
    }

    private String randomChant() {
        return chants.get(ThreadLocalRandom.current().nextInt(chants.size()));
    }

    private static final List<String> chants = List.of(
            "Так, так! Только так! Атакует наш Спартак!",
            "Эй, Спартак - давай вперёд, Вся Москва победы ждёт!",
            "Посмотри на стадион,\nТам течёт со всех сторон\nКрасно-белая река -\nЭто фаны Спартака!",
            "Красно-белым я родился,\nКрасно-белым я умру,\nА мой адрес в интернете\nКрасно-белый точка ру!",
            "В мире нет еще пока\nКоманды лучше Спартака.",
            "Cпартак - чемпион,\nПобеждает только он.",
            "Спартак московский – могуч!\nСпартак московский – велик!\nСпартак московский – силен!\nОооон – чемпион!",
            "Бойся Европа,\nБойся враг,\nВ бой идет\nМосковский спартак!",
            "Спартак - это сила, Спартак - это класс,\nНарод его любит, в обиду не даст.",
            "Мы ехали, мы верили в наших ребят,\nМы знаем, красно-белые сегодня победят.",
            "Чемпион страны - Спартак,\nБыло, есть и будет так!!!\nААААААААААА второго Спартака,\nААААА не будет никогда !!!",
            "В любую погоду,\nИ в бурю и в зной,\nМосковский Спартак,\nМы будем с тобой!",
            "Пусть кому-то снится сон,\nЧто Динамо чемпион!\nНу а мы во сне видали:\nНаш Спартак на пьедестале!",
            "Хоть ты лопни, хоть ты тресни,\nА Спартак на первом месте!",
            "Футболку храню, шарф берегу,\nВсех забываю, Спартак - не могу!",
            "Спартак - это сила,\nСпартак - это гол,\nСпартак - это фаны,\nЛюбовь и футбол!",
            "Прозвище мясное, золотое\nЗаслужили яркою игрою!\nМедалей звон! Титул чемпион!\nКрасно-белый флаг – реет гордо он!\n",
            "Самый лучший клуб - Спартак,\nКрасно-белый - лучший флаг!\nЧемпион одет всегда\nВ красно-белые цвета!",
            "Вперед Спартак, вперед родной,\nМосква всегда будет с тобой...",
            "От Москвы до Баку -\nВсе проиграли Спартаку!",
            "Пришла пора, пришла пора\nНам разорвать любого гранда.\nФутбол - народная игра,\nСпартак - народная команда.",
            "Мы в холодной воде не тонем!\nИ в огне никогда не горим!\nМы спартаковские фанаты\nИ Спартак наш непобедим!",
            "Поднимайте красный флаг,\nМы болеем за Спартак.",
            "Россия-мать жива, пока\nИдёт игра у Спартака.",
            "От Москвы до Бреста\nНет такого места\nГде бы не выигрывал Спартак,\nВот так!",
            "Как ласточка в небе,\nКак в море маяк,\nВ российском футболе -\nМосковский Спартак!",
            "И во сне и на яву,\nЗа Спартак я пасть порву!!!",
            "Наш Спартак - великий клуб,\nЭто знают все вокруг!!!",
            "Родился ребенок и сделал свой шаг,\nИ первое слово - \"московский Спартак\"!\nРодился второй и взял микрофон,\nИ первое слово - \"Спартак - Чемпион\"!\nЕще он сказал: как прекрасна планета,\nКогда она вся красно-белого цвета.",
            "Боже Cпартак храни,\nДай ему силы,\nЧтоб победил он все клубы страны.\nБоже Спартак храни,\nДай ему силы,\nЧтоб победил он во имя Москвы.",
            "Больше побед и красивых атак!\nЛучшая в мире команда Спартак!",
            "Кто болеет за Спартак -\nУ того дела ништяк.",
            "Месяц - для ночи,\nСолнце - для дня,\nСвет - для природы,\nСпартак - для меня!",
            "Он - российский, он - народный,\nКаждый знает - это так!\nОн - как рыцарь благородный,\nНаш кумир - родной Спартак!",
            "Морем и рыбой пахнет рыбак\nЗолотом пахнет московский Спартак!",
            "Чтобы пенальти метко бить,\nНадо \"Спатрак - колу\" пить!",
            "Земля - крестьянам, Фабрики - рабочим,\nА у Спартака нет своего стадиона, между прочим.",
            "Меркнет свет,\nВся жизнь - не так,\nЕсли проиграл “Спартак”!",
            "Вперед, вперед Спартак,\nКрасно-белый флаг\nРеет над страной.\nНавсегда, навсегда\nМы с тобой!",
            "Все может быть, все может статься,\nС женой может муж расстаться,\nМы можем бросить пить, курить,\nНо чтоб Спартак нам разлюбить?\nНет! Этого не может быть!",
            "Легче Тайсона побить,\nЧем Спартак наш победить!");
}
