package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.io;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack
{
  public static final int SUBTYPE_CAPTIONS = 2;
  public static final int SUBTYPE_CHAPTERS = 4;
  public static final int SUBTYPE_DESCRIPTIONS = 3;
  public static final int SUBTYPE_METADATA = 5;
  public static final int SUBTYPE_NONE = 0;
  public static final int SUBTYPE_SUBTITLES = 1;
  public static final int SUBTYPE_UNKNOWN = -1;
  public static final int TYPE_AUDIO = 2;
  public static final int TYPE_TEXT = 1;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_VIDEO = 3;
  private long AP;
  private int AQ;
  private int AR;
  private String Ao;
  private String Aq;
  private String As;
  private JSONObject Ax;
  private String mName;
  
  MediaTrack(long paramLong, int paramInt)
    throws IllegalArgumentException
  {
    clear();
    this.AP = paramLong;
    if ((paramInt <= 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid type " + paramInt);
    }
    this.AQ = paramInt;
  }
  
  MediaTrack(JSONObject paramJSONObject)
    throws JSONException
  {
    b(paramJSONObject);
  }
  
  private void b(JSONObject paramJSONObject)
    throws JSONException
  {
    clear();
    this.AP = paramJSONObject.getLong("trackId");
    String str = paramJSONObject.getString("type");
    if ("TEXT".equals(str))
    {
      this.AQ = 1;
      this.Aq = paramJSONObject.optString("trackContentId", null);
      this.As = paramJSONObject.optString("trackContentType", null);
      this.mName = paramJSONObject.optString("name", null);
      this.Ao = paramJSONObject.optString("language", null);
      if (!paramJSONObject.has("subtype")) {
        break label276;
      }
      str = paramJSONObject.getString("subtype");
      if (!"SUBTITLES".equals(str)) {
        break label181;
      }
      this.AR = 1;
    }
    for (;;)
    {
      this.Ax = paramJSONObject.optJSONObject("customData");
      return;
      if ("AUDIO".equals(str))
      {
        this.AQ = 2;
        break;
      }
      if ("VIDEO".equals(str))
      {
        this.AQ = 3;
        break;
      }
      throw new JSONException("invalid type: " + str);
      label181:
      if ("CAPTIONS".equals(str))
      {
        this.AR = 2;
      }
      else if ("DESCRIPTIONS".equals(str))
      {
        this.AR = 3;
      }
      else if ("CHAPTERS".equals(str))
      {
        this.AR = 4;
      }
      else if ("METADATA".equals(str))
      {
        this.AR = 5;
      }
      else
      {
        throw new JSONException("invalid subtype: " + str);
        label276:
        this.AR = 0;
      }
    }
  }
  
  private void clear()
  {
    this.AP = 0L;
    this.AQ = 0;
    this.Aq = null;
    this.mName = null;
    this.Ao = null;
    this.AR = -1;
    this.Ax = null;
  }
  
  void R(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt <= -1) || (paramInt > 5)) {
      throw new IllegalArgumentException("invalid subtype " + paramInt);
    }
    if ((paramInt != 0) && (this.AQ != 1)) {
      throw new IllegalArgumentException("subtypes are only valid for text tracks");
    }
    this.AR = paramInt;
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trackId", this.AP);
      switch (this.AQ)
      {
      case 1: 
        if (this.Aq != null) {
          localJSONObject.put("trackContentId", this.Aq);
        }
        if (this.As != null) {
          localJSONObject.put("trackContentType", this.As);
        }
        if (this.mName != null) {
          localJSONObject.put("name", this.mName);
        }
        if (!TextUtils.isEmpty(this.Ao)) {
          localJSONObject.put("language", this.Ao);
        }
        switch (this.AR)
        {
        }
        break;
      }
      for (;;)
      {
        if (this.Ax == null) {
          break label282;
        }
        localJSONObject.put("customData", this.Ax);
        return localJSONObject;
        localJSONObject.put("type", "TEXT");
        break;
        localJSONObject.put("type", "AUDIO");
        break;
        localJSONObject.put("type", "VIDEO");
        break;
        localJSONObject.put("subtype", "SUBTITLES");
        continue;
        localJSONObject.put("subtype", "CAPTIONS");
        continue;
        localJSONObject.put("subtype", "DESCRIPTIONS");
        continue;
        localJSONObject.put("subtype", "CHAPTERS");
        continue;
        localJSONObject.put("subtype", "METADATA");
        continue;
        break;
      }
      label282:
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
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
        } while (!(paramObject instanceof MediaTrack));
        paramObject = (MediaTrack)paramObject;
        if (this.Ax != null) {
          break;
        }
        i = 1;
        if (((MediaTrack)paramObject).Ax != null) {
          break label194;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.Ax == null) || (((MediaTrack)paramObject).Ax == null)) {
        break;
      }
      bool1 = bool3;
    } while (!io.d(this.Ax, ((MediaTrack)paramObject).Ax));
    if ((this.AP == ((MediaTrack)paramObject).AP) && (this.AQ == ((MediaTrack)paramObject).AQ) && (gj.a(this.Aq, ((MediaTrack)paramObject).Aq)) && (gj.a(this.As, ((MediaTrack)paramObject).As)) && (gj.a(this.mName, ((MediaTrack)paramObject).mName)) && (gj.a(this.Ao, ((MediaTrack)paramObject).Ao)) && (this.AR == ((MediaTrack)paramObject).AR)) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label194:
      j = 0;
      break label51;
    }
  }
  
  public String getContentId()
  {
    return this.Aq;
  }
  
  public String getContentType()
  {
    return this.As;
  }
  
  public JSONObject getCustomData()
  {
    return this.Ax;
  }
  
  public long getId()
  {
    return this.AP;
  }
  
  public String getLanguage()
  {
    return this.Ao;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getSubtype()
  {
    return this.AR;
  }
  
  public int getType()
  {
    return this.AQ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Long.valueOf(this.AP), Integer.valueOf(this.AQ), this.Aq, this.As, this.mName, this.Ao, Integer.valueOf(this.AR), this.Ax });
  }
  
  public void setContentId(String paramString)
  {
    this.Aq = paramString;
  }
  
  public void setContentType(String paramString)
  {
    this.As = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.Ax = paramJSONObject;
  }
  
  void setLanguage(String paramString)
  {
    this.Ao = paramString;
  }
  
  void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public static class Builder
  {
    private final MediaTrack AS;
    
    public Builder(long paramLong, int paramInt)
      throws IllegalArgumentException
    {
      this.AS = new MediaTrack(paramLong, paramInt);
    }
    
    public MediaTrack build()
    {
      return this.AS;
    }
    
    public Builder setContentId(String paramString)
    {
      this.AS.setContentId(paramString);
      return this;
    }
    
    public Builder setContentType(String paramString)
    {
      this.AS.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.AS.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setLanguage(String paramString)
    {
      this.AS.setLanguage(paramString);
      return this;
    }
    
    public Builder setLanguage(Locale paramLocale)
    {
      this.AS.setLanguage(gj.b(paramLocale));
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.AS.setName(paramString);
      return this;
    }
    
    public Builder setSubtype(int paramInt)
      throws IllegalArgumentException
    {
      this.AS.R(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/cast/MediaTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */