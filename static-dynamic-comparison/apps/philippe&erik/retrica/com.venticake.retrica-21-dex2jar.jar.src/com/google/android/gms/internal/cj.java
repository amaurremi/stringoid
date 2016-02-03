package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.HashMap;
import java.util.Map;

public final class cj
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private final ex lN;
  private final MediaController oI;
  private final mm oJ;
  private final VideoView oK;
  private long oL;
  private String oM;
  
  public cj(Context paramContext, ex paramex)
  {
    super(paramContext);
    this.lN = paramex;
    this.oK = new VideoView(paramContext);
    paramex = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.oK, paramex);
    this.oI = new MediaController(paramContext);
    this.oJ = new mm(this);
    this.oJ.b();
    this.oK.setOnCompletionListener(this);
    this.oK.setOnPreparedListener(this);
    this.oK.setOnErrorListener(this);
  }
  
  private static void a(ex paramex, String paramString)
  {
    a(paramex, paramString, new HashMap(1));
  }
  
  public static void a(ex paramex, String paramString1, String paramString2)
  {
    int i;
    if (paramString2 == null)
    {
      i = 1;
      if (i == 0) {
        break label60;
      }
    }
    label60:
    for (int j = 2;; j = 3)
    {
      HashMap localHashMap = new HashMap(j);
      localHashMap.put("what", paramString1);
      if (i == 0) {
        localHashMap.put("extra", paramString2);
      }
      a(paramex, "error", localHashMap);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(ex paramex, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put(paramString2, paramString3);
    a(paramex, paramString1, localHashMap);
  }
  
  private static void a(ex paramex, String paramString, Map<String, String> paramMap)
  {
    paramMap.put("event", paramString);
    paramex.a("onVideoEvent", paramMap);
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.oK.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void ba()
  {
    if (!TextUtils.isEmpty(this.oM))
    {
      this.oK.setVideoPath(this.oM);
      return;
    }
    a(this.lN, "no_src", null);
  }
  
  public void bb()
  {
    long l = this.oK.getCurrentPosition();
    if (this.oL != l)
    {
      float f = (float)l / 1000.0F;
      a(this.lN, "timeupdate", "time", String.valueOf(f));
      this.oL = l;
    }
  }
  
  public void destroy()
  {
    this.oJ.a();
    this.oK.stopPlayback();
  }
  
  public void l(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.oK.setMediaController(this.oI);
      return;
    }
    this.oI.hide();
    this.oK.setMediaController(null);
  }
  
  public void o(String paramString)
  {
    this.oM = paramString;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a(this.lN, "ended");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a(this.lN, String.valueOf(paramInt1), String.valueOf(paramInt2));
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    float f = this.oK.getDuration() / 1000.0F;
    a(this.lN, "canplaythrough", "duration", String.valueOf(f));
  }
  
  public void pause()
  {
    this.oK.pause();
  }
  
  public void play()
  {
    this.oK.start();
  }
  
  public void seekTo(int paramInt)
  {
    this.oK.seekTo(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */