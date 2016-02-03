package com.inmobi.re.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.ApiStatCollector.ApiEventType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;
import com.inmobi.re.container.mraidimpl.AudioTriggerer;
import com.inmobi.re.controller.util.ImageProcessing;
import com.inmobi.re.controller.util.StartActivityForResultCallback;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class JSUtilityController
  extends JSController
{
  DownloadManager a = null;
  Object b;
  private JSDisplayController c;
  private Map<String, Boolean> d = new HashMap();
  private AudioTriggerCallback e = new d(this);
  private boolean f = false;
  private boolean g = false;
  
  public JSUtilityController(IMWebView paramIMWebView, Context paramContext)
  {
    super(paramIMWebView, paramContext);
    this.c = new JSDisplayController(paramIMWebView, paramContext);
    paramIMWebView.addJavascriptInterface(this.c, "displayController");
  }
  
  private int a(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    do
    {
      return (String)localObject;
      localObject = paramString;
    } while (paramString.startsWith("tel:"));
    Object localObject = new StringBuilder("tel:");
    ((StringBuilder)localObject).append(paramString);
    return ((StringBuilder)localObject).toString();
  }
  
  private int[] a()
  {
    int[] arrayOfInt = new int[2];
    try
    {
      FrameLayout localFrameLayout = (FrameLayout)((ViewGroup)this.imWebView.getOriginalParent()).getRootView().findViewById(16908290);
      arrayOfInt[0] = ((int)(localFrameLayout.getWidth() / this.imWebView.getDensity()));
      arrayOfInt[1] = ((int)(localFrameLayout.getHeight() / this.imWebView.getDensity()));
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
    }
    return arrayOfInt;
  }
  
  private void b()
  {
    if (this.g) {
      registerMicListener();
    }
  }
  
  private void b(final String paramString)
  {
    new d(paramString).start();
  }
  
  private void c()
  {
    this.g = this.f;
    unRegisterMicListener();
  }
  
  @SuppressLint({"NewApi"})
  private boolean c(String paramString)
  {
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool4 = false;
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(22), null));
    Object localObject = (Boolean)this.d.get(paramString);
    if (localObject != null)
    {
      bool1 = ((Boolean)localObject).booleanValue();
      return bool1;
    }
    localObject = this.imWebView.getActivity().getPackageManager();
    if (paramString.equals("tel"))
    {
      if (((PackageManager)localObject).checkPermission("android.permission.CALL_PHONE", ((PackageManager)localObject).getNameForUid(Binder.getCallingUid())) == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject = Boolean.valueOf(bool1);
        this.d.put(paramString, localObject);
        return ((Boolean)localObject).booleanValue();
      }
    }
    if (paramString.equals("sms"))
    {
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setType("vnd.android-dir/mms-sms");
      if (this.imWebView.getActivity().getPackageManager().resolveActivity((Intent)localObject, 65536) == null) {}
      for (localObject = Boolean.valueOf(false);; localObject = Boolean.valueOf(true))
      {
        this.d.put(paramString, localObject);
        return ((Boolean)localObject).booleanValue();
      }
    }
    if (paramString.equals("calendar"))
    {
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setType("vnd.android.cursor.item/event");
      if (this.imWebView.getActivity().getPackageManager().resolveActivity((Intent)localObject, 65536) == null) {}
      for (localObject = Boolean.valueOf(false);; localObject = Boolean.valueOf(true))
      {
        this.d.put(paramString, localObject);
        return ((Boolean)localObject).booleanValue();
      }
    }
    if (paramString.equals("microphone"))
    {
      if (((PackageManager)localObject).checkPermission("android.permission.RECORD_AUDIO", ((PackageManager)localObject).getNameForUid(Binder.getCallingUid())) == 0) {}
      for (;;)
      {
        localObject = Boolean.valueOf(bool1);
        this.d.put(paramString, localObject);
        return ((Boolean)localObject).booleanValue();
        bool1 = false;
      }
    }
    if (paramString.equals("storePicture"))
    {
      if ((Build.VERSION.SDK_INT > 8) && (((PackageManager)localObject).checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", ((PackageManager)localObject).getNameForUid(Binder.getCallingUid())) == 0)) {}
      for (bool1 = bool5;; bool1 = false)
      {
        localObject = Boolean.valueOf(bool1);
        this.d.put(paramString, localObject);
        return ((Boolean)localObject).booleanValue();
      }
    }
    if ((paramString.equals("postToSocial.2")) || (paramString.equals("postToSocial.3")) || (paramString.equals("inlineVideo")))
    {
      localObject = Boolean.valueOf(true);
      this.d.put(paramString, localObject);
      return ((Boolean)localObject).booleanValue();
    }
    if (paramString.equals("takeCameraPicture"))
    {
      localObject = new Intent("android.media.action.IMAGE_CAPTURE");
      if (this.imWebView.getActivity().getPackageManager().resolveActivity((Intent)localObject, 65536) == null) {}
      for (localObject = Boolean.valueOf(false);; localObject = Boolean.valueOf(true))
      {
        this.d.put(paramString, localObject);
        return ((Boolean)localObject).booleanValue();
      }
    }
    if (paramString.equals("getGalleryImage"))
    {
      localObject = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
      if (this.imWebView.getActivity().getPackageManager().resolveActivity((Intent)localObject, 65536) == null) {}
      for (localObject = Boolean.valueOf(false);; localObject = Boolean.valueOf(true))
      {
        this.d.put(paramString, localObject);
        return ((Boolean)localObject).booleanValue();
      }
    }
    label670:
    Vibrator localVibrator;
    if (paramString.equals("vibrate")) {
      if (((PackageManager)localObject).checkPermission("android.permission.VIBRATE", ((PackageManager)localObject).getNameForUid(Binder.getCallingUid())) == 0)
      {
        bool1 = true;
        localObject = Boolean.valueOf(bool1);
        localVibrator = (Vibrator)this.c.imWebView.getActivity().getSystemService("vibrator");
        if (localVibrator != null) {
          break label732;
        }
        localObject = Boolean.valueOf(false);
      }
    }
    for (;;)
    {
      this.d.put(paramString, localObject);
      return ((Boolean)localObject).booleanValue();
      bool1 = false;
      break label670;
      label732:
      if (Build.VERSION.SDK_INT >= 11)
      {
        if ((((Boolean)localObject).booleanValue()) && (localVibrator.hasVibrator())) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localObject = Boolean.valueOf(bool1);
          break;
        }
        bool1 = bool4;
        if (!paramString.equals("html5video")) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 11) {
          if ((this.imWebView.isHardwareAccelerated()) && (this.imWebView.isEnabledHardwareAcceleration())) {
            bool1 = bool3;
          }
        }
        for (localObject = Boolean.valueOf(bool1);; localObject = Boolean.valueOf(true))
        {
          this.d.put(paramString, localObject);
          return ((Boolean)localObject).booleanValue();
          bool1 = false;
          break;
        }
      }
    }
  }
  
  @JavascriptInterface
  public void asyncPing(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(31), null));
    try
    {
      Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> asyncPing: url: " + paramString);
      if (!URLUtil.isValidUrl(paramString))
      {
        this.imWebView.raiseError("Invalid url", "asyncPing");
        return;
      }
      b(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  @JavascriptInterface
  public void closeVideo(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(50), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> closeVideo: id :" + paramString);
    this.imWebView.closeVideo(paramString);
  }
  
  public GregorianCalendar convertDateString(String paramString)
    throws ParseException
  {
    paramString = new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ", Locale.ENGLISH).parse(paramString);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTime(paramString);
    return (GregorianCalendar)localGregorianCalendar;
  }
  
  @JavascriptInterface
  public void createCalendarEvent(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(30), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> createEvent: date: " + paramString1 + " location: " + paramString3 + " body: " + paramString4);
    if (!c("calendar")) {
      Log.internal("[InMobi]-[RE]-4.1.1", "createCalendarEvent called even if it is not supported");
    }
    for (;;)
    {
      return;
      try
      {
        paramString1 = convertDateString(paramString1);
        paramString2 = convertDateString(paramString2);
        Intent localIntent = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
        localIntent.putExtra("id", IMBrowserActivity.generateId(new e()));
        localIntent.putExtra("action", "createCalendarEvent");
        localIntent.putExtra("description", paramString4);
        localIntent.putExtra("location", paramString3);
        localIntent.putExtra("start", paramString1.getTimeInMillis());
        localIntent.putExtra("end", paramString2.getTimeInMillis());
        this.imWebView.getActivity().startActivity(localIntent);
        if (this.imWebView.mListener != null)
        {
          this.imWebView.mListener.onLeaveApplication();
          return;
        }
      }
      catch (Exception paramString1)
      {
        Log.debug("[InMobi]-[RE]-4.1.1", "exception" + paramString1.getMessage());
        this.imWebView.raiseError("Date format is incorrect", "createCalendarEvent");
      }
    }
  }
  
  @JavascriptInterface
  public int getAudioVolume(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(37), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> getAudioVolume: ");
    return this.imWebView.getAudioVolume(paramString);
  }
  
  @JavascriptInterface
  public String getCurrentPosition()
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(18), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> getCurrentPosition");
    synchronized (this.imWebView.mutexcPos)
    {
      this.imWebView.sendToCPHandler();
      for (;;)
      {
        boolean bool = this.imWebView.acqMutexcPos.get();
        if (bool) {
          try
          {
            this.imWebView.mutexcPos.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.debug("[InMobi]-[RE]-4.1.1", "mutexcPos failed ", localInterruptedException);
          }
        }
      }
    }
    this.imWebView.acqMutexcPos.set(true);
    return this.imWebView.curPosition.toString();
  }
  
  @JavascriptInterface
  public String getDefaultPosition()
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(19), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> getDefaultPosition");
    synchronized (this.imWebView.mutexdPos)
    {
      this.imWebView.sendToDPHandler();
      for (;;)
      {
        boolean bool = this.imWebView.acqMutexdPos.get();
        if (bool) {
          try
          {
            this.imWebView.mutexdPos.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.debug("[InMobi]-[RE]-4.1.1", "mutexdPos failed ", localInterruptedException);
          }
        }
      }
    }
    this.imWebView.acqMutexdPos.set(true);
    Log.debug("[InMobi]-[RE]-4.1.1", "mutexdPassed" + this.imWebView.defPosition);
    return this.imWebView.defPosition.toString();
  }
  
  @JavascriptInterface
  public String getGalleryImage()
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(25), null));
    if (!c("getGalleryImage")) {
      Log.internal("[InMobi]-[RE]-4.1.1", "getGalleryImage called even if it is not supported");
    }
    do
    {
      return null;
      Intent localIntent = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
      localIntent.putExtra("id", IMBrowserActivity.generateId(new a()));
      localIntent.putExtra("action", "getGalleryImage");
      this.imWebView.getActivity().startActivity(localIntent);
    } while (this.imWebView.mListener == null);
    this.imWebView.mListener.onLeaveApplication();
    return null;
  }
  
  @JavascriptInterface
  public String getMaxSize()
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(20), null));
    int[] arrayOfInt = a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("width", arrayOfInt[0]);
      localJSONObject.put("height", arrayOfInt[1]);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  @JavascriptInterface
  public double getMicIntensity()
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(51), null));
    return this.imWebView.getLastGoodKnownMicValue();
  }
  
  @JavascriptInterface
  public String getScreenSize()
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(17), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> getScreenSize");
    Object localObject = new DisplayMetrics();
    ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = (int)(((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).density);
    int j = (int)(((DisplayMetrics)localObject).heightPixels / ((DisplayMetrics)localObject).density);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("width", i);
      ((JSONObject)localObject).put("height", j);
      return ((JSONObject)localObject).toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.debug("[InMobi]-[RE]-4.1.1", "Failed to get screen size");
      }
    }
  }
  
  @JavascriptInterface
  public int getVideoVolume(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(45), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> getVideoVolume: ");
    return this.imWebView.getVideoVolume(paramString);
  }
  
  @JavascriptInterface
  public void hideVideo(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(48), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> hideVideo: id :" + paramString);
    this.imWebView.hideVideo(paramString);
  }
  
  @JavascriptInterface
  public boolean isAudioMuted(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(35), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> isAudioMuted: ");
    return this.imWebView.isAudioMuted(paramString);
  }
  
  @JavascriptInterface
  public boolean isVideoMuted(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(43), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> isVideoMuted: ");
    return this.imWebView.isVideoMuted(paramString);
  }
  
  @JavascriptInterface
  public void log(String paramString)
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "Ad Log Message: " + paramString);
  }
  
  @JavascriptInterface
  public void makeCall(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(29), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> makeCall: number: " + paramString);
    try
    {
      paramString = a(paramString);
      if (paramString == null)
      {
        this.imWebView.raiseError("Bad Phone Number", "makeCall");
        return;
      }
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString.toString()));
      paramString.addFlags(268435456);
      this.imWebView.getActivity().startActivity(paramString);
      this.imWebView.fireOnLeaveApplication();
      return;
    }
    catch (Exception paramString)
    {
      Log.debug("[InMobi]-[RE]-4.1.1", "Exception in making call ", paramString);
      this.imWebView.raiseError("Exception in making call", "makeCall");
    }
  }
  
  @JavascriptInterface
  public void muteAudio(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(33), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> muteAudio: ");
    this.imWebView.muteAudio(paramString);
  }
  
  @JavascriptInterface
  public void muteVideo(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(41), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> muteVideo: ");
    this.imWebView.muteVideo(paramString);
  }
  
  @JavascriptInterface
  public void onUserInteraction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          localHashMap.put(str, paramString.getString(str));
        }
        catch (JSONException localJSONException) {}
      }
      this.imWebView.userInteraction(localHashMap);
      return;
    }
    catch (Exception paramString) {}
  }
  
  @JavascriptInterface
  public void openExternal(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(2), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> openExternal: url: " + paramString);
    this.imWebView.openExternal(paramString);
  }
  
  @JavascriptInterface
  public void pauseAudio(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(39), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> pauseAudio: id :" + paramString);
    this.imWebView.pauseAudio(paramString);
  }
  
  @JavascriptInterface
  public void pauseVideo(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(47), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> pauseVideo: id :" + paramString);
    this.imWebView.pauseVideo(paramString);
  }
  
  @JavascriptInterface
  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(32), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "playAudio: url: " + paramString1 + " autoPlay: " + paramBoolean1 + " controls: " + paramBoolean2 + " loop: " + paramBoolean3 + " startStyle: " + paramString2 + " stopStyle: " + paramString3 + " id:" + paramString4);
    this.imWebView.playAudio(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramString2, paramString3, paramString4);
  }
  
  @JavascriptInterface
  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(40), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> playVideo: url: " + paramString1 + " audioMuted: " + paramBoolean1 + " autoPlay: " + paramBoolean2 + " controls: " + paramBoolean3 + " loop: " + paramBoolean4 + " x: " + paramString2 + " y: " + paramString3 + " width: " + paramString4 + " height: " + paramString5 + " startStyle: " + paramString6 + " stopStyle: " + paramString7 + " id:" + paramString8);
    JSController.Dimensions localDimensions = new JSController.Dimensions();
    localDimensions.x = a(paramString2, -99999);
    localDimensions.y = a(paramString3, -99999);
    localDimensions.width = a(paramString4, -99999);
    localDimensions.height = a(paramString5, -99999);
    if ((localDimensions.width == -99999) && (localDimensions.height == -99999))
    {
      paramString2 = a();
      localDimensions.x = 0;
      localDimensions.y = 0;
      localDimensions.width = paramString2[0];
      localDimensions.height = paramString2[1];
    }
    this.imWebView.playVideo(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, localDimensions, paramString6, paramString7, paramString8);
  }
  
  @JavascriptInterface
  public void postToSocial(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(21), null));
    if (!c("postToSocial." + paramInt))
    {
      this.imWebView.raiseError("Social type " + paramInt + " is not supported.", "postToSocial");
      return;
    }
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString1 = "";
      }
      String str = paramString3;
      if (paramString3 == null) {
        str = "";
      }
      paramString3 = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
      paramString3.putExtra("id", IMBrowserActivity.generateId(new c()));
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
  public void registerBroadcastListener()
  {
    b();
    if (this.b != null) {}
    while (Build.VERSION.SDK_INT <= 8) {
      return;
    }
    try
    {
      if (this.a == null) {
        this.a = ((DownloadManager)this.imWebView.getActivity().getSystemService("download"));
      }
      this.b = new f();
      this.imWebView.getActivity().registerReceiver((BroadcastReceiver)this.b, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "JSUtilityController-> registerBroadcastListener. Unable to register download listener", localException);
    }
  }
  
  @JavascriptInterface
  public void registerMicListener()
  {
    if (this.f) {
      return;
    }
    this.f = true;
    AudioTriggerer.addEventListener(this.e);
  }
  
  public void reset()
  {
    if (this.c != null) {
      this.c.reset();
    }
  }
  
  @JavascriptInterface
  public void seekAudio(String paramString, int paramInt)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(38), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> seekAudio: ");
    this.imWebView.seekAudio(paramString, paramInt);
  }
  
  @JavascriptInterface
  public void seekVideo(String paramString, int paramInt)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(46), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> seekVideo: ");
    this.imWebView.seekVideo(paramString, paramInt);
  }
  
  @JavascriptInterface
  public void sendMail(String paramString1, String paramString2, String paramString3)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(28), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> sendMail: recipient: " + paramString1 + " subject: " + paramString2 + " body: " + paramString3);
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("plain/text");
      localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString1 });
      localIntent.putExtra("android.intent.extra.SUBJECT", paramString2);
      localIntent.putExtra("android.intent.extra.TEXT", paramString3);
      localIntent.addFlags(268435456);
      paramString1 = Intent.createChooser(localIntent, "Choose the Email Client.");
      this.imWebView.getActivity().startActivity(paramString1);
      this.imWebView.fireOnLeaveApplication();
      return;
    }
    catch (Exception paramString1)
    {
      Log.debug("[InMobi]-[RE]-4.1.1", "Exception in sending mail ", paramString1);
      this.imWebView.raiseError("Exception in sending mail", "sendMail");
    }
  }
  
  @JavascriptInterface
  public void sendSMS(String paramString1, String paramString2)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(27), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> sendSMS: recipient: " + paramString1 + " body: " + paramString2);
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.putExtra("address", paramString1);
      localIntent.putExtra("sms_body", paramString2);
      localIntent.setType("vnd.android-dir/mms-sms");
      localIntent.addFlags(268435456);
      this.imWebView.getActivity().startActivity(localIntent);
      this.imWebView.fireOnLeaveApplication();
      return;
    }
    catch (Exception paramString1)
    {
      Log.debug("[InMobi]-[RE]-4.1.1", "Exception in sending SMS ", paramString1);
      this.imWebView.raiseError("Exception in sending SMS", "sendSMS");
    }
  }
  
  @JavascriptInterface
  public void setAudioVolume(String paramString, int paramInt)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(36), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> setAudioVolume: " + paramString + " " + paramInt);
    this.imWebView.setAudioVolume(paramString, paramInt);
  }
  
  @JavascriptInterface
  public void setVideoVolume(String paramString, int paramInt)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(44), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> setVideoVolume: ");
    this.imWebView.setVideoVolume(paramString, paramInt);
  }
  
  @JavascriptInterface
  public void showAlert(String paramString)
  {
    Log.debug("[InMobi]-[RE]-4.1.1", paramString);
  }
  
  @JavascriptInterface
  public void showVideo(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(49), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> showVideo: id :" + paramString);
    this.imWebView.showVideo(paramString);
  }
  
  public void stopAllListeners()
  {
    try
    {
      this.c.stopAllListeners();
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  @JavascriptInterface
  @SuppressLint({"NewApi"})
  public void storePicture(String paramString)
  {
    // Byte code:
    //   0: invokestatic 165	com/inmobi/commons/internal/ApiStatCollector:getLogger	()Lcom/inmobi/commons/metric/Logger;
    //   3: new 167	com/inmobi/commons/metric/EventLog
    //   6: dup
    //   7: new 169	com/inmobi/commons/internal/ApiStatCollector$ApiEventType
    //   10: dup
    //   11: bipush 23
    //   13: invokespecial 172	com/inmobi/commons/internal/ApiStatCollector$ApiEventType:<init>	(I)V
    //   16: aconst_null
    //   17: invokespecial 175	com/inmobi/commons/metric/EventLog:<init>	(Lcom/inmobi/commons/metric/EventType;Lorg/json/JSONObject;)V
    //   20: invokevirtual 181	com/inmobi/commons/metric/Logger:logEvent	(Lcom/inmobi/commons/metric/EventLog;)V
    //   23: ldc_w 322
    //   26: new 96	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 865
    //   36: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 331	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokestatic 870	com/inmobi/commons/internal/InternalSDKUtil:getFinalRedirectedUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 618	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   56: astore_1
    //   57: aload_0
    //   58: ldc_w 262
    //   61: invokespecial 391	com/inmobi/re/controller/JSUtilityController:c	(Ljava/lang/String;)Z
    //   64: ifeq +33 -> 97
    //   67: new 872	android/app/DownloadManager$Request
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 875	android/app/DownloadManager$Request:<init>	(Landroid/net/Uri;)V
    //   75: astore_2
    //   76: aload_2
    //   77: getstatic 881	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   80: aload_1
    //   81: invokevirtual 884	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   84: invokevirtual 888	android/app/DownloadManager$Request:setDestinationInExternalPublicDir	(Ljava/lang/String;Ljava/lang/String;)Landroid/app/DownloadManager$Request;
    //   87: pop
    //   88: aload_0
    //   89: getfield 40	com/inmobi/re/controller/JSUtilityController:a	Landroid/app/DownloadManager;
    //   92: aload_2
    //   93: invokevirtual 892	android/app/DownloadManager:enqueue	(Landroid/app/DownloadManager$Request;)J
    //   96: pop2
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 114	com/inmobi/re/controller/JSUtilityController:imWebView	Lcom/inmobi/re/container/IMWebView;
    //   103: ldc_w 894
    //   106: ldc_w 262
    //   109: invokevirtual 342	com/inmobi/re/container/IMWebView:raiseError	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: return
    //   113: astore_1
    //   114: aload_0
    //   115: getfield 114	com/inmobi/re/controller/JSUtilityController:imWebView	Lcom/inmobi/re/container/IMWebView;
    //   118: ldc_w 896
    //   121: ldc_w 262
    //   124: invokevirtual 342	com/inmobi/re/container/IMWebView:raiseError	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  @JavascriptInterface
  public String supportsFeature(String paramString)
  {
    return String.valueOf(c(paramString));
  }
  
  @JavascriptInterface
  public String takeCameraPicture()
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(24), null));
    if (!c("takeCameraPicture")) {
      Log.internal("[InMobi]-[RE]-4.1.1", "takeCameraPicture called even if it is not supported");
    }
    do
    {
      return null;
      Intent localIntent = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
      final Object localObject = new ContentValues();
      localObject = this.mContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject);
      localIntent.putExtra("id", IMBrowserActivity.generateId(new b((Uri)localObject)));
      localIntent.putExtra("URI", (Parcelable)localObject);
      localIntent.putExtra("action", "takeCameraPicture");
      this.imWebView.getActivity().startActivity(localIntent);
    } while (this.imWebView.mListener == null);
    this.imWebView.mListener.onLeaveApplication();
    return null;
  }
  
  @JavascriptInterface
  public void unMuteAudio(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(34), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> unMuteAudio: ");
    this.imWebView.unMuteAudio(paramString);
  }
  
  @JavascriptInterface
  public void unMuteVideo(String paramString)
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(42), null));
    Log.debug("[InMobi]-[RE]-4.1.1", "JSUtilityController-> unMuteVideo: ");
    this.imWebView.unMuteVideo(paramString);
  }
  
  @SuppressLint({"NewApi"})
  public void unRegisterBroadcastListener()
  {
    try
    {
      c();
      if (Build.VERSION.SDK_INT > 8)
      {
        this.imWebView.getActivity().unregisterReceiver((BroadcastReceiver)this.b);
        this.b = null;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "JSUtilityController-> unregisterBroadcastListener. Unable to unregister download listener", localException);
    }
  }
  
  @JavascriptInterface
  public void unRegisterMicListener()
  {
    if (!this.f) {
      return;
    }
    this.f = false;
    AudioTriggerer.removeEventListener(this.e);
  }
  
  @JavascriptInterface
  public void vibrate()
  {
    ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(26), null));
    if (!this.imWebView.isViewable())
    {
      this.imWebView.raiseError("Creative not visible. Will not vibrate.", "vibrate");
      return;
    }
    if (c("vibrate"))
    {
      ((Vibrator)this.imWebView.getActivity().getSystemService("vibrator")).vibrate(2000L);
      new Timer().schedule(new g(), 2000L);
      return;
    }
    Log.internal("[InMobi]-[RE]-4.1.1", "vibrate called even if it is not supported");
  }
  
  class a
    implements StartActivityForResultCallback
  {
    a() {}
    
    public void onActivityResult(int paramInt, Intent paramIntent)
    {
      if (paramInt == -1)
      {
        paramIntent = ImageProcessing.getCompressedBitmap(ImageProcessing.convertMediaUriToPath(paramIntent.getData(), JSUtilityController.this.mContext), JSUtilityController.this.mContext);
        paramInt = paramIntent.getWidth();
        int i = paramIntent.getHeight();
        paramIntent = ImageProcessing.getBase64EncodedImage(paramIntent, JSUtilityController.this.mContext);
        JSUtilityController.this.imWebView.raiseGalleryImageSelectedEvent(paramIntent, paramInt, i);
        return;
      }
      JSUtilityController.this.imWebView.raiseError("User did not select a picture", "getGalleryImage");
    }
  }
  
  class b
    implements StartActivityForResultCallback
  {
    b(Uri paramUri) {}
    
    public void onActivityResult(int paramInt, Intent paramIntent)
    {
      if (paramInt == -1)
      {
        if (paramIntent == null) {}
        for (paramIntent = ImageProcessing.convertMediaUriToPath(localObject, JSUtilityController.this.mContext);; paramIntent = ImageProcessing.convertMediaUriToPath(paramIntent.getData(), JSUtilityController.this.mContext))
        {
          paramIntent = ImageProcessing.getCompressedBitmap(paramIntent, JSUtilityController.this.mContext);
          paramInt = paramIntent.getWidth();
          int i = paramIntent.getHeight();
          paramIntent = ImageProcessing.getBase64EncodedImage(paramIntent, JSUtilityController.this.mContext);
          JSUtilityController.this.imWebView.raiseCameraPictureCapturedEvent(paramIntent, paramInt, i);
          return;
        }
      }
      JSUtilityController.this.imWebView.raiseError("User did not take a picture", "takeCameraPicture");
    }
  }
  
  class c
    implements StartActivityForResultCallback
  {
    c() {}
    
    public void onActivityResult(int paramInt, Intent paramIntent) {}
  }
  
  class d
    extends Thread
  {
    d(String paramString) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: aload_2
      //   5: astore_1
      //   6: aload_0
      //   7: getfield 18	com/inmobi/re/controller/JSUtilityController$d:a	Ljava/lang/String;
      //   10: ldc 27
      //   12: ldc 29
      //   14: invokevirtual 35	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   17: astore 4
      //   19: aload_2
      //   20: astore_1
      //   21: ldc 37
      //   23: new 39	java/lang/StringBuilder
      //   26: dup
      //   27: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   30: ldc 42
      //   32: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   35: aload 4
      //   37: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   43: invokestatic 56	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
      //   46: aload_2
      //   47: astore_1
      //   48: new 58	java/net/URL
      //   51: dup
      //   52: aload 4
      //   54: invokespecial 60	java/net/URL:<init>	(Ljava/lang/String;)V
      //   57: invokevirtual 64	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   60: checkcast 66	java/net/HttpURLConnection
      //   63: astore_2
      //   64: aload_2
      //   65: sipush 20000
      //   68: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   71: aload_2
      //   72: ldc 72
      //   74: invokevirtual 75	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   77: aload_2
      //   78: invokestatic 81	com/inmobi/commons/internal/InternalSDKUtil:addCommonPropertiesToConnection	(Ljava/net/HttpURLConnection;)V
      //   81: ldc 37
      //   83: new 39	java/lang/StringBuilder
      //   86: dup
      //   87: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   90: ldc 83
      //   92: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   95: aload_2
      //   96: invokevirtual 87	java/net/HttpURLConnection:getResponseCode	()I
      //   99: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   102: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   105: invokestatic 56	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
      //   108: aload_2
      //   109: ifnull +7 -> 116
      //   112: aload_2
      //   113: invokevirtual 93	java/net/HttpURLConnection:disconnect	()V
      //   116: return
      //   117: astore_1
      //   118: aload_3
      //   119: astore_2
      //   120: aload_1
      //   121: astore_3
      //   122: aload_2
      //   123: astore_1
      //   124: ldc 37
      //   126: ldc 95
      //   128: aload_3
      //   129: invokestatic 98	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   132: aload_2
      //   133: ifnull -17 -> 116
      //   136: aload_2
      //   137: invokevirtual 93	java/net/HttpURLConnection:disconnect	()V
      //   140: return
      //   141: astore_3
      //   142: aload_1
      //   143: astore_2
      //   144: aload_3
      //   145: astore_1
      //   146: aload_2
      //   147: ifnull +7 -> 154
      //   150: aload_2
      //   151: invokevirtual 93	java/net/HttpURLConnection:disconnect	()V
      //   154: aload_1
      //   155: athrow
      //   156: astore_1
      //   157: goto -11 -> 146
      //   160: astore_3
      //   161: goto -39 -> 122
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	164	0	this	d
      //   5	43	1	localObject1	Object
      //   117	4	1	localException1	Exception
      //   123	32	1	localObject2	Object
      //   156	1	1	localObject3	Object
      //   1	150	2	localObject4	Object
      //   3	126	3	localObject5	Object
      //   141	4	3	localObject6	Object
      //   160	1	3	localException2	Exception
      //   17	36	4	str	String
      // Exception table:
      //   from	to	target	type
      //   6	19	117	java/lang/Exception
      //   21	46	117	java/lang/Exception
      //   48	64	117	java/lang/Exception
      //   6	19	141	finally
      //   21	46	141	finally
      //   48	64	141	finally
      //   124	132	141	finally
      //   64	108	156	finally
      //   64	108	160	java/lang/Exception
    }
  }
  
  class e
    implements StartActivityForResultCallback
  {
    e() {}
    
    public void onActivityResult(int paramInt, Intent paramIntent) {}
  }
  
  class f
    extends BroadcastReceiver
  {
    f() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      if ("android.intent.action.DOWNLOAD_COMPLETE".equals(paramIntent.getAction()))
      {
        long l = paramIntent.getLongExtra("extra_download_id", 0L);
        paramContext = new DownloadManager.Query();
        paramContext.setFilterById(new long[] { l });
        paramContext = JSUtilityController.this.a.query(paramContext);
        if (paramContext.moveToFirst())
        {
          i = paramContext.getColumnIndex("status");
          if (16 != paramContext.getInt(i)) {
            break label99;
          }
          JSUtilityController.this.imWebView.raiseError("download failed", "storePicture");
        }
      }
      label99:
      while (8 != paramContext.getInt(i)) {
        return;
      }
    }
  }
  
  class g
    extends TimerTask
  {
    g() {}
    
    public void run()
    {
      try
      {
        JSUtilityController.this.imWebView.raiseVibrateCompleteEvent();
        return;
      }
      catch (Exception localException)
      {
        Log.internal("[InMobi]-[RE]-4.1.1", "Vibrate callback execption", localException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/controller/JSUtilityController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */