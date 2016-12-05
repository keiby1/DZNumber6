package com.company;

;
;

public interface SockerPlayer {
    String getNickName();       //получение ФИО игрока

    int getPoints();            //рейтинг игрока

    League getLeague();         //лига игрока

    Country getCountry();       //страна происхождения

    void addPoints(int points); //увеличение рейтинга

    void outAllInfo();   //выводвсей информации об игроке на экран
}
