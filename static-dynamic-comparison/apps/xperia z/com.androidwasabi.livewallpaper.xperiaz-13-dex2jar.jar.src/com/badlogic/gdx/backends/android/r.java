package com.badlogic.gdx.backends.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.badlogic.gdx.g;
import java.io.IOException;

public class r
  implements MediaPlayer.OnCompletionListener, com.badlogic.gdx.b.a
{
  protected boolean a;
  protected com.badlogic.gdx.b.b b;
  private final b c;
  private MediaPlayer d;
  private boolean e;
  
  public boolean a()
  {
    return this.d.isPlaying();
  }
  
  public void b()
  {
    if (this.d.isPlaying()) {
      this.d.pause();
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/badlogic/gdx/backends/android/r:d	Landroid/media/MediaPlayer;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 20	com/badlogic/gdx/backends/android/r:d	Landroid/media/MediaPlayer;
    //   12: invokevirtual 25	android/media/MediaPlayer:isPlaying	()Z
    //   15: ifeq +10 -> 25
    //   18: aload_0
    //   19: getfield 20	com/badlogic/gdx/backends/android/r:d	Landroid/media/MediaPlayer;
    //   22: invokevirtual 35	android/media/MediaPlayer:stop	()V
    //   25: aload_0
    //   26: getfield 20	com/badlogic/gdx/backends/android/r:d	Landroid/media/MediaPlayer;
    //   29: invokevirtual 38	android/media/MediaPlayer:release	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 20	com/badlogic/gdx/backends/android/r:d	Landroid/media/MediaPlayer;
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 40	com/badlogic/gdx/backends/android/r:b	Lcom/badlogic/gdx/b/b;
    //   42: aload_0
    //   43: getfield 42	com/badlogic/gdx/backends/android/r:c	Lcom/badlogic/gdx/backends/android/b;
    //   46: getfield 47	com/badlogic/gdx/backends/android/b:a	Ljava/util/List;
    //   49: astore_1
    //   50: aload_1
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 42	com/badlogic/gdx/backends/android/r:c	Lcom/badlogic/gdx/backends/android/b;
    //   56: getfield 47	com/badlogic/gdx/backends/android/b:a	Ljava/util/List;
    //   59: aload_0
    //   60: invokeinterface 53 2 0
    //   65: pop
    //   66: aload_1
    //   67: monitorexit
    //   68: return
    //   69: astore_2
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    //   74: astore_1
    //   75: getstatic 58	com/badlogic/gdx/g:a	Lcom/badlogic/gdx/a;
    //   78: ldc 60
    //   80: ldc 62
    //   82: invokeinterface 67 3 0
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 20	com/badlogic/gdx/backends/android/r:d	Landroid/media/MediaPlayer;
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield 40	com/badlogic/gdx/backends/android/r:b	Lcom/badlogic/gdx/b/b;
    //   97: aload_0
    //   98: getfield 42	com/badlogic/gdx/backends/android/r:c	Lcom/badlogic/gdx/backends/android/b;
    //   101: getfield 47	com/badlogic/gdx/backends/android/b:a	Ljava/util/List;
    //   104: astore_1
    //   105: aload_1
    //   106: monitorenter
    //   107: aload_0
    //   108: getfield 42	com/badlogic/gdx/backends/android/r:c	Lcom/badlogic/gdx/backends/android/b;
    //   111: getfield 47	com/badlogic/gdx/backends/android/b:a	Ljava/util/List;
    //   114: aload_0
    //   115: invokeinterface 53 2 0
    //   120: pop
    //   121: aload_1
    //   122: monitorexit
    //   123: return
    //   124: astore_2
    //   125: aload_1
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    //   129: astore_2
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 20	com/badlogic/gdx/backends/android/r:d	Landroid/media/MediaPlayer;
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 40	com/badlogic/gdx/backends/android/r:b	Lcom/badlogic/gdx/b/b;
    //   140: aload_0
    //   141: getfield 42	com/badlogic/gdx/backends/android/r:c	Lcom/badlogic/gdx/backends/android/b;
    //   144: getfield 47	com/badlogic/gdx/backends/android/b:a	Ljava/util/List;
    //   147: astore_1
    //   148: aload_1
    //   149: monitorenter
    //   150: aload_0
    //   151: getfield 42	com/badlogic/gdx/backends/android/r:c	Lcom/badlogic/gdx/backends/android/b;
    //   154: getfield 47	com/badlogic/gdx/backends/android/b:a	Ljava/util/List;
    //   157: aload_0
    //   158: invokeinterface 53 2 0
    //   163: pop
    //   164: aload_1
    //   165: monitorexit
    //   166: aload_2
    //   167: athrow
    //   168: astore_2
    //   169: aload_1
    //   170: monitorexit
    //   171: aload_2
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	r
    //   74	1	1	localThrowable	Throwable
    //   69	4	2	localObject1	Object
    //   124	4	2	localObject2	Object
    //   129	38	2	localObject3	Object
    //   168	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   52	68	69	finally
    //   70	72	69	finally
    //   8	25	74	java/lang/Throwable
    //   25	32	74	java/lang/Throwable
    //   107	123	124	finally
    //   125	127	124	finally
    //   8	25	129	finally
    //   25	32	129	finally
    //   75	87	129	finally
    //   150	166	168	finally
    //   169	171	168	finally
  }
  
  public void d()
  {
    if (this.d.isPlaying()) {
      return;
    }
    try
    {
      if (!this.e)
      {
        this.d.prepare();
        this.e = true;
      }
      this.d.start();
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
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.b != null) {
      g.a.a(new s(this));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */