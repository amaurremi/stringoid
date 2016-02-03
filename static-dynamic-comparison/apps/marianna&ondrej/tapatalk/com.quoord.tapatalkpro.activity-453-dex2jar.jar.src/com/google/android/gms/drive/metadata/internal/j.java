package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class j
        extends a<String> {
    public j(String paramString, int paramInt) {
        super(paramString, paramInt);
    }

    protected void a(Bundle paramBundle, String paramString) {
        paramBundle.putString(getName(), paramString);
    }

    protected String h(DataHolder paramDataHolder, int paramInt1, int paramInt2) {
        return paramDataHolder.getString(getName(), paramInt1, paramInt2);
    }

    protected String l(Bundle paramBundle) {
        return paramBundle.getString(getName());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */