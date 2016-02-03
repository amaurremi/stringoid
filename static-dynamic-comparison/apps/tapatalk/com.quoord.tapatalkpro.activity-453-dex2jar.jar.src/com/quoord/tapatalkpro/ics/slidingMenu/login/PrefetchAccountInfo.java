package com.quoord.tapatalkpro.ics.slidingMenu.login;

import java.io.Serializable;
import java.util.ArrayList;

public class PrefetchAccountInfo
        implements Serializable {
    private static final long serialVersionUID = -3145570441256804759L;
    public String avatorUrl;
    public ArrayList<CustomRegisterField> customFields;
    public String displayName;
    public boolean hasUser;
    public String resultTxt;
    public String uid;
    public String userName;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/PrefetchAccountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */