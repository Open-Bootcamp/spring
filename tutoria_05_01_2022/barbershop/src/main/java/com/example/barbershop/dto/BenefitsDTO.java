package com.example.barbershop.dto;

public class BenefitsDTO {

    private Double benefits;


    public BenefitsDTO(){}

    public BenefitsDTO(Double benefits) {
        this.benefits = benefits;
    }

    public Double getBenefits() {
        return benefits;
    }

    public void setBenefits(Double benefits) {
        this.benefits = benefits;
    }
}
