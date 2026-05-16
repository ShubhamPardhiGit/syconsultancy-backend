package com.syconsultancy.sy_backend.service;

import com.syconsultancy.sy_backend.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    // User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    //User updateUser(Long id, User user);
    public User updateUser(

            Long id,
            String fullName,
            String passportNo,
            String dob,
            String designation,
            String ppType,
            String mobileNo,
            String address,
            String remark,
            MultipartFile photo,
            MultipartFile cv

    ) throws IOException;

    User searchByPassportNo(String passportNo);

    User saveUser(User user, MultipartFile photoFile, MultipartFile cvFile) throws IOException;
    public void deleteUser(Long id);

}