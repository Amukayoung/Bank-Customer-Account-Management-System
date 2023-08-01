package com.example.BankAccountManager.Role;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RoleController {


    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(path = "/api/v1/role")
    public List<Role> getRole(){
        return roleService.getRole();

    }
    @PostMapping(path = "/api/v1/role")
    public void registerNewRole(@RequestBody Role role){
        System.out.println(role);
        roleService.addNewRole(role);
    }

    @PutMapping(path = "/api/v1/role/{id}")
    public void updateRole(@PathVariable Long id, @RequestBody Role role) {
        roleService.updateRole(id, role);
    }

    @DeleteMapping(path = "/api/v1/role/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

}
