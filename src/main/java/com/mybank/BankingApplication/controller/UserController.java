package com.mybank.BankingApplication.controller;

import com.mybank.BankingApplication.Dto.UserRequestDto;
import com.mybank.BankingApplication.Dto.UserResponseDto;
import com.mybank.BankingApplication.model.UserSignUp;
import com.mybank.BankingApplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public UserSignUp createUser(@RequestBody @Valid UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


}
