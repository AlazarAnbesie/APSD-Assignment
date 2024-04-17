package edu.miu.cs.cs489.lab6.ads_dental_app.dto.user;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleResponse;

import java.util.List;

public record UserResponse(
        Long id,
        String name,
        String username,
        String password,
        String email,
        String phone,
        List<RoleResponse> roles
//        Long roleId
) {
}
