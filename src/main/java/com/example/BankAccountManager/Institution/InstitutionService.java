package com.example.BankAccountManager.Institution;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class InstitutionService {

    private final InstitutionRepository institutionRepository;
    @Autowired
    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> getInstitution(){

        return institutionRepository.findAll();
//
    }

    public void addNewInstitution(Institution institution) {
        Optional<Institution> codeExist = institutionRepository.findInstitutionByCode(institution.getCode());
        if(codeExist.isPresent()){
            throw new IllegalStateException("Institution already registered");
        }
        institutionRepository.save(institution);
    }

    public void updateInstitution(Long id, Institution updatedInstitution) {
        Institution existingInstitution = institutionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Institution not found with id: " + id));

        // Update the properties of the existing user
        existingInstitution.setName(updatedInstitution.getName());
        existingInstitution.setCode(updatedInstitution.getCode());

        institutionRepository.save(existingInstitution);
    }

    public void deleteInstitution(Long id) {
        if (!institutionRepository.existsById(id)) {
            throw new IllegalArgumentException("Institution not found with id: " + id);
        }

        institutionRepository.deleteById(id);
    }
}
