package com.example.ecommerce.service;

import com.example.ecommerce.model.FullName;
import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;
import com.example.ecommerce.model.UserRole;
import com.example.ecommerce.repository.FullNameRepository;
import com.example.ecommerce.repository.RoleRepository;
import com.example.ecommerce.repository.UserRepository;
//import com.example.ecommerce.user.domain.UserRole;
import com.example.ecommerce.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializationComponent implements CommandLineRunner {

    private final UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private FullNameRepository fullnameRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

//    private CartService cartService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializationComponent(UserRepository userRepository,
                                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
//        this.cartService=cartService;
    }

    @Override
    public void run(String... args) {
        initializeAdminUser();
    }

    private void initializeAdminUser() {
        String adminUsername = "duc@gmail.com";

        if (userRepository.findByEmail(adminUsername)==null) {
            User adminUser = new User();

            adminUser.setEmail(adminUsername);
            adminUser.setUsername("nguyenvanduc");
            adminUser.setPassword(passwordEncoder.encode("123"));

            FullName fullName = new FullName();
            fullName.setFirstName("Duc");
            fullName.setLastName("Nguyen");
            fullnameRepository.save(fullName);
            adminUser.setFullName(fullName);

            UserRole userRole = new UserRole();
            userRole.setRole(roleRepository.findById(1L).get());

            List<UserRole> userRoles = List.of(userRole);

            adminUser.setUserRoleList(userRoles);
            User admin=userRepository.save(adminUser);

//            cartService.createCart(admin);
        }
    }

}
