package com.inmobi.androidsdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.inmobi.androidsdk.AdRequest;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDHelper;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

public final class UserInfo
{
  private String A;
  private int B;
  private long C;
  private Activity D;
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
  private double m;
  private double n;
  private double o;
  private boolean p;
  private Context q;
  private String r;
  private String s = null;
  private String t = null;
  private String u = null;
  private String v = null;
  private String w = null;
  private String x = null;
  private AdRequest y;
  private Random z;
  
  public UserInfo(Activity paramActivity)
  {
    this.D = paramActivity;
    this.q = paramActivity.getApplicationContext();
    this.z = new Random();
  }
  
  private String a()
  {
    return this.j;
  }
  
  private void a(double paramDouble)
  {
    this.m = paramDouble;
  }
  
  private void a(int paramInt)
  {
    this.g = Integer.toString(paramInt);
  }
  
  private void a(long paramLong)
  {
    this.C = paramLong;
  }
  
  private void a(Context paramContext)
  {
    try
    {
      if (this.A == null) {
        this.A = paramContext.getSharedPreferences("inmobisdkaid", 0).getString("A_ID", null);
      }
      if (this.A == null)
      {
        this.A = UUID.randomUUID().toString();
        paramContext = paramContext.getSharedPreferences("inmobisdkaid", 0).edit();
        paramContext.putString("A_ID", this.A);
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
      a(paramLocation.getTime());
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
  
  private void a(AdRequest paramAdRequest)
  {
    this.y = paramAdRequest;
  }
  
  private void a(String paramString)
  {
    this.b = paramString;
  }
  
  private void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  private LocationManager b()
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
  
  private void b(double paramDouble)
  {
    this.n = paramDouble;
  }
  
  private void b(int paramInt)
  {
    this.B = paramInt;
  }
  
  private void b(String paramString)
  {
    this.c = paramString;
  }
  
  private void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  private void c(double paramDouble)
  {
    this.o = paramDouble;
  }
  
  private void c(String paramString)
  {
    this.d = paramString;
  }
  
  private boolean c()
  {
    if (this.y != null) {
      return this.y.isLocationInquiryAllowed();
    }
    return true;
  }
  
  private void d(String paramString)
  {
    this.e = paramString;
  }
  
  private boolean d()
  {
    return this.a;
  }
  
  private void e()
  {
    try
    {
      if (b() == null) {
        a((LocationManager)getApplicationContext().getSystemService("location"));
      }
      if (b() != null)
      {
        Object localObject1 = b();
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
          Log.debug("[InMobi]-[Network]-4.1.1", "lastBestKnownLocation: " + localObject2);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = f();
            Log.debug("[InMobi]-[Network]-4.1.1", "lastKnownLocation: " + localObject1);
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
      Log.debug("[InMobi]-[Network]-4.1.1", "Error getting the Location Info ", localException);
    }
  }
  
  private void e(String paramString)
  {
    this.f = paramString;
  }
  
  private Location f()
  {
    if (b() == null) {
      a((LocationManager)getApplicationContext().getSystemService("location"));
    }
    if (b() != null)
    {
      LocationManager localLocationManager = b();
      List localList = localLocationManager.getProviders(true);
      int i1 = localList.size() - 1;
      while (i1 >= 0)
      {
        Object localObject = (String)localList.get(i1);
        if (localLocationManager.isProviderEnabled((String)localObject))
        {
          localObject = localLocationManager.getLastKnownLocation((String)localObject);
          if (localObject != null) {
            return (Location)localObject;
          }
        }
        i1 -= 1;
      }
    }
    return null;
  }
  
  private void f(String paramString)
  {
    this.h = paramString;
  }
  
  private void g()
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
  
  private void g(String paramString)
  {
    this.i = paramString;
  }
  
  private void h()
  {
    Object localObject1;
    Object localObject4;
    Object localObject5;
    if (a() == null)
    {
      h(Build.BRAND);
      localObject1 = Locale.getDefault();
      localObject4 = ((Locale)localObject1).getLanguage();
      if (localObject4 == null) {
        break label374;
      }
      localObject4 = ((String)localObject4).toLowerCase(Locale.ENGLISH);
      localObject5 = ((Locale)localObject1).getCountry();
      localObject1 = localObject4;
      if (localObject5 != null) {
        localObject1 = (String)localObject4 + "_" + ((String)localObject5).toLowerCase(Locale.ENGLISH);
      }
    }
    for (;;)
    {
      g((String)localObject1);
      try
      {
        localObject1 = getApplicationContext();
        localObject4 = ((Context)localObject1).getPackageManager();
        localObject5 = ((PackageManager)localObject4).getApplicationInfo(((Context)localObject1).getPackageName(), 128);
        if (localObject5 != null)
        {
          a(((ApplicationInfo)localObject5).packageName);
          b(((ApplicationInfo)localObject5).loadLabel((PackageManager)localObject4).toString());
        }
        localObject5 = ((PackageManager)localObject4).getPackageInfo(((Context)localObject1).getPackageName(), 128);
        if (localObject5 == null) {
          break label506;
        }
        localObject4 = ((PackageInfo)localObject5).versionName;
        if (localObject4 != null)
        {
          localObject1 = localObject4;
          if (!((String)localObject4).equals("")) {}
        }
        else
        {
          localObject1 = ((PackageInfo)localObject5).versionCode + "";
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          int i1;
          continue;
          Object localObject3 = null;
        }
      }
      if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
        c((String)localObject1);
      }
      e(UIDHelper.getODIN1(UIDHelper.getAndroidId(getApplicationContext())));
      a(this.z.nextInt());
      i1 = 0;
      if (this.y != null) {
        i1 = com.inmobi.commons.data.UserInfo.getInstance().getDeviceIDMask();
      }
      localObject4 = new HashMap();
      try
      {
        localObject1 = AnalyticsInitializer.getConfigParams().getLTVId();
        if (localObject1 != null) {
          ((Map)localObject4).put("LTVID", localObject1 + "");
        }
        f(Initializer.getConfigParams().getUID().getUidMap(i1, getRandomKey(), (Map)localObject4));
        if (this.q != null) {
          a(this.q);
        }
        d(InternalSDKUtil.getConnectivityType(getApplicationContext()));
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            i1 = WrapperFunctions.getCurrentOrientationInFixedValues(i());
            if (i1 != 9) {
              break label463;
            }
            b(2);
            return;
            label374:
            localObject1 = (String)System.getProperties().get("user.language");
            localObject5 = (String)System.getProperties().get("user.region");
            if ((localObject1 == null) || (localObject5 == null)) {
              break label511;
            }
            localObject4 = (String)localObject1 + "_" + (String)localObject5;
            localObject1 = localObject4;
            if (localObject4 != null) {
              break;
            }
            localObject1 = "en";
            break;
            localException1 = localException1;
            Log.internal("[InMobi]-[Network]-4.1.1", "LTVID not available yet in configs");
            Object localObject2 = null;
          }
          label463:
          if (i1 == 8)
          {
            b(4);
            return;
          }
        }
        catch (Exception localException2)
        {
          Log.debug("[InMobi]-[Network]-4.1.1", "Error getting the orientation info ", localException2);
          return;
        }
        if (i1 == 0)
        {
          b(3);
          return;
        }
        b(1);
        return;
      }
    }
  }
  
  private void h(String paramString)
  {
    this.j = paramString;
  }
  
  private Activity i()
  {
    return this.D;
  }
  
  private void i(String paramString)
  {
    this.k = paramString;
  }
  
  public String getAdUnitSlot()
  {
    return this.u;
  }
  
  public int getAge()
  {
    if (this.y != null) {
      return this.y.getAge();
    }
    return 0;
  }
  
  public String getAid()
  {
    return this.A;
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
  
  public Context getApplicationContext()
  {
    return this.q;
  }
  
  public String getAreaCode()
  {
    if (this.y != null) {
      return this.y.getAreaCode();
    }
    return null;
  }
  
  public String getDateOfBirth()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.y != null)
    {
      localObject1 = localObject2;
      if (this.y.getDateOfBirth() != null)
      {
        localObject1 = this.y.getDateOfBirth();
        localObject1 = ((Calendar)localObject1).get(1) + "-" + (((Calendar)localObject1).get(2) + 1) + "-" + ((Calendar)localObject1).get(5);
      }
    }
    return (String)localObject1;
  }
  
