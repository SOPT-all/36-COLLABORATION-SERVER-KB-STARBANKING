package org.sopt36th.seminar.repository;

import org.sopt36th.seminar.domain.PreferentialRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferentialRateRepository extends JpaRepository<PreferentialRate, Long> {
    List<PreferentialRate> findBySavingId(Long savingId);

    // 효은


    // 소연

}
