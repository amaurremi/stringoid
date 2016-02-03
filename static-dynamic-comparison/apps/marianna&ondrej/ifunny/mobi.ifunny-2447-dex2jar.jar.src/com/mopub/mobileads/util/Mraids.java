package com.mopub.mobileads.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.mopub.common.util.IntentUtils;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.MraidVideoPlayerActivity;

public class Mraids {
    public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";

    public static boolean isCalendarAvailable(Context paramContext) {
        Intent localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
        return (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) && (IntentUtils.deviceCanHandleIntent(paramContext, localIntent));
    }

    public static boolean isInlineVideoAvailable(Context paramContext) {
        return IntentUtils.deviceCanHandleIntent(paramContext, new Intent(paramContext, MraidVideoPlayerActivity.class));
    }

    public static boolean isSmsAvailable(Context paramContext) {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse("sms:"));
        return IntentUtils.deviceCanHandleIntent(paramContext, localIntent);
    }

    public static boolean isStorePictureSupported(Context paramContext) {
        return ("mounted".equals(Environment.getExternalStorageState())) && (paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
    }

    public static boolean isTelAvailable(Context paramContext) {
        Intent localIntent = new Intent("android.intent.action.DIAL");
        localIntent.setData(Uri.parse("tel:"));
        return IntentUtils.deviceCanHandleIntent(paramContext, localIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/Mraids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */