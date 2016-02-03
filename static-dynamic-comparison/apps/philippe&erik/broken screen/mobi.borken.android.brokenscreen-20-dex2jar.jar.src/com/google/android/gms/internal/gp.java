package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gp
  extends gh
{
  private static final long Cm = TimeUnit.HOURS.toMillis(24L);
  private static final long Cn = TimeUnit.HOURS.toMillis(24L);
  private static final long Co = TimeUnit.HOURS.toMillis(24L);
  private static final long Cp = TimeUnit.SECONDS.toMillis(1L);
  private static final String NAMESPACE = gj.al("com.google.cast.media");
  private final gs CA;
  private final gs CB;
  private final List<gs> CC = new ArrayList();
  private final Runnable CD = new a(null);
  private boolean CE;
  private long Cq;
  private MediaStatus Cr;
  private final gs Cs = new gs(Cn);
  private final gs Ct;
  private final gs Cu;
  private final gs Cv;
  private final gs Cw;
  private final gs Cx;
  private final gs Cy;
  private final gs Cz;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  
  public gp()
  {
    this(null);
  }
  
  public gp(String paramString)
  {
    super(NAMESPACE, "MediaControlChannel", paramString);
    this.CC.add(this.Cs);
    this.Ct = new gs(Cm);
    this.CC.add(this.Ct);
    this.Cu = new gs(Cm);
    this.CC.add(this.Cu);
    this.Cv = new gs(Cm);
    this.CC.add(this.Cv);
    this.Cw = new gs(Co);
    this.CC.add(this.Cw);
    this.Cx = new gs(Cm);
    this.CC.add(this.Cx);
    this.Cy = new gs(Cm);
    this.CC.add(this.Cy);
    this.Cz = new gs(Cm);
    this.CC.add(this.Cz);
    this.CA = new gs(Cm);
    this.CC.add(this.CA);
    this.CB = new gs(Cm);
    this.CC.add(this.CB);
    eo();
  }
  
  private void a(long paramLong, JSONObject paramJSONObject)
    throws JSONException
  {
    int k = 1;
    boolean bool = this.Cs.p(paramLong);
    int j;
    if ((this.Cw.eq()) && (!this.Cw.p(paramLong)))
    {
      i = 1;
      if (this.Cx.eq())
      {
        j = k;
        if (!this.Cx.p(paramLong)) {}
      }
      else
      {
        if ((!this.Cy.eq()) || (this.Cy.p(paramLong))) {
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
      if ((bool) || (this.Cr == null))
      {
        this.Cr = new MediaStatus(paramJSONObject);
        this.Cq = SystemClock.elapsedRealtime();
      }
      for (i = 7;; i = this.Cr.a(paramJSONObject, k))
      {
        if ((i & 0x1) != 0)
        {
          this.Cq = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((i & 0x2) != 0)
        {
          this.Cq = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((i & 0x4) != 0) {
          onMetadataUpdated();
        }
        paramJSONObject = this.CC.iterator();
        while (paramJSONObject.hasNext()) {
          ((gs)paramJSONObject.next()).c(paramLong, 0);
        }
        i = 0;
        break;
        j = 0;
        break label87;
      }
      return;
    }
  }
  
  private void eo()
  {
    z(false);
    this.Cq = 0L;
    this.Cr = null;
    this.Cs.clear();
    this.Cw.clear();
    this.Cx.clear();
  }
  
  private void z(boolean paramBoolean)
  {
    if (this.CE != paramBoolean)
    {
      this.CE = paramBoolean;
      if (paramBoolean) {
        this.mHandler.postDelayed(this.CD, Cp);
      }
    }
    else
    {
      return;
    }
    this.mHandler.removeCallbacks(this.CD);
  }
  
  public long a(gr paramgr)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cz.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "GET_STATUS");
      if (this.Cr != null) {
        localJSONObject.put("mediaSessionId", this.Cr.dV());
      }
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException paramgr)
    {
      for (;;) {}
    }
  }
  
  public long a(gr paramgr, double paramDouble, JSONObject paramJSONObject)
    throws IOException, IllegalStateException, IllegalArgumentException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cx.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SET_VOLUME");
      localJSONObject.put("mediaSessionId", dV());
      paramgr = new JSONObject();
      paramgr.put("level", paramDouble);
      localJSONObject.put("volume", paramgr);
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgr)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gr paramgr, long paramLong, int paramInt, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cw.a(l, paramgr);
    z(true);
    for (;;)
    {
      try
      {
        localJSONObject.put("requestId", l);
        localJSONObject.put("type", "SEEK");
        localJSONObject.put("mediaSessionId", dV());
        localJSONObject.put("currentTime", gj.o(paramLong));
        if (paramInt != 1) {
          continue;
        }
        localJSONObject.put("resumeState", "PLAYBACK_START");
        if (paramJSONObject != null) {
          localJSONObject.put("customData", paramJSONObject);
        }
      }
      catch (JSONException paramgr)
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
  
  public long a(gr paramgr, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cs.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "LOAD");
      localJSONObject.put("media", paramMediaInfo.dU());
      localJSONObject.put("autoplay", paramBoolean);
      localJSONObject.put("currentTime", gj.o(paramLong));
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgr)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gr paramgr, TextTrackStyle paramTextTrackStyle)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.CB.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      if (paramTextTrackStyle != null) {
        localJSONObject.put("textTrackStyle", paramTextTrackStyle.dU());
      }
      localJSONObject.put("mediaSessionId", dV());
    }
    catch (JSONException paramgr)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gr paramgr, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Ct.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PAUSE");
      localJSONObject.put("mediaSessionId", dV());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgr)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gr paramgr, boolean paramBoolean, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cy.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SET_VOLUME");
      localJSONObject.put("mediaSessionId", dV());
      paramgr = new JSONObject();
      paramgr.put("muted", paramBoolean);
      localJSONObject.put("volume", paramgr);
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgr)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(gr paramgr, long[] paramArrayOfLong)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.CA.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      localJSONObject.put("mediaSessionId", dV());
      paramgr = new JSONArray();
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        paramgr.put(i, paramArrayOfLong[i]);
        i += 1;
      }
      localJSONObject.put("activeTrackIds", paramgr);
    }
    catch (JSONException paramgr)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public void a(long paramLong, int paramInt)
  {
    Iterator localIterator = this.CC.iterator();
    while (localIterator.hasNext()) {
      ((gs)localIterator.next()).c(paramLong, paramInt);
    }
  }
  
  public final void ai(String paramString)
  {
    this.BA.b("message received: %s", new Object[] { paramString });
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
        this.Cr = null;
        onStatusUpdated();
        onMetadataUpdated();
        this.Cz.c(l, 0);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      this.BA.d("Message is malformed (%s); ignoring: %s", new Object[] { localJSONException.getMessage(), paramString });
      return;
    }
    JSONObject localJSONObject;
    if (((String)localObject2).equals("INVALID_PLAYER_STATE"))
    {
      this.BA.d("received unexpected error: Invalid Player State.", new Object[0]);
      localJSONObject = localJSONException.optJSONObject("customData");
      localObject2 = this.CC.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((gs)((Iterator)localObject2).next()).b(l, 1, localJSONObject);
      }
    }
    if (((String)localObject2).equals("LOAD_FAILED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.Cs.b(l, 1, localJSONObject);
      return;
    }
    if (((String)localObject2).equals("LOAD_CANCELLED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.Cs.b(l, 2, localJSONObject);
      return;
    }
    if (((String)localObject2).equals("INVALID_REQUEST"))
    {
      this.BA.d("received unexpected error: Invalid Request.", new Object[0]);
      localJSONObject = localJSONObject.optJSONObject("customData");
      localObject2 = this.CC.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((gs)((Iterator)localObject2).next()).b(l, 1, localJSONObject);
      }
    }
  }
  
  public long b(gr paramgr, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cv.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "STOP");
      localJSONObject.put("mediaSessionId", dV());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgr)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long c(gr paramgr, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cu.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PLAY");
      localJSONObject.put("mediaSessionId", dV());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramgr)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long dV()
    throws IllegalStateException
  {
    if (this.Cr == null) {
      throw new IllegalStateException("No current media session");
    }
    return this.Cr.dV();
  }
  
  public void dZ()
  {
    eo();
  }
  
  public long getApproximateStreamPosition()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo == null) {}
    while (this.Cq == 0L) {
      return 0L;
    }
    double d = this.Cr.getPlaybackRate();
    long l3 = this.Cr.getStreamPosition();
    int i = this.Cr.getPlayerState();
    if ((d == 0.0D) || (i != 2)) {
      return l3;
    }
    long l1 = SystemClock.elapsedRealtime() - this.Cq;
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
    if (this.Cr == null) {
      return null;
    }
    return this.Cr.getMediaInfo();
  }
  
  public MediaStatus getMediaStatus()
  {
    return this.Cr;
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
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      boolean bool = false;
      gp.a(gp.this, false);
      long l = SystemClock.elapsedRealtime();
      ??? = gp.a(gp.this).iterator();
      while (((Iterator)???).hasNext()) {
        ((gs)((Iterator)???).next()).d(l, 3);
      }
      for (;;)
      {
        synchronized (gs.CK)
        {
          Iterator localIterator = gp.a(gp.this).iterator();
          if (localIterator.hasNext())
          {
            if (((gs)localIterator.next()).eq()) {
              bool = true;
            }
          }
          else
          {
            gp.b(gp.this, bool);
            return;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */