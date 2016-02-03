package com.google.android.youtube.player;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.youtube.player.internal.z;

import java.util.List;

public final class YouTubeIntents {
    private static Uri a(String paramString) {
        return Uri.parse("http://www.youtube.com/playlist?list=" + paramString);
    }

    private static String a(Context paramContext) {
        if (z.a(paramContext.getPackageManager())) {
            return "com.google.android.youtube.googletv";
        }
        return "com.google.android.youtube";
    }

    private static boolean a(Context paramContext, Intent paramIntent) {
        paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
        return (paramContext != null) && (!paramContext.isEmpty());
    }

    private static boolean a(Context paramContext, Uri paramUri) {
        return a(paramContext, new Intent("android.intent.action.VIEW", paramUri).setPackage(a(paramContext)));
    }

    private static Intent b(Context paramContext, Uri paramUri) {
        return new Intent("android.intent.action.VIEW", paramUri).setPackage(a(paramContext));
    }

    public static boolean canResolveOpenPlaylistIntent(Context paramContext) {
        return a(paramContext, Uri.parse("http://www.youtube.com/playlist?list="));
    }

    public static boolean canResolvePlayPlaylistIntent(Context paramContext) {
        int i = getInstalledYouTubeVersionCode(paramContext);
        if (z.a(paramContext.getPackageManager())) {
            if (i >= Integer.MAX_VALUE) {
                i = 1;
            }
        }
        while ((i != 0) && (canResolveOpenPlaylistIntent(paramContext))) {
            return true;
            i = 0;
            continue;
            if (i >= 4000) {
                i = 1;
            } else {
                i = 0;
            }
        }
        return false;
    }

    public static boolean canResolvePlayVideoIntent(Context paramContext) {
        return a(paramContext, Uri.parse("http://www.youtube.com/watch?v="));
    }

    public static boolean canResolveSearchIntent(Context paramContext) {
        if ((z.a(paramContext.getPackageManager())) && (getInstalledYouTubeVersionCode(paramContext) < Integer.MAX_VALUE)) {
            return false;
        }
        return a(paramContext, new Intent("android.intent.action.SEARCH").setPackage(a(paramContext)));
    }

    public static boolean canResolveUploadIntent(Context paramContext) {
        return a(paramContext, new Intent("com.google.android.youtube.intent.action.UPLOAD").setPackage(a(paramContext)).setType("video/*"));
    }

    public static boolean canResolveUserIntent(Context paramContext) {
        return a(paramContext, Uri.parse("http://www.youtube.com/user/"));
    }

    public static Intent createOpenPlaylistIntent(Context paramContext, String paramString) {
        paramContext = b(paramContext, a(paramString));
        paramContext.putExtra("authenticate", false);
        return paramContext;
    }

    public static Intent createPlayPlaylistIntent(Context paramContext, String paramString) {
        paramContext = b(paramContext, a(paramString).buildUpon().appendQueryParameter("playnext", "1").build());
        paramContext.putExtra("authenticate", false);
        return paramContext;
    }

    public static Intent createPlayVideoIntent(Context paramContext, String paramString) {
        return createPlayVideoIntentWithOptions(paramContext, paramString, false, false);
    }

    public static Intent createPlayVideoIntentWithOptions(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        return b(paramContext, Uri.parse("http://www.youtube.com/watch?v=" + paramString)).putExtra("force_fullscreen", paramBoolean1).putExtra("finish_on_ended", paramBoolean2);
    }

    public static Intent createSearchIntent(Context paramContext, String paramString) {
        return new Intent("android.intent.action.SEARCH").setPackage(a(paramContext)).putExtra("query", paramString);
    }

    public static Intent createUploadIntent(Context paramContext, Uri paramUri)
            throws IllegalArgumentException {
        if (paramUri == null) {
            throw new IllegalArgumentException("videoUri parameter cannot be null.");
        }
        if (!paramUri.toString().startsWith("content://media/")) {
            throw new IllegalArgumentException("videoUri parameter must be a URI pointing to a valid video file. It must begin with \"content://media/\"");
        }
        return new Intent("com.google.android.youtube.intent.action.UPLOAD").setPackage(a(paramContext)).setDataAndType(paramUri, "video/*");
    }

    public static Intent createUserIntent(Context paramContext, String paramString) {
        return b(paramContext, Uri.parse("http://www.youtube.com/user/" + paramString));
    }

    public static int getInstalledYouTubeVersionCode(Context paramContext) {
        try {
            int i = paramContext.getPackageManager().getPackageInfo(a(paramContext), 0).versionCode;
            return i;
        } catch (PackageManager.NameNotFoundException paramContext) {
        }
        return -1;
    }

    public static String getInstalledYouTubeVersionName(Context paramContext) {
        try {
            paramContext = paramContext.getPackageManager().getPackageInfo(a(paramContext), 0).versionName;
            return paramContext;
        } catch (PackageManager.NameNotFoundException paramContext) {
        }
        return null;
    }

    public static boolean isYouTubeInstalled(Context paramContext) {
        try {
            paramContext.getPackageManager().getApplicationInfo(a(paramContext), 0);
            return true;
        } catch (PackageManager.NameNotFoundException paramContext) {
        }
        return false;
    }

    public final boolean canResolvePlayVideoIntentWithOptions(Context paramContext) {
        int i = getInstalledYouTubeVersionCode(paramContext);
        if (z.a(paramContext.getPackageManager())) {
            if (i >= Integer.MAX_VALUE) {
                i = 1;
            }
        }
        while ((i != 0) && (canResolvePlayVideoIntent(paramContext))) {
            return true;
            i = 0;
            continue;
            if (i >= 3300) {
                i = 1;
            } else {
                i = 0;
            }
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/YouTubeIntents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */