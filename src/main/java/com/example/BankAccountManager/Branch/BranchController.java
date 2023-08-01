package com.example.BankAccountManager.Branch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BranchController {

    private final BranchService branchService;
    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @RequestMapping(path = "/api/v1/branch")
    public List<Branch> getBranch(){
        return branchService.getBranch();

    }
    @PostMapping(path = "/api/v1/branch")
    public void registerNewBranch(@RequestBody Branch branch){
        System.out.println(branch);
        branchService.addNewBranch(branch);
    }

    @PutMapping(path = "/api/v1/branch/{id}")
    public void updateBranch(@PathVariable Long id, @RequestBody Branch branch) {
        branchService.updateBranch(id, branch);
    }

    @DeleteMapping(path = "/api/v1/branch/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
    }

}
