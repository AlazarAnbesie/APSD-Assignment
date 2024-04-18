package edu.miu.cs.cs489.lab6.ads_dental_app.dto.role;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.RoleType;

public record RoleResponse(
        Long id,
        RoleType roleType
) {
}
