package org.sopt36th.seminar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.sopt36th.seminar.common.entity.BaseEntity;
import org.sopt36th.seminar.domain.enums.ContractState;

import java.time.LocalDate;


@Entity
public class Contract extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saving_id", nullable = false)
    private Saving saving;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 30, nullable = false)
    private String account;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate endDate;

    private int totalBalance;

    @JsonFormat(shape = Shape.STRING, pattern = "0.00")
    private Double totalPreferentialRate;

    @Enumerated(EnumType.STRING)
    private ContractState state;

    protected Contract() {

    }

    public Contract(Saving saving, User user, String account, LocalDate startDate, LocalDate endDate, int totalBalance, Double totalPreferentialRate, ContractState state) {
        this.saving = saving;
        this.user = user;
        this.account = account;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBalance = totalBalance;
        this.totalPreferentialRate = totalPreferentialRate;
        this.state = ContractState.ACTIVE;
    }

    //getter
    public Saving getSaving() {
        return saving;
    }

    public User getUser() {
        return user;
    }

    public String getAccount() {
        return account;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getTotalBalance() {
        return totalBalance;
    }

    public Double getTotalPreferentialRate() {
        return totalPreferentialRate;
    }

    public ContractState getState() {
        return state;
    }

    //update
    public void updateTotalBalance(int newBalance) {
        this.totalBalance = newBalance;
    }

}
