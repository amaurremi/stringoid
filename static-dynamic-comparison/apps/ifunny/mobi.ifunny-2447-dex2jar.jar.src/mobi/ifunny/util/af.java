package mobi.ifunny.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.support.v4.app.av;
import android.support.v4.app.aw;
import android.support.v4.app.bi;
import android.support.v4.app.bv;
import android.text.TextUtils;
import mobi.ifunny.main.IFunnyMenuActivity;
import mobi.ifunny.main.a.b;

public class af {
    private static int a = 0;
    private static final String b = IFunnyMenuActivity.class.getCanonicalName();

    public static int a() {
        int i = a;
        a = (a + 1) % 90;
        return i + 10;
    }

    public static void a(Context paramContext) {
        ((NotificationManager) paramContext.getSystemService("notification")).cancel(0);
    }

    public static void a(Context paramContext, int paramInt) {
        b(paramContext, paramInt);
        c(paramContext, paramInt);
        d(paramContext, paramInt);
    }

    public static void a(Context paramContext, int paramInt, boolean paramBoolean, String paramString) {
        Resources localResources = paramContext.getResources();
        aw localaw = new aw(paramContext);
        Object localObject;
        String str1;
        if (paramBoolean) {
            localObject = localResources.getString(2131690098);
            str1 = localResources.getString(2131690097);
        }
        for (; ; ) {
            localaw.c((CharSequence) localObject).a((CharSequence) localObject).b(str1);
            paramString = new av();
            paramString.a(str1);
            localaw.a(paramString);
            a(localaw);
            localaw.a(BitmapFactory.decodeResource(localResources, 2130837776));
            localaw.c(true);
            localaw.d(true);
            localaw.b(true);
            paramString = new Intent(paramContext, IFunnyMenuActivity.class);
            paramString.setFlags(335544320);
            paramString.putExtra("intent.start_fragment", b.f);
            localaw.a(PendingIntent.getActivity(paramContext, 0, paramString, 134217728));
            paramContext = bv.a(paramContext);
            if (!r.b()) {
                break;
            }
            if (paramInt > 0) {
                paramContext.a(paramInt);
            }
            paramContext.a(a(), localaw.b());
            return;
            String str2 = localResources.getString(2131690095);
            localObject = str2;
            str1 = paramString;
            if (TextUtils.isEmpty(paramString)) {
                str1 = localResources.getString(2131690096);
                localObject = str2;
            }
        }
        if (paramInt > 0) {
        }
        for (; ; ) {
            paramContext.a(paramInt, localaw.b());
            return;
            paramInt = a();
        }
    }

    public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
        aw localaw = new aw(paramContext);
        localaw.c(paramString1).a(paramString2).b(paramString3);
        a(localaw);
        localaw.c(true).b(true);
        paramString1 = Bitmap.createBitmap(320, 320, Bitmap.Config.ARGB_8888);
        new Canvas(paramString1).drawColor(paramContext.getResources().getColor(2131361857));
        paramString2 = new bi();
        paramString2.a(false);
        paramString2.a(paramString1);
        paramString2.a(0);
        localaw.a(paramString2);
        paramString1 = new Intent(paramContext, IFunnyMenuActivity.class);
        paramString1.setFlags(335544320);
        paramString1.putExtra("intent.start_fragment", b.a);
        localaw.a(PendingIntent.getActivity(paramContext, 0, paramString1, 134217728));
        bv.a(paramContext).a(0, localaw.b());
    }

    private static void a(aw paramaw) {
        paramaw.a(2130837775);
    }

    public static aw b(Context paramContext) {
        Resources localResources = paramContext.getResources();
        aw localaw = new aw(paramContext);
        localaw.a(localResources.getString(2131690091));
        localaw.b(localResources.getString(2131690090));
        a(localaw);
        localaw.d(true);
        localaw.a(PendingIntent.getActivity(paramContext, 0, new Intent(), 134217728));
        localaw.a(true).b(true);
        return localaw;
    }

    public static void b(Context paramContext, int paramInt) {
        try {
            String[] arrayOfString = new String[1];
            arrayOfString[0] = paramContext.getPackageName();
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("package", arrayOfString[0]);
            localContentValues.put("class", b);
            localContentValues.put("badgecount", Integer.valueOf(paramInt));
            paramContext = paramContext.getContentResolver();
            Uri localUri = Uri.parse("content://com.sec.badge/apps");
            paramInt = paramContext.update(localUri, localContentValues, "package=?", arrayOfString);
            if (paramInt == 0) {
                paramContext.insert(localUri, localContentValues);
                return;
            }
            if (paramInt > 1) {
                paramContext.delete(localUri, "package=?", arrayOfString);
                paramContext.insert(localUri, localContentValues);
                return;
            }
        } catch (Exception paramContext) {
        }
    }

    public static void c(Context paramContext, int paramInt) {
        Intent localIntent = new Intent();
        localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", b);
        if (paramInt > 0) {
        }
        for (boolean bool = true; ; bool = false) {
            localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", bool);
            localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", Integer.toString(paramInt));
            localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", paramContext.getPackageName());
            paramContext.sendBroadcast(localIntent);
            return;
        }
    }

    public static void d(Context paramContext, int paramInt) {
        try {
            String str = paramContext.getPackageName() + "/" + b;
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("tag", str);
            localContentValues.put("count", Integer.valueOf(paramInt));
            paramContext.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), localContentValues);
            return;
        } catch (Exception paramContext) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */