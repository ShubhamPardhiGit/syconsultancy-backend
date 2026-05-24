package com.syconsultancy.sy_backend.service.impl;

import com.syconsultancy.sy_backend.DTO.UserDto;
import com.syconsultancy.sy_backend.entity.User;
import com.syconsultancy.sy_backend.repository.UserRepository;
import com.syconsultancy.sy_backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }


    @Override
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

    ) throws IOException {

        logger.info("Inside update user method");

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (fullName != null) {
            existingUser.setFullName(fullName);
        }

        if (passportNo != null) {
            existingUser.setPassportNo(passportNo);
        }

        if (dob != null) {
            existingUser.setDob(LocalDate.parse(dob));
        }

        if (designation != null) {
            existingUser.setDesignation(designation);
        }

        if (ppType != null) {
            existingUser.setPpType(ppType);
        }

        if (mobileNo != null) {
            existingUser.setMobileNo(mobileNo);
        }

        if (address != null) {
            existingUser.setAddress(address);
        }

        if (remark != null) {
            existingUser.setRemark(remark);
        }

        // Update photo only if new photo uploaded
        if (photo != null && !photo.isEmpty()) {
            existingUser.setPhoto(photo.getBytes());
        }

        // Update cv only if new cv uploaded
        if (cv != null && !cv.isEmpty()) {
            existingUser.setCv(cv.getBytes());
        }

        return userRepository.save(existingUser);
    }
    @Override
    public User searchByPassportNo(String passportNo) {

        return userRepository.findByPassportNo(passportNo)
                .orElseThrow(() -> new RuntimeException("Passport Not Found"));
    }

    @Override
    public User saveUser(User user,
                         MultipartFile photoFile,
                         MultipartFile cvFile) throws IOException {

        logger.info("Inside save user method.....");

        // Save photo in DB
        if (photoFile != null && !photoFile.isEmpty()) {

            logger.info("Saving photo in database...");

            user.setPhoto(photoFile.getBytes());
        }

        // Save CV in DB
        if (cvFile != null && !cvFile.isEmpty()) {

            logger.info("Saving CV in database...");

            user.setCv(cvFile.getBytes());
        }

        // Set created date
        user.setCreatedDate(LocalDateTime.now());

        logger.info("Before save........");

        logger.info("Photo class: {}", user.getPhoto().getClass());
        logger.info("CV class: {}", user.getCv().getClass());

        return userRepository.save(user);
    }
        @Override
        public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
