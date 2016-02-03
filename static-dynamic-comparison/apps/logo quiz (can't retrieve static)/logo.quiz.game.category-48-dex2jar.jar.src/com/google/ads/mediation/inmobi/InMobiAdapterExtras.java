package com.google.ads.mediation.inmobi;

import com.google.ads.mediation.NetworkExtras;
import com.inmobi.androidsdk.IMAdRequest.EducationType;
import com.inmobi.androidsdk.IMAdRequest.EthnicityType;
import com.inmobi.androidsdk.IMAdRequest.IMIDType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class InMobiAdapterExtras
  implements NetworkExtras
{
  private String areaCode = null;
  private IMAdRequest.EducationType education = null;
  private IMAdRequest.EthnicityType ethnicity = null;
  private Map<IMAdRequest.IMIDType, String> idtypeParams = new HashMap();
  private Integer income = null;
  private Set<String> interests = null;
  private boolean isLocationInquiryAllowed = true;
  private String keywords = null;
  private String postalCode = null;
  private Map<String, String> requestParams;
  private String searchString = null;
  private int uidMapFlag;
  
  public void addIDType(IMAdRequest.IMIDType paramIMIDType, String paramString)
  {
    if (this.idtypeParams != null) {
      this.idtypeParams.put(paramIMIDType, paramString);
    }
  }
  
  public void addInterests(String paramString)
  {
    if (this.interests == null) {
      this.interests = new HashSet();
    }
    this.interests.add(paramString);
  }
  
  public InMobiAdapterExtras clearAreaCode()
  {
    return setAreaCode(null);
  }
  
  public InMobiAdapterExtras clearDeviceIdMask()
  {
    setDeviceIDMask(1);
    return this;
  }
  
  public InMobiAdapterExtras clearEducation()
  {
    return setEducation(null);
  }
  
  public InMobiAdapterExtras clearEthnicity()
  {
    return setEthnicity(null);
  }
  
  public InMobiAdapterExtras clearIncome()
  {
    return setIncome(null);
  }
  
  public InMobiAdapterExtras clearInterests()
  {
    return setInterests(null);
  }
  
  public InMobiAdapterExtras clearKeywords()
  {
    return setKeywords(null);
  }
  
  public InMobiAdapterExtras clearLocationInquiryAllowed()
  {
    setLocationInquiryAllowed(false);
    return this;
  }
  
  public InMobiAdapterExtras clearPostalCode()
  {
    return setPostalCode(null);
  }
  
  public InMobiAdapterExtras clearRequestParams()
  {
    return setRequestParams(null);
  }
  
  public InMobiAdapterExtras clearSearchString()
  {
    return setSearchString(null);
  }
  
  public String getAreaCode()
  {
    return this.areaCode;
  }
  
  public int getDeviceIdMask()
  {
    return this.uidMapFlag;
  }
  
  public IMAdRequest.EducationType getEducation()
  {
    return this.education;
  }
  
  public IMAdRequest.EthnicityType getEthnicity()
  {
    return this.ethnicity;
  }
  
  public String getIDType(IMAdRequest.IMIDType paramIMIDType)
  {
    if (this.idtypeParams != null) {
      return (String)this.idtypeParams.get(paramIMIDType);
    }
    return null;
  }
  
  public Integer getIncome()
  {
    return this.income;
  }
  
  public Set<String> getInterests()
  {
    if (this.interests == null) {
      return null;
    }
    return Collections.unmodifiableSet(this.interests);
  }
  
  public String getKeywords()
  {
    return this.keywords;
  }
  
  public String getPostalCode()
  {
    return this.postalCode;
  }
  
  public Map<String, String> getRequestParams()
  {
    return this.requestParams;
  }
  
  public String getSearchString()
  {
    return this.searchString;
  }
  
  public boolean isLocationInquiryAllowed()
  {
    return this.isLocationInquiryAllowed;
  }
  
  public void removeIDType(IMAdRequest.IMIDType paramIMIDType)
  {
    if (this.idtypeParams != null) {
      this.idtypeParams.remove(paramIMIDType);
    }
  }
  
  public InMobiAdapterExtras setAreaCode(String paramString)
  {
    this.areaCode = paramString;
    return this;
  }
  
  public void setDeviceIDMask(int paramInt)
  {
    this.uidMapFlag = paramInt;
  }
  
  public InMobiAdapterExtras setEducation(IMAdRequest.EducationType paramEducationType)
  {
    this.education = paramEducationType;
    return this;
  }
  
  public InMobiAdapterExtras setEthnicity(IMAdRequest.EthnicityType paramEthnicityType)
  {
    this.ethnicity = paramEthnicityType;
    return this;
  }
  
  public InMobiAdapterExtras setIncome(Integer paramInteger)
  {
    this.income = paramInteger;
    return this;
  }
  
  public InMobiAdapterExtras setInterests(Collection<String> paramCollection)
  {
    if (paramCollection == null)
    {
      this.interests = new HashSet();
      return this;
    }
    this.interests = new HashSet(paramCollection);
    return this;
  }
  
  public InMobiAdapterExtras setKeywords(String paramString)
  {
    this.keywords = paramString;
    return this;
  }
  
  public void setLocationInquiryAllowed(boolean paramBoolean)
  {
    this.isLocationInquiryAllowed = paramBoolean;
  }
  
  public InMobiAdapterExtras setPostalCode(String paramString)
  {
    this.postalCode = paramString;
    return this;
  }
  
  public InMobiAdapterExtras setRequestParams(Map<String, String> paramMap)
  {
    this.requestParams = paramMap;
    return this;
  }
  
  public InMobiAdapterExtras setSearchString(String paramString)
  {
    this.searchString = paramString;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/ads/mediation/inmobi/InMobiAdapterExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */