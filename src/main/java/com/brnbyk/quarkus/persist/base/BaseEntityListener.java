package com.brnbyk.quarkus.persist.base;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * Username = baranbuyuk
 * Date = 20.09.2019 17:08
 **/
public class BaseEntityListener<T extends BaseEntity> {


    @PrePersist
    public void prePersist(T ob) {
        ob.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(T ob) {
        ob.setUpdatedDate(LocalDateTime.now());
    }

}
