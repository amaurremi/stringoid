package com.jtpgodorncrqoeurl;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdUtilityController
  extends AdController
{
  private AdAssetController c;
  private AdDisplayController d;
  private AdLocationController e;
  private AdNetworkController f;
  private AdSensorController g;
  
  public AdUtilityController(AdView paramAdView, Context paramContext)
  {
    super(paramAdView, paramContext);
    this.c = new AdAssetController(paramAdView, paramContext);
    this.d = new AdDisplayController(paramAdView, paramContext);
    this.e = new AdLocationController(paramAdView, paramContext);
    this.f = new AdNetworkController(paramAdView, paramContext);
    this.g = new AdSensorController(paramAdView, paramContext);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ContentResolver localContentResolver = this.a.getContentResolver();
    long l = Long.parseLong(paramString1);
    paramString1 = new ContentValues();
    paramString1.put("calendar_id", Integer.valueOf(paramInt));
    paramString1.put("title", paramString2);
    paramString1.put("description", paramString3);
    paramString1.put("dtstart", Long.valueOf(l));
    paramString1.put("hasAlarm", Integer.valueOf(1));
    paramString1.put("dtend", Long.valueOf(3600000L + l));
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
      Toast.makeText(this.a, "Event added to calendar", 0).show();
      return;
      paramString1 = localContentResolver.insert(Uri.parse("content://calendar/events"), paramString1);
      break;
      label212:
      localContentResolver.insert(Uri.parse("content://calendar/reminders"), paramString1);
    }
  }
  
  public void activate(String paramString)
  {
    Log.d("AdUtilityController", "activate: " + paramString);
    if (paramString.equalsIgnoreCase("networkChange")) {
      this.f.startNetworkListener();
    }
    for (;;)
    {
      if (paramString.equals("ready")) {
        this.b.injectJavaScript("broadcastEvent(\"ready\");");
      }
      return;
      if ((this.e.allowLocationServices()) && (paramString.equalsIgnoreCase("locationChange"))) {
        this.e.startLocationListener();
      } else if (paramString.equalsIgnoreCase("shake")) {
        this.g.startShakeListener();
      } else if (paramString.equalsIgnoreCase("tiltChange")) {
        this.g.startTiltListener();
      } else if (paramString.equalsIgnoreCase("headingChange")) {
        this.g.startHeadingListener();
      } else if (paramString.equalsIgnoreCase("orientationChange")) {
        this.d.startConfigurationListener();
      }
    }
  }
  
  public String copyTextFromJarIntoAssetDir(String paramString1, String paramString2)
  {
    return this.c.copyTextFromJarIntoAssetDir(paramString1, paramString2);
  }
  
  public void createEvent(String paramString1, String paramString2, String paramString3)
  {
    Log.d("AdUtilityController", "createEvent: date: " + paramString1 + " title: " + paramString2 + " body: " + paramString3);
    Object localObject1 = this.a.getContentResolver();
    Object localObject2 = new String[3];
    localObject2[0] = "_id";
    localObject2[1] = "displayName";
    localObject2[2] = "_sync_account";
    if (Integer.parseInt(Build.VERSION.SDK) == 8) {}
    for (localObject1 = ((ContentResolver)localObject1).query(Uri.parse("content://com.android.calendar/calendars"), (String[])localObject2, null, null, null); (localObject1 == null) || ((localObject1 != null) && (!((Cursor)localObject1).moveToFirst())); localObject1 = ((ContentResolver)localObject1).query(Uri.parse("content://calendar/calendars"), (String[])localObject2, null, null, null))
    {
      Toast.makeText(this.a, "No calendar account found", 1).show();
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      return;
    }
    if (((Cursor)localObject1).getCount() == 1) {
      a(((Cursor)localObject1).getInt(0), paramString1, paramString2, paramString3);
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
      Object localObject3 = new AlertDialog.Builder(this.a);
      ((AlertDialog.Builder)localObject3).setTitle("Choose Calendar to save event to");
      ((AlertDialog.Builder)localObject3).setSingleChoiceItems(new SimpleAdapter(this.a, (List)localObject2, 17367053, new String[] { "NAME", "EMAILID" }, new int[] { 16908308, 16908309 }), -1, new M(this, (List)localObject2, paramString1, paramString2, paramString3));
      ((AlertDialog.Builder)localObject3).create().show();
    }
  }
  
  public void deactivate(String paramString)
  {
    Log.d("AdUtilityController", "deactivate: " + paramString);
    if (paramString.equalsIgnoreCase("networkChange")) {
      this.f.stopNetworkListener();
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("locationChange"))
      {
        this.e.stopAllListeners();
        return;
      }
      if (paramString.equalsIgnoreCase("shake"))
      {
        this.g.stopShakeListener();
        return;
      }
      if (paramString.equalsIgnoreCase("tiltChange"))
      {
        this.g.stopTiltListener();
        return;
      }
      if (paramString.equalsIgnoreCase("headingChange"))
      {
        this.g.stopHeadingListener();
        return;
      }
    } while (!paramString.equalsIgnoreCase("orientationChange"));
    this.d.stopConfigurationListener();
  }
  
  public void deleteOldAds()
  {
    this.c.deleteOldAds();
  }
  
  public void init(float paramFloat)
  {
    int j = 1;
    StringBuilder localStringBuilder = new StringBuilder("window.ormmaview.fireChangeEvent({ state: 'default', network: '").append(this.f.getNetwork()).append("', size: ").append(this.d.getSize()).append(", maxSize: ").append(this.d.getMaxSize()).append(", screenSize: ").append(this.d.getScreenSize()).append(", defaultPosition: { x:").append((int)(this.b.getLeft() / paramFloat)).append(", y: ").append((int)(this.b.getTop() / paramFloat)).append(", width: ").append((int)(this.b.getWidth() / paramFloat)).append(", height: ").append((int)(this.b.getHeight() / paramFloat)).append(" }, orientation:").append(this.d.getOrientation()).append(",");
    Object localObject2 = "supports: [ 'level-1', 'level-2', 'screen', 'orientation', 'network'";
    label260:
    Object localObject1;
    if ((this.e.allowLocationServices()) && ((this.a.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) || (this.a.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)))
    {
      i = 1;
      if (i != 0) {
        localObject2 = "supports: [ 'level-1', 'level-2', 'screen', 'orientation', 'network'" + ", 'location'";
      }
      if (this.a.checkCallingOrSelfPermission("android.permission.SEND_SMS") != 0) {
        break label573;
      }
      i = 1;
      localObject1 = localObject2;
      if (i != 0) {
        localObject1 = (String)localObject2 + ", 'sms'";
      }
      if (this.a.checkCallingOrSelfPermission("android.permission.CALL_PHONE") != 0) {
        break label578;
      }
      i = 1;
      label306:
      localObject2 = localObject1;
      if (i != 0) {
        localObject2 = (String)localObject1 + ", 'phone'";
      }
      if ((this.a.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") != 0) || (this.a.checkCallingOrSelfPermission("android.permission.READ_CALENDAR") != 0)) {
        break label583;
      }
    }
    label573:
    label578:
    label583:
    for (int i = j;; i = 0)
    {
      localObject1 = localObject2;
      if (i != 0) {
        localObject1 = (String)localObject2 + ", 'calendar'";
      }
      localObject1 = (String)localObject1 + ", 'video'";
      localObject1 = (String)localObject1 + ", 'audio'";
      localObject1 = (String)localObject1 + ", 'map'";
      localObject1 = (String)localObject1 + ", 'email' ]";
      Log.d("AdUtilityController", "getSupports: " + (String)localObject1);
      localObject1 = (String)localObject1 + " });";
      Log.d("AdUtilityController", "init: injection: " + (String)localObject1);
      this.b.injectJavaScript((String)localObject1);
      ready();
      return;
      i = 0;
      break;
      i = 0;
      break label260;
      i = 0;
      break label306;
    }
  }
  
  public void makeCall(String paramString)
  {
    Log.d("AdUtilityController", "makeCall: number: " + paramString);
    if (TextUtils.isEmpty(paramString)) {}
    StringBuilder localStringBuilder;
    for (paramString = null; paramString == null; paramString = localStringBuilder.toString())
    {
      this.b.raiseError("Bad Phone Number", "makeCall");
      return;
      localStringBuilder = new StringBuilder("tel:");
      localStringBuilder.append(paramString);
    }
    paramString = new Intent("android.intent.action.CALL", Uri.parse(paramString.toString()));
    paramString.addFlags(268435456);
    this.a.startActivity(paramString);
  }
  
  public void ready()
  {
    this.b.injectJavaScript("broadcastEvent(EVENTS.READY, 'ready');");
    Log.d("AdUtilityController", "ready()");
  }
  
  public void sendMail(String paramString1, String paramString2, String paramString3)
  {
    Log.d("AdUtilityController", "sendMail: recipient: " + paramString1 + " subject: " + paramString2 + " body: " + paramString3);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("plain/text");
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString1 });
    localIntent.putExtra("android.intent.extra.SUBJECT", paramString2);
    localIntent.putExtra("android.intent.extra.TEXT", paramString3);
    localIntent.addFlags(268435456);
    this.a.startActivity(localIntent);
  }
  
  public void sendSMS(String paramString1, String paramString2)
  {
    Log.d("AdUtilityController", "sendSMS: recipient: " + paramString1 + " body: " + paramString2);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.putExtra("address", paramString1);
    localIntent.putExtra("sms_body", paramString2);
    localIntent.setType("vnd.android-dir/mms-sms");
    localIntent.addFlags(268435456);
    this.a.startActivity(localIntent);
  }
  
  public void setMaxSize(int paramInt1, int paramInt2)
  {
    this.d.setMaxSize(paramInt1, paramInt2);
  }
  
  public void showAlert(String paramString)
  {
    Log.e("AdUtilityController", paramString);
  }
  
  public void stopAllListeners()
  {
    try
    {
      this.c.stopAllListeners();
      this.d.stopAllListeners();
      this.e.stopAllListeners();
      this.f.stopAllListeners();
      this.g.stopAllListeners();
      return;
    }
    catch (Exception localException) {}
  }
  
  public String writeHTMLToDiskWrap(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5)
  {
    return this.c.writeHTMLToDiskWrap(paramString1, paramString2, paramBoolean, paramString3, paramString4, paramString5);
  }
  
  public String writeToDiskWrap(InputStream paramInputStream, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    return this.c.writeToDiskWrap(paramInputStream, paramString1, paramBoolean, paramString2, paramString3, paramString4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdUtilityController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */