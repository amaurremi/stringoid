package com.mopub.mobileads.util.vast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VastVideoConfiguration
        implements Serializable {
    private static final long serialVersionUID = 0L;
    private ArrayList<String> a = new ArrayList();
    private ArrayList<String> b = new ArrayList();
    private ArrayList<String> c = new ArrayList();
    private ArrayList<String> d = new ArrayList();
    private ArrayList<String> e = new ArrayList();
    private ArrayList<String> f = new ArrayList();
    private ArrayList<String> g = new ArrayList();
    private String h;
    private String i;
    private String j;
    private VastCompanionAd k;

    public void addClickTrackers(List<String> paramList) {
        this.g.addAll(paramList);
    }

    public void addCompleteTrackers(List<String> paramList) {
        this.f.addAll(paramList);
    }

    public void addFirstQuartileTrackers(List<String> paramList) {
        this.c.addAll(paramList);
    }

    public void addImpressionTrackers(List<String> paramList) {
        this.a.addAll(paramList);
    }

    public void addMidpointTrackers(List<String> paramList) {
        this.d.addAll(paramList);
    }

    public void addStartTrackers(List<String> paramList) {
        this.b.addAll(paramList);
    }

    public void addThirdQuartileTrackers(List<String> paramList) {
        this.e.addAll(paramList);
    }

    public String getClickThroughUrl() {
        return this.h;
    }

    public List<String> getClickTrackers() {
        return this.g;
    }

    public List<String> getCompleteTrackers() {
        return this.f;
    }

    public String getDiskMediaFileUrl() {
        return this.j;
    }

    public List<String> getFirstQuartileTrackers() {
        return this.c;
    }

    public List<String> getImpressionTrackers() {
        return this.a;
    }

    public List<String> getMidpointTrackers() {
        return this.d;
    }

    public String getNetworkMediaFileUrl() {
        return this.i;
    }

    public List<String> getStartTrackers() {
        return this.b;
    }

    public List<String> getThirdQuartileTrackers() {
        return this.e;
    }

    public VastCompanionAd getVastCompanionAd() {
        return this.k;
    }

    public void setClickThroughUrl(String paramString) {
        this.h = paramString;
    }

    public void setDiskMediaFileUrl(String paramString) {
        this.j = paramString;
    }

    public void setNetworkMediaFileUrl(String paramString) {
        this.i = paramString;
    }

    public void setVastCompanionAd(VastCompanionAd paramVastCompanionAd) {
        this.k = paramVastCompanionAd;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/vast/VastVideoConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */