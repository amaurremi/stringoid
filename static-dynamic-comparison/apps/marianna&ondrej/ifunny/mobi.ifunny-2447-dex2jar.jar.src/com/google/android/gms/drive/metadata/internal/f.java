package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.metadata.i;

import java.util.Date;

public class f
        extends i<Date> {
    public f(String paramString, int paramInt) {
        super(paramString, paramInt);
    }

    protected Date c(Bundle paramBundle) {
        return new Date(paramBundle.getLong(a()));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */