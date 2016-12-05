package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lushi on 05.12.2016.
 */
public class SomeLeagueManager implements LeagueManager {
    Scanner sc = new Scanner(System.in);
    private ArrayList<SockerPlayer> listSockerPlayer = new ArrayList<>();   //список игроков

    @Override
    public void addPlauer(SockerPlayer player) {    //метод для добавления игрока
        listSockerPlayer.add(player);
    }

    @Override
    public void removePlayer(SockerPlayer player) { //метод для удаления игрока
        listSockerPlayer.remove(player);
    }

    @Override
    public SockerPlayer getPlayer(String name) {    //метод для получения игрока, по известному ФИО
        for (SockerPlayer iter : listSockerPlayer)
            if (iter.getNickName().equals(name))
                return iter;
        return null;
    }

    @Override
    public ArrayList<SockerPlayer> getAllPlayers() { //получение списка всех игроков
        return listSockerPlayer;
    }

    @Override
    public ArrayList<SockerPlayer> getPlayers(League league) { //получение списка игрков играющих в одной лиге
        ArrayList<SockerPlayer> oneLeaguePlayers = new ArrayList<>();
        for (SockerPlayer iter : listSockerPlayer)
            if (iter.getLeague().equals(league))
                oneLeaguePlayers.add(iter);

        return oneLeaguePlayers;
    }

    @Override
    public ArrayList<SockerPlayer> getPlayers(Country country) { //получение списка игроков родом из одной страны
        ArrayList<SockerPlayer> oneCountryPlayers = new ArrayList<>();
        for (SockerPlayer iter : listSockerPlayer)
            if (iter.getCountry().equals(country))
                oneCountryPlayers.add(iter);

        return oneCountryPlayers;
    }

    @Override
    public void addPoints(String name, int points) { //метод для увеличения рейтинга игрока
        for (SockerPlayer iter : listSockerPlayer)
            if (iter.getNickName().equals(name)) {
                iter.addPoints(points);
                break;
            }
    }
}
