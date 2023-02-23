package com.example.furama_resort.repository.facility;

import com.example.furama_resort.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Long> {
    @Query(value = "select * from facility where is_delete = false and name like concat('%',:nameSearch,'%')", nativeQuery = true)
    Page<Facility> getAllByNameSearch(@Param("nameSearch") String nameSearch, Pageable pageable);

    @Query(value = "select * from facility where is_delete = false and name like concat('%',:nameSearch,'%') and facility_type_id = :typeId", nativeQuery = true)
    Page<Facility> getAllByNameSearchAndFacilityType(@Param("nameSearch") String nameSearch, @Param("typeId") long facilityType, Pageable pageable);

    @Modifying
    @Query(value = "update facility set is_delete = true where id=:idDelete ", nativeQuery = true)
    void deleteLogic(@Param("idDelete") Long id);

}
