package org.sopt36th.seminar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Deposit extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate date;

    private int afterDeposit;

    private int payment;

    private int count;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.00")
    private Double appliedRate;

    public Deposit(Contract contract, LocalDate date, int afterDeposit, int payment, int count, Double appliedRate) {
        this.contract = contract;
        this.date = date;
        this.afterDeposit = afterDeposit;
        this.payment = payment;
        this.count = count;
        this.appliedRate = appliedRate;
    }
}
