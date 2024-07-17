package com.oss.nur.repository;

import com.oss.nur.entity.Genre;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GenreRepository extends BaseRepository{
    @Getter
    private static final GenreRepository instance = new GenreRepository();

    private GenreRepository() {}

    public Optional<List<Genre>> getAllGenres() {
        try {
            beginTransaction();
            List<Genre> genres = entityManager.createQuery("from Genre b", Genre.class).getResultList();
            commitTransaction();
            return Optional.of(genres);
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Genre> getGenreById(String id) {
        try {
            beginTransaction();
            Genre genre = entityManager.find(Genre.class, UUID.fromString(id));
            commitTransaction();
            return Optional.of(genre);
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Genre> getGenreByName(String name) {
        try {
            beginTransaction();
            Genre genre = entityManager.find(Genre.class, name);
            commitTransaction();
            return Optional.of(genre);
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<List<Genre>> searchBy(String name) {
        try {
            beginTransaction();

            List<Genre> genres = entityManager
                    .createQuery("from Genre b where b.name ILIKE :title", Genre.class)
                    .setParameter("title", "%" + name + "%")
                    .getResultList();

            commitTransaction();
            return Optional.of(genres);
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void orderBy(String escOrDesc) {
        try {
            beginTransaction();
            switch (escOrDesc) {
                case "asc":{
                    entityManager.createQuery("from Genre b order by b.id asc");}
                case "desc":{
                    entityManager.createQuery("from Genre b order by b.id desc");
                }
            }
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
        }
    }

    public boolean save(Genre genre) {
        try {
            beginTransaction();
            entityManager.persist(genre);
            commitTransaction();
            return true;
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Genre genre) {
        try {
            beginTransaction();
            entityManager.merge(genre);
            commitTransaction();
            return true;
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            beginTransaction();
            Genre genre = entityManager.find(Genre.class, UUID.fromString(id));
            entityManager.remove(genre);
            commitTransaction();
            return true;
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return false;
        }
    }
}
