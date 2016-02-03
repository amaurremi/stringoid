package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;

public class ds
  extends AdNetworkView
{
  private static final String a = ds.class.getSimpleName();
  private final String f;
  private final String g;
  private final String h;
  
  ds(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdCreative paramAdCreative, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdCreative);
    this.f = paramBundle.getString("com.flurry.jumptap.PUBLISHER_ID");
    this.g = paramBundle.getString("com.flurry.jumptap.SPOT_ID");
    this.h = paramBundle.getString("com.flurry.jumptap.SITE_ID");
    setFocusable(true);
  }
  
  /* Error */
  public void initLayout()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 54	com/flurry/android/monolithic/sdk/impl/ds:getContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: invokestatic 60	com/jumptap/adtag/JtAdWidgetSettingsFactory:createWidgetSettings	()Lcom/jumptap/adtag/JtAdWidgetSettings;
    //   8: astore_3
    //   9: aload_3
    //   10: aload_0
    //   11: getfield 35	com/flurry/android/monolithic/sdk/impl/ds:f	Ljava/lang/String;
    //   14: invokevirtual 66	com/jumptap/adtag/JtAdWidgetSettings:setPublisherId	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 39	com/flurry/android/monolithic/sdk/impl/ds:g	Ljava/lang/String;
    //   21: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +11 -> 35
    //   27: aload_3
    //   28: aload_0
    //   29: getfield 39	com/flurry/android/monolithic/sdk/impl/ds:g	Ljava/lang/String;
    //   32: invokevirtual 75	com/jumptap/adtag/JtAdWidgetSettings:setSpotId	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 43	com/flurry/android/monolithic/sdk/impl/ds:h	Ljava/lang/String;
    //   39: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +11 -> 53
    //   45: aload_3
    //   46: aload_0
    //   47: getfield 43	com/flurry/android/monolithic/sdk/impl/ds:h	Ljava/lang/String;
    //   50: invokevirtual 78	com/jumptap/adtag/JtAdWidgetSettings:setSiteId	(Ljava/lang/String;)V
    //   53: aload_3
    //   54: aload_2
    //   55: invokestatic 84	com/flurry/android/monolithic/sdk/impl/il:c	(Landroid/content/Context;)Ljava/lang/String;
    //   58: invokevirtual 87	com/jumptap/adtag/JtAdWidgetSettings:setApplicationId	(Ljava/lang/String;)V
    //   61: aload_3
    //   62: aload_2
    //   63: invokestatic 90	com/flurry/android/monolithic/sdk/impl/il:d	(Landroid/content/Context;)Ljava/lang/String;
    //   66: invokevirtual 93	com/jumptap/adtag/JtAdWidgetSettings:setApplicationVersion	(Ljava/lang/String;)V
    //   69: aload_3
    //   70: iconst_0
    //   71: invokevirtual 97	com/jumptap/adtag/JtAdWidgetSettings:setRefreshPeriod	(I)V
    //   74: aload_3
    //   75: iconst_0
    //   76: invokevirtual 100	com/jumptap/adtag/JtAdWidgetSettings:setShouldSendLocation	(Z)V
    //   79: aload_0
    //   80: bipush 17
    //   82: invokevirtual 103	com/flurry/android/monolithic/sdk/impl/ds:setGravity	(I)V
    //   85: new 105	com/jumptap/adtag/JtAdView
    //   88: dup
    //   89: aload_2
    //   90: checkcast 107	android/app/Activity
    //   93: aload_3
    //   94: invokespecial 110	com/jumptap/adtag/JtAdView:<init>	(Landroid/content/Context;Lcom/jumptap/adtag/JtAdWidgetSettings;)V
    //   97: astore_2
    //   98: aload_0
    //   99: invokevirtual 114	com/flurry/android/monolithic/sdk/impl/ds:getResources	()Landroid/content/res/Resources;
    //   102: invokevirtual 120	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   105: getfield 126	android/util/DisplayMetrics:density	F
    //   108: fstore_1
    //   109: iconst_3
    //   110: getstatic 19	com/flurry/android/monolithic/sdk/impl/ds:a	Ljava/lang/String;
    //   113: new 128	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   120: ldc -124
    //   122: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: fload_1
    //   126: invokevirtual 139	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   129: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 147	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   135: aload_2
    //   136: new 149	android/widget/LinearLayout$LayoutParams
    //   139: dup
    //   140: ldc -106
    //   142: fload_1
    //   143: fmul
    //   144: ldc -105
    //   146: fadd
    //   147: f2i
    //   148: fload_1
    //   149: ldc -104
    //   151: fmul
    //   152: ldc -105
    //   154: fadd
    //   155: f2i
    //   156: invokespecial 155	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   159: invokevirtual 159	com/jumptap/adtag/JtAdView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   162: aload_2
    //   163: new 161	com/flurry/android/monolithic/sdk/impl/dt
    //   166: dup
    //   167: aload_0
    //   168: invokespecial 164	com/flurry/android/monolithic/sdk/impl/dt:<init>	(Lcom/flurry/android/monolithic/sdk/impl/ds;)V
    //   171: invokevirtual 168	com/jumptap/adtag/JtAdView:setAdViewListener	(Lcom/jumptap/adtag/JtAdViewListener;)V
    //   174: aload_0
    //   175: aload_2
    //   176: invokevirtual 172	com/flurry/android/monolithic/sdk/impl/ds:addView	(Landroid/view/View;)V
    //   179: return
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_2
    //   183: iconst_3
    //   184: getstatic 19	com/flurry/android/monolithic/sdk/impl/ds:a	Ljava/lang/String;
    //   187: ldc -82
    //   189: invokestatic 147	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   192: goto -30 -> 162
    //   195: astore_3
    //   196: goto -13 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	ds
    //   108	41	1	f1	float
    //   4	172	2	localObject1	Object
    //   180	1	2	localJtException1	com.jumptap.adtag.utils.JtException
    //   182	1	2	localObject2	Object
    //   8	86	3	localJtAdWidgetSettings	com.jumptap.adtag.JtAdWidgetSettings
    //   195	1	3	localJtException2	com.jumptap.adtag.utils.JtException
    // Exception table:
    //   from	to	target	type
    //   85	98	180	com/jumptap/adtag/utils/JtException
    //   98	162	195	com/jumptap/adtag/utils/JtException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */