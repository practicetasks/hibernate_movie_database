package dao;

import model.Movie;

import java.util.List;

public class MovieDao extends EntityDao<Movie> {

    public List<Movie> getTop10() {
        return manager.createQuery("from Movie order by rating desc", Movie.class)
                .setMaxResults(10)
                .getResultList();
    }

    public Movie getByTitle(String title) {
        return manager.createQuery("from Movie where name = :title", Movie.class)
                .setParameter("title", title).getSingleResult();
    }

    public List<Movie> findByYear(int year) {
        return manager.createQuery("from Movie where year = :year", Movie.class)
                .setParameter("year", year).getResultList();
    }


    public List<Movie> filterByDirector(String name) {
        return manager.createQuery("from Movie m join fetch m.directors d where d.name = :directorName", Movie.class)
                .setParameter("directorName", name)
                .getResultList();
    }

    public List<Movie> filterByActorName(String name) {
        return manager.createQuery("from Movie m join fetch m.actors a where a.name = :actorName", Movie.class)
                .setParameter("actorName", name)
                .getResultList();
    }

    @Override
    public Movie getById(int id) {
        return manager.find(Movie.class, id);
    }

    @Override
    public List<Movie> getAll() {
        return manager.createQuery("from Movie", Movie.class).getResultList();
    }
}
