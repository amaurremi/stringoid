package com.tapstream.sdk;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private boolean collectAdvertisingId = true;
    private boolean collectAndroidId = true;
    private boolean collectDeviceId = true;
    private boolean collectTasteData = true;
    private boolean collectWifiMac = true;
    private boolean fireAutomaticInstallEvent = true;
    private boolean fireAutomaticOpenEvent = true;
    public Map<String, Object> globalEventParams = new HashMap();
    private String hardware = null;
    private String installEventName = null;
    private String odin1 = null;
    private String openEventName = null;
    private String openUdid = null;

    public boolean getCollectAdvertisingId() {
        return this.collectAdvertisingId;
    }

    public boolean getCollectAndroidId() {
        return this.collectAndroidId;
    }

    public boolean getCollectDeviceId() {
        return this.collectDeviceId;
    }

    public boolean getCollectTasteData() {
        return this.collectTasteData;
    }

    public boolean getCollectWifiMac() {
        return this.collectWifiMac;
    }

    public boolean getFireAutomaticInstallEvent() {
        return this.fireAutomaticInstallEvent;
    }

    public boolean getFireAutomaticOpenEvent() {
        return this.fireAutomaticOpenEvent;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String getInstallEventName() {
        return this.installEventName;
    }

    public String getOdin1() {
        return this.odin1;
    }

    public String getOpenEventName() {
        return this.openEventName;
    }

    public String getOpenUdid() {
        return this.openUdid;
    }

    public void setCollectAdvertisingId(boolean paramBoolean) {
        this.collectAdvertisingId = paramBoolean;
    }

    public void setCollectAndroidId(boolean paramBoolean) {
        this.collectAndroidId = paramBoolean;
    }

    public void setCollectDeviceId(boolean paramBoolean) {
        this.collectDeviceId = paramBoolean;
    }

    public void setCollectTasteData(boolean paramBoolean) {
        this.collectTasteData = paramBoolean;
    }

    public void setCollectWifiMac(boolean paramBoolean) {
        this.collectWifiMac = paramBoolean;
    }

    public void setFireAutomaticInstallEvent(boolean paramBoolean) {
        this.fireAutomaticInstallEvent = paramBoolean;
    }

    public void setFireAutomaticOpenEvent(boolean paramBoolean) {
        this.fireAutomaticOpenEvent = paramBoolean;
    }

    public void setHardware(String paramString) {
        this.hardware = paramString;
    }

    public void setInstallEventName(String paramString) {
        this.installEventName = paramString;
    }

    public void setOdin1(String paramString) {
        this.odin1 = paramString;
    }

    public void setOpenEventName(String paramString) {
        this.openEventName = paramString;
    }

    public void setOpenUdid(String paramString) {
        this.openUdid = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */