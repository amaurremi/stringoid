package com.pocket.l;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

public class a
{
  private static final boolean a = ;
  private final AudioManager b;
  private final b c;
  private final AudioManager.OnAudioFocusChangeListener d;
  private int e = 1;
  
  public a(AudioManager paramAudioManager, b paramb)
  {
    this.b = paramAudioManager;
    this.c = paramb;
    if (a)
    {
      this.d = new AudioManager.OnAudioFocusChangeListener()
      {
        public void onAudioFocusChange(int paramAnonymousInt)
        {
          if (a.a(a.this) == null) {
            return;
          }
          switch (paramAnonymousInt)
          {
          case 0: 
          default: 
            return;
          case -3: 
            a.a(a.this).a(true);
            return;
          case 1: 
            a.a(a.this).a();
            return;
          }
          a.a(a.this).a(false);
        }
      };
      return;
    }
    this.d = null;
    this.e = 3;
  }
  
  public boolean a()
  {
    if (a)
    {
      if (this.b.requestAudioFocus(this.d, 3, 1) == 1) {
        this.e = 3;
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    if (a)
    {
      if (this.b.abandonAudioFocus(this.d) == 1)
      {
        this.e = 1;
        return true;
      }
      return false;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */