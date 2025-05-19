package org.sopt36th.seminar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt36th.seminar.common.entity.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Saving extends BaseEntity {

    private String name;

    @JsonFormat(shape = Shape.STRING, pattern = "0.00")
    private Double baseRate;

    public Saving(String name, double baseRate) {
        this.name = name;
        this.baseRate = baseRate;
    }
}
