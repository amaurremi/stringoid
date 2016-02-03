package com.tapjoy.mraid.controller;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import android.util.Log;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.view.MraidView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
public class Utility
  extends Abstract
{
  private static final String TAG = "MRAID Utility";
  private Assets mAssetController;
  private Display mDisplayController;
  private MraidLocation mLocationController;
  private Network mNetworkController;
  private MraidSensor mSensorController;
  
  public Utility(MraidView paramMraidView, Context paramContext)
  {
    super(paramMraidView, paramContext);
    this.mAssetController = new Assets(paramMraidView, paramContext);
    this.mDisplayController = new Display(paramMraidView, paramContext);
    this.mLocationController = new MraidLocation(paramMraidView, paramContext);
    this.mNetworkController = new Network(paramMraidView, paramContext);
    this.mSensorController = new MraidSensor(paramMraidView, paramContext);
    paramMraidView.addJavascriptInterface(this.mAssetController, "MRAIDAssetsControllerBridge");
    paramMraidView.addJavascriptInterface(this.mDisplayController, "MRAIDDisplayControllerBridge");
    paramMraidView.addJavascriptInterface(this.mLocationController, "MRAIDLocationControllerBridge");
    paramMraidView.addJavascriptInterface(this.mNetworkController, "MRAIDNetworkControllerBridge");
    paramMraidView.addJavascriptInterface(this.mSensorController, "MRAIDSensorControllerBridge");
  }
  
  private void addCalendarEvent(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ContentResolver localContentResolver = this.mContext.getContentResolver();
    long l = Long.parseLong(paramString1);
    paramString1 = new ContentValues();
    paramString1.put("calendar_id", Integer.valueOf(paramInt));
    paramString1.put("title", paramString2);
    paramString1.put("description", paramString3);
    paramString1.put("dtstart", Long.valueOf(l));
    paramString1.put("hasAlarm", Integer.valueOf(1));
    paramString1.put("dtend", Long.valueOf(l + 3600000L));
    if (Integer.parseInt(Build.VERSION.SDK) == 8)
    {
      paramString1 = localContentResolver.insert(Uri.parse("content://com.android.calendar/events"), paramString1);
      if (paramString1 != null)
      {
        l = Long.parseLong(paramString1.getLastPathSegment());
        paramString1 = new ContentValues();
        paramString1.put("event_id", Long.valueOf(l));
        paramString1.put("method", Integer.valueOf(1));
        paramString1.put("minutes", Integer.valueOf(15));
        if (Integer.parseInt(Build.VERSION.SDK) != 8) {
          break label212;
        }
        localContentResolver.insert(Uri.parse("content://com.android.calendar/reminders"), paramString1);
      }
    }
    for (;;)
    {
      Toast.makeText(this.mContext, "Event added to calendar", 0).show();
      return;
      paramString1 = localContentResolver.insert(Uri.parse("content://calendar/events"), paramString1);
      break;
      label212:
      localContentResolver.insert(Uri.parse("content://calendar/reminders"), paramString1);
    }
  }
  
  private String createTelUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("tel:");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private String getSupports()
  {
    Object localObject2 = "supports: [ 'level-1', 'level-2', 'screen', 'orientation', 'network'";
    label78:
    Object localObject1;
    if ((this.mLocationController.allowLocationServices()) && ((this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) || (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)))
    {
      i = 1;
      if (i != 0) {
        localObject2 = "supports: [ 'level-1', 'level-2', 'screen', 'orientation', 'network'" + ", 'location'";
      }
      if (this.mContext.checkCallingOrSelfPermission("android.permission.SEND_SMS") != 0) {
        break label315;
      }
      i = 1;
      localObject1 = localObject2;
      if (i != 0) {
        localObject1 = (String)localObject2 + ", 'sms'";
      }
      if (this.mContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") != 0) {
        break label320;
      }
      i = 1;
      label118:
      localObject2 = localObject1;
      if (i != 0) {
        localObject2 = (String)localObject1 + ", 'phone'";
      }
      if ((this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") != 0) || (this.mContext.checkCallingOrSelfPermission("android.permission.READ_CALENDAR") != 0) || (Build.VERSION.SDK_INT < 14)) {
        break label325;
      }
    }
    label315:
    label320:
    label325:
    for (int i = 1;; i = 0)
    {
      localObject1 = localObject2;
      if (i != 0) {
        localObject1 = (String)localObject2 + ", 'calendar'";
      }
      localObject1 = (String)localObject1 + ", 'video'";
      localObject1 = (String)localObject1 + ", 'audio'";
      localObject1 = (String)localObject1 + ", 'map'";
      localObject1 = (String)localObject1 + ", 'email' ]";
      TapjoyLog.d("MRAID Utility", "getSupports: " + (String)localObject1);
      return (String)localObject1;
      i = 0;
      break;
      i = 0;
      break label78;
      i = 0;
      break label118;
    }
  }
  
  public void activate(String paramString)
  {
    TapjoyLog.d("MRAID Utility", "activate: " + paramString);
    if (paramString.equalsIgnoreCase("networkChange")) {
      this.mNetworkController.startNetworkListener();
    }
    do
    {
      return;
      if ((this.mLocationController.allowLocationServices()) && (paramString.equalsIgnoreCase("locationChange")))
      {
        this.mLocationController.startLocationListener();
        return;
      }
      if (paramString.equalsIgnoreCase("shake"))
      {
        this.mSensorController.startShakeListener();
        return;
      }
      if (paramString.equalsIgnoreCase("tiltChange"))
      {
        this.mSensorController.startTiltListener();
        return;
      }
      if (paramString.equalsIgnoreCase("headingChange"))
      {
        this.mSensorController.startHeadingListener();
        return;
      }
    } while (!paramString.equalsIgnoreCase("orientationChange"));
    this.mDisplayController.startConfigurationListener();
  }
  
  public String copyTextFromJarIntoAssetDir(String paramString1, String paramString2)
  {
    return this.mAssetController.copyTextFromJarIntoAssetDir(paramString1, paramString2);
  }
  
  public String copyTextFromJarIntoString(String paramString)
  {
    return this.mAssetController.copyTextFromJarIntoString(paramString);
  }
  
  public void createEvent(final String paramString1, final String paramString2, final String paramString3)
  {
    TapjoyLog.d("MRAID Utility", "createEvent: date: " + paramString1 + " title: " + paramString2 + " body: " + paramString3);
    Object localObject1 = this.mContext.getContentResolver();
    final Object localObject2 = new String[3];
    localObject2[0] = "_id";
    localObject2[1] = "displayName";
    localObject2[2] = "_sync_account";
    if (Integer.parseInt(Build.VERSION.SDK) == 8) {}
    for (localObject1 = ((ContentResolver)localObject1).query(Uri.parse("content://com.android.calendar/calendars"), (String[])localObject2, null, null, null); (localObject1 == null) || ((localObject1 != null) && (!((Cursor)localObject1).moveToFirst())); localObject1 = ((ContentResolver)localObject1).query(Uri.parse("content://calendar/calendars"), (String[])localObject2, null, null, null))
    {
      Toast.makeText(this.mContext, "No calendar account found", 1).show();
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      return;
    }
    if (((Cursor)localObject1).getCount() == 1) {
      addCalendarEvent(((Cursor)localObject1).getInt(0), paramString1, paramString2, paramString3);
    }
    for (;;)
    {
      ((Cursor)localObject1).close();
      return;
      localObject2 = new ArrayList();
      int i = 0;
      while (i < ((Cursor)localObject1).getCount())
      {
        localObject3 = new HashMap();
        ((Map)localObject3).put("ID", ((Cursor)localObject1).getString(0));
        ((Map)localObject3).put("NAME", ((Cursor)localObject1).getString(1));
        ((Map)localObject3).put("EMAILID", ((Cursor)localObject1).getString(2));
        ((List)localObject2).add(localObject3);
        ((Cursor)localObject1).moveToNext();
        i += 1;
      }
      Object localObject3 = new AlertDialog.Builder(this.mContext);
      ((AlertDialog.Builder)localObject3).setTitle("Choose Calendar to save event to");
      ((AlertDialog.Builder)localObject3).setSingleChoiceItems(new SimpleAdapter(this.mContext, (List)localObject2, 17367053, new String[] { "NAME", "EMAILID" }, new int[] { 16908308, 16908309 }), -1, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Map localMap = (Map)localObject2.get(paramAnonymousInt);
          Utility.this.addCalendarEvent(Integer.parseInt((String)localMap.get("ID")), paramString1, paramString2, paramString3);
          paramAnonymousDialogInterface.cancel();
        }
      });
      ((AlertDialog.Builder)localObject3).create().show();
    }
  }
  
  public void deactivate(String paramString)
  {
    TapjoyLog.d("MRAID Utility", "deactivate: " + paramString);
    if (paramString.equalsIgnoreCase("networkChange")) {
      this.mNetworkController.stopNetworkListener();
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("locationChange"))
      {
        this.mLocationController.stopAllListeners();
        return;
      }
      if (paramString.equalsIgnoreCase("shake"))
      {
        this.mSensorController.stopShakeListener();
        return;
      }
      if (paramString.equalsIgnoreCase("tiltChange"))
      {
        this.mSensorController.stopTiltListener();
        return;
      }
      if (paramString.equalsIgnoreCase("headingChange"))
      {
        this.mSensorController.stopHeadingListener();
        return;
      }
    } while (!paramString.equalsIgnoreCase("orientationChange"));
    this.mDisplayController.stopConfigurationListener();
  }
  
  public void deleteOldAds()
  {
    this.mAssetController.deleteOldAds();
  }
  
  public void init(float paramFloat)
  {
    String str = "window.mraidview.fireChangeEvent({ state: 'default', network: '" + this.mNetworkController.getNetwork() + "'," + " size: " + this.mDisplayController.getSize() + "," + " placement: " + "'" + this.mMraidView.getPlacementType() + "'," + " maxSize: " + this.mDisplayController.getMaxSize() + ",expandProperties: " + this.mDisplayController.getMaxSize() + "," + " screenSize: " + this.mDisplayController.getScreenSize() + "," + " defaultPosition: { x:" + (int)(this.mMraidView.getLeft() / paramFloat) + ", y: " + (int)(this.mMraidView.getTop() / paramFloat) + ", width: " + (int)(this.mMraidView.getWidth() / paramFloat) + ", height: " + (int)(this.mMraidView.getHeight() / paramFloat) + " }," + " orientation:" + this.mDisplayController.getOrientation() + "," + getSupports() + ",viewable:true });";
    Log.d("MRAID Utility", "init: injection: " + str);
    this.mMraidView.injectMraidJavaScript(str);
    ready();
  }
  
  public void makeCall(String paramString)
  {
    TapjoyLog.d("MRAID Utility", "makeCall: number: " + paramString);
    paramString = createTelUrl(paramString);
    if (paramString == null)
    {
      this.mMraidView.raiseError("Bad Phone Number", "makeCall");
      return;
    }
    paramString = new Intent("android.intent.action.CALL", Uri.parse(paramString.toString()));
    paramString.addFlags(268435456);
    this.mContext.startActivity(paramString);
  }
  
  public void mraidCreateEvent(String paramString)
  {
    Object localObject3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    if (Build.VERSION.SDK_INT < 14) {
      return;
    }
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localObject1 = localObject3;
    String str3 = str4;
    String str2 = str6;
    String str1 = str5;
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localObject1 = localObject3;
      str3 = str4;
      str2 = str6;
      str1 = str5;
      JSONObject localJSONObject1 = localJSONObject2.getJSONObject("start");
      localObject1 = localObject3;
      str3 = str4;
      str2 = str6;
      str1 = str5;
      paramString = localJSONObject2.optJSONObject("end");
      Object localObject2 = paramString;
      if (paramString == null) {
        localObject2 = localJSONObject1;
      }
      localObject1 = localObject3;
      str3 = str4;
      str2 = str6;
      str1 = str5;
      paramString = localJSONObject2.getString("description");
      localObject1 = paramString;
      str3 = str4;
      str2 = str6;
      str1 = str5;
      str4 = localJSONObject2.optString("location");
      localObject1 = paramString;
      str3 = str4;
      str2 = str6;
      str1 = str5;
      str5 = localJSONObject2.optString("summary");
      localObject1 = paramString;
      str3 = str4;
      str2 = str6;
      str1 = str5;
      str6 = localJSONObject2.optString("status");
      localObject1 = paramString;
      str3 = str4;
      str2 = str6;
      str1 = str5;
      localCalendar1.set(localJSONObject1.getInt("year"), localJSONObject1.getInt("month"), localJSONObject1.getInt("day"), localJSONObject1.getInt("hour"), localJSONObject1.getInt("min"));
      localObject1 = paramString;
      str3 = str4;
      str2 = str6;
      str1 = str5;
      localCalendar2.set(((JSONObject)localObject2).getInt("year"), ((JSONObject)localObject2).getInt("month"), ((JSONObject)localObject2).getInt("day"), ((JSONObject)localObject2).getInt("hour"), ((JSONObject)localObject2).getInt("min"));
      str1 = str5;
      str2 = str6;
      str3 = str4;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject1;
      }
    }
    paramString = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("beginTime", localCalendar1.getTimeInMillis()).putExtra("endTime", localCalendar2.getTimeInMillis()).putExtra("title", str1).putExtra("description", paramString).putExtra("eventLocation", str3).putExtra("eventStatus", str2);
    this.mMraidView.getContext().startActivity(paramString);
  }
  
  public void ready()
  {
    this.mMraidView.injectMraidJavaScript("mraid.setState(\"" + this.mMraidView.getState() + "\");");
    this.mMraidView.injectMraidJavaScript("mraidview.fireReadyEvent();");
  }
  
  public void sendMail(String paramString1, String paramString2, String paramString3)
  {
    TapjoyLog.d("MRAID Utility", "sendMail: recipient: " + paramString1 + " subject: " + paramString2 + " body: " + paramString3);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("plain/text");
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString1 });
    localIntent.putExtra("android.intent.extra.SUBJECT", paramString2);
    localIntent.putExtra("android.intent.extra.TEXT", paramString3);
    localIntent.addFlags(268435456);
    this.mContext.startActivity(localIntent);
  }
  
  public void sendSMS(String paramString1, String paramString2)
  {
    TapjoyLog.d("MRAID Utility", "sendSMS: recipient: " + paramString1 + " body: " + paramString2);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.putExtra("address", paramString1);
    localIntent.putExtra("sms_body", paramString2);
    localIntent.setType("vnd.android-dir/mms-sms");
    localIntent.addFlags(268435456);
    this.mContext.startActivity(localIntent);
  }
  
  public void setMaxSize(int paramInt1, int paramInt2)
  {
    this.mDisplayController.setMaxSize(paramInt1, paramInt2);
  }
  
  public void showAlert(String paramString)
  {
    TapjoyLog.e("MRAID Utility", paramString);
  }
  
  public void stopAllListeners()
  {
    try
    {
      this.mAssetController.stopAllListeners();
      this.mDisplayController.stopAllListeners();
      this.mLocationController.stopAllListeners();
      this.mNetworkController.stopAllListeners();
      this.mSensorController.stopAllListeners();
      return;
    }
    catch (Exception localException) {}
  }
  
  public String writeToDiskWrap(InputStream paramInputStream, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
    throws IllegalStateException, IOException
  {
    return this.mAssetController.writeToDiskWrap(paramInputStream, paramString1, paramBoolean, paramString2, paramString3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/controller/Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */