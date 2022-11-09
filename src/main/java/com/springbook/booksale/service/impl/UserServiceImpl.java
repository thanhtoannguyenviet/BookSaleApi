package com.springbook.booksale.service.impl;

import com.springbook.booksale.entity.UserEntity;
import com.springbook.booksale.payload.UserResponse;
import com.springbook.booksale.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserResponse getAllUser(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public UserEntity getUserById(long id) {
        return null;
    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public UserEntity updateInvoice(UserEntity invoiceEntity, long id) {
        return null;
    }
}
