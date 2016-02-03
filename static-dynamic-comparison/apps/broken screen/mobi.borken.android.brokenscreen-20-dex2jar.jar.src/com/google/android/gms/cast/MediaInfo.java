package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.io;
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
  private final String Aq;
  private int Ar;
  private String As;
  private MediaMetadata At;
  private long Au;
  private List<MediaTrack> Av;
  private TextTrackStyle Aw;
  private JSONObject Ax;
  
  MediaInfo(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    this.Aq = paramString;
    this.Ar = -1;
  }
  
  MediaInfo(JSONObject paramJSONObject)
    throws JSONException
  {
    this.Aq = paramJSONObject.getString("contentId");
    Object localObject1 = paramJSONObject.getString("streamType");
    if ("NONE".equals(localObject1)) {
      this.Ar = 0;
    }
    Object localObject2;
    for (;;)
    {
      this.As = paramJSONObject.getString("contentType");
      if (paramJSONObject.has("metadata"))
      {
        localObject1 = paramJSONObject.getJSONObject("metadata");
        this.At = new MediaMetadata(((JSONObject)localObject1).getInt("metadataType"));
        this.At.b((JSONObject)localObject1);
      }
      this.Au = gj.b(paramJSONObject.optDouble("duration", 0.0D));
      if (!paramJSONObject.has("tracks")) {
        break;
      }
      this.Av = new ArrayList();
      localObject1 = paramJSONObject.getJSONArray("tracks");
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = new MediaTrack(((JSONArray)localObject1).getJSONObject(i));
        this.Av.add(localObject2);
        i += 1;
      }
      if ("BUFFERED".equals(localObject1)) {
        this.Ar = 1;
      } else if ("LIVE".equals(localObject1)) {
        this.Ar = 2;
      } else {
        this.Ar = -1;
      }
    }
    this.Av = null;
    if (paramJSONObject.has("textTrackStyle"))
    {
      localObject1 = paramJSONObject.getJSONObject("textTrackStyle");
      localObject2 = new TextTrackStyle();
      ((TextTrackStyle)localObject2).b((JSONObject)localObject1);
    }
    for (this.Aw = ((TextTrackStyle)localObject2);; this.Aw = null)
    {
      this.Ax = paramJSONObject.optJSONObject("customData");
      return;
    }
  }
  
  void a(MediaMetadata paramMediaMetadata)
  {
    this.At = paramMediaMetadata;
  }
  
  void b(List<MediaTrack> paramList)
  {
    this.Av = paramList;
  }
  
  void dT()
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(this.Aq)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    if (TextUtils.isEmpty(this.As)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    if (this.Ar == -1) {
      throw new IllegalArgumentException("a valid stream type must be specified");
    }
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("contentId", this.Aq);
        switch (this.Ar)
        {
        default: 
          localJSONObject.put("streamType", localObject);
          if (this.As != null) {
            localJSONObject.put("contentType", this.As);
          }
          if (this.At != null) {
            localJSONObject.put("metadata", this.At.dU());
          }
          localJSONObject.put("duration", gj.o(this.Au));
          if (this.Av != null)
          {
            localObject = new JSONArray();
            Iterator localIterator = this.Av.iterator();
            if (localIterator.hasNext())
            {
              ((JSONArray)localObject).put(((MediaTrack)localIterator.next()).dU());
              continue;
            }
            localJSONObject.put("tracks", localObject);
          }
          if (this.Aw != null) {
            localJSONObject.put("textTrackStyle", this.Aw.dU());
          }
          if (this.Ax == null) {
            break label215;
          }
          localJSONObject.put("customData", this.Ax);
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
        if (this.Ax != null) {
          break;
        }
        i = 1;
        if (((MediaInfo)paramObject).Ax != null) {
          break label169;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.Ax == null) || (((MediaInfo)paramObject).Ax == null)) {
        break;
      }
      bool1 = bool3;
    } while (!io.d(this.Ax, ((MediaInfo)paramObject).Ax));
    if ((gj.a(this.Aq, ((MediaInfo)paramObject).Aq)) && (this.Ar == ((MediaInfo)paramObject).Ar) && (gj.a(this.As, ((MediaInfo)paramObject).As)) && (gj.a(this.At, ((MediaInfo)paramObject).At)) && (this.Au == ((MediaInfo)paramObject).Au)) {}
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
  
  public List<MediaTrack> getMediaTracks()
  {
    return this.Av;
  }
  
  public MediaMetadata getMetadata()
  {
    return this.At;
  }
  
  public long getStreamDuration()
  {
    return this.Au;
  }
  
  public int getStreamType()
  {
    return this.Ar;
  }
  
  public TextTrackStyle getTextTrackStyle()
  {
    return this.Aw;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.Aq, Integer.valueOf(this.Ar), this.As, this.At, Long.valueOf(this.Au), String.valueOf(this.Ax) });
  }
  
  void m(long paramLong)
    throws IllegalArgumentException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Stream duration cannot be negative");
    }
    this.Au = paramLong;
  }
  
  void setContentType(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    this.As = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.Ax = paramJSONObject;
  }
  
  void setStreamType(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt < -1) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid stream type");
    }
    this.Ar = paramInt;
  }
  
  public void setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
  {
    this.Aw = paramTextTrackStyle;
  }
  
  public static class Builder
  {
    private final MediaInfo Ay;
    
    public Builder(String paramString)
      throws IllegalArgumentException
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("Content ID cannot be empty");
      }
      this.Ay = new MediaInfo(paramString);
    }
    
    public MediaInfo build()
      throws IllegalArgumentException
    {
      this.Ay.dT();
      return this.Ay;
    }
    
    public Builder setContentType(String paramString)
      throws IllegalArgumentException
    {
      this.Ay.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.Ay.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setMediaTracks(List<MediaTrack> paramList)
    {
      this.Ay.b(paramList);
      return this;
    }
    
    public Builder setMetadata(MediaMetadata paramMediaMetadata)
    {
      this.Ay.a(paramMediaMetadata);
      return this;
    }
    
    public Builder setStreamDuration(long paramLong)
      throws IllegalArgumentException
    {
      this.Ay.m(paramLong);
      return this;
    }
    
    public Builder setStreamType(int paramInt)
      throws IllegalArgumentException
    {
      this.Ay.setStreamType(paramInt);
      return this;
    }
    
    public Builder setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
    {
      this.Ay.setTextTrackStyle(paramTextTrackStyle);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/cast/MediaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */