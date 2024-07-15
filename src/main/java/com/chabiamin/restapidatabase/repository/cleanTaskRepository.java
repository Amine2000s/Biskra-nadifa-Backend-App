package com.chabiamin.restapidatabase.repository;

import com.chabiamin.restapidatabase.model.cleanTask;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface cleanTaskRepository extends JpaRepository<cleanTask, Integer> {


    @Query("select ct FROM cleanTask ct where ct.Assigneddriver.id=:driverId")
    List<cleanTask> findTasksByID(int driverId);


    @Modifying
    @Transactional
    @Query("UPDATE cleanTask ct set ct.status=:newStatus WHERE ct.id=:taskid")
    void updateTaskStatus(@Param("newStatus")String status , @Param("taskid")int taskid);



    //@Query("UPDATE tasks SET status =:new_status WHERE id =:task_id")
}
