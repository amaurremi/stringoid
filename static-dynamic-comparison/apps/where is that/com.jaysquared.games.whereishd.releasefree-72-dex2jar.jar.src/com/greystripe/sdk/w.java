package com.greystripe.sdk;

import android.webkit.JavascriptInterface;

abstract class w
  implements x
{
  protected y a;
  private c b;
  
  public w(c paramc)
  {
    this.b = paramc;
  }
  
  private void a(String paramString)
  {
    if (this.b == null) {
      return;
    }
    this.b.j().b("EventHandler.broadcastEvent('" + paramString + "');");
  }
  
  @JavascriptInterface
  public boolean canPause()
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return false;
    }
    try
    {
      boolean bool = this.a.canPause();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at canPause", new Object[0]);
    }
    return false;
  }
  
  @JavascriptInterface
  public boolean canSeekBackward()
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return false;
    }
    try
    {
      boolean bool = this.a.canSeekBackward();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at canSeekBackward", new Object[0]);
    }
    return false;
  }
  
  @JavascriptInterface
  public boolean canSeekForward()
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return false;
    }
    try
    {
      boolean bool = this.a.canSeekForward();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at canSeekForward", new Object[0]);
    }
    return false;
  }
  
  @JavascriptInterface
  public int getBufferPercentage()
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return -1;
    }
    try
    {
      int i = this.a.getBufferPercentage();
      return i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at getBufferPercentage", new Object[0]);
    }
    return -1;
  }
  
  @JavascriptInterface
  public double getCurrentTime()
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return -1.0D;
    }
    try
    {
      int i = this.a.getCurrentPosition();
      return i / 1000.0D;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at getCurrentTime", new Object[0]);
    }
    return -1.0D;
  }
  
  @JavascriptInterface
  public double getDuration()
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return -1.0D;
    }
    try
    {
      int i = this.a.getDuration();
      return i / 1000.0D;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at getDuration", new Object[0]);
    }
    return -1.0D;
  }
  
  @JavascriptInterface
  public boolean isPlaying()
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return false;
    }
    try
    {
      boolean bool = this.a.isPlaying();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at isPlaying", new Object[0]);
    }
    return false;
  }
  
  public void onCompletion()
  {
    a("videooncompletion");
  }
  
  public void onPause()
  {
    a("videoonpause");
  }
  
  public void onPlay()
  {
    a("videoonplay");
  }
  
  public void onPrepared()
  {
    a("videoonprepared");
  }
  
  public void onTimeUpdate()
  {
    a("videoontimeupdate");
  }
  
  public void onTouchCancel()
  {
    a("videoontouchcancel");
  }
  
  public void onTouchEnd()
  {
    a("videoontouchend");
  }
  
  public void onTouchMove()
  {
    a("videoontouchmove");
  }
  
  public void onTouchStart()
  {
    a("videoontouchstart");
  }
  
  public void onVideoExit()
  {
    a("videoonexit");
  }
  
  @JavascriptInterface
  public void pause()
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return;
    }
    try
    {
      this.a.pause();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at pause", new Object[0]);
    }
  }
  
  @JavascriptInterface
  public void seekTo(int paramInt)
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return;
    }
    try
    {
      this.a.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at seekTo", new Object[0]);
    }
  }
  
  @JavascriptInterface
  public void start()
  {
    if (this.a == null)
    {
      bd.b("videoView was null", new Object[0]);
      return;
    }
    try
    {
      this.a.start();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bd.b("CAUGHT: IllegalStateException at start", new Object[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */