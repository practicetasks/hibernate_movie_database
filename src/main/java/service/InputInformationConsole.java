package service;

import model.Actor;
import model.Director;
import model.Movie;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InputInformationConsole {
    private final Scanner scanner;

    public InputInformationConsole() {
        scanner = new Scanner(System.in);
    }

    public int printMenu() {
        System.out.println("1. Вывести фильмы на печать");
        System.out.println("2. Добавить новый фильм");
        System.out.println("3. Удалить фильм");
        System.out.println("4. Обновить данные о фильме");
        System.out.println("5. Поиск по названию");
        System.out.println("6. Поиск по имени актера");
        System.out.println("7. Поиск по имени режиссера");
        System.out.println("8. Поиск по годам");
        System.out.println("9. Вывести топ-10 фильмов");
        System.out.println("10. Вывести всех актеров");
        System.out.println("11. Вывести всех режиссеров");
        System.out.println("0. Выход");

        return Integer.parseInt(scanner.nextLine());
    }

    public void printMovies(List<Movie> movies) {
        movies.forEach(System.out::println);
    }

    public void printActors(List<Actor> actors) {
        actors.forEach(System.out::println);
    }

    public void printDirectors(List<Director> directors) {
        directors.forEach(System.out::println);
    }

    public String getDirectorName() {
        System.out.println("Введите имя режиссера: ");
        return scanner.nextLine();
    }

    public String getActorName() {
        System.out.println("Введите имя актера: ");
        return scanner.nextLine();
    }

    public String getTitle() {
        System.out.println("Введите название фильма: ");
        return scanner.nextLine();
    }

    public int getYear() {
        System.out.println("Введите год выпуска: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public double getRating() {
        System.out.println("Введите рейтинг: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public int getRandomCount() {
        return new Random().nextInt(51);
    }
}
