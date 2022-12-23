package org.cs202.entity.dto.converter;

import org.cs202.entity.concretes.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public Role convert(String role){
        if (role.equalsIgnoreCase("Guest")){
            return Role.GUEST;
        } else if (role.equalsIgnoreCase("ADMINISTRATOR")) {
            return Role.ADMINISTRATOR;
        } else if (role.equalsIgnoreCase("HOUSEKEEPING")) {
            return Role.HOUSEKEEPING;
        } else if (role.equalsIgnoreCase("RECEPTIONIST")) {
            return Role.RECEPTIONIST;
        }
        else {
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
