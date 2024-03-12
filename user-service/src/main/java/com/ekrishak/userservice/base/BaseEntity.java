package com.ekrishak.userservice.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedBy
    @JsonIgnore
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    private Integer createdBy;

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @JsonIgnore
    @Column(name = "updated_by", length = 50)
    private Integer updatedBy;

    @JsonIgnore
    @Column(name = "updated_date")
    private Date updatedDate;
}
