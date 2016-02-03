package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.in;
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
  private JSONObject AA;
  private long AS;
  private int AT;
  private int AU;
  private String Ar;
  private String At;
  private String Av;
  private String mName;
  
  MediaTrack(long paramLong, int paramInt)
  {
    clear();
    this.AS = paramLong;
    if ((paramInt <= 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid type " + paramInt);
    }
    this.AT = paramInt;
  }
  
  MediaTrack(JSONObject paramJSONObject)
  {
    b(paramJSONObject);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    clear();
    this.AS = paramJSONObject.getLong("trackId");
    String str = paramJSONObject.getString("type");
    if ("TEXT".equals(str))
    {
      this.AT = 1;
      this.At = paramJSONObject.optString("trackContentId", null);
      this.Av = paramJSONObject.optString("trackContentType", null);
      this.mName = paramJSONObject.optString("name", null);
      this.Ar = paramJSONObject.optString("language", null);
      if (!paramJSONObject.has("subtype")) {
        break label276;
      }
      str = paramJSONObject.getString("subtype");
      if (!"SUBTITLES".equals(str)) {
        break label181;
      }
      this.AU = 1;
    }
    for (;;)
    {
      this.AA = paramJSONObject.optJSONObject("customData");
      return;
      if ("AUDIO".equals(str))
      {
        this.AT = 2;
        break;
      }
      if ("VIDEO".equals(str))
      {
        this.AT = 3;
        break;
      }
      throw new JSONException("invalid type: " + str);
      label181:
      if ("CAPTIONS".equals(str))
      {
        this.AU = 2;
      }
      else if ("DESCRIPTIONS".equals(str))
      {
        this.AU = 3;
      }
      else if ("CHAPTERS".equals(str))
      {
        this.AU = 4;
      }
      else if ("METADATA".equals(str))
      {
        this.AU = 5;
      }
      else
      {
        throw new JSONException("invalid subtype: " + str);
        label276:
        this.AU = 0;
      }
    }
  }
  
  private void clear()
  {
    this.AS = 0L;
    this.AT = 0;
    this.At = null;
    this.mName = null;
    this.Ar = null;
    this.AU = -1;
    this.AA = null;
  }
  
  void R(int paramInt)
  {
    if ((paramInt <= -1) || (paramInt > 5)) {
      throw new IllegalArgumentException("invalid subtype " + paramInt);
    }
    if ((paramInt != 0) && (this.AT != 1)) {
      throw new IllegalArgumentException("subtypes are only valid for text tracks");
    }
    this.AU = paramInt;
  }
  
  public JSONObject dZ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trackId", this.AS);
      switch (this.AT)
      {
      case 1: 
        if (this.At != null) {
          localJSONObject.put("trackContentId", this.At);
        }
        if (this.Av != null) {
          localJSONObject.put("trackContentType", this.Av);
        }
        if (this.mName != null) {
          localJSONObject.put("name", this.mName);
        }
        if (!TextUtils.isEmpty(this.Ar)) {
          localJSONObject.put("language", this.Ar);
        }
        switch (this.AU)
        {
        }
        break;
      }
      for (;;)
      {
        if (this.AA == null) {
          break label282;
        }
        localJSONObject.put("customData", this.AA);
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
        if (this.AA != null) {
          break;
        }
        i = 1;
        if (((MediaTrack)paramObject).AA != null) {
          break label194;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.AA == null) || (((MediaTrack)paramObject).AA == null)) {
        break;
      }
      bool1 = bool3;
    } while (!in.d(this.AA, ((MediaTrack)paramObject).AA));
    if ((this.AS == ((MediaTrack)paramObject).AS) && (this.AT == ((MediaTrack)paramObject).AT) && (gi.a(this.At, ((MediaTrack)paramObject).At)) && (gi.a(this.Av, ((MediaTrack)paramObject).Av)) && (gi.a(this.mName, ((MediaTrack)paramObject).mName)) && (gi.a(this.Ar, ((MediaTrack)paramObject).Ar)) && (this.AU == ((MediaTrack)paramObject).AU)) {}
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
    return this.At;
  }
  
  public String getContentType()
  {
    return this.Av;
  }
  
  public JSONObject getCustomData()
  {
    return this.AA;
  }
  
  public long getId()
  {
    return this.AS;
  }
  
  public String getLanguage()
  {
    return this.Ar;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getSubtype()
  {
    return this.AU;
  }
  
  public int getType()
  {
    return this.AT;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Long.valueOf(this.AS), Integer.valueOf(this.AT), this.At, this.Av, this.mName, this.Ar, Integer.valueOf(this.AU), this.AA });
  }
  
  public void setContentId(String paramString)
  {
    this.At = paramString;
  }
  
  public void setContentType(String paramString)
  {
    this.Av = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.AA = paramJSONObject;
  }
  
  void setLanguage(String paramString)
  {
    this.Ar = paramString;
  }
  
  void setName(String paramString)
  {
    this.mName = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/MediaTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */