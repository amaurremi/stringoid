package com.everimaging.fotor.picture.album;

import android.content.Intent;
import android.net.Uri;
import com.everimaging.fotor.App;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;

import java.io.File;
import java.util.Random;

public class a {
    private static final String a = a.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);

    public static final String a(String paramString1, String paramString2) {
        return paramString1 + System.currentTimeMillis() + new Random().nextInt(100) + "." + paramString2;
    }

    public static final void a(String paramString) {
        try {
            paramString = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(paramString)));
            App.b.sendBroadcast(paramString);
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/picture/album/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */