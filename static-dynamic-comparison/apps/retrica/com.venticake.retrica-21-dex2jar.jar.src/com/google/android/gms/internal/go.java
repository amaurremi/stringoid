package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class go
  extends gg
{
  private static final long Cp = TimeUnit.HOURS.toMillis(24L);
  private static final long Cq = TimeUnit.HOURS.toMillis(24L);
  private static final long Cr = TimeUnit.HOURS.toMillis(24L);
  private static final long Cs = TimeUnit.SECONDS.toMillis(1L);
  private static final String NAMESPACE = gi.al("com.google.cast.media");
  private final gr CA;
  private final gr CB;
  private final gr CC;
  private final gr CD;
  private final gr CE;
  private final List<gr> CF = new ArrayList();
  private final Runnable CG = new ol(this, null);
  private boolean CH;
  private long Ct;
  private MediaStatus Cu;
  private final gr Cv = new gr(Cq);
  private final gr Cw;
  private final gr Cx;
  private final gr Cy;
  private final gr Cz;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  
  public go()
  {
    this(null);
  }
  
  public go(String paramString)
  {
    super(NAMESPACE, "MediaControlChannel", paramString);
    this.CF.add(this.Cv);
    this.Cw = new gr(Cp);
    this.CF.add(this.Cw);
    this.Cx = new gr(Cp);
    this.CF.add(this.Cx);
    this.Cy = new gr(Cp);
    this.CF.add(this.Cy);
    this.Cz = new gr(Cr);
    this.CF.add(this.Cz);
    this.CA = new gr(Cp);
    this.CF.add(this.CA);
    this.CB = new gr(Cp);
    this.CF.add(this.CB);
    this.CC = new gr(Cp);
    this.CF.add(this.CC);
    this.CD = new gr(Cp);
    this.CF.add(this.CD);
    this.CE = new gr(Cp);
    this.CF.add(this.CE);
    et();
  }
  
  private void a(long paramLong, JSONObject paramJSONObject)
  {
    int k = 1;
    boolean bool = this.Cv.p(paramLong);
    int j;
    if ((this.Cz.ev()) && (!this.Cz.p(paramLong)))
    {
      i = 1;
      if (this.CA.ev())
      {
        j = k;
        if (!this.CA.p(paramLong)) {}
      }
      else
      {
        if ((!this.CB.ev()) || (this.CB.p(paramLong))) {
          break label235;
        }
        j = k;
      }
      label87:
      if (i == 0) {
        break label257;
      }
    }
    label235:
    label257:
    for (int i = 2;; i = 0)
    {
      k = i;
      if (j != 0) {
        k = i | 0x1;
      }
      if ((bool) || (this.Cu == null))
      {
        this.Cu = new MediaStatus(paramJSONObject);
        this.Ct = SystemClock.elapsedRealtime();
      }
      for (i = 7;; i = this.Cu.a(paramJSONObject, k))
      {
        if ((i & 0x1) != 0)
        {
          this.Ct = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((i & 0x2) != 0)
        {
          this.Ct = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((i & 0x4) != 0) {
          onMetadataUpdated();
        }
        paramJSONObject = this.CF.iterator();
        while (paramJSONObject.hasNext()) {
          ((gr)paramJSONObject.next()).c(paramLong, 0);
        }
        i = 0;
        break;
        j = 0;
        break label87;
      }
      return;
    }
  }
  
  private void et()
  {
    z(false);
    this.Ct = 0L;
    this.Cu = null;
    this.Cv.clear();
    this.Cz.clear();
    this.CA.clear();
  }
  
  private void z(boolean paramBoolean)
  {
    if (this.CH != paramBoolean)
    {
      this.CH = paramBoolean;
      if (paramBoolean) {
        this.mHandler.postDelayed(this.CG, Cs);
      }
    }
    else
    {
      return;
    }
    this.mHandler.removeCallbacks(this.CG);
  }
  
  public long a(gq paramgq)
  {
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.CC.a(l, paramgq);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "GET_STATUS");
      if (this.Cu != null) {
        localJSONObject.put("mediaSessionId", this.Cu.ea());
      }
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException paramgq)
    {
      for (;;) {}
    }
  }
  
  public long a(gq paramgq, double paramDouble, JSONObject paramJSONObject)
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.CA.a(l, paramgq);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SET_VOLUME");
      localJSONObject.put("mediaSessionId", ea());
      paramgq = new JSONObject();
      paramgq.put("level", paramDouble);
      localJSONObject.put("volume", paramgq);
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgq)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gq paramgq, long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.Cz.a(l, paramgq);
    z(true);
    for (;;)
    {
      try
      {
        localJSONObject.put("requestId", l);
        localJSONObject.put("type", "SEEK");
        localJSONObject.put("mediaSessionId", ea());
        localJSONObject.put("currentTime", gi.o(paramLong));
        if (paramInt != 1) {
          continue;
        }
        localJSONObject.put("resumeState", "PLAYBACK_START");
        if (paramJSONObject != null) {
          localJSONObject.put("customData", paramJSONObject);
        }
      }
      catch (JSONException paramgq)
      {
        continue;
      }
      a(localJSONObject.toString(), l, null);
      return l;
      if (paramInt == 2) {
        localJSONObject.put("resumeState", "PLAYBACK_PAUSE");
      }
    }
  }
  
  public long a(gq paramgq, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.Cv.a(l, paramgq);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "LOAD");
      localJSONObject.put("media", paramMediaInfo.dZ());
      localJSONObject.put("autoplay", paramBoolean);
      localJSONObject.put("currentTime", gi.o(paramLong));
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgq)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gq paramgq, TextTrackStyle paramTextTrackStyle)
  {
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.CE.a(l, paramgq);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      if (paramTextTrackStyle != null) {
        localJSONObject.put("textTrackStyle", paramTextTrackStyle.dZ());
      }
      localJSONObject.put("mediaSessionId", ea());
    }
    catch (JSONException paramgq)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gq paramgq, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.Cw.a(l, paramgq);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PAUSE");
      localJSONObject.put("mediaSessionId", ea());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgq)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gq paramgq, boolean paramBoolean, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.CB.a(l, paramgq);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SET_VOLUME");
      localJSONObject.put("mediaSessionId", ea());
      paramgq = new JSONObject();
      paramgq.put("muted", paramBoolean);
      localJSONObject.put("volume", paramgq);
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgq)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gq paramgq, long[] paramArrayOfLong)
  {
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.CD.a(l, paramgq);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      localJSONObject.put("mediaSessionId", ea());
      paramgq = new JSONArray();
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        paramgq.put(i, paramArrayOfLong[i]);
        i += 1;
      }
      localJSONObject.put("activeTrackIds", paramgq);
    }
    catch (JSONException paramgq)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public void a(long paramLong, int paramInt)
  {
    Iterator localIterator = this.CF.iterator();
    while (localIterator.hasNext()) {
      ((gr)localIterator.next()).c(paramLong, paramInt);
    }
  }
  
  public final void ai(String paramString)
  {
    this.BD.b("message received: %s", new Object[] { paramString });
    Object localObject2;
    long l;
    try
    {
      Object localObject1 = new JSONObject(paramString);
      localObject2 = ((JSONObject)localObject1).getString("type");
      l = ((JSONObject)localObject1).optLong("requestId", -1L);
      if (((String)localObject2).equals("MEDIA_STATUS"))
      {
        localObject1 = ((JSONObject)localObject1).getJSONArray("status");
        if (((JSONArray)localObject1).length() > 0)
        {
          a(l, ((JSONArray)localObject1).getJSONObject(0));
          return;
        }
        this.Cu = null;
        onStatusUpdated();
        onMetadataUpdated();
        this.CC.c(l, 0);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      this.BD.d("Message is malformed (%s); ignoring: %s", new Object[] { localJSONException.getMessage(), paramString });
      return;
    }
    JSONObject localJSONObject;
    if (((String)localObject2).equals("INVALID_PLAYER_STATE"))
    {
      this.BD.d("received unexpected error: Invalid Player State.", new Object[0]);
      localJSONObject = localJSONException.optJSONObject("customData");
      localObject2 = this.CF.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((gr)((Iterator)localObject2).next()).b(l, 1, localJSONObject);
      }
    }
    if (((String)localObject2).equals("LOAD_FAILED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.Cv.b(l, 1, localJSONObject);
      return;
    }
    if (((String)localObject2).equals("LOAD_CANCELLED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.Cv.b(l, 2, localJSONObject);
      return;
    }
    if (((String)localObject2).equals("INVALID_REQUEST"))
    {
      this.BD.d("received unexpected error: Invalid Request.", new Object[0]);
      localJSONObject = localJSONObject.optJSONObject("customData");
      localObject2 = this.CF.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((gr)((Iterator)localObject2).next()).b(l, 1, localJSONObject);
      }
    }
  }
  
  public long b(gq paramgq, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.Cy.a(l, paramgq);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "STOP");
      localJSONObject.put("mediaSessionId", ea());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgq)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long c(gq paramgq, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    long l = ed();
    this.Cx.a(l, paramgq);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PLAY");
      localJSONObject.put("mediaSessionId", ea());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgq)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long ea()
  {
    if (this.Cu == null) {
      throw new IllegalStateException("No current media session");
    }
    return this.Cu.ea();
  }
  
  public void ee()
  {
    et();
  }
  
  public long getApproximateStreamPosition()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo == null) {}
    while (this.Ct == 0L) {
      return 0L;
    }
    double d = this.Cu.getPlaybackRate();
    long l3 = this.Cu.getStreamPosition();
    int i = this.Cu.getPlayerState();
    if ((d == 0.0D) || (i != 2)) {
      return l3;
    }
    long l1 = SystemClock.elapsedRealtime() - this.Ct;
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      if (l1 == 0L) {
        return l3;
      }
      long l2 = localMediaInfo.getStreamDuration();
      l1 = l3 + (l1 * d);
      if (l1 > l2) {
        l1 = l2;
      }
      for (;;)
      {
        return l1;
        if (l1 < 0L) {
          l1 = 0L;
        }
      }
    }
  }
  
  public MediaInfo getMediaInfo()
  {
    if (this.Cu == null) {
      return null;
    }
    return this.Cu.getMediaInfo();
  }
  
  public MediaStatus getMediaStatus()
  {
    return this.Cu;
  }
  
  public long getStreamDuration()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo != null) {
      return localMediaInfo.getStreamDuration();
    }
    return 0L;
  }
  
  protected void onMetadataUpdated() {}
  
  protected void onStatusUpdated() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */