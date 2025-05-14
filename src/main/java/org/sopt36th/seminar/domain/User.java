package org.sopt36th.seminar.domain;

import jakarta.persistence.Entity;
import org.sopt36th.seminar.common.entity.BaseEntity;

@Entity
public class User extends BaseEntity {

    private String name;

    protected User() {

    }

    public User(String name) {
        this.name = name;
    }
}
