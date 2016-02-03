package com.google.ads.mediation.adfonic.util;

import com.adfonic.android.api.Request;
import com.adfonic.android.api.Request.RequestBuilder;
import com.google.ads.AdRequest.Gender;
import com.google.ads.mediation.MediationAdRequest;
import java.text.SimpleDateFormat;

public class RequestHelper
{
  private void setAge(Request paramRequest, MediationAdRequest paramMediationAdRequest)
  {
    try
    {
      int i = paramMediationAdRequest.getAgeInYears().intValue();
      if (i > 0) {
        paramRequest.setAge(i);
      }
      return;
    }
    catch (Exception paramRequest) {}
  }
  
  private void setBirthday(Request paramRequest, MediationAdRequest paramMediationAdRequest)
  {
    paramMediationAdRequest = paramMediationAdRequest.getBirthday();
    if (paramMediationAdRequest == null) {
      return;
    }
    paramRequest.setDateOfBirth(new SimpleDateFormat("yyyyMMdd").format(paramMediationAdRequest));
  }
  
  private void setGender(Request paramRequest, MediationAdRequest paramMediationAdRequest)
  {
    paramMediationAdRequest = paramMediationAdRequest.getGender();
    if (AdRequest.Gender.MALE == paramMediationAdRequest)
    {
      paramRequest.setMale(true);
      return;
    }
    paramRequest.setMale(false);
  }
  
  private void setIsTesting(Request paramRequest, MediationAdRequest paramMediationAdRequest)
  {
    paramRequest.setTest(paramMediationAdRequest.isTesting());
  }
  
  private void setLocation(Request paramRequest, MediationAdRequest paramMediationAdRequest)
  {
    if (paramMediationAdRequest.getLocation() != null) {
      paramRequest.setLocation(paramMediationAdRequest.getLocation());
    }
  }
  
  public Request createRequest(String paramString, MediationAdRequest paramMediationAdRequest)
  {
    paramString = new Request.RequestBuilder().withSlotId(paramString).withRefreshAd(false).build();
    if (paramMediationAdRequest == null) {
      return paramString;
    }
    setAge(paramString, paramMediationAdRequest);
    setBirthday(paramString, paramMediationAdRequest);
    setLocation(paramString, paramMediationAdRequest);
    setGender(paramString, paramMediationAdRequest);
    setIsTesting(paramString, paramMediationAdRequest);
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/mediation/adfonic/util/RequestHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */