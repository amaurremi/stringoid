package com.quoord.tapatalkpro.util;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.activity.forum.CreateTopicActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.tabwidget.manager.FavForumWidgetManager;
import com.quoord.tapatalkpro.tabwidget.manager.FavTopicsWidgetManager;
import com.quoord.tapatalkpro.tabwidget.manager.PMWidgetManager;
import com.quoord.tools.ForumHttpStatus;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@SuppressLint({"NewApi"})
public class Util {
    public static final HostnameVerifier DO_NOT_VERIFY;
    static final int MAXTHREAD = 4;
    public static final int MILLISECOND_IN_AN_HOUR = 3600000;
    public static final int MILLISECOND_IN_A_DAY = 86400000;
    public static final int SECOND_IN_A_DAY = 86400;
    public static int counter = 0;
    public static String email_expression = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    public static String googleAdsId;
    private static long lastClickTime = 0L;
    public static Object lock;
    static int maxsize = 0;
    static int size = 0;
    public static String tag = "util";
    public static final int timeout = 30000;
    public static Date today;
    public static String username_expression = "[A-Za-z0-9_\\.\\s]{3,32}$";

    static {
        googleAdsId = null;
        lock = new Object();
        maxsize = 10;
        size = 0;
        counter = 0;
        DO_NOT_VERIFY = new HostnameVerifier() {
            public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession) {
                return true;
            }
        };
        today = new Date();
    }

    public static boolean DateCompareTheDayUpdate(String paramString1, String paramString2, int paramInt)
            throws Exception {
        if (paramString2.equals("")) {
        }
        do {
            return true;
            SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            paramString1 = localSimpleDateFormat.parse(paramString1);
            paramString2 = localSimpleDateFormat.parse(paramString2);
        } while (Math.abs((paramString1.getTime() - paramString2.getTime()) / 86400000L) >= paramInt);
        return false;
    }

    public static void byoRate(Activity paramActivity) {
        Object localObject = paramActivity.getPreferences(0);
        SharedPreferences.Editor localEditor = paramActivity.getPreferences(0).edit();
        int i = ((SharedPreferences) localObject).getInt("start_count_for_rate", 0) + 1;
        localEditor.putInt("start_count_for_rate", i);
        localEditor.commit();
        if ((i == 20) && (Prefs.get(paramActivity).getBoolean("should_rate", true))) {
            localObject = new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131100085)).setMessage(paramActivity.getString(2131100493)).setPositiveButton(2131100088, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    try {
                        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW");
                        paramAnonymousDialogInterface.setData(Uri.parse(TapatalkApp.rate_url));
                        Util.this.startActivity(paramAnonymousDialogInterface);
                        return;
                    } catch (Exception paramAnonymousDialogInterface) {
                    }
                }
            }).setNegativeButton(2131100089, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            }).create();
            if ((!paramActivity.getResources().getBoolean(2131558402)) && (!paramActivity.getResources().getBoolean(2131558401))) {
                break label157;
            }
            ((AlertDialog) localObject).setTitle("Rate Us");
        }
        for (; ; ) {
            ((AlertDialog) localObject).show();
            return;
            label157:
            ((AlertDialog) localObject).setTitle(paramActivity.getString(2131100085));
        }
    }

    public static boolean cachePicFullPath(String paramString1, String paramString2) {
        if ((paramString1 != null) && (paramString1.length() > 0)) {
            try {
                Object localObject = new File(paramString1);
                if (((File) localObject).exists()) {
                    ((File) localObject).delete();
                }
                paramString2 = new FileInputStream(paramString2);
                paramString1 = new FileOutputStream(paramString1);
                localObject = new byte['Ѐ'];
                for (; ; ) {
                    int i = paramString2.read((byte[]) localObject);
                    if (i <= 0) {
                        paramString2.close();
                        paramString1.close();
                        return true;
                    }
                    paramString1.write((byte[]) localObject, 0, i);
                }
                return false;
            } catch (Exception paramString1) {
                paramString1.printStackTrace();
            }
        }
    }

    public static boolean checkBitmap(String paramString) {
        boolean bool = true;
        if ((paramString == null) || (paramString.length() == 0)) {
            bool = false;
        }
        int i;
        int j;
        do {
            return bool;
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(paramString, localOptions);
            i = localOptions.outHeight;
            j = localOptions.outHeight;
        } while ((i > 0) && (j > 0));
        return false;
    }

    public static boolean checkEditText(EditText paramEditText) {
        return (paramEditText != null) && (paramEditText.getText().toString() != null) && (!"".equals(paramEditText.getText().toString().trim()));
    }

    public static boolean checkEmailFormat(String paramString) {
        return Pattern.compile(email_expression).matcher(paramString).matches();
    }

    public static boolean checkLocalData(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
        }
        while (!new File(paramString).exists()) {
            return false;
        }
        return true;
    }

    public static boolean checkString(String paramString) {
        return (paramString != null) && (!"".equals(paramString));
    }

    public static boolean checkUsernameFormat(String paramString) {
        return Pattern.compile(username_expression).matcher(paramString).matches();
    }

    public static void clearAllSigninForums(Context paramContext, ArrayList<TapatalkForum> paramArrayList, int paramInt) {
        try {
            paramContext = Prefs.get(paramContext).edit();
            int j = paramArrayList.size();
            int i = 0;
            for (; ; ) {
                if (i >= j) {
                    paramContext.commit();
                    return;
                }
                Object localObject = (TapatalkForum) paramArrayList.get(i);
                String str = ((TapatalkForum) localObject).getId().intValue() + paramInt + ((TapatalkForum) localObject).getName() + "usesignin";
                localObject = paramInt + ((TapatalkForum) localObject).getId() + ((TapatalkForum) localObject).getLowerUserName() + "usesignin";
                paramContext.putString(str, "");
                paramContext.putString((String) localObject, "");
                i += 1;
            }
            return;
        } catch (Exception paramContext) {
        }
    }

    public static void clearSigninForum(Context paramContext, TapatalkForum paramTapatalkForum, int paramInt) {
        try {
            paramContext = Prefs.get(paramContext).edit();
            String str = paramTapatalkForum.getId().intValue() + paramInt + paramTapatalkForum.getName() + "usesignin";
            paramTapatalkForum = paramInt + paramTapatalkForum.getId() + paramTapatalkForum.getLowerUserName() + "usesignin";
            paramContext.putString(str, "");
            paramContext.putString(paramTapatalkForum, "");
            paramContext.commit();
            return;
        } catch (Exception paramContext) {
        }
    }

    public static boolean compareTwoString(String paramString1, String paramString2) {
        if (checkString(paramString1)) {
            return paramString1.equals(paramString2);
        }
        return false;
    }

    public static void copyFile(File paramFile1, File paramFile2)
            throws IOException {
        paramFile1 = new FileInputStream(paramFile1);
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramFile1);
        paramFile2 = new FileOutputStream(paramFile2);
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramFile2);
        byte[] arrayOfByte = new byte['᐀'];
        for (; ; ) {
            int i = localBufferedInputStream.read(arrayOfByte);
            if (i == -1) {
                localBufferedOutputStream.flush();
                localBufferedInputStream.close();
                localBufferedOutputStream.close();
                paramFile2.close();
                paramFile1.close();
                return;
            }
            localBufferedOutputStream.write(arrayOfByte, 0, i);
        }
    }

    public static Bitmap cutBitmap(Bitmap paramBitmap, Rect paramRect, Bitmap.Config paramConfig, int paramInt1, int paramInt2) {
        int n = paramRect.width();
        int i1 = paramRect.height();
        int k = paramBitmap.getWidth();
        int m = paramBitmap.getHeight();
        int j;
        int i;
        if ((k < n) && (m < i1)) {
            j = k;
            i = m;
        }
        for (; ; ) {
            paramConfig = Bitmap.createBitmap(j, i, paramConfig);
            new Canvas(paramConfig).drawBitmap(paramBitmap, paramRect, new Rect((paramConfig.getWidth() - paramInt1) / 2, (paramConfig.getHeight() - paramInt2) / 2, (paramConfig.getWidth() - paramInt1) / 2 + paramInt1, (paramConfig.getHeight() - paramInt2) / 2 + paramInt1), null);
            if (k >= paramInt1) {
                paramBitmap = paramConfig;
                if (m >= paramInt2) {
                }
            } else {
                paramBitmap = Bitmap.createBitmap(matrixImage(paramConfig, paramInt1, paramInt2));
            }
            return paramBitmap;
            if ((k < n) && (m > i1)) {
                j = k;
                i = i1;
            } else {
                i = i1;
                j = n;
                if (k > n) {
                    i = i1;
                    j = n;
                    if (m < i1) {
                        i = m;
                        j = n;
                    }
                }
            }
        }
    }

    public static Bitmap decodeLocalBlogImage(String paramString, int paramInt1, int paramInt2) {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        int i = 1;
        int j = localOptions.outWidth;
        int k = localOptions.outHeight;
        if (j > 800) {
            if (j <= paramInt1) {
            }
        }
        for (i = j / paramInt1; ; i = (int) Math.pow(2.0D, (int) Math.round(Math.log(paramInt1 / Math.max(j, k)) / Math.log(0.5D)))) {
            do {
                paramInt1 = i;
                if (i < 1) {
                    paramInt1 = 1;
                }
                localOptions.inJustDecodeBounds = false;
                localOptions.inSampleSize = paramInt1;
                localOptions.inPurgeable = true;
                return BitmapFactory.decodeFile(paramString, localOptions);
            } while ((j <= paramInt1) && (k <= paramInt2));
        }
    }

    public static Bitmap decodeLocalFullBlogImage(String paramString, int paramInt1, int paramInt2) {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        int i = 1;
        int j = localOptions.outWidth;
        int k = localOptions.outHeight;
        if ((j > paramInt1) || (k > paramInt2)) {
            i = (int) Math.pow(2.0D, (int) Math.round(Math.log(paramInt1 / Math.max(j, k)) / Math.log(0.5D)));
        }
        paramInt1 = i;
        if (i < 1) {
            paramInt1 = 1;
        }
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = paramInt1;
        localOptions.inPurgeable = true;
        return BitmapFactory.decodeFile(paramString, localOptions);
    }

    public static Bitmap decodeLocalImage(String paramString, int paramInt1, int paramInt2) {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        int i = 1;
        int j = localOptions.outWidth;
        int k = localOptions.outHeight;
        if ((j == 1) && (k == 1)) {
            return null;
        }
        if ((j > paramInt1) || (k > paramInt2)) {
            i = (int) Math.pow(2.0D, (int) Math.round(Math.log(paramInt1 / Math.max(j, k)) / Math.log(0.5D)));
        }
        paramInt1 = i;
        if (i < 1) {
            paramInt1 = 1;
        }
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = paramInt1;
        localOptions.inPurgeable = true;
        return BitmapFactory.decodeFile(paramString, localOptions);
    }

    public static Bitmap decodeLocalImageUri(Context paramContext, Uri paramUri, int paramInt1, int paramInt2) {
        for (; ; ) {
            int i;
            try {
                localOptions = new BitmapFactory.Options();
                localOptions.inJustDecodeBounds = true;
                localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
                BitmapFactory.decodeStream(localInputStream, null, localOptions);
                i = 1;
                int j = localOptions.outWidth;
                int k = localOptions.outHeight;
                if ((j <= paramInt1) && (k <= paramInt2)) {
                    break label148;
                }
                i = (int) Math.pow(2.0D, (int) Math.round(Math.log(paramInt1 / Math.max(j, k)) / Math.log(0.5D)));
            } catch (Exception paramContext) {
                BitmapFactory.Options localOptions;
                InputStream localInputStream;
                paramContext.printStackTrace();
                return null;
            }
            localInputStream.close();
            localOptions.inJustDecodeBounds = false;
            localOptions.inSampleSize = paramInt1;
            localOptions.inPurgeable = true;
            paramContext = BitmapFactory.decodeStream(paramContext.getContentResolver().openInputStream(paramUri), null, localOptions);
            return paramContext;
            label148:
            paramInt1 = i;
            if (i < 1) {
                paramInt1 = 1;
            }
        }
    }

    public static void del(String paramString)
            throws IOException {
        try {
            paramString = new File(paramString);
            File[] arrayOfFile;
            int j;
            int i;
            if ((paramString.exists()) && (paramString.isDirectory())) {
                if (paramString.listFiles().length == 0) {
                    paramString.delete();
                    return;
                }
                arrayOfFile = paramString.listFiles();
                j = paramString.listFiles().length;
                i = 0;
            }
            while (i < j) {
                if (arrayOfFile[i].isDirectory()) {
                    del(arrayOfFile[i].getAbsolutePath());
                }
                arrayOfFile[i].delete();
                i += 1;
                continue;
                paramString.delete();
                return;
            }
        } catch (Exception paramString) {
        }
    }

    public static void delFile(String paramString) {
        try {
            paramString = new File(paramString);
            if (paramString.exists()) {
                paramString.delete();
            }
            return;
        } catch (Exception paramString) {
        }
    }

    public static String delHTMLTag(String paramString) {
        paramString = Pattern.compile("<script[^>]*?>[\\s\\S]*?<\\/script>", 2).matcher(paramString).replaceAll("");
        paramString = Pattern.compile("<style[^>]*?>[\\s\\S]*?<\\/style>", 2).matcher(paramString).replaceAll("");
        return Pattern.compile("<[^>]+>", 2).matcher(paramString).replaceAll("").trim();
    }

    public static void deleteAllSignOutCache(Context paramContext) {
        Object localObject = Prefs.get(paramContext);
        paramContext = ((SharedPreferences) localObject).edit();
        localObject = ((HashMap) ((SharedPreferences) localObject).getAll()).keySet().iterator();
        for (; ; ) {
            if (!((Iterator) localObject).hasNext()) {
                paramContext.commit();
                return;
            }
            String str = (String) ((Iterator) localObject).next();
            if (str.contains("user_logout")) {
                paramContext.remove(str);
            }
        }
    }

    public static void deleteAllWidget(Context paramContext) {
        try {
            FavForumWidgetManager.getInstance().deleteAllWidgets(paramContext);
            FavTopicsWidgetManager.getInstance().deleteAllWidgets(paramContext);
            PMWidgetManager.getInstance().deleteAllWidgets(paramContext);
            return;
        } catch (Exception paramContext) {
        }
    }

    public static void deleteWidgetByForumId(Context paramContext, String paramString) {
        try {
            FavForumWidgetManager.getInstance().deleteWidgetsByForumId(paramContext, paramString);
            FavTopicsWidgetManager.getInstance().deleteWidgetsByForumId(paramContext, paramString);
            PMWidgetManager.getInstance().deleteWidgetsByForumId(paramContext, paramString);
            return;
        } catch (Exception paramContext) {
        }
    }

    public static void displayFullScreenMessage(Activity paramActivity, String paramString, int paramInt) {
        paramActivity = (LinearLayout) paramActivity.findViewById(2131230761);
        if (paramActivity != null) {
            TextView localTextView = (TextView) paramActivity.findViewById(2131230763);
            ImageView localImageView = (ImageView) paramActivity.findViewById(2131230762);
            localTextView.setText(paramString);
            localImageView.setImageResource(paramInt);
            paramActivity.setVisibility(0);
        }
    }

    public static String formatDate(Date paramDate, Context paramContext) {
        if (paramDate == null) {
            return null;
        }
        if ((paramDate.getYear() == today.getYear()) && (paramDate.getMonth() == today.getMonth()) && (paramDate.getDate() == today.getDate())) {
            if (SettingsFragment.is24TimeFormat(paramContext)) {
            }
            for (paramContext = new SimpleDateFormat("HH:mm"); ; paramContext = new SimpleDateFormat("h:mmaa")) {
                return paramContext.format(paramDate);
            }
        }
        if (SettingsFragment.is24TimeFormat(paramContext)) {
        }
        for (SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm"); paramDate.getYear() == today.getYear(); localSimpleDateFormat = new SimpleDateFormat("h:mmaa")) {
            return new SimpleDateFormat("MM/dd").format(paramDate) + " " + localSimpleDateFormat.format(paramDate);
        }
        return android.text.format.DateFormat.getDateFormat(paramContext).format(paramDate);
    }

    public static String formatDate2(Context paramContext, int paramInt) {
        return getShortTimeString(paramContext, paramInt);
    }

    public static String formatDateInThread(Date paramDate, Context paramContext) {
        Date localDate = new Date();
        if ((paramDate.getYear() == localDate.getYear()) && (paramDate.getMonth() == localDate.getMonth()) && (paramDate.getDate() == localDate.getDate())) {
            if (SettingsFragment.is24TimeFormat(paramContext)) {
                paramContext = new SimpleDateFormat("HH:mm");
            }
        }
        for (; ; ) {
            paramContext.setTimeZone(TimeZone.getDefault());
            return paramContext.format(paramDate);
            paramContext = new SimpleDateFormat("h:mmaa");
            continue;
            if (paramDate.getYear() != localDate.getYear()) {
                break;
            }
            paramContext = new SimpleDateFormat("MMM dd");
        }
        return android.text.format.DateFormat.getDateFormat(paramContext).format(paramDate);
    }

    public static String formatSize(float paramFloat) {
        long l1 = 1024L * 1024L;
        long l2 = l1 * 1024L;
        if (paramFloat < (float) 1024L) {
            return String.format("%d bytes", new Object[]{Integer.valueOf((int) paramFloat)});
        }
        if (paramFloat < (float) l1) {
            return String.format("%.1f kB", new Object[]{Float.valueOf(paramFloat / (float) 1024L)});
        }
        if (paramFloat < (float) l2) {
            return String.format("%.1f MB", new Object[]{Float.valueOf(paramFloat / (float) l1)});
        }
        return String.format("%.1f GB", new Object[]{Float.valueOf(paramFloat / (float) l2)});
    }

    public static String formatSmartDate(Context paramContext, int paramInt) {
        return getSmartTime(paramContext, paramInt);
    }

    public static void getByoTabItemCache(String paramString, Activity paramActivity, ForumStatus paramForumStatus) {
        try {
            paramForumStatus.rebrandingConfig = ((RebrandingConfig) AppCacheManager.getCacheData(paramString));
            int i = 0;
            for (; ; ) {
                if (i >= paramForumStatus.rebrandingConfig.getOrder().size()) {
                    return;
                }
                paramString = (TabItem) paramForumStatus.rebrandingConfig.getOrder().get(i);
                paramString.setDrawable(paramActivity, paramString.getName(), paramString.getDisplay_name(), paramString.getValue(), paramString.isSelected());
                i += 1;
            }
            return;
        } catch (Exception paramString) {
        }
    }

    public static Object getCacheDataTemp(String paramString) {
        Object localObject = null;
        new Object();
        System.currentTimeMillis();
        try {
            if (new File(paramString).exists()) {
                paramString = new ObjectInputStream(new FileInputStream(paramString));
                localObject = paramString.readObject();
                paramString.close();
            }
            return localObject;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    public static String getDeviceLanguage(Context paramContext) {
        paramContext = paramContext.getResources().getConfiguration().locale;
        if (paramContext != null) {
            return paramContext.getLanguage();
        }
        return "en";
    }

    public static String getDeviceLocal(Context paramContext) {
        return paramContext.getResources().getConfiguration().locale.toString();
    }

    public static String getDeviceName() {
        try {
            String str = "Android:" + URLEncoder.encode(Build.MODEL, "utf-8");
            return str;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
        }
        return "Android:" + URLEncoder.encode(Build.MODEL);
    }

    public static double getDeviceSize(Activity paramActivity) {
        if (paramActivity != null) {
            DisplayMetrics localDisplayMetrics = new DisplayMetrics();
            paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
            return Math.round(Math.sqrt(Math.pow(localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi, 2.0D) + Math.pow(localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi, 2.0D)));
        }
        return -1.0D;
    }

    public static String getExternalSDCard() {
        localObject1 = "";
        localObject3 = localObject1;
        try {
            localObject4 = new ProcessBuilder(new String[0]).command(new String[]{"mount"}).redirectErrorStream(true).start();
            localObject3 = localObject1;
            ((Process) localObject4).waitFor();
            localObject3 = localObject1;
            localObject4 = ((Process) localObject4).getInputStream();
            localObject3 = localObject1;
            localObject5 = new byte['Ѐ'];
        } catch (Exception localException1) {
            for (; ; ) {
                int i;
                try {
                    Object localObject5;
                    Object localObject4 = Environment.getExternalStorageDirectory().toString();
                    localObject3 = ((String) localObject4).split("\\/");
                    if (((String) localObject4).startsWith("/")) {
                        localObject3 = localObject3[1];
                        localObject1 = ((String) localObject1).split("\n");
                        i = 0;
                        int j = localObject1.length;
                        Object localObject2;
                        if (i >= j) {
                            return null;
                            localObject3 = localObject1;
                            localObject1 = localObject1 + new String((byte[]) localObject5);
                            continue;
                            localException1 = localException1;
                            localException1.printStackTrace();
                            localObject2 = localObject3;
                            continue;
                        }
                        if (-1 == localObject2[i].indexOf("vfat")) {
                            break label280;
                        }
                        localObject5 = localObject2[i].split("\\s");
                        j = 0;
                        if (j >= localObject5.length) {
                            break label280;
                        }
                        if ((-1 != localObject5[j].indexOf((String) localObject3)) && (-1 == localObject5[j].indexOf((String) localObject4)) && (-1 != localObject5[j].toLowerCase().indexOf("sdcard"))) {
                            localObject2 = localObject5[j];
                            return (String) localObject2;
                        }
                        j += 1;
                        continue;
                    }
                    localObject3 = localObject3[0];
                } catch (Exception localException2) {
                    return null;
                }
                continue;
                i += 1;
            }
        }
        localObject3 = localObject1;
        if (((InputStream) localObject4).read((byte[]) localObject5) == -1) {
            localObject3 = localObject1;
            ((InputStream) localObject4).close();
        }
    }

    public static String getFeedSmartTime(Context paramContext, int paramInt) {
        Object localObject = Calendar.getInstance();
        ((Calendar) localObject).setTimeZone(TimeZone.getTimeZone("gmt"));
        Integer.parseInt(Long.valueOf(((Calendar) localObject).getTimeInMillis() / 1000L).toString());
        Date localDate = new Date(paramInt * 1000L);
        paramInt = ((Calendar) localObject).get(1);
        int i = localDate.getYear();
        android.text.format.DateFormat.getDateFormat(paramContext);
        if (paramInt - (i + 1900) >= 1) {
            return new SimpleDateFormat("MM dd,yyyy").format(localDate);
        }
        localObject = new Date();
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM dd,yyyy");
        if (localDate != null) {
            if (localSimpleDateFormat.format((Date) localObject).equals(localSimpleDateFormat.format(localDate))) {
                if (SettingsFragment.is24TimeFormat(paramContext)) {
                    return new SimpleDateFormat("HH:mm").format(localDate);
                }
                return new SimpleDateFormat("h:mmaa").format(localDate);
            }
            return new SimpleDateFormat("MM dd,yyyy").format(localDate);
        }
        return null;
    }

    public static Bitmap getFoursquareForumIcon(Bitmap paramBitmap, int paramInt) {
        int j = paramBitmap.getWidth();
        int k = paramBitmap.getHeight();
        int i;
        int m;
        label33:
        int n;
        if (j > k) {
            i = (j - k) / 2;
            if (j <= k) {
                break label72;
            }
            m = 0;
            if (j >= k) {
                break label83;
            }
            n = j;
            label42:
            if (j >= k) {
                break label90;
            }
        }
        for (; ; ) {
            return Bitmap.createScaledBitmap(Bitmap.createBitmap(paramBitmap, i, m, n, j, null, false), paramInt, paramInt, true);
            i = 0;
            break;
            label72:
            m = (k - j) / 2;
            break label33;
            label83:
            n = k;
            break label42;
            label90:
            j = k;
        }
    }

    public static Bitmap getFoursquareForumIcon(String paramString, int paramInt) {
        paramString = decodeLocalImage(paramString, 196, 144);
        if (paramString == null) {
            return null;
        }
        int j = paramString.getWidth();
        int k = paramString.getHeight();
        int i;
        int m;
        label50:
        int n;
        if (j > k) {
            i = (j - k) / 2;
            if (j <= k) {
                break label89;
            }
            m = 0;
            if (j >= k) {
                break label100;
            }
            n = j;
            label59:
            if (j >= k) {
                break label107;
            }
        }
        for (; ; ) {
            return Bitmap.createScaledBitmap(Bitmap.createBitmap(paramString, i, m, n, j, null, false), paramInt, paramInt, true);
            i = 0;
            break;
            label89:
            m = (k - j) / 2;
            break label50;
            label100:
            n = k;
            break label59;
            label107:
            j = k;
        }
    }

    public static String getHost(String paramString) {
        String str1;
        if (paramString == null) {
            str1 = null;
        }
        for (; ; ) {
            return str1;
            str1 = paramString;
            String str2 = paramString.trim();
            paramString = str2;
            if (!str2.startsWith("http://")) {
                paramString = str2;
                if (!str2.startsWith("https://")) {
                    paramString = "http://" + str2;
                }
            }
            try {
                paramString = new URL(paramString).getHost();
                str1 = paramString;
                if (!paramString.startsWith("www.")) {
                    continue;
                }
                return paramString.replaceFirst("www.", "");
            } catch (MalformedURLException paramString) {
                for (; ; ) {
                    paramString.printStackTrace();
                    paramString = str1;
                }
            }
        }
    }

    public static int getLoginCount(Context paramContext) {
        paramContext = Prefs.get(paramContext);
        SharedPreferences.Editor localEditor = paramContext.edit();
        localEditor.putInt("logincount", paramContext.getInt("logincount", 0) + 1);
        localEditor.commit();
        return paramContext.getInt("logincount", 0);
    }

    public static String getLogoNameFromUrl(String paramString1, String paramString2) {
        paramString1 = paramString1.split("/");
        paramString1 = paramString1[(paramString1.length - 1)];
        return paramString2 + "/" + paramString1;
    }

    public static Bitmap getLogoRemoteAllInOneAvatar(String paramString) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                paramString = decodeLocalImage(paramString, 560, 160);
                return paramString;
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static Bitmap getLogoRemoteAvatar(String paramString) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                paramString = decodeLocalImage(paramString, 300, 100);
                return paramString;
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static Bitmap getLogoRemoteForumLogo(String paramString) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                paramString = decodeLocalImage(paramString, 250, 190);
                return paramString;
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static String getMD5(String paramString) {
        Object localObject1 = null;
        if ((paramString == null) || (paramString.length() == 0)) {
            return null;
        }
        try {
            Object localObject2 = MessageDigest.getInstance("MD5");
            ((MessageDigest) localObject2).update(paramString.getBytes("UTF8"));
            localObject2 = ((MessageDigest) localObject2).digest();
            paramString = "";
            int i = 0;
            while (i < localObject2.length) {
                paramString = paramString + Integer.toHexString(localObject2[i] & 0xFF | 0xFF00).substring(6);
                i += 1;
            }
            return paramString;
        } catch (Exception paramString) {
            paramString.printStackTrace();
            paramString = (String) localObject1;
        }
    }

    public static String getMacAddress(Context paramContext) {
        String str = ((WifiManager) paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        if ((str != null) && (!str.equals(""))) {
            return str;
        }
        return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }

    public static String getNowFreeString() {
        return " [url='http://tapatalk.com/m?id=10']Tapatalk[/url]";
    }

    public static int getPxFromDip(Context paramContext, float paramFloat) {
        return (int) (paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    }

    public static String getRefer(String paramString) {
        if (paramString == null) {
            return null;
        }
        Object localObject = paramString;
        try {
            String str = new URL(paramString).getHost();
            localObject = str;
        } catch (MalformedURLException localMalformedURLException) {
            for (; ; ) {
                localMalformedURLException.printStackTrace();
            }
        }
        if (paramString.contains("https")) {
            return "https://" + (String) localObject;
        }
        return "http://" + (String) localObject;
    }

    public static Bitmap getRemoteAvatar(String paramString) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                paramString = decodeLocalImage(paramString, 100, 100);
                return paramString;
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static Bitmap getRemoteBlog(Context paramContext, String paramString) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                int i = paramContext.getResources().getDimensionPixelOffset(2131427355);
                int j = paramContext.getResources().getDimensionPixelOffset(2131427356);
                Bitmap localBitmap = decodeLocalBlogImage(paramString, i, j);
                paramString = null;
                paramContext = paramString;
                if (localBitmap.getWidth() > i) {
                    paramContext = paramString;
                    if (localBitmap.getHeight() > j) {
                        paramContext = new Rect((localBitmap.getWidth() - i) / 2, (localBitmap.getHeight() - j) / 2, (localBitmap.getWidth() - i) / 2 + i, (localBitmap.getHeight() - j) / 2 + j);
                    }
                }
                if (paramContext != null) {
                    paramContext = cutBitmap(localBitmap, paramContext, Bitmap.Config.RGB_565, i, j);
                    return paramContext;
                }
                return localBitmap;
            } catch (Exception paramContext) {
                System.err.println(paramContext.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static Bitmap getRemoteForumIcon(String paramString, int paramInt1, int paramInt2) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                paramString = decodeLocalImage(paramString, paramInt1, paramInt2);
                paramString = cutBitmap(paramString, new Rect((paramString.getWidth() - paramInt1) / 2, (paramString.getHeight() - paramInt2) / 2, (paramString.getWidth() - paramInt1) / 2 + paramInt1, (paramString.getHeight() - paramInt2) / 2 + paramInt1), Bitmap.Config.RGB_565, paramInt1, paramInt2);
                return paramString;
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static Bitmap getRemoteFullBlog(Context paramContext, String paramString) {
        if (paramString != null) {
            try {
                if (paramString.length() != 0) {
                    int i = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
                    Bitmap localBitmap = decodeLocalFullBlogImage(paramString, i, 480);
                    paramContext = new Matrix();
                    if (i > localBitmap.getWidth()) {
                        paramContext.postScale(i / localBitmap.getWidth(), 'Ǡ' / localBitmap.getHeight());
                    }
                    for (paramContext = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramContext, true); ; paramContext = Bitmap.createBitmap(localBitmap, 0, 0, i, 480, paramContext, true)) {
                        paramString = null;
                        if ((paramContext.getWidth() > i) || (paramContext.getHeight() > 480)) {
                            paramString = new Rect((localBitmap.getWidth() - i) / 2, (localBitmap.getHeight() - 480) / 2, (localBitmap.getWidth() - i) / 2 + i, (localBitmap.getHeight() - 480) / 2 + 480);
                        }
                        if (paramString == null) {
                            break;
                        }
                        return cutBitmap(paramContext, paramString, Bitmap.Config.RGB_565, i, 480);
                        paramContext.postScale(localBitmap.getWidth() / i, localBitmap.getHeight() / 'Ǡ');
                    }
                    return paramContext;
                }
            } catch (Exception paramContext) {
                System.err.println(paramContext.toString());
                System.err.println("error writing to pic");
                return null;
            }
        }
        return null;
    }

    public static Bitmap getRemotePic(String paramString) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                paramString = decodeLocalImage(paramString, 400, 600);
                return paramString;
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static Bitmap getRemotePic(String paramString, Activity paramActivity) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                DisplayMetrics localDisplayMetrics = new DisplayMetrics();
                paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
                paramString = decodeLocalImage(paramString, localDisplayMetrics.widthPixels, 600);
                return paramString;
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static InputStream getRemotePicData(String paramString) {
        FileInputStream localFileInputStream = null;
        try {
            if (new File(paramString).exists()) {
                localFileInputStream = new FileInputStream(paramString);
            }
            return localFileInputStream;
        } catch (FileNotFoundException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    public static Bitmap getRemotePicFullScreen(String paramString) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                paramString = decodeLocalImage(paramString, 900, 1024);
                return paramString;
            } catch (Exception paramString) {
            }
        }
        return null;
    }

    public static Bitmap getRemotePicFullScreen(String paramString, int paramInt1, int paramInt2) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                paramString = decodeLocalImage(paramString, 900, 1024);
                paramString = cutBitmap(paramString, new Rect((paramString.getWidth() - paramInt1) / 2, (paramString.getHeight() - paramInt2) / 2, (paramString.getWidth() - paramInt1) / 2 + paramInt1, (paramString.getHeight() - paramInt2) / 2 + paramInt2), Bitmap.Config.RGB_565, paramInt1, paramInt2);
                return paramString;
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static Bitmap getRemotePicSmall(String paramString) {
        if (paramString != null) {
            try {
                if (paramString.length() == 0) {
                    return null;
                }
                File localFile = new File(paramString);
                BitmapFactory.Options localOptions = new BitmapFactory.Options();
                localOptions.inSampleSize = ((int) (localFile.length() / 20000L + 1L));
                paramString = BitmapFactory.decodeFile(paramString, localOptions);
                return paramString;
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
            }
        }
        return null;
    }

    public static Bitmap getRemoteTapatalkPic(String paramString, Context paramContext) {
        if (paramString != null) {
            try {
                if (paramString.length() != 0) {
                    int i = paramContext.getResources().getDimensionPixelOffset(2131427396);
                    int j = paramContext.getResources().getDimensionPixelOffset(2131427397);
                    paramContext = decodeLocalFullBlogImage(paramString, i, j);
                    paramString = new Matrix();
                    if (i > paramContext.getWidth()) {
                        f = i / paramContext.getWidth();
                        paramString.postScale(f, f);
                        Bitmap localBitmap = Bitmap.createBitmap(paramContext, 0, 0, paramContext.getWidth(), paramContext.getHeight(), paramString, true);
                        paramString = null;
                        if ((localBitmap.getWidth() > i) || (localBitmap.getHeight() > j)) {
                            paramString = new Rect((paramContext.getWidth() - i) / 2, (paramContext.getHeight() - j) / 2, (paramContext.getWidth() - i) / 2 + i, (paramContext.getHeight() - j) / 2 + j);
                        }
                        paramContext = localBitmap;
                        if (paramString == null) {
                            return paramContext;
                        }
                        return cutBitmap(localBitmap, paramString, Bitmap.Config.RGB_565, i, j);
                    }
                    float f = paramContext.getWidth() / i;
                    paramString.postScale(f, f);
                    paramString = Bitmap.createBitmap(paramContext, 0, 0, i, (int) (paramContext.getHeight() / f), paramString, true);
                    return paramString;
                }
            } catch (Exception paramString) {
                System.err.println(paramString.toString());
                System.err.println("error writing to pic");
                return null;
            }
        }
        paramContext = null;
        return paramContext;
    }

    public static Bitmap getRoundCornerBitmap(Bitmap paramBitmap, float paramFloat) {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, i, j);
        RectF localRectF = new RectF(localRect);
        localPaint.setColor(-12434878);
        localPaint.setAntiAlias(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
        return localBitmap;
    }

    public static String getShortTimeString(Context paramContext, int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeZone(TimeZone.getTimeZone("gmt"));
        int i = Integer.parseInt(Long.valueOf(localCalendar.getTimeInMillis() / 1000L).toString()) - paramInt;
        if (i < 10) {
            return paramContext.getString(2131100341);
        }
        if (i < 60) {
            return String.format(paramContext.getString(2131100347), new Object[]{Integer.valueOf(i)});
        }
        if (i < 3600) {
            if (i / 60 == 1) {
                return paramContext.getString(2131100344);
            }
            return String.format(paramContext.getString(2131100343), new Object[]{Integer.valueOf(i / 60)});
        }
        if (i < 86400) {
            if (i / 3600 == 1) {
                return paramContext.getString(2131100351);
            }
            return String.format(paramContext.getString(2131100349), new Object[]{Integer.valueOf(i / 3600)});
        }
        if (i < 691200) {
            if (i / 86400 == 1) {
                return paramContext.getString(2131100352);
            }
            return String.format(paramContext.getString(2131100353), new Object[]{Integer.valueOf(i / 86400)});
        }
        Date localDate = new Date(paramInt * 1000L);
        paramInt = localCalendar.get(1);
        i = localDate.getYear();
        android.text.format.DateFormat.getDateFormat(paramContext);
        paramContext = getSystemDefaultDateFormat(paramContext);
        if (paramInt - (i + 1900) >= 1) {
            return new SimpleDateFormat(paramContext).format(localDate);
        }
        return new SimpleDateFormat(paramContext).format(localDate);
    }

    public static String getSignOutKey(Context paramContext, int paramInt, String paramString1, String paramString2) {
        int i = TapatalkIdFactory.getTapatalkId(paramContext).getAuid();
        if ((!isEmpty(paramString1)) && (!paramString1.equals("0"))) {
            return i + "|" + paramInt + "|" + paramString1 + "|" + "user_logout";
        }
        return i + "|" + paramInt + "|" + paramString2.toLowerCase() + "|" + "user_logout";
    }

    public static String getSignOutKey(Context paramContext, TapatalkForum paramTapatalkForum) {
        return getSignOutKey(paramContext, paramTapatalkForum.getId().intValue(), paramTapatalkForum.getUserId(), paramTapatalkForum.getUserNameOrDisplayName().toLowerCase());
    }

    public static String getSmartTime(Context paramContext, int paramInt) {
        Object localObject = Calendar.getInstance();
        ((Calendar) localObject).setTimeZone(TimeZone.getTimeZone("gmt"));
        Integer.parseInt(Long.valueOf(((Calendar) localObject).getTimeInMillis() / 1000L).toString());
        Date localDate1 = new Date(paramInt * 1000L);
        paramInt = ((Calendar) localObject).get(1);
        int i = localDate1.getYear();
        android.text.format.DateFormat.getDateFormat(paramContext);
        localObject = getSystemDefaultDateFormat(paramContext);
        if (paramInt - (i + 1900) >= 1) {
            return new SimpleDateFormat((String) localObject).format(localDate1);
        }
        Date localDate2 = new Date();
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        if (localDate1 != null) {
            if (localSimpleDateFormat.format(localDate2).equals(localSimpleDateFormat.format(localDate1))) {
                if (SettingsFragment.is24TimeFormat(paramContext)) {
                    return new SimpleDateFormat("HH:mm").format(localDate1);
                }
                return new SimpleDateFormat("h:mmaa").format(localDate1);
            }
            return new SimpleDateFormat((String) localObject).format(localDate1);
        }
        return null;
    }

    public static String getSmartTimeString(Context paramContext, int paramInt) {
        Object localObject = Calendar.getInstance();
        ((Calendar) localObject).setTimeZone(TimeZone.getTimeZone("gmt"));
        Integer.parseInt(Long.valueOf(((Calendar) localObject).getTimeInMillis() / 1000L).toString());
        Date localDate1 = new Date(paramInt * 1000L);
        paramInt = ((Calendar) localObject).get(1);
        int i = localDate1.getYear();
        android.text.format.DateFormat.getDateFormat(paramContext);
        localObject = getSystemDefaultDateFormat(paramContext);
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat((String) localObject);
        if (paramInt - (i + 1900) >= 1) {
            return localSimpleDateFormat.format(localDate1);
        }
        Date localDate2 = new Date();
        if (localDate1 != null) {
            if (localSimpleDateFormat.format(localDate2).equals(localSimpleDateFormat.format(localDate1))) {
                if (SettingsFragment.is24TimeFormat(paramContext)) {
                    return new SimpleDateFormat("HH:mm").format(localDate1);
                }
                return new SimpleDateFormat("h:mmaa").format(localDate1);
            }
            return new SimpleDateFormat((String) localObject).format(localDate1);
        }
        return null;
    }

    private static String getSystemDefaultDateFormat(Context paramContext) {
        try {
            paramContext = Settings.System.getString(paramContext.getContentResolver(), "date_format");
            if (paramContext != null) {
                localObject = paramContext;
                if (!paramContext.equals("")) {
                }
            } else {
                localObject = "yyyy/MM/dd";
            }
        } catch (Exception paramContext) {
            for (; ; ) {
                try {
                    Object localObject;
                    paramContext = new SimpleDateFormat((String) localObject);
                    Date localDate = new Date();
                    localDate.setTime(System.currentTimeMillis());
                    paramContext.format(localDate);
                    return (String) localObject;
                } catch (Exception paramContext) {
                }
                paramContext = paramContext;
                paramContext = "yyyy/MM/dd";
            }
        }
        return "yyyy/MM/dd";
    }

    public static Bitmap getTendingTopicImage(Bitmap paramBitmap, Context paramContext, int paramInt) {
        try {
            int i = paramContext.getResources().getDimensionPixelOffset(2131427397);
            paramContext = new Matrix();
            float f;
            if (paramInt > paramBitmap.getWidth()) {
                f = paramInt / paramBitmap.getWidth();
                paramContext.postScale(f, f);
                Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramContext, true);
                paramContext = null;
                if ((localBitmap.getWidth() > paramInt) || (localBitmap.getHeight() > i)) {
                    paramContext = new Rect((paramBitmap.getWidth() - paramInt) / 2, (paramBitmap.getHeight() - i) / 2, (paramBitmap.getWidth() - paramInt) / 2 + paramInt, (paramBitmap.getHeight() - i) / 2 + i);
                }
                paramBitmap = localBitmap;
                if (paramContext != null) {
                    return cutBitmap(localBitmap, paramContext, Bitmap.Config.RGB_565, paramInt, i);
                }
            } else {
                f = paramBitmap.getWidth() / paramInt;
                paramContext.postScale(f, f);
                paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, (int) (paramBitmap.getHeight() / f), paramContext, true);
                return paramBitmap;
            }
        } catch (Exception paramBitmap) {
            System.err.println(paramBitmap.toString());
            System.err.println("error writing to pic");
            paramBitmap = null;
        }
        return paramBitmap;
    }

    public static String getTimeString(Context paramContext, int paramInt) {
        return getTimeString(paramContext, paramInt, 1, getSystemDefaultDateFormat(paramContext), Locale.getDefault());
    }

    public static String getTimeString(Context paramContext, int paramInt1, int paramInt2, String paramString, Locale paramLocale) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeZone(TimeZone.getTimeZone("gmt"));
        int i = Integer.parseInt(Long.valueOf(localCalendar.getTimeInMillis() / 1000L).toString()) - paramInt1;
        if (i < 10) {
            return paramContext.getString(2131100340);
        }
        if (i < 60) {
            return String.format(paramContext.getString(2131100346), new Object[]{Integer.valueOf(i)});
        }
        if (i == 60) {
            return paramContext.getString(2131100344);
        }
        if (i < 3600) {
            return String.format(paramContext.getString(2131100342), new Object[]{Integer.valueOf(i / 60)});
        }
        if (i == 3600) {
            return paramContext.getString(2131100350);
        }
        if (i < 86400) {
            return String.format(paramContext.getString(2131100348), new Object[]{Integer.valueOf(i / 3600)});
        }
        if (i / 86400 >= paramInt2) {
            paramContext = new Date(paramInt1 * 1000L);
            return new SimpleDateFormat(paramString, paramLocale).format(paramContext);
        }
        if (i == 86400) {
            return paramContext.getString(2131100352);
        }
        return String.format(paramContext.getString(2131100353), new Object[]{Integer.valueOf(i / 86400)});
    }

    public static BitmapDrawable getTopicImageBitMap(Bitmap paramBitmap) {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(96.0F / f1, 96.0F / f2);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, (int) f1, (int) f2, localMatrix, true);
        if (paramBitmap != null) {
            return new BitmapDrawable(getRoundCornerBitmap(paramBitmap, 70.0F));
        }
        return null;
    }

    public static void getTrendingTopicLogo(Context paramContext, ForumHttpStatus paramForumHttpStatus, ImageView paramImageView1, String paramString, ImageView paramImageView2, TextView paramTextView) {
        if (!is2GState(paramContext)) {
            if (SettingsFragment.isShowAvatar(paramContext)) {
                AvatarTool.showTrendingTopicLogo(paramContext, paramForumHttpStatus, paramImageView1, paramString, paramTextView, paramImageView2);
            }
        }
        do {
            do {
                return;
                if (paramImageView1 != null) {
                    paramImageView1.setVisibility(8);
                }
            } while (paramImageView2 == null);
            paramImageView2.setVisibility(8);
            return;
            if (SettingsFragment.isShowAvatarWithSlowConn(paramContext)) {
                AvatarTool.showTrendingTopicLogo(paramContext, paramForumHttpStatus, paramImageView1, paramString, paramTextView, paramImageView2);
                return;
            }
            if (paramImageView1 != null) {
                paramImageView1.setVisibility(8);
            }
        } while (paramImageView2 == null);
        paramImageView2.setVisibility(8);
    }

    public static Bitmap getTrendingTopicSquareUserIcon(Bitmap paramBitmap) {
        if (paramBitmap == null) {
            return null;
        }
        int j = paramBitmap.getWidth();
        int k = paramBitmap.getHeight();
        int i;
        int m;
        label35:
        int n;
        if (j > k) {
            i = (j - k) / 2;
            if (j <= k) {
                break label74;
            }
            m = 0;
            if (j >= k) {
                break label84;
            }
            n = j;
            label43:
            if (j >= k) {
                break label90;
            }
        }
        for (; ; ) {
            return Bitmap.createScaledBitmap(Bitmap.createBitmap(paramBitmap, i, m, n, j, null, false), 48, 48, true);
            i = 0;
            break;
            label74:
            m = (k - j) / 2;
            break label35;
            label84:
            n = k;
            break label43;
            label90:
            j = k;
        }
    }

    public static void getUserImage(Context paramContext, ForumHttpStatus paramForumHttpStatus, GifImageView paramGifImageView, String paramString, ImageView paramImageView) {
        if (!is2GState(paramContext)) {
            if (SettingsFragment.isShowAvatar(paramContext)) {
                AvatarTool.showAvatar(paramContext, paramForumHttpStatus, paramGifImageView, paramString, 0);
            }
        }
        do {
            do {
                return;
                if (paramGifImageView != null) {
                    paramGifImageView.setVisibility(8);
                }
            } while (paramImageView == null);
            paramImageView.setVisibility(8);
            return;
            if (SettingsFragment.isShowAvatarWithSlowConn(paramContext)) {
                AvatarTool.showAvatar(paramContext, paramForumHttpStatus, paramGifImageView, paramString, 0);
                return;
            }
            if (paramGifImageView != null) {
                paramGifImageView.setVisibility(8);
            }
        } while (paramImageView == null);
        paramImageView.setVisibility(8);
    }

    public static int getVersionCode(Context paramContext) {
        try {
            int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
            return i;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
        return 0;
    }

    public static int[] getViewSize(View paramView) {
        int i = paramView.getWidth();
        int j = paramView.getHeight();
        return new int[]{Math.min(i, j), Math.max(j, i)};
    }

    public static int[] getWindowSize(Activity paramActivity) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = localDisplayMetrics.widthPixels;
        int j = localDisplayMetrics.heightPixels;
        return new int[]{Math.min(i, j), Math.max(i, j)};
    }

    public static boolean hasGoogleAccount(Activity paramActivity) {
        return AccountManager.get(paramActivity).getAccountsByType("com.google").length != 0;
    }

    public static void hideFullScreenMessage(Activity paramActivity) {
        if (paramActivity != null) {
            paramActivity = (LinearLayout) paramActivity.findViewById(2131230761);
            if (paramActivity != null) {
                paramActivity.setVisibility(4);
            }
        }
    }

    public static void hideHintview(View paramView, int paramInt) {
        if (paramView != null) {
            if (paramInt != 0) {
                break label91;
            }
            localObject = paramView.getTag();
            if ((localObject == null) || (!(localObject instanceof String)) || (!((String) localObject).equals("hide"))) {
                break label38;
            }
        }
        label38:
        label91:
        while (paramView.getVisibility() != 0) {
            do {
                return;
            } while (paramView.getVisibility() != 0);
            Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramView.getHeight());
            ((TranslateAnimation) localObject).setDuration(200L);
            ((TranslateAnimation) localObject).setFillAfter(false);
            ((TranslateAnimation) localObject).setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation paramAnonymousAnimation) {
                    Util.this.setOnTouchListener(null);
                    Util.this.setVisibility(8);
                }

                public void onAnimationRepeat(Animation paramAnonymousAnimation) {
                }

                public void onAnimationStart(Animation paramAnonymousAnimation) {
                    Util.this.setTag("hide");
                }
            });
            paramView.startAnimation((Animation) localObject);
            return;
        }
        paramView.setOnTouchListener(null);
        paramView.setVisibility(8);
    }

    public static void hideSoftKeyb(Context paramContext, View paramView) {
        if ((paramContext != null) && (paramView != null)) {
            ((InputMethodManager) paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 2);
        }
    }

    public static boolean is2GState(Context paramContext) {
        boolean bool2 = false;
        Object localObject = ((ConnectivityManager) paramContext.getSystemService("connectivity")).getNetworkInfo(0);
        boolean bool1 = bool2;
        if (localObject != null) {
            localObject = ((NetworkInfo) localObject).getState();
            bool1 = bool2;
            if (localObject != null) {
                bool1 = bool2;
                if (localObject == NetworkInfo.State.CONNECTED) {
                    bool1 = bool2;
                    if (!isFastMobileNetwork(paramContext)) {
                        bool1 = true;
                    }
                }
            }
        }
        return bool1;
    }

    public static boolean isConn(Context paramContext) {
        boolean bool = false;
        paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
        if (paramContext.getActiveNetworkInfo() != null) {
            bool = paramContext.getActiveNetworkInfo().isAvailable();
        }
        return bool;
    }

    public static boolean isEmpty(int paramInt) {
        return paramInt == 0;
    }

    public static boolean isEmpty(long paramLong) {
        return paramLong == 0L;
    }

    public static boolean isEmpty(Uri paramUri) {
        return (paramUri == null) || (paramUri.equals(""));
    }

    public static boolean isEmpty(View paramView) {
        return paramView == null;
    }

    public static boolean isEmpty(Integer paramInteger) {
        boolean bool = false;
        if ((paramInteger == null) || (paramInteger.equals(Integer.valueOf(0)))) {
            bool = true;
        }
        return bool;
    }

    public static boolean isEmpty(String paramString) {
        return (paramString == null) || (paramString.equals(""));
    }

    public static boolean isFastDoubleClick() {
        long l1 = System.currentTimeMillis();
        long l2 = l1 - lastClickTime;
        lastClickTime = l1;
        return (0L >= l2) || (l2 >= 1000L);
    }

    private static boolean isFastMobileNetwork(Context paramContext) {
        switch (((TelephonyManager) paramContext.getSystemService("phone")).getNetworkType()) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            default:
                return false;
            case 5:
                return true;
            case 6:
                return true;
            case 8:
                return true;
            case 10:
                return true;
            case 9:
                return true;
            case 3:
                return true;
            case 14:
                return true;
            case 12:
                return true;
            case 15:
                return true;
        }
        return true;
    }

    public static boolean isFavoriate(Context paramContext, int paramInt) {
        paramContext = TapatalkAccountAction.getCurrnentAllAccount((Activity) paramContext);
        int i = 0;
        for (; ; ) {
            if (i >= paramContext.size()) {
                return false;
            }
            if (paramInt == ((TapatalkForum) paramContext.get(i)).getId().intValue()) {
                return true;
            }
            i += 1;
        }
    }

    public static boolean isFirstEntryForum(Context paramContext) {
        paramContext = Prefs.get(paramContext);
        SharedPreferences.Editor localEditor = paramContext.edit();
        localEditor.putInt("first_entry_forum", paramContext.getInt("first_entry_forum", 0) + 1);
        localEditor.commit();
        return paramContext.getInt("first_entry_forum", 0) == 1;
    }

    public static boolean isFirstOpenApp(Context paramContext) {
        return Prefs.get(paramContext).getInt("start_count_for_rate", 0) == 1;
    }

    public static boolean isHDDevice(Activity paramActivity) {
        return getDeviceSize(paramActivity) >= 7.0D;
    }

    public static boolean isLoggedForum(Context paramContext, Integer paramInteger, String paramString1, String paramString2) {
        return (isSignedUserNew(paramContext, paramInteger, paramString1)) || ((checkString(paramString1)) && (checkString(paramString2)));
    }

    public static boolean isLoginedUser(Context paramContext, TapatalkForum paramTapatalkForum) {
        boolean bool = isSignedUser(paramContext, paramTapatalkForum);
        if ((paramTapatalkForum.getUserName() != null) && (paramTapatalkForum.getUserName().length() > 0) && (paramTapatalkForum.hasPassword())) {
        }
        for (int i = 1; (!bool) && (i == 0); i = 0) {
            return false;
        }
        return true;
    }

    public static boolean isShowCard() {
        return (int) System.currentTimeMillis() / 1000 % 2 != 0;
    }

    public static void isShowHint(Activity paramActivity, TextView paramTextView) {
        SharedPreferences localSharedPreferences = Prefs.get(paramActivity);
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        if (localSharedPreferences.getBoolean("show_hints_isshow_hintview", false)) {
            localEditor.putBoolean("show_hints_isshow_hintview", false);
            paramTextView.setVisibility(0);
        }
        try {
            paramTextView.setTypeface(Typeface.createFromAsset(paramActivity.getAssets(), "font/GothamRounded-Bold.ttf"));
            for (; ; ) {
                localEditor.commit();
                return;
                paramTextView.setVisibility(8);
            }
        } catch (Exception paramActivity) {
            for (; ; ) {
            }
        }
    }

    public static boolean isSignOutUser(Context paramContext, int paramInt, String paramString1, String paramString2) {
        return Prefs.get(paramContext).getBoolean(getSignOutKey(paramContext, paramInt, paramString1, paramString2), false);
    }

    public static boolean isSignOutUser(Context paramContext, TapatalkForum paramTapatalkForum) {
        return Prefs.get(paramContext).getBoolean(getSignOutKey(paramContext, paramTapatalkForum), false);
    }

    public static boolean isSignedUser(Context paramContext, TapatalkForum paramTapatalkForum) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        int i = TapatalkIdFactory.getTapatalkId(paramContext).getAuid();
        paramContext = localSharedPreferences.getString(i + paramTapatalkForum.getId() + paramTapatalkForum.getLowerUserName() + "usesignin", "");
        if (checkString(paramContext)) {
            return "usesignin".equals(paramContext);
        }
        return "usesignin".equals(localSharedPreferences.getString(paramTapatalkForum.getId().intValue() + i + paramTapatalkForum.getName() + "usesignin", ""));
    }

    public static boolean isSignedUserNew(Context paramContext, Integer paramInteger, String paramString) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        int i = TapatalkIdFactory.getTapatalkId(paramContext).getAuid();
        return "usesignin".equals(localSharedPreferences.getString(i + paramInteger + paramString + "usesignin", ""));
    }

    public static boolean isWifiState(Context paramContext) {
        paramContext = ((ConnectivityManager) paramContext.getSystemService("connectivity")).getNetworkInfo(1);
        if (paramContext != null) {
            paramContext = paramContext.getState();
            return (paramContext != null) && (paramContext == NetworkInfo.State.CONNECTED);
        }
        return false;
    }

    public static void lockReset() {
        size = 0;
        lock = new Object();
        maxsize = 1;
    }

    public static void logAppSession(Activity paramActivity) {
        if (googleAdsId == null) {
            new Thread() {
                public void handleMessage(Message paramAnonymousMessage) {
                    paramAnonymousMessage = (String) paramAnonymousMessage.obj;
                    Util.googleAdsId = paramAnonymousMessage;
                    try {
                        if (!Util.this.getResources().getBoolean(2131558401)) {
                            Util.logSession(Util.this, paramAnonymousMessage);
                        }
                        return;
                    } catch (Exception paramAnonymousMessage) {
                        paramAnonymousMessage.printStackTrace();
                    }
                }
            }
            {
                public void run ()
                {
                    String str = GoogleAdsTool.getIdThread(Util.this);
                    Message localMessage = new Message();
                    localMessage.arg1 = 0;
                    localMessage.obj = str;
                    this.val$logHandler.dispatchMessage(localMessage);
                }
            }.start();
            return;
        }
        logSession(paramActivity, googleAdsId);
    }

    public static void logSession(Activity paramActivity, String paramString) {
        int i = TapatalkIdFactory.getTapatalkId(paramActivity).getAuid();
        String str2 = TapatalkJsonEngine.APP_SESSION + "?" + "device_id=" + getMD5(getMacAddress(paramActivity)) + "&device_type=" + getDeviceName() + "&au_id=" + i;
        String str1 = str2;
        if (paramString != null) {
            str1 = str2 + "&ads_id=" + paramString;
        }
        TapatalkJsonEngine.callLogin(paramActivity, str1);
    }

    private static Bitmap matrixImage(Bitmap paramBitmap, int paramInt1, int paramInt2) {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        if (i < paramInt1) {
            if (j >= paramInt2) {
                break label77;
            }
        }
        for (; ; ) {
            float f1 = paramInt1 / i;
            float f2 = paramInt2 / j;
            Matrix localMatrix = new Matrix();
            localMatrix.postScale(f1, f2);
            return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
            paramInt1 = i;
            break;
            label77:
            paramInt2 = j;
        }
    }

    public static byte[] parseByteArray(byte[] paramArrayOfByte) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        int j = 0;
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayOfByte.length - 1) {
                localByteArrayOutputStream.write(paramArrayOfByte, j, i - j + 1);
                return localByteArrayOutputStream.toByteArray();
            }
            int k = j;
            if (paramArrayOfByte[i] == 13) {
                k = j;
                if (paramArrayOfByte[(i + 1)] == 10) {
                    localByteArrayOutputStream.write(paramArrayOfByte, j, i - j);
                    k = i + 1;
                }
            }
            i += 1;
            j = k;
        }
    }

    public static View prepareExploerImageView(Activity paramActivity) {
        View localView = LayoutInflater.from(paramActivity).inflate(2130903420, null);
        RelativeLayout localRelativeLayout = (RelativeLayout) localView.findViewById(2131231709);
        ImageView localImageView1 = (ImageView) localView.findViewById(2131231711);
        TextView localTextView = (TextView) localView.findViewById(2131231710);
        ImageView localImageView2 = (ImageView) localView.findViewById(2131231712);
        if (SettingsFragment.isLightTheme(paramActivity)) {
            localImageView1.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130839509));
            localRelativeLayout.setBackgroundColor(paramActivity.getResources().getColor(2131165561));
            localTextView.setBackgroundColor(paramActivity.getResources().getColor(2131165251));
            localImageView2.setBackgroundColor(paramActivity.getResources().getColor(2131165560));
            return localView;
        }
        localImageView1.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130839508));
        localRelativeLayout.setBackgroundColor(paramActivity.getResources().getColor(2131165252));
        localTextView.setBackgroundColor(paramActivity.getResources().getColor(2131165601));
        localImageView2.setBackgroundColor(paramActivity.getResources().getColor(2131165573));
        return localView;
    }

    public static View prepareFeedImageView(Activity paramActivity) {
        View localView = LayoutInflater.from(paramActivity).inflate(2130903421, null);
        RelativeLayout localRelativeLayout = (RelativeLayout) localView.findViewById(2131231709);
        ImageView localImageView1 = (ImageView) localView.findViewById(2131231711);
        ImageView localImageView2 = (ImageView) localView.findViewById(2131231712);
        if (SettingsFragment.isLightTheme(paramActivity)) {
            localImageView1.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130839511));
            localRelativeLayout.setBackgroundColor(paramActivity.getResources().getColor(2131165561));
            localImageView2.setBackgroundColor(paramActivity.getResources().getColor(2131165560));
            return localView;
        }
        localImageView1.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130839510));
        localRelativeLayout.setBackgroundColor(paramActivity.getResources().getColor(2131165252));
        localImageView2.setBackgroundColor(paramActivity.getResources().getColor(2131165573));
        return localView;
    }

    public static View prepareProfilesImageView(Activity paramActivity) {
        View localView = LayoutInflater.from(paramActivity).inflate(2130903422, null);
        RelativeLayout localRelativeLayout = (RelativeLayout) localView.findViewById(2131231709);
        ImageView localImageView1 = (ImageView) localView.findViewById(2131231711);
        TextView localTextView = (TextView) localView.findViewById(2131231710);
        ImageView localImageView2 = (ImageView) localView.findViewById(2131231712);
        if (SettingsFragment.isLightTheme(paramActivity)) {
            localImageView1.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130839513));
            localRelativeLayout.setBackgroundColor(paramActivity.getResources().getColor(2131165561));
            localTextView.setBackgroundColor(paramActivity.getResources().getColor(2131165251));
            localImageView2.setBackgroundColor(paramActivity.getResources().getColor(2131165560));
            return localView;
        }
        localImageView1.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130839512));
        localRelativeLayout.setBackgroundColor(paramActivity.getResources().getColor(2131165252));
        localTextView.setBackgroundColor(paramActivity.getResources().getColor(2131165601));
        localImageView2.setBackgroundColor(paramActivity.getResources().getColor(2131165573));
        return localView;
    }

    public static View prepareTabView(String paramString, Activity paramActivity, boolean paramBoolean) {
        View localView = LayoutInflater.from(paramActivity).inflate(2130903423, null);
        TextView localTextView = (TextView) localView.findViewById(2131231715);
        localTextView.setText(paramString.toUpperCase());
        paramString = (TextView) localView.findViewById(2131231714);
        if (!paramBoolean) {
            paramString.setVisibility(8);
        }
        if (SettingsFragment.isLightTheme(paramActivity)) {
            localView.setBackgroundColor(paramActivity.getResources().getColor(2131165213));
            localTextView.setTextColor(paramActivity.getResources().getColor(2131165563));
        }
        for (; ; ) {
            paramString = (ImageView) localView.findViewById(2131231713);
            return localView;
            localView.setBackgroundColor(paramActivity.getResources().getColor(2131165562));
            localTextView.setTextColor(paramActivity.getResources().getColor(2131165213));
        }
    }

    public static void saveFavoriate(Context paramContext, TapatalkForum paramTapatalkForum, String paramString, boolean paramBoolean) {
        TapatalkForum localTapatalkForum2 = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(paramTapatalkForum.getId());
        int j = 0;
        int i;
        TapatalkForum localTapatalkForum1;
        if (isFavoriate(paramContext, paramTapatalkForum.getId().intValue())) {
            i = 1;
            localTapatalkForum1 = localTapatalkForum2;
        }
        for (; ; ) {
            if (i == 0) {
                if (!isLoginedUser(paramContext, localTapatalkForum1)) {
                    TapatalkJsonEngine.auAddAccount(paramContext, paramTapatalkForum.getId().intValue(), "Guest", null, "0", null, paramString, localTapatalkForum1);
                }
                TapatalkAccountAction.addToCurrenForums(paramTapatalkForum, (Activity) paramContext);
                if (paramBoolean) {
                    showToastDialog((Activity) paramContext, paramContext.getResources().getString(2131099707));
                }
            }
            return;
            localTapatalkForum1 = localTapatalkForum2;
            i = j;
            if (localTapatalkForum2 == null) {
                localTapatalkForum1 = paramTapatalkForum;
                i = j;
            }
        }
    }

    public static void saveFavoriate(Context paramContext, ArrayList<Object> paramArrayList, String paramString) {
        int i;
        if (paramArrayList.size() > 0) {
            i = 0;
            if (i < paramArrayList.size()) {
            }
        } else {
            return;
        }
        TapatalkForum localTapatalkForum2 = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(((TapatalkForum) paramArrayList.get(i)).getId().intValue());
        int k = 0;
        int j;
        TapatalkForum localTapatalkForum1;
        if (isFavoriate(paramContext, ((TapatalkForum) paramArrayList.get(i)).getId().intValue())) {
            j = 1;
            localTapatalkForum1 = localTapatalkForum2;
        }
        for (; ; ) {
            if (j == 0) {
                if (!isLoginedUser(paramContext, localTapatalkForum1)) {
                    TapatalkJsonEngine.auAddAccount(paramContext, ((TapatalkForum) paramArrayList.get(i)).getId().intValue(), "Guest", null, "0", null, paramString, localTapatalkForum1);
                }
                TapatalkAccountAction.addToCurrenForums((TapatalkForum) paramArrayList.get(i), (Activity) paramContext);
                showToastDialog((Activity) paramContext, paramContext.getResources().getString(2131099707));
            }
            i += 1;
            break;
            localTapatalkForum1 = localTapatalkForum2;
            j = k;
            if (localTapatalkForum2 == null) {
                localTapatalkForum1 = (TapatalkForum) paramArrayList.get(i);
                j = k;
            }
        }
    }

    public static void sendLog(Context paramContext) {
        if (getLoginCount(paramContext) == 1) {
            if (!Prefs.get(paramContext).getBoolean("showcard", false)) {
                break label75;
            }
        }
        label75:
        for (int i = 1; ; i = 0) {
            TapatalkJsonEngine.callLogin(paramContext, TapatalkJsonEngine.AB_TID_CARD_REG + "?" + TapatalkApp.APP_KEY + "&is_registered=1" + "&has_card=" + i);
            return;
        }
    }

    public static void setBg(View paramView, Drawable paramDrawable) {
        if ((paramView == null) || (paramDrawable == null)) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                paramView.setBackground(paramDrawable);
                return;
            }
            paramView.setBackgroundDrawable(paramDrawable);
            return;
        } catch (Exception paramView) {
        }
    }

    public static void setKeyboardFocus(EditText paramEditText) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Util.this.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0F, 0.0F, 0));
                Util.this.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0F, 0.0F, 0));
            }
        }, 100L);
    }

    public static void setListViewHeightBasedOnChildren(ListView paramListView) {
        ListAdapter localListAdapter = paramListView.getAdapter();
        if (localListAdapter == null) {
            return;
        }
        int j = 0;
        int i = 0;
        for (; ; ) {
            if (i >= localListAdapter.getCount()) {
                localObject = paramListView.getLayoutParams();
                ((ViewGroup.LayoutParams) localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j);
                paramListView.setLayoutParams((ViewGroup.LayoutParams) localObject);
                return;
            }
            Object localObject = localListAdapter.getView(i, null, paramListView);
            ((View) localObject).measure(0, 0);
            j += ((View) localObject).getMeasuredHeight();
            i += 1;
        }
    }

    public static void setPortrait(Activity paramActivity) {
        if (paramActivity.getRequestedOrientation() != 1) {
            paramActivity.setRequestedOrientation(1);
        }
    }

    public static int setThemeBg(Activity paramActivity, int paramInt1, int paramInt2) {
        if (SettingsFragment.isLightTheme(paramActivity)) {
            return paramInt1;
        }
        return paramInt2;
    }

    public static String shift(String paramString) {
        if ((paramString != null) && (paramString.length() > 0)) {
            int j = paramString.length();
            paramString = paramString.toCharArray();
            int i = 0;
            for (; ; ) {
                if (i >= j) {
                    return new String(paramString);
                }
                if ((paramString[i] <= 'z') && (paramString[i] >= 'a')) {
                    paramString[i] = ((char) (paramString[i] - ' '));
                }
                i += 1;
            }
        }
        return " ";
    }

    public static void showMenu(Activity paramActivity) {
        try {
            paramActivity = ViewConfiguration.get(paramActivity);
            Field localField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (localField != null) {
                localField.setAccessible(true);
                localField.setBoolean(paramActivity, false);
            }
            return;
        } catch (Exception paramActivity) {
        }
    }

    public static void showSettingsDialog(Context paramContext) {
        if ((is2GState(paramContext)) && (isFirstEntryForum(paramContext))) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
            localBuilder.setView(LayoutInflater.from(paramContext).inflate(2130903070, null));
            localBuilder.setPositiveButton(paramContext.getString(2131100000), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.setClass(Util.this, SettingsActivity.class);
                    Util.this.startActivity(paramAnonymousDialogInterface);
                }
            });
            localBuilder.setNegativeButton(paramContext.getString(2131099914), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            });
            localBuilder.show();
        }
    }

    public static void showToastDialog(Activity paramActivity, String paramString) {
        View localView = paramActivity.getLayoutInflater().inflate(2130903404, null);
        ImageView localImageView = (ImageView) localView.findViewById(2131231675);
        TextView localTextView = (TextView) localView.findViewById(2131231676);
        localTextView.setText(paramString);
        if (SettingsFragment.isLightTheme(paramActivity)) {
            localImageView.setImageResource(2130837761);
            localView.setBackgroundResource(2130839451);
            localTextView.setTextColor(paramActivity.getResources().getColor(2131165213));
        }
        for (; ; ) {
            paramActivity = new Toast(paramActivity);
            paramActivity.setGravity(17, 0, 0);
            paramActivity.setDuration(0);
            paramActivity.setView(localView);
            paramActivity.show();
            return;
            localImageView.setImageResource(2130837762);
            localView.setBackgroundResource(2130839452);
            localTextView.setTextColor(paramActivity.getResources().getColor(2131165291));
        }
    }

    public static void showToastForLong(Activity paramActivity, final String paramString) {
        if ((checkString(paramString)) && (paramActivity != null) && (!paramActivity.isFinishing())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    Toast.makeText(Util.this, paramString, 1).show();
                }
            });
        }
    }

    public static void showToastForLong(Activity paramActivity, byte[] paramArrayOfByte) {
        if (paramArrayOfByte != null) {
            showToastForLong(paramActivity, new String(paramArrayOfByte));
        }
    }

    public static void showToastForShort(Activity paramActivity, final String paramString) {
        if ((checkString(paramString)) && (paramActivity != null) && (!paramActivity.isFinishing())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    Toast.makeText(Util.this, paramString, 0).show();
                }
            });
        }
    }

    public static void showToastForShort(Activity paramActivity, byte[] paramArrayOfByte) {
        if (paramArrayOfByte != null) {
            showToastForShort(paramActivity, new String(paramArrayOfByte));
        }
    }

    public static void signOutForum(Context paramContext, TapatalkForum paramTapatalkForum) {
        SharedPreferences.Editor localEditor = Prefs.get(paramContext).edit();
        localEditor.putBoolean(getSignOutKey(paramContext, paramTapatalkForum), true);
        localEditor.commit();
    }

    public static void startReplyActivity(ThreadOuterFragment paramThreadOuterFragment, ForumStatus paramForumStatus, Topic paramTopic, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2) {
        Intent localIntent = new Intent(paramThreadOuterFragment.activity, CreateTopicActivity.class);
        if ((paramString1 != null) && (paramString1.length() > 0)) {
            localIntent.putExtra("posttitle", paramString1);
        }
        for (; ; ) {
            localIntent.putExtra("modifytype", 38);
            localIntent.putExtra("topicid", paramTopic.getId());
            localIntent.putExtra("forumid", paramTopic.getForumId());
            localIntent.putExtra("forumStatus", paramForumStatus);
            localIntent.putExtra("countdown", paramInt2);
            if (paramInt1 != 0) {
                localIntent.putExtra("firstQuotePosition", paramInt1);
            }
            if (paramString2 != null) {
                localIntent.putExtra("quotecontent", paramString2);
            }
            localIntent.putExtra("canUpload", paramBoolean);
            paramThreadOuterFragment.startActivityForResult(localIntent, 38);
            return;
            localIntent.putExtra("posttitle", paramTopic.getTitle());
        }
    }

    public static void startReplyActivity(ThreadOuterFragment paramThreadOuterFragment, ForumStatus paramForumStatus, Topic paramTopic, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, String paramString3, int paramInt2) {
        Intent localIntent = new Intent(paramThreadOuterFragment.activity, CreateTopicActivity.class);
        if ((paramString1 != null) && (paramString1.length() > 0)) {
            localIntent.putExtra("posttitle", paramString1);
        }
        for (; ; ) {
            localIntent.putExtra("modifytype", 38);
            localIntent.putExtra("topicid", paramTopic.getId());
            localIntent.putExtra("forumid", paramTopic.getForumId());
            localIntent.putExtra("forumStatus", paramForumStatus);
            localIntent.putExtra("countdown", paramInt2);
            if (paramInt1 != 0) {
                localIntent.putExtra("firstQuotePosition", paramInt1);
            }
            if (paramString2 != null) {
                localIntent.putExtra("quotecontent", paramString2);
            }
            localIntent.putExtra("canUpload", paramBoolean);
            localIntent.putExtra("quickText", paramString3);
            paramThreadOuterFragment.startActivityForResult(localIntent, 38);
            return;
            localIntent.putExtra("posttitle", paramTopic.getTitle());
        }
    }

    public static int stringFormat(Date paramDate) {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (paramDate != null) {
            localSimpleDateFormat.format(paramDate);
            return (int) (paramDate.getTime() / 1000L);
        }
        return (int) (new Date().getTime() / 1000L);
    }

    public static Bitmap toRoundCorner(Bitmap paramBitmap, int paramInt) {
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        RectF localRectF = new RectF(localRect);
        float f = paramInt;
        localPaint.setAntiAlias(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-12434878);
        localCanvas.drawRoundRect(localRectF, f, f, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
        return localBitmap;
    }

    public static void trustAllHosts() {
        X509TrustManager local2 = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
                    throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
                    throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        try {
            SSLContext localSSLContext = SSLContext.getInstance("TLS");
            SecureRandom localSecureRandom = new SecureRandom();
            localSSLContext.init(null, new TrustManager[]{local2}, localSecureRandom);
            HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public static void unMyLock(int paramInt) {
        synchronized (lock) {
            size -= paramInt;
            try {
                Thread.sleep(50L);
                lock.notify();
                return;
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                }
            }
        }
    }

    public static void updateByoAccount(Activity paramActivity, TapatalkForum paramTapatalkForum) {
        FavoriateSqlHelper localFavoriateSqlHelper = new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        TapatalkForum localTapatalkForum2 = localFavoriateSqlHelper.getFavrivateById(paramTapatalkForum.getId());
        TapatalkForum localTapatalkForum1;
        if (localTapatalkForum2 == null) {
            localTapatalkForum1 = paramTapatalkForum;
        }
        do {
            localFavoriateSqlHelper.saveFavoriate(paramTapatalkForum);
            if (!isLoginedUser(paramActivity, localTapatalkForum1)) {
                TapatalkJsonEngine.auAddAccount(paramActivity, paramTapatalkForum.getId().intValue(), "Guest", null, "0", null, "byo", 0);
            }
            return;
            localTapatalkForum1 = localTapatalkForum2;
        } while (!localTapatalkForum2.getUserId().equals(paramTapatalkForum.getUserId()));
    }

    public static Bitmap zoomImage(Bitmap paramBitmap, double paramDouble1, double paramDouble2) {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.postScale((float) paramDouble1 / f1, (float) paramDouble2 / f2);
        return Bitmap.createBitmap(paramBitmap, 0, 0, (int) f1, (int) f2, localMatrix, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */