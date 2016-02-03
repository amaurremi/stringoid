package com.venticake.retrica;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.util.Log;

public class p
{
  private static p a = null;
  private SoundPool b = null;
  private int c = this.b.load((MainActivity)MainActivity.a, 2131034112, 1);
  private boolean d = false;
  private boolean e = false;
  
  protected p()
  {
    this.b.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
    {
      public void onLoadComplete(SoundPool paramAnonymousSoundPool, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        Log.d("retrica", "soundPool: " + paramAnonymousSoundPool);
        Log.d("retrica", "sampleId: " + paramAnonymousInt1);
        Log.d("retrica", "status: " + paramAnonymousInt2);
        if (paramAnonymousInt2 == 0)
        {
          p.a(p.this, true);
          if (p.a(p.this)) {
            p.this.b();
          }
        }
      }
    });
  }
  
  public static p a()
  {
    if (a == null)
    {
      p localp = new p();
      a = localp;
      return localp;
    }
    return a;
  }
  
  public void b()
  {
    if (!this.d)
    {
      this.e = true;
      return;
    }
    this.b.play(this.c, 1.0F, 1.0F, 0, 0, 1.0F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */