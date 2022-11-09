package com.springbook.booksale.service.impl;

import com.springbook.booksale.entity.AuthorEntity;
import com.springbook.booksale.exception.ResourceNotFoundException;
import com.springbook.booksale.payload.AuthorResponse;
import com.springbook.booksale.repository.AuthorRespository;
import com.springbook.booksale.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRespository authorRespository;
    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRespository.save(authorEntity);
    }

    @Override
    public AuthorResponse getAllAuthor(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        //create Pageable instance
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);

        Page<AuthorEntity> authorPage = authorRespository.findAll(pageable);
        List<AuthorEntity> authorLs = authorPage.getContent();

        AuthorResponse dataResponse = new AuthorResponse();
        dataResponse.setContent(authorLs);
        dataResponse.setPageNo(authorPage.getNumber());
        dataResponse.setPageSize(authorPage.getSize());
        dataResponse.setTotalElements(authorPage.getTotalElements());
        dataResponse.setTotalPages(authorPage.getTotalPages());
        dataResponse.setLast(authorPage.isLast());
        return dataResponse;
    }

    @Override
    public AuthorEntity getAuthorById(long id) {
        return authorRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Author","id",id));
    }

    @Override
    public void deleteAuthorById(long id) {
        AuthorEntity authorEntity = authorRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Author","id",id));
        authorEntity.setIsDel(false);
        authorRespository.save(authorEntity);
    }

    @Override
    public AuthorEntity updateAuthor(AuthorEntity authorEntity, long id) {
        AuthorEntity author = authorRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Author","id",id));
        author.setName(authorEntity.getName());
        return authorRespository.save(authorEntity);
    }
}
