package com.b.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;

import java.util.List;

public class a {
    public static Intent a() {
        return a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    public static Intent a(Uri paramUri) {
        paramUri = new Intent("android.intent.action.PICK", paramUri);
        paramUri.setType("image/*");
        return paramUri;
    }

    public static Intent a(String paramString1, String paramString2) {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.SEND");
        if (!TextUtils.isEmpty(paramString1)) {
            localIntent.putExtra("android.intent.extra.SUBJECT", paramString1);
        }
        localIntent.putExtra("android.intent.extra.TEXT", paramString2);
        localIntent.setType("text/plain");
        return localIntent;
    }

    public static Intent a(String paramString1, String paramString2, String paramString3) {
        return a(new String[]{paramString1}, paramString2, paramString3);
    }

    public static Intent a(String[] paramArrayOfString, String paramString1, String paramString2) {
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setType("message/rfc822");
        localIntent.putExtra("android.intent.extra.EMAIL", paramArrayOfString);
        localIntent.putExtra("android.intent.extra.SUBJECT", paramString1);
        localIntent.putExtra("android.intent.extra.TEXT", paramString2);
        return localIntent;
    }

    public static boolean a(Context paramContext, Intent paramIntent) {
        return paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0;
    }

    public static Intent b(String paramString1, String paramString2) {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + paramString1));
        localIntent.putExtra("address", paramString1);
        localIntent.putExtra("sms_body", paramString2);
        localIntent.setType("vnd.android-dir/mms-sms");
        return localIntent;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/b/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */