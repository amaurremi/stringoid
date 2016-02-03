package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.gp;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo
{
  public static final int STREAM_TYPE_BUFFERED = 1;
  public static final int STREAM_TYPE_INVALID = -1;
  public static final int STREAM_TYPE_LIVE = 2;
  public static final int STREAM_TYPE_NONE = 0;
  private final String yi;
  private int yj;
  private String yk;
  private MediaMetadata yl;
  private long ym;
  private JSONObject yn;
  
  MediaInfo(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    this.yi = paramString;
    this.yj = -1;
  }
  
  MediaInfo(JSONObject paramJSONObject)
    throws JSONException
  {
    this.yi = paramJSONObject.getString("contentId");
    Object localObject = paramJSONObject.getString("streamType");
    if ("NONE".equals(localObject)) {
      this.yj = 0;
    }
    for (;;)
    {
      this.yk = paramJSONObject.getString("contentType");
      if (paramJSONObject.has("metadata"))
      {
        localObject = paramJSONObject.getJSONObject("metadata");
        this.yl = new MediaMetadata(((JSONObject)localObject).getInt("metadataType"));
        this.yl.c((JSONObject)localObject);
      }
      this.ym = eo.b(paramJSONObject.optDouble("duration", 0.0D));
      this.yn = paramJSONObject.optJSONObject("customData");
      return;
      if ("BUFFERED".equals(localObject)) {
        this.yj = 1;
      } else if ("LIVE".equals(localObject)) {
        this.yj = 2;
      } else {
        this.yj = -1;
      }
    }
  }
  
  void a(MediaMetadata paramMediaMetadata)
  {
    this.yl = paramMediaMetadata;
  }
  
  void b(JSONObject paramJSONObject)
  {
    this.yn = paramJSONObject;
  }
  
  void dA()
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(this.yi)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    if (TextUtils.isEmpty(this.yk)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    if (this.yj == -1) {
      throw new IllegalArgumentException("a valid stream type must be specified");
    }
  }
  
  public JSONObject dB()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("contentId", this.yi);
        switch (this.yj)
        {
        case 2: 
          localJSONObject.put("streamType", localObject);
          if (this.yk != null) {
            localJSONObject.put("contentType", this.yk);
          }
          if (this.yl != null) {
            localJSONObject.put("metadata", this.yl.dB());
          }
          localJSONObject.put("duration", eo.m(this.ym));
          if (this.yn == null) {
            break label140;
          }
          localJSONObject.put("customData", this.yn);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        return localJSONObject;
      }
      localObject = "LIVE";
      continue;
      String str = "NONE";
      continue;
      label140:
      return localJSONObject;
      str = "BUFFERED";
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    int i;
    int j;
    label51:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (!(paramObject instanceof MediaInfo));
        paramObject = (MediaInfo)paramObject;
        if (this.yn != null) {
          break;
        }
        i = 1;
        if (((MediaInfo)paramObject).yn != null) {
          break label169;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.yn == null) || (((MediaInfo)paramObject).yn == null)) {
        break;
      }
      bool1 = bool3;
    } while (!gp.d(this.yn, ((MediaInfo)paramObject).yn));
    if ((eo.a(this.yi, ((MediaInfo)paramObject).yi)) && (this.yj == ((MediaInfo)paramObject).yj) && (eo.a(this.yk, ((MediaInfo)paramObject).yk)) && (eo.a(this.yl, ((MediaInfo)paramObject).yl)) && (this.ym == ((MediaInfo)paramObject).ym)) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label169:
      j = 0;
      break label51;
    }
  }
  
  public String getContentId()
  {
    return this.yi;
  }
  
  public String getContentType()
  {
    return this.yk;
  }
  
  public JSONObject getCustomData()
  {
    return this.yn;
  }
  
  public MediaMetadata getMetadata()
  {
    return this.yl;
  }
  
  public long getStreamDuration()
  {
    return this.ym;
  }
  
  public int getStreamType()
  {
    return this.yj;
  }
  
  public int hashCode()
  {
    return fo.hashCode(new Object[] { this.yi, Integer.valueOf(this.yj), this.yk, this.yl, Long.valueOf(this.ym), String.valueOf(this.yn) });
  }
  
  void k(long paramLong)
    throws IllegalArgumentException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Stream duration cannot be negative");
    }
    this.ym = paramLong;
  }
  
  void setContentType(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    this.yk = paramString;
  }
  
  void setStreamType(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt < -1) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid stream type");
    }
    this.yj = paramInt;
  }
  
  public static class Builder
  {
    private final MediaInfo yo;
    
    public Builder(String paramString)
      throws IllegalArgumentException
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("Content ID cannot be empty");
      }
      this.yo = new MediaInfo(paramString);
    }
    
    public MediaInfo build()
      throws IllegalArgumentException
    {
      this.yo.dA();
      return this.yo;
    }
    
    public Builder setContentType(String paramString)
      throws IllegalArgumentException
    {
      this.yo.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.yo.b(paramJSONObject);
      return this;
    }
    
    public Builder setMetadata(MediaMetadata paramMediaMetadata)
    {
      this.yo.a(paramMediaMetadata);
      return this;
    }
    
    public Builder setStreamDuration(long paramLong)
      throws IllegalArgumentException
    {
      this.yo.k(paramLong);
      return this;
    }
    
    public Builder setStreamType(int paramInt)
      throws IllegalArgumentException
    {
      this.yo.setStreamType(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/cast/MediaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */