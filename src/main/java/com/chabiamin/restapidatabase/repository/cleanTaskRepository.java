package com.chabiamin.restapidatabase.repository;

import ch.qos.logback.core.model.INamedModel;
import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.model.driver;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface cleanTaskRepository extends JpaRepository<cleanTask, Integer> {


    @Query("select ct FROM cleanTask ct where ct.Assigneddriver=:driver")
    List<cleanTask> findTasksByID(@Param("driver")driver driver);


    @Modifying
    @Transactional
    @Query("UPDATE cleanTask ct set ct.status=:newStatus WHERE ct.id=:id")
    void updateTaskStatus(@Param("newStatus")String status , @Param("id")int id);

    //@Query("UPDATE tasks SET status =:new_status WHERE id =:task_id")
}
