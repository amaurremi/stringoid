package com.google.android.gms.cast;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

public class MediaInfo$Builder
{
  private final MediaInfo AB;
  
  public MediaInfo$Builder(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Content ID cannot be empty");
    }
    this.AB = new MediaInfo(paramString);
  }
  
  public MediaInfo build()
  {
    this.AB.dY();
    return this.AB;
  }
  
  public Builder setContentType(String paramString)
  {
    this.AB.setContentType(paramString);
    return this;
  }
  
  public Builder setCustomData(JSONObject paramJSONObject)
  {
    this.AB.setCustomData(paramJSONObject);
    return this;
  }
  
  public Builder setMediaTracks(List<MediaTrack> paramList)
  {
    this.AB.b(paramList);
    return this;
  }
  
  public Builder setMetadata(MediaMetadata paramMediaMetadata)
  {
    this.AB.a(paramMediaMetadata);
    return this;
  }
  
  public Builder setStreamDuration(long paramLong)
  {
    this.AB.m(paramLong);
    return this;
  }
  
  public Builder setStreamType(int paramInt)
  {
    this.AB.setStreamType(paramInt);
    return this;
  }
  
  public Builder setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
  {
    this.AB.setTextTrackStyle(paramTextTrackStyle);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/MediaInfo$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */