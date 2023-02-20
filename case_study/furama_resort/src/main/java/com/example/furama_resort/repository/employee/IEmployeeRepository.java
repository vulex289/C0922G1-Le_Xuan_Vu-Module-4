package com.example.furama_resort.repository.employee;
import com.example.furama_resort.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from employee where is_delete=false and name like concat('%',:nameSearch,'%')",nativeQuery = true)
    Page<Employee> findAll(@Param("nameSearch") String nameSearch, Pageable pageable);
}
