package com.inmobi.commons.data;

import android.app.Activity;
import android.location.Location;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public final class UserInfo
{
  private static UserInfo a = new UserInfo();
  private static int d = 1;
  private boolean b;
  private Activity c;
  private Location e;
  private boolean f = true;
  private String g;
  private EducationType h;
  private EthnicityType i;
  private GenderType j;
  private Calendar k;
  private Integer l = Integer.valueOf(0);
  private Integer m = Integer.valueOf(0);
  private String n;
  private String o;
  private String p;
  private String q;
  private HasChildren r;
  private MaritalStatus s;
  private String t;
  private SexualOrientation u;
  private Map<IMIDType, String> v = new HashMap();
  
  public static UserInfo getInstance()
  {
    return a;
  }
  
  public void addIDType(IMIDType paramIMIDType, String paramString)
  {
    if (this.v != null) {
      this.v.put(paramIMIDType, paramString);
    }
  }
  
  public Integer getAge()
  {
    return this.m;
  }
  
  public String getAreaCode()
  {
    return this.q;
  }
  
  public Location getCurrentLocation()
  {
    return this.e;
  }
  
  public Calendar getDateOfBirth()
  {
    return this.k;
  }
  
  public int getDeviceIDMask()
  {
    return d;
  }
  
  public EducationType getEducation()
  {
    return this.h;
  }
  
  public EthnicityType getEthnicity()
  {
    return this.i;
  }
  
  public GenderType getGender()
  {
    return this.j;
  }
  
  public HasChildren getHasChildren()
  {
    return this.r;
  }
  
  public String getIDType(IMIDType paramIMIDType)
  {
    if (this.v != null) {
      return (String)this.v.get(paramIMIDType);
    }
    return null;
  }
  
  public Integer getIncome()
  {
    return this.l;
  }
  
  public String getInterests()
  {
    return this.n;
  }
  
  public String getLanguage()
  {
    return this.t;
  }
  
  public String getLocationWithCityStateCountry()
  {
    return this.o;
  }
  
  public MaritalStatus getMaritalStatus()
  {
    return this.s;
  }
  
  public String getPostalCode()
  {
    return this.p;
  }
  
  public String getSearchString()
  {
    return this.g;
  }
  
  public SexualOrientation getSexualOrientation()
  {
    return this.u;
  }
  
  public boolean isLocationInquiryAllowed()
  {
    return this.f;
  }
  
  public boolean isTestMode()
  {
    return this.b;
  }
  
  public void removeIDType(IMIDType paramIMIDType)
  {
    if (this.v != null) {
      this.v.remove(paramIMIDType);
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.c = paramActivity;
    DeviceInfo.getInstance().init(this.c);
  }
  
  public void setAge(Integer paramInteger)
  {
    this.m = paramInteger;
  }
  
  public void setAreaCode(String paramString)
  {
    this.q = paramString;
  }
  
  public void setCurrentLocation(Location paramLocation)
  {
    this.e = paramLocation;
  }
  
  public void setDateOfBirth(Calendar paramCalendar)
  {
    this.k = paramCalendar;
  }
  
  public void setDeviceIDMask(int paramInt)
  {
    d = paramInt;
  }
  
  public void setEducation(EducationType paramEducationType)
  {
    this.h = paramEducationType;
  }
  
  public void setEthnicity(EthnicityType paramEthnicityType)
  {
    this.i = paramEthnicityType;
  }
  
  public void setGender(GenderType paramGenderType)
  {
    this.j = paramGenderType;
  }
  
  public void setHasChildren(HasChildren paramHasChildren)
  {
    this.r = paramHasChildren;
  }
  
  public void setIncome(Integer paramInteger)
  {
    this.l = paramInteger;
  }
  
  public void setInterests(String paramString)
  {
    this.n = paramString;
  }
  
  public void setLanguage(String paramString)
  {
    this.t = paramString;
  }
  
  public void setLocationInquiryAllowed(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setLocationWithCityStateCountry(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!"".equals(paramString1.trim()))) {
      this.o = paramString1;
    }
    if ((paramString2 != null) && (!"".equals(paramString2.trim()))) {
      this.o = (this.o + "-" + paramString2);
    }
    if ((paramString3 != null) && (!"".equals(paramString3.trim()))) {
      this.o = (this.o + "-" + paramString3);
    }
  }
  
  public void setMaritalStatus(MaritalStatus paramMaritalStatus)
  {
    this.s = paramMaritalStatus;
  }
  
  public void setPostalCode(String paramString)
  {
    this.p = paramString;
  }
  
  public void setSexualOrientation(SexualOrientation paramSexualOrientation)
  {
    this.u = paramSexualOrientation;
  }
  
  public void setTestMode(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void updateInfo()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new DisplayMetrics();
        this.c.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        float f1 = ((DisplayMetrics)localObject1).density;
        localObject1 = ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay();
        int i1 = (int)(WrapperFunctions.getDisplayWidth((Display)localObject1) / f1);
        int i2 = (int)(WrapperFunctions.getDisplayHeight((Display)localObject1) / f1);
        DeviceInfo.setScreenDensity(String.valueOf(f1));
        DeviceInfo.setScreenSize("" + i1 + "X" + i2);
        DeviceInfo.setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent(this.c.getApplicationContext()));
        DeviceInfo.getInstance().fillDeviceInfo();
        AppInfo.fillAppInfo();
        LocationInfo.b(false);
        if (isLocationInquiryAllowed())
        {
          if (getCurrentLocation() != null)
          {
            LocationInfo.a(getCurrentLocation());
            LocationInfo.b(true);
            return;
          }
          LocationInfo.verifyLocationPermission();
          if (LocationInfo.isLocationDeniedByUser()) {
            continue;
          }
          LocationInfo.updateBestKnownLocation();
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.internal("[InMobi]-4.1.1", "Exception updating user info", localException);
        continue;
      }
      finally {}
      LocationInfo.a(true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/data/UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */