package com.inmobi.commons.internal;

import com.inmobi.commons.metric.Logger;

public class ApiStatCollector {
    private static Logger a = new Logger(3, "apiStats", new c());

    public static Logger getLogger() {
        return a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/ApiStatCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */