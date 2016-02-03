package com.everimaging.fotor.discovery.entity;

import java.util.List;

public class SuggestionList {
    private List<Suggestion> data;
    private String version;

    public List<Suggestion> getData() {
        return this.data;
    }

    public String getVersion() {
        return this.version;
    }

    public void setData(List<Suggestion> paramList) {
        this.data = paramList;
    }

    public void setVersion(String paramString) {
        this.version = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/entity/SuggestionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */