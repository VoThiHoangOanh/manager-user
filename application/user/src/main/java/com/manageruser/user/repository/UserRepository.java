package com.manageruser.user.repository;

import com.manageruser.sharedmodel.core.repository.MongoQueryDSLRepository;
import com.manageruser.user.document.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoQueryDSLRepository<User> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
