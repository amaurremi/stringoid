package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

final class ImageManager$ImageReceiver
        extends ResultReceiver {
    private final Uri b;
    private final ArrayList<e> c;

    public void onReceiveResult(int paramInt, Bundle paramBundle) {
        paramBundle = (ParcelFileDescriptor) paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
        ImageManager.f(this.a).execute(new c(this.a, this.b, paramBundle));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/images/ImageManager$ImageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */