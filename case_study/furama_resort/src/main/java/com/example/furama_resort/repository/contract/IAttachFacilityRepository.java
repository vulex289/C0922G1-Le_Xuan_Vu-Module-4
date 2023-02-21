package com.example.furama_resort.repository.contract;

import com.example.furama_resort.model.contract.AttachFacility;
import com.example.furama_resort.model.dto.IAttachFacilityDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Long> {
    @Query(value = " select de.contract_id as contractId ,de.quantity as quantity,att.cost as cost,att.`name` as nameAttach,att.`status`as status,att.unit as unit from contract_detail de\n" +
            "  join attach_facility att on de.attach_facility_id = att.id where de.contract_id = :param", nativeQuery = true)
    List<IAttachFacilityDto> findByContractId(@Param("param") long id);

}
