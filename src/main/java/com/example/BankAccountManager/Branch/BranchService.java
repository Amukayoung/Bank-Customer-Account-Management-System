package com.example.BankAccountManager.Branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BranchService {


    private final BranchRepository branchRepository;
    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> getBranch(){

        return branchRepository.findAll();
//
    }

    public void addNewBranch(Branch branch) {
        Optional<Branch> codeExist = branchRepository.findBranchByCode(branch.getCode());
        if(codeExist.isPresent()){
            throw new IllegalStateException("Branch already registered");
        }
        branchRepository.save(branch);
    }

    public void updateBranch(Long id, Branch updatedBranch) {
        Branch existingBranch = branchRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Branch not found with id: " + id));

        // Update the properties of the existing user
        existingBranch.setName(updatedBranch.getName());
        existingBranch.setCode(updatedBranch.getCode());
        existingBranch.setInstitutionID(updatedBranch.getInstitutionID());
        branchRepository.save(existingBranch);
    }

    public void deleteBranch(Long id) {
        if (!branchRepository.existsById(id)) {
            throw new IllegalArgumentException("Branch not found with id: " + id);
        }

        branchRepository.deleteById(id);
    }
}
