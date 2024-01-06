package dao;

import model.Actor;

import java.util.List;

public class ActorDao extends EntityDao<Actor> {
    @Override
    public Actor getById(int id) {
        return manager.find(Actor.class, id);
    }

    @Override
    public List<Actor> getAll() {
        return manager.createQuery("from Actor", Actor.class).getResultList();
    }
}
