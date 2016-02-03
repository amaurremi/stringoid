package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.in;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo
{
  public static final int STREAM_TYPE_BUFFERED = 1;
  public static final int STREAM_TYPE_INVALID = -1;
  public static final int STREAM_TYPE_LIVE = 2;
  public static final int STREAM_TYPE_NONE = 0;
  private JSONObject AA;
  private final String At;
  private int Au;
  private String Av;
  private MediaMetadata Aw;
  private long Ax;
  private List<MediaTrack> Ay;
  private TextTrackStyle Az;
  
  MediaInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    this.At = paramString;
    this.Au = -1;
  }
  
  MediaInfo(JSONObject paramJSONObject)
  {
    this.At = paramJSONObject.getString("contentId");
    Object localObject1 = paramJSONObject.getString("streamType");
    if ("NONE".equals(localObject1)) {
      this.Au = 0;
    }
    Object localObject2;
    for (;;)
    {
      this.Av = paramJSONObject.getString("contentType");
      if (paramJSONObject.has("metadata"))
      {
        localObject1 = paramJSONObject.getJSONObject("metadata");
        this.Aw = new MediaMetadata(((JSONObject)localObject1).getInt("metadataType"));
        this.Aw.b((JSONObject)localObject1);
      }
      this.Ax = gi.b(paramJSONObject.optDouble("duration", 0.0D));
      if (!paramJSONObject.has("tracks")) {
        break;
      }
      this.Ay = new ArrayList();
      localObject1 = paramJSONObject.getJSONArray("tracks");
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = new MediaTrack(((JSONArray)localObject1).getJSONObject(i));
        this.Ay.add(localObject2);
        i += 1;
      }
      if ("BUFFERED".equals(localObject1)) {
        this.Au = 1;
      } else if ("LIVE".equals(localObject1)) {
        this.Au = 2;
      } else {
        this.Au = -1;
      }
    }
    this.Ay = null;
    if (paramJSONObject.has("textTrackStyle"))
    {
      localObject1 = paramJSONObject.getJSONObject("textTrackStyle");
      localObject2 = new TextTrackStyle();
      ((TextTrackStyle)localObject2).b((JSONObject)localObject1);
    }
    for (this.Az = ((TextTrackStyle)localObject2);; this.Az = null)
    {
      this.AA = paramJSONObject.optJSONObject("customData");
      return;
    }
  }
  
  void a(MediaMetadata paramMediaMetadata)
  {
    this.Aw = paramMediaMetadata;
  }
  
  void b(List<MediaTrack> paramList)
  {
    this.Ay = paramList;
  }
  
  void dY()
  {
    if (TextUtils.isEmpty(this.At)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    if (TextUtils.isEmpty(this.Av)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    if (this.Au == -1) {
      throw new IllegalArgumentException("a valid stream type must be specified");
    }
  }
  
  public JSONObject dZ()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("contentId", this.At);
        switch (this.Au)
        {
        default: 
          localJSONObject.put("streamType", localObject);
          if (this.Av != null) {
            localJSONObject.put("contentType", this.Av);
          }
          if (this.Aw != null) {
            localJSONObject.put("metadata", this.Aw.dZ());
          }
          localJSONObject.put("duration", gi.o(this.Ax));
          if (this.Ay != null)
          {
            localObject = new JSONArray();
            Iterator localIterator = this.Ay.iterator();
            if (localIterator.hasNext())
            {
              ((JSONArray)localObject).put(((MediaTrack)localIterator.next()).dZ());
              continue;
            }
            localJSONObject.put("tracks", localObject);
          }
          if (this.Az != null) {
            localJSONObject.put("textTrackStyle", this.Az.dZ());
          }
          if (this.AA == null) {
            break label215;
          }
          localJSONObject.put("customData", this.AA);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException) {}
      Object localObject = "NONE";
      continue;
      label215:
      return localJSONObject;
      String str = "BUFFERED";
      continue;
      str = "LIVE";
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
        if (this.AA != null) {
          break;
        }
        i = 1;
        if (((MediaInfo)paramObject).AA != null) {
          break label169;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.AA == null) || (((MediaInfo)paramObject).AA == null)) {
        break;
      }
      bool1 = bool3;
    } while (!in.d(this.AA, ((MediaInfo)paramObject).AA));
    if ((gi.a(this.At, ((MediaInfo)paramObject).At)) && (this.Au == ((MediaInfo)paramObject).Au) && (gi.a(this.Av, ((MediaInfo)paramObject).Av)) && (gi.a(this.Aw, ((MediaInfo)paramObject).Aw)) && (this.Ax == ((MediaInfo)paramObject).Ax)) {}
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
  
  public List<MediaTrack> getMediaTracks()
  {
    return this.Ay;
  }
  
  public MediaMetadata getMetadata()
  {
    return this.Aw;
  }
  
  public long getStreamDuration()
  {
    return this.Ax;
  }
  
  public int getStreamType()
  {
    return this.Au;
  }
  
  public TextTrackStyle getTextTrackStyle()
  {
    return this.Az;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { this.At, Integer.valueOf(this.Au), this.Av, this.Aw, Long.valueOf(this.Ax), String.valueOf(this.AA) });
  }
  
  void m(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Stream duration cannot be negative");
    }
    this.Ax = paramLong;
  }
  
  void setContentType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    this.Av = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.AA = paramJSONObject;
  }
  
  void setStreamType(int paramInt)
  {
    if ((paramInt < -1) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid stream type");
    }
    this.Au = paramInt;
  }
  
  public void setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
  {
    this.Az = paramTextTrackStyle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/MediaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */