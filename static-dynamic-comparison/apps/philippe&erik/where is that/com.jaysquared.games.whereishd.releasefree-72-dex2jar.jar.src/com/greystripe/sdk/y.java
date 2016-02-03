package com.greystripe.sdk;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.MotionEvent;
import android.widget.VideoView;
import java.util.ArrayList;
import java.util.Iterator;

final class y
  extends VideoView
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener
{
  private ArrayList a;
  
  public y(Context paramContext)
  {
    super(paramContext);
    setOnCompletionListener(this);
    setOnPreparedListener(this);
  }
  
  public final void a(x paramx)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramx);
  }
  
  public final void b(x paramx)
  {
    if (this.a != null) {
      this.a.remove(paramx);
    }
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a != null)
    {
      paramMediaPlayer = this.a.iterator();
      while (paramMediaPlayer.hasNext()) {
        ((x)paramMediaPlayer.next()).onCompletion();
      }
    }
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.a != null)
    {
      paramMediaPlayer = this.a.iterator();
      while (paramMediaPlayer.hasNext()) {
        ((x)paramMediaPlayer.next()).onPrepared();
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          ((x)localIterator.next()).onTouchStart();
        }
        if (this.a != null)
        {
          localIterator = this.a.iterator();
          while (localIterator.hasNext()) {
            ((x)localIterator.next()).onTouchMove();
          }
          if (this.a != null)
          {
            localIterator = this.a.iterator();
            while (localIterator.hasNext()) {
              ((x)localIterator.next()).onTouchCancel();
            }
            if (this.a != null)
            {
              localIterator = this.a.iterator();
              while (localIterator.hasNext()) {
                ((x)localIterator.next()).onTouchEnd();
              }
            }
          }
        }
      }
    }
  }
  
  public final void pause()
  {
    super.pause();
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((x)localIterator.next()).onPause();
      }
    }
  }
  
  public final void seekTo(int paramInt)
  {
    super.seekTo(paramInt);
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((x)localIterator.next()).onTimeUpdate();
      }
    }
  }
  
  public final void start()
  {
    super.start();
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((x)localIterator.next()).onPlay();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */