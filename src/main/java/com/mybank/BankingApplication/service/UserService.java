package com.mybank.BankingApplication.service;

import com.mybank.BankingApplication.Dto.UserRequestDto;
import com.mybank.BankingApplication.Dto.UserResponseDto;
import com.mybank.BankingApplication.Mapper.UserMapper;
import com.mybank.BankingApplication.exception.InValidUserDetails;
import com.mybank.BankingApplication.exception.ResourceNotFoundException;
import com.mybank.BankingApplication.model.UserSignUp;
import com.mybank.BankingApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserSignUp createUser(UserRequestDto userRequestDto){
        if(userRequestDto.getUserName().isBlank() || userRequestDto.getPassWord() == null || userRequestDto.getEmail() == null){
            throw new InValidUserDetails("Username should not be null.");
        }
        UserSignUp userSignUpMapper = UserMapper.toEntity(userRequestDto);
        return userRepository.save(userSignUpMapper);
    }
    public UserResponseDto getUserById(Long id){

            UserSignUp uv =  userRepository.findById(id).orElseThrow(
                   () -> new ResourceNotFoundException("user not found with id "+id));

            UserResponseDto dto =UserMapper.toDto(uv);
           return dto;

        }

    }

