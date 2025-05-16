package org.sopt36th.seminar.repository;

import org.sopt36th.seminar.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    List<Contract> findByUserId(Long userId);

    List<Contract> findBySavingId(Long savingId);

    // 효은


    // 소연

}
