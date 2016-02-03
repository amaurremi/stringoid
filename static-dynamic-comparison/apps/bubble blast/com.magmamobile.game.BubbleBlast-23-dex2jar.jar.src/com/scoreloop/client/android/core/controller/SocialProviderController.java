package com.scoreloop.client.android.core.controller;

import android.app.Activity;
import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.SocialProvider;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.ui.AuthViewController;

public abstract class SocialProviderController
{
  a a;
  RequestControllerObserver b;
  private Activity d;
  private final SocialProviderControllerObserver e;
  private SocialProvider f;
  private final Session g;
  
  static
  {
    if (!SocialProviderController.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  SocialProviderController(Session paramSession, SocialProviderControllerObserver paramSocialProviderControllerObserver)
  {
    this.g = paramSession;
    this.e = paramSocialProviderControllerObserver;
  }
  
  /* Error */
  @PublishedFor__1_0_0
  public static SocialProviderController getSocialProviderController(Session paramSession, SocialProviderControllerObserver paramSocialProviderControllerObserver, SocialProvider paramSocialProvider)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +13 -> 18
    //   8: new 48	java/lang/IllegalArgumentException
    //   11: dup
    //   12: ldc 56
    //   14: invokespecial 59	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_0
    //   19: astore_3
    //   20: aload_0
    //   21: ifnonnull +7 -> 28
    //   24: invokestatic 65	com/scoreloop/client/android/core/model/Session:getCurrentSession	()Lcom/scoreloop/client/android/core/model/Session;
    //   27: astore_3
    //   28: getstatic 30	com/scoreloop/client/android/core/controller/SocialProviderController:c	Z
    //   31: ifne +15 -> 46
    //   34: aload_3
    //   35: ifnonnull +11 -> 46
    //   38: new 67	java/lang/AssertionError
    //   41: dup
    //   42: invokespecial 68	java/lang/AssertionError:<init>	()V
    //   45: athrow
    //   46: aload_2
    //   47: invokevirtual 73	com/scoreloop/client/android/core/model/SocialProvider:a	()Ljava/lang/Class;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnonnull +11 -> 63
    //   55: new 48	java/lang/IllegalArgumentException
    //   58: dup
    //   59: invokespecial 74	java/lang/IllegalArgumentException:<init>	()V
    //   62: athrow
    //   63: aload_0
    //   64: iconst_2
    //   65: anewarray 24	java/lang/Class
    //   68: dup
    //   69: iconst_0
    //   70: ldc 61
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: ldc 76
    //   77: aastore
    //   78: invokevirtual 80	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   81: astore_0
    //   82: aload_0
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_3
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: aload_1
    //   94: aastore
    //   95: invokevirtual 86	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 2	com/scoreloop/client/android/core/controller/SocialProviderController
    //   101: astore_0
    //   102: aload_0
    //   103: aload_2
    //   104: invokevirtual 89	com/scoreloop/client/android/core/controller/SocialProviderController:a	(Lcom/scoreloop/client/android/core/model/SocialProvider;)V
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: new 91	java/lang/IllegalStateException
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 94	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   118: athrow
    //   119: astore_0
    //   120: new 91	java/lang/IllegalStateException
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 94	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   128: athrow
    //   129: astore_0
    //   130: new 91	java/lang/IllegalStateException
    //   133: dup
    //   134: aload_0
    //   135: invokespecial 94	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   138: athrow
    //   139: astore_0
    //   140: new 91	java/lang/IllegalStateException
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 94	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   148: athrow
    //   149: astore_0
    //   150: new 91	java/lang/IllegalStateException
    //   153: dup
    //   154: aload_0
    //   155: invokespecial 94	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   158: athrow
    //   159: astore_0
    //   160: new 91	java/lang/IllegalStateException
    //   163: dup
    //   164: aload_0
    //   165: invokespecial 94	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramSession	Session
    //   0	169	1	paramSocialProviderControllerObserver	SocialProviderControllerObserver
    //   0	169	2	paramSocialProvider	SocialProvider
    //   19	71	3	localSession	Session
    // Exception table:
    //   from	to	target	type
    //   63	82	109	java/lang/SecurityException
    //   63	82	119	java/lang/NoSuchMethodException
    //   82	102	129	java/lang/IllegalArgumentException
    //   82	102	139	java/lang/InstantiationException
    //   82	102	149	java/lang/IllegalAccessException
    //   82	102	159	java/lang/reflect/InvocationTargetException
  }
  
  @PublishedFor__1_0_0
  public static SocialProviderController getSocialProviderController(String paramString, SocialProviderControllerObserver paramSocialProviderControllerObserver)
  {
    return getSocialProviderController(null, paramSocialProviderControllerObserver, SocialProvider.getSocialProviderForIdentifier(paramString));
  }
  
  void a(Activity paramActivity, AuthViewController paramAuthViewController)
  {
    if ((paramActivity == null) || (paramAuthViewController == null)) {
      throw new IllegalArgumentException();
    }
    paramAuthViewController.a(paramActivity);
  }
  
  void a(SocialProvider paramSocialProvider)
  {
    this.f = paramSocialProvider;
  }
  
  abstract void b();
  
  @PublishedFor__1_0_0
  public final void connect(Activity paramActivity)
  {
    this.d = paramActivity;
    this.b = new a();
    if ((g() == null) || (!g().isAuthenticated()))
    {
      if (this.a == null) {
        this.a = new a(g(), this.b);
      }
      this.a.j();
      return;
    }
    h();
  }
  
  Activity e()
  {
    return this.d;
  }
  
  SocialProviderControllerObserver f()
  {
    return this.e;
  }
  
  Session g()
  {
    return this.g;
  }
  
  @PublishedFor__1_0_0
  public SocialProvider getSocialProvider()
  {
    return this.f;
  }
  
  void h()
  {
    if (g().getUser().isConnectedToSocialProviderWithIdentifier(getSocialProvider().getIdentifier()))
    {
      f().didSucceed(this);
      return;
    }
    b();
  }
  
  class a
    implements RequestControllerObserver
  {
    a() {}
    
    public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
    {
      SocialProviderController.this.f().didFail(SocialProviderController.this, paramException);
    }
    
    public void requestControllerDidReceiveResponse(RequestController paramRequestController)
    {
      if (paramRequestController.getClass().isAssignableFrom(a.class)) {
        SocialProviderController.this.h();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/SocialProviderController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */