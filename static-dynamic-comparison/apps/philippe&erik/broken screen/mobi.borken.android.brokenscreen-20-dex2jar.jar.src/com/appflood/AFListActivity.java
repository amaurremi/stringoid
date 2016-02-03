package com.appflood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.e.j;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimerTask;
import org.json.JSONObject;

public class AFListActivity
  extends Activity
{
  private com.appflood.c.g A;
  private float a = 480.0F;
  private float b = 800.0F;
  private float c = 1.0F;
  private RelativeLayout d = null;
  private RelativeLayout e = null;
  private ImageView f = null;
  private ArrayList<HashMap<String, String>> g = null;
  private ArrayList<HashMap<String, String>> h = null;
  private ArrayList<HashMap<String, String>> i = null;
  private Bitmap j = null;
  private Bitmap k = null;
  private String l = null;
  private String m = null;
  private String n = null;
  private String o = null;
  private String p = null;
  private String q = null;
  private a r = null;
  private a s = null;
  private a t = null;
  private View u = null;
  private View v = null;
  private int w = 0;
  private float x = 25.0F;
  private int y = 20;
  private TabHost z;
  
  private void a()
  {
    com.appflood.c.g localg = this.A;
    if (j.a(null))
    {
      this.l = (com.appflood.c.d.z + "newbg" + com.appflood.c.d.A);
      this.m = (com.appflood.c.d.z + "title" + com.appflood.c.d.A);
      this.n = (com.appflood.c.d.z + "game" + com.appflood.c.d.A);
      this.o = (com.appflood.c.d.z + "app" + com.appflood.c.d.A);
      this.p = (com.appflood.c.d.z + "gameP" + com.appflood.c.d.A);
      this.q = (com.appflood.c.d.z + "appP" + com.appflood.c.d.A);
      this.h = this.A.g;
      this.i = this.A.h;
      this.g = this.A.a(this.w);
      if (this.h != null) {
        j.d("game length + " + this.h.size());
      }
      if (this.i != null) {
        j.d("appData lenth + " + this.i.size());
      }
      if (this.g != null) {
        j.d("alldata length + " + this.g.size());
      }
      if ((this.w == 4) || (this.w == 3))
      {
        if ((this.h.size() > 0) || (this.i.size() > 0)) {
          break label413;
        }
        com.appflood.c.e.a().a(false, 8);
        b();
      }
    }
    else
    {
      throw new NullPointerException();
    }
    if (this.g.size() <= 0)
    {
      com.appflood.c.e.a().a(false, 8);
      b();
      return;
    }
    label413:
    com.appflood.c.e.a().a(true, 8);
    com.appflood.c.f.a(new Runnable()
    {
      public final void run()
      {
        Object localObject;
        if ((AFListActivity.k(AFListActivity.this) == 4) || (AFListActivity.k(AFListActivity.this) == 3))
        {
          if ((AFListActivity.l(AFListActivity.this).size() <= 0) && (AFListActivity.m(AFListActivity.this).size() <= 0))
          {
            AFListActivity.a(AFListActivity.this);
            return;
          }
          localObject = AFListActivity.this;
          AFListActivity.a(AFListActivity.l(AFListActivity.this));
          localObject = AFListActivity.this;
          AFListActivity.a(AFListActivity.m(AFListActivity.this));
          localObject = new AFListActivity.b(AFListActivity.this, AFListActivity.this, AFListActivity.l(AFListActivity.this));
          AFListActivity.b localb = new AFListActivity.b(AFListActivity.this, AFListActivity.this, AFListActivity.m(AFListActivity.this));
          AFListActivity.b(AFListActivity.this).setAdapter((ListAdapter)localObject);
          AFListActivity.c(AFListActivity.this).setAdapter(localb);
          if (AFListActivity.k(AFListActivity.this) == 3)
          {
            AFListActivity.n(AFListActivity.this).setCurrentTab(0);
            new b(AFListActivity.o(AFListActivity.this), (byte)0).a(AFListActivity.b(AFListActivity.this));
            new b(AFListActivity.o(AFListActivity.this), (byte)0).a(AFListActivity.c(AFListActivity.this));
            if (AFListActivity.k(AFListActivity.this) != 3) {
              break label380;
            }
            new b(AFListActivity.e(AFListActivity.this), (byte)0).a(AFListActivity.d(AFListActivity.this));
            new b(AFListActivity.g(AFListActivity.this), (byte)0).a(AFListActivity.f(AFListActivity.this));
          }
        }
        for (;;)
        {
          new b(AFListActivity.s(AFListActivity.this), (byte)0).a(AFListActivity.r(AFListActivity.this));
          if (j.a(null)) {
            new b(com.appflood.c.d.z + "newclose.png", (byte)0).a(AFListActivity.t(AFListActivity.this));
          }
          AFListActivity.u(AFListActivity.this);
          return;
          AFListActivity.n(AFListActivity.this).setCurrentTab(1);
          break;
          label380:
          new b(AFListActivity.i(AFListActivity.this), (byte)0).a(AFListActivity.d(AFListActivity.this));
          new b(AFListActivity.h(AFListActivity.this), (byte)0).a(AFListActivity.f(AFListActivity.this));
          continue;
          localObject = AFListActivity.this;
          AFListActivity.a(AFListActivity.p(AFListActivity.this));
          localObject = new AFListActivity.b(AFListActivity.this, AFListActivity.this, AFListActivity.p(AFListActivity.this));
          AFListActivity.q(AFListActivity.this).setAdapter((ListAdapter)localObject);
          new b(AFListActivity.o(AFListActivity.this), (byte)0).a(AFListActivity.q(AFListActivity.this));
        }
      }
    });
  }
  
  private void b()
  {
    this.f.setClickable(false);
    this.j = null;
    this.k = null;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.b);
    localTranslateAnimation.setDuration(500L);
    this.d.startAnimation(localTranslateAnimation);
    com.appflood.c.f.a(new TimerTask()
    {
      public final void run()
      {
        com.appflood.c.f.a(new Runnable()
        {
          public final void run()
          {
            try
            {
              if (AFListActivity.v(AFListActivity.this) != null) {
                AFListActivity.v(AFListActivity.this).removeAllViews();
              }
              AFListActivity.this.finish();
              return;
            }
            catch (Throwable localThrowable) {}
          }
        });
      }
    }, 500L);
    try
    {
      com.appflood.c.e.a().a(false, j.a("type", Integer.valueOf(8)));
      return;
    }
    catch (Exception localException)
    {
      j.b(localException, "error in fireEventDelegate");
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 340	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   5: new 144	java/lang/StringBuilder
    //   8: dup
    //   9: ldc_w 342
    //   12: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: invokestatic 347	com/appflood/AppFlood:isConnected	()Z
    //   18: invokevirtual 350	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   21: ldc_w 352
    //   24: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 353	com/appflood/c/d:n	Ljava/lang/String;
    //   30: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: pop
    //   37: invokestatic 249	com/appflood/e/j:a	()V
    //   40: invokestatic 347	com/appflood/AppFlood:isConnected	()Z
    //   43: ifne +76 -> 119
    //   46: getstatic 353	com/appflood/c/d:n	Ljava/lang/String;
    //   49: invokestatic 142	com/appflood/e/j:a	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +67 -> 119
    //   55: invokestatic 249	com/appflood/e/j:a	()V
    //   58: aload_0
    //   59: invokestatic 358	com/appflood/e/c:a	(Landroid/content/Context;)V
    //   62: aload_0
    //   63: iconst_0
    //   64: invokestatic 361	com/appflood/c/f:a	(Landroid/content/Context;Z)V
    //   67: invokestatic 362	com/appflood/c/f:a	()V
    //   70: aload_0
    //   71: ldc_w 364
    //   74: invokestatic 369	com/appflood/e/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   77: putstatic 371	com/appflood/c/d:w	Ljava/lang/String;
    //   80: aload_0
    //   81: ldc_w 373
    //   84: invokestatic 369	com/appflood/e/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   87: putstatic 149	com/appflood/c/d:z	Ljava/lang/String;
    //   90: aload_0
    //   91: ldc_w 375
    //   94: invokestatic 369	com/appflood/e/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_1
    //   98: aload_1
    //   99: putstatic 353	com/appflood/c/d:n	Ljava/lang/String;
    //   102: aload_1
    //   103: invokestatic 142	com/appflood/e/j:a	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +13 -> 119
    //   109: ldc_w 377
    //   112: invokestatic 379	com/appflood/e/j:c	(Ljava/lang/String;)V
    //   115: aload_0
    //   116: invokevirtual 382	com/appflood/AFListActivity:finish	()V
    //   119: aload_0
    //   120: invokestatic 385	com/appflood/c/g:a	()Lcom/appflood/c/g;
    //   123: putfield 137	com/appflood/AFListActivity:A	Lcom/appflood/c/g;
    //   126: aload_0
    //   127: iconst_1
    //   128: invokevirtual 389	com/appflood/AFListActivity:requestWindowFeature	(I)Z
    //   131: pop
    //   132: aload_0
    //   133: invokevirtual 393	com/appflood/AFListActivity:getIntent	()Landroid/content/Intent;
    //   136: invokevirtual 399	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +1365 -> 1506
    //   144: aload_1
    //   145: ldc_w 401
    //   148: invokevirtual 407	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   151: istore 4
    //   153: aload_1
    //   154: ldc_w 409
    //   157: invokevirtual 407	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   160: istore_3
    //   161: aload_0
    //   162: aload_1
    //   163: ldc_w 411
    //   166: invokevirtual 415	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   169: putfield 127	com/appflood/AFListActivity:w	I
    //   172: iload 4
    //   174: ifeq +16 -> 190
    //   177: aload_0
    //   178: invokevirtual 419	com/appflood/AFListActivity:getWindow	()Landroid/view/Window;
    //   181: sipush 1024
    //   184: sipush 1024
    //   187: invokevirtual 425	android/view/Window:setFlags	(II)V
    //   190: iload_3
    //   191: ifeq +1046 -> 1237
    //   194: getstatic 427	com/appflood/e/c:j	I
    //   197: bipush 9
    //   199: if_icmplt +1030 -> 1229
    //   202: aload_0
    //   203: bipush 7
    //   205: invokevirtual 430	com/appflood/AFListActivity:setRequestedOrientation	(I)V
    //   208: getstatic 427	com/appflood/e/c:j	I
    //   211: bipush 15
    //   213: if_icmplt +16 -> 229
    //   216: aload_0
    //   217: ldc_w 431
    //   220: putfield 130	com/appflood/AFListActivity:x	F
    //   223: aload_0
    //   224: bipush 15
    //   226: putfield 132	com/appflood/AFListActivity:y	I
    //   229: getstatic 427	com/appflood/e/c:j	I
    //   232: iconst_4
    //   233: if_icmpge +16 -> 249
    //   236: aload_0
    //   237: getfield 127	com/appflood/AFListActivity:w	I
    //   240: iconst_4
    //   241: if_icmpne +1021 -> 1262
    //   244: aload_0
    //   245: iconst_1
    //   246: putfield 127	com/appflood/AFListActivity:w	I
    //   249: new 433	android/util/DisplayMetrics
    //   252: dup
    //   253: invokespecial 434	android/util/DisplayMetrics:<init>	()V
    //   256: astore_1
    //   257: aload_0
    //   258: invokevirtual 438	com/appflood/AFListActivity:getWindowManager	()Landroid/view/WindowManager;
    //   261: invokeinterface 444 1 0
    //   266: aload_1
    //   267: invokevirtual 450	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   270: aload_0
    //   271: invokevirtual 419	com/appflood/AFListActivity:getWindow	()Landroid/view/Window;
    //   274: ldc_w 451
    //   277: invokevirtual 454	android/view/Window:setBackgroundDrawableResource	(I)V
    //   280: aload_0
    //   281: aload_1
    //   282: getfield 457	android/util/DisplayMetrics:widthPixels	I
    //   285: i2f
    //   286: putfield 82	com/appflood/AFListActivity:a	F
    //   289: aload_0
    //   290: aload_1
    //   291: getfield 460	android/util/DisplayMetrics:heightPixels	I
    //   294: i2f
    //   295: putfield 85	com/appflood/AFListActivity:b	F
    //   298: aload_0
    //   299: getfield 82	com/appflood/AFListActivity:a	F
    //   302: aload_0
    //   303: getfield 85	com/appflood/AFListActivity:b	F
    //   306: fcmpl
    //   307: ifle +971 -> 1278
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 82	com/appflood/AFListActivity:a	F
    //   315: ldc 83
    //   317: fdiv
    //   318: putfield 87	com/appflood/AFListActivity:c	F
    //   321: aload_0
    //   322: new 286	android/widget/RelativeLayout
    //   325: dup
    //   326: aload_0
    //   327: invokespecial 462	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   330: putfield 89	com/appflood/AFListActivity:d	Landroid/widget/RelativeLayout;
    //   333: aload_0
    //   334: new 286	android/widget/RelativeLayout
    //   337: dup
    //   338: aload_0
    //   339: invokespecial 462	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   342: putfield 91	com/appflood/AFListActivity:e	Landroid/widget/RelativeLayout;
    //   345: aload_0
    //   346: getfield 91	com/appflood/AFListActivity:e	Landroid/widget/RelativeLayout;
    //   349: sipush 202
    //   352: invokevirtual 465	android/widget/RelativeLayout:setId	(I)V
    //   355: aload_0
    //   356: new 269	android/widget/ImageView
    //   359: dup
    //   360: aload_0
    //   361: invokespecial 466	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   364: putfield 93	com/appflood/AFListActivity:f	Landroid/widget/ImageView;
    //   367: aload_0
    //   368: getfield 93	com/appflood/AFListActivity:f	Landroid/widget/ImageView;
    //   371: aload_0
    //   372: getfield 87	com/appflood/AFListActivity:c	F
    //   375: ldc_w 467
    //   378: fmul
    //   379: f2i
    //   380: aload_0
    //   381: getfield 87	com/appflood/AFListActivity:c	F
    //   384: ldc_w 467
    //   387: fmul
    //   388: f2i
    //   389: ldc_w 468
    //   392: aload_0
    //   393: getfield 87	com/appflood/AFListActivity:c	F
    //   396: fmul
    //   397: f2i
    //   398: aload_0
    //   399: getfield 87	com/appflood/AFListActivity:c	F
    //   402: ldc_w 467
    //   405: fmul
    //   406: f2i
    //   407: invokevirtual 472	android/widget/ImageView:setPadding	(IIII)V
    //   410: new 474	android/widget/RelativeLayout$LayoutParams
    //   413: dup
    //   414: ldc_w 475
    //   417: aload_0
    //   418: getfield 87	com/appflood/AFListActivity:c	F
    //   421: fmul
    //   422: f2i
    //   423: ldc_w 476
    //   426: aload_0
    //   427: getfield 87	com/appflood/AFListActivity:c	F
    //   430: fmul
    //   431: f2i
    //   432: invokespecial 478	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   435: astore_1
    //   436: aload_1
    //   437: bipush 11
    //   439: invokevirtual 481	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   442: aload_1
    //   443: bipush 15
    //   445: invokevirtual 481	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   448: aload_0
    //   449: getfield 91	com/appflood/AFListActivity:e	Landroid/widget/RelativeLayout;
    //   452: aload_0
    //   453: getfield 93	com/appflood/AFListActivity:f	Landroid/widget/ImageView;
    //   456: aload_1
    //   457: invokevirtual 485	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   460: aload_0
    //   461: getfield 93	com/appflood/AFListActivity:f	Landroid/widget/ImageView;
    //   464: new 10	com/appflood/AFListActivity$3
    //   467: dup
    //   468: aload_0
    //   469: invokespecial 486	com/appflood/AFListActivity$3:<init>	(Lcom/appflood/AFListActivity;)V
    //   472: invokevirtual 490	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   475: new 474	android/widget/RelativeLayout$LayoutParams
    //   478: dup
    //   479: iconst_m1
    //   480: aload_0
    //   481: getfield 87	com/appflood/AFListActivity:c	F
    //   484: ldc_w 491
    //   487: fmul
    //   488: f2i
    //   489: invokespecial 478	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   492: astore_1
    //   493: aload_1
    //   494: bipush 10
    //   496: invokevirtual 481	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   499: aload_0
    //   500: getfield 89	com/appflood/AFListActivity:d	Landroid/widget/RelativeLayout;
    //   503: aload_0
    //   504: getfield 91	com/appflood/AFListActivity:e	Landroid/widget/RelativeLayout;
    //   507: aload_1
    //   508: invokevirtual 485	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   511: new 269	android/widget/ImageView
    //   514: dup
    //   515: aload_0
    //   516: invokespecial 466	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   519: astore_1
    //   520: aload_1
    //   521: ldc_w 492
    //   524: invokevirtual 493	android/widget/ImageView:setId	(I)V
    //   527: new 495	com/appflood/b/b
    //   530: dup
    //   531: new 144	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   538: getstatic 149	com/appflood/c/d:z	Ljava/lang/String;
    //   541: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: ldc_w 497
    //   547: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: iconst_0
    //   554: invokespecial 500	com/appflood/b/b:<init>	(Ljava/lang/String;B)V
    //   557: aload_1
    //   558: invokevirtual 503	com/appflood/b/b:a	(Landroid/view/View;)V
    //   561: aload_1
    //   562: new 474	android/widget/RelativeLayout$LayoutParams
    //   565: dup
    //   566: iconst_m1
    //   567: iconst_m1
    //   568: invokespecial 478	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   571: invokevirtual 507	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   574: aload_0
    //   575: getfield 127	com/appflood/AFListActivity:w	I
    //   578: iconst_4
    //   579: if_icmpeq +11 -> 590
    //   582: aload_0
    //   583: getfield 127	com/appflood/AFListActivity:w	I
    //   586: iconst_3
    //   587: if_icmpne +766 -> 1353
    //   590: aload_0
    //   591: new 26	com/appflood/AFListActivity$a
    //   594: dup
    //   595: aload_0
    //   596: aload_0
    //   597: invokespecial 510	com/appflood/AFListActivity$a:<init>	(Lcom/appflood/AFListActivity;Landroid/content/Context;)V
    //   600: putfield 119	com/appflood/AFListActivity:s	Lcom/appflood/AFListActivity$a;
    //   603: aload_0
    //   604: new 26	com/appflood/AFListActivity$a
    //   607: dup
    //   608: aload_0
    //   609: aload_0
    //   610: invokespecial 510	com/appflood/AFListActivity$a:<init>	(Lcom/appflood/AFListActivity;Landroid/content/Context;)V
    //   613: putfield 121	com/appflood/AFListActivity:t	Lcom/appflood/AFListActivity$a;
    //   616: new 286	android/widget/RelativeLayout
    //   619: dup
    //   620: aload_0
    //   621: invokespecial 462	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   624: astore_1
    //   625: new 474	android/widget/RelativeLayout$LayoutParams
    //   628: dup
    //   629: iconst_m1
    //   630: iconst_m1
    //   631: invokespecial 478	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   634: astore 5
    //   636: new 512	android/widget/TabWidget
    //   639: dup
    //   640: aload_0
    //   641: invokespecial 513	android/widget/TabWidget:<init>	(Landroid/content/Context;)V
    //   644: astore 6
    //   646: aload 6
    //   648: ldc_w 514
    //   651: invokevirtual 515	android/widget/TabWidget:setId	(I)V
    //   654: new 474	android/widget/RelativeLayout$LayoutParams
    //   657: dup
    //   658: iconst_m1
    //   659: ldc_w 516
    //   662: aload_0
    //   663: getfield 87	com/appflood/AFListActivity:c	F
    //   666: fmul
    //   667: f2i
    //   668: invokespecial 478	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   671: astore 7
    //   673: aload 7
    //   675: bipush 10
    //   677: invokevirtual 481	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   680: aload_1
    //   681: aload 6
    //   683: aload 7
    //   685: invokevirtual 485	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   688: new 518	android/widget/FrameLayout
    //   691: dup
    //   692: aload_0
    //   693: invokespecial 519	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   696: astore 6
    //   698: aload 6
    //   700: ldc_w 520
    //   703: invokevirtual 521	android/widget/FrameLayout:setId	(I)V
    //   706: new 474	android/widget/RelativeLayout$LayoutParams
    //   709: dup
    //   710: iconst_m1
    //   711: iconst_m1
    //   712: invokespecial 478	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   715: astore 7
    //   717: aload 7
    //   719: ldc_w 522
    //   722: aload_0
    //   723: getfield 87	com/appflood/AFListActivity:c	F
    //   726: fmul
    //   727: f2i
    //   728: putfield 525	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   731: aload 7
    //   733: bipush 12
    //   735: invokevirtual 481	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   738: aload_1
    //   739: aload 6
    //   741: aload 7
    //   743: invokevirtual 485	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   746: aload_0
    //   747: new 527	android/view/View
    //   750: dup
    //   751: aload_0
    //   752: invokespecial 528	android/view/View:<init>	(Landroid/content/Context;)V
    //   755: putfield 123	com/appflood/AFListActivity:u	Landroid/view/View;
    //   758: aload_0
    //   759: new 527	android/view/View
    //   762: dup
    //   763: aload_0
    //   764: invokespecial 528	android/view/View:<init>	(Landroid/content/Context;)V
    //   767: putfield 125	com/appflood/AFListActivity:v	Landroid/view/View;
    //   770: aload_0
    //   771: new 530	android/widget/TabHost
    //   774: dup
    //   775: aload_0
    //   776: invokespecial 531	android/widget/TabHost:<init>	(Landroid/content/Context;)V
    //   779: putfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   782: aload_0
    //   783: getfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   786: ldc_w 532
    //   789: invokevirtual 533	android/widget/TabHost:setId	(I)V
    //   792: aload_0
    //   793: getfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   796: aload_1
    //   797: aload 5
    //   799: invokevirtual 534	android/widget/TabHost:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   802: aload_0
    //   803: getfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   806: invokevirtual 537	android/widget/TabHost:setup	()V
    //   809: aload_0
    //   810: getfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   813: ldc_w 539
    //   816: invokevirtual 543	android/widget/TabHost:newTabSpec	(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;
    //   819: new 12	com/appflood/AFListActivity$4
    //   822: dup
    //   823: aload_0
    //   824: invokespecial 544	com/appflood/AFListActivity$4:<init>	(Lcom/appflood/AFListActivity;)V
    //   827: invokevirtual 550	android/widget/TabHost$TabSpec:setContent	(Landroid/widget/TabHost$TabContentFactory;)Landroid/widget/TabHost$TabSpec;
    //   830: astore_1
    //   831: aload_0
    //   832: getfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   835: ldc_w 552
    //   838: invokevirtual 543	android/widget/TabHost:newTabSpec	(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;
    //   841: new 14	com/appflood/AFListActivity$5
    //   844: dup
    //   845: aload_0
    //   846: invokespecial 553	com/appflood/AFListActivity$5:<init>	(Lcom/appflood/AFListActivity;)V
    //   849: invokevirtual 550	android/widget/TabHost$TabSpec:setContent	(Landroid/widget/TabHost$TabContentFactory;)Landroid/widget/TabHost$TabSpec;
    //   852: astore 5
    //   854: aload_1
    //   855: invokevirtual 559	java/lang/Object:getClass	()Ljava/lang/Class;
    //   858: ldc_w 561
    //   861: iconst_1
    //   862: anewarray 563	java/lang/Class
    //   865: dup
    //   866: iconst_0
    //   867: ldc_w 527
    //   870: aastore
    //   871: invokevirtual 567	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   874: astore 6
    //   876: aload 6
    //   878: aload_1
    //   879: iconst_1
    //   880: anewarray 555	java/lang/Object
    //   883: dup
    //   884: iconst_0
    //   885: aload_0
    //   886: getfield 123	com/appflood/AFListActivity:u	Landroid/view/View;
    //   889: aastore
    //   890: invokevirtual 573	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   893: pop
    //   894: aload 6
    //   896: aload 5
    //   898: iconst_1
    //   899: anewarray 555	java/lang/Object
    //   902: dup
    //   903: iconst_0
    //   904: aload_0
    //   905: getfield 125	com/appflood/AFListActivity:v	Landroid/view/View;
    //   908: aastore
    //   909: invokevirtual 573	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   912: pop
    //   913: aload_0
    //   914: getfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   917: aload_1
    //   918: invokevirtual 577	android/widget/TabHost:addTab	(Landroid/widget/TabHost$TabSpec;)V
    //   921: aload_0
    //   922: getfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   925: aload 5
    //   927: invokevirtual 577	android/widget/TabHost:addTab	(Landroid/widget/TabHost$TabSpec;)V
    //   930: aload_0
    //   931: getfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   934: new 16	com/appflood/AFListActivity$6
    //   937: dup
    //   938: aload_0
    //   939: invokespecial 578	com/appflood/AFListActivity$6:<init>	(Lcom/appflood/AFListActivity;)V
    //   942: invokevirtual 582	android/widget/TabHost:setOnTabChangedListener	(Landroid/widget/TabHost$OnTabChangeListener;)V
    //   945: new 474	android/widget/RelativeLayout$LayoutParams
    //   948: dup
    //   949: iconst_m1
    //   950: iconst_m1
    //   951: invokespecial 478	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   954: astore_1
    //   955: aload_1
    //   956: aload_0
    //   957: getfield 87	com/appflood/AFListActivity:c	F
    //   960: ldc_w 491
    //   963: fmul
    //   964: f2i
    //   965: putfield 525	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   968: aload_1
    //   969: bipush 12
    //   971: invokevirtual 481	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   974: aload_0
    //   975: getfield 89	com/appflood/AFListActivity:d	Landroid/widget/RelativeLayout;
    //   978: aload_0
    //   979: getfield 321	com/appflood/AFListActivity:z	Landroid/widget/TabHost;
    //   982: aload_1
    //   983: invokevirtual 485	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   986: new 584	android/graphics/drawable/GradientDrawable
    //   989: dup
    //   990: getstatic 590	android/graphics/drawable/GradientDrawable$Orientation:BOTTOM_TOP	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   993: iconst_2
    //   994: newarray <illegal type>
    //   996: dup
    //   997: iconst_0
    //   998: ldc_w 591
    //   1001: iastore
    //   1002: dup
    //   1003: iconst_1
    //   1004: ldc_w 592
    //   1007: iastore
    //   1008: invokespecial 595	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   1011: astore 5
    //   1013: aload 5
    //   1015: iconst_0
    //   1016: invokevirtual 598	android/graphics/drawable/GradientDrawable:setShape	(I)V
    //   1019: new 527	android/view/View
    //   1022: dup
    //   1023: aload_0
    //   1024: invokespecial 528	android/view/View:<init>	(Landroid/content/Context;)V
    //   1027: astore_1
    //   1028: aload_1
    //   1029: aload 5
    //   1031: invokevirtual 602	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1034: new 474	android/widget/RelativeLayout$LayoutParams
    //   1037: dup
    //   1038: iconst_m1
    //   1039: ldc_w 603
    //   1042: aload_0
    //   1043: getfield 87	com/appflood/AFListActivity:c	F
    //   1046: fmul
    //   1047: f2i
    //   1048: invokespecial 478	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1051: astore 5
    //   1053: aload 5
    //   1055: bipush 12
    //   1057: invokevirtual 481	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1060: aload_0
    //   1061: getfield 89	com/appflood/AFListActivity:d	Landroid/widget/RelativeLayout;
    //   1064: aload_1
    //   1065: aload 5
    //   1067: invokevirtual 485	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1070: aload_0
    //   1071: getfield 89	com/appflood/AFListActivity:d	Landroid/widget/RelativeLayout;
    //   1074: bipush 8
    //   1076: invokevirtual 327	android/widget/RelativeLayout:setVisibility	(I)V
    //   1079: aload_0
    //   1080: aload_0
    //   1081: getfield 89	com/appflood/AFListActivity:d	Landroid/widget/RelativeLayout;
    //   1084: invokevirtual 606	com/appflood/AFListActivity:setContentView	(Landroid/view/View;)V
    //   1087: invokestatic 385	com/appflood/c/g:a	()Lcom/appflood/c/g;
    //   1090: astore_1
    //   1091: aload_0
    //   1092: getfield 127	com/appflood/AFListActivity:w	I
    //   1095: istore_2
    //   1096: iload_2
    //   1097: tableswitch	default:+417->1514, 0:+344->1441, 1:+356->1453, 2:+331->1428, 3:+368->1465, 4:+368->1465
    //   1132: iload_2
    //   1133: ifeq +351 -> 1484
    //   1136: aload_0
    //   1137: invokespecial 316	com/appflood/AFListActivity:a	()V
    //   1140: new 495	com/appflood/b/b
    //   1143: dup
    //   1144: new 144	java/lang/StringBuilder
    //   1147: dup
    //   1148: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   1151: getstatic 149	com/appflood/c/d:z	Ljava/lang/String;
    //   1154: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: ldc_w 608
    //   1160: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: iconst_0
    //   1167: invokespecial 500	com/appflood/b/b:<init>	(Ljava/lang/String;B)V
    //   1170: new 6	com/appflood/AFListActivity$1
    //   1173: dup
    //   1174: aload_0
    //   1175: invokespecial 609	com/appflood/AFListActivity$1:<init>	(Lcom/appflood/AFListActivity;)V
    //   1178: invokevirtual 612	com/appflood/b/b:a	(Lcom/appflood/b/b$a;)Lcom/appflood/b/b;
    //   1181: invokevirtual 614	com/appflood/b/b:f	()V
    //   1184: new 495	com/appflood/b/b
    //   1187: dup
    //   1188: new 144	java/lang/StringBuilder
    //   1191: dup
    //   1192: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   1195: getstatic 149	com/appflood/c/d:z	Ljava/lang/String;
    //   1198: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: getstatic 616	com/appflood/c/d:f	Ljava/lang/String;
    //   1204: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1210: iconst_0
    //   1211: invokespecial 500	com/appflood/b/b:<init>	(Ljava/lang/String;B)V
    //   1214: new 8	com/appflood/AFListActivity$2
    //   1217: dup
    //   1218: aload_0
    //   1219: invokespecial 617	com/appflood/AFListActivity$2:<init>	(Lcom/appflood/AFListActivity;)V
    //   1222: invokevirtual 612	com/appflood/b/b:a	(Lcom/appflood/b/b$a;)Lcom/appflood/b/b;
    //   1225: invokevirtual 614	com/appflood/b/b:f	()V
    //   1228: return
    //   1229: aload_0
    //   1230: iconst_1
    //   1231: invokevirtual 430	com/appflood/AFListActivity:setRequestedOrientation	(I)V
    //   1234: goto -1026 -> 208
    //   1237: getstatic 427	com/appflood/e/c:j	I
    //   1240: bipush 9
    //   1242: if_icmplt +12 -> 1254
    //   1245: aload_0
    //   1246: bipush 6
    //   1248: invokevirtual 430	com/appflood/AFListActivity:setRequestedOrientation	(I)V
    //   1251: goto -1043 -> 208
    //   1254: aload_0
    //   1255: iconst_0
    //   1256: invokevirtual 430	com/appflood/AFListActivity:setRequestedOrientation	(I)V
    //   1259: goto -1051 -> 208
    //   1262: aload_0
    //   1263: getfield 127	com/appflood/AFListActivity:w	I
    //   1266: iconst_3
    //   1267: if_icmpne -1018 -> 249
    //   1270: aload_0
    //   1271: iconst_0
    //   1272: putfield 127	com/appflood/AFListActivity:w	I
    //   1275: goto -1026 -> 249
    //   1278: aload_0
    //   1279: aload_0
    //   1280: getfield 85	com/appflood/AFListActivity:b	F
    //   1283: ldc 83
    //   1285: fdiv
    //   1286: putfield 87	com/appflood/AFListActivity:c	F
    //   1289: goto -968 -> 321
    //   1292: astore_1
    //   1293: aload_1
    //   1294: ldc_w 619
    //   1297: invokestatic 313	com/appflood/e/j:b	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   1300: return
    //   1301: astore 6
    //   1303: aload 6
    //   1305: ldc_w 621
    //   1308: invokestatic 313	com/appflood/e/j:b	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   1311: goto -398 -> 913
    //   1314: astore 6
    //   1316: aload 6
    //   1318: ldc_w 623
    //   1321: invokestatic 313	com/appflood/e/j:b	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   1324: goto -411 -> 913
    //   1327: astore 6
    //   1329: aload 6
    //   1331: ldc_w 625
    //   1334: invokestatic 313	com/appflood/e/j:b	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   1337: goto -424 -> 913
    //   1340: astore 6
    //   1342: aload 6
    //   1344: ldc_w 627
    //   1347: invokestatic 313	com/appflood/e/j:b	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   1350: goto -437 -> 913
    //   1353: aload_0
    //   1354: new 26	com/appflood/AFListActivity$a
    //   1357: dup
    //   1358: aload_0
    //   1359: aload_0
    //   1360: invokespecial 510	com/appflood/AFListActivity$a:<init>	(Lcom/appflood/AFListActivity;Landroid/content/Context;)V
    //   1363: putfield 117	com/appflood/AFListActivity:r	Lcom/appflood/AFListActivity$a;
    //   1366: aload_0
    //   1367: getfield 89	com/appflood/AFListActivity:d	Landroid/widget/RelativeLayout;
    //   1370: aload_1
    //   1371: invokevirtual 629	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1374: aload_0
    //   1375: getfield 117	com/appflood/AFListActivity:r	Lcom/appflood/AFListActivity$a;
    //   1378: aload_1
    //   1379: invokevirtual 632	com/appflood/AFListActivity$a:setEmptyView	(Landroid/view/View;)V
    //   1382: new 474	android/widget/RelativeLayout$LayoutParams
    //   1385: dup
    //   1386: iconst_m1
    //   1387: aload_0
    //   1388: getfield 85	com/appflood/AFListActivity:b	F
    //   1391: aload_0
    //   1392: getfield 87	com/appflood/AFListActivity:c	F
    //   1395: ldc_w 491
    //   1398: fmul
    //   1399: fsub
    //   1400: f2i
    //   1401: invokespecial 478	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1404: astore_1
    //   1405: aload_1
    //   1406: iconst_3
    //   1407: sipush 202
    //   1410: invokevirtual 634	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1413: aload_0
    //   1414: getfield 89	com/appflood/AFListActivity:d	Landroid/widget/RelativeLayout;
    //   1417: aload_0
    //   1418: getfield 117	com/appflood/AFListActivity:r	Lcom/appflood/AFListActivity$a;
    //   1421: aload_1
    //   1422: invokevirtual 485	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1425: goto -439 -> 986
    //   1428: aload_1
    //   1429: iload_2
    //   1430: invokevirtual 178	com/appflood/c/g:a	(I)Ljava/util/ArrayList;
    //   1433: ifnull +86 -> 1519
    //   1436: iconst_1
    //   1437: istore_2
    //   1438: goto -306 -> 1132
    //   1441: aload_1
    //   1442: getfield 175	com/appflood/c/g:h	Ljava/util/ArrayList;
    //   1445: ifnull +79 -> 1524
    //   1448: iconst_1
    //   1449: istore_2
    //   1450: goto -318 -> 1132
    //   1453: aload_1
    //   1454: getfield 175	com/appflood/c/g:h	Ljava/util/ArrayList;
    //   1457: ifnull +72 -> 1529
    //   1460: iconst_1
    //   1461: istore_2
    //   1462: goto -330 -> 1132
    //   1465: aload_1
    //   1466: getfield 175	com/appflood/c/g:h	Ljava/util/ArrayList;
    //   1469: ifnull +65 -> 1534
    //   1472: aload_1
    //   1473: getfield 174	com/appflood/c/g:g	Ljava/util/ArrayList;
    //   1476: ifnull +58 -> 1534
    //   1479: iconst_1
    //   1480: istore_2
    //   1481: goto -349 -> 1132
    //   1484: aload_0
    //   1485: getfield 137	com/appflood/AFListActivity:A	Lcom/appflood/c/g;
    //   1488: aload_0
    //   1489: getfield 127	com/appflood/AFListActivity:w	I
    //   1492: new 18	com/appflood/AFListActivity$7
    //   1495: dup
    //   1496: aload_0
    //   1497: invokespecial 635	com/appflood/AFListActivity$7:<init>	(Lcom/appflood/AFListActivity;)V
    //   1500: invokevirtual 638	com/appflood/c/g:a	(ILcom/appflood/AppFlood$AFRequestDelegate;)V
    //   1503: goto -363 -> 1140
    //   1506: iconst_1
    //   1507: istore_3
    //   1508: iconst_1
    //   1509: istore 4
    //   1511: goto -1339 -> 172
    //   1514: iconst_0
    //   1515: istore_2
    //   1516: goto -384 -> 1132
    //   1519: iconst_0
    //   1520: istore_2
    //   1521: goto -389 -> 1132
    //   1524: iconst_0
    //   1525: istore_2
    //   1526: goto -394 -> 1132
    //   1529: iconst_0
    //   1530: istore_2
    //   1531: goto -399 -> 1132
    //   1534: iconst_0
    //   1535: istore_2
    //   1536: goto -404 -> 1132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1539	0	this	AFListActivity
    //   0	1539	1	paramBundle	android.os.Bundle
    //   1095	441	2	i1	int
    //   160	1348	3	bool1	boolean
    //   151	1359	4	bool2	boolean
    //   634	432	5	localObject1	Object
    //   644	251	6	localObject2	Object
    //   1301	3	6	localNoSuchMethodException	NoSuchMethodException
    //   1314	3	6	localIllegalArgumentException	IllegalArgumentException
    //   1327	3	6	localIllegalAccessException	IllegalAccessException
    //   1340	3	6	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   671	71	7	localLayoutParams	RelativeLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   249	321	1292	java/lang/Exception
    //   321	590	1292	java/lang/Exception
    //   590	854	1292	java/lang/Exception
    //   854	913	1292	java/lang/Exception
    //   913	986	1292	java/lang/Exception
    //   986	1096	1292	java/lang/Exception
    //   1136	1140	1292	java/lang/Exception
    //   1140	1228	1292	java/lang/Exception
    //   1278	1289	1292	java/lang/Exception
    //   1303	1311	1292	java/lang/Exception
    //   1316	1324	1292	java/lang/Exception
    //   1329	1337	1292	java/lang/Exception
    //   1342	1350	1292	java/lang/Exception
    //   1353	1425	1292	java/lang/Exception
    //   1428	1436	1292	java/lang/Exception
    //   1441	1448	1292	java/lang/Exception
    //   1453	1460	1292	java/lang/Exception
    //   1465	1479	1292	java/lang/Exception
    //   1484	1503	1292	java/lang/Exception
    //   854	913	1301	java/lang/NoSuchMethodException
    //   854	913	1314	java/lang/IllegalArgumentException
    //   854	913	1327	java/lang/IllegalAccessException
    //   854	913	1340	java/lang/reflect/InvocationTargetException
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      b();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  final class a
    extends ListView
  {
    public a(Context paramContext)
    {
      super();
      setId(16908298);
      setDivider(new ColorDrawable(0));
      setDividerHeight((int)(12.0F * AFListActivity.w(this$1)));
      paramContext = new View(this$1);
      paramContext.setBackgroundDrawable(new ColorDrawable(0));
      addHeaderView(paramContext, null, false);
      paramContext = new View(this$1);
      paramContext.setBackgroundDrawable(new ColorDrawable(0));
      addFooterView(paramContext, null, false);
      setHeaderDividersEnabled(true);
      setFooterDividersEnabled(true);
      setPadding((int)(AFListActivity.w(this$1) * 15.0F), 0, (int)(AFListActivity.w(this$1) * 15.0F), 0);
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private Context b;
    private ArrayList<HashMap<String, String>> c;
    
    public b(ArrayList<HashMap<String, String>> paramArrayList)
    {
      this.b = paramArrayList;
      ArrayList localArrayList;
      this.c = localArrayList;
    }
    
    public final int getCount()
    {
      if (this.c != null) {
        return this.c.size();
      }
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    /* Error */
    public final View getView(final int paramInt, View paramView, android.view.ViewGroup paramViewGroup)
    {
      // Byte code:
      //   0: aload_2
      //   1: ifnonnull +57 -> 58
      //   4: new 52	com/appflood/AFListActivity$c
      //   7: dup
      //   8: aload_0
      //   9: getfield 19	com/appflood/AFListActivity$b:a	Lcom/appflood/AFListActivity;
      //   12: aload_0
      //   13: getfield 24	com/appflood/AFListActivity$b:b	Landroid/content/Context;
      //   16: invokespecial 55	com/appflood/AFListActivity$c:<init>	(Lcom/appflood/AFListActivity;Landroid/content/Context;)V
      //   19: astore_3
      //   20: aload_3
      //   21: astore_2
      //   22: aload_2
      //   23: astore 4
      //   25: aload_3
      //   26: astore_2
      //   27: aload 4
      //   29: aload_0
      //   30: getfield 26	com/appflood/AFListActivity$b:c	Ljava/util/ArrayList;
      //   33: iload_1
      //   34: invokevirtual 42	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   37: checkcast 44	java/util/HashMap
      //   40: invokevirtual 58	com/appflood/AFListActivity$c:a	(Ljava/util/HashMap;)V
      //   43: aload_2
      //   44: new 9	com/appflood/AFListActivity$b$1
      //   47: dup
      //   48: aload_0
      //   49: iload_1
      //   50: invokespecial 61	com/appflood/AFListActivity$b$1:<init>	(Lcom/appflood/AFListActivity$b;I)V
      //   53: invokevirtual 67	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
      //   56: aload_2
      //   57: areturn
      //   58: aload_2
      //   59: checkcast 52	com/appflood/AFListActivity$c
      //   62: astore_3
      //   63: aload_3
      //   64: astore 4
      //   66: goto -39 -> 27
      //   69: astore_3
      //   70: aload_3
      //   71: ldc 69
      //   73: invokestatic 74	com/appflood/e/j:b	(Ljava/lang/Throwable;Ljava/lang/String;)V
      //   76: goto -33 -> 43
      //   79: astore_3
      //   80: goto -10 -> 70
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	b
      //   0	83	1	paramInt	int
      //   0	83	2	paramView	View
      //   0	83	3	paramViewGroup	android.view.ViewGroup
      //   23	42	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	20	69	java/lang/Throwable
      //   58	63	69	java/lang/Throwable
      //   27	43	79	java/lang/Throwable
    }
  }
  
  final class c
    extends RelativeLayout
  {
    private TextView a;
    private TextView b;
    private ImageView c;
    private String d;
    
    public c(Context paramContext)
    {
      super();
      Object localObject = new ImageView(paramContext);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(92.0F * AFListActivity.w(this$1)));
      localLayoutParams.addRule(14);
      if (AFListActivity.x(this$1) != null)
      {
        ((ImageView)localObject).setImageBitmap(AFListActivity.x(this$1));
        addView((View)localObject, localLayoutParams);
        this.c = new ImageView(paramContext);
        this.c.setId(203);
        this.c.setScaleType(ImageView.ScaleType.FIT_XY);
        localObject = new ShapeDrawable(new RoundRectShape(new float[] { 9.0F, 9.0F, 9.0F, 9.0F, 9.0F, 9.0F, 9.0F, 9.0F }, null, null));
        ((ShapeDrawable)localObject).getPaint().setColor(-261724570);
        this.c.setBackgroundDrawable((Drawable)localObject);
        this.c.setPadding(0, 0, 2, 2);
        localObject = new RelativeLayout.LayoutParams((int)(AFListActivity.w(this$1) * 72.0F), (int)(AFListActivity.w(this$1) * 72.0F));
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).setMargins((int)(AFListActivity.w(this$1) * 10.0F), (int)(AFListActivity.w(this$1) * 10.0F), (int)(AFListActivity.w(this$1) * 10.0F), 0);
        addView(this.c, (ViewGroup.LayoutParams)localObject);
        this.a = new TextView(paramContext);
        this.a.setTextSize(AFListActivity.y(this$1) * AFListActivity.w(this$1) / getResources().getDisplayMetrics().density);
        this.a.setTextColor(Color.rgb(67, 95, 125));
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        this.a.setId(204);
        localObject = new RelativeLayout.LayoutParams(-1, (int)(34.0F * AFListActivity.w(this$1)));
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 203);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(8.0F * AFListActivity.w(this$1)), 0, 0);
        addView(this.a, (ViewGroup.LayoutParams)localObject);
        this.b = new TextView(paramContext);
        this.b.setTextSize(AFListActivity.z(this$1) * AFListActivity.w(this$1) / getResources().getDisplayMetrics().density);
        this.b.setTextColor(Color.rgb(158, 164, 173));
        localObject = new RelativeLayout.LayoutParams((int)(243.0F * AFListActivity.w(this$1)), (int)(40.0F * AFListActivity.w(this$1)));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 204);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 203);
        addView(this.b, (ViewGroup.LayoutParams)localObject);
        paramContext = new ImageView(paramContext);
        localObject = new RelativeLayout.LayoutParams((int)(81.0F * AFListActivity.w(this$1)), (int)(34.5D * AFListActivity.w(this$1)));
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 203);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, (int)(11.0F * AFListActivity.w(this$1)), 0);
        if (AFListActivity.A(this$1) == null) {
          break label620;
        }
        paramContext.setImageBitmap(AFListActivity.A(this$1));
      }
      for (;;)
      {
        addView(paramContext, (ViewGroup.LayoutParams)localObject);
        return;
        new b(com.appflood.c.d.z + "newbg2.png", (byte)0).a((View)localObject);
        break;
        label620:
        new b(com.appflood.c.d.z + com.appflood.c.d.f, (byte)0).a(paramContext);
      }
    }
    
    protected final void a(HashMap<String, String> paramHashMap)
    {
      if (paramHashMap != null)
      {
        if (j.a((CharSequence)paramHashMap.get("name"))) {
          break label180;
        }
        this.a.setText((CharSequence)paramHashMap.get("name"));
        if (j.a((CharSequence)paramHashMap.get("des"))) {
          break label192;
        }
        this.b.setText((CharSequence)paramHashMap.get("des"));
      }
      for (;;)
      {
        if (!j.a((CharSequence)paramHashMap.get("icon_url")))
        {
          str = (String)paramHashMap.get("icon_url");
          if (!str.equals(this.d))
          {
            this.d = str;
            new b(this.d, (byte)0).a(new b.a()
            {
              public final void a(final b paramAnonymousb)
              {
                if (str.equals(AFListActivity.c.a(AFListActivity.c.this)))
                {
                  Bitmap localBitmap = paramAnonymousb.d();
                  paramAnonymousb = localBitmap;
                  if (localBitmap != null) {
                    paramAnonymousb = AFListActivity.1.a(localBitmap, 9.0F);
                  }
                  com.appflood.c.f.a(new Runnable()
                  {
                    public final void run()
                    {
                      try
                      {
                        AFListActivity.c.b(AFListActivity.c.this).setImageBitmap(paramAnonymousb);
                        return;
                      }
                      catch (Throwable localThrowable)
                      {
                        j.a(localThrowable, "set view image failed!");
                      }
                    }
                  });
                }
              }
              
              public final void a(b paramAnonymousb, int paramAnonymousInt) {}
            }).f();
          }
        }
        final String str = (String)paramHashMap.get("show_cb_url");
        if (!j.a(str))
        {
          new b(str).f();
          paramHashMap.put("show_cb_url_copy", str);
          paramHashMap.put("show_cb_url", "");
        }
        return;
        label180:
        this.a.setText("");
        break;
        label192:
        this.b.setText("");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/AFListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */