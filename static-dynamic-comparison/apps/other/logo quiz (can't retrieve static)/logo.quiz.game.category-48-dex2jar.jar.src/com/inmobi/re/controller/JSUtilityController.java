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
import com.inmobi.commons.internal.Log;
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
  private AudioTriggerCallback e = new c(this);
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
    new f(paramString).start();
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
    label639:
    Vibrator localVibrator;
    if (paramString.equals("vibrate")) {
      if (((PackageManager)localObject).checkPermission("android.permission.VIBRATE", ((PackageManager)localObject).getNameForUid(Binder.getCallingUid())) == 0)
      {
        bool1 = true;
        localObject = Boolean.valueOf(bool1);
        localVibrator = (Vibrator)this.c.imWebView.getActivity().getSystemService("vibrator");
        if (localVibrator != null) {
          break label701;
        }
        localObject = Boolean.valueOf(false);
      }
    }
    for (;;)
    {
      this.d.put(paramString, localObject);
      return ((Boolean)localObject).booleanValue();
      bool1 = false;
      break label639;
      label701:
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
    try
    {
      Log.debug("IMRE_3.7.1", "JSUtilityController-> asyncPing: url: " + paramString);
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
    Log.debug("IMRE_3.7.1", "JSUtilityController-> closeVideo: id :" + paramString);
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
    Log.debug("IMRE_3.7.1", "JSUtilityController-> createEvent: date: " + paramString1 + " location: " + paramString3 + " body: " + paramString4);
    if (!c("calendar")) {
      Log.internal("IMRE_3.7.1", "createCalendarEvent called even if it is not supported");
    }
    for (;;)
    {
      return;
      try
      {
        paramString1 = convertDateString(paramString1);
        paramString2 = convertDateString(paramString2);
        Intent localIntent = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
        localIntent.putExtra("id", IMBrowserActivity.generateId(new a()));
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
        Log.debug("IMRE_3.7.1", "exception" + paramString1.getMessage());
        this.imWebView.raiseError("Date format is incorrect", "createCalendarEvent");
      }
    }
  }
  
  @JavascriptInterface
  public int getAudioVolume(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> getAudioVolume: ");
    return this.imWebView.getAudioVolume(paramString);
  }
  
  @JavascriptInterface
  public String getCurrentPosition()
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> getCurrentPosition");
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
            Log.debug("IMRE_3.7.1", "mutexcPos failed ", localInterruptedException);
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
    Log.debug("IMRE_3.7.1", "JSUtilityController-> getDefaultPosition");
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
            Log.debug("IMRE_3.7.1", "mutexdPos failed ", localInterruptedException);
          }
        }
      }
    }
    this.imWebView.acqMutexdPos.set(true);
    Log.debug("IMRE_3.7.1", "mutexdPassed" + this.imWebView.defPosition);
    return this.imWebView.defPosition.toString();
  }
  
  @JavascriptInterface
  public String getGalleryImage()
  {
    if (!c("getGalleryImage")) {
      Log.internal("IMRE_3.7.1", "getGalleryImage called even if it is not supported");
    }
    do
    {
      return null;
      Intent localIntent = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
      localIntent.putExtra("id", IMBrowserActivity.generateId(new c()));
      localIntent.putExtra("action", "getGalleryImage");
      this.imWebView.getActivity().startActivity(localIntent);
    } while (this.imWebView.mListener == null);
    this.imWebView.mListener.onLeaveApplication();
    return null;
  }
  
  @JavascriptInterface
  public String getMaxSize()
  {
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
    return this.imWebView.getLastGoodKnownMicValue();
  }
  
  @JavascriptInterface
  public String getScreenSize()
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> getScreenSize");
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
        Log.debug("IMRE_3.7.1", "Failed to get screen size");
      }
    }
  }
  
  @JavascriptInterface
  public int getVideoVolume(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> getVideoVolume: ");
    return this.imWebView.getVideoVolume(paramString);
  }
  
  @JavascriptInterface
  public void hideVideo(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> hideVideo: id :" + paramString);
    this.imWebView.hideVideo(paramString);
  }
  
  @JavascriptInterface
  public boolean isAudioMuted(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> isAudioMuted: ");
    return this.imWebView.isAudioMuted(paramString);
  }
  
  @JavascriptInterface
  public boolean isVideoMuted(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> isVideoMuted: ");
    return this.imWebView.isVideoMuted(paramString);
  }
  
  @JavascriptInterface
  public void log(String paramString)
  {
    Log.debug("IMRE_3.7.1", "Ad Log Message: " + paramString);
  }
  
  @JavascriptInterface
  public void makeCall(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> makeCall: number: " + paramString);
    try
    {
      if (this.mContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == -1)
      {
        Log.debug("IMRE_3.7.1", "No permission to make call");
        this.imWebView.raiseError("No Permisson to make call", "makeCall");
        return;
      }
      paramString = a(paramString);
      if (paramString == null)
      {
        this.imWebView.raiseError("Bad Phone Number", "makeCall");
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.debug("IMRE_3.7.1", "Exception in making call ", paramString);
      this.imWebView.raiseError("Exception in making call", "makeCall");
      return;
    }
    paramString = new Intent("android.intent.action.CALL", Uri.parse(paramString.toString()));
    paramString.addFlags(268435456);
    this.imWebView.getActivity().startActivity(paramString);
    this.imWebView.fireOnLeaveApplication();
  }
  
  @JavascriptInterface
  public void muteAudio(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> muteAudio: ");
    this.imWebView.muteAudio(paramString);
  }
  
  @JavascriptInterface
  public void muteVideo(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> muteVideo: ");
    this.imWebView.muteVideo(paramString);
  }
  
  @JavascriptInterface
  public void openExternal(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> openExternal: url: " + paramString);
    this.imWebView.openExternal(paramString);
  }
  
  @JavascriptInterface
  public void pauseAudio(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> pauseAudio: id :" + paramString);
    this.imWebView.pauseAudio(paramString);
  }
  
  @JavascriptInterface
  public void pauseVideo(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> pauseVideo: id :" + paramString);
    this.imWebView.pauseVideo(paramString);
  }
  
  @JavascriptInterface
  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4)
  {
    Log.debug("IMRE_3.7.1", "playAudio: url: " + paramString1 + " autoPlay: " + paramBoolean1 + " controls: " + paramBoolean2 + " loop: " + paramBoolean3 + " startStyle: " + paramString2 + " stopStyle: " + paramString3 + " id:" + paramString4);
    this.imWebView.playAudio(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramString2, paramString3, paramString4);
  }
  
  @JavascriptInterface
  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> playVideo: url: " + paramString1 + " audioMuted: " + paramBoolean1 + " autoPlay: " + paramBoolean2 + " controls: " + paramBoolean3 + " loop: " + paramBoolean4 + " x: " + paramString2 + " y: " + paramString3 + " width: " + paramString4 + " height: " + paramString5 + " startStyle: " + paramString6 + " stopStyle: " + paramString7 + " id:" + paramString8);
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
      paramString3.putExtra("id", IMBrowserActivity.generateId(new e()));
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
      this.b = new b();
      this.imWebView.getActivity().registerReceiver((BroadcastReceiver)this.b, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
      return;
    }
    catch (Exception localException)
    {
      Log.internal("IMRE_3.7.1", "JSUtilityController-> registerBroadcastListener. Unable to register download listener", localException);
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
    Log.debug("IMRE_3.7.1", "JSUtilityController-> seekAudio: ");
    this.imWebView.seekAudio(paramString, paramInt);
  }
  
  @JavascriptInterface
  public void seekVideo(String paramString, int paramInt)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> seekVideo: ");
    this.imWebView.seekVideo(paramString, paramInt);
  }
  
  @JavascriptInterface
  public void sendMail(String paramString1, String paramString2, String paramString3)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> sendMail: recipient: " + paramString1 + " subject: " + paramString2 + " body: " + paramString3);
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
      Log.debug("IMRE_3.7.1", "Exception in sending mail ", paramString1);
      this.imWebView.raiseError("Exception in sending mail", "sendMail");
    }
  }
  
  @JavascriptInterface
  public void sendSMS(String paramString1, String paramString2)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> sendSMS: recipient: " + paramString1 + " body: " + paramString2);
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
      Log.debug("IMRE_3.7.1", "Exception in sending SMS ", paramString1);
      this.imWebView.raiseError("Exception in sending SMS", "sendSMS");
    }
  }
  
  @JavascriptInterface
  public void setAudioVolume(String paramString, int paramInt)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> setAudioVolume: " + paramString + " " + paramInt);
    this.imWebView.setAudioVolume(paramString, paramInt);
  }
  
  @JavascriptInterface
  public void setVideoVolume(String paramString, int paramInt)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> setVideoVolume: ");
    this.imWebView.setVideoVolume(paramString, paramInt);
  }
  
  @JavascriptInterface
  public void showAlert(String paramString)
  {
    Log.debug("IMRE_3.7.1", paramString);
  }
  
  @JavascriptInterface
  public void showVideo(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> showVideo: id :" + paramString);
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
    //   0: ldc_w 300
    //   3: new 96	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 829
    //   13: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 309	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_1
    //   27: invokestatic 834	com/inmobi/commons/internal/InternalSDKUtil:getFinalRedirectedUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokestatic 609	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   33: astore_1
    //   34: aload_0
    //   35: ldc -16
    //   37: invokespecial 369	com/inmobi/re/controller/JSUtilityController:c	(Ljava/lang/String;)Z
    //   40: ifeq +33 -> 73
    //   43: new 836	android/app/DownloadManager$Request
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 839	android/app/DownloadManager$Request:<init>	(Landroid/net/Uri;)V
    //   51: astore_2
    //   52: aload_2
    //   53: getstatic 845	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 848	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   60: invokevirtual 852	android/app/DownloadManager$Request:setDestinationInExternalPublicDir	(Ljava/lang/String;Ljava/lang/String;)Landroid/app/DownloadManager$Request;
    //   63: pop
    //   64: aload_0
    //   65: getfield 40	com/inmobi/re/controller/JSUtilityController:a	Landroid/app/DownloadManager;
    //   68: aload_2
    //   69: invokevirtual 856	android/app/DownloadManager:enqueue	(Landroid/app/DownloadManager$Request;)J
    //   72: pop2
    //   73: return
    //   74: astore_1
    //   75: aload_0
    //   76: getfield 114	com/inmobi/re/controller/JSUtilityController:imWebView	Lcom/inmobi/re/container/IMWebView;
    //   79: ldc_w 858
    //   82: ldc -16
    //   84: invokevirtual 320	com/inmobi/re/container/IMWebView:raiseError	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: return
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 114	com/inmobi/re/controller/JSUtilityController:imWebView	Lcom/inmobi/re/container/IMWebView;
    //   93: ldc_w 860
    //   96: ldc -16
    //   98: invokevirtual 320	com/inmobi/re/container/IMWebView:raiseError	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	JSUtilityController
    //   0	102	1	paramString	String
    //   51	18	2	localRequest	android.app.DownloadManager.Request
    // Exception table:
    //   from	to	target	type
    //   26	34	74	java/lang/Exception
    //   43	73	88	java/lang/Exception
  }
  
  @JavascriptInterface
  public String supportsFeature(String paramString)
  {
    return String.valueOf(c(paramString));
  }
  
  @JavascriptInterface
  public String takeCameraPicture()
  {
    if (!c("takeCameraPicture")) {
      Log.internal("IMRE_3.7.1", "takeCameraPicture called even if it is not supported");
    }
    do
    {
      return null;
      Intent localIntent = new Intent(this.imWebView.getActivity(), IMBrowserActivity.class);
      final Object localObject = new ContentValues();
      localObject = this.mContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject);
      localIntent.putExtra("id", IMBrowserActivity.generateId(new d((Uri)localObject)));
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
    Log.debug("IMRE_3.7.1", "JSUtilityController-> unMuteAudio: ");
    this.imWebView.unMuteAudio(paramString);
  }
  
  @JavascriptInterface
  public void unMuteVideo(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSUtilityController-> unMuteVideo: ");
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
      Log.internal("IMRE_3.7.1", "JSUtilityController-> unregisterBroadcastListener. Unable to unregister download listener", localException);
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
    Log.internal("IMRE_3.7.1", "vibrate called even if it is not supported");
  }
  
  class a
    implements StartActivityForResultCallback
  {
    a() {}
    
    public void onActivityResult(int paramInt, Intent paramIntent) {}
  }
  
  class b
    extends BroadcastReceiver
  {
    b() {}
    
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
  
  class c
    implements StartActivityForResultCallback
  {
    c() {}
    
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
  
  class d
    implements StartActivityForResultCallback
  {
    d(Uri paramUri) {}
    
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
  
  class e
    implements StartActivityForResultCallback
  {
    e() {}
    
    public void onActivityResult(int paramInt, Intent paramIntent) {}
  }
  
  class f
    extends Thread
  {
    f(String paramString) {}
    
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
      //   7: getfield 18	com/inmobi/re/controller/JSUtilityController$f:a	Ljava/lang/String;
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
      //   77: aload_0
      //   78: getfield 16	com/inmobi/re/controller/JSUtilityController$f:b	Lcom/inmobi/re/controller/JSUtilityController;
      //   81: getfield 79	com/inmobi/re/controller/JSUtilityController:imWebView	Lcom/inmobi/re/container/IMWebView;
      //   84: getfield 84	com/inmobi/re/container/IMWebView:webviewUserAgent	Ljava/lang/String;
      //   87: astore_1
      //   88: aload_1
      //   89: ifnull +10 -> 99
      //   92: aload_2
      //   93: ldc 86
      //   95: aload_1
      //   96: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   99: ldc 37
      //   101: new 39	java/lang/StringBuilder
      //   104: dup
      //   105: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   108: ldc 91
      //   110: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   113: aload_2
      //   114: invokevirtual 95	java/net/HttpURLConnection:getResponseCode	()I
      //   117: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   120: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   123: invokestatic 56	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
      //   126: aload_2
      //   127: ifnull +7 -> 134
      //   130: aload_2
      //   131: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
      //   134: return
      //   135: astore_1
      //   136: aload_3
      //   137: astore_2
      //   138: aload_1
      //   139: astore_3
      //   140: aload_2
      //   141: astore_1
      //   142: ldc 37
      //   144: ldc 103
      //   146: aload_3
      //   147: invokestatic 106	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   150: aload_2
      //   151: ifnull -17 -> 134
      //   154: aload_2
      //   155: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
      //   158: return
      //   159: astore_3
      //   160: aload_1
      //   161: astore_2
      //   162: aload_3
      //   163: astore_1
      //   164: aload_2
      //   165: ifnull +7 -> 172
      //   168: aload_2
      //   169: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
      //   172: aload_1
      //   173: athrow
      //   174: astore_1
      //   175: goto -11 -> 164
      //   178: astore_3
      //   179: goto -39 -> 140
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	182	0	this	f
      //   5	91	1	localObject1	Object
      //   135	4	1	localException1	Exception
      //   141	32	1	localObject2	Object
      //   174	1	1	localObject3	Object
      //   1	168	2	localObject4	Object
      //   3	144	3	localObject5	Object
      //   159	4	3	localObject6	Object
      //   178	1	3	localException2	Exception
      //   17	36	4	str	String
      // Exception table:
      //   from	to	target	type
      //   6	19	135	java/lang/Exception
      //   21	46	135	java/lang/Exception
      //   48	64	135	java/lang/Exception
      //   6	19	159	finally
      //   21	46	159	finally
      //   48	64	159	finally
      //   142	150	159	finally
      //   64	88	174	finally
      //   92	99	174	finally
      //   99	126	174	finally
      //   64	88	178	java/lang/Exception
      //   92	99	178	java/lang/Exception
      //   99	126	178	java/lang/Exception
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
        Log.internal("IMRE_3.7.1", "Vibrate callback execption", localException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/controller/JSUtilityController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */