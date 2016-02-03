package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.ny;

public abstract interface b
        extends IInterface {
    public abstract void a(int paramInt, Bundle paramBundle);

    public abstract void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2);

    public abstract void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor);

    public abstract void a(int paramInt, Bundle paramBundle, jp paramjp);

    public abstract void a(int paramInt, ny paramny);

    public abstract void a(Status paramStatus);

    public abstract void a(DataHolder paramDataHolder, String paramString);

    public abstract void a(DataHolder paramDataHolder, String paramString1, String paramString2);

    public abstract void a(String paramString);

    public abstract void b(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */