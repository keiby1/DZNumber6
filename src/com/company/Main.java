package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void outAllPlayers(LeagueManager leagueManager) {
        /*
        Вывод списка всех игроков на экран в формате: ФИО:Страна:Лига:Рейтинг
         */
        ArrayList<SockerPlayer> listPlayer = new ArrayList<>();
        listPlayer = leagueManager.getAllPlayers();
        for (SockerPlayer iter : listPlayer) {
            iter.outAllInfo();
        }
    }

    public static void outRatingCountry(LeagueManager leagueManager) {
        /*
        Метод выводящий список игроков в зависимости от страны раждения, в порядке убывания рейтинга
         */
        ArrayList<SockerPlayer> listPlayers;
        int maxPoints, indexPlayer = 0;
        String nickNamePlayer;
        for (int i = 0; i < Country.values().length; i++) {
            System.out.println("Страна: " + Country.values()[i]);
            listPlayers = leagueManager.getPlayers(Country.values()[i]);
            if (listPlayers.isEmpty())
                System.out.println("Нет игроков!");
            else
                while (!listPlayers.isEmpty()) {
                    maxPoints = listPlayers.get(0).getPoints();
                    indexPlayer = 0;
                    nickNamePlayer = listPlayers.get(0).getNickName();

                    for (int j = 0; j < listPlayers.size(); j++) {
                        if (listPlayers.get(j).getPoints() > maxPoints) {
                            maxPoints = listPlayers.get(j).getPoints();
                            nickNamePlayer = listPlayers.get(j).getNickName();
                            indexPlayer = j;
                        }
                    }
                    System.out.println(nickNamePlayer + " : " + maxPoints);
                    listPlayers.remove(indexPlayer);
                }
        }
    }

    public static void outRatingLeague(LeagueManager leagueManager) {
        /*
        Метод вывода игроков в зависимости от лиги, в порядке убывания баллов
         */

        ArrayList<SockerPlayer> listPlayers;
        int maxPoints, indexPlayer = 0;
        String nickNamePlayer;

        for (int i = 0; i < League.values().length; i++) {
            System.out.println("Лига: " + League.values()[i]);
            listPlayers = leagueManager.getPlayers(League.values()[i]);
            if (listPlayers.isEmpty())
                System.out.println("Нет игроков!");
            else
                while (!listPlayers.isEmpty()) {
                    maxPoints = listPlayers.get(0).getPoints();
                    indexPlayer = 0;
                    nickNamePlayer = listPlayers.get(0).getNickName();

                    for (int j = 0; j < listPlayers.size(); j++) {
                        if (listPlayers.get(j).getPoints() > maxPoints) {
                            maxPoints = listPlayers.get(j).getPoints();
                            nickNamePlayer = listPlayers.get(j).getNickName();
                            indexPlayer = j;
                        }
                    }
                    System.out.println(nickNamePlayer + " : " + maxPoints);
                    listPlayers.remove(indexPlayer);
                }
        }
    }

    public static void removePlayer(LeagueManager leagueManager) {
        /*
        Метод для удаления игрока. Поиск удаляемого игрока осуществляется по имени.
         */
        Scanner scanner = new Scanner(System.in);
        String nickNamePlayer;
        System.out.println("Введите ФИО игрока для удаления: ");
        nickNamePlayer = scanner.nextLine();

        SockerPlayer somePlayer = leagueManager.getPlayer(nickNamePlayer);
        if (somePlayer != null) {
            leagueManager.removePlayer(somePlayer);
            System.out.println("Игрок удалён!");
        } else
            System.out.println("Игрок не найден!");
    }

    public static void addRating(LeagueManager leagueManager) {
        /*
        Метод для увеличениярейтинга выбранному игроку на указанное вол-во баллов.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите фИО игрока: ");
        String nickName = scanner.nextLine();
        System.out.print("Введите баллы: ");
        int points = scanner.nextInt();
        leagueManager.addPoints(nickName, points);
    }

    public static void addPlayer(LeagueManager leagueManager) {
        /*
        Метод для добавления игрока. Перед добавлением проверяется уникальность ФИО.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО игрока: ");
        String nickNamePlayer = scanner.nextLine();
        if (leagueManager.getPlayer(nickNamePlayer) != null)
            System.out.println("Игрок с таким именем уже есть!");

        else {
            leagueManager.addPlauer(new SomeSockerPlayer(nickNamePlayer));
            System.out.println("Игрок добавлен!");
        }

    }

    public static void Menu(LeagueManager leagueManager) {
        /*
        Метод отображающий меню действий, которые может совершать пользователь.
         */
        Scanner scanner = new Scanner(System.in);
        int key;
        boolean exit = false;
        while (!exit) {
            System.out.println("\n0-Вывести всех игроков на экран");
            System.out.println("1-Вывести рейтинг игроков для каждой страны");
            System.out.println("2-Вывести рейтинг игроков для каждой лиги");
            System.out.println("3-Добавить игрока");
            System.out.println("4-Удалить игрока");
            System.out.println("5-Увеличить рейтинг игрока");
            System.out.println("6-Выход");
            System.out.print(">> ");
            key = scanner.nextInt();

            switch (key) {
                case 0:
                    outAllPlayers(leagueManager);
                    break;
                case 1:
                    outRatingCountry(leagueManager);
                    break;
                case 2:
                    outRatingLeague(leagueManager);
                    break;
                case 3:
                    addPlayer(leagueManager);
                    break;
                case 4:
                    removePlayer(leagueManager);
                    break;
                case 5:
                    addRating(leagueManager);
                    break;
                case 6:
                    exit = true;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        /*
            В данном методе выполняется создание менеджера лиги, начальная инициализация списка игроков, вызов метода Меню.
        */
        Scanner scanner = new Scanner(System.in);
        SomeLeagueManager leagueManager = new SomeLeagueManager();
        System.out.print("Введите начальное число игроков: ");
        int n = scanner.nextInt();
        System.out.print("1 - Заполнить имена игроков автоматически(неповторяющиеся числа)\n2 - Ввести вручную: \n>> ");
        int key = scanner.nextInt();
        if (key == 1)
            for (int i = 0; i < n; i++)
                leagueManager.addPlauer(new SomeSockerPlayer(Integer.toString(i)));
        else
            for (int i = 0; i < n; i++)
                leagueManager.addPlauer(new SomeSockerPlayer());

        Menu(leagueManager);

    }
}