  public EducationType getEducation()
  {
    if (this.y != null) {
      return this.y.getEducation();
    }
    return null;
  }
  
  public EthnicityType getEthnicity()
  {
    if (this.y != null) {
      return this.y.getEthnicity();
    }
    return null;
  }
  
  public GenderType getGender()
  {
    if (this.y != null) {
      return this.y.getGender();
    }
    return null;
  }
  
  public long getGeoTS()
  {
    return this.C;
  }
  
  public HasChildren getHasChildren()
  {
    if (this.y != null) {
      return this.y.getHasChildren();
    }
    return null;
  }
  
  public int getIncome()
  {
    if (this.y != null) {
      return this.y.getIncome();
    }
    return 0;
  }
  
  public String getInterests()
  {
    if (this.y != null) {
      return this.y.getInterests();
    }
    return null;
  }
  
  public String getKeywords()
  {
    if (this.y != null) {
      return this.y.getKeywords();
    }
    return null;
  }
  
  public String getLanguage()
  {
    if (this.y != null) {
      return this.y.getLanguage();
    }
    return null;
  }
  
  public double getLat()
  {
    return this.m;
  }
  
  public double getLocAccuracy()
  {
    return this.o;
  }
  
  public String getLocalization()
  {
    return this.i;
  }
  
