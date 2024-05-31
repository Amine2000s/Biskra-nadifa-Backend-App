package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.modernBin;
import com.chabiamin.restapidatabase.repository.modernBinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class modernBinServiceImp implements modernBInService{


    modernBinRepository modernbinRepository ;


    @Autowired
    public modernBinServiceImp( modernBinRepository modernbinRepository){

        this.modernbinRepository = modernbinRepository;

    }

    @Override
    public List<modernBin> getAllBin() {



        return modernbinRepository.findAll() ;
    }

    @Override
    public void addBin(modernBin moderbin) {

        modernbinRepository.save(moderbin);

        System.out.println("insertion successfully done ");

    }

    @Override
    public void deleteBin(int id) {

        modernbinRepository.deleteById(id);

        System.out.println("delete successfully done ");


    }

    @Override
    public void modifiyBIn(int id) {
        return;
    }


}