package com.company;

import java.util.Random;

/**
 * Created by lushi on 05.12.2016.
 */
enum Country {   //перечисление стран
    Австралия,
    Австрия,
    Бельгия,
    Белоруссия,
    Въетнам,
    Греция,
    Египет,
    Индия,
    Ирак,
    Казахстан,
    Канада,
    Китай,
    Литва,
    Мексика,
    Россия,
    США,
    Турция;

    public static Country getRandom() {//метод для получения случайной страны
        Random random = new Random();
        return values()[random.nextInt(Country.values().length)];
    }
}
