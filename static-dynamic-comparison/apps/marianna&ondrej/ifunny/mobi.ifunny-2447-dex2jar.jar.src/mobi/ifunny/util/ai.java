package mobi.ifunny.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.b.a.a.a.a;

import java.util.Iterator;
import java.util.List;

public class ai {
    private static final String[] a = {"com.facebook.katana", "com.thedeck.android.app", "com.seesmic", "com.hootsuite.droid.full"};
    private static final String[] b = {"com.twitter.android", "com.thedeck.android.app", "com.handmark.tweetcaster", "com.seesmic", "com.hootsuite.droid.full", "com.jv.falcon.pro"};

    private static Account a(AccountManager paramAccountManager) {
        paramAccountManager = paramAccountManager.getAccountsByType("com.google");
        if (paramAccountManager.length > 0) {
            return paramAccountManager[0];
        }
        return null;
    }

    public static Intent a(Context paramContext, String paramString) {
        try {
            paramContext.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            paramContext = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/" + paramString));
            paramContext.addFlags(268435456);
            return paramContext;
        } catch (Exception paramContext) {
        }
        return new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/profile.php?id=" + paramString));
    }

    public static Intent a(String paramString) {
        return new Intent("android.intent.action.VIEW", Uri.parse("https://plus.google.com/" + paramString + "/posts"));
    }

    public static String a(Context paramContext) {
        paramContext = a(AccountManager.get(paramContext));
        if (paramContext == null) {
            return null;
        }
        return paramContext.name;
    }

    public static String a(String paramString1, String paramString2) {
        return "https://graph.facebook.com/" + paramString1 + "/picture?type=large&access_token=" + paramString2;
    }

    public static void a(Activity paramActivity) {
        Object localObject = paramActivity.getResources();
        if (r.b()) {
        }
        for (localObject = ((Resources) localObject).getString(2131690159); ; localObject = ((Resources) localObject).getString(2131690160)) {
            localObject = new Intent("android.intent.action.VIEW", Uri.parse((String) localObject));
            ((Intent) localObject).addFlags(1074266112);
            paramActivity.startActivity((Intent) localObject);
            return;
        }
    }

    public static void a(Activity paramActivity, String paramString) {
        paramActivity.startActivity(Intent.createChooser(a.a(null, paramString), paramActivity.getString(2131689647)));
    }

    public static void a(Activity paramActivity, String paramString1, String paramString2) {
        Intent localIntent = a.a(paramString1, paramString2);
        localIntent.setFlags(8912896);
        List localList = paramActivity.getPackageManager().queryIntentActivities(localIntent, 0);
        Object localObject = null;
        String[] arrayOfString = b;
        int j = arrayOfString.length;
        int i = 0;
        if (i < j) {
            String str = arrayOfString[i];
            Iterator localIterator = localList.iterator();
            for (; ; ) {
                if (localIterator.hasNext()) {
                    ResolveInfo localResolveInfo = (ResolveInfo) localIterator.next();
                    if (TextUtils.equals(localResolveInfo.activityInfo.packageName, str)) {
                        localObject = localResolveInfo;
                        label105:
                        if (localObject == null) {
                            break;
                        }
                    }
                }
            }
        }
        for (; ; ) {
            if (localObject == null) {
                b(paramActivity, paramString1, paramString2);
                return;
                i += 1;
                break;
            }
            localIntent.setClassName(((ResolveInfo) localObject).activityInfo.packageName, ((ResolveInfo) localObject).activityInfo.name);
            paramActivity.startActivity(localIntent);
            return;
            break label105;
        }
    }

    public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4) {
        o.a(paramActivity, paramString1, paramString2, paramString3, paramString4);
    }

    public static void a(Context paramContext, String paramString1, String paramString2) {
        paramString2 = paramContext.getResources().getString(2131689928, new Object[]{paramString2});
        if (TextUtils.isEmpty(paramString1)) {
        }
        for (paramString1 = paramString2; ; paramString1 = paramString2 + ": " + paramString1) {
            Toast.makeText(paramContext, paramString1, 0).show();
            return;
        }
    }

    public static Intent b(Context paramContext, String paramString) {
        try {
            paramContext.getPackageManager().getPackageInfo("com.twitter.android", 0);
            paramContext = new Intent("android.intent.action.VIEW", Uri.parse("twitter://user?user_id=" + paramString));
            paramContext.addFlags(268435456);
            return paramContext;
        } catch (Exception paramContext) {
        }
        return new Intent("android.intent.action.VIEW", Uri.parse("https://mobile.twitter.com/intent/user?user_id=" + paramString));
    }

    public static void b(Activity paramActivity, String paramString1, String paramString2) {
        paramActivity.startActivity(Intent.createChooser(a.a(paramString1, paramString1 + " - " + paramString2), paramActivity.getString(2131689647)));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */