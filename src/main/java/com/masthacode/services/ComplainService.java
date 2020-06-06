package com.masthacode.services;

import com.masthacode.model.Complain;

import java.util.List;

public interface ComplainService {
    List <Complain> listComplain();
    Complain saveOrUpdate(Complain complain);
    Complain getIdComplain(Integer id);
}
