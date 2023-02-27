package com.example.furama_resort.repository.contract;

import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.dto.IContractDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(value = "select c.id as contractId,\n" +
            "f.name as facilityName,cu.name as customerName,c.start_date as startDate,c.end_date as endDate,deposit,(sum(ifnull(att.cost,0)*ifnull(de.quantity,0))+(f.cost)-deposit) as total\n" +
            "from contract c \n" +
            " left join facility f on c.facility_id = f.id\n" +
            " left join customer cu on c.customer_id = cu.id\n" +
            " left join contract_detail de on c.id = de.contract_id\n" +
            " left join attach_facility att on att.id = de.attach_facility_id\n" +
            " group by c.id", nativeQuery = true)
    List<IContractDto> getAllContracts();
}
