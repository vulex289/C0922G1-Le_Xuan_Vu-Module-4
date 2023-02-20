package com.example.furama_resort.repository.customer;

import com.example.furama_resort.model.customer.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value=" select * from customer where is_delete=false and name like concat('%',:nameSearch,'%' ) and email like concat('%',:email,'%') and customer_type_id like concat('%',:param,'%')",nativeQuery = true)
    Page<Customer>findAll(@Param("nameSearch") String name,@Param("email") String email,@Param("param") String customerTypeId, Pageable pageable);
    @Modifying
    @Query(value = "update customer set is_delete=true where id=:paramId",nativeQuery = true)
    void deleteLogic(@Param("paramId") long id);
    @Query(value = "select * from customer ",nativeQuery = true)
    List<Customer> findAll();

}
