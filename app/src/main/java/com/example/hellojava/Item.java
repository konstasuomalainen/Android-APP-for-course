package com.example.hellojava;

public class Item {

    private String setId;

    private String setName;

    private String setCompanyForm;

    private String setRegistrationDate;



    public String getRegistrationDate() {
        return setRegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.setRegistrationDate = setRegistrationDate;
    }

    public String getCompanyForm() {
        return setCompanyForm;
    }
    public void setCompanyForm(String companyForm) {
        this.setCompanyForm = setCompanyForm;
    }

    public String getName() {
        return setName;
    }
    public void setName(String name) {
        this.setName = setName;
    }

    public String getId() {
        return setName;
    }
    public void setId(String businessId) {
        this.setId = setId;
    }
}
