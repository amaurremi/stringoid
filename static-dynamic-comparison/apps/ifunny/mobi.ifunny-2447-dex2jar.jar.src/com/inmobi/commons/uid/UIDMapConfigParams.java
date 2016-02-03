package com.inmobi.commons.uid;

import com.inmobi.commons.internal.InternalSDKUtil;

import java.util.Map;

public class UIDMapConfigParams {
    private Map<String, Boolean> a;
    private boolean b = true;
    private boolean c = true;
    private boolean d = false;
    private boolean e = true;
    private boolean f = true;
    private boolean g = true;
    private boolean h = true;
    private boolean i = true;
    private boolean j = true;

    public boolean getAIDL() {
        return this.j;
    }

    public boolean getFacebookID() {
        return this.d;
    }

    public boolean getGPID() {
        return this.h;
    }

    public boolean getIMID() {
        return this.i;
    }

    public boolean getLTVID() {
        return this.g;
    }

    public boolean getLoginID() {
        return this.b;
    }

    public Map<String, Boolean> getMap() {
        return this.a;
    }

    public boolean getODIN1() {
        return this.e;
    }

    public boolean getSessionID() {
        return this.c;
    }

    public boolean getUM5() {
        return this.f;
    }

    public void setAIDL(boolean paramBoolean) {
        this.j = paramBoolean;
    }

    public void setFacebookID(boolean paramBoolean) {
        this.d = paramBoolean;
    }

    public void setGPID(boolean paramBoolean) {
        this.h = paramBoolean;
    }

    public void setIMID(boolean paramBoolean) {
        this.i = paramBoolean;
    }

    public void setLTVID(boolean paramBoolean) {
        this.g = paramBoolean;
    }

    public void setLoginID(boolean paramBoolean) {
        this.b = paramBoolean;
    }

    public void setMap(Object paramObject) {
        Map localMap = (Map) paramObject;
        this.b = InternalSDKUtil.getBooleanFromMap(localMap, "LID");
        this.c = InternalSDKUtil.getBooleanFromMap(localMap, "SID");
        this.d = InternalSDKUtil.getBooleanFromMap(localMap, "FBA");
        this.e = InternalSDKUtil.getBooleanFromMap(localMap, "O1");
        this.f = InternalSDKUtil.getBooleanFromMap(localMap, "UM5");
        this.g = InternalSDKUtil.getBooleanFromMap(localMap, "LTVID");
        this.h = InternalSDKUtil.getBooleanFromMap(localMap, "GPID");
        this.i = InternalSDKUtil.getBooleanFromMap(localMap, "IMID");
        this.j = InternalSDKUtil.getBooleanFromMap(localMap, "AIDL");
        this.a = ((Map) paramObject);
    }

    public void setODIN1(boolean paramBoolean) {
        this.e = paramBoolean;
    }

    public void setSessionID(boolean paramBoolean) {
        this.c = paramBoolean;
    }

    public void setUM5(boolean paramBoolean) {
        this.f = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/uid/UIDMapConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */