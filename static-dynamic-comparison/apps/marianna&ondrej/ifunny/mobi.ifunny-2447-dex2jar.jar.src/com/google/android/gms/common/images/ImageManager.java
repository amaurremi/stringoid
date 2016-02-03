package com.google.android.gms.common.images;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.internal.oy;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    private static final Object a = new Object();
    private static HashSet<Uri> b = new HashSet();
    private final Context c;
    private final Handler d;
    private final ExecutorService e;
    private final b f;
    private final oy g;
    private final Map<e, ImageManager.ImageReceiver> h;
    private final Map<Uri, ImageManager.ImageReceiver> i;
    private final Map<Uri, Long> j;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/images/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */