package mobi.ifunny.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.b.a.a.a.a;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Random;

import mobi.ifunny.social.auth.l;

public class r {
    private static final NumberFormat a = ;
    private static final Random b = new Random();

    private static int a(Date paramDate1, Date paramDate2) {
        return (int) ((paramDate2.getTime() - paramDate1.getTime()) / 86400000L);
    }

    public static String a(int paramInt) {
        if (paramInt <= 0) {
            return null;
        }
        if (paramInt >= 1000) {
            return "999+";
        }
        return String.valueOf(paramInt);
    }

    public static String a(int paramInt1, int paramInt2) {
        paramInt2 = paramInt1 - paramInt2;
        paramInt1 = paramInt2;
        if (paramInt2 < 0) {
            paramInt1 = 0;
        }
        if (paramInt1 >= 100000) {
            return d(paramInt1 / 1000) + "K";
        }
        return d(paramInt1);
    }

    public static String a(long paramLong, Context paramContext) {
        java.text.DateFormat localDateFormat = a(paramContext);
        paramContext = paramContext.getResources();
        Date localDate1 = new Date(paramLong);
        Date localDate2 = new Date(System.currentTimeMillis());
        int i = a(localDate1, localDate2);
        if (i > 30) {
            return localDateFormat.format(localDate1);
        }
        if (i > 0) {
            return String.format(paramContext.getQuantityString(2131623953, i), new Object[]{Integer.valueOf(i)});
        }
        i = b(localDate1, localDate2);
        if (i > 0) {
            return String.format(paramContext.getQuantityString(2131623954, i), new Object[]{Integer.valueOf(i)});
        }
        i = c(localDate1, localDate2);
        if (i > 0) {
            return String.format(paramContext.getQuantityString(2131623955, i), new Object[]{Integer.valueOf(i)});
        }
        return String.format(b(paramContext, 2131623956, 2131690193, Math.max(d(localDate1, localDate2), 0)), new Object[0]);
    }

    public static String a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt3 <= 0) {
            return paramResources.getString(paramInt2);
        }
        if (paramInt3 >= 1000) {
            return paramResources.getQuantityString(paramInt1, 1000, new Object[]{d(paramInt3 / 1000) + "K"});
        }
        return paramResources.getQuantityString(paramInt1, paramInt3, new Object[]{String.valueOf(paramInt3)});
    }

    public static String a(String paramString) {
        if (paramString == null) {
            return null;
        }
        return paramString.replaceAll("(\\r|\\n)", " ");
    }

    public static String a(String paramString, int paramInt) {
        return a(paramString, paramInt, "...");
    }

    public static String a(String paramString1, int paramInt, String paramString2) {
        if ((paramString1 == null) || (paramString1.length() <= paramInt)) {
            return paramString1;
        }
        return paramString1.substring(0, paramInt - paramString2.length()) + paramString2;
    }

    private static java.text.DateFormat a(Context paramContext) {
        return android.text.format.DateFormat.getDateFormat(paramContext);
    }

    public static void a(Activity paramActivity) {
        Resources localResources = paramActivity.getResources();
        Object localObject = l.a();
        if (((l) localObject).h()) {
        }
        for (localObject = ((l) localObject).e(); ; localObject = "-") {
            localObject = localResources.getString(2131690166, new Object[]{localObject, "4.0", Build.MANUFACTURER + " " + Build.MODEL + " " + Build.PRODUCT, Build.VERSION.RELEASE});
            localObject = a.a(localResources.getString(2131690155), localResources.getString(2131690165), (String) localObject);
            ((Intent) localObject).addFlags(1073741824);
            if (a.a(paramActivity, (Intent) localObject)) {
                break;
            }
            Toast.makeText(paramActivity, 2131689637, 0).show();
            return;
        }
        try {
            paramActivity.startActivityForResult(Intent.createChooser((Intent) localObject, localResources.getString(2131689647)), 0);
            return;
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            Toast.makeText(paramActivity, 2131689637, 0).show();
        }
    }

    public static boolean a() {
        return l.a().h();
    }

    public static int b(int paramInt1, int paramInt2) {
        return b.nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
    }

    private static int b(Date paramDate1, Date paramDate2) {
        return (int) ((paramDate2.getTime() - paramDate1.getTime()) / 3600000L);
    }

    public static String b(int paramInt) {
        if (paramInt <= 0) {
            return null;
        }
        if (paramInt >= 1000) {
            return d(paramInt / 1000) + "K";
        }
        return String.valueOf(paramInt);
    }

    public static String b(long paramLong, Context paramContext) {
        java.text.DateFormat localDateFormat = a(paramContext);
        paramContext = paramContext.getResources();
        Date localDate1 = new Date(paramLong);
        Date localDate2 = new Date(System.currentTimeMillis());
        int i = a(localDate1, localDate2);
        if (i > 30) {
            return localDateFormat.format(localDate1);
        }
        if (i > 0) {
            return String.format(paramContext.getQuantityString(2131623938, i), new Object[]{Integer.valueOf(i)});
        }
        i = b(localDate1, localDate2);
        if (i > 0) {
            return String.format(paramContext.getQuantityString(2131623939, i), new Object[]{Integer.valueOf(i)});
        }
        i = c(localDate1, localDate2);
        if (i > 0) {
            return String.format(paramContext.getQuantityString(2131623940, i), new Object[]{Integer.valueOf(i)});
        }
        return String.format(b(paramContext, 2131623941, 2131689539, Math.max(d(localDate1, localDate2), 0)), new Object[0]);
    }

    public static String b(Resources paramResources, int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt3 == 0) {
            return paramResources.getString(paramInt2);
        }
        return paramResources.getQuantityString(paramInt1, paramInt3, new Object[]{d(paramInt3)});
    }

    public static boolean b() {
        return TextUtils.equals("google", "amazon");
    }

    public static boolean b(String paramString) {
        return paramString.matches("^.+\\@.+\\.([a-zA-Z0-9]{2,})$");
    }

    public static int c(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return 0;
        }
        String str = paramString;
        if (paramString.charAt(0) != '#') {
            str = '#' + paramString;
        }
        try {
            int i = Color.parseColor(str);
            return i;
        } catch (Exception paramString) {
        }
        return 0;
    }

    private static int c(Date paramDate1, Date paramDate2) {
        return (int) ((paramDate2.getTime() - paramDate1.getTime()) / 60000L);
    }

    public static String c(int paramInt) {
        if (paramInt >= 100000) {
            return d(paramInt / 1000) + "K";
        }
        return d(paramInt);
    }

    private static int d(Date paramDate1, Date paramDate2) {
        return (int) ((paramDate2.getTime() - paramDate1.getTime()) / 1000L);
    }

    public static String d(int paramInt) {
        return a.format(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */