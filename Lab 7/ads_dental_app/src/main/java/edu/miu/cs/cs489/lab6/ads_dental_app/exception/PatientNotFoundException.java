package edu.miu.cs.cs489.lab6.ads_dental_app.exception;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String message) {
        super(message);
    }
}
