package com.example.artistsapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepositoryJPA extends JpaRepository<Department, Long> {
    @Query("select d from Department d where d.displayName like :name" + "%")
    public List<Department> findDepartmentByName(@Param("name") String name);
}
