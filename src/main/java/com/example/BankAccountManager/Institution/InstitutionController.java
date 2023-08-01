package com.example.BankAccountManager.Institution;

import com.example.BankAccountManager.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstitutionController {
    private final InstitutionService institutionService;
    @Autowired
    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @RequestMapping(path = "/api/v1/institution")
    public List<Institution> getInstitution(){
        return institutionService.getInstitution();

    }
    @PostMapping(path = "/api/v1/institution")
    public void registerNewInstitution(@RequestBody Institution institution){
        System.out.println(institution);
        institutionService.addNewInstitution(institution);
    }

    @PutMapping(path = "/api/v1/institution/{id}")
    public void updateInstitution(@PathVariable Long id, @RequestBody Institution institution) {
        institutionService.updateInstitution(id, institution);
    }

    @DeleteMapping(path = "/api/v1/institution/{id}")
    public void deleteInstitution(@PathVariable Long id) {
        institutionService.deleteInstitution(id);
    }

}
