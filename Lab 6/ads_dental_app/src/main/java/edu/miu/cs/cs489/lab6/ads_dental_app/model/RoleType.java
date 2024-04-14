package edu.miu.cs.cs489.lab6.ads_dental_app.model;


import lombok.Getter;

@Getter
public enum RoleType {
    DENTIST("Dentist"),
    OFFICE_MANAGER("OfficeManager"),
    PATIENT("Patient");

    private final String value;

        RoleType(String value) {
            this.value = value;
        }

}
