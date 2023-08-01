package com.example.BankAccountManager.Branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {
    Optional<Branch> findBranchByCode(String code);
}
