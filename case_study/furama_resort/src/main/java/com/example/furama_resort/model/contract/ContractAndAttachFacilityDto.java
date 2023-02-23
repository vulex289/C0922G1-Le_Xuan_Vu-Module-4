package com.example.furama_resort.model.contract;

public class ContractAndAttachFacilityDto {
    private AttachFacility attachFacility;
    private Contract contract;
    private int quantity;

    public ContractAndAttachFacilityDto() {
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
