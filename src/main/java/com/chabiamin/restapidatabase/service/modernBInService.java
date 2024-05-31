package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.modernBin;

import java.util.List;

public interface modernBInService {


    public List<modernBin> getAllBin();


    public void addBin(modernBin moderbin) ;

    public void deleteBin(int id );

    public void modifiyBIn(int id );



}
