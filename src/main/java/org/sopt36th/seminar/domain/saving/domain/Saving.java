package org.sopt36th.seminar.domain.saving.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Saving {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
