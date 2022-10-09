package com.cdx.schedulebackend.service;

import com.cdx.schedulebackend.model.request.AccountRequest;
import com.cdx.schedulebackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AccountRepository accountRepository;

    public ResponseEntity<?> execute(AccountRequest request){
        var isLogin = accountRepository.existsByUsernameAndPassword(request.getUsername(),request.getPassword());

        if (Boolean.FALSE.equals(isLogin)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new  ResponseEntity<>( "Compete",HttpStatus.OK);
    }
}
