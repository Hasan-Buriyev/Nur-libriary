package com.oss.nur.entity;

import com.oss.nur.config.base.BaseEntityLong;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "attachment")
public class Attachment extends BaseEntityLong {

    @Column(name = "original_name", nullable = false)
    private String originalName;

    @Column(name = "generated_name", nullable = false)
    private String generatedName;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "size")
    private double size;

    @Column(name = "file_url", nullable = false)
    private String fileUrl;

    @Column(name = "mime_type")
    private String mimeType;
}
