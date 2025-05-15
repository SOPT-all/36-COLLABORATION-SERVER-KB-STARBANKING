package org.sopt36th.seminar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.sopt36th.seminar.common.entity.BaseEntity;

import java.time.LocalDate;

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

    protected Deposit() {

    }

    public Deposit(Contract contract, LocalDate date, int afterDeposit, int payment, int count, Double appliedRate) {
        this.contract = contract;
        this.date = date;
        this.afterDeposit = afterDeposit;
        this.payment = payment;
        this.count = count;
        this.appliedRate = appliedRate;
    }

    //getter
    public Contract getContract() {
        return contract;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAfterDeposit() {
        return afterDeposit;
    }

    public int getPayment() {
        return payment;
    }

    public int getCount() {
        return count;
    }

    public Double getAppliedRate() {
        return appliedRate;
    }

    //update
    public void updateAfterDeposit(int newBalance) {
        this.afterDeposit = newBalance;
    }
}
