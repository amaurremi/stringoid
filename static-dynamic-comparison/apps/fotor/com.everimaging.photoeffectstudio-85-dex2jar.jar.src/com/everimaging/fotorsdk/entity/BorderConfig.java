package com.everimaging.fotorsdk.entity;

import java.util.List;

public class BorderConfig {
    public List<BorderItem> classes;
    public String package_key;
    public String title;
    public String version;

    public static class BorderItem {
        public String algorithm_file;
        public String mThickness;
        public String sThickness;
        public String title;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/entity/BorderConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */