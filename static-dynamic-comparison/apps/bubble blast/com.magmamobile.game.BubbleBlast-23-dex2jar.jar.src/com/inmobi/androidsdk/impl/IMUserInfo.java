package com.inmobi.androidsdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdRequest.EducationType;
import com.inmobi.androidsdk.IMAdRequest.EthnicityType;
import com.inmobi.androidsdk.IMAdRequest.GenderType;
import com.inmobi.androidsdk.IMAdRequest.IMIDType;
import com.inmobi.commons.IMCommonUtil;
import com.inmobi.commons.internal.IMLog;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

public final class IMUserInfo
{
  private Random A;
  private String B;
  private int C = -1;
  private int D;
  boolean a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private LocationManager l;
  private String m;
  private double n;
  private double o;
  private double p;
  private boolean q;
  private Context r;
  private String s;
  private String t = null;
  private String u = null;
  private String v = null;
  private String w = null;
  private String x = null;
  private String y = null;
  private IMAdRequest z;
  
  public IMUserInfo(Context paramContext)
  {
    this.r = paramContext;
    this.A = new Random();
  }
  
  private String a()
  {
    return this.f;
  }
  
  private void a(double paramDouble)
  {
    this.n = paramDouble;
  }
  
  private void a(int paramInt)
  {
    this.g = Integer.toString(paramInt);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      if (this.B == null) {
        this.B = paramContext.getSharedPreferences("inmobisdkaid", 0).getString("A_ID", null);
      }
      if (this.B == null)
      {
        this.B = UUID.randomUUID().toString();
        paramContext = paramContext.getSharedPreferences("inmobisdkaid", 0).edit();
        paramContext.putString("A_ID", this.B);
        paramContext.commit();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void a(Location paramLocation)
  {
    if (paramLocation != null)
    {
      b(true);
      a(paramLocation.getLatitude());
      b(paramLocation.getLongitude());
      c(paramLocation.getAccuracy());
    }
  }
  
  private void a(LocationManager paramLocationManager)
  {
    try
    {
      this.l = paramLocationManager;
      return;
    }
    finally
    {
      paramLocationManager = finally;
      throw paramLocationManager;
    }
  }
  
  private void a(IMAdRequest paramIMAdRequest)
  {
    this.z = paramIMAdRequest;
  }
  
  private void a(String paramString)
  {
    this.b = paramString;
  }
  
  private void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  private String b()
  {
    return this.j;
  }
  
  private void b(double paramDouble)
  {
    this.o = paramDouble;
  }
  
  private void b(int paramInt)
  {
    this.D = paramInt;
  }
  
  private void b(String paramString)
  {
    this.c = paramString;
  }
  
  private void b(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  private LocationManager c()
  {
    try
    {
      LocationManager localLocationManager = this.l;
      return localLocationManager;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void c(double paramDouble)
  {
    this.p = paramDouble;
  }
  
  private void c(String paramString)
  {
    this.d = paramString;
  }
  
  private void d(String paramString)
  {
    this.e = paramString;
  }
  
  private boolean d()
  {
    if (this.z != null) {
      return this.z.isLocationInquiryAllowed();
    }
    return true;
  }
  
  private void e(String paramString)
  {
    this.f = paramString;
  }
  
  private boolean e()
  {
    return this.a;
  }
  
  private void f()
  {
    try
    {
      if (c() == null) {
        a((LocationManager)getApplicationContext().getSystemService("location"));
      }
      if (c() != null)
      {
        Object localObject1 = c();
        Object localObject2 = new Criteria();
        if (getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          ((Criteria)localObject2).setAccuracy(1);
        }
        for (;;)
        {
          ((Criteria)localObject2).setCostAllowed(false);
          localObject2 = ((LocationManager)localObject1).getBestProvider((Criteria)localObject2, true);
          if ((isValidGeoInfo()) || (localObject2 == null)) {
            break;
          }
          localObject2 = ((LocationManager)localObject1).getLastKnownLocation((String)localObject2);
          IMLog.debug("InMobiAndroidSDK_3.6.1", "lastBestKnownLocation: " + localObject2);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = g();
            IMLog.debug("InMobiAndroidSDK_3.6.1", "lastKnownLocation: " + localObject1);
          }
          a((Location)localObject1);
          return;
          if (getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            ((Criteria)localObject2).setAccuracy(2);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Error getting the Location Info ", localException);
    }
  }
  
  private void f(String paramString)
  {
    this.h = paramString;
  }
  
  private Location g()
  {
    if (c() == null) {
      a((LocationManager)getApplicationContext().getSystemService("location"));
    }
    LocationManager localLocationManager;
    List localList;
    int i1;
    if (c() != null)
    {
      localLocationManager = c();
      localList = localLocationManager.getProviders(true);
      i1 = localList.size() - 1;
    }
    for (;;)
    {
      Object localObject;
      if (i1 < 0) {
        localObject = null;
      }
      Location localLocation;
      do
      {
        return (Location)localObject;
        localObject = (String)localList.get(i1);
        if (!localLocationManager.isProviderEnabled((String)localObject)) {
          break;
        }
        localLocation = localLocationManager.getLastKnownLocation((String)localObject);
        localObject = localLocation;
      } while (localLocation != null);
      i1 -= 1;
    }
  }
  
  private void g(String paramString)
  {
    this.i = paramString;
  }
  
  private void h()
  {
    int i1 = getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
    int i2 = getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
    if ((i1 != 0) && (i2 != 0))
    {
      a(true);
      return;
    }
    a(false);
  }
  
  private void h(String paramString)
  {
    this.j = paramString;
  }
  
  private void i()
  {
    Object localObject1;
    Object localObject4;
    if (b() == null)
    {
      h(Build.BRAND);
      localObject1 = Locale.getDefault();
      localObject3 = ((Locale)localObject1).getLanguage();
      if (localObject3 == null) {
        break label342;
      }
      localObject3 = ((String)localObject3).toLowerCase();
      localObject4 = ((Locale)localObject1).getCountry();
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = localObject3 + "_" + ((String)localObject4).toLowerCase();
      }
    }
    for (;;)
    {
      g((String)localObject1);
      try
      {
        localObject1 = getApplicationContext();
        localObject3 = ((Context)localObject1).getPackageManager();
        localObject4 = ((PackageManager)localObject3).getApplicationInfo(((Context)localObject1).getPackageName(), 128);
        if (localObject4 != null)
        {
          a(((ApplicationInfo)localObject4).packageName);
          b(((ApplicationInfo)localObject4).loadLabel((PackageManager)localObject3).toString());
        }
        localObject4 = ((PackageManager)localObject3).getPackageInfo(((Context)localObject1).getPackageName(), 128);
        if (localObject4 == null) {
          break label450;
        }
        localObject3 = ((PackageInfo)localObject4).versionName;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (!((String)localObject3).equals("")) {}
        }
        else
        {
          localObject1 = ((PackageInfo)localObject4).versionCode;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i1;
          continue;
          localObject3 = null;
          Object localObject2 = null;
          continue;
          localObject2 = null;
        }
      }
      if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
        c((String)localObject1);
      }
      e(InternalSDKUtil.getODIN1(InternalSDKUtil.getAndroidId(getApplicationContext())));
      a(this.A.nextInt());
      i1 = 0;
      if (this.z != null)
      {
        localObject1 = this.z.getIDType(IMAdRequest.IMIDType.ID_LOGIN);
        localObject3 = this.z.getIDType(IMAdRequest.IMIDType.ID_SESSION);
        i1 = IMCommonUtil.getDeviceIdMask();
        f(InternalSDKUtil.getUIDMap((String)localObject1, (String)localObject3, a(), null, i1, getRandomKey()));
        if (this.r != null) {
          a(this.r.getApplicationContext());
        }
        d(InternalSDKUtil.getConnectivityType(getApplicationContext()));
        try
        {
          i1 = getApplicationContext().getResources().getConfiguration().orientation;
          if (i1 == 2) {
            b(3);
          }
          label342:
          while (i1 != 1)
          {
            return;
            localObject1 = (String)System.getProperties().get("user.language");
            localObject4 = (String)System.getProperties().get("user.region");
            if ((localObject1 == null) || (localObject4 == null)) {
              break label455;
            }
            localObject3 = localObject1 + "_" + (String)localObject4;
            localObject1 = localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject1 = "en";
            break;
          }
          b(1);
          return;
        }
        catch (Exception localException1)
        {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Error getting the orientation info ", localException1);
          return;
        }
      }
    }
  }
  
  private void i(String paramString)
  {
    this.k = paramString;
  }
  
  public String getAdUnitSlot()
  {
    return this.v;
  }
  
  public int getAge()
  {
    if (this.z != null) {
      return this.z.getAge();
    }
    return 0;
  }
  
  public String getAid()
  {
    return this.B;
  }
  
  public String getAppBId()
  {
    return this.b;
  }
  
  public String getAppDisplayName()
  {
    return this.c;
  }
  
  public String getAppVer()
  {
    return this.d;
  }
  
  protected Context getApplicationContext()
  {
    return this.r;
  }
  
  public String getAreaCode()
  {
    if (this.z != null) {
      return this.z.getAreaCode();
    }
    return null;
  }
  
  public String getDateOfBirth()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.z != null)
    {
      localObject1 = localObject2;
      if (this.z.getDateOfBirth() != null)
      {
        localObject1 = this.z.getDateOfBirth();
        localObject1 = ((Calendar)localObject1).get(1) + "-" + (((Calendar)localObject1).get(2) + 1) + "-" + ((Calendar)localObject1).get(5);
      }
    }
    return (String)localObject1;
  }
  
  public IMAdRequest.EducationType getEducation()
  {
    if (this.z != null) {
      return this.z.getEducation();
    }
    return null;
  }
  
  public IMAdRequest.EthnicityType getEthnicity()
  {
    if (this.z != null) {
      return this.z.getEthnicity();
    }
    return null;
  }
  
  public IMAdRequest.GenderType getGender()
  {
    if (this.z != null) {
      return this.z.getGender();
    }
    return null;
  }
  
  public int getIncome()
  {
    if (this.z != null) {
      return this.z.getIncome();
    }
    return 0;
  }
  
  public String getInterests()
  {
    if (this.z != null) {
      return this.z.getInterests();
    }
    return null;
  }
  
  public String getKeywords()
  {
    if (this.z != null) {
      return this.z.getKeywords();
    }
    return null;
  }
  
  public double getLat()
  {
    return this.n;
  }
  
  public double getLocAccuracy()
  {
    return this.p;
  }
  
  public String getLocalization()
  {
    return this.i;
  }
  
  public String getLocationWithCityStateCountry()
  {
    if (this.z != null) {
      return this.z.getLocationWithCityStateCountry();
    }
    return null;
  }
  
  public double getLon()
  {
    return this.o;
  }
  
  public String getNetworkType()
  {
    return this.e;
  }
  
  public int getOrientation()
  {
    return this.D;
  }
  
  public String getPhoneDefaultUserAgent()
  {
    if (this.s == null) {
      return "";
    }
    return this.s;
  }
  
  public String getPostalCode()
  {
    if (this.z != null) {
      return this.z.getPostalCode();
    }
    return null;
  }
  
  public String getRandomKey()
  {
    return this.g;
  }
  
  public String getRefTagKey()
  {
    return this.t;
  }
  
  public String getRefTagValue()
  {
    return this.u;
  }
  
  public int getRefreshType()
  {
    return this.C;
  }
  
  public Map<String, String> getRequestParams()
  {
    if (this.z != null) {
      return this.z.getRequestParams();
    }
    return null;
  }
  
  public String getRsakeyVersion()
  {
    return InternalSDKUtil.getRSAKeyVersion();
  }
  
  public String getScreenDensity()
  {
    return this.y;
  }
  
  public String getScreenSize()
  {
    return this.x;
  }
  
  public String getSearchString()
  {
    if (this.z != null) {
      return this.z.getSearchString();
    }
    return null;
  }
  
  public String getSiteId()
  {
    return this.k;
  }
  
  public String getSlotId()
  {
    return this.w;
  }
  
  public String getTestModeAdActionType()
  {
    return this.m;
  }
  
  public String getUIDMapEncrypted()
  {
    return this.h;
  }
  
  public boolean isTestMode()
  {
    if (this.z != null) {
      return this.z.isTestMode();
    }
    return false;
  }
  
  public boolean isValidGeoInfo()
  {
    return this.q;
  }
  
  public void setAdUnitSlot(String paramString)
  {
    this.v = paramString;
  }
  
  public void setPhoneDefaultUserAgent(String paramString)
  {
    this.s = paramString;
  }
  
  public void setRefTagKey(String paramString)
  {
    this.t = paramString;
  }
  
  public void setRefTagValue(String paramString)
  {
    this.u = paramString;
  }
  
  public void setRefreshType(int paramInt)
  {
    if ((paramInt != 1) || (paramInt != 0)) {
      this.C = -1;
    }
    this.C = paramInt;
  }
  
  public void setScreenDensity(String paramString)
  {
    this.y = paramString;
  }
  
  public void setScreenSize(String paramString)
  {
    this.x = paramString;
  }
  
  public void setSlotId(String paramString)
  {
    this.w = paramString;
  }
  
  public void updateInfo(String paramString, IMAdRequest paramIMAdRequest)
  {
    label78:
    for (;;)
    {
      try
      {
        a(paramIMAdRequest);
        i();
        i(paramString);
        if (paramIMAdRequest != null)
        {
          b(false);
          if (!d()) {
            break label78;
          }
          if (paramIMAdRequest.getCurrentLocation() != null)
          {
            a(paramIMAdRequest.getCurrentLocation());
            b(true);
          }
        }
        else
        {
          return;
        }
        h();
        if (!e())
        {
          f();
          continue;
          a(true);
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/IMUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */