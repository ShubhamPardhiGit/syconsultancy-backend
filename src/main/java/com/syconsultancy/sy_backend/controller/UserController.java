package com.syconsultancy.sy_backend.controller;

import com.syconsultancy.sy_backend.entity.User;
import com.syconsultancy.sy_backend.service.UserService;
import com.syconsultancy.sy_backend.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    private static final Logger logger =LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        logger.info("Inside controller /hello");
        return "App is running";
    }

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public User registerUser(
            @RequestParam("fullName") String fullName,
            @RequestParam("passportNo") String passportNo,
            @RequestParam("dob") String dob,
            @RequestParam("designation") String designation,
            @RequestParam("ppType") String ppType,
            @RequestParam("mobileNo") String mobileNo,
            @RequestParam("address") String address,
            @RequestParam("remark") String remark,
            @RequestParam("photoFile") MultipartFile photo,
            @RequestParam("cvFile") MultipartFile cv) throws IOException {
        logger.info("Inside controller /register");
        User user = new User();

        user.setFullName(fullName);
        user.setPassportNo(passportNo);
        user.setDob(LocalDate.parse(dob));
        user.setDesignation(designation);
        user.setPpType(ppType);
        user.setMobileNo(mobileNo);
        user.setAddress(address);
        user.setRemark(remark);

        return userService.saveUser(user, photo, cv);
    }

    @PutMapping(value = "/updateUser", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public User updateUser(

            @RequestParam("id") Long id,

            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String passportNo,
            @RequestParam(required = false) String dob,
            @RequestParam(required = false) String designation,
            @RequestParam(required = false) String ppType,
            @RequestParam(required = false) String mobileNo,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String remark,
            @RequestParam(value = "photoFile", required = false) MultipartFile photo,
            @RequestParam(value = "cvFile", required = false) MultipartFile cv

    ) throws IOException {
logger.info("Inside controller /update") ;
        return userService.updateUser(
                id,
                fullName,
                passportNo,
                dob,
                designation,
                ppType,
                mobileNo,
                address,
                remark,
                photo,
                cv
        );
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {

        logger.info("Inside controller /getAllUsers") ;
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable Long id) {
        logger.info("Inside controller /getUser") ;
        return userService.getUserById(id);
    }

    @GetMapping("/search/{passportNo}")
    public User searchByPassportNo(@PathVariable String passportNo) {
        return userService.searchByPassportNo(passportNo);
    }


}