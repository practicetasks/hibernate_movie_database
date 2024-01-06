package dao;

import model.Genre;

import java.util.List;

public class GenreDao extends EntityDao<Genre> {
    @Override
    public Genre getById(int id) {
        return manager.find(Genre.class, id);
    }

    @Override
    public List<Genre> getAll() {
        return manager.createQuery("from Genre", Genre.class).getResultList();
    }
}
