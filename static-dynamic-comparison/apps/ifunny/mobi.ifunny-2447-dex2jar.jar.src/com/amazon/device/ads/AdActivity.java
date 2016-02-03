package com.amazon.device.ads;

import android.app.Activity;
import android.os.Bundle;

public class AdActivity
        extends Activity {
    private di a;

    /* Error */
    di a() {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 30	com/amazon/device/ads/AdActivity:getIntent	()Landroid/content/Intent;
        //   4: ldc 32
        //   6: invokevirtual 38	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   9: astore_1
        //   10: aload_1
        //   11: ifnonnull +12 -> 23
        //   14: ldc 40
        //   16: ldc 42
        //   18: invokestatic 48	com/amazon/device/ads/dv:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   21: aconst_null
        //   22: areturn
        //   23: aload_1
        //   24: invokestatic 54	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
        //   27: astore_1
        //   28: aload_1
        //   29: iconst_0
        //   30: anewarray 50	java/lang/Class
        //   33: invokevirtual 58	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   36: astore_1
        //   37: aload_1
        //   38: iconst_0
        //   39: anewarray 60	java/lang/Object
        //   42: invokevirtual 66	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
        //   45: checkcast 68	com/amazon/device/ads/di
        //   48: astore_1
        //   49: aload_1
        //   50: areturn
        //   51: astore_1
        //   52: ldc 40
        //   54: ldc 70
        //   56: invokestatic 48	com/amazon/device/ads/dv:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   59: aconst_null
        //   60: areturn
        //   61: astore_1
        //   62: ldc 40
        //   64: ldc 72
        //   66: invokestatic 48	com/amazon/device/ads/dv:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   69: aconst_null
        //   70: areturn
        //   71: astore_1
        //   72: ldc 40
        //   74: ldc 74
        //   76: invokestatic 48	com/amazon/device/ads/dv:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   79: aconst_null
        //   80: areturn
        //   81: astore_1
        //   82: ldc 40
        //   84: ldc 76
        //   86: invokestatic 48	com/amazon/device/ads/dv:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   89: aconst_null
        //   90: areturn
        //   91: astore_1
        //   92: ldc 40
        //   94: ldc 78
        //   96: invokestatic 48	com/amazon/device/ads/dv:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   99: aconst_null
        //   100: areturn
        //   101: astore_1
        //   102: ldc 40
        //   104: ldc 80
        //   106: invokestatic 48	com/amazon/device/ads/dv:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   109: aconst_null
        //   110: areturn
        //   111: astore_1
        //   112: ldc 40
        //   114: ldc 82
        //   116: invokestatic 48	com/amazon/device/ads/dv:c	(Ljava/lang/String;Ljava/lang/String;)V
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
        dn.i().a(getApplicationContext());
        this.a = a();
        if (this.a == null) {
            finish();
            return;
        }
        this.a.a(this);
        this.a.a();
        super.onCreate(paramBundle);
        this.a.b();
    }

    public void onPause() {
        super.onPause();
        this.a.c();
    }

    public void onResume() {
        super.onResume();
        this.a.d();
    }

    public void onStop() {
        this.a.e();
        super.onStop();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/AdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */