package com.facebook;

import java.util.List;

class Session$PermissionsPair {
    List<String> declinedPermissions;
    List<String> grantedPermissions;

    public Session$PermissionsPair(List<String> paramList1, List<String> paramList2) {
        this.grantedPermissions = paramList1;
        this.declinedPermissions = paramList2;
    }

    public List<String> getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    public List<String> getGrantedPermissions() {
        return this.grantedPermissions;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$PermissionsPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */