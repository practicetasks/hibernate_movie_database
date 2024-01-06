package service;

import dao.ActorDao;
import dao.DirectorDao;
import dao.MovieDao;
import model.Movie;

public class DatabaseService {
    private final InputInformationConsole information = new InputInformationConsole();

    public void start() {
        while (true) {
            int command = information.printMenu();
            switch (command) {
                case 0 -> {
                    return;
                }
                case 1 -> printMovies();
                case 2 -> addMovie();
                case 3 -> deleteMovie();
                case 4 -> updateMovie();
                case 5 -> findByTitle();
                case 6 -> findByActorName();
                case 7 -> findByDirectorName();
                case 8 -> findByYear();
                case 9 -> getTop10();
                case 10 -> printActors();
                case 11 -> printDirectors();
                default -> System.out.println("Неизвестный пункт меню");
            }
        }
    }

    private void getTop10() {
        try (MovieDao movieDao = new MovieDao()) {
            information.printMovies(movieDao.getTop10());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findByYear() {
        try (MovieDao movieDao = new MovieDao()) {
            int year = information.getYear();
            information.printMovies(movieDao.findByYear(year));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findByDirectorName() {
        try (MovieDao movieDao = new MovieDao()) {
            String directorName = information.getDirectorName();
            information.printMovies(movieDao.filterByDirector(directorName));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findByActorName() {
        try (MovieDao movieDao = new MovieDao()) {
            String actorName = information.getActorName();
            information.printMovies(movieDao.filterByActorName(actorName));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findByTitle() {
        try (MovieDao movieDao = new MovieDao()) {
            String title = information.getTitle();
            Movie movie = movieDao.getByTitle(title);
            System.out.println(movie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addMovie() {
        try (MovieDao movieDao = new MovieDao()) {
            Movie movie = Movie.builder()
                    .name(information.getTitle())
                    .year(information.getYear())
                    .rating(information.getRating())
                    .count(information.getRandomCount())
                    .build();

            movieDao.insert(movie);
            System.out.println("Фильм успешно добавлен");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateMovie() {
        try (MovieDao movieDao = new MovieDao()) {
            Movie movie = Movie.builder()
                    .name(information.getTitle())
                    .year(information.getYear())
                    .rating(information.getRating())
                    .count(information.getRandomCount())
                    .build();

            movieDao.update(movie);
            System.out.println("Фильм успешно добавлен");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteMovie() {
        try (MovieDao movieDao = new MovieDao()) {
            Movie movie = Movie.builder()
                    .name(information.getTitle())
                    .year(information.getYear())
                    .rating(information.getRating())
                    .count(information.getRandomCount())
                    .build();

            movieDao.delete(movie);
            System.out.println("Фильм успешно добавлен");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printMovies() {
        try (MovieDao movieDao = new MovieDao()) {
            information.printMovies(movieDao.getAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printActors() {
        try (ActorDao actorDao = new ActorDao()) {
            information.printActors(actorDao.getAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printDirectors() {
        try (DirectorDao directorDao = new DirectorDao()) {
            information.printDirectors(directorDao.getAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
