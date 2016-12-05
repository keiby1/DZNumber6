package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lushi on 05.12.2016.
 */
public class SomeSockerPlayer implements SockerPlayer {
    private String nickNamePlayer;  //ФИО игрока
    private int pointsPlayer;       //Рейтинг
    private League leaguePlayer;    //Лига
    private Country countryPlayer;  //Страна

    SomeSockerPlayer() {            //конструктор без параметров, для самостоятельного ввода ФИО
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО игрока: ");
        nickNamePlayer = scanner.nextLine();
        setRandomInfo();
    }

    SomeSockerPlayer(String name) { // конструктор, для создания игрока с указанным именем
        nickNamePlayer = name;
        setRandomInfo();
    }

    private void setRandomInfo() {  //заполнение полей случайной информацией
        Random random = new Random();

        pointsPlayer = random.nextInt(100) + 1;
        leaguePlayer = League.getRandom();
        countryPlayer = Country.getRandom();
    }

    @Override
    public String getNickName() {   //метод получения имени игрока
        return nickNamePlayer;
    }

    @Override
    public int getPoints() {    //метод получения рейтинга
        return pointsPlayer;
    }

    @Override
    public League getLeague() { //метод для получения лиги
        return leaguePlayer;
    }

    @Override
    public Country getCountry() {   //метод для получения страны
        return countryPlayer;
    }

    public void addPoints(int points) { //метод для увеличения рейтинга
        pointsPlayer += points;
    }

    public void outAllInfo() {   //метод для вывода всей информации об игроке на экран
        System.out.println(nickNamePlayer + " : " + countryPlayer + " : " + leaguePlayer + " : " + pointsPlayer);
    }
}
