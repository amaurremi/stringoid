package com.inmobi.androidsdk;

import android.location.Location;
import android.util.Log;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class IMAdRequest
{
  private boolean a = true;
  private Location b = null;
  private String c = null;
  private boolean d = false;
  private String e = null;
  private String f = null;
  private Calendar g = null;
  private GenderType h;
  private String i = null;
  private String j = null;
  private int k = 0;
  private EducationType l;
  private EthnicityType m;
  private int n = 0;
  private String o = null;
  private Map<String, String> p = null;
  private Map<IMIDType, String> q = new HashMap();
  
  public void addIDType(IMIDType paramIMIDType, String paramString)
  {
    if ((this.q != null) && (paramString != null) && (!"".equals(paramString)))
    {
      this.q.put(paramIMIDType, paramString);
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "IMID type invalid");
  }
  
  public int getAge()
  {
    return this.n;
  }
  
  public String getAreaCode()
  {
    return this.f;
  }
  
  public Location getCurrentLocation()
  {
    return this.b;
  }
  
  public Calendar getDateOfBirth()
  {
    return this.g;
  }
  
  public EducationType getEducation()
  {
    return this.l;
  }
  
  public EthnicityType getEthnicity()
  {
    return this.m;
  }
  
  public GenderType getGender()
  {
    return this.h;
  }
  
  public String getIDType(IMIDType paramIMIDType)
  {
    if (this.q != null) {
      return (String)this.q.get(paramIMIDType);
    }
    return null;
  }
  
  public int getIncome()
  {
    return this.k;
  }
  
  public String getInterests()
  {
    return this.o;
  }
  
  public String getKeywords()
  {
    return this.i;
  }
  
  public String getLocationWithCityStateCountry()
  {
    return this.c;
  }
  
  public String getPostalCode()
  {
    return this.e;
  }
  
  public Map<String, String> getRequestParams()
  {
    return this.p;
  }
  
  public String getSearchString()
  {
    return this.j;
  }
  
  public boolean isLocationInquiryAllowed()
  {
    return this.a;
  }
  
  @Deprecated
  public boolean isTestMode()
  {
    return this.d;
  }
  
  public void removeIDType(IMIDType paramIMIDType)
  {
    if (this.q != null) {
      this.q.remove(paramIMIDType);
    }
  }
  
  public void setAge(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.n = paramInt;
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "Age is invalid");
  }
  
  public void setAreaCode(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      this.f = paramString;
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "Area code is invalid");
  }
  
  public void setCurrentLocation(Location paramLocation)
  {
    if (paramLocation != null)
    {
      this.b = paramLocation;
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "Current location is invalid");
  }
  
  public void setDateOfBirth(Calendar paramCalendar)
  {
    if (paramCalendar != null)
    {
      this.g = paramCalendar;
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "Date of birth is invalid");
  }
  
  public void setDateOfBirth(Date paramDate)
  {
    if (this.g == null) {
      this.g = Calendar.getInstance();
    }
    this.g.setTime(paramDate);
  }
  
  public void setEducation(EducationType paramEducationType)
  {
    this.l = paramEducationType;
  }
  
  public void setEthnicity(EthnicityType paramEthnicityType)
  {
    this.m = paramEthnicityType;
  }
  
  public void setGender(GenderType paramGenderType)
  {
    this.h = paramGenderType;
  }
  
  public void setIncome(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setInterests(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      this.o = paramString;
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "searchString is invalid");
  }
  
  public void setKeywords(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      this.i = paramString;
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "Keyword is invalid");
  }
  
  public void setLocationInquiryAllowed(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setLocationWithCityStateCountry(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!"".equals(paramString1))) {
      this.c = paramString1;
    }
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.c = (this.c + "-" + paramString2);
    }
    if ((paramString3 != null) && (!"".equals(paramString3))) {
      this.c = (this.c + "-" + paramString3);
    }
  }
  
  public void setPostalCode(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      this.e = paramString;
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "Postal code is invalid");
  }
  
  public void setRequestParams(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.p = paramMap;
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "Request params invalid");
  }
  
  public void setSearchString(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      this.j = paramString;
      return;
    }
    Log.e("InMobiAndroidSDK_3.7.1", "searchString is invalid");
  }
  
  @Deprecated
  public void setTestMode(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public static enum EducationType
  {
    static
    {
      Edu_HighSchool = new EducationType("Edu_HighSchool", 1);
      Edu_SomeCollege = new EducationType("Edu_SomeCollege", 2);
      Edu_InCollege = new EducationType("Edu_InCollege", 3);
      Edu_BachelorsDegree = new EducationType("Edu_BachelorsDegree", 4);
      Edu_MastersDegree = new EducationType("Edu_MastersDegree", 5);
    }
    
    private EducationType() {}
  }
  
  public static enum ErrorCode
  {
    static
    {
      AD_DOWNLOAD_IN_PROGRESS = new ErrorCode("AD_DOWNLOAD_IN_PROGRESS", 1);
      AD_CLICK_IN_PROGRESS = new ErrorCode("AD_CLICK_IN_PROGRESS", 2);
      AD_FETCH_TIMEOUT = new ErrorCode("AD_FETCH_TIMEOUT", 3);
      AD_RENDERING_TIMEOUT = new ErrorCode("AD_RENDERING_TIMEOUT", 4);
      NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 5);
      INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 6);
      NO_FILL = new ErrorCode("NO_FILL", 7);
    }
    
    private ErrorCode() {}
    
    public int getErrorCode()
    {
      int i = 3;
      if (this == AD_FETCH_TIMEOUT) {
        i = 1;
      }
      if (this == NETWORK_ERROR) {
        i = 2;
      }
      return i;
    }
  }
  
  public static enum EthnicityType
  {
    static
    {
      Eth_Mixed = new EthnicityType("Eth_Mixed", 1);
      Eth_Asian = new EthnicityType("Eth_Asian", 2);
      Eth_Black = new EthnicityType("Eth_Black", 3);
      Eth_Hispanic = new EthnicityType("Eth_Hispanic", 4);
      Eth_NativeAmerican = new EthnicityType("Eth_NativeAmerican", 5);
      Eth_White = new EthnicityType("Eth_White", 6);
    }
    
    private EthnicityType() {}
  }
  
  public static enum GenderType
  {
    static
    {
      MALE = new GenderType("MALE", 1);
    }
    
    private GenderType() {}
  }
  
  public static enum IMIDType
  {
    private IMIDType() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/IMAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */