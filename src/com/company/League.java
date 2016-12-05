package com.company;

import java.util.Random;

/**
 * Created by lushi on 05.12.2016.
 */
enum League {   //перечисление лиг
    Лудогорец,
    Бавария,
    Мадрид,
    Базель,
    Арсенал,
    ПСВ,
    Ростов,
    Барселона,
    ЦСКА,
    Монако;

    public static League getRandom() {//метод для получения случайной лиги
        Random random = new Random();
        return values()[random.nextInt(League.values().length)];
    }
}
