package com.inmobi.androidsdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.inmobi.commons.internal.IMLog;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class IMNiceInfo
{
  private List<ScanResult> a = null;
  private Context b = null;
  private String c = null;
  private Long d = Long.valueOf(0L);
  private Long e = Long.valueOf(0L);
  private AtomicLong f;
  private IMUserInfo g = null;
  private a h = null;
  
  public IMNiceInfo(Context paramContext, IMUserInfo paramIMUserInfo)
  {
    this.b = paramContext;
    this.g = paramIMUserInfo;
    scanWifiAP();
    this.f = new AtomicLong(0L);
  }
  
  private boolean a()
  {
    return this.b.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
  }
  
  private boolean b()
  {
    return this.b.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0;
  }
  
  private void c()
  {
    try
    {
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      HttpPost localHttpPost = new HttpPost(this.c);
      List localList = d();
      if (localList != null)
      {
        IMLog.internal("InMobiAndroidSDK_3.6.1", "NICE Param: " + localList);
        localHttpPost.setEntity(new UrlEncodedFormEntity(localList));
        if (localDefaultHttpClient.execute(localHttpPost).getStatusLine().getStatusCode() == 200) {
          IMLog.internal("InMobiAndroidSDK_3.6.1", "NICE params posted Successfully");
        }
      }
      else
      {
        IMLog.internal("InMobiAndroidSDK_3.6.1", "NICE Params not present");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private List<NameValuePair> d()
  {
    if (this.g == null) {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "User Info Not initialised");
    }
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList(4);
      String str1 = getCellInfo();
      String str2 = getSimInfo();
      String str3 = getWifiInfo();
      String str4 = getTimeStamp();
      if (str1 != null) {
        localArrayList.add(new BasicNameValuePair("d-n-cell", str1));
      }
      if (str2 != null) {
        localArrayList.add(new BasicNameValuePair("d-n-sim", str2));
      }
      if (str3 != null) {
        localArrayList.add(new BasicNameValuePair("d-n-wifi", str3));
      }
      if (((str2 != null) || (str1 != null) || (str3 != null)) && (str4 != null))
      {
        localArrayList.add(new BasicNameValuePair("d-n-time", str4));
        str1 = this.g.getUIDMapEncrypted();
        str2 = this.g.getRandomKey();
        str3 = this.g.getRsakeyVersion();
        if ((str1 != null) && (str2 != null) && (str3 != null))
        {
          localArrayList.add(new BasicNameValuePair("u-id-map", str1));
          localArrayList.add(new BasicNameValuePair("u-id-key", str2));
          localArrayList.add(new BasicNameValuePair("u-key-ver", str3));
        }
      }
    } while (localArrayList.isEmpty());
    return localArrayList;
  }
  
  public String getCellInfo()
  {
    if (!a())
    {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "Access coarse permission not granted.Cant collect Cell Info");
      return null;
    }
    try
    {
      Object localObject1 = new JSONObject();
      Object localObject2 = (TelephonyManager)this.b.getSystemService("phone");
      String str2 = ((TelephonyManager)localObject2).getNetworkOperator();
      Object localObject3 = ((TelephonyManager)localObject2).getCellLocation();
      if ((localObject3 != null) && (str2 != null) && (!str2.equals("")))
      {
        localObject2 = str2.substring(0, 3);
        str2 = str2.substring(3);
        int i;
        int j;
        String str3;
        if ((localObject3 instanceof CdmaCellLocation))
        {
          ((JSONObject)localObject1).put("a1", 2);
          localObject3 = (CdmaCellLocation)localObject3;
          i = ((CdmaCellLocation)localObject3).getNetworkId();
          j = ((CdmaCellLocation)localObject3).getBaseStationId();
          int k = ((CdmaCellLocation)localObject3).getSystemId();
          if ((i != -1) && (j != -1) && (k != -1))
          {
            localObject3 = Integer.toHexString(i);
            str3 = Integer.toHexString(j);
            String str4 = Integer.toHexString(k);
            ((JSONObject)localObject1).put("a2", localObject2 + "-" + str2 + "-" + (String)localObject3 + "-" + str3 + "-" + str4);
          }
        }
        while (((JSONObject)localObject1).length() != 0)
        {
          localObject1 = new JSONObject().put("a", localObject1).toString();
          break label391;
          ((JSONObject)localObject1).put("a1", 1);
          localObject3 = (GsmCellLocation)localObject3;
          i = ((GsmCellLocation)localObject3).getCid();
          j = ((GsmCellLocation)localObject3).getLac();
          if ((i != -1) && (j != -1))
          {
            localObject3 = Integer.toHexString(j);
            str3 = Integer.toHexString(i);
            ((JSONObject)localObject1).put("a2", localObject2 + "-" + str2 + "-" + (String)localObject3 + "-" + str3);
          }
        }
      }
      str1 = null;
    }
    catch (Exception localException)
    {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "Error Getting NICE param Cell Info", localException);
      return null;
    }
    String str1;
    label391:
    return str1;
  }
  
  public String getSimInfo()
  {
    if (!a())
    {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "Access coarse permission not granted.Cant collect Sim Info");
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject();
        String str2 = ((TelephonyManager)this.b.getSystemService("phone")).getSimOperator();
        if ((str2 != null) && (!str2.equals("")))
        {
          String str1 = str2.substring(0, 3);
          str2 = str2.substring(3);
          ((JSONObject)localObject1).put("b1", str1 + "-" + str2);
        }
        if (((JSONObject)localObject1).length() != 0)
        {
          localObject1 = new JSONObject().put("b", localObject1).toString();
          return (String)localObject1;
        }
      }
      catch (Exception localException)
      {
        IMLog.internal("InMobiAndroidSDK_3.6.1", "Error Getting NICE Param Sim Info", localException);
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  public String getTimeStamp()
  {
    String str = null;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Calendar localCalendar = Calendar.getInstance();
      long l = localCalendar.getTimeInMillis();
      int i = localCalendar.get(15);
      localJSONObject.put("d1", l);
      localJSONObject.put("d2", i);
      if (localJSONObject.length() != 0) {
        str = new JSONObject().put("d", localJSONObject).toString();
      }
      return str;
    }
    catch (Exception localException)
    {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "Error Getting NICE param Timestamp", localException);
    }
    return null;
  }
  
  public String getWifiInfo()
  {
    if (!b())
    {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "Access wifi permission not granted.Cant collect get wifi access point Info");
      return null;
    }
    try
    {
      Object localObject = new JSONArray();
      int i;
      if (this.a != null) {
        i = 0;
      }
      for (;;)
      {
        if (i >= this.a.size())
        {
          if (((JSONArray)localObject).length() == 0) {
            break;
          }
          return new JSONObject().put("c", localObject).toString();
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("c1a", ((ScanResult)this.a.get(i)).SSID);
        localJSONObject.put("c1b", ((ScanResult)this.a.get(i)).BSSID);
        localJSONObject.put("c1c", ((ScanResult)this.a.get(i)).level);
        ((JSONArray)localObject).put(i, localJSONObject);
        i += 1;
      }
      str = null;
    }
    catch (Exception localException)
    {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "Error Getting NICE Param Wifi Apian", localException);
      return null;
    }
    String str;
    return str;
  }
  
  public void processNiceParams(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection == null) {}
    try
    {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "HTTP Connection lost.Cannot retreive nice url");
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      String str;
      Long localLong1;
      Long localLong2;
      IMLog.internal("InMobiAndroidSDK_3.6.1", "Failed to process NICE params", paramHttpURLConnection);
    }
    if (Boolean.valueOf(Boolean.parseBoolean(paramHttpURLConnection.getHeaderField("x-inmobi-ph-enable"))).booleanValue())
    {
      str = paramHttpURLConnection.getHeaderField("x-inmobi-ph-url");
      localLong1 = Long.valueOf(Long.parseLong(paramHttpURLConnection.getHeaderField("x-inmobi-ph-intvl-sec")));
      localLong2 = Long.valueOf(Long.parseLong(paramHttpURLConnection.getHeaderField("x-inmobi-ph-lse-sec")));
      paramHttpURLConnection = localLong1;
      if (localLong1.longValue() < IMConfigConstants.MIN_NICE_RETRY_INERVAL.longValue()) {
        paramHttpURLConnection = IMConfigConstants.MIN_NICE_RETRY_INERVAL;
      }
      if ((!str.equals(this.c)) || (!localLong2.toString().equals(this.e.toString())) || (!paramHttpURLConnection.toString().equals(this.d.toString())) || (this.f.get() == 0L))
      {
        this.c = str;
        this.d = paramHttpURLConnection;
        this.e = localLong2;
        IMLog.internal("InMobiAndroidSDK_3.6.1", "NICE URL: " + this.c);
        new Thread(new Runnable()
        {
          public void run()
          {
            
            if (IMNiceInfo.d(IMNiceInfo.this) != null) {
              IMNiceInfo.d(IMNiceInfo.this).removeMessages(1);
            }
            while ((IMNiceInfo.c(IMNiceInfo.this).longValue() == 0L) || (IMNiceInfo.e(IMNiceInfo.this).longValue() == 0L))
            {
              return;
              IMNiceInfo.a(IMNiceInfo.this, new IMNiceInfo.a(IMNiceInfo.this));
            }
            IMNiceInfo.a(IMNiceInfo.this).set(IMNiceInfo.e(IMNiceInfo.this).longValue() / IMNiceInfo.c(IMNiceInfo.this).longValue());
            IMNiceInfo.d(IMNiceInfo.this).sendEmptyMessage(1);
            Looper.loop();
          }
        }).start();
        return;
      }
    }
  }
  
  public void scanWifiAP()
  {
    if (!b()) {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "Access wifi permission not granted.Cant collect scan wifi Info");
    }
    for (;;)
    {
      return;
      try
      {
        Object localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.net.wifi.SCAN_RESULTS");
        this.b.registerReceiver(new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            paramAnonymousContext = (WifiManager)paramAnonymousContext.getSystemService("wifi");
            IMNiceInfo.a(IMNiceInfo.this, paramAnonymousContext.getScanResults());
          }
        }, (IntentFilter)localObject);
        localObject = (WifiManager)this.b.getSystemService("wifi");
        this.a = ((WifiManager)localObject).getScanResults();
        if (this.a == null)
        {
          ((WifiManager)localObject).startScan();
          return;
        }
      }
      catch (Exception localException)
      {
        IMLog.internal("InMobiAndroidSDK_3.6.1", "Error Setting Wifi Apian", localException);
      }
    }
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<IMNiceInfo> a;
    
    public a(IMNiceInfo paramIMNiceInfo)
    {
      this.a = new WeakReference(paramIMNiceInfo);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if (IMNiceInfo.a((IMNiceInfo)this.a.get()).get() > 0L)
        {
          IMNiceInfo.b((IMNiceInfo)this.a.get());
          IMNiceInfo.a((IMNiceInfo)this.a.get()).set(IMNiceInfo.a((IMNiceInfo)this.a.get()).get() - 1L);
          sendEmptyMessageDelayed(1, IMNiceInfo.c((IMNiceInfo)this.a.get()).longValue() * 1000L);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/IMNiceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */