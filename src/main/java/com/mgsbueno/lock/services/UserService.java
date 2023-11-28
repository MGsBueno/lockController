package com.mgsbueno.lock.services;

import com.mgsbueno.lock.entities.User;
import com.mgsbueno.lock.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String becomeAdmin(Long adminId, Long userId) {
        Optional<User> optionalAdmin = userRepository.findById(adminId);
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalAdmin.isPresent() && optionalUser.isPresent()) {
            User admin = optionalAdmin.get();
            User user = optionalUser.get();

            if (admin.isAdmin() || admin.getHierarchyLevel() == 0) {
                user.setAdmin(true);
                userRepository.save(user);
                return "Success";
            } else {
                return "Fail, insufficient privileges to make user an admin";
            }
        } else {
            return "Fail, user or admin not found";
        }
    }

    public String changeHierarchyLevel(Long adminId, Long userId, int newhierarchyLevel, boolean isadminState) {
        Optional<User> optionalAdmin = userRepository.findById(adminId);
        Optional<User> optionalUserToBeModified = userRepository.findById(userId);

        if (optionalAdmin.isPresent() && optionalUserToBeModified.isPresent()) {
            User admin = optionalAdmin.get();
            User userToBeModified = optionalUserToBeModified.get();

            // Verifica se o usuário que está requisitando é um administrador
            if (!admin.isAdmin()) {
                return "Fail, admin privileges required";
            }

            // Verifica se o admin tem hierarquia para modificar o usuário
            if (admin.getHierarchyLevel() <= userToBeModified.getHierarchyLevel()) {
                return "Fail, need higher hierarchy";
            }

            // Lógica para atribuir a nova hierarquia
            userToBeModified.setHierarchyLevel(newhierarchyLevel);
            userToBeModified.setAdmin(isadminState);
            userRepository.save(userToBeModified);

            return "Success";
        } else {
            return "Fail, user or admin not found";
        }
    }

    public String acceptUserRegistration(Long adminId, User newUser) {
        Optional<User> optionalAdmin = userRepository.findById(adminId);

        if (optionalAdmin.isPresent()) {
            User admin = optionalAdmin.get();

            if (admin.isAdmin()) {
                newUser.setRegistered(true);
                userRepository.save(newUser);
                return "Success";
            } else {
                return "Fail, insufficient privileges to accept user registration";
            }
        } else {
            return "Fail, admin not found";
        }
    }



    // Outros métodos do serviço
}
