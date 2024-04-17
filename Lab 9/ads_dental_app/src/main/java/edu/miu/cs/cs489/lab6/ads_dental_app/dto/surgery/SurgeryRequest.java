package edu.miu.cs.cs489.lab6.ads_dental_app.dto.surgery;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Address;

public record SurgeryRequest(
        String name,
        Address location,
        String phone
) {
}
