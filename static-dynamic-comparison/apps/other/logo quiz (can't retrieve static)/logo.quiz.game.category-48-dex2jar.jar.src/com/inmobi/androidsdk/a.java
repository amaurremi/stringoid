package com.inmobi.androidsdk;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a
  implements Animation.AnimationListener
{
  a(IMAdView paramIMAdView) {}
  
  /* Error */
  public void onAnimationEnd(Animation paramAnimation)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   7: invokevirtual 25	com/inmobi/androidsdk/IMAdView:a	()Landroid/view/animation/Animation;
    //   10: invokevirtual 29	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +224 -> 237
    //   16: aload_0
    //   17: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   20: invokevirtual 32	com/inmobi/androidsdk/IMAdView:removeAllViews	()V
    //   23: aload_0
    //   24: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   27: invokestatic 36	com/inmobi/androidsdk/IMAdView:h	(Lcom/inmobi/androidsdk/IMAdView;)Z
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +105 -> 137
    //   35: aload_0
    //   36: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   39: invokestatic 40	com/inmobi/androidsdk/IMAdView:i	(Lcom/inmobi/androidsdk/IMAdView;)Lcom/inmobi/re/container/IMWebView;
    //   42: invokevirtual 46	com/inmobi/re/container/IMWebView:getParent	()Landroid/view/ViewParent;
    //   45: checkcast 48	android/view/ViewGroup
    //   48: aload_0
    //   49: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   52: invokestatic 40	com/inmobi/androidsdk/IMAdView:i	(Lcom/inmobi/androidsdk/IMAdView;)Lcom/inmobi/re/container/IMWebView;
    //   55: invokevirtual 52	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   58: new 54	android/widget/RelativeLayout$LayoutParams
    //   61: dup
    //   62: iconst_m1
    //   63: iconst_m1
    //   64: invokespecial 57	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   67: astore_3
    //   68: aload_0
    //   69: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   72: aload_0
    //   73: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   76: invokestatic 40	com/inmobi/androidsdk/IMAdView:i	(Lcom/inmobi/androidsdk/IMAdView;)Lcom/inmobi/re/container/IMWebView;
    //   79: invokestatic 61	com/inmobi/androidsdk/IMAdView:c	(Lcom/inmobi/androidsdk/IMAdView;Lcom/inmobi/re/container/IMWebView;)Lcom/inmobi/re/container/IMWebView;
    //   82: pop
    //   83: aload_0
    //   84: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   87: aload_0
    //   88: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   91: invokestatic 40	com/inmobi/androidsdk/IMAdView:i	(Lcom/inmobi/androidsdk/IMAdView;)Lcom/inmobi/re/container/IMWebView;
    //   94: aload_3
    //   95: invokevirtual 65	com/inmobi/androidsdk/IMAdView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   98: aload_0
    //   99: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   102: aload_0
    //   103: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   106: invokevirtual 68	com/inmobi/androidsdk/IMAdView:b	()Landroid/view/animation/Animation;
    //   109: invokevirtual 71	com/inmobi/androidsdk/IMAdView:startAnimation	(Landroid/view/animation/Animation;)V
    //   112: aload_1
    //   113: aload_0
    //   114: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   117: invokevirtual 25	com/inmobi/androidsdk/IMAdView:a	()Landroid/view/animation/Animation;
    //   120: invokevirtual 29	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   123: ifne +13 -> 136
    //   126: aload_0
    //   127: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   130: bipush 100
    //   132: aconst_null
    //   133: invokestatic 74	com/inmobi/androidsdk/IMAdView:a	(Lcom/inmobi/androidsdk/IMAdView;ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   136: return
    //   137: aload_0
    //   138: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   141: invokestatic 77	com/inmobi/androidsdk/IMAdView:j	(Lcom/inmobi/androidsdk/IMAdView;)Lcom/inmobi/re/container/IMWebView;
    //   144: invokevirtual 46	com/inmobi/re/container/IMWebView:getParent	()Landroid/view/ViewParent;
    //   147: checkcast 48	android/view/ViewGroup
    //   150: aload_0
    //   151: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   154: invokestatic 77	com/inmobi/androidsdk/IMAdView:j	(Lcom/inmobi/androidsdk/IMAdView;)Lcom/inmobi/re/container/IMWebView;
    //   157: invokevirtual 52	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   160: new 54	android/widget/RelativeLayout$LayoutParams
    //   163: dup
    //   164: iconst_m1
    //   165: iconst_m1
    //   166: invokespecial 57	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   169: astore_3
    //   170: aload_0
    //   171: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   174: aload_0
    //   175: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   178: invokestatic 77	com/inmobi/androidsdk/IMAdView:j	(Lcom/inmobi/androidsdk/IMAdView;)Lcom/inmobi/re/container/IMWebView;
    //   181: invokestatic 61	com/inmobi/androidsdk/IMAdView:c	(Lcom/inmobi/androidsdk/IMAdView;Lcom/inmobi/re/container/IMWebView;)Lcom/inmobi/re/container/IMWebView;
    //   184: pop
    //   185: aload_0
    //   186: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   189: aload_0
    //   190: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   193: invokestatic 77	com/inmobi/androidsdk/IMAdView:j	(Lcom/inmobi/androidsdk/IMAdView;)Lcom/inmobi/re/container/IMWebView;
    //   196: aload_3
    //   197: invokevirtual 65	com/inmobi/androidsdk/IMAdView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   200: goto -102 -> 98
    //   203: astore_3
    //   204: ldc 79
    //   206: ldc 81
    //   208: aload_3
    //   209: invokestatic 87	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload_1
    //   213: aload_0
    //   214: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   217: invokevirtual 25	com/inmobi/androidsdk/IMAdView:a	()Landroid/view/animation/Animation;
    //   220: invokevirtual 29	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   223: ifne -87 -> 136
    //   226: aload_0
    //   227: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   230: bipush 100
    //   232: aconst_null
    //   233: invokestatic 74	com/inmobi/androidsdk/IMAdView:a	(Lcom/inmobi/androidsdk/IMAdView;ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   236: return
    //   237: aload_0
    //   238: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   241: astore_3
    //   242: aload_0
    //   243: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   246: invokestatic 36	com/inmobi/androidsdk/IMAdView:h	(Lcom/inmobi/androidsdk/IMAdView;)Z
    //   249: ifne +5 -> 254
    //   252: iconst_1
    //   253: istore_2
    //   254: aload_3
    //   255: iload_2
    //   256: invokestatic 91	com/inmobi/androidsdk/IMAdView:d	(Lcom/inmobi/androidsdk/IMAdView;Z)V
    //   259: aload_0
    //   260: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   263: iconst_0
    //   264: invokestatic 93	com/inmobi/androidsdk/IMAdView:a	(Lcom/inmobi/androidsdk/IMAdView;Z)V
    //   267: aload_0
    //   268: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   271: invokestatic 96	com/inmobi/androidsdk/IMAdView:s	(Lcom/inmobi/androidsdk/IMAdView;)V
    //   274: goto -162 -> 112
    //   277: astore_3
    //   278: aload_1
    //   279: aload_0
    //   280: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   283: invokevirtual 25	com/inmobi/androidsdk/IMAdView:a	()Landroid/view/animation/Animation;
    //   286: invokevirtual 29	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   289: ifne +13 -> 302
    //   292: aload_0
    //   293: getfield 14	com/inmobi/androidsdk/a:a	Lcom/inmobi/androidsdk/IMAdView;
    //   296: bipush 100
    //   298: aconst_null
    //   299: invokestatic 74	com/inmobi/androidsdk/IMAdView:a	(Lcom/inmobi/androidsdk/IMAdView;ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   302: aload_3
    //   303: athrow
    //   304: astore_3
    //   305: goto -145 -> 160
    //   308: astore_3
    //   309: goto -251 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	a
    //   0	312	1	paramAnimation	Animation
    //   1	255	2	bool	boolean
    //   67	130	3	localLayoutParams	android.widget.RelativeLayout.LayoutParams
    //   203	6	3	localException1	Exception
    //   241	14	3	localIMAdView	IMAdView
    //   277	26	3	localObject	Object
    //   304	1	3	localException2	Exception
    //   308	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   2	31	203	java/lang/Exception
    //   58	98	203	java/lang/Exception
    //   98	112	203	java/lang/Exception
    //   160	200	203	java/lang/Exception
    //   237	242	203	java/lang/Exception
    //   242	252	203	java/lang/Exception
    //   254	274	203	java/lang/Exception
    //   2	31	277	finally
    //   35	58	277	finally
    //   58	98	277	finally
    //   98	112	277	finally
    //   137	160	277	finally
    //   160	200	277	finally
    //   204	212	277	finally
    //   237	242	277	finally
    //   242	252	277	finally
    //   254	274	277	finally
    //   137	160	304	java/lang/Exception
    //   35	58	308	java/lang/Exception
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */