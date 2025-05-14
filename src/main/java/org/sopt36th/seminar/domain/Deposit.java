package org.sopt36th.seminar.domain;

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

    private LocalDate date;

    private Integer afterDeposit;

    private Integer payment;

    private Integer count;

    private Double appliedRate;

    protected Deposit() {

    }


    public Deposit(Contract contract, LocalDate date, Integer afterDeposit, Integer payment, Integer count, Double appliedRate) {
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

    public Integer getAfterDeposit() {
        return afterDeposit;
    }

    public Integer getPayment() {
        return payment;
    }

    public Integer getCount() {
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
