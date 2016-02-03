package com.tapstream.sdk;

import android.app.Application;

import java.lang.reflect.Constructor;

public class Tapstream
        implements Api {
    private static Tapstream instance;
    private Core core;
    private Delegate delegate = new DelegateImpl(null);
    private CoreListener listener;
    private Platform platform;

    private Tapstream(Application paramApplication, String paramString1, String paramString2, Config paramConfig) {
        this.platform = new PlatformImpl(paramApplication);
        this.listener = new CoreListenerImpl();
        try {
            ActivityEventSource localActivityEventSource1 = (ActivityEventSource) Class.forName("com.tapstream.sdk.api14.ActivityCallbacks").getConstructor(new Class[]{Application.class}).newInstance(new Object[]{paramApplication});
            this.core = new Core(this.delegate, this.platform, this.listener, localActivityEventSource1, new AdvertisingIdFetcher(paramApplication), paramString1, paramString2, paramConfig);
            this.core.start();
            return;
        } catch (Exception localException) {
            for (; ; ) {
                ActivityEventSource localActivityEventSource2 = new ActivityEventSource();
            }
        }
    }

    /* Error */
    public static void create(Application paramApplication, String paramString1, String paramString2, Config paramConfig) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 89	com/tapstream/sdk/Tapstream:instance	Lcom/tapstream/sdk/Tapstream;
        //   6: ifnonnull +21 -> 27
        //   9: new 2	com/tapstream/sdk/Tapstream
        //   12: dup
        //   13: aload_0
        //   14: aload_1
        //   15: aload_2
        //   16: aload_3
        //   17: invokespecial 91	com/tapstream/sdk/Tapstream:<init>	(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Lcom/tapstream/sdk/Config;)V
        //   20: putstatic 89	com/tapstream/sdk/Tapstream:instance	Lcom/tapstream/sdk/Tapstream;
        //   23: ldc 2
        //   25: monitorexit
        //   26: return
        //   27: iconst_5
        //   28: ldc 93
        //   30: iconst_0
        //   31: anewarray 4	java/lang/Object
        //   34: invokestatic 99	com/tapstream/sdk/Logging:log	(ILjava/lang/String;[Ljava/lang/Object;)V
        //   37: goto -14 -> 23
        //   40: astore_0
        //   41: ldc 2
        //   43: monitorexit
        //   44: aload_0
        //   45: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	46	0	paramApplication	Application
        //   0	46	1	paramString1	String
        //   0	46	2	paramString2	String
        //   0	46	3	paramConfig	Config
        // Exception table:
        //   from	to	target	type
        //   3	23	40	finally
        //   23	26	40	finally
        //   27	37	40	finally
        //   41	44	40	finally
    }

    public static Tapstream getInstance() {
        try {
            if (instance == null) {
                throw new RuntimeException("You must first call Tapstream.create");
            }
        } finally {
        }
        Tapstream localTapstream = instance;
        return localTapstream;
    }

    public void fireEvent(Event paramEvent) {
        this.core.fireEvent(paramEvent);
    }

    public void fireHit(Hit paramHit, Hit.CompletionHandler paramCompletionHandler) {
        this.core.fireHit(paramHit, paramCompletionHandler);
    }

    public void getConversionData(ConversionListener paramConversionListener) {
        this.core.getConversionData(paramConversionListener);
    }

    private class DelegateImpl
            implements Delegate {
        private DelegateImpl() {
        }

        public int getDelay() {
            return Tapstream.this.core.getDelay();
        }

        public boolean isRetryAllowed() {
            return true;
        }

        public void setDelay(int paramInt) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Tapstream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */