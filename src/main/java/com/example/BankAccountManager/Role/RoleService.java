package com.example.BankAccountManager.Role;
import com.example.BankAccountManager.Branch.Branch;
import com.example.BankAccountManager.Branch.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RoleService {


    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRole(){

        return roleRepository.findAll();
//
    }

    public void addNewRole(Role role) {
        Optional<Role> codeExist = roleRepository.findRoleByCode(role.getCode());
        if(codeExist.isPresent()){
            throw new IllegalStateException("Role already registered");
        }
        roleRepository.save(role);
    }

    public void updateRole(Long id, Role updatedRole) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + id));

        existingRole.setName(updatedRole.getName());
        existingRole.setCode(updatedRole.getCode());
        existingRole.setDescription(updatedRole.getDescription());
        roleRepository.save(existingRole);
    }

    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new IllegalArgumentException("Role not found with id: " + id);
        }

        roleRepository.deleteById(id);
    }
}
