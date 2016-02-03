package com.everimaging.fotorsdk.entity;

import java.util.List;

public class EffectConfig {
    public List<EffectItem> classes;
    public String package_key;
    public String title;
    public String version;

    public static class EffectItem {
        public String algorithm_file;
        public String title;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/entity/EffectConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */