package com.millennialmedia.android;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.SoundPool;
import android.net.Uri;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class BridgeMMMedia$Audio
        implements MediaPlayer.OnCompletionListener {
    private static Audio d;
    CopyOnWriteArrayList<MediaPlayer.OnCompletionListener> a;
    CopyOnWriteArrayList<BridgeMMMedia.Audio.PeriodicListener> b;
    Runnable c = new BridgeMMMedia.Audio
    .1(this);
    private WeakReference<Context> e;
    private MediaPlayer f;
    private SoundPool g;
    private BridgeMMMedia.Audio.OnLoadCompleteListener h;

    private BridgeMMMedia$Audio() {
    }

    private BridgeMMMedia$Audio(Context paramContext) {
        this.e = new WeakReference(paramContext.getApplicationContext());
    }

    static Audio a(Context paramContext) {
        try {
            if (d == null) {
                d = new Audio(paramContext);
            }
            paramContext = d;
            return paramContext;
        } finally {
        }
    }

    MMJSResponse a(Uri paramUri, boolean paramBoolean) {
        try {
            if (this.f != null) {
                this.f.release();
                this.f = null;
            }
            this.f = MediaPlayer.create((Context) this.e.get(), paramUri);
            this.f.setLooping(paramBoolean);
            this.f.start();
            this.f.setOnCompletionListener(this);
            MMSDK.a(this.c);
        } catch (Exception paramUri) {
            for (; ; ) {
                MMLog.a("BridgeMMMedia", "Exception in playAudio method", paramUri.getCause());
            }
        } finally {
        }
        paramUri = MMJSResponse.a("Audio playback started");
        return paramUri;
    }

    /* Error */
    MMJSResponse a(java.io.File paramFile) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 114	com/millennialmedia/android/BridgeMMMedia$Audio:g	Landroid/media/SoundPool;
        //   6: ifnonnull +33 -> 39
        //   9: aload_0
        //   10: new 116	android/media/SoundPool
        //   13: dup
        //   14: iconst_4
        //   15: iconst_3
        //   16: iconst_0
        //   17: invokespecial 119	android/media/SoundPool:<init>	(III)V
        //   20: putfield 114	com/millennialmedia/android/BridgeMMMedia$Audio:g	Landroid/media/SoundPool;
        //   23: aload_0
        //   24: new 121	com/millennialmedia/android/BridgeMMMedia$Audio$2
        //   27: dup
        //   28: aload_0
        //   29: aload_0
        //   30: getfield 114	com/millennialmedia/android/BridgeMMMedia$Audio:g	Landroid/media/SoundPool;
        //   33: invokespecial 124	com/millennialmedia/android/BridgeMMMedia$Audio$2:<init>	(Lcom/millennialmedia/android/BridgeMMMedia$Audio;Landroid/media/SoundPool;)V
        //   36: putfield 126	com/millennialmedia/android/BridgeMMMedia$Audio:h	Lcom/millennialmedia/android/BridgeMMMedia$Audio$OnLoadCompleteListener;
        //   39: aload_0
        //   40: getfield 126	com/millennialmedia/android/BridgeMMMedia$Audio:h	Lcom/millennialmedia/android/BridgeMMMedia$Audio$OnLoadCompleteListener;
        //   43: aload_0
        //   44: getfield 114	com/millennialmedia/android/BridgeMMMedia$Audio:g	Landroid/media/SoundPool;
        //   47: aload_1
        //   48: invokevirtual 132	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   51: iconst_1
        //   52: invokevirtual 136	android/media/SoundPool:load	(Ljava/lang/String;I)I
        //   55: invokevirtual 141	com/millennialmedia/android/BridgeMMMedia$Audio$OnLoadCompleteListener:a	(I)V
        //   58: ldc -113
        //   60: invokestatic 98	com/millennialmedia/android/MMJSResponse:a	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
        //   63: astore_1
        //   64: aload_0
        //   65: monitorexit
        //   66: aload_1
        //   67: areturn
        //   68: astore_1
        //   69: aload_0
        //   70: monitorexit
        //   71: aload_1
        //   72: athrow
        //   73: astore_1
        //   74: goto -16 -> 58
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	Audio
        //   0	77	1	paramFile	java.io.File
        // Exception table:
        //   from	to	target	type
        //   2	39	68	finally
        //   39	58	68	finally
        //   58	64	68	finally
        //   2	39	73	java/lang/Exception
        //   39	58	73	java/lang/Exception
    }

    /* Error */
    boolean a() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 53	com/millennialmedia/android/BridgeMMMedia$Audio:f	Landroid/media/MediaPlayer;
        //   6: ifnull +21 -> 27
        //   9: aload_0
        //   10: getfield 53	com/millennialmedia/android/BridgeMMMedia$Audio:f	Landroid/media/MediaPlayer;
        //   13: invokevirtual 147	android/media/MediaPlayer:isPlaying	()Z
        //   16: istore_1
        //   17: iload_1
        //   18: ifeq +9 -> 27
        //   21: iconst_1
        //   22: istore_1
        //   23: aload_0
        //   24: monitorexit
        //   25: iload_1
        //   26: ireturn
        //   27: iconst_0
        //   28: istore_1
        //   29: goto -6 -> 23
        //   32: astore_2
        //   33: aload_0
        //   34: monitorexit
        //   35: aload_2
        //   36: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	37	0	this	Audio
        //   16	13	1	bool	boolean
        //   32	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	17	32	finally
    }

    boolean a(MediaPlayer.OnCompletionListener paramOnCompletionListener) {
        if (this.a == null) {
            this.a = new CopyOnWriteArrayList();
        }
        if (!this.a.contains(paramOnCompletionListener)) {
            return this.a.add(paramOnCompletionListener);
        }
        return false;
    }

    boolean a(BridgeMMMedia.Audio.PeriodicListener paramPeriodicListener) {
        if (this.b == null) {
            this.b = new CopyOnWriteArrayList();
        }
        if (!this.b.contains(paramPeriodicListener)) {
            return this.b.add(paramPeriodicListener);
        }
        return false;
    }

    MMJSResponse b() {
        try {
            if (this.f != null) {
                onCompletion(this.f);
            }
            if (this.g != null) {
                this.g.release();
                this.g = null;
            }
            if (this.h != null) {
                this.h.a();
                this.h = null;
            }
            MMJSResponse localMMJSResponse = MMJSResponse.a("Audio stopped");
            return localMMJSResponse;
        } finally {
        }
    }

    boolean b(MediaPlayer.OnCompletionListener paramOnCompletionListener) {
        if (this.a != null) {
            return this.a.remove(paramOnCompletionListener);
        }
        return false;
    }

    boolean b(BridgeMMMedia.Audio.PeriodicListener paramPeriodicListener) {
        if (this.b != null) {
            return this.b.remove(paramPeriodicListener);
        }
        return false;
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        try {
            if (this.a != null) {
                paramMediaPlayer = this.a.iterator();
                while (paramMediaPlayer.hasNext()) {
                    ((MediaPlayer.OnCompletionListener) paramMediaPlayer.next()).onCompletion(this.f);
                }
            }
            if (this.f == null) {
                break label71;
            }
        } finally {
        }
        this.f.release();
        this.f = null;
        label71:
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMMedia$Audio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */