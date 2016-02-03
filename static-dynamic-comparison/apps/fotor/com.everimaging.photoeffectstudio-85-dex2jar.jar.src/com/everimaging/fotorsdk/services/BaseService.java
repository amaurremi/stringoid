package com.everimaging.fotorsdk.services;

import android.content.Context;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class BaseService {
    private static final String b = BaseService.class.getSimpleName();
    private static final FotorLoggerFactory.c c = FotorLoggerFactory.a(b, FotorLoggerFactory.LoggerType.CONSOLE);
    protected Context a;

    public BaseService(Context paramContext) {
        this.a = paramContext;
    }

    public Context a() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/services/BaseService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */