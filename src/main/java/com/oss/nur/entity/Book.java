package com.oss.nur.entity;

import com.oss.nur.config.base.BaseEntityUUID;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "book")
public class Book  extends BaseEntityUUID {

    @Column(name = "title" , nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private User admin;

    @Column(name = "author")
    private String author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @OneToOne()
    @JoinColumn(name = "file_data_id")
    private Attachment file_data;

    @OneToOne()
    @JoinColumn(name = "file_img_id")
    private Attachment file_img;
}
