package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.fe;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo
{
  public static final int STREAM_TYPE_BUFFERED = 1;
  public static final int STREAM_TYPE_INVALID = -1;
  public static final int STREAM_TYPE_LIVE = 2;
  public static final int STREAM_TYPE_NONE = 0;
  private final String kH;
  private int kI;
  private String kJ;
  private MediaMetadata kK;
  private long kL;
  private JSONObject kM;
  
  MediaInfo(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    this.kH = paramString;
    this.kI = -1;
  }
  
  MediaInfo(JSONObject paramJSONObject)
    throws JSONException
  {
    this.kH = paramJSONObject.getString("contentId");
    Object localObject = paramJSONObject.getString("streamType");
    if ("NONE".equals(localObject)) {
      this.kI = 0;
    }
    for (;;)
    {
      this.kJ = paramJSONObject.getString("contentType");
      if (paramJSONObject.has("metadata"))
      {
        localObject = paramJSONObject.getJSONObject("metadata");
        this.kK = new MediaMetadata(((JSONObject)localObject).getInt("metadataType"));
        this.kK.b((JSONObject)localObject);
      }
      this.kL = dh.b(paramJSONObject.optDouble("duration", 0.0D));
      this.kM = paramJSONObject.optJSONObject("customData");
      return;
      if ("BUFFERED".equals(localObject)) {
        this.kI = 1;
      } else if ("LIVE".equals(localObject)) {
        this.kI = 2;
      } else {
        this.kI = -1;
      }
    }
  }
  
  void a(MediaMetadata paramMediaMetadata)
  {
    this.kK = paramMediaMetadata;
  }
  
  void a(JSONObject paramJSONObject)
  {
    this.kM = paramJSONObject;
  }
  
  void aO()
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(this.kH)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    if (TextUtils.isEmpty(this.kJ)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    if (this.kI == -1) {
      throw new IllegalArgumentException("a valid stream type must be specified");
    }
  }
  
  public JSONObject aP()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("contentId", this.kH);
        switch (this.kI)
        {
        case 2: 
          localJSONObject.put("streamType", localObject);
          if (this.kJ != null) {
            localJSONObject.put("contentType", this.kJ);
          }
          if (this.kK != null) {
            localJSONObject.put("metadata", this.kK.aP());
          }
          localJSONObject.put("duration", dh.h(this.kL));
          if (this.kM == null) {
            break label140;
          }
          localJSONObject.put("customData", this.kM);
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
        if (this.kM != null) {
          break;
        }
        i = 1;
        if (((MediaInfo)paramObject).kM != null) {
          break label169;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.kM == null) || (((MediaInfo)paramObject).kM == null)) {
        break;
      }
      bool1 = bool3;
    } while (!fe.d(this.kM, ((MediaInfo)paramObject).kM));
    if ((dh.a(this.kH, ((MediaInfo)paramObject).kH)) && (this.kI == ((MediaInfo)paramObject).kI) && (dh.a(this.kJ, ((MediaInfo)paramObject).kJ)) && (dh.a(this.kK, ((MediaInfo)paramObject).kK)) && (this.kL == ((MediaInfo)paramObject).kL)) {}
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
  
  void f(long paramLong)
    throws IllegalArgumentException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Stream duration cannot be negative");
    }
    this.kL = paramLong;
  }
  
  public String getContentId()
  {
    return this.kH;
  }
  
  public String getContentType()
  {
    return this.kJ;
  }
  
  public JSONObject getCustomData()
  {
    return this.kM;
  }
  
  public MediaMetadata getMetadata()
  {
    return this.kK;
  }
  
  public long getStreamDuration()
  {
    return this.kL;
  }
  
  public int getStreamType()
  {
    return this.kI;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { this.kH, Integer.valueOf(this.kI), this.kJ, this.kK, Long.valueOf(this.kL), String.valueOf(this.kM) });
  }
  
  void setContentType(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    this.kJ = paramString;
  }
  
  void setStreamType(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt < -1) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid stream type");
    }
    this.kI = paramInt;
  }
  
  public static class Builder
  {
    private final MediaInfo kN;
    
    public Builder(String paramString)
      throws IllegalArgumentException
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("Content ID cannot be empty");
      }
      this.kN = new MediaInfo(paramString);
    }
    
    public MediaInfo build()
      throws IllegalArgumentException
    {
      this.kN.aO();
      return this.kN;
    }
    
    public Builder setContentType(String paramString)
      throws IllegalArgumentException
    {
      this.kN.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.kN.a(paramJSONObject);
      return this;
    }
    
    public Builder setMetadata(MediaMetadata paramMediaMetadata)
    {
      this.kN.a(paramMediaMetadata);
      return this;
    }
    
    public Builder setStreamDuration(long paramLong)
      throws IllegalArgumentException
    {
      this.kN.f(paramLong);
      return this;
    }
    
    public Builder setStreamType(int paramInt)
      throws IllegalArgumentException
    {
      this.kN.setStreamType(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/cast/MediaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */