package com.cdx.schedulebackend.service;

import com.cdx.schedulebackend.model.request.AccountRequest;
import com.cdx.schedulebackend.repository.AccountRepository;
import com.cdx.schedulebackend.repository.dao.Account;
import com.cdx.schedulebackend.repository.dao.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final AccountRepository accountRepository;

    public ResponseEntity<?> execute(AccountRequest request){
        try {
            if (Boolean.TRUE.equals(accountRepository.existsByUsername(request.getUsername()))){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            Account account = accountRepository.save(Account.builder()
                            .username(request.getUsername())
                            .password(request.getPassword())
                    .build());
            return new ResponseEntity<>(account, HttpStatus.CREATED);

        }catch (Exception e){

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }

    }
}
