package org.sopt36th.seminar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Entity;
import org.sopt36th.seminar.common.entity.BaseEntity;

@Entity
public class Saving extends BaseEntity {

    private String name;

    @JsonFormat(shape = Shape.STRING, pattern = "0.00")
    private Double baseRate;

    protected Saving() {

    }

    public Saving(String name, double baseRate) {
        this.name = name;
        this.baseRate = baseRate;
    }

    public String getName() {
        return name;
    }

    public Double getBaseRate() {
        return baseRate;
    }
}
