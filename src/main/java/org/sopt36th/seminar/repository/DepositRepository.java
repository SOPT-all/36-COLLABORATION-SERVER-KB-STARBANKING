package org.sopt36th.seminar.repository;

import org.sopt36th.seminar.domain.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

    List<Deposit> findByContractId(Long contractId);

    // 효은
    Deposit findTopByContractIdOrderByCreatedAtDesc(Long contractId);


    // 소연

}
