package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.c;

import java.util.Map;

@ii
public class ez {
    private final mz a;
    private final Map<String, String> b;
    private final Context c;

    public ez(mz parammz, Map<String, String> paramMap) {
        this.a = parammz;
        this.b = paramMap;
        this.c = parammz.k();
    }

    DownloadManager.Request a(String paramString1, String paramString2) {
        paramString1 = new DownloadManager.Request(Uri.parse(paramString1));
        paramString1.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, paramString2);
        paramString1.allowScanningByMediaScanner();
        paramString1.setNotificationVisibility(1);
        return paramString1;
    }

    String a(String paramString) {
        return Uri.parse(paramString).getLastPathSegment();
    }

    public void a() {
        if (!new br(this.c).c()) {
            mx.e("Store picture feature is not supported on this device.");
            return;
        }
        if (TextUtils.isEmpty((CharSequence) this.b.get("iurl"))) {
            mx.e("Image url cannot be empty.");
            return;
        }
        String str1 = (String) this.b.get("iurl");
        if (!URLUtil.isValidUrl(str1)) {
            mx.e("Invalid image url:" + str1);
            return;
        }
        String str2 = a(str1);
        if (!lw.c(str2)) {
            mx.e("Image type not recognized:");
            return;
        }
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.c);
        localBuilder.setTitle(lj.a(c.store_picture_title, "Save image"));
        localBuilder.setMessage(lj.a(c.store_picture_message, "Allow Ad to store image in Picture gallery?"));
        localBuilder.setPositiveButton(lj.a(c.accept, "Accept"), new fa(this, str1, str2));
        localBuilder.setNegativeButton(lj.a(c.decline, "Decline"), new fb(this));
        localBuilder.create().show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */