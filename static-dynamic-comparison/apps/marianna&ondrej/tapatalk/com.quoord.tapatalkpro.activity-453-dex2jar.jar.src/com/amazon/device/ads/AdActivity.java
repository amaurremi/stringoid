package com.amazon.device.ads;

import android.app.Activity;
import android.os.Bundle;

public class AdActivity
        extends Activity {
    protected static final String ADAPTER_KEY = "adapter";
    private static final String LOG_TAG = "AdAdapter";
    private IAdActivityAdapter adapter;

    /* Error */
    IAdActivityAdapter createAdapter() {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 37	com/amazon/device/ads/AdActivity:getIntent	()Landroid/content/Intent;
        //   4: ldc 8
        //   6: invokevirtual 43	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   9: astore_1
        //   10: aload_1
        //   11: ifnonnull +12 -> 23
        //   14: ldc 11
        //   16: ldc 45
        //   18: invokestatic 51	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   21: aconst_null
        //   22: areturn
        //   23: aload_1
        //   24: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
        //   27: astore_1
        //   28: aload_1
        //   29: iconst_0
        //   30: anewarray 53	java/lang/Class
        //   33: invokevirtual 61	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   36: astore_1
        //   37: aload_1
        //   38: iconst_0
        //   39: anewarray 63	java/lang/Object
        //   42: invokevirtual 69	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
        //   45: checkcast 71	com/amazon/device/ads/IAdActivityAdapter
        //   48: astore_1
        //   49: aload_1
        //   50: areturn
        //   51: astore_1
        //   52: ldc 11
        //   54: ldc 73
        //   56: invokestatic 51	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   59: aconst_null
        //   60: areturn
        //   61: astore_1
        //   62: ldc 11
        //   64: ldc 75
        //   66: invokestatic 51	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   69: aconst_null
        //   70: areturn
        //   71: astore_1
        //   72: ldc 11
        //   74: ldc 77
        //   76: invokestatic 51	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   79: aconst_null
        //   80: areturn
        //   81: astore_1
        //   82: ldc 11
        //   84: ldc 79
        //   86: invokestatic 51	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   89: aconst_null
        //   90: areturn
        //   91: astore_1
        //   92: ldc 11
        //   94: ldc 81
        //   96: invokestatic 51	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   99: aconst_null
        //   100: areturn
        //   101: astore_1
        //   102: ldc 11
        //   104: ldc 83
        //   106: invokestatic 51	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   109: aconst_null
        //   110: areturn
        //   111: astore_1
        //   112: ldc 11
        //   114: ldc 85
        //   116: invokestatic 51	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   119: aconst_null
        //   120: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	this	AdActivity
        //   9	41	1	localObject	Object
        //   51	1	1	localClassNotFoundException	ClassNotFoundException
        //   61	1	1	localSecurityException	SecurityException
        //   71	1	1	localNoSuchMethodException	NoSuchMethodException
        //   81	1	1	localIllegalArgumentException	IllegalArgumentException
        //   91	1	1	localInstantiationException	InstantiationException
        //   101	1	1	localIllegalAccessException	IllegalAccessException
        //   111	1	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
        // Exception table:
        //   from	to	target	type
        //   23	28	51	java/lang/ClassNotFoundException
        //   28	37	61	java/lang/SecurityException
        //   28	37	71	java/lang/NoSuchMethodException
        //   37	49	81	java/lang/IllegalArgumentException
        //   37	49	91	java/lang/InstantiationException
        //   37	49	101	java/lang/IllegalAccessException
        //   37	49	111	java/lang/reflect/InvocationTargetException
    }

    public void onCreate(Bundle paramBundle) {
        InternalAdRegistration.getInstance().contextReceived(getApplicationContext());
        this.adapter = createAdapter();
        if (this.adapter == null) {
            finish();
            return;
        }
        this.adapter.setActivity(this);
        this.adapter.preOnCreate();
        super.onCreate(paramBundle);
        this.adapter.onCreate();
    }

    public void onPause() {
        super.onPause();
        this.adapter.onPause();
    }

    public void onResume() {
        super.onResume();
        this.adapter.onResume();
    }

    public void onStop() {
        this.adapter.onStop();
        super.onStop();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */