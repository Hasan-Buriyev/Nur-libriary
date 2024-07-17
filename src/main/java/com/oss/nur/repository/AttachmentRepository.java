package com.oss.nur.repository;


import com.oss.nur.entity.Attachment;
import lombok.Getter;

public class AttachmentRepository extends BaseRepository {
    @Getter
    private static final AttachmentRepository instance = new AttachmentRepository();
    private AttachmentRepository() {}

    public void save(Attachment attachment) {
        try {
            beginTransaction();
            entityManager.persist(attachment);
            commitTransaction();
        }catch(Exception e) {
            rollbackTransaction();
            e.printStackTrace();
        }
    }
    public Attachment findById(Long id) {
        try {
            beginTransaction();
            Attachment attachment = entityManager.find(Attachment.class, id);
            commitTransaction();
            return attachment;

        }catch(Exception e) {
            rollbackTransaction();
            e.printStackTrace();
            return null;
        }
    }

}
