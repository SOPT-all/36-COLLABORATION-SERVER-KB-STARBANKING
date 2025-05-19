package org.sopt36th.seminar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.sopt36th.seminar.common.entity.BaseEntity;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PreferentialRate extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "saving_id")
    private Saving saving;

    private String name;

    @JsonFormat(shape = Shape.STRING, pattern = "0.00")
    private Double rate;

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate startDate;

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate endDate;


    public PreferentialRate(Saving saving, String name, Double rate, LocalDate startDate, LocalDate endDate) {
        this.saving = saving;
        this.name = name;
        this.rate = rate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Saving getSaving() {
        return saving;
    }

    public String getName() {
        return name;
    }

    public Double getRate() {
        return rate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
