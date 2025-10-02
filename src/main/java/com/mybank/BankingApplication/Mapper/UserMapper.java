package com.mybank.BankingApplication.Mapper;

import com.mybank.BankingApplication.Dto.UserRequestDto;
import com.mybank.BankingApplication.Dto.UserResponseDto;
import com.mybank.BankingApplication.model.UserSignUp;

public class UserMapper {

    public static UserSignUp toEntity(UserRequestDto userRequestDto){
        UserSignUp userSignUp = new UserSignUp(userRequestDto.getUserName(),userRequestDto.getPassWord(),userRequestDto.getEmail());
//        user.setUserName(userRequestDto.getUserName());
//        user.setPassWord(userRequestDto.getPassWord());
//        user.setEmail(userRequestDto.getEmail());
        return userSignUp;
    }

    public static UserResponseDto toDto(UserSignUp userSignUp){
        //        userResponseDto.setUserName(user.getUserName());
//        userResponseDto.setEmail(user.getEmail());
        return new UserResponseDto(userSignUp.getUserName(), userSignUp.getEmail());
    }

}
