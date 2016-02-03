package com.inmobi.androidsdk;

import android.location.Location;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AdRequest
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
  private MaritalStatus q;
  private String r;
  private SexualOrientation s;
  private HasChildren t;
  
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
  
  public HasChildren getHasChildren()
  {
    return this.t;
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
  
  public String getLanguage()
  {
    return this.r;
  }
  
  public String getLocationWithCityStateCountry()
  {
    return this.c;
  }
  
  public MaritalStatus getMaritalStatus()
  {
    return this.q;
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
  
  public SexualOrientation getSexualOrientation()
  {
    return this.s;
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
  
  public void setAge(int paramInt)
  {
    if (paramInt >= 0) {
      this.n = paramInt;
    }
  }
  
  public void setAreaCode(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim()))) {
      this.f = paramString;
    }
  }
  
  public void setCurrentLocation(Location paramLocation)
  {
    if (paramLocation != null) {
      this.b = paramLocation;
    }
  }
  
  public void setDateOfBirth(Calendar paramCalendar)
  {
    if (paramCalendar != null) {
      this.g = paramCalendar;
    }
  }
  
  public void setDateOfBirth(Date paramDate)
  {
    if (paramDate == null) {
      return;
    }
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
  
  public void setHasChildren(HasChildren paramHasChildren)
  {
    this.t = paramHasChildren;
  }
  
  public void setIncome(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setInterests(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim()))) {
      this.o = paramString;
    }
  }
  
  public void setKeywords(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim()))) {
      this.i = paramString;
    }
  }
  
  public void setLanguage(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim()))) {
      this.r = paramString;
    }
  }
  
  public void setLocationInquiryAllowed(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setLocationOfCityStateAndCountry(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim()))) {
      this.c = paramString;
    }
  }
  
  public void setLocationWithCityStateCountry(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!"".equals(paramString1.trim()))) {
      this.c = paramString1;
    }
    if ((paramString2 != null) && (!"".equals(paramString2.trim()))) {
      this.c = (this.c + "-" + paramString2);
    }
    if ((paramString3 != null) && (!"".equals(paramString3.trim()))) {
      this.c = (this.c + "-" + paramString3);
    }
  }
  
  public void setMaritalStatus(MaritalStatus paramMaritalStatus)
  {
    this.q = paramMaritalStatus;
  }
  
  public void setPostalCode(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim()))) {
      this.e = paramString;
    }
  }
  
  public void setRequestParams(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      if (this.p == null) {
        this.p = new HashMap();
      }
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.p.put(str, paramMap.get(str));
      }
    }
  }
  
  public void setSearchString(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim()))) {
      this.j = paramString;
    }
  }
  
  public void setSexualOrientation(SexualOrientation paramSexualOrientation)
  {
    this.s = paramSexualOrientation;
  }
  
  @Deprecated
  public void setTestMode(boolean paramBoolean)
  {
    this.d = paramBoolean;
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
  
  public static enum IMIDType
  {
    private IMIDType() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/AdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */