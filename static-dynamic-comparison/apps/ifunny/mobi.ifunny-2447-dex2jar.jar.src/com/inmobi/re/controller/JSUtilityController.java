package com.inmobi.re.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.Vibrator;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.ApiStatCollector.ApiEventType;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.IMWebView.IMWebViewPlayableListener;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;
import com.inmobi.re.container.mraidimpl.AudioTriggerer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONException;
import org.json.JSONObject;

public class JSUtilityController
        extends JSController {
    public static SimpleDateFormat[] calendarUntiFormats = {new SimpleDateFormat("yyyyMMdd'T'HHmmssZ"), new SimpleDateFormat("yyyyMMdd'T'HHmm"), new SimpleDateFormat("yyyyMMdd")};
    public static SimpleDateFormat[] formats = {new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH), new SimpleDateFormat("yyyyMMddHHmmssZ", Locale.ENGLISH), new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH), new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH), new SimpleDateFormat("yyyyMM", Locale.ENGLISH), new SimpleDateFormat("yyyy", Locale.ENGLISH)};
    DownloadManager a = null;
    Object b;
    int c = 0;
    private JSDisplayController d;
    private boolean e = false;
    private Map<String, Boolean> f = new HashMap();
    private AudioTriggerCallback g = new g(this);
    private boolean h = false;
    private boolean i = false;

    public JSUtilityController(IMWebView paramIMWebView, Context paramContext) {
        super(paramIMWebView, paramContext);
        this.d = new JSDisplayController(paramIMWebView, paramContext);
        paramIMWebView.addJavascriptInterface(this.d, "displayController");
    }

    private int a() {
        Object localObject = new String[2];
        localObject[0] = "_id";
        localObject[1] = "title";
        if (Build.VERSION.SDK_INT >= 8) {
        }
        for (localObject = this.imWebView.getActivity().getContentResolver().query(Uri.parse("content://com.android.calendar/events"), (String[]) localObject, null, null, null); (localObject != null) && (((Cursor) localObject).moveToLast()); localObject = this.imWebView.getActivity().getContentResolver().query(Uri.parse("content://calendar/events"), (String[]) localObject, null, null, null)) {
            int j = ((Cursor) localObject).getColumnIndex("title");
            int k = ((Cursor) localObject).getColumnIndex("_id");
            String str = ((Cursor) localObject).getString(j);
            localObject = ((Cursor) localObject).getString(k);
            if (str == null) {
                break;
            }
            return Integer.parseInt((String) localObject);
        }
        return 0;
    }

    private int a(String paramString, int paramInt) {
        try {
            int j = Integer.parseInt(paramString);
            return j;
        } catch (NumberFormatException paramString) {
        }
        return paramInt;
    }

    private String b(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            localObject = null;
        }
        do {
            return (String) localObject;
            localObject = paramString;
        } while (paramString.startsWith("tel:"));
        Object localObject = new StringBuilder("tel:");
        ((StringBuilder) localObject).append(paramString);
        return ((StringBuilder) localObject).toString();
    }

    private int[] b() {
        int[] arrayOfInt = new int[2];
        try {
            FrameLayout localFrameLayout = (FrameLayout) ((ViewGroup) this.imWebView.getOriginalParent()).getRootView().findViewById(16908290);
            arrayOfInt[0] = ((int) (localFrameLayout.getWidth() / this.imWebView.getDensity()));
            arrayOfInt[1] = ((int) (localFrameLayout.getHeight() / this.imWebView.getDensity()));
            return arrayOfInt;
        } catch (Exception localException) {
            arrayOfInt[1] = 0;
            arrayOfInt[0] = 0;
        }
        return arrayOfInt;
    }

    private void c() {
        if (this.i) {
            registerMicListener();
        }
    }

    private void c(String paramString) {
        new JSUtilityController.f(this, paramString).start();
    }

    public static GregorianCalendar convertDateString(String paramString) {
        SimpleDateFormat[] arrayOfSimpleDateFormat = formats;
        int k = arrayOfSimpleDateFormat.length;
        int j = 0;
        while (j < k) {
            Object localObject = arrayOfSimpleDateFormat[j];
            try {
                localObject = ((SimpleDateFormat) localObject).parse(paramString);
                GregorianCalendar localGregorianCalendar = new GregorianCalendar();
                localGregorianCalendar.setTime((Date) localObject);
                localObject = (GregorianCalendar) localGregorianCalendar;
                return (GregorianCalendar) localObject;
            } catch (Exception localException) {
                j += 1;
            }
        }
        return null;
    }

    private void d() {
        this.i = this.h;
        unRegisterMicListener();
    }

    boolean a(String paramString) {
        PackageManager localPackageManager = this.imWebView.getActivity().getPackageManager();
        return localPackageManager.checkPermission(paramString, localPackageManager.getNameForUid(Binder.getCallingUid())) == 0;
    }

    @JavascriptInterface
    public void asyncPing(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(31), null));
        try {
            Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> asyncPing: url: " + paramString);
            if (!URLUtil.isValidUrl(paramString)) {
                this.imWebView.raiseError("Invalid url", "asyncPing");
                return;
            }
            c(paramString);
            return;
        } catch (Exception paramString) {
        }
    }

    @JavascriptInterface
    public void cancelSaveContent(String paramString) {
        this.imWebView.cancelSaveContent(paramString);
    }

    @JavascriptInterface
    public void closeVideo(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(50), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> closeVideo: id :" + paramString);
        this.imWebView.closeVideo(paramString);
    }

    @JavascriptInterface
    public void createCalendarEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10) {
        GregorianCalendar localGregorianCalendar;
        try {
            if ((a("android.permission.READ_CALENDAR")) && (a("android.permission.WRITE_CALENDAR"))) {
                this.c = a();
            }
            ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(30), null));
            Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> createEvent: date: " + paramString2 + " location: " + paramString4 + " body: " + paramString5);
            if (!supports("calendar")) {
                Log.internal("[InMobi]-[RE]-4.5.1", "createCalendarEvent called even if it is not supported");
                this.imWebView.raiseError("createCalendarEvent called even if it is not supported", "createCalendarEvent");
                return;
            }
            localGregorianCalendar = convertDateString(paramString2);
            paramString3 = convertDateString(paramString3);
            if ((localGregorianCalendar == null) || (paramString3 == null)) {
                Log.debug("[InMobi]-[RE]-4.5.1", "exception");
                this.imWebView.raiseError("Date format is incorrect", "createCalendarEvent");
                return;
            }
        } catch (Exception paramString1) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Error creating reminder event", paramString1);
            return;
        }
        Intent localIntent = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
        localIntent.putExtra("extra_browser_type", 100);
        localIntent.putExtra("id", IMBrowserActivity.generateId(new JSUtilityController.a(this, paramString7, paramString10, paramString2)));
        localIntent.putExtra("eventId", paramString1);
        localIntent.putExtra("action", "createCalendarEvent");
        localIntent.putExtra("description", paramString5);
        localIntent.putExtra("summary", paramString6);
        localIntent.putExtra("location", paramString4);
        localIntent.putExtra("start", localGregorianCalendar.getTimeInMillis());
        localIntent.putExtra("end", paramString3.getTimeInMillis());
        localIntent.putExtra("status", paramString7);
        localIntent.putExtra("transparency", paramString8);
        localIntent.putExtra("recurrence", paramString9);
        if ((paramString10 != null) && (!"".equals(paramString10))) {
            localIntent.putExtra("hasAlarm", true);
        }
        this.imWebView.getActivity().startActivity(localIntent);
        if (this.imWebView.mListener != null) {
            this.imWebView.mListener.onLeaveApplication();
        }
    }

    @JavascriptInterface
    public int getAudioVolume(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(37), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> getAudioVolume: ");
        return this.imWebView.getAudioVolume(paramString);
    }

    @JavascriptInterface
    public String getCurrentPosition() {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(18), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> getCurrentPosition");
        synchronized (this.imWebView.mutexcPos) {
            this.imWebView.sendToCPHandler();
            for (; ; ) {
                boolean bool = this.imWebView.acqMutexcPos.get();
                if (bool) {
                    try {
                        this.imWebView.mutexcPos.wait();
                    } catch (InterruptedException localInterruptedException) {
                        Log.debug("[InMobi]-[RE]-4.5.1", "mutexcPos failed ", localInterruptedException);
                    }
                }
            }
        }
        this.imWebView.acqMutexcPos.set(true);
        return this.imWebView.curPosition.toString();
    }

    @JavascriptInterface
    public String getDefaultPosition() {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(19), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> getDefaultPosition");
        synchronized (this.imWebView.mutexdPos) {
            this.imWebView.sendToDPHandler();
            for (; ; ) {
                boolean bool = this.imWebView.acqMutexdPos.get();
                if (bool) {
                    try {
                        this.imWebView.mutexdPos.wait();
                    } catch (InterruptedException localInterruptedException) {
                        Log.debug("[InMobi]-[RE]-4.5.1", "mutexdPos failed ", localInterruptedException);
                    }
                }
            }
        }
        this.imWebView.acqMutexdPos.set(true);
        Log.debug("[InMobi]-[RE]-4.5.1", "mutexdPassed" + this.imWebView.defPosition);
        return this.imWebView.defPosition.toString();
    }

    @JavascriptInterface
    public String getGalleryImage() {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(25), null));
        if (!supports("getGalleryImage")) {
            Log.internal("[InMobi]-[RE]-4.5.1", "getGalleryImage called even if it is not supported");
        }
        do {
            return null;
            Intent localIntent = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
            localIntent.putExtra("extra_browser_type", 100);
            localIntent.putExtra("id", IMBrowserActivity.generateId(new JSUtilityController.c(this)));
            localIntent.putExtra("action", "getGalleryImage");
            this.imWebView.getActivity().startActivity(localIntent);
        } while (this.imWebView.mListener == null);
        this.imWebView.mListener.onLeaveApplication();
        return null;
    }

    @JavascriptInterface
    public String getMaxSize() {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(20), null));
        int[] arrayOfInt = b();
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("width", arrayOfInt[0]);
            localJSONObject.put("height", arrayOfInt[1]);
            return localJSONObject.toString();
        } catch (JSONException localJSONException) {
            for (; ; ) {
            }
        }
    }

    @JavascriptInterface
    public double getMicIntensity() {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(51), null));
        return this.imWebView.getLastGoodKnownMicValue();
    }

    @JavascriptInterface
    public String getScreenSize() {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(17), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> getScreenSize");
        Object localObject = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
        int j = (int) (((DisplayMetrics) localObject).widthPixels / ((DisplayMetrics) localObject).density);
        int k = (int) (((DisplayMetrics) localObject).heightPixels / ((DisplayMetrics) localObject).density);
        localObject = new JSONObject();
        try {
            ((JSONObject) localObject).put("width", j);
            ((JSONObject) localObject).put("height", k);
            return ((JSONObject) localObject).toString();
        } catch (JSONException localJSONException) {
            for (; ; ) {
                Log.debug("[InMobi]-[RE]-4.5.1", "Failed to get screen size");
            }
        }
    }

    @JavascriptInterface
    public String getSdkVersion() {
        return InMobi.getVersion();
    }

    @JavascriptInterface
    public int getVideoVolume(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(45), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> getVideoVolume: ");
        return this.imWebView.getVideoVolume(paramString);
    }

    @JavascriptInterface
    public void hideVideo(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(48), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> hideVideo: id :" + paramString);
        this.imWebView.hideVideo(paramString);
    }

    @JavascriptInterface
    public void incentCompleted(String paramString) {
        try {
            paramString = new JSONObject(paramString);
            HashMap localHashMap = new HashMap();
            Iterator localIterator = paramString.keys();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                try {
                    localHashMap.put(str, paramString.get(str));
                } catch (JSONException paramString) {
                    this.imWebView.incentCompleted(null);
                    return;
                }
            }
            this.imWebView.incentCompleted(localHashMap);
            return;
        } catch (JSONException paramString) {
            Log.internal("[InMobi]-[RE]-4.5.1", "JSON error");
            this.imWebView.incentCompleted(null);
        }
    }

    @JavascriptInterface
    public boolean isAudioMuted(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(35), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> isAudioMuted: ");
        return this.imWebView.isAudioMuted(paramString);
    }

    @JavascriptInterface
    public boolean isVideoMuted(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(43), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> isVideoMuted: ");
        return this.imWebView.isVideoMuted(paramString);
    }

    @JavascriptInterface
    public void log(String paramString) {
        Log.debug("[InMobi]-[RE]-4.5.1", "Ad Log Message: " + paramString);
    }

    @JavascriptInterface
    public void makeCall(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(29), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> makeCall: number: " + paramString);
        try {
            paramString = b(paramString);
            if (paramString == null) {
                this.imWebView.raiseError("Bad Phone Number", "makeCall");
                return;
            }
            paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString.toString()));
            paramString.addFlags(268435456);
            this.imWebView.getActivity().startActivity(paramString);
            this.imWebView.fireOnLeaveApplication();
            return;
        } catch (Exception paramString) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Exception in making call ", paramString);
            this.imWebView.raiseError("Exception in making call", "makeCall");
        }
    }

    @JavascriptInterface
    public void muteAudio(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(33), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> muteAudio: ");
        this.imWebView.muteAudio(paramString);
    }

    @JavascriptInterface
    public void muteVideo(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(41), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> muteVideo: ");
        this.imWebView.muteVideo(paramString);
    }

    @JavascriptInterface
    public void onUserInteraction(String paramString) {
        try {
            paramString = new JSONObject(paramString);
            HashMap localHashMap = new HashMap();
            Iterator localIterator = paramString.keys();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                try {
                    localHashMap.put(str, paramString.getString(str));
                } catch (JSONException localJSONException) {
                }
            }
            this.imWebView.userInteraction(localHashMap);
            return;
        } catch (Exception paramString) {
        }
    }

    @JavascriptInterface
    public void openExternal(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(2), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> openExternal: url: " + paramString);
        this.imWebView.openExternal(paramString);
    }

    @JavascriptInterface
    public void pauseAudio(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(39), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> pauseAudio: id :" + paramString);
        this.imWebView.pauseAudio(paramString);
    }

    @JavascriptInterface
    public void pauseVideo(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(47), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> pauseVideo: id :" + paramString);
        this.imWebView.pauseVideo(paramString);
    }

    @JavascriptInterface
    public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(32), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "playAudio: url: " + paramString1 + " autoPlay: " + paramBoolean1 + " controls: " + paramBoolean2 + " loop: " + paramBoolean3 + " startStyle: " + paramString2 + " stopStyle: " + paramString3 + " id:" + paramString4);
        this.imWebView.playAudio(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramString2, paramString3, paramString4);
    }

    @JavascriptInterface
    public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(40), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> playVideo: url: " + paramString1 + " audioMuted: " + paramBoolean1 + " autoPlay: " + paramBoolean2 + " controls: " + paramBoolean3 + " loop: " + paramBoolean4 + " x: " + paramString2 + " y: " + paramString3 + " width: " + paramString4 + " height: " + paramString5 + " startStyle: " + paramString6 + " stopStyle: " + paramString7 + " id:" + paramString8);
        JSController.Dimensions localDimensions = new JSController.Dimensions();
        localDimensions.x = a(paramString2, -99999);
        localDimensions.y = a(paramString3, -99999);
        localDimensions.width = a(paramString4, -99999);
        localDimensions.height = a(paramString5, -99999);
        if ((localDimensions.width == -99999) && (localDimensions.height == -99999)) {
            paramString2 = b();
            localDimensions.x = 0;
            localDimensions.y = 0;
            localDimensions.width = paramString2[0];
            localDimensions.height = paramString2[1];
        }
        this.imWebView.playVideo(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, localDimensions, paramString6, paramString7, paramString8);
    }

    @JavascriptInterface
    public void postToSocial(int paramInt, String paramString1, String paramString2, String paramString3) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(21), null));
        if (!supports("postToSocial." + paramInt)) {
            this.imWebView.raiseError("Social type " + paramInt + " is not supported.", "postToSocial");
            return;
        }
        if (paramString1 == null) {
            paramString1 = "";
        }
        for (; ; ) {
            if (paramString2 == null) {
                paramString1 = "";
            }
            String str = paramString3;
            if (paramString3 == null) {
                str = "";
            }
            paramString3 = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
            int j = IMBrowserActivity.generateId(new JSUtilityController.e(this));
            paramString3.putExtra("extra_browser_type", 100);
            paramString3.putExtra("id", j);
            paramString3.putExtra("action", "postToSocial");
            paramString3.putExtra("socialType", paramInt);
            paramString3.putExtra("text", paramString1);
            paramString3.putExtra("link", paramString2);
            paramString3.putExtra("image", str);
            this.imWebView.getActivity().startActivity(paramString3);
            if (this.imWebView.mListener == null) {
                break;
            }
            this.imWebView.mListener.onLeaveApplication();
            return;
        }
    }

    @SuppressLint({"NewApi"})
    public void registerBroadcastListener() {
        c();
        if (this.b != null) {
        }
        while (Build.VERSION.SDK_INT <= 8) {
            return;
        }
        try {
            if (this.a == null) {
                this.a = ((DownloadManager) this.imWebView.getActivity().getSystemService("download"));
            }
            this.b = new JSUtilityController.b(this);
            if (!this.e) {
                this.imWebView.getActivity().registerReceiver((BroadcastReceiver) this.b, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                return;
            }
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "JSUtilityController-> registerBroadcastListener. Unable to register download listener", localException);
            return;
        }
        this.b = null;
    }

    @JavascriptInterface
    public void registerMicListener() {
        if (this.h) {
            return;
        }
        this.h = true;
        AudioTriggerer.addEventListener(this.g);
    }

    public void reset() {
        if (this.d != null) {
            this.d.reset();
        }
    }

    @JavascriptInterface
    public void saveContent(String paramString1, String paramString2) {
        Object localObject = InternalSDKUtil.getContext();
        localObject = new File(((Context) localObject).getExternalFilesDir(null) + "/im_cached_content/");
        if (((File) localObject).exists()) {
            ((File) localObject).delete();
        }
        ((File) localObject).mkdir();
        char[] arrayOfChar = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder localStringBuilder = new StringBuilder();
        Random localRandom = new Random();
        int j = 0;
        while (j < 20) {
            localStringBuilder.append(arrayOfChar[localRandom.nextInt(arrayOfChar.length)]);
            j += 1;
        }
        localObject = new File((File) localObject, localStringBuilder.toString());
        this.imWebView.saveFile((File) localObject, paramString2, paramString1);
    }

    @JavascriptInterface
    public void seekAudio(String paramString, int paramInt) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(38), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> seekAudio: ");
        this.imWebView.seekAudio(paramString, paramInt);
    }

    @JavascriptInterface
    public void seekVideo(String paramString, int paramInt) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(46), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> seekVideo: ");
        this.imWebView.seekVideo(paramString, paramInt);
    }

    @JavascriptInterface
    public void sendMail(String paramString1, String paramString2, String paramString3) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(28), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> sendMail: recipient: " + paramString1 + " subject: " + paramString2 + " body: " + paramString3);
        try {
            Intent localIntent = new Intent("android.intent.action.SEND");
            localIntent.setType("plain/text");
            localIntent.putExtra("android.intent.extra.EMAIL", new String[]{paramString1});
            localIntent.putExtra("android.intent.extra.SUBJECT", paramString2);
            localIntent.putExtra("android.intent.extra.TEXT", paramString3);
            localIntent.addFlags(268435456);
            paramString1 = Intent.createChooser(localIntent, "Choose the Email Client.");
            this.imWebView.getActivity().startActivity(paramString1);
            this.imWebView.fireOnLeaveApplication();
            return;
        } catch (Exception paramString1) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Exception in sending mail ", paramString1);
            this.imWebView.raiseError("Exception in sending mail", "sendMail");
        }
    }

    @JavascriptInterface
    public void sendSMS(String paramString1, String paramString2) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(27), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> sendSMS: recipient: " + paramString1 + " body: " + paramString2);
        try {
            paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + Uri.encode(paramString1)));
            paramString1.putExtra("sms_body", paramString2);
            paramString1.addFlags(268435456);
            this.imWebView.getActivity().startActivity(paramString1);
            this.imWebView.fireOnLeaveApplication();
            return;
        } catch (Exception paramString1) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Exception in sending SMS ", paramString1);
            this.imWebView.raiseError("Exception in sending SMS", "sendSMS");
        }
    }

    @JavascriptInterface
    public void setAudioVolume(String paramString, int paramInt) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(36), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> setAudioVolume: " + paramString + " " + paramInt);
        this.imWebView.setAudioVolume(paramString, paramInt);
    }

    @JavascriptInterface
    public void setPlayableSettings(String paramString) {
        try {
            paramString = new JSONObject(paramString);
            HashMap localHashMap = new HashMap();
            Iterator localIterator = paramString.keys();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                try {
                    localHashMap.put(str, paramString.get(str));
                } catch (JSONException localJSONException) {
                    Log.internal("[InMobi]-[RE]-4.5.1", "Playable Ads Settings map key " + str + " has invalid value");
                }
            }
            this.imWebView.getPlayableListener().onPlayableSettingsReceived(localHashMap);
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception setting playable settings", paramString);
            return;
        }
    }

    @JavascriptInterface
    public void setVideoVolume(String paramString, int paramInt) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(44), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> setVideoVolume: ");
        this.imWebView.setVideoVolume(paramString, paramInt);
    }

    public void setWebViewClosed(boolean paramBoolean) {
        this.e = paramBoolean;
    }

    @JavascriptInterface
    public void showAlert(String paramString) {
        Log.debug("[InMobi]-[RE]-4.5.1", paramString);
    }

    @JavascriptInterface
    public void showVideo(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(49), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> showVideo: id :" + paramString);
        this.imWebView.showVideo(paramString);
    }

    public void stopAllListeners() {
        try {
            this.d.stopAllListeners();
            return;
        } catch (Exception localException) {
        }
    }

    /* Error */
    @JavascriptInterface
    @SuppressLint({"NewApi"})
    public void storePicture(String paramString) {
        // Byte code:
        //   0: invokestatic 284	com/inmobi/commons/internal/ApiStatCollector:getLogger	()Lcom/inmobi/commons/metric/Logger;
        //   3: new 286	com/inmobi/commons/metric/EventLog
        //   6: dup
        //   7: new 288	com/inmobi/commons/internal/ApiStatCollector$ApiEventType
        //   10: dup
        //   11: bipush 23
        //   13: invokespecial 291	com/inmobi/commons/internal/ApiStatCollector$ApiEventType:<init>	(I)V
        //   16: aconst_null
        //   17: invokespecial 294	com/inmobi/commons/metric/EventLog:<init>	(Lcom/inmobi/commons/metric/EventType;Lorg/json/JSONObject;)V
        //   20: invokevirtual 300	com/inmobi/commons/metric/Logger:logEvent	(Lcom/inmobi/commons/metric/EventLog;)V
        //   23: ldc_w 302
        //   26: new 189	java/lang/StringBuilder
        //   29: dup
        //   30: invokespecial 303	java/lang/StringBuilder:<init>	()V
        //   33: ldc_w 961
        //   36: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   39: aload_1
        //   40: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   43: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   46: invokestatic 311	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   49: aload_1
        //   50: invokestatic 964	com/inmobi/commons/internal/InternalSDKUtil:getFinalRedirectedUrl	(Ljava/lang/String;)Ljava/lang/String;
        //   53: invokestatic 141	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
        //   56: astore_1
        //   57: aload_0
        //   58: ldc_w 965
        //   61: invokevirtual 352	com/inmobi/re/controller/JSUtilityController:supports	(Ljava/lang/String;)Z
        //   64: ifeq +33 -> 97
        //   67: new 967	android/app/DownloadManager$Request
        //   70: dup
        //   71: aload_1
        //   72: invokespecial 970	android/app/DownloadManager$Request:<init>	(Landroid/net/Uri;)V
        //   75: astore_2
        //   76: aload_2
        //   77: getstatic 976	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
        //   80: aload_1
        //   81: invokevirtual 979	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
        //   84: invokevirtual 983	android/app/DownloadManager$Request:setDestinationInExternalPublicDir	(Ljava/lang/String;Ljava/lang/String;)Landroid/app/DownloadManager$Request;
        //   87: pop
        //   88: aload_0
        //   89: getfield 73	com/inmobi/re/controller/JSUtilityController:a	Landroid/app/DownloadManager;
        //   92: aload_2
        //   93: invokevirtual 987	android/app/DownloadManager:enqueue	(Landroid/app/DownloadManager$Request;)J
        //   96: pop2
        //   97: return
        //   98: astore_1
        //   99: aload_0
        //   100: getfield 123	com/inmobi/re/controller/JSUtilityController:imWebView	Lcom/inmobi/re/container/IMWebView;
        //   103: ldc_w 989
        //   106: ldc_w 965
        //   109: invokevirtual 322	com/inmobi/re/container/IMWebView:raiseError	(Ljava/lang/String;Ljava/lang/String;)V
        //   112: return
        //   113: astore_1
        //   114: aload_0
        //   115: getfield 123	com/inmobi/re/controller/JSUtilityController:imWebView	Lcom/inmobi/re/container/IMWebView;
        //   118: ldc_w 991
        //   121: ldc_w 965
        //   124: invokevirtual 322	com/inmobi/re/container/IMWebView:raiseError	(Ljava/lang/String;Ljava/lang/String;)V
        //   127: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	128	0	this	JSUtilityController
        //   0	128	1	paramString	String
        //   75	18	2	localRequest	android.app.DownloadManager.Request
        // Exception table:
        //   from	to	target	type
        //   49	57	98	java/lang/Exception
        //   67	97	113	java/lang/Exception
    }

    @SuppressLint({"NewApi"})
    public boolean supports(String paramString) {
        boolean bool3 = true;
        boolean bool4 = true;
        boolean bool2 = true;
        boolean bool1 = true;
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(22), null));
        if ((paramString.equals("html5video")) || (paramString.equals("inlineVideo"))) {
            if (Build.VERSION.SDK_INT >= 11) {
                if ((this.imWebView.isHardwareAccelerated()) && (this.imWebView.isEnabledHardwareAcceleration())) {
                    bool1 = true;
                }
            }
            for (localObject1 = Boolean.valueOf(bool1); ; localObject1 = Boolean.valueOf(true)) {
                this.f.put(paramString, localObject1);
                return ((Boolean) localObject1).booleanValue();
                bool1 = false;
                break;
            }
        }
        Object localObject1 = (Boolean) this.f.get(paramString);
        if (localObject1 != null) {
            return ((Boolean) localObject1).booleanValue();
        }
        localObject1 = this.imWebView.getActivity().getPackageManager();
        if (paramString.equals("tel")) {
            this.f.put(paramString, Boolean.valueOf(true));
            return true;
        }
        if (paramString.equals("sms")) {
            localObject1 = new Intent("android.intent.action.VIEW");
            ((Intent) localObject1).setType("vnd.android-dir/mms-sms");
            if (this.imWebView.getActivity().getPackageManager().resolveActivity((Intent) localObject1, 65536) == null) {
            }
            for (localObject1 = Boolean.valueOf(false); ; localObject1 = Boolean.valueOf(true)) {
                this.f.put(paramString, localObject1);
                return ((Boolean) localObject1).booleanValue();
            }
        }
        if (paramString.equals("calendar")) {
            localObject1 = new Intent("android.intent.action.VIEW");
            ((Intent) localObject1).setType("vnd.android.cursor.item/event");
            if (this.imWebView.getActivity().getPackageManager().resolveActivity((Intent) localObject1, 65536) == null) {
            }
            for (localObject1 = Boolean.valueOf(false); ; localObject1 = Boolean.valueOf(true)) {
                this.f.put(paramString, localObject1);
                return ((Boolean) localObject1).booleanValue();
            }
        }
        if (paramString.equals("microphone")) {
            if (((PackageManager) localObject1).checkPermission("android.permission.RECORD_AUDIO", ((PackageManager) localObject1).getNameForUid(Binder.getCallingUid())) == 0) {
            }
            for (; ; ) {
                localObject1 = Boolean.valueOf(bool1);
                this.f.put(paramString, localObject1);
                return ((Boolean) localObject1).booleanValue();
                bool1 = false;
            }
        }
        if (paramString.equals("storePicture")) {
            if ((Build.VERSION.SDK_INT > 8) && (((PackageManager) localObject1).checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", ((PackageManager) localObject1).getNameForUid(Binder.getCallingUid())) == 0)) {
            }
            for (bool1 = bool3; ; bool1 = false) {
                localObject1 = Boolean.valueOf(bool1);
                this.f.put(paramString, localObject1);
                return ((Boolean) localObject1).booleanValue();
            }
        }
        if ((paramString.equals("postToSocial.2")) || (paramString.equals("postToSocial.3"))) {
            localObject1 = Boolean.valueOf(true);
            this.f.put(paramString, localObject1);
            return ((Boolean) localObject1).booleanValue();
        }
        Object localObject2;
        if (paramString.equals("takeCameraPicture")) {
            localObject2 = new Intent("android.media.action.IMAGE_CAPTURE");
            localObject2 = this.imWebView.getActivity().getPackageManager().resolveActivity((Intent) localObject2, 65536);
            if (((PackageManager) localObject1).checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", ((PackageManager) localObject1).getNameForUid(Binder.getCallingUid())) == 0) {
            }
            for (int j = 1; localObject2 == null; j = 0) {
                localObject1 = Boolean.valueOf(false);
                this.f.put(paramString, localObject1);
                return ((Boolean) localObject1).booleanValue();
            }
            if (j != 0) {
            }
            for (bool1 = bool4; ; bool1 = false) {
                localObject1 = Boolean.valueOf(bool1);
                break;
            }
        }
        if (paramString.equals("getGalleryImage")) {
            localObject1 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (this.imWebView.getActivity().getPackageManager().resolveActivity((Intent) localObject1, 65536) == null) {
            }
            for (localObject1 = Boolean.valueOf(false); ; localObject1 = Boolean.valueOf(true)) {
                this.f.put(paramString, localObject1);
                return ((Boolean) localObject1).booleanValue();
            }
        }
        if (paramString.equals("vibrate")) {
            if (((PackageManager) localObject1).checkPermission("android.permission.VIBRATE", ((PackageManager) localObject1).getNameForUid(Binder.getCallingUid())) == 0) {
                bool1 = true;
                localObject1 = Boolean.valueOf(bool1);
                localObject2 = (Vibrator) this.d.imWebView.getActivity().getSystemService("vibrator");
                if (localObject2 != null) {
                    break label826;
                }
                localObject1 = Boolean.valueOf(false);
            }
        }
        for (; ; ) {
            this.f.put(paramString, localObject1);
            return ((Boolean) localObject1).booleanValue();
            bool1 = false;
            break;
            label826:
            if (Build.VERSION.SDK_INT >= 11) {
                if ((((Boolean) localObject1).booleanValue()) && (((Vibrator) localObject2).hasVibrator())) {
                }
                for (bool1 = bool2; ; bool1 = false) {
                    localObject1 = Boolean.valueOf(bool1);
                    break;
                }
                return false;
            }
        }
    }

    @JavascriptInterface
    public String supportsFeature(String paramString) {
        return String.valueOf(supports(paramString));
    }

    @JavascriptInterface
    public String takeCameraPicture() {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(24), null));
        if (!supports("takeCameraPicture")) {
            Log.internal("[InMobi]-[RE]-4.5.1", "takeCameraPicture called even if it is not supported");
        }
        do {
            return null;
            Intent localIntent = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
            localIntent.putExtra("extra_browser_type", 100);
            Object localObject = new ContentValues();
            localObject = this.mContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (ContentValues) localObject);
            localIntent.putExtra("id", IMBrowserActivity.generateId(new JSUtilityController.d(this, (Uri) localObject)));
            localIntent.putExtra("URI", (Parcelable) localObject);
            localIntent.putExtra("action", "takeCameraPicture");
            this.imWebView.getActivity().startActivity(localIntent);
        } while (this.imWebView.mListener == null);
        this.imWebView.mListener.onLeaveApplication();
        return null;
    }

    @JavascriptInterface
    public void unMuteAudio(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(34), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> unMuteAudio: ");
        this.imWebView.unMuteAudio(paramString);
    }

    @JavascriptInterface
    public void unMuteVideo(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(42), null));
        Log.debug("[InMobi]-[RE]-4.5.1", "JSUtilityController-> unMuteVideo: ");
        this.imWebView.unMuteVideo(paramString);
    }

    @SuppressLint({"NewApi"})
    public void unRegisterBroadcastListener() {
        try {
            d();
            if (Build.VERSION.SDK_INT > 8) {
                this.imWebView.getActivity().unregisterReceiver((BroadcastReceiver) this.b);
                this.b = null;
            }
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "JSUtilityController-> unregisterBroadcastListener. Unable to unregister download listener");
        }
    }

    @JavascriptInterface
    public void unRegisterMicListener() {
        if (!this.h) {
            return;
        }
        this.h = false;
        AudioTriggerer.removeEventListener(this.g);
    }

    @JavascriptInterface
    public void vibrate() {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(26), null));
        if (!this.imWebView.isViewable()) {
            this.imWebView.raiseError("Creative not visible. Will not vibrate.", "vibrate");
            return;
        }
        if (supports("vibrate")) {
            ((Vibrator) this.imWebView.getActivity().getSystemService("vibrator")).vibrate(2000L);
            new Timer().schedule(new JSUtilityController.g(this), 2000L);
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.1", "vibrate called even if it is not supported");
    }

    @JavascriptInterface
    public void vibrate(String paramString, int paramInt) {
        Vibrator localVibrator;
        try {
            ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(26), null));
            if (!this.imWebView.isViewable()) {
                this.imWebView.raiseError("Creative not visible. Will not vibrate.", "vibrate");
                return;
            }
            if (!supports("vibrate")) {
                break label347;
            }
            localVibrator = (Vibrator) this.imWebView.getActivity().getSystemService("vibrator");
            paramString = paramString.replaceAll("\\[", "").replaceAll("\\]", "");
            if ((paramString == null) || ("".equals(paramString.trim()))) {
                localVibrator.cancel();
                return;
            }
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[RE]-4.5.1", "vibrate exception", paramString);
            return;
        }
        paramString = paramString.split(",");
        int j = paramString.length;
        long[] arrayOfLong;
        int k;
        if (j > Initializer.getConfigParams().getMaxVibPatternLength()) {
            Log.internal("[InMobi]-[RE]-4.5.1", "vibration pattern exceeds max length. Will be truncated to max " + Initializer.getConfigParams().getMaxVibPatternLength() + "ms");
            j = Initializer.getConfigParams().getMaxVibPatternLength();
            arrayOfLong = new long[j];
            k = 0;
        }
        for (; ; ) {
            if (k < j) {
                try {
                    arrayOfLong[k] = Long.parseLong(paramString[k]);
                    if (arrayOfLong[k] > Initializer.getConfigParams().getMaxVibDuration()) {
                        Log.internal("[InMobi]-[RE]-4.5.1", "vibration duration exceeds max. Will only vibrate for max " + Initializer.getConfigParams().getMaxVibDuration() + "ms");
                        arrayOfLong[k] = Initializer.getConfigParams().getMaxVibDuration();
                    }
                    if (arrayOfLong[k] >= 0L) {
                        break label374;
                    }
                    this.imWebView.raiseError("Negative duration not allowed in vibration .", "vibrate");
                } catch (NumberFormatException paramString) {
                    this.imWebView.raiseError("Invalid values of pattern in vibration .", "vibrate");
                    return;
                }
            }
            if ((arrayOfLong != null) && (arrayOfLong.length != 0)) {
                localVibrator.vibrate(arrayOfLong, paramInt);
                return;
                label347:
                this.imWebView.raiseError("Vibrate called even if it is not supported.", "vibrate");
                Log.internal("[InMobi]-[RE]-4.5.1", "vibrate called even if it is not supported");
                return;
                break;
            }
            return;
            label374:
            k += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSUtilityController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */