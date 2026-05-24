package com.syconsultancy.sy_backend.repository;

import com.syconsultancy.sy_backend.DTO.UserDto;
import com.syconsultancy.sy_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPassportNo(String passportNo);

    @Query("""
SELECT new com.syconsultancy.sy_backend.DTO.UserDto(
    u.id,
    u.fullName,
    u.mobileNo,
    u.passportNo
)
FROM User u
""")
    List<UserDto> getAllUsers();

}
