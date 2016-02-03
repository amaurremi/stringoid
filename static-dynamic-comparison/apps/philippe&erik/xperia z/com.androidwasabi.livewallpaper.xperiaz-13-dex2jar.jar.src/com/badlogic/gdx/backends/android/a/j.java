package com.badlogic.gdx.backends.android.a;

import android.media.MediaPlayer;
import com.badlogic.gdx.b.a;
import java.io.IOException;

public class j
  implements a
{
  protected boolean a;
  private final b b;
  private MediaPlayer c;
  private boolean d;
  
  public boolean a()
  {
    return this.c.isPlaying();
  }
  
  public void b()
  {
    if (this.c.isPlaying()) {
      this.c.pause();
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/badlogic/gdx/backends/android/a/j:c	Landroid/media/MediaPlayer;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 16	com/badlogic/gdx/backends/android/a/j:c	Landroid/media/MediaPlayer;
    //   12: invokevirtual 21	android/media/MediaPlayer:isPlaying	()Z
    //   15: ifeq +10 -> 25
    //   18: aload_0
    //   19: getfield 16	com/badlogic/gdx/backends/android/a/j:c	Landroid/media/MediaPlayer;
    //   22: invokevirtual 31	android/media/MediaPlayer:stop	()V
    //   25: aload_0
    //   26: getfield 16	com/badlogic/gdx/backends/android/a/j:c	Landroid/media/MediaPlayer;
    //   29: invokevirtual 34	android/media/MediaPlayer:release	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 16	com/badlogic/gdx/backends/android/a/j:c	Landroid/media/MediaPlayer;
    //   37: aload_0
    //   38: getfield 36	com/badlogic/gdx/backends/android/a/j:b	Lcom/badlogic/gdx/backends/android/a/b;
    //   41: getfield 41	com/badlogic/gdx/backends/android/a/b:b	Ljava/util/List;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 36	com/badlogic/gdx/backends/android/a/j:b	Lcom/badlogic/gdx/backends/android/a/b;
    //   51: getfield 41	com/badlogic/gdx/backends/android/a/b:b	Ljava/util/List;
    //   54: aload_0
    //   55: invokeinterface 47 2 0
    //   60: pop
    //   61: aload_1
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: aload_1
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    //   69: astore_1
    //   70: getstatic 52	com/badlogic/gdx/g:a	Lcom/badlogic/gdx/a;
    //   73: ldc 54
    //   75: ldc 56
    //   77: invokeinterface 61 3 0
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 16	com/badlogic/gdx/backends/android/a/j:c	Landroid/media/MediaPlayer;
    //   87: aload_0
    //   88: getfield 36	com/badlogic/gdx/backends/android/a/j:b	Lcom/badlogic/gdx/backends/android/a/b;
    //   91: getfield 41	com/badlogic/gdx/backends/android/a/b:b	Ljava/util/List;
    //   94: astore_1
    //   95: aload_1
    //   96: monitorenter
    //   97: aload_0
    //   98: getfield 36	com/badlogic/gdx/backends/android/a/j:b	Lcom/badlogic/gdx/backends/android/a/b;
    //   101: getfield 41	com/badlogic/gdx/backends/android/a/b:b	Ljava/util/List;
    //   104: aload_0
    //   105: invokeinterface 47 2 0
    //   110: pop
    //   111: aload_1
    //   112: monitorexit
    //   113: return
    //   114: astore_2
    //   115: aload_1
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: astore_2
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 16	com/badlogic/gdx/backends/android/a/j:c	Landroid/media/MediaPlayer;
    //   125: aload_0
    //   126: getfield 36	com/badlogic/gdx/backends/android/a/j:b	Lcom/badlogic/gdx/backends/android/a/b;
    //   129: getfield 41	com/badlogic/gdx/backends/android/a/b:b	Ljava/util/List;
    //   132: astore_1
    //   133: aload_1
    //   134: monitorenter
    //   135: aload_0
    //   136: getfield 36	com/badlogic/gdx/backends/android/a/j:b	Lcom/badlogic/gdx/backends/android/a/b;
    //   139: getfield 41	com/badlogic/gdx/backends/android/a/b:b	Ljava/util/List;
    //   142: aload_0
    //   143: invokeinterface 47 2 0
    //   148: pop
    //   149: aload_1
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    //   153: astore_2
    //   154: aload_1
    //   155: monitorexit
    //   156: aload_2
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	j
    //   69	1	1	localThrowable	Throwable
    //   64	4	2	localObject1	Object
    //   114	4	2	localObject2	Object
    //   119	33	2	localObject3	Object
    //   153	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   47	63	64	finally
    //   65	67	64	finally
    //   8	25	69	java/lang/Throwable
    //   25	32	69	java/lang/Throwable
    //   97	113	114	finally
    //   115	117	114	finally
    //   8	25	119	finally
    //   25	32	119	finally
    //   70	82	119	finally
    //   135	151	153	finally
    //   154	156	153	finally
  }
  
  public void d()
  {
    if (this.c.isPlaying()) {
      return;
    }
    try
    {
      if (!this.d)
      {
        this.c.prepare();
        this.d = true;
      }
      this.c.start();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */