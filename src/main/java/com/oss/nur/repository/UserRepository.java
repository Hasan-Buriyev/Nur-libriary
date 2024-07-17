package com.oss.nur.repository;

import com.oss.nur.entity.User;
import jakarta.persistence.NoResultException;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepository extends BaseRepository  {
    @Getter
    private static final UserRepository instance=new UserRepository();

    private UserRepository(){}

    public Optional<User> findByEmailOrUsername(String emailOrUsername) {
        try {
            beginTransaction(); // Transaction boshlanishi
            User user = entityManager
                    .createQuery("from User u where u.email = :emailOrUsername or u.username = :emailOrUsername", User.class)
                    .setParameter("emailOrUsername", emailOrUsername)
                    .getSingleResult();
            commitTransaction(); // Transaktsiya yakunlanishi
            return Optional.of(user);
        } catch (NoResultException e) {
            rollbackTransaction(); // Xatolik bo'lsa transaktsiyani bekor qilish
            return Optional.empty();
        } catch (Exception e) {
            rollbackTransaction(); // Boshqa xatoliklar uchun ham transaktsiyani bekor qilish
            e.printStackTrace();
            return Optional.empty();
        }
    }
    public Optional<List<User>> findAll(){
        try {
            beginTransaction();
            List<User> users = entityManager.createQuery("from User", User.class).getResultList();
            commitTransaction();
            return Optional.of(users);
        }catch (Exception e){
            rollbackTransaction();
            e.printStackTrace();
            return Optional.empty();
        }
    }
    public Optional<User> findById(String id){
        try {
            beginTransaction();
            User user = entityManager.find(User.class,UUID.fromString(id));
            commitTransaction();
            return Optional.of(user);
        }catch (Exception e){
            rollbackTransaction();
            e.printStackTrace();
            return Optional.empty();
        }
    }
    public boolean save(User user){
        try {
            beginTransaction();
            entityManager.persist(user);
            commitTransaction();
            return true;
        }catch (Exception e){
            rollbackTransaction();
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(User user){
        try {
            beginTransaction();
            entityManager.merge(user);
            commitTransaction();
            return true;
        }catch (Exception e){
            rollbackTransaction();
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String id){
        try {
            beginTransaction();
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            commitTransaction();
            return true;
        }catch (Exception e){
            rollbackTransaction();
            e.printStackTrace();
            return false;
        }
    }
}
