package com.brnbyk.quarkus.persist.base;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 11:36
 **/
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public abstract class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "ID=" + ID +
                '}';
    }
}
