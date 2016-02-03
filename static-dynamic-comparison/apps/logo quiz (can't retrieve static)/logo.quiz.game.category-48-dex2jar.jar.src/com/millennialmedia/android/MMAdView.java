package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Random;

public final class MMAdView
  extends MMLayout
  implements View.OnClickListener, Animation.AnimationListener
{
  static final int DEFAULT_RESIZE_PARAM_VALUES = -50;
  public static final int TRANSITION_DOWN = 3;
  public static final int TRANSITION_FADE = 1;
  public static final int TRANSITION_NONE = 0;
  public static final int TRANSITION_RANDOM = 4;
  public static final int TRANSITION_UP = 2;
  int height = 0;
  int oldHeight = -50;
  int oldWidth = -50;
  ImageView refreshAnimationimageView;
  int transitionType = 4;
  ResizeView view;
  int width = 0;
  
  public MMAdView(Context paramContext)
  {
    super(paramContext);
    this.adImpl = new MMAdViewMMAdImpl(paramContext);
    init(paramContext);
  }
  
  @Deprecated
  public MMAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @Deprecated
  public MMAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    String str1;
    String str2;
    if (!isInEditMode())
    {
      MMSDK.Log.d("Creating MMAdView from XML layout.");
      this.adImpl = new MMAdViewMMAdImpl(paramContext);
      if (paramAttributeSet != null)
      {
        setApid(paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "apid"));
        this.adImpl.ignoreDensityScaling = paramAttributeSet.getAttributeBooleanValue("http://millennialmedia.com/android/schema", "ignoreDensityScaling", false);
        str1 = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "height");
        str2 = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "width");
      }
    }
    try
    {
      if (!TextUtils.isEmpty(str1)) {
        this.height = Integer.parseInt(str1);
      }
      if (!TextUtils.isEmpty(str2)) {
        this.width = Integer.parseInt(str2);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    if (this.adImpl.mmRequest != null)
    {
      this.adImpl.mmRequest.age = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "age");
      this.adImpl.mmRequest.children = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "children");
      this.adImpl.mmRequest.education = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "education");
      this.adImpl.mmRequest.ethnicity = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "ethnicity");
      this.adImpl.mmRequest.gender = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "gender");
      this.adImpl.mmRequest.income = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "income");
      this.adImpl.mmRequest.keywords = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "keywords");
      this.adImpl.mmRequest.orientation = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "orientation");
      this.adImpl.mmRequest.marital = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "marital");
      this.adImpl.mmRequest.politics = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "politics");
      this.adImpl.mmRequest.vendor = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "vendor");
      this.adImpl.mmRequest.zip = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "zip");
    }
    this.goalId = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "goalId");
    this.adImpl.xmlLayout = true;
    init(paramContext);
    return;
    initEclipseAd(paramContext);
  }
  
  private void attachToWindow(View paramView)
  {
    try
    {
      detachFromParent(paramView);
      Object localObject = getContext();
      if ((localObject != null) && ((localObject instanceof Activity)))
      {
        localObject = ((Activity)localObject).getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if ((localObject != null) && ((localObject instanceof ViewGroup))) {
            ((ViewGroup)localObject).addView(paramView);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private void callSetTranslationX(int paramInt)
  {
    try
    {
      View.class.getMethod("setTranslationX", new Class[] { Float.TYPE }).invoke(this, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException) {}
  }
  
  private void callSetTranslationY(int paramInt)
  {
    try
    {
      View.class.getMethod("setTranslationY", new Class[] { Float.TYPE }).invoke(this, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException) {}
  }
  
  private void detachFromParent(View paramView)
  {
    if (paramView != null) {}
    try
    {
      Object localObject = getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup)))
      {
        localObject = (ViewGroup)localObject;
        if (paramView.getParent() != null) {
          ((ViewGroup)localObject).removeView(paramView);
        }
      }
      return;
    }
    finally {}
  }
  
  private void getAdInternal()
  {
    if (this.adImpl != null) {
      this.adImpl.requestAd();
    }
  }
  
  private boolean hasDefaultResizeParams()
  {
    return (this.oldWidth == -50) && (this.oldHeight == -50);
  }
  
  private void init(Context paramContext)
  {
    setBackgroundColor(0);
    this.adImpl.adType = "b";
    setOnClickListener(this);
    setFocusable(true);
    this.refreshAnimationimageView = new ImageView(paramContext);
    this.refreshAnimationimageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.refreshAnimationimageView.setVisibility(8);
    addView(this.refreshAnimationimageView, new RelativeLayout.LayoutParams(-2, -2));
    setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
  }
  
  /* Error */
  private void initEclipseAd(Context paramContext)
  {
    // Byte code:
    //   0: new 296	android/widget/ImageView
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 297	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   8: astore 14
    //   10: aconst_null
    //   11: astore 10
    //   13: aconst_null
    //   14: astore 11
    //   16: aconst_null
    //   17: astore 12
    //   19: aconst_null
    //   20: astore 8
    //   22: aconst_null
    //   23: astore 9
    //   25: aconst_null
    //   26: astore 5
    //   28: aload 10
    //   30: astore_3
    //   31: aload 8
    //   33: astore 6
    //   35: aload 11
    //   37: astore 4
    //   39: aload 9
    //   41: astore 7
    //   43: ldc_w 326
    //   46: invokestatic 332	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 13
    //   51: aload 13
    //   53: astore_1
    //   54: aload 13
    //   56: ifnull +69 -> 125
    //   59: aload 13
    //   61: astore_1
    //   62: aload 10
    //   64: astore_3
    //   65: aload 8
    //   67: astore 6
    //   69: aload 11
    //   71: astore 4
    //   73: aload 9
    //   75: astore 7
    //   77: aload 13
    //   79: getstatic 337	java/io/File:separator	Ljava/lang/String;
    //   82: invokevirtual 343	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   85: ifne +40 -> 125
    //   88: aload 10
    //   90: astore_3
    //   91: aload 8
    //   93: astore 6
    //   95: aload 11
    //   97: astore 4
    //   99: aload 9
    //   101: astore 7
    //   103: new 345	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   110: aload 13
    //   112: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: getstatic 337	java/io/File:separator	Ljava/lang/String;
    //   118: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore_1
    //   125: aload 10
    //   127: astore_3
    //   128: aload 8
    //   130: astore 6
    //   132: aload 11
    //   134: astore 4
    //   136: aload 9
    //   138: astore 7
    //   140: new 334	java/io/File
    //   143: dup
    //   144: new 345	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   151: aload_1
    //   152: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 357
    //   158: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: astore 13
    //   169: aload 12
    //   171: astore_1
    //   172: aload 10
    //   174: astore_3
    //   175: aload 8
    //   177: astore 6
    //   179: aload 11
    //   181: astore 4
    //   183: aload 9
    //   185: astore 7
    //   187: aload 13
    //   189: invokevirtual 362	java/io/File:exists	()Z
    //   192: ifne +197 -> 389
    //   195: aload 10
    //   197: astore_3
    //   198: aload 8
    //   200: astore 6
    //   202: aload 11
    //   204: astore 4
    //   206: aload 9
    //   208: astore 7
    //   210: new 364	java/net/URL
    //   213: dup
    //   214: ldc_w 366
    //   217: invokespecial 367	java/net/URL:<init>	(Ljava/lang/String;)V
    //   220: invokevirtual 371	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   223: checkcast 373	java/net/HttpURLConnection
    //   226: astore_1
    //   227: aload 10
    //   229: astore_3
    //   230: aload 8
    //   232: astore 6
    //   234: aload 11
    //   236: astore 4
    //   238: aload 9
    //   240: astore 7
    //   242: aload_1
    //   243: iconst_1
    //   244: invokevirtual 376	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   247: aload 10
    //   249: astore_3
    //   250: aload 8
    //   252: astore 6
    //   254: aload 11
    //   256: astore 4
    //   258: aload 9
    //   260: astore 7
    //   262: aload_1
    //   263: sipush 10000
    //   266: invokevirtual 379	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   269: aload 10
    //   271: astore_3
    //   272: aload 8
    //   274: astore 6
    //   276: aload 11
    //   278: astore 4
    //   280: aload 9
    //   282: astore 7
    //   284: aload_1
    //   285: invokevirtual 382	java/net/HttpURLConnection:connect	()V
    //   288: aload 10
    //   290: astore_3
    //   291: aload 8
    //   293: astore 6
    //   295: aload 11
    //   297: astore 4
    //   299: aload 9
    //   301: astore 7
    //   303: aload_1
    //   304: invokevirtual 386	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   307: astore_1
    //   308: aload_1
    //   309: astore_3
    //   310: aload 8
    //   312: astore 6
    //   314: aload_1
    //   315: astore 4
    //   317: aload 9
    //   319: astore 7
    //   321: new 388	java/io/FileOutputStream
    //   324: dup
    //   325: aload 13
    //   327: invokespecial 391	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   330: astore 5
    //   332: sipush 1024
    //   335: newarray <illegal type>
    //   337: astore_3
    //   338: aload_1
    //   339: aload_3
    //   340: invokevirtual 397	java/io/InputStream:read	([B)I
    //   343: istore_2
    //   344: iload_2
    //   345: ifle +44 -> 389
    //   348: aload 5
    //   350: aload_3
    //   351: iconst_0
    //   352: iload_2
    //   353: invokevirtual 403	java/io/OutputStream:write	([BII)V
    //   356: goto -18 -> 338
    //   359: astore_3
    //   360: aload 5
    //   362: astore 7
    //   364: aload_1
    //   365: ifnull +7 -> 372
    //   368: aload_1
    //   369: invokevirtual 406	java/io/InputStream:close	()V
    //   372: aload 7
    //   374: ifnull +8 -> 382
    //   377: aload 7
    //   379: invokevirtual 407	java/io/OutputStream:close	()V
    //   382: aload_0
    //   383: aload 14
    //   385: invokevirtual 408	com/millennialmedia/android/MMAdView:addView	(Landroid/view/View;)V
    //   388: return
    //   389: aload_1
    //   390: astore_3
    //   391: aload 5
    //   393: astore 6
    //   395: aload_1
    //   396: astore 4
    //   398: aload 5
    //   400: astore 7
    //   402: aload 13
    //   404: invokevirtual 411	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   407: invokestatic 417	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   410: astore 8
    //   412: aload 14
    //   414: ifnull +28 -> 442
    //   417: aload 8
    //   419: ifnull +23 -> 442
    //   422: aload_1
    //   423: astore_3
    //   424: aload 5
    //   426: astore 6
    //   428: aload_1
    //   429: astore 4
    //   431: aload 5
    //   433: astore 7
    //   435: aload 14
    //   437: aload 8
    //   439: invokevirtual 421	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   442: aload_1
    //   443: ifnull +7 -> 450
    //   446: aload_1
    //   447: invokevirtual 406	java/io/InputStream:close	()V
    //   450: aload 5
    //   452: ifnull -70 -> 382
    //   455: aload 5
    //   457: invokevirtual 407	java/io/OutputStream:close	()V
    //   460: goto -78 -> 382
    //   463: astore_1
    //   464: goto -82 -> 382
    //   467: astore_1
    //   468: aload_3
    //   469: ifnull +7 -> 476
    //   472: aload_3
    //   473: invokevirtual 406	java/io/InputStream:close	()V
    //   476: aload 6
    //   478: ifnull +8 -> 486
    //   481: aload 6
    //   483: invokevirtual 407	java/io/OutputStream:close	()V
    //   486: aload_1
    //   487: athrow
    //   488: astore_3
    //   489: goto -3 -> 486
    //   492: astore 4
    //   494: aload_1
    //   495: astore_3
    //   496: aload 5
    //   498: astore 6
    //   500: aload 4
    //   502: astore_1
    //   503: goto -35 -> 468
    //   506: astore_1
    //   507: goto -125 -> 382
    //   510: astore_1
    //   511: aload 4
    //   513: astore_1
    //   514: goto -150 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	MMAdView
    //   0	517	1	paramContext	Context
    //   343	10	2	i	int
    //   30	321	3	localObject1	Object
    //   359	1	3	localException1	Exception
    //   390	83	3	localContext1	Context
    //   488	1	3	localException2	Exception
    //   495	1	3	localContext2	Context
    //   37	393	4	localObject2	Object
    //   492	20	4	localObject3	Object
    //   26	471	5	localFileOutputStream	java.io.FileOutputStream
    //   33	466	6	localObject4	Object
    //   41	393	7	localObject5	Object
    //   20	418	8	localBitmap	Bitmap
    //   23	295	9	localObject6	Object
    //   11	278	10	localObject7	Object
    //   14	282	11	localObject8	Object
    //   17	153	12	localObject9	Object
    //   49	354	13	localObject10	Object
    //   8	428	14	localImageView	ImageView
    // Exception table:
    //   from	to	target	type
    //   332	338	359	java/lang/Exception
    //   338	344	359	java/lang/Exception
    //   348	356	359	java/lang/Exception
    //   446	450	463	java/lang/Exception
    //   455	460	463	java/lang/Exception
    //   43	51	467	finally
    //   77	88	467	finally
    //   103	125	467	finally
    //   140	169	467	finally
    //   187	195	467	finally
    //   210	227	467	finally
    //   242	247	467	finally
    //   262	269	467	finally
    //   284	288	467	finally
    //   303	308	467	finally
    //   321	332	467	finally
    //   402	412	467	finally
    //   435	442	467	finally
    //   472	476	488	java/lang/Exception
    //   481	486	488	java/lang/Exception
    //   332	338	492	finally
    //   338	344	492	finally
    //   348	356	492	finally
    //   368	372	506	java/lang/Exception
    //   377	382	506	java/lang/Exception
    //   43	51	510	java/lang/Exception
    //   77	88	510	java/lang/Exception
    //   103	125	510	java/lang/Exception
    //   140	169	510	java/lang/Exception
    //   187	195	510	java/lang/Exception
    //   210	227	510	java/lang/Exception
    //   242	247	510	java/lang/Exception
    //   262	269	510	java/lang/Exception
    //   284	288	510	java/lang/Exception
    //   303	308	510	java/lang/Exception
    //   321	332	510	java/lang/Exception
    //   402	412	510	java/lang/Exception
    //   435	442	510	java/lang/Exception
  }
  
  private void setUnresizeParameters()
  {
    if (hasDefaultResizeParams())
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.oldWidth = localLayoutParams.width;
      this.oldHeight = localLayoutParams.height;
      if (this.oldWidth <= 0) {
        this.oldWidth = getWidth();
      }
      if (this.oldHeight <= 0) {
        this.oldHeight = getHeight();
      }
    }
  }
  
  void closeAreaTouched()
  {
    this.adImpl.unresizeToDefault();
  }
  
  public void getAd()
  {
    if ((this.adImpl != null) && (this.adImpl.requestListener != null))
    {
      getAd(this.adImpl.requestListener);
      return;
    }
    getAdInternal();
  }
  
  public void getAd(RequestListener paramRequestListener)
  {
    if (this.adImpl != null) {
      this.adImpl.requestListener = paramRequestListener;
    }
    getAdInternal();
  }
  
  void handleMraidResize(DTOResizeParameters paramDTOResizeParameters)
  {
    try
    {
      this.refreshAnimationimageView.setImageBitmap(null);
      if (MMSDK.hasSetTranslationMethod())
      {
        if (this.view == null)
        {
          this.view = new ResizeView(getContext());
          this.view.setId(304025022);
          this.view.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
          this.view.setBackgroundColor(0);
        }
        if (this.view.getParent() == null)
        {
          localObject = getParent();
          if ((localObject != null) && ((localObject instanceof ViewGroup))) {
            ((ViewGroup)localObject).addView(this.view);
          }
        }
        Object localObject = new BannerBounds(paramDTOResizeParameters);
        if (!paramDTOResizeParameters.allowOffScreen) {
          ((BannerBounds)localObject).calculateOnScreenBounds();
        }
        int[] arrayOfInt1 = new int[2];
        getLocationInWindow(arrayOfInt1);
        attachToWindow(this);
        int[] arrayOfInt2 = new int[2];
        getLocationInWindow(arrayOfInt2);
        setUnresizeParameters();
        int i = arrayOfInt1[0];
        int j = arrayOfInt2[0];
        int k = arrayOfInt1[1];
        int m = arrayOfInt2[1];
        ((BannerBounds)localObject).modifyLayoutParams(getLayoutParams());
        callSetTranslationX(((BannerBounds)localObject).translationX + (i - j));
        callSetTranslationY(((BannerBounds)localObject).translationY + (k - m));
        setCloseArea(paramDTOResizeParameters.customClosePosition);
      }
      return;
    }
    finally {}
  }
  
  void handleUnresize()
  {
    try
    {
      if (MMSDK.hasSetTranslationMethod())
      {
        removeCloseTouchDelegate();
        Object localObject1;
        if (!hasDefaultResizeParams())
        {
          localObject1 = getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.oldWidth;
          ((ViewGroup.LayoutParams)localObject1).height = this.oldHeight;
          callSetTranslationX(0);
          callSetTranslationY(0);
          this.oldWidth = -50;
          this.oldHeight = -50;
        }
        if (this.view != null)
        {
          this.isResizing = true;
          this.view.attachToContext(this);
          localObject1 = getParent();
          if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
          {
            localObject1 = (ViewGroup)localObject1;
            if (this.view.getParent() != null) {
              ((ViewGroup)localObject1).removeView(this.view);
            }
          }
          this.isResizing = false;
        }
      }
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.refreshAnimationimageView.setVisibility(8);
  }
  
  @Deprecated
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  @Deprecated
  public void onAnimationStart(Animation paramAnimation) {}
  
  @Deprecated
  public void onClick(View paramView)
  {
    MMSDK.Log.d("On click for " + paramView.getId() + " view, " + paramView + " adimpl" + this.adImpl);
    onTouchEvent(MotionEvent.obtain(0L, System.currentTimeMillis(), 1, 0.0F, 0.0F, 0));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Utils.ThreadUtils.execute(new Runnable()
    {
      public void run()
      {
        float f = MMAdView.this.getContext().getResources().getDisplayMetrics().density;
        if (MMAdView.this.width <= 0) {
          MMAdView.this.width = ((int)(MMAdView.this.getWidth() / f));
        }
        if (MMAdView.this.height <= 0) {
          MMAdView.this.height = ((int)(MMAdView.this.getHeight() / f));
        }
      }
    });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.adImpl != null) && (this.adImpl.controller != null))
    {
      if (this.adImpl.controller.webView == null) {
        this.adImpl.controller.webView = MMAdImplController.getWebViewFromExistingAdImpl(this.adImpl);
      }
      if ((this.adImpl.controller.webView != null) && (!this.adImpl.controller.webView.isCurrentParent(this.adImpl.internalId)))
      {
        this.adImpl.controller.webView.removeFromParent();
        addView(this.adImpl.controller.webView);
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if ((this.adImpl != null) && (this.adImpl.controller != null) && (this.adImpl.controller.webView != null)) {
      this.adImpl.controller.webView.setBackgroundColor(paramInt);
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setTransitionType(int paramInt)
  {
    this.transitionType = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  class BannerBounds
  {
    DTOResizeParameters resizeParams;
    int translationX;
    int translationY;
    
    BannerBounds(DTOResizeParameters paramDTOResizeParameters)
    {
      this.resizeParams = paramDTOResizeParameters;
      this.translationX = paramDTOResizeParameters.offsetX;
      this.translationY = paramDTOResizeParameters.offsetY;
    }
    
    private BoundsResult calculateBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = paramInt1;
      int j = paramInt3;
      int k;
      if (paramInt1 + paramInt3 + paramInt2 > paramInt4)
      {
        paramInt2 = paramInt4 - paramInt3 + paramInt2;
        if (paramInt2 < 0)
        {
          i = 0;
          k = paramInt4;
        }
      }
      for (;;)
      {
        BoundsResult localBoundsResult = new BoundsResult(null);
        localBoundsResult.translation = (i - paramInt1);
        localBoundsResult.size = k;
        return localBoundsResult;
        k = j;
        i = paramInt2;
        if (paramInt2 + paramInt3 > paramInt4)
        {
          i = paramInt4 - paramInt3;
          k = j;
          continue;
          k = j;
          if (paramInt2 > 0)
          {
            k = j;
            i = paramInt2;
          }
        }
      }
    }
    
    private void calculateXBounds()
    {
      Object localObject = new int[2];
      MMAdView.this.getLocationInWindow((int[])localObject);
      localObject = calculateBounds(localObject[0], this.resizeParams.offsetX, this.resizeParams.width, this.resizeParams.xMax);
      this.resizeParams.width = ((BoundsResult)localObject).size;
      this.translationX = ((BoundsResult)localObject).translation;
    }
    
    private void calculateYBounds()
    {
      Object localObject = new int[2];
      MMAdView.this.getLocationInWindow((int[])localObject);
      localObject = calculateBounds(localObject[1], this.resizeParams.offsetY, this.resizeParams.height, this.resizeParams.yMax);
      this.resizeParams.height = ((BoundsResult)localObject).size;
      this.translationY = ((BoundsResult)localObject).translation;
    }
    
    void calculateOnScreenBounds()
    {
      calculateXBounds();
      calculateYBounds();
    }
    
    ViewGroup.LayoutParams modifyLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      paramLayoutParams.width = this.resizeParams.width;
      paramLayoutParams.height = this.resizeParams.height;
      return paramLayoutParams;
    }
    
    private class BoundsResult
    {
      int size;
      int translation;
      
      private BoundsResult() {}
    }
  }
  
  class MMAdViewMMAdImpl
    extends MMLayout.MMLayoutMMAdImpl
  {
    public MMAdViewMMAdImpl(Context paramContext)
    {
      super(paramContext);
      this.mmWebViewClientListener = new MMAdView.MMAdViewWebViewClientListener(this);
    }
    
    void animateTransition()
    {
      final Object localObject;
      if (MMAdView.this.refreshAnimationimageView.getDrawable() != null)
      {
        int j = MMAdView.this.transitionType;
        int i = j;
        if (j == 4) {
          i = new Random().nextInt(4);
        }
        switch (i)
        {
        default: 
          localObject = new AlphaAnimation(1.0F, 0.0F);
        }
      }
      for (;;)
      {
        ((Animation)localObject).setDuration(1000L);
        ((Animation)localObject).setAnimationListener(MMAdView.this);
        ((Animation)localObject).setFillEnabled(true);
        ((Animation)localObject).setFillBefore(true);
        ((Animation)localObject).setFillAfter(true);
        MMSDK.runOnUiThread(new Runnable()
        {
          public void run()
          {
            MMAdView.this.refreshAnimationimageView.startAnimation(localObject);
          }
        });
        return;
        localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -MMAdView.this.getHeight());
        continue;
        localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, MMAdView.this.getHeight());
      }
    }
    
    String getReqType()
    {
      return "getad";
    }
    
    String getRequestCompletedAction()
    {
      return "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
    }
    
    String getRequestFailedAction()
    {
      return "millennialmedia.action.ACTION_GETAD_FAILED";
    }
    
    public boolean hasCachedVideoSupport()
    {
      return false;
    }
    
    void insertUrlAdMetaValues(Map<String, String> paramMap)
    {
      if (MMAdView.this.height > 0) {
        paramMap.put("hsht", String.valueOf(MMAdView.this.height));
      }
      if (MMAdView.this.width > 0) {
        paramMap.put("hswd", String.valueOf(MMAdView.this.width));
      }
      super.insertUrlAdMetaValues(paramMap);
    }
    
    public boolean isBanner()
    {
      return true;
    }
    
    boolean isLifecycleObservable()
    {
      return MMAdView.this.getWindowToken() != null;
    }
    
    boolean isTransitionAnimated()
    {
      return MMAdView.this.transitionType != 0;
    }
    
    void prepareTransition(Bitmap paramBitmap)
    {
      MMAdView.this.refreshAnimationimageView.setImageBitmap(paramBitmap);
      MMAdView.this.refreshAnimationimageView.setVisibility(0);
      MMAdView.this.refreshAnimationimageView.bringToFront();
    }
  }
  
  private static class MMAdViewWebViewClientListener
    extends MMAdImpl.BasicWebViewClientListener
  {
    MMAdViewWebViewClientListener(MMAdImpl paramMMAdImpl)
    {
      super();
    }
    
    public void onPageFinished(String paramString)
    {
      super.onPageFinished(paramString);
      paramString = (MMAdImpl)this.adImplRef.get();
      if ((paramString != null) && (paramString.isTransitionAnimated())) {
        paramString.animateTransition();
      }
    }
  }
  
  class ResizeView
    extends View
  {
    public ResizeView(Context paramContext)
    {
      super();
    }
    
    void attachToContext(View paramView)
    {
      try
      {
        MMAdView.this.detachFromParent(paramView);
        if ((getParent() != null) && ((getParent() instanceof ViewGroup))) {
          ((ViewGroup)getParent()).addView(paramView);
        }
        return;
      }
      finally
      {
        paramView = finally;
        throw paramView;
      }
    }
    
    protected void onRestoreInstanceState(Parcelable paramParcelable)
    {
      MMSDK.Log.d("onRestoreInstanceState");
      MMAdView.this.attachToWindow(MMAdView.this);
      super.onRestoreInstanceState(paramParcelable);
    }
    
    protected Parcelable onSaveInstanceState()
    {
      MMSDK.Log.d("onSaveInstanceState");
      attachToContext(MMAdView.this);
      return super.onSaveInstanceState();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/MMAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */