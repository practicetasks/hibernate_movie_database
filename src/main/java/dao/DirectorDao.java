package dao;

import model.Director;

import java.util.List;

public class DirectorDao extends EntityDao<Director> {
    @Override
    public Director getById(int id) {
        return manager.find(Director.class, id);
    }

    @Override
    public List<Director> getAll() {
        return manager.createQuery("from Director", Director.class).getResultList();
    }
}
