package com.everimaging.fotor.discovery.entity;

import java.util.ArrayList;

public class InspirationListInfo {
    private ArrayList<InspirationEntity> data;
    private String msg;
    private boolean status;
    private int version;

    public ArrayList<InspirationEntity> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setData(ArrayList<InspirationEntity> paramArrayList) {
        this.data = paramArrayList;
    }

    public void setMsg(String paramString) {
        this.msg = paramString;
    }

    public void setStatus(boolean paramBoolean) {
        this.status = paramBoolean;
    }

    public void setVersion(int paramInt) {
        this.version = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/entity/InspirationListInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */