package com.oss.nur.repository;

import com.oss.nur.entity.Book;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookRepository extends BaseRepository {

    @Getter
    private static final BookRepository instance = new BookRepository();

    private BookRepository() {
    }

    public Optional<List<Book>> getAllBooks() {
        try {
            beginTransaction();
            List<Book> books = entityManager.createQuery("from Book b", Book.class).getResultList();
            commitTransaction();
            return Optional.of(books);
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Book> getBookById(String id) {
        try {
            beginTransaction();
            Book book = entityManager.find(Book.class, UUID.fromString(id));
            commitTransaction();
            return Optional.of(book);
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<List<Book>> searchBy(String title) {
        try {
            beginTransaction();

            List<Book> books = entityManager
                    .createQuery("from Book b where b.title ILIKE :title", Book.class)
                    .setParameter("title", "%" + title + "%")
                    .getResultList();

            commitTransaction();
            return Optional.of(books);
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void orderBy(String value) {
        try {
            beginTransaction();
            switch (value) {
                case "title": {
                    entityManager.createQuery("from Book b order by b.title desc ", Book.class).executeUpdate();
                }
                case "author": {
                    entityManager.createQuery("from Book b order by b.author", Book.class).executeUpdate();
                }

                case "new": {
                    entityManager.createQuery("from Book b order by b.createdAt ", Book.class).executeUpdate();
                }
                case "old": {
                    entityManager.createQuery("from Book b order by b.createdAt ", Book.class).executeUpdate();
                }
            }
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
        }
    }

    public void save(Book book) {
        try {
            beginTransaction();
            entityManager.persist(book);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
        }
    }

    public boolean update(Book book) {
        try {
            beginTransaction();
            entityManager.merge(book);
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
            Book book = entityManager.find(Book.class, UUID.fromString(id));
            entityManager.remove(book);
            commitTransaction();
            return true;
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return false;
        }
    }

}
