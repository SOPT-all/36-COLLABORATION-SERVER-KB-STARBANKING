package org.sopt36th.seminar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt36th.seminar.common.entity.BaseEntity;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PreferentialRate extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private String name;

    @JsonFormat(shape = Shape.STRING, pattern = "0.00")
    private Double rate;

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate startDate;

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate endDate;

    public PreferentialRate(Contract contract, String name, Double rate, LocalDate startDate, LocalDate endDate) {
        this.contract = contract;
        this.name = name;
        this.rate = rate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
