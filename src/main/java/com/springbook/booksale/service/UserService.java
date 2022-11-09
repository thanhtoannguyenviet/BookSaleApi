package com.springbook.booksale.service;

import com.springbook.booksale.entity.UserEntity;
import com.springbook.booksale.payload.UserResponse;

public interface UserService {
    UserEntity createUser(UserEntity userEntity);
    UserResponse getAllUser(int pageNo, int pageSize, String sortBy, String sortDir);
    UserEntity getUserById(long id);
    void deleteUserById(long id);
    UserEntity updateInvoice(UserEntity invoiceEntity, long id);
}