package org.sopt36th.seminar.domain;

import jakarta.persistence.*;
import org.sopt36th.seminar.common.entity.BaseEntity;
import org.sopt36th.seminar.domain.enums.ContractState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contract extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saving_id", nullable = false)
    private Saving saving;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<Deposit> deposits = new ArrayList<>();

    @Column(length = 30, nullable = false)
    private String account;

    private LocalDate startDate;
    private LocalDate endDate;

    private Integer totalBalance;

    private Double totalPreferentialRate;

    @Enumerated(EnumType.STRING)
    private ContractState state;

    protected Contract() {

    }

    public Contract(Saving saving, User user, String account, LocalDate startDate, LocalDate endDate, Integer totalBalance, Double totalPreferentialRate, ContractState state) {
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

    public Integer getTotalBalance() {
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
