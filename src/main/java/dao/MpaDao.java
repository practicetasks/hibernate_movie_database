package dao;

import model.Mpa;

import java.util.List;

public class MpaDao extends EntityDao<Mpa> {
    @Override
    public Mpa getById(int id) {
        return manager.find(Mpa.class, id);
    }

    @Override
    public List<Mpa> getAll() {
        return manager.createQuery("from Mpa", Mpa.class).getResultList();
    }
}
