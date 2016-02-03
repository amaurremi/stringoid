package com.quoord.tapatalkpro.bean;

import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;

import java.io.Serializable;
import java.util.ArrayList;

public class RebrandingConfig
        implements Serializable {
    public static int banner_num = 20;
    private static final long serialVersionUID = -9055097304680999840L;
    private String GAId;
    private int adDisplay;
    private ArrayList<String> adGroupId = new ArrayList();
    private String admobId;
    private String cms_url;
    private String dfp_300x250;
    private String dfp_320x50;
    private String ext;
    private String folder;
    private String interstitials;
    private boolean isShowPoweredBy = true;
    private ArrayList<TabItem> order = new ArrayList();
    private boolean purcahse;
    private int signatureType;
    private String singatureString;
    private String skimId;
    private String vigLinkId;

    public String getAdmobId() {
        return this.admobId;
    }

    public String getCms_url() {
        return this.cms_url;
    }

    public String getDfp_300x250() {
        return this.dfp_300x250;
    }

    public String getDfp_320x50() {
        return this.dfp_320x50;
    }

    public String getExt() {
        return this.ext;
    }

    public String getFolder() {
        return this.folder;
    }

    public String getGAId() {
        return this.GAId;
    }

    public String getInterstitials() {
        return this.interstitials;
    }

    public ArrayList<TabItem> getOrder() {
        return this.order;
    }

    public String getSkimId() {
        return this.skimId;
    }

    public String getVigLinkId() {
        return this.vigLinkId;
    }

    public boolean isPurcahse() {
        return this.purcahse;
    }

    public boolean isShowPoweredBy() {
        return this.isShowPoweredBy;
    }

    public void setAdmobId(String paramString) {
        this.admobId = paramString;
    }

    public void setCms_url(String paramString) {
        this.cms_url = paramString;
    }

    public void setDfp_300x250(String paramString) {
        this.dfp_300x250 = paramString;
    }

    public void setDfp_320x50(String paramString) {
        this.dfp_320x50 = paramString;
    }

    public void setExt(String paramString) {
        this.ext = paramString;
    }

    public void setFolder(String paramString) {
        this.folder = paramString;
    }

    public void setGAId(String paramString) {
        this.GAId = paramString;
    }

    public void setInterstitials(String paramString) {
        this.interstitials = paramString;
    }

    public void setOrder(ArrayList<TabItem> paramArrayList) {
        this.order = paramArrayList;
    }

    public void setPurcahse(boolean paramBoolean) {
        this.purcahse = paramBoolean;
    }

    public void setShowPoweredBy(boolean paramBoolean) {
        this.isShowPoweredBy = paramBoolean;
    }

    public void setSkimId(String paramString) {
        this.skimId = paramString;
    }

    public void setVigLinkId(String paramString) {
        this.vigLinkId = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/RebrandingConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */