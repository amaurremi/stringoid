package com.everimaging.fotorsdk.store.entity;

import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;

public class ResourceInfo {
    private String highDefault;
    private String highPressed;
    private int id;
    private String lowDefault;
    private String lowPressed;
    private String name;
    private String type;
    private String url;

    public PurchasedPack buildPurchasedPack() {
        PurchasedPack localPurchasedPack = new PurchasedPack();
        localPurchasedPack.setHighDefault(this.highDefault);
        localPurchasedPack.setHighPressed(this.highPressed);
        localPurchasedPack.setLowDefault(this.lowDefault);
        localPurchasedPack.setLowPressed(this.lowPressed);
        localPurchasedPack.setPackName(this.name);
        localPurchasedPack.setResourceId(this.id);
        localPurchasedPack.setResourceUrl(this.url);
        localPurchasedPack.setType(this.type);
        return localPurchasedPack;
    }

    public String getHighDefault() {
        return this.highDefault;
    }

    public String getHighPressed() {
        return this.highPressed;
    }

    public int getId() {
        return this.id;
    }

    public String getLowDefault() {
        return this.lowDefault;
    }

    public String getLowPressed() {
        return this.lowPressed;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHighDefault(String paramString) {
        this.highDefault = paramString;
    }

    public void setHighPressed(String paramString) {
        this.highPressed = paramString;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setLowDefault(String paramString) {
        this.lowDefault = paramString;
    }

    public void setLowPressed(String paramString) {
        this.lowPressed = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setType(String paramString) {
        this.type = paramString;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/entity/ResourceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */