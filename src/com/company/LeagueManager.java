package com.company;

import java.util.ArrayList;

/**
 * Created by lushi on 05.12.2016.
 */
public interface LeagueManager {
    void addPlauer(SockerPlayer player);        //добавить игрока

    void removePlayer(SockerPlayer player);     //удалить игрока

    SockerPlayer getPlayer(String name);        //получение игрока по фио

    ArrayList<SockerPlayer> getAllPlayers();             //получение массива всех игроков

    ArrayList<SockerPlayer> getPlayers(League league);   //получениемассива игроков, играющих в одной лиге

    ArrayList<SockerPlayer> getPlayers(Country country); //получение массива игроков, происхождением из одной страны

    void addPoints(String name, int points);    //добавление рейтинга, игроку с указанным фио
}
