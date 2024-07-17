package com.oss.nur.entity;

import com.oss.nur.config.base.BaseEntityUUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "genre")
public class Genre extends BaseEntityUUID {

    @Column(length = 50,name = "name",unique=true)
    private String name;
    @ManyToMany(mappedBy = "genres")
    private List<Book> books;
}
