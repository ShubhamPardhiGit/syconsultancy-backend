package com.syconsultancy.sy_backend.repository;

import com.syconsultancy.sy_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPassportNo(String passportNo);

}
