package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public abstract class ab {
    private static final ab a = ;

    public static ab a() {
        return a;
    }

    /* Error */
    private static ab b() {
        // Byte code:
        //   0: ldc 26
        //   2: invokestatic 32	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
        //   5: ldc 2
        //   7: invokevirtual 36	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
        //   10: astore_0
        //   11: aload_0
        //   12: invokevirtual 40	java/lang/Class:newInstance	()Ljava/lang/Object;
        //   15: checkcast 2	com/google/android/youtube/player/internal/ab
        //   18: astore_0
        //   19: aload_0
        //   20: areturn
        //   21: astore_0
        //   22: new 42	java/lang/IllegalStateException
        //   25: dup
        //   26: aload_0
        //   27: invokespecial 45	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
        //   30: athrow
        //   31: astore_0
        //   32: new 47	com/google/android/youtube/player/internal/ad
        //   35: dup
        //   36: invokespecial 48	com/google/android/youtube/player/internal/ad:<init>	()V
        //   39: areturn
        //   40: astore_0
        //   41: new 42	java/lang/IllegalStateException
        //   44: dup
        //   45: aload_0
        //   46: invokespecial 45	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
        //   49: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   10	10	0	localObject	Object
        //   21	6	0	localInstantiationException	InstantiationException
        //   31	1	0	localClassNotFoundException	ClassNotFoundException
        //   40	6	0	localIllegalAccessException	IllegalAccessException
        // Exception table:
        //   from	to	target	type
        //   11	19	21	java/lang/InstantiationException
        //   0	11	31	java/lang/ClassNotFoundException
        //   11	19	31	java/lang/ClassNotFoundException
        //   22	31	31	java/lang/ClassNotFoundException
        //   41	50	31	java/lang/ClassNotFoundException
        //   11	19	40	java/lang/IllegalAccessException
    }

    public abstract YouTubeThumbnailLoader a(b paramb, YouTubeThumbnailView paramYouTubeThumbnailView);

    public abstract b a(Context paramContext, String paramString, t.a parama, t.b paramb);

    public abstract d a(Activity paramActivity, b paramb)
            throws w.a;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */