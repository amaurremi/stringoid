package com.google.android.gms.cast;

import com.google.android.gms.internal.gi;
import java.util.Locale;
import org.json.JSONObject;

public class MediaTrack$Builder
{
  private final MediaTrack AV;
  
  public MediaTrack$Builder(long paramLong, int paramInt)
  {
    this.AV = new MediaTrack(paramLong, paramInt);
  }
  
  public MediaTrack build()
  {
    return this.AV;
  }
  
  public Builder setContentId(String paramString)
  {
    this.AV.setContentId(paramString);
    return this;
  }
  
  public Builder setContentType(String paramString)
  {
    this.AV.setContentType(paramString);
    return this;
  }
  
  public Builder setCustomData(JSONObject paramJSONObject)
  {
    this.AV.setCustomData(paramJSONObject);
    return this;
  }
  
  public Builder setLanguage(String paramString)
  {
    this.AV.setLanguage(paramString);
    return this;
  }
  
  public Builder setLanguage(Locale paramLocale)
  {
    this.AV.setLanguage(gi.b(paramLocale));
    return this;
  }
  
  public Builder setName(String paramString)
  {
    this.AV.setName(paramString);
    return this;
  }
  
  public Builder setSubtype(int paramInt)
  {
    this.AV.R(paramInt);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/MediaTrack$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */