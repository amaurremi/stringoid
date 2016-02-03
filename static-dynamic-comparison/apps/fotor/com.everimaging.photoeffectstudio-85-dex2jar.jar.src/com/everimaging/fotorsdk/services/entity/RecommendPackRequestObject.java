package com.everimaging.fotorsdk.services.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class RecommendPackRequestObject {
    public List<RecommendPackData> data;
    public String msg;
    public boolean status;

    public static class RecommendPackData {
        public int count;
        public String description;
        public String highDefault;
        public String highPressed;
        public int id;
        public String lowDefault;
        public String lowPressed;
        public String name;
        public String pkgName;
        public float price;
        public String publishDate;
        public String type;

        public void parseFromJsonStr(String paramString) {
            paramString = (RecommendPackData) new GsonBuilder().create().fromJson(paramString, RecommendPackData.class);
            this.id = paramString.id;
            this.name = paramString.name;
            this.type = paramString.type;
            this.highDefault = paramString.highDefault;
            this.highPressed = paramString.highPressed;
            this.lowDefault = paramString.lowDefault;
            this.lowPressed = paramString.lowPressed;
            this.publishDate = paramString.publishDate;
            this.pkgName = paramString.pkgName;
            this.description = paramString.description;
            this.count = paramString.count;
            this.price = paramString.price;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/services/entity/RecommendPackRequestObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */