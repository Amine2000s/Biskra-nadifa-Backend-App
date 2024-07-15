package com.chabiamin.restapidatabase.repository;


import com.chabiamin.restapidatabase.model.Report;
import com.chabiamin.restapidatabase.model.driver;
import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.model.systemUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assert;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest

public class cleanTaskRepositoryTest {

    @Autowired
    private cleanTaskRepository cleantaskRepository;
    @Autowired
    private systemUserRepository systemuserrepository;
    @Autowired
    private driverRepository DriverRepository;
    @Autowired

    private reportsRepository reportsrepository;
    @PersistenceContext
    private EntityManager entityManager;
    cleanTask cleantask ;
    Report report ;

    driver Driver ;

    systemUser systemuser ;

    Session session ;

    @BeforeEach
    void setUp() {

        report = Report.builder().id(1)
                .reporterId(5)
                .reportType("Toxic trash")
                .reportDescription("there is too much toxic trash ").build();

        systemuser = systemUser.builder().id(2)
                .name("mohammed")
                .surName("Ali")
                .build();

        Driver = driver.builder().id(3)
                .name("Ahmed")
                .surName("amin")
                .build();


    }

    @AfterEach
    void tearDown() {
            cleantask = null ;
            systemuser=null;
            report=null;
            Driver=null;

            cleantaskRepository.deleteAll();
            DriverRepository.deleteAll();
            reportsrepository.deleteAll();
            systemuserrepository.deleteAll();
            cleantaskRepository.deleteAll();
    }


    @Test
    void findTasksByIDtest(){

        report =  reportsrepository.save(report);

        Driver = DriverRepository.save(Driver);

        systemuser = systemuserrepository.save(systemuser);


        cleantask = new cleanTask(report,systemuser,Driver);

        cleantaskRepository.save(cleantask);


        assertThat(cleantaskRepository.findTasksByID(Driver.getId()).get(0).getId()).isEqualTo(cleantask.getId());

    }

    @Test
    @Transactional
    void updateTaskStatus(){

        report =  reportsrepository.save(report);

        Driver = DriverRepository.save(Driver);

        systemuser = systemuserrepository.save(systemuser);


        cleantask = new cleanTask(report,systemuser,Driver);

        cleantask.setStatus("Not Done");
        entityManager.persist(cleantask);
        cleantask = cleantaskRepository.save(cleantask);

        entityManager.flush();

        // Update the status of the task
        cleantaskRepository.updateTaskStatus("Done",cleantask.getId());

        // Clear the persistence context to avoid caching issues
        cleantaskRepository.flush();
        entityManager.clear();

        cleanTask updatedTask = cleantaskRepository.findById(cleantask.getId()).orElse(null);
        
        assertThat(updatedTask.getStatus()).isEqualTo("Done");

    }


}



