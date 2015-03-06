package com.mycompany.servicenow.connector.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SysUserHasRoleCollection {

    @SerializedName("records")
    private List<SysUserHasRole> sysUserHasRoles;

    public List<SysUserHasRole> getsysUserHasRoles() {
        return sysUserHasRoles;
    }

}
