package com.adwhirl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.adwhirl.obj.Custom;
import com.adwhirl.obj.Extra;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import com.adwhirl.util.AdWhirlUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AdWhirlManager
{
  private static final String PREFS_STRING_CONFIG = "config";
  private static final String PREFS_STRING_TIMESTAMP = "timestamp";
  private static long configExpireTimeout = 1800000L;
  private WeakReference<Context> contextReference;
  public String deviceIDHash;
  private Extra extra;
  public String keyAdWhirl;
  public String localeString;
  public Location location;
  private List<Ration> rationsList;
  Iterator<Ration> rollovers;
  private double totalWeight = 0.0D;
  
  public AdWhirlManager(WeakReference<Context> paramWeakReference, String paramString)
  {
    if (Extra2.verboselog) {
      Log.i("AdWhirl SDK", "Creating adWhirlManager...");
    }
    this.contextReference = paramWeakReference;
    this.keyAdWhirl = paramString;
    this.localeString = Locale.getDefault().toString();
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Locale is: " + this.localeString);
    }
    try
    {
      paramWeakReference = MessageDigest.getInstance("MD5");
      paramString = new StringBuffer("android_id");
      paramString.append("AdWhirl");
      this.deviceIDHash = AdWhirlUtil.convertToHex(paramWeakReference.digest(paramString.toString().getBytes()));
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "Hashed device ID is: " + this.deviceIDHash);
      }
      if (Extra2.verboselog) {
        Log.i("AdWhirl SDK", "Finished creating adWhirlManager");
      }
      return;
    }
    catch (NoSuchAlgorithmException paramWeakReference)
    {
      for (;;)
      {
        this.deviceIDHash = "00000000000000000000000000000000";
      }
    }
  }
  
  private String convertStreamToString(InputStream paramInputStream)
  {
    Object localObject1 = null;
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        str = localBufferedReader.readLine();
        if (str != null) {}
      }
      catch (IOException localIOException1)
      {
        String str;
        if (Extra2.verboselog) {
          Log.e("AdWhirl SDK", "Caught IOException in convertStreamToString()", localIOException1);
        }
        try
        {
          paramInputStream.close();
          return null;
        }
        catch (IOException localIOException2)
        {
          paramInputStream = (InputStream)localObject1;
        }
        if (!Extra2.verboselog) {
          continue;
        }
        Log.e("AdWhirl SDK", "Caught IOException in convertStreamToString()", localIOException2);
        return null;
      }
      finally
      {
        try
        {
          paramInputStream.close();
          throw ((Throwable)localObject2);
        }
        catch (IOException localIOException3)
        {
          paramInputStream = (InputStream)localObject1;
        }
        if (!Extra2.verboselog) {
          continue;
        }
        Log.e("AdWhirl SDK", "Caught IOException in convertStreamToString()", localIOException3);
        return null;
      }
      try
      {
        paramInputStream.close();
        paramInputStream = localStringBuilder.toString();
      }
      catch (IOException localIOException4)
      {
        paramInputStream = (InputStream)localObject1;
        if (!Extra2.verboselog) {
          continue;
        }
        Log.e("AdWhirl SDK", "Caught IOException in convertStreamToString()", localIOException4);
      }
      return paramInputStream;
      localStringBuilder.append(str + "\n");
    }
    return null;
  }
  
  private Drawable fetchImage(String paramString)
  {
    try
    {
      paramString = Drawable.createFromStream((InputStream)new URL(paramString).getContent(), "src");
      return paramString;
    }
    catch (Exception paramString)
    {
      if (Extra2.verboselog) {
        Log.e("AdWhirl SDK", "Unable to fetchImage(): ", paramString);
      }
    }
    return null;
  }
  
  private void parseConfigurationString(String paramString)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Received jsonString: " + paramString);
    }
    this.totalWeight = 0.0D;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      parseExtraJson(localJSONObject.getJSONObject("extra"));
      parseRationsJson(localJSONObject.getJSONArray("rations"));
      return;
    }
    catch (JSONException localJSONException)
    {
      if (Extra2.verboselog)
      {
        Log.e("AdWhirl SDK", "Unable to parse response from JSON. This may or may not be fatal.", localJSONException);
        Log.e("AdWhirl SDK", paramString);
      }
      this.extra = null;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (Extra2.verboselog)
      {
        Log.e("AdWhirl SDK", "Unable to parse response from JSON. This may or may not be fatal.", localNullPointerException);
        Log.e("AdWhirl SDK", paramString);
      }
      this.extra = null;
    }
  }
  
  private Custom parseCustomJsonString(String paramString)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Received custom jsonString: " + paramString);
    }
    Custom localCustom = new Custom();
    try
    {
      paramString = new JSONObject(paramString);
      localCustom.type = paramString.getInt("ad_type");
      localCustom.imageLink = paramString.getString("img_url");
      localCustom.link = paramString.getString("redirect_url");
      localCustom.description = paramString.getString("ad_text");
      if (localCustom.link.startsWith("market://")) {
        localCustom.link += Extra2.extraLinkMarketCustom;
      }
      try
      {
        localCustom.imageLink480x75 = paramString.getString("img_url_480x75");
        paramString = new DisplayMetrics();
        ((WindowManager)((Context)this.contextReference.get()).getSystemService("window")).getDefaultDisplay().getMetrics(paramString);
        if ((paramString.density == 1.5D) && (localCustom.type == 1) && (localCustom.imageLink480x75 != null) && (localCustom.imageLink480x75.length() != 0))
        {
          localCustom.image = fetchImage(localCustom.imageLink480x75);
          return localCustom;
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          localCustom.imageLink480x75 = null;
        }
      }
      localCustom.image = fetchImage(localCustom.imageLink);
    }
    catch (JSONException paramString)
    {
      if (Extra2.verboselog) {
        Log.e("AdWhirl SDK", "Caught JSONException in parseCustomJsonString()", paramString);
      }
      return null;
    }
    return localCustom;
  }
  
  private void parseExtraJson(JSONObject paramJSONObject)
  {
    Extra localExtra = new Extra();
    try
    {
      localExtra.cycleTime = paramJSONObject.getInt("cycle_time");
      localExtra.locationOn = paramJSONObject.getInt("location_on");
      localExtra.transition = paramJSONObject.getInt("transition");
      JSONObject localJSONObject = paramJSONObject.getJSONObject("background_color_rgb");
      localExtra.bgRed = localJSONObject.getInt("red");
      localExtra.bgGreen = localJSONObject.getInt("green");
      localExtra.bgBlue = localJSONObject.getInt("blue");
      localExtra.bgAlpha = (localJSONObject.getInt("alpha") * 255);
      paramJSONObject = paramJSONObject.getJSONObject("text_color_rgb");
      localExtra.fgRed = paramJSONObject.getInt("red");
      localExtra.fgGreen = paramJSONObject.getInt("green");
      localExtra.fgBlue = paramJSONObject.getInt("blue");
      localExtra.fgAlpha = (paramJSONObject.getInt("alpha") * 255);
      this.extra = localExtra;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (Extra2.verboselog) {
          Log.e("AdWhirl SDK", "Exception in parsing config.extra JSON. This may or may not be fatal.", paramJSONObject);
        }
      }
    }
  }
  
  private Custom parseKreactiveXMLStream(InputStream paramInputStream)
  {
    Custom localCustom = new Custom();
    for (;;)
    {
      int j;
      Object localObject1;
      Object localObject2;
      try
      {
        paramInputStream = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(paramInputStream).getDocumentElement().getElementsByTagName("ad");
        int i = 0;
        if (i >= paramInputStream.getLength())
        {
          localCustom.type = 1;
          localCustom.description = "Kreactive";
          if (localCustom.link.startsWith("market://")) {
            localCustom.link += Extra2.extraLinkMarketCustom;
          }
          localCustom.image = fetchImage(localCustom.imageLink);
          return localCustom;
        }
        NodeList localNodeList = paramInputStream.item(i).getChildNodes();
        j = 0;
        if (j >= localNodeList.getLength())
        {
          i += 1;
          continue;
        }
        localObject1 = localNodeList.item(j);
        localObject2 = ((Node)localObject1).getNodeName();
        if (((String)localObject2).equalsIgnoreCase("url")) {
          localCustom.imageLink = ((Node)localObject1).getFirstChild().getNodeValue();
        } else if (((String)localObject2).equalsIgnoreCase("destination")) {
          localCustom.link = ((Node)localObject1).getFirstChild().getNodeValue();
        }
      }
      catch (Exception paramInputStream)
      {
        if (Extra2.verboselog) {
          Log.e("AdWhirl SDK", "Caught Exception in parseKreactiveXMLString()", paramInputStream);
        }
        return null;
      }
      if (((String)localObject2).equalsIgnoreCase("id"))
      {
        localObject1 = ((Node)localObject1).getFirstChild().getNodeValue();
        localObject2 = (Context)this.contextReference.get();
        localCustom.setTrackingClick((Context)localObject2, (String)localObject1);
        localCustom.setTrackingDisplay((Context)localObject2, (String)localObject1);
      }
      j += 1;
    }
  }
  
  private void parseRationsJson(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    this.totalWeight = 0.0D;
    int i = 0;
    try
    {
      int j = paramJSONArray.length();
      if (i < j) {
        break label51;
      }
    }
    catch (JSONException paramJSONArray)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        Ration localRation;
        if (Extra2.verboselog)
        {
          Log.e("AdWhirl SDK", "JSONException in parsing config.rations JSON. This may or may not be fatal.", paramJSONArray);
          continue;
          localJSONObject = localJSONObject.getJSONObject("key");
          localRation.key = localJSONObject.getString("siteID");
          localRation.key2 = localJSONObject.getString("publisherID");
        }
      }
    }
    Collections.sort(localArrayList);
    this.rationsList = localArrayList;
    this.rollovers = this.rationsList.iterator();
    return;
    label51:
    localJSONObject = paramJSONArray.getJSONObject(i);
    if (localJSONObject != null)
    {
      localRation = new Ration();
      localRation.nid = localJSONObject.getString("nid");
      localRation.type = localJSONObject.getInt("type");
      localRation.name = localJSONObject.getString("nname");
      localRation.weight = localJSONObject.getInt("weight");
      localRation.priority = localJSONObject.getInt("priority");
      switch (localRation.type)
      {
      }
    }
    for (;;)
    {
      localRation.key = localJSONObject.getString("key");
      this.totalWeight += localRation.weight;
      localArrayList.add(localRation);
      i += 1;
      break;
    }
  }
  
  public static void setConfigExpireTimeout(long paramLong)
  {
    configExpireTimeout = paramLong;
  }
  
  public void fetchConfig()
  {
    try
    {
      if ((ModCommon.defaultjson != null) && (ModCommon.defaultjson.equals(""))) {
        Log.e("AdWhirl SDK", "Adwhirl DEFAULT CONFIG NOT SET !");
      }
      Object localObject1 = (Context)this.contextReference.get();
      if (localObject1 == null) {
        return;
      }
      SharedPreferences localSharedPreferences = ((Context)localObject1).getSharedPreferences(this.keyAdWhirl, 0);
      Object localObject8 = localSharedPreferences.getString("config", null);
      long l = localSharedPreferences.getLong("timestamp", -1L);
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "Prefs{" + this.keyAdWhirl + "}: {\"" + "config" + "\": \"" + (String)localObject8 + "\", \"" + "timestamp" + "\": " + l + "}");
      }
      Object localObject9;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      if ((localObject8 == null) || (configExpireTimeout == -1L) || (System.currentTimeMillis() >= configExpireTimeout + l))
      {
        if (Extra2.verboselog) {
          Log.i("AdWhirl SDK", "Stored config info not present or expired, fetching fresh data");
        }
        localObject1 = new DefaultHttpClient();
        localObject9 = new HttpGet(String.format("http://mob.adwhirl.com/getInfo.php?appid=%s&appver=%d&client=2", new Object[] { this.keyAdWhirl, Integer.valueOf(300) }));
        localObject5 = localObject8;
        localObject6 = localObject8;
        localObject7 = localObject8;
      }
      for (;;)
      {
        Object localObject4;
        try
        {
          localObject1 = ((HttpClient)localObject1).execute((HttpUriRequest)localObject9);
          localObject5 = localObject8;
          localObject6 = localObject8;
          localObject7 = localObject8;
          if (Extra2.verboselog)
          {
            localObject5 = localObject8;
            localObject6 = localObject8;
            localObject7 = localObject8;
            Log.d("AdWhirl SDK", ((HttpResponse)localObject1).getStatusLine().toString());
          }
          localObject5 = localObject8;
          localObject6 = localObject8;
          localObject7 = localObject8;
          localObject9 = ((HttpResponse)localObject1).getEntity();
          localObject1 = localObject8;
          if (localObject9 != null)
          {
            localObject5 = localObject8;
            localObject6 = localObject8;
            localObject7 = localObject8;
            localObject1 = convertStreamToString(((HttpEntity)localObject9).getContent());
            localObject5 = localObject1;
            localObject6 = localObject1;
            localObject7 = localObject1;
          }
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          if (!Extra2.verboselog) {
            continue;
          }
          Log.e("AdWhirl SDK", "Caught ClientProtocolException in fetchConfig()", localClientProtocolException);
          Object localObject2 = localObject5;
          if (ModCommon.defaultjson == null) {
            continue;
          }
          localObject2 = localObject5;
          if (ModCommon.defaultjson.equals("")) {
            continue;
          }
          localObject2 = ModCommon.defaultjson;
          localObject5 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject5).putString("config", (String)localObject2);
          ((SharedPreferences.Editor)localObject5).putLong("timestamp", System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject5).commit();
          continue;
        }
        catch (IOException localIOException)
        {
          if (!Extra2.verboselog) {
            continue;
          }
          Log.e("AdWhirl SDK", "Caught IOException in fetchConfig()", localIOException);
          Object localObject3 = localObject6;
          if (ModCommon.defaultjson == null) {
            continue;
          }
          localObject3 = localObject6;
          if (ModCommon.defaultjson.equals("")) {
            continue;
          }
          localObject3 = ModCommon.defaultjson;
          localObject5 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject5).putString("config", (String)localObject3);
          ((SharedPreferences.Editor)localObject5).putLong("timestamp", System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject5).commit();
          continue;
        }
        catch (Exception localException1)
        {
          if (!Extra2.verboselog) {
            continue;
          }
          Log.e("AdWhirl SDK", "Caught Exception in fetchConfig()", localException1);
          localObject4 = localObject7;
          if (ModCommon.defaultjson == null) {
            continue;
          }
          localObject4 = localObject7;
          if (ModCommon.defaultjson.equals("")) {
            continue;
          }
          localObject4 = ModCommon.defaultjson;
          localObject5 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject5).putString("config", (String)localObject4);
          ((SharedPreferences.Editor)localObject5).putLong("timestamp", System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject5).commit();
          continue;
        }
        try
        {
          new JSONObject((String)localObject1);
          localObject5 = localObject1;
          localObject6 = localObject1;
          localObject7 = localObject1;
          localObject8 = localSharedPreferences.edit();
          localObject5 = localObject1;
          localObject6 = localObject1;
          localObject7 = localObject1;
          ((SharedPreferences.Editor)localObject8).putString("config", (String)localObject1);
          localObject5 = localObject1;
          localObject6 = localObject1;
          localObject7 = localObject1;
          ((SharedPreferences.Editor)localObject8).putLong("timestamp", System.currentTimeMillis());
          localObject5 = localObject1;
          localObject6 = localObject1;
          localObject7 = localObject1;
          ((SharedPreferences.Editor)localObject8).commit();
          parseConfigurationString((String)localObject1);
          return;
        }
        catch (JSONException localJSONException2)
        {
          localObject5 = localObject1;
          localObject6 = localObject1;
          localObject7 = localObject1;
          localJSONException2.printStackTrace();
          localObject5 = localObject1;
          localObject6 = localObject1;
          localObject7 = localObject1;
          localObject1 = ModCommon.defaultjson;
          continue;
        }
        if (Extra2.verboselog) {
          Log.i("AdWhirl SDK", "Using stored config data");
        }
        try
        {
          new JSONObject(localJSONException2);
          localObject4 = localJSONException2;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          String str = ModCommon.defaultjson;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public Custom getCustom(String paramString)
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    String str;
    if (this.extra.locationOn == 1)
    {
      this.location = getLocation();
      if (this.location != null) {
        str = String.format("&location=%f,%f&location_timestamp=%d", new Object[] { Double.valueOf(this.location.getLatitude()), Double.valueOf(this.location.getLongitude()), Long.valueOf(this.location.getTime()) });
      }
    }
    for (;;)
    {
      paramString = new HttpGet(String.format("http://cus.adwhirl.com/custom.php?appid=%s&nid=%s&uuid=%s&country_code=%s%s&appver=%d&client=2", new Object[] { this.keyAdWhirl, paramString, this.deviceIDHash, this.localeString, str, Integer.valueOf(300) }));
      try
      {
        paramString = localDefaultHttpClient.execute(paramString);
        if (Extra2.verboselog) {
          Log.d("AdWhirl SDK", paramString.getStatusLine().toString());
        }
        paramString = paramString.getEntity();
        if (paramString == null) {
          break;
        }
        paramString = parseCustomJsonString(convertStreamToString(paramString.getContent()));
        return paramString;
      }
      catch (ClientProtocolException paramString)
      {
        if (!Extra2.verboselog) {
          break;
        }
        Log.e("AdWhirl SDK", "Caught ClientProtocolException in getCustom()", paramString);
        return null;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          if (Extra2.verboselog) {
            Log.e("AdWhirl SDK", "Caught IOException in getCustom()", paramString);
          }
        }
      }
      str = "";
      continue;
      this.location = null;
      str = "";
    }
  }
  
  public Extra getExtra()
  {
    if (this.totalWeight <= 0.0D)
    {
      if (Extra2.verboselog) {
        Log.i("AdWhirl SDK", "Sum of ration weights is 0 - no ads to be shown");
      }
      return null;
    }
    return this.extra;
  }
  
  public Custom getKreactive(String paramString)
  {
    Object localObject = new DefaultHttpClient();
    if (Extra2.kreativeTest) {}
    for (paramString = "http://dep-adserver.feedvalue.com/getads.php";; paramString = "http://adserver.feedvalue.com/getads.php")
    {
      paramString = paramString.concat(String.format("?cat=%s&appID=%s&w=%s&l=%s&devID=3&ver=1&con=%s&lang=%s", new Object[] { Integer.valueOf(Extra2.kreativeCat), Integer.valueOf(Extra2.kreativeAppID), Integer.valueOf(Extra2.kreativeW), Integer.valueOf(Extra2.kreativeH), Integer.valueOf(ModCommon.getConnectionType((Context)this.contextReference.get())), ModCommon.getLocale((Context)this.contextReference.get()) }));
      if (Extra2.verboselog) {
        Log.d("URL Kreactive", paramString);
      }
      paramString = new HttpGet(paramString);
      try
      {
        paramString = ((HttpClient)localObject).execute(paramString);
        if (Extra2.verboselog) {
          Log.d("AdWhirl SDK", paramString.getStatusLine().toString());
        }
        localObject = paramString.getEntity();
        if ((localObject == null) || (paramString.getStatusLine().getStatusCode() == 403)) {
          break;
        }
        paramString = parseKreactiveXMLStream(((HttpEntity)localObject).getContent());
        return paramString;
      }
      catch (ClientProtocolException paramString)
      {
        if (!Extra2.verboselog) {
          break;
        }
        Log.e("AdWhirl SDK", "Caught ClientProtocolException in getCustom()", paramString);
        return null;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          if (Extra2.verboselog) {
            Log.e("AdWhirl SDK", "Caught IOException in getCustom()", paramString);
          }
        }
      }
    }
  }
  
  public Location getLocation()
  {
    if (this.contextReference == null) {}
    Context localContext;
    do
    {
      do
      {
        return null;
        localContext = (Context)this.contextReference.get();
      } while (localContext == null);
      if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        return ((LocationManager)localContext.getSystemService("location")).getLastKnownLocation("gps");
      }
    } while (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0);
    return ((LocationManager)localContext.getSystemService("location")).getLastKnownLocation("network");
  }
  
  public Ration getRation()
  {
    double d3 = new Random().nextDouble() * this.totalWeight;
    double d1 = 0.0D;
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Dart is <" + d3 + "> of <" + this.totalWeight + ">");
    }
    Iterator localIterator = this.rationsList.iterator();
    Object localObject = null;
    Ration localRation;
    double d2;
    do
    {
      if (!localIterator.hasNext()) {
        return (Ration)localObject;
      }
      localRation = (Ration)localIterator.next();
      d2 = d1 + localRation.weight;
      localObject = localRation;
      d1 = d2;
    } while (d2 < d3);
    return localRation;
  }
  
  public Ration getRollover()
  {
    if (this.rollovers == null) {}
    do
    {
      return null;
      if (Extra2.verboselog) {
        Log.w("AdWhirl SDK", "GETROLLOVER");
      }
    } while (!this.rollovers.hasNext());
    return (Ration)this.rollovers.next();
  }
  
  public void resetRollover()
  {
    if (Extra2.verboselog) {
      Log.w("AdWhirl SDK", "RESET ROLLOVER");
    }
    this.rollovers = this.rationsList.iterator();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/AdWhirlManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */