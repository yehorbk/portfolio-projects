package space.generics.superburger.service;

import space.generics.superburger.dto.user.UpdateUserDto;
import space.generics.superburger.dto.user.UserDto;

public interface UserService {
    
    UserDto readById(long id);
    
    UserDto readByEmail(String email);
    
    UserDto readByPhone(String phone);
    
    UserDto update(long id, UpdateUserDto updateUserDto);
    
    void deleteById(long id);
    
}
