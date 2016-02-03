package com.adfonic.android.api;

import android.location.Location;
import java.util.List;

public class Request
{
  public static final boolean ALLOW_LOCATION_DEFAULT_VALUE = true;
  public static final boolean REFRESH_DEFAULT_VALUE = true;
  public static final int REFRESH_TIME_DEFAULT_VALUE = 20;
  public static final boolean TEST_MODE_DEFAULT_VALUE = false;
  private float adHeight;
  private float adWidth;
  private int age;
  private int ageHigh;
  private int ageLow;
  private String dateOfBirth;
  private boolean hasGender;
  private boolean isAllowLocation = true;
  private boolean isMale;
  private boolean isRefreshAd = true;
  private boolean isTest;
  private String language;
  private Location location;
  private int refreshTime = 20;
  private String slotId;
  private List<String> tags;
  
  public float getAdHeight()
  {
    return this.adHeight;
  }
  
  public float getAdWidth()
  {
    return this.adWidth;
  }
  
  public int getAge()
  {
    return this.age;
  }
  
  public int getAgeHigh()
  {
    return this.ageHigh;
  }
  
  public int getAgeLow()
  {
    return this.ageLow;
  }
  
  public String getDateOfBirth()
  {
    return this.dateOfBirth;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public Location getLocation()
  {
    return this.location;
  }
  
  public int getRefreshTime()
  {
    return this.refreshTime;
  }
  
  public String getSlotId()
  {
    return this.slotId;
  }
  
  public List<String> getTags()
  {
    return this.tags;
  }
  
  public boolean hasGender()
  {
    return this.hasGender;
  }
  
  public boolean isAllowLocation()
  {
    return this.isAllowLocation;
  }
  
  public boolean isMale()
  {
    return this.isMale;
  }
  
  public boolean isRefreshAd()
  {
    return this.isRefreshAd;
  }
  
  public boolean isTest()
  {
    return this.isTest;
  }
  
  public void setAdHeight(float paramFloat)
  {
    this.adHeight = paramFloat;
  }
  
  public void setAdWidth(float paramFloat)
  {
    this.adWidth = paramFloat;
  }
  
  public void setAge(int paramInt)
  {
    this.age = paramInt;
  }
  
  public void setAgeHigh(int paramInt)
  {
    this.ageHigh = paramInt;
  }
  
  public void setAgeLow(int paramInt)
  {
    this.ageLow = paramInt;
  }
  
  public void setAllowLocation(boolean paramBoolean)
  {
    this.isAllowLocation = paramBoolean;
  }
  
  public void setDateOfBirth(String paramString)
  {
    this.dateOfBirth = paramString;
  }
  
  public void setHasGender(boolean paramBoolean)
  {
    this.hasGender = paramBoolean;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public void setLocation(Location paramLocation)
  {
    this.location = paramLocation;
  }
  
  public void setMale(boolean paramBoolean)
  {
    this.hasGender = true;
    this.isMale = paramBoolean;
  }
  
  public void setRefreshAd(boolean paramBoolean)
  {
    this.isRefreshAd = paramBoolean;
  }
  
  public void setRefreshTime(int paramInt)
  {
    if (paramInt < 20)
    {
      this.refreshTime = 20;
      return;
    }
    if (paramInt > 120)
    {
      this.refreshTime = 120;
      return;
    }
    this.refreshTime = paramInt;
  }
  
  public void setSlotId(String paramString)
  {
    this.slotId = paramString;
  }
  
  public void setTags(List<String> paramList)
  {
    this.tags = paramList;
  }
  
  public void setTest(boolean paramBoolean)
  {
    this.isTest = paramBoolean;
  }
  
  public static class RequestBuilder
  {
    private Request request;
    
    public RequestBuilder()
    {
      this(new Request());
    }
    
    public RequestBuilder(Request paramRequest)
    {
      this.request = paramRequest;
    }
    
    public Request build()
    {
      return this.request;
    }
    
    public RequestBuilder withAge(int paramInt)
    {
      this.request.setAge(paramInt);
      return this;
    }
    
    public RequestBuilder withAgeHigh(int paramInt)
    {
      this.request.setAgeHigh(paramInt);
      return this;
    }
    
    public RequestBuilder withAgeLow(int paramInt)
    {
      this.request.setAgeLow(paramInt);
      return this;
    }
    
    public RequestBuilder withAgeRange(int paramInt1, int paramInt2)
    {
      Request.access$002(this.request, paramInt1);
      Request.access$102(this.request, paramInt2);
      return this;
    }
    
    public RequestBuilder withAllowLocation(boolean paramBoolean)
    {
      this.request.setAllowLocation(paramBoolean);
      return this;
    }
    
    public RequestBuilder withDateOfBirth(String paramString)
    {
      this.request.setDateOfBirth(paramString);
      return this;
    }
    
    public RequestBuilder withIsMale(boolean paramBoolean)
    {
      this.request.setMale(paramBoolean);
      return this;
    }
    
    public RequestBuilder withIsTest(boolean paramBoolean)
    {
      this.request.setMale(paramBoolean);
      return this;
    }
    
    public RequestBuilder withLanguage(String paramString)
    {
      this.request.setLanguage(paramString);
      return this;
    }
    
    public RequestBuilder withLocation(Location paramLocation)
    {
      this.request.setLocation(paramLocation);
      return this;
    }
    
    public RequestBuilder withRefreshAd(boolean paramBoolean)
    {
      this.request.setRefreshAd(paramBoolean);
      return this;
    }
    
    public RequestBuilder withRefreshTime(int paramInt)
    {
      this.request.setRefreshTime(paramInt);
      return this;
    }
    
    public RequestBuilder withSlotId(String paramString)
    {
      this.request.setSlotId(paramString);
      return this;
    }
    
    public RequestBuilder withTags(List<String> paramList)
    {
      this.request.setTags(paramList);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */