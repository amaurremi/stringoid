package com.everimaging.fotorsdk.database;

import java.util.HashMap;
import java.util.Map;

public abstract class d
        extends c {
    protected Map<String, String> a = new HashMap();

    public d() {
        this.a.put("_id", "integer primary key autoincrement  not null");
        this.a.put("core_filename", "TEXT UNIQUE NOT NULL");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/database/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */