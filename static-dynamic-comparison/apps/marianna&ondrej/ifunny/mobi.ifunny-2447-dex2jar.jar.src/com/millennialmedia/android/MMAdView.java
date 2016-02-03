package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;

import java.lang.reflect.Method;

public final class MMAdView
        extends MMLayout
        implements View.OnClickListener, Animation.AnimationListener {
    public static final int TRANSITION_DOWN = 3;
    public static final int TRANSITION_FADE = 1;
    public static final int TRANSITION_NONE = 0;
    public static final int TRANSITION_RANDOM = 4;
    public static final int TRANSITION_UP = 2;
    ImageView a;
    int b = 4;
    int c = 0;
    int d = 0;
    int e = -50;
    int f = -50;
    MMAdView.ResizeView g;

    public MMAdView(Context paramContext) {
        super(paramContext);
        this.h = new MMAdView.MMAdViewMMAdImpl(this, paramContext);
        b(paramContext);
    }

    @Deprecated
    public MMAdView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    @Deprecated
    public MMAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        if (!isInEditMode()) {
            MMLog.b("MMAdView", "Creating MMAdView from XML layout.");
            this.h = new MMAdView.MMAdViewMMAdImpl(this, paramContext);
            String str1;
            String str2;
            if (paramAttributeSet != null) {
                setApid(paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "apid"));
                this.h.d = paramAttributeSet.getAttributeBooleanValue("http://millennialmedia.com/android/schema", "ignoreDensityScaling", false);
                str1 = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "height");
                str2 = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "width");
            }
            try {
                if (!TextUtils.isEmpty(str1)) {
                    this.c = Integer.parseInt(str1);
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.d = Integer.parseInt(str2);
                }
            } catch (NumberFormatException localNumberFormatException) {
                for (; ; ) {
                    MMLog.a("MMAdView", "Error reading attrs file from xml", localNumberFormatException);
                }
            }
            if (this.h.b != null) {
                this.h.b.a = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "age");
                this.h.b.b = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "children");
                this.h.b.c = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "education");
                this.h.b.d = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "ethnicity");
                this.h.b.e = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "gender");
                this.h.b.f = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "income");
                this.h.b.g = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "keywords");
                this.h.b.h = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "marital");
                this.h.b.i = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "politics");
                this.h.b.j = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "vendor");
                this.h.b.k = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "zip");
            }
            this.i = paramAttributeSet.getAttributeValue("http://millennialmedia.com/android/schema", "goalId");
            b(paramContext);
            return;
        }
        c(paramContext);
    }

    private void a(int paramInt) {
        try {
            View.class.getMethod("setTranslationX", new Class[]{Float.TYPE}).invoke(this, new Object[]{Integer.valueOf(paramInt)});
            return;
        } catch (Exception localException) {
            MMLog.a("MMAdView", "Unable to call setTranslationX", localException);
        }
    }

    private void a(View paramView) {
        if (paramView != null) {
        }
        try {
            Object localObject = getParent();
            if ((localObject != null) && ((localObject instanceof ViewGroup))) {
                localObject = (ViewGroup) localObject;
                if (paramView.getParent() != null) {
                    ((ViewGroup) localObject).removeView(paramView);
                }
            }
            return;
        } finally {
        }
    }

    private void b(int paramInt) {
        try {
            View.class.getMethod("setTranslationY", new Class[]{Float.TYPE}).invoke(this, new Object[]{Integer.valueOf(paramInt)});
            return;
        } catch (Exception localException) {
            MMLog.a("MMAdView", "Unable to call setTranslationY", localException);
        }
    }

    private void b(Context paramContext) {
        setBackgroundColor(0);
        this.h.f = "b";
        setOnClickListener(this);
        setFocusable(true);
        this.a = new ImageView(paramContext);
        this.a.setScaleType(ImageView.ScaleType.FIT_XY);
        this.a.setVisibility(8);
        addView(this.a, new RelativeLayout.LayoutParams(-2, -2));
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    private void b(View paramView) {
        try {
            a(paramView);
            Object localObject = getContext();
            if ((localObject != null) && ((localObject instanceof Activity))) {
                localObject = ((Activity) localObject).getWindow();
                if (localObject != null) {
                    localObject = ((Window) localObject).getDecorView();
                    if ((localObject != null) && ((localObject instanceof ViewGroup))) {
                        ((ViewGroup) localObject).addView(paramView);
                    }
                }
            }
            return;
        } finally {
        }
    }

    private void c() {
        if (d()) {
            ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
            this.f = localLayoutParams.width;
            this.e = localLayoutParams.height;
            if (this.f <= 0) {
                this.f = getWidth();
            }
            if (this.e <= 0) {
                this.e = getHeight();
            }
        }
    }

    /* Error */
    private void c(Context paramContext) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: aconst_null
        //   3: astore 6
        //   5: aconst_null
        //   6: astore 4
        //   8: new 246	android/widget/ImageView
        //   11: dup
        //   12: aload_1
        //   13: invokespecial 247	android/widget/ImageView:<init>	(Landroid/content/Context;)V
        //   16: astore 7
        //   18: ldc_w 317
        //   21: invokestatic 323	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
        //   24: astore 5
        //   26: aload 5
        //   28: astore_1
        //   29: aload 5
        //   31: ifnull +39 -> 70
        //   34: aload 5
        //   36: astore_1
        //   37: aload 5
        //   39: getstatic 328	java/io/File:separator	Ljava/lang/String;
        //   42: invokevirtual 334	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   45: ifne +25 -> 70
        //   48: new 336	java/lang/StringBuilder
        //   51: dup
        //   52: invokespecial 338	java/lang/StringBuilder:<init>	()V
        //   55: aload 5
        //   57: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   60: getstatic 328	java/io/File:separator	Ljava/lang/String;
        //   63: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   69: astore_1
        //   70: new 325	java/io/File
        //   73: dup
        //   74: new 336	java/lang/StringBuilder
        //   77: dup
        //   78: invokespecial 338	java/lang/StringBuilder:<init>	()V
        //   81: aload_1
        //   82: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   85: ldc_w 348
        //   88: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   91: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   94: invokespecial 350	java/io/File:<init>	(Ljava/lang/String;)V
        //   97: astore 8
        //   99: aload 8
        //   101: invokevirtual 353	java/io/File:exists	()Z
        //   104: ifne +292 -> 396
        //   107: new 355	java/net/URL
        //   110: dup
        //   111: ldc_w 357
        //   114: invokespecial 358	java/net/URL:<init>	(Ljava/lang/String;)V
        //   117: invokevirtual 362	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   120: checkcast 364	java/net/HttpURLConnection
        //   123: astore_1
        //   124: aload_1
        //   125: iconst_1
        //   126: invokevirtual 367	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   129: aload_1
        //   130: sipush 10000
        //   133: invokevirtual 370	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   136: aload_1
        //   137: invokevirtual 373	java/net/HttpURLConnection:connect	()V
        //   140: aload_1
        //   141: invokevirtual 377	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   144: astore_1
        //   145: new 379	java/io/FileOutputStream
        //   148: dup
        //   149: aload 8
        //   151: invokespecial 382	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   154: astore_3
        //   155: sipush 1024
        //   158: newarray <illegal type>
        //   160: astore 4
        //   162: aload_1
        //   163: aload 4
        //   165: invokevirtual 388	java/io/InputStream:read	([B)I
        //   168: istore_2
        //   169: iload_2
        //   170: ifle +63 -> 233
        //   173: aload_3
        //   174: aload 4
        //   176: iconst_0
        //   177: iload_2
        //   178: invokevirtual 394	java/io/OutputStream:write	([BII)V
        //   181: goto -19 -> 162
        //   184: astore 5
        //   186: aload_3
        //   187: astore 4
        //   189: aload 5
        //   191: astore_3
        //   192: aload 4
        //   194: astore 6
        //   196: aload_1
        //   197: astore 5
        //   199: ldc 69
        //   201: ldc_w 396
        //   204: aload_3
        //   205: invokestatic 178	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   208: aload_1
        //   209: ifnull +7 -> 216
        //   212: aload_1
        //   213: invokevirtual 399	java/io/InputStream:close	()V
        //   216: aload 4
        //   218: ifnull +8 -> 226
        //   221: aload 4
        //   223: invokevirtual 400	java/io/OutputStream:close	()V
        //   226: aload_0
        //   227: aload 7
        //   229: invokevirtual 401	com/millennialmedia/android/MMAdView:addView	(Landroid/view/View;)V
        //   232: return
        //   233: aload_3
        //   234: astore 4
        //   236: aload 4
        //   238: astore 6
        //   240: aload_1
        //   241: astore 5
        //   243: aload 8
        //   245: invokevirtual 404	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   248: invokestatic 410	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   251: astore_3
        //   252: aload 7
        //   254: ifnull +20 -> 274
        //   257: aload_3
        //   258: ifnull +16 -> 274
        //   261: aload 4
        //   263: astore 6
        //   265: aload_1
        //   266: astore 5
        //   268: aload 7
        //   270: aload_3
        //   271: invokevirtual 414	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
        //   274: aload_1
        //   275: ifnull +7 -> 282
        //   278: aload_1
        //   279: invokevirtual 399	java/io/InputStream:close	()V
        //   282: aload 4
        //   284: ifnull -58 -> 226
        //   287: aload 4
        //   289: invokevirtual 400	java/io/OutputStream:close	()V
        //   292: goto -66 -> 226
        //   295: astore_1
        //   296: ldc 69
        //   298: ldc_w 416
        //   301: aload_1
        //   302: invokestatic 178	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   305: goto -79 -> 226
        //   308: astore_1
        //   309: aconst_null
        //   310: astore_3
        //   311: aload_3
        //   312: ifnull +7 -> 319
        //   315: aload_3
        //   316: invokevirtual 399	java/io/InputStream:close	()V
        //   319: aload 6
        //   321: ifnull +8 -> 329
        //   324: aload 6
        //   326: invokevirtual 400	java/io/OutputStream:close	()V
        //   329: aload_1
        //   330: athrow
        //   331: astore_3
        //   332: ldc 69
        //   334: ldc_w 416
        //   337: aload_3
        //   338: invokestatic 178	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   341: goto -12 -> 329
        //   344: astore_1
        //   345: goto -49 -> 296
        //   348: astore 4
        //   350: aload_1
        //   351: astore_3
        //   352: aload 4
        //   354: astore_1
        //   355: goto -44 -> 311
        //   358: astore 5
        //   360: aload_1
        //   361: astore 4
        //   363: aload 5
        //   365: astore_1
        //   366: aload_3
        //   367: astore 6
        //   369: aload 4
        //   371: astore_3
        //   372: goto -61 -> 311
        //   375: astore_1
        //   376: aload 5
        //   378: astore_3
        //   379: goto -68 -> 311
        //   382: astore_3
        //   383: aconst_null
        //   384: astore_1
        //   385: goto -193 -> 192
        //   388: astore_3
        //   389: goto -197 -> 192
        //   392: astore_3
        //   393: goto -201 -> 192
        //   396: aconst_null
        //   397: astore_1
        //   398: aload_3
        //   399: astore 4
        //   401: goto -165 -> 236
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	404	0	this	MMAdView
        //   0	404	1	paramContext	Context
        //   168	10	2	i	int
        //   1	315	3	localObject1	Object
        //   331	7	3	localException1	Exception
        //   351	28	3	localObject2	Object
        //   382	1	3	localException2	Exception
        //   388	1	3	localException3	Exception
        //   392	7	3	localException4	Exception
        //   6	282	4	localObject3	Object
        //   348	5	4	localObject4	Object
        //   361	39	4	localObject5	Object
        //   24	32	5	str	String
        //   184	6	5	localException5	Exception
        //   197	70	5	localContext	Context
        //   358	19	5	localObject6	Object
        //   3	365	6	localObject7	Object
        //   16	253	7	localImageView	ImageView
        //   97	147	8	localFile	java.io.File
        // Exception table:
        //   from	to	target	type
        //   155	162	184	java/lang/Exception
        //   162	169	184	java/lang/Exception
        //   173	181	184	java/lang/Exception
        //   278	282	295	java/lang/Exception
        //   287	292	295	java/lang/Exception
        //   18	26	308	finally
        //   37	70	308	finally
        //   70	145	308	finally
        //   315	319	331	java/lang/Exception
        //   324	329	331	java/lang/Exception
        //   212	216	344	java/lang/Exception
        //   221	226	344	java/lang/Exception
        //   145	155	348	finally
        //   155	162	358	finally
        //   162	169	358	finally
        //   173	181	358	finally
        //   199	208	375	finally
        //   243	252	375	finally
        //   268	274	375	finally
        //   18	26	382	java/lang/Exception
        //   37	70	382	java/lang/Exception
        //   70	145	382	java/lang/Exception
        //   145	155	388	java/lang/Exception
        //   243	252	392	java/lang/Exception
        //   268	274	392	java/lang/Exception
    }

    private boolean d() {
        return (this.f == -50) && (this.e == -50);
    }

    private void getAdInternal() {
        if (this.h != null) {
            this.h.f();
        }
    }

    void a() {
        try {
            if (MMSDK.c()) {
                l();
                Object localObject1;
                if (!d()) {
                    localObject1 = getLayoutParams();
                    ((ViewGroup.LayoutParams) localObject1).width = this.f;
                    ((ViewGroup.LayoutParams) localObject1).height = this.e;
                    a(0);
                    b(0);
                    this.f = -50;
                    this.e = -50;
                }
                if (this.g != null) {
                    this.j = true;
                    this.g.a(this);
                    localObject1 = getParent();
                    if ((localObject1 != null) && ((localObject1 instanceof ViewGroup))) {
                        localObject1 = (ViewGroup) localObject1;
                        if (this.g.getParent() != null) {
                            ((ViewGroup) localObject1).removeView(this.g);
                        }
                    }
                    this.j = false;
                }
            }
            return;
        } finally {
        }
    }

    void a(DTOResizeParameters paramDTOResizeParameters) {
        try {
            this.a.setImageBitmap(null);
            if (MMSDK.c()) {
                if (this.g == null) {
                    this.g = new MMAdView.ResizeView(this, getContext());
                    this.g.setId(304025022);
                    this.g.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
                    this.g.setBackgroundColor(0);
                }
                if (this.g.getParent() == null) {
                    localObject = getParent();
                    if ((localObject != null) && ((localObject instanceof ViewGroup))) {
                        ((ViewGroup) localObject).addView(this.g);
                    }
                }
                Object localObject = new MMAdView.BannerBounds(this, paramDTOResizeParameters);
                if (!paramDTOResizeParameters.f) {
                    ((MMAdView.BannerBounds) localObject).a();
                }
                int[] arrayOfInt1 = new int[2];
                getLocationInWindow(arrayOfInt1);
                b(this);
                int[] arrayOfInt2 = new int[2];
                getLocationInWindow(arrayOfInt2);
                c();
                int i = arrayOfInt1[0];
                int j = arrayOfInt2[0];
                int k = arrayOfInt1[1];
                int m = arrayOfInt2[1];
                ((MMAdView.BannerBounds) localObject).a(getLayoutParams());
                a(((MMAdView.BannerBounds) localObject).a + (i - j));
                b(((MMAdView.BannerBounds) localObject).b + (k - m));
                setCloseArea(paramDTOResizeParameters.c);
            }
            return;
        } finally {
        }
    }

    void b() {
        this.h.p();
    }

    public void getAd() {
        if ((this.h != null) && (this.h.c != null)) {
            getAd(this.h.c);
            return;
        }
        getAdInternal();
    }

    public void getAd(RequestListener paramRequestListener) {
        if (this.h != null) {
            this.h.c = paramRequestListener;
        }
        getAdInternal();
    }

    @Deprecated
    public void onAnimationEnd(Animation paramAnimation) {
        this.a.setVisibility(8);
    }

    @Deprecated
    public void onAnimationRepeat(Animation paramAnimation) {
    }

    @Deprecated
    public void onAnimationStart(Animation paramAnimation) {
    }

    @Deprecated
    public void onClick(View paramView) {
        MMLog.b("MMAdView", "On click for " + paramView.getId() + " view, " + paramView + " adimpl" + this.h);
        onTouchEvent(MotionEvent.obtain(0L, System.currentTimeMillis(), 1, 0.0F, 0.0F, 0));
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        Utils.ThreadUtils.a(new MMAdView .1 (this));
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
        if ((!paramBoolean) || (this.h == null) || (this.h.k == null)) {
        }
        MMWebView localMMWebView;
        do {
            return;
            if (this.h.k.b == null) {
                this.h.k.b = MMAdImplController.d(this.h);
            }
            localMMWebView = this.h.k.b;
        } while ((localMMWebView == null) || (localMMWebView.a(this.h.h)) || (localMMWebView.c.equals("expanded")));
        localMMWebView.v();
        addView(localMMWebView);
    }

    public void setBackgroundColor(int paramInt) {
        super.setBackgroundColor(paramInt);
        if ((this.h != null) && (this.h.k != null) && (this.h.k.b != null)) {
            this.h.k.b.setBackgroundColor(paramInt);
        }
    }

    public void setHeight(int paramInt) {
        this.c = paramInt;
    }

    public void setTransitionType(int paramInt) {
        this.b = paramInt;
    }

    public void setWidth(int paramInt) {
        this.d = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */