package com.brnbyk.quarkus.persist.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 11:36
 **/
@MappedSuperclass
public abstract class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        return getID() != null ? getID().equals(that.getID()) : that.getID() == null;
    }

    @Override
    public int hashCode() {
        return getID() != null ? getID().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "ID=" + ID +
                '}';
    }
}