  public String getLocationWithCityStateCountry()
  {
    if (this.y != null) {
      return this.y.getLocationWithCityStateCountry();
    }
    return null;
  }
  
  public double getLon()
  {
    return this.n;
  }
  
  public MaritalStatus getMaritalStatus()
  {
    if (this.y != null) {
      return this.y.getMaritalStatus();
    }
    return null;
  }
  
  public String getNetworkType()
  {
    return this.e;
  }
  
  public String getODINId()
  {
    return this.f;
  }
  
  public int getOrientation()
  {
    return this.B;
  }
  
  public String getPhoneDefaultUserAgent()
  {
    if (this.r == null) {
      return "";
    }
    return this.r;
  }
  
  public String getPostalCode()
  {
    if (this.y != null) {
      return this.y.getPostalCode();
    }
    return null;
  }
  
  public String getRandomKey()
  {
    return this.g;
  }
  
  public String getRefTagKey()
  {
    return this.s;
  }
  
  public String getRefTagValue()
  {
    return this.t;
  }
  
  public Map<String, String> getRequestParams()
  {
    if (this.y != null) {
      return this.y.getRequestParams();
    }
    return null;
  }
  
  public String getRsakeyVersion()
  {
    return UIDHelper.getRSAKeyVersion();
  }
  
  public String getScreenDensity()
  {
    return this.x;
  }
  
  public String getScreenSize()
  {
    return this.w;
  }
  
  public String getSearchString()
  {
    if (this.y != null) {
      return this.y.getSearchString();
    }
    return null;
  }
  
  public SexualOrientation getSexualOrientation()
  {
    if (this.y != null) {
      return this.y.getSexualOrientation();
    }
    return null;
  }
  
  public String getSiteId()
  {
    return this.k;
  }
  
  public String getSlotId()
  {
    return this.v;
  }
  
  public String getUIDMapEncrypted()
  {
    return this.h;
  }
  
  public boolean isValidGeoInfo()
  {
    return this.p;
  }
  
  public void setAdUnitSlot(String paramString)
  {
    this.u = paramString;
  }
  
  public void setPhoneDefaultUserAgent(String paramString)
  {
    this.r = paramString;
  }
  
  public void setRefTagKey(String paramString)
  {
    this.s = paramString;
  }
  
  public void setRefTagValue(String paramString)
  {
    this.t = paramString;
  }
  
  public void setScreenDensity(String paramString)
  {
    this.x = paramString;
  }
  
  public void setScreenSize(String paramString)
  {
    this.w = paramString;
  }
  
  public void setSlotId(String paramString)
  {
    this.v = paramString;
  }
  
  public void updateInfo(String paramString, AdRequest paramAdRequest)
  {
    label78:
    for (;;)
    {
      try
      {
        a(paramAdRequest);
        h();
        i(paramString);
        if (paramAdRequest != null)
        {
          b(false);
          if (!c()) {
            break label78;
          }
          if (paramAdRequest.getCurrentLocation() != null)
          {
            a(paramAdRequest.getCurrentLocation());
            b(true);
          }
        }
        else
        {
          return;
        }
        g();
        if (!d())
        {
          e();
          continue;
          a(true);
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/impl/UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */