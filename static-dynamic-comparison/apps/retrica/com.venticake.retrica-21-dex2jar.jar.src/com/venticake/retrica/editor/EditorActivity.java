package com.venticake.retrica.editor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.venticake.retrica.engine.RetricaEngine;
import com.venticake.retrica.engine.RetricaEngine.BitmapApplyProgressCallback;
import com.venticake.retrica.f;
import com.venticake.retrica.h;
import com.venticake.retrica.i;
import com.venticake.retrica.k;
import com.venticake.retrica.setting.PurchaseActivity;
import com.venticake.retrica.setting.b;
import com.venticake.retrica.util.UserInterfaceUtil;
import com.venticake.retrica.view.EditorPreviewImageView;
import com.venticake.retrica.view.LensIntensityControlView;
import com.venticake.retrica.view.LensSelector;
import com.venticake.retrica.view.LensSelector.LensSelectorListner;
import com.venticake.retrica.view.RetricaBlurTouchEventDispatcher;
import com.venticake.retrica.view.RetricaBlurTouchEventListener;
import com.venticake.retrica.view.album.LazyImageView;
import com.venticake.retrica.view.album.LazyImageView.LoadingFinishListner;
import com.venticake.retrica.view.album.LazyImageView.URILoadingFinishListner;
import com.venticake.retrica.view.album.QuickViewActivity;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class EditorActivity
  extends Activity
  implements LensSelector.LensSelectorListner, RetricaBlurTouchEventListener
{
  private float A;
  private ImageButton B;
  private ImageButton C;
  private LensSelector D;
  private RetricaEngine E;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private HandlerThread I;
  private Handler J;
  private Runnable K;
  private Activity a;
  private List<String> b;
  private String c;
  private Bitmap d;
  private byte[] e;
  private int f;
  private boolean g;
  private boolean h;
  private int i;
  private float[] j = com.venticake.retrica.engine.a.g.a;
  private float[] k = com.venticake.retrica.engine.a.g.a;
  private Location l = null;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private Handler q;
  private com.venticake.retrica.g r;
  private LazyImageView s;
  private EditorPreviewImageView t;
  private TextView u;
  private ProgressBar v;
  private ProgressBar w;
  private EditorHeadButtonLayout x;
  private EditorHeadButtonLayout y;
  private EditorHeadButtonLayout z;
  
  private Bitmap a(Uri paramUri)
  {
    try
    {
      paramUri = MediaStore.Images.Media.getBitmap(this.a.getContentResolver(), paramUri);
      return paramUri;
    }
    catch (FileNotFoundException paramUri)
    {
      paramUri.printStackTrace();
      return null;
    }
    catch (IOException paramUri)
    {
      paramUri.printStackTrace();
    }
    return null;
  }
  
  private RetricaEngine a(Context paramContext, com.venticake.retrica.engine.a.g paramg, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f1 = this.t.eventDispatcher().getCenterX();
    float f2 = this.t.eventDispatcher().getCenterY();
    float f3 = this.t.eventDispatcher().getRadius();
    paramContext = new RetricaEngine(paramContext, paramg, true);
    paramg.a(true);
    paramContext.setOrientation(paramInt, paramBoolean1, paramBoolean2);
    Log.d("retrica", "mCropRegion: " + this.j[0] + ", " + this.j[1] + ", " + this.j[2] + ", " + this.j[3]);
    Log.d("retrica", "eg orientation: " + paramInt + " (" + f.a(paramInt) + ")" + " isFront: " + paramBoolean1 + " saveAsPreview: " + paramBoolean2);
    Log.d("retrica", "eg blurCenter: " + f1 + ", " + f2);
    paramg.b(true);
    paramg.a(new float[] { this.j[1], this.j[0], this.j[3], this.j[2] });
    paramg.b(paramInt, paramBoolean1, paramBoolean2, f1, f2, f3);
    return paramContext;
  }
  
  private Runnable a(final String paramString, final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    new Runnable()
    {
      public void run()
      {
        Object localObject9 = null;
        localObject8 = null;
        int i = EditorActivity.k(EditorActivity.this);
        int j = EditorActivity.j(EditorActivity.this);
        localObject1 = Uri.parse(paramString);
        try
        {
          localObject6 = new ExifInterface(((Uri)localObject1).getPath());
          Log.d("retrica", "mURLString: " + paramString);
          Log.d("retrica", "pictureOrientation: " + paramInt);
          Log.d("retrica", "uri.getPath(): " + ((Uri)localObject1).getPath());
          EditorActivity.this.a(10);
          localObject3 = localObject9;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            try
            {
              localObject5 = EditorActivity.a(EditorActivity.this, (Uri)localObject1);
              localObject3 = localObject9;
              EditorActivity.this.a(30);
              localObject3 = localObject9;
              localObject1 = EditorActivity.a(EditorActivity.this, EditorActivity.l(EditorActivity.this), EditorActivity.m(EditorActivity.this).getCurrentLens().a(EditorActivity.l(EditorActivity.this)), paramInt, paramBoolean1, paramBoolean2);
              localObject3 = localObject9;
              ((RetricaEngine)localObject1).setBitmapApplyProgressCallback(new RetricaEngine.BitmapApplyProgressCallback()
              {
                public void onProcess(float paramAnonymous2Float)
                {
                  EditorActivity.this.a((int)(45.0F * paramAnonymous2Float) + 35);
                }
              });
              localObject3 = localObject9;
              EditorActivity.this.a(35);
              localObject3 = localObject9;
            }
            catch (Exception localException1)
            {
              Object localObject3;
              Object localObject5;
              Object localObject7;
              Object localObject4;
              localException1.printStackTrace();
              EditorActivity.this.d();
              EditorActivity.p(EditorActivity.this);
              EditorActivity.a(EditorActivity.this, false);
              localObject2 = localObject4;
              continue;
              EditorActivity.this.d();
              EditorActivity.this.b();
              EditorActivity.p(EditorActivity.this);
              continue;
              Object localObject6 = localOutOfMemoryError4;
              continue;
            }
            try
            {
              localObject7 = ((RetricaEngine)localObject1).getBitmapWithFilterApplied((Bitmap)localObject5, i, j);
              localObject3 = localObject9;
              EditorActivity.this.a(80);
              localObject1 = localObject7;
              localObject3 = localObject9;
              if (com.venticake.retrica.setting.a.a().j())
              {
                localObject3 = localObject9;
                localObject1 = i.a((Bitmap)localObject7, i, j);
              }
              localObject3 = localObject9;
              System.gc();
              localObject3 = localObject9;
              EditorActivity.this.a(85);
              localObject7 = localObject1;
              localObject3 = localObject9;
              if (com.venticake.retrica.setting.a.a().q())
              {
                localObject3 = localObject9;
                localObject7 = b.a(EditorActivity.l(EditorActivity.this), (Bitmap)localObject1, paramInt, 0, false);
              }
              localObject3 = localObject9;
              EditorActivity.this.a(90);
              localObject3 = localObject9;
              System.gc();
              localObject3 = localObject9;
              localObject1 = EditorActivity.o(EditorActivity.this).a((Bitmap)localObject7, paramInt, true, true, false, null, (ExifInterface)localObject6);
              if (localObject5 == null) {
                continue;
              }
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              localObject1 = localObject8;
              localObject6 = localObject5;
              localObject5 = localOutOfMemoryError1;
              localObject4 = localObject1;
              ((OutOfMemoryError)localObject5).printStackTrace();
              if (localObject6 != null)
              {
                localObject4 = localObject1;
                ((Bitmap)localObject6).recycle();
              }
              localObject4 = localObject1;
              EditorActivity.this.d();
              localObject4 = localObject1;
              EditorActivity.p(EditorActivity.this);
              localObject4 = localObject1;
              EditorActivity.a(EditorActivity.this, false);
              return;
            }
            try
            {
              ((Bitmap)localObject5).recycle();
              localObject6 = null;
            }
            catch (Exception localException2)
            {
              localObject4 = localObject2;
              Object localObject2 = localException2;
              continue;
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              localObject6 = localException2;
              OutOfMemoryError localOutOfMemoryError3 = localOutOfMemoryError2;
              continue;
            }
            try
            {
              System.gc();
              EditorActivity.this.a(100);
              if (localObject1 == null) {
                continue;
              }
              EditorActivity.this.a((Uri)localObject1, "StillPicture");
              EditorActivity.a(EditorActivity.this, false);
              return;
            }
            catch (OutOfMemoryError localOutOfMemoryError4)
            {
              continue;
            }
            localIOException = localIOException;
            localIOException.printStackTrace();
            localObject6 = null;
          }
        }
      }
    };
  }
  
  private Runnable a(final List<String> paramList, final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: ldc 45
        //   2: new 47	java/lang/StringBuilder
        //   5: dup
        //   6: ldc 49
        //   8: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   11: aload_0
        //   12: getfield 29	com/venticake/retrica/editor/EditorActivity$16:b	Ljava/util/List;
        //   15: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   18: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   21: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   24: pop
        //   25: ldc 45
        //   27: new 47	java/lang/StringBuilder
        //   30: dup
        //   31: ldc 67
        //   33: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   36: aload_0
        //   37: getfield 31	com/venticake/retrica/editor/EditorActivity$16:c	I
        //   40: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   43: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   46: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   49: pop
        //   50: aload_0
        //   51: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   54: invokestatic 74	com/venticake/retrica/editor/EditorActivity:j	(Lcom/venticake/retrica/editor/EditorActivity;)I
        //   57: istore 4
        //   59: aload_0
        //   60: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   63: invokestatic 77	com/venticake/retrica/editor/EditorActivity:k	(Lcom/venticake/retrica/editor/EditorActivity;)I
        //   66: istore 5
        //   68: ldc 45
        //   70: new 47	java/lang/StringBuilder
        //   73: dup
        //   74: ldc 79
        //   76: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   79: iload 4
        //   81: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   84: ldc 81
        //   86: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   89: iload 5
        //   91: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   94: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   97: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   100: pop
        //   101: ldc 85
        //   103: aload_0
        //   104: getfield 29	com/venticake/retrica/editor/EditorActivity$16:b	Ljava/util/List;
        //   107: invokeinterface 91 1 0
        //   112: i2f
        //   113: fdiv
        //   114: fstore_2
        //   115: aload_0
        //   116: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   119: bipush 10
        //   121: invokevirtual 94	com/venticake/retrica/editor/EditorActivity:a	(I)V
        //   124: aload_0
        //   125: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   128: aload_0
        //   129: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   132: invokestatic 98	com/venticake/retrica/editor/EditorActivity:l	(Lcom/venticake/retrica/editor/EditorActivity;)Landroid/app/Activity;
        //   135: aload_0
        //   136: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   139: invokestatic 102	com/venticake/retrica/editor/EditorActivity:m	(Lcom/venticake/retrica/editor/EditorActivity;)Lcom/venticake/retrica/engine/RetricaEngine;
        //   142: invokevirtual 108	com/venticake/retrica/engine/RetricaEngine:getCurrentLens	()Lcom/venticake/retrica/engine/a/g;
        //   145: aload_0
        //   146: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   149: invokestatic 98	com/venticake/retrica/editor/EditorActivity:l	(Lcom/venticake/retrica/editor/EditorActivity;)Landroid/app/Activity;
        //   152: invokevirtual 113	com/venticake/retrica/engine/a/g:a	(Landroid/content/Context;)Lcom/venticake/retrica/engine/a/g;
        //   155: aload_0
        //   156: getfield 31	com/venticake/retrica/editor/EditorActivity$16:c	I
        //   159: aload_0
        //   160: getfield 33	com/venticake/retrica/editor/EditorActivity$16:d	Z
        //   163: aload_0
        //   164: getfield 35	com/venticake/retrica/editor/EditorActivity$16:e	Z
        //   167: invokestatic 116	com/venticake/retrica/editor/EditorActivity:a	(Lcom/venticake/retrica/editor/EditorActivity;Landroid/content/Context;Lcom/venticake/retrica/engine/a/g;IZZ)Lcom/venticake/retrica/engine/RetricaEngine;
        //   170: astore 10
        //   172: iconst_0
        //   173: istore_3
        //   174: iload_3
        //   175: aload_0
        //   176: getfield 29	com/venticake/retrica/editor/EditorActivity$16:b	Ljava/util/List;
        //   179: invokeinterface 91 1 0
        //   184: if_icmplt +216 -> 400
        //   187: aload_0
        //   188: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   191: bipush 80
        //   193: invokevirtual 94	com/venticake/retrica/editor/EditorActivity:a	(I)V
        //   196: new 118	com/venticake/retrica/i
        //   199: dup
        //   200: getstatic 123	com/venticake/retrica/MainActivity:a	Landroid/content/Context;
        //   203: checkcast 120	com/venticake/retrica/MainActivity
        //   206: invokespecial 126	com/venticake/retrica/i:<init>	(Lcom/venticake/retrica/MainActivity;)V
        //   209: astore 9
        //   211: aload_0
        //   212: getfield 33	com/venticake/retrica/editor/EditorActivity$16:d	Z
        //   215: ifeq +718 -> 933
        //   218: aload_0
        //   219: getfield 35	com/venticake/retrica/editor/EditorActivity$16:e	Z
        //   222: ifeq +711 -> 933
        //   225: iconst_1
        //   226: istore 8
        //   228: aload 9
        //   230: iload 8
        //   232: invokevirtual 129	com/venticake/retrica/i:a	(Z)V
        //   235: aload 9
        //   237: aload_0
        //   238: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   241: invokestatic 132	com/venticake/retrica/editor/EditorActivity:q	(Lcom/venticake/retrica/editor/EditorActivity;)I
        //   244: invokevirtual 133	com/venticake/retrica/i:a	(I)V
        //   247: aload 9
        //   249: aload_0
        //   250: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   253: invokestatic 136	com/venticake/retrica/editor/EditorActivity:n	(Lcom/venticake/retrica/editor/EditorActivity;)I
        //   256: aload_0
        //   257: getfield 29	com/venticake/retrica/editor/EditorActivity$16:b	Ljava/util/List;
        //   260: new 15	com/venticake/retrica/editor/EditorActivity$16$2
        //   263: dup
        //   264: aload_0
        //   265: invokespecial 139	com/venticake/retrica/editor/EditorActivity$16$2:<init>	(Lcom/venticake/retrica/editor/EditorActivity$16;)V
        //   268: invokevirtual 142	com/venticake/retrica/i:a	(ILjava/util/List;Lcom/venticake/retrica/k;)Landroid/graphics/Bitmap;
        //   271: astore 9
        //   273: ldc 45
        //   275: new 47	java/lang/StringBuilder
        //   278: dup
        //   279: ldc -112
        //   281: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   284: aload_0
        //   285: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   288: invokestatic 148	com/venticake/retrica/editor/EditorActivity:r	(Lcom/venticake/retrica/editor/EditorActivity;)Landroid/location/Location;
        //   291: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   294: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   297: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   300: pop
        //   301: aload_0
        //   302: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   305: bipush 95
        //   307: invokevirtual 94	com/venticake/retrica/editor/EditorActivity:a	(I)V
        //   310: aload_0
        //   311: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   314: invokestatic 152	com/venticake/retrica/editor/EditorActivity:o	(Lcom/venticake/retrica/editor/EditorActivity;)Lcom/venticake/retrica/g;
        //   317: aload 9
        //   319: iconst_m1
        //   320: iconst_1
        //   321: iconst_0
        //   322: iconst_0
        //   323: aload_0
        //   324: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   327: invokestatic 148	com/venticake/retrica/editor/EditorActivity:r	(Lcom/venticake/retrica/editor/EditorActivity;)Landroid/location/Location;
        //   330: invokevirtual 157	com/venticake/retrica/g:a	(Landroid/graphics/Bitmap;IZZZLandroid/location/Location;)Landroid/net/Uri;
        //   333: astore 9
        //   335: ldc 45
        //   337: new 47	java/lang/StringBuilder
        //   340: dup
        //   341: ldc -97
        //   343: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   346: aload 9
        //   348: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   351: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   354: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   357: pop
        //   358: ldc 45
        //   360: ldc -95
        //   362: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   365: pop
        //   366: aload_0
        //   367: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   370: bipush 100
        //   372: invokevirtual 94	com/venticake/retrica/editor/EditorActivity:a	(I)V
        //   375: aload 9
        //   377: ifnull +562 -> 939
        //   380: aload_0
        //   381: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   384: aload 9
        //   386: ldc -93
        //   388: invokevirtual 166	com/venticake/retrica/editor/EditorActivity:a	(Landroid/net/Uri;Ljava/lang/String;)V
        //   391: aload_0
        //   392: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   395: iconst_0
        //   396: invokestatic 169	com/venticake/retrica/editor/EditorActivity:a	(Lcom/venticake/retrica/editor/EditorActivity;Z)V
        //   399: return
        //   400: aload_0
        //   401: getfield 29	com/venticake/retrica/editor/EditorActivity$16:b	Ljava/util/List;
        //   404: iload_3
        //   405: invokeinterface 173 2 0
        //   410: checkcast 175	java/lang/String
        //   413: astore 9
        //   415: ldc 45
        //   417: new 47	java/lang/StringBuilder
        //   420: dup
        //   421: ldc -79
        //   423: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   426: aload 9
        //   428: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   431: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   434: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   437: pop
        //   438: aload_0
        //   439: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   442: iload_3
        //   443: i2f
        //   444: ldc -78
        //   446: fadd
        //   447: fload_2
        //   448: fmul
        //   449: ldc -77
        //   451: fmul
        //   452: invokestatic 185	java/lang/Math:round	(F)I
        //   455: invokevirtual 94	com/venticake/retrica/editor/EditorActivity:a	(I)V
        //   458: aload 9
        //   460: invokestatic 191	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
        //   463: astore 12
        //   465: aload_0
        //   466: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   469: aload 12
        //   471: invokestatic 194	com/venticake/retrica/editor/EditorActivity:a	(Lcom/venticake/retrica/editor/EditorActivity;Landroid/net/Uri;)Landroid/graphics/Bitmap;
        //   474: astore 9
        //   476: iload_3
        //   477: i2f
        //   478: ldc -61
        //   480: fadd
        //   481: fload_2
        //   482: fmul
        //   483: ldc -77
        //   485: fmul
        //   486: invokestatic 185	java/lang/Math:round	(F)I
        //   489: istore 6
        //   491: aload_0
        //   492: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   495: iload 6
        //   497: invokevirtual 94	com/venticake/retrica/editor/EditorActivity:a	(I)V
        //   500: aload 10
        //   502: new 13	com/venticake/retrica/editor/EditorActivity$16$1
        //   505: dup
        //   506: aload_0
        //   507: iload 6
        //   509: fload_2
        //   510: invokespecial 198	com/venticake/retrica/editor/EditorActivity$16$1:<init>	(Lcom/venticake/retrica/editor/EditorActivity$16;IF)V
        //   513: invokevirtual 202	com/venticake/retrica/engine/RetricaEngine:setBitmapApplyProgressCallback	(Lcom/venticake/retrica/engine/RetricaEngine$BitmapApplyProgressCallback;)V
        //   516: aload_0
        //   517: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   520: invokestatic 136	com/venticake/retrica/editor/EditorActivity:n	(Lcom/venticake/retrica/editor/EditorActivity;)I
        //   523: invokestatic 205	com/venticake/retrica/i:b	(I)I
        //   526: istore 6
        //   528: fconst_1
        //   529: fstore_1
        //   530: aload 9
        //   532: invokevirtual 210	android/graphics/Bitmap:getWidth	()I
        //   535: iload 6
        //   537: if_icmple +330 -> 867
        //   540: aload 9
        //   542: invokevirtual 210	android/graphics/Bitmap:getWidth	()I
        //   545: aload 9
        //   547: invokevirtual 213	android/graphics/Bitmap:getHeight	()I
        //   550: if_icmple +317 -> 867
        //   553: iload 6
        //   555: i2f
        //   556: fconst_1
        //   557: fmul
        //   558: aload 9
        //   560: invokevirtual 210	android/graphics/Bitmap:getWidth	()I
        //   563: i2f
        //   564: fdiv
        //   565: fstore_1
        //   566: ldc 45
        //   568: new 47	java/lang/StringBuilder
        //   571: dup
        //   572: ldc -41
        //   574: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   577: iload 4
        //   579: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   582: ldc 81
        //   584: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   587: iload 5
        //   589: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   592: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   595: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   598: pop
        //   599: ldc 45
        //   601: new 47	java/lang/StringBuilder
        //   604: dup
        //   605: ldc -39
        //   607: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   610: iload 6
        //   612: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   615: ldc -37
        //   617: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   620: fload_1
        //   621: invokevirtual 222	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   624: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   627: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   630: pop
        //   631: iload 4
        //   633: i2f
        //   634: fload_1
        //   635: fmul
        //   636: invokestatic 185	java/lang/Math:round	(F)I
        //   639: istore 6
        //   641: fload_1
        //   642: iload 5
        //   644: i2f
        //   645: fmul
        //   646: invokestatic 185	java/lang/Math:round	(F)I
        //   649: istore 7
        //   651: ldc 45
        //   653: new 47	java/lang/StringBuilder
        //   656: dup
        //   657: ldc -32
        //   659: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   662: iload 6
        //   664: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   667: ldc 81
        //   669: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   672: iload 7
        //   674: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   677: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   680: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   683: pop
        //   684: aload 10
        //   686: aload 9
        //   688: iload 6
        //   690: iload 7
        //   692: invokevirtual 228	com/venticake/retrica/engine/RetricaEngine:getBitmapWithFilterApplied	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
        //   695: astore 11
        //   697: invokestatic 233	java/lang/System:gc	()V
        //   700: ldc 45
        //   702: new 47	java/lang/StringBuilder
        //   705: dup
        //   706: ldc -21
        //   708: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   711: aload 11
        //   713: invokevirtual 210	android/graphics/Bitmap:getWidth	()I
        //   716: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   719: ldc 81
        //   721: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   724: aload 11
        //   726: invokevirtual 213	android/graphics/Bitmap:getHeight	()I
        //   729: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   732: ldc -19
        //   734: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   737: iload 4
        //   739: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   742: ldc 81
        //   744: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   747: iload 5
        //   749: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   752: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   755: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   758: pop
        //   759: new 239	java/io/File
        //   762: dup
        //   763: aload 12
        //   765: invokevirtual 242	android/net/Uri:getPath	()Ljava/lang/String;
        //   768: invokespecial 243	java/io/File:<init>	(Ljava/lang/String;)V
        //   771: astore 12
        //   773: aload_0
        //   774: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   777: invokestatic 152	com/venticake/retrica/editor/EditorActivity:o	(Lcom/venticake/retrica/editor/EditorActivity;)Lcom/venticake/retrica/g;
        //   780: aload 12
        //   782: aload 11
        //   784: aload_0
        //   785: getfield 31	com/venticake/retrica/editor/EditorActivity$16:c	I
        //   788: iconst_1
        //   789: iconst_1
        //   790: iconst_0
        //   791: aconst_null
        //   792: aconst_null
        //   793: iconst_0
        //   794: invokevirtual 246	com/venticake/retrica/g:a	(Ljava/io/File;Landroid/graphics/Bitmap;IZZZLandroid/location/Location;Landroid/media/ExifInterface;Z)Landroid/net/Uri;
        //   797: astore 11
        //   799: ldc 45
        //   801: new 47	java/lang/StringBuilder
        //   804: dup
        //   805: ldc -8
        //   807: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   810: aload 11
        //   812: invokevirtual 249	android/net/Uri:toString	()Ljava/lang/String;
        //   815: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   818: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   821: invokestatic 65	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   824: pop
        //   825: aload 9
        //   827: ifnull +141 -> 968
        //   830: aload 9
        //   832: invokevirtual 252	android/graphics/Bitmap:recycle	()V
        //   835: aconst_null
        //   836: astore 9
        //   838: aload_0
        //   839: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   842: iload_3
        //   843: i2f
        //   844: fconst_1
        //   845: fadd
        //   846: fload_2
        //   847: fmul
        //   848: ldc -77
        //   850: fmul
        //   851: invokestatic 185	java/lang/Math:round	(F)I
        //   854: invokevirtual 94	com/venticake/retrica/editor/EditorActivity:a	(I)V
        //   857: invokestatic 233	java/lang/System:gc	()V
        //   860: iload_3
        //   861: iconst_1
        //   862: iadd
        //   863: istore_3
        //   864: goto -690 -> 174
        //   867: aload 9
        //   869: invokevirtual 213	android/graphics/Bitmap:getHeight	()I
        //   872: iload 6
        //   874: if_icmple -308 -> 566
        //   877: iload 6
        //   879: i2f
        //   880: fconst_1
        //   881: fmul
        //   882: aload 9
        //   884: invokevirtual 213	android/graphics/Bitmap:getHeight	()I
        //   887: i2f
        //   888: fdiv
        //   889: fstore_1
        //   890: goto -324 -> 566
        //   893: astore 10
        //   895: aload 10
        //   897: invokevirtual 255	java/lang/OutOfMemoryError:printStackTrace	()V
        //   900: aload 9
        //   902: ifnull +8 -> 910
        //   905: aload 9
        //   907: invokevirtual 252	android/graphics/Bitmap:recycle	()V
        //   910: aload_0
        //   911: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   914: invokevirtual 257	com/venticake/retrica/editor/EditorActivity:d	()V
        //   917: aload_0
        //   918: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   921: invokestatic 261	com/venticake/retrica/editor/EditorActivity:p	(Lcom/venticake/retrica/editor/EditorActivity;)V
        //   924: aload_0
        //   925: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   928: iconst_0
        //   929: invokestatic 169	com/venticake/retrica/editor/EditorActivity:a	(Lcom/venticake/retrica/editor/EditorActivity;Z)V
        //   932: return
        //   933: iconst_0
        //   934: istore 8
        //   936: goto -708 -> 228
        //   939: aload_0
        //   940: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   943: invokevirtual 257	com/venticake/retrica/editor/EditorActivity:d	()V
        //   946: aload_0
        //   947: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   950: invokevirtual 263	com/venticake/retrica/editor/EditorActivity:b	()V
        //   953: aload_0
        //   954: getfield 27	com/venticake/retrica/editor/EditorActivity$16:a	Lcom/venticake/retrica/editor/EditorActivity;
        //   957: invokestatic 261	com/venticake/retrica/editor/EditorActivity:p	(Lcom/venticake/retrica/editor/EditorActivity;)V
        //   960: goto -569 -> 391
        //   963: astore 10
        //   965: goto -70 -> 895
        //   968: goto -130 -> 838
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	971	0	this	16
        //   529	361	1	f1	float
        //   114	733	2	f2	float
        //   173	691	3	i	int
        //   57	681	4	j	int
        //   66	682	5	k	int
        //   489	389	6	m	int
        //   649	42	7	n	int
        //   226	709	8	bool	boolean
        //   209	697	9	localObject1	Object
        //   170	515	10	localRetricaEngine	RetricaEngine
        //   893	3	10	localOutOfMemoryError1	OutOfMemoryError
        //   963	1	10	localOutOfMemoryError2	OutOfMemoryError
        //   695	116	11	localObject2	Object
        //   463	318	12	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   684	825	893	java/lang/OutOfMemoryError
        //   830	835	893	java/lang/OutOfMemoryError
        //   838	860	963	java/lang/OutOfMemoryError
      }
    };
  }
  
  private void a(float paramFloat)
  {
    this.A = paramFloat;
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.k = com.venticake.retrica.engine.a.g.a;
      this.o = 0;
      this.p = 0;
      return;
    }
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    paramBitmap = new h();
    paramBitmap.a(this.i, i1, i2);
    float[] arrayOfFloat;
    if ((this.f == 1) || (this.f == 3)) {
      arrayOfFloat = paramBitmap.d();
    }
    for (this.k = new float[] { arrayOfFloat[1], arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[2] };; this.k = paramBitmap.d())
    {
      this.o = paramBitmap.e();
      this.p = paramBitmap.f();
      return;
    }
  }
  
  private void a(com.venticake.retrica.engine.a.g paramg)
  {
    paramg.a(com.venticake.retrica.engine.a.g.a);
  }
  
  private void a(com.venticake.retrica.engine.a.g paramg, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramg.a(paramInt, paramBoolean1, paramBoolean2, paramFloat1, paramFloat2, paramFloat3);
  }
  
  private void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.j = com.venticake.retrica.engine.a.g.a;
      this.m = 0;
      this.n = 0;
      return;
    }
    int i1 = paramBitmap.getHeight();
    int i2 = paramBitmap.getWidth();
    paramBitmap = new h();
    paramBitmap.a(this.i, i1, i2);
    this.j = paramBitmap.d();
    this.m = paramBitmap.e();
    this.n = paramBitmap.f();
    Log.i("retrica", "setBitmap1: (" + this.f + ") " + i1 + " x " + i2 + " -> " + this.m + " x " + this.n);
    Log.i("retrica", "setBitmap2: " + this.j[0] + ", " + this.j[1] + ", " + this.j[2] + ", " + this.j[3] + " - " + this.i);
  }
  
  private void b(com.venticake.retrica.engine.a.g paramg)
  {
    if (paramg == null) {
      return;
    }
    paramg.b(false);
    a(paramg);
    paramg.c(s());
    paramg.d(t());
    if (this.t != null)
    {
      d(paramg);
      this.t.invalidate();
      y();
    }
    paramg.a(this.A);
  }
  
  private void c(com.venticake.retrica.engine.a.g paramg)
  {
    b(paramg);
    this.E.setLens(paramg);
    com.venticake.retrica.setting.a.a().a(paramg.v());
    u();
    x();
  }
  
  private void d(com.venticake.retrica.engine.a.g paramg)
  {
    a(paramg, this.t.eventDispatcher().getCenterX(), 1.0F - this.t.eventDispatcher().getCenterY(), this.t.eventDispatcher().getRadius(), 0, false, false);
  }
  
  private void h()
  {
    EditorHeadButtonLayout localEditorHeadButtonLayout = this.x;
    if (this.x.isSelected()) {}
    for (boolean bool = false;; bool = true)
    {
      localEditorHeadButtonLayout.setSelected(bool);
      r();
      x();
      return;
    }
  }
  
  private void i()
  {
    EditorHeadButtonLayout localEditorHeadButtonLayout = this.y;
    if (this.y.isSelected()) {}
    for (boolean bool = false;; bool = true)
    {
      localEditorHeadButtonLayout.setSelected(bool);
      r();
      x();
      return;
    }
  }
  
  private void j()
  {
    f();
  }
  
  private void k()
  {
    e();
  }
  
  private void l()
  {
    if (this.G)
    {
      m();
      return;
    }
    n();
  }
  
  private void m()
  {
    startActivity(new Intent(this, PurchaseActivity.class));
  }
  
  /* Error */
  private void n()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 136	com/venticake/retrica/editor/EditorActivity:H	Z
    //   7: aload_0
    //   8: getfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   11: ifnull +14 -> 25
    //   14: aload_0
    //   15: getfield 418	com/venticake/retrica/editor/EditorActivity:J	Landroid/os/Handler;
    //   18: aload_0
    //   19: getfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   22: invokevirtual 424	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   30: aload_0
    //   31: getfield 426	com/venticake/retrica/editor/EditorActivity:b	Ljava/util/List;
    //   34: ifnull +62 -> 96
    //   37: aload_0
    //   38: getfield 426	com/venticake/retrica/editor/EditorActivity:b	Ljava/util/List;
    //   41: invokeinterface 431 1 0
    //   46: ifle +50 -> 96
    //   49: aload_0
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 426	com/venticake/retrica/editor/EditorActivity:b	Ljava/util/List;
    //   55: aload_0
    //   56: getfield 288	com/venticake/retrica/editor/EditorActivity:f	I
    //   59: aload_0
    //   60: getfield 433	com/venticake/retrica/editor/EditorActivity:g	Z
    //   63: aload_0
    //   64: getfield 435	com/venticake/retrica/editor/EditorActivity:h	Z
    //   67: invokespecial 437	com/venticake/retrica/editor/EditorActivity:a	(Ljava/util/List;IZZ)Ljava/lang/Runnable;
    //   70: putfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   73: aload_0
    //   74: invokespecial 439	com/venticake/retrica/editor/EditorActivity:v	()V
    //   77: aload_0
    //   78: invokevirtual 441	com/venticake/retrica/editor/EditorActivity:c	()V
    //   81: aload_0
    //   82: getfield 418	com/venticake/retrica/editor/EditorActivity:J	Landroid/os/Handler;
    //   85: aload_0
    //   86: getfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   89: invokevirtual 445	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   92: pop
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 447	com/venticake/retrica/editor/EditorActivity:c	Ljava/lang/String;
    //   102: aload_0
    //   103: getfield 288	com/venticake/retrica/editor/EditorActivity:f	I
    //   106: aload_0
    //   107: getfield 433	com/venticake/retrica/editor/EditorActivity:g	Z
    //   110: aload_0
    //   111: getfield 435	com/venticake/retrica/editor/EditorActivity:h	Z
    //   114: invokespecial 449	com/venticake/retrica/editor/EditorActivity:a	(Ljava/lang/String;IZZ)Ljava/lang/Runnable;
    //   117: putfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   120: goto -47 -> 73
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	EditorActivity
    //   123	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	123	finally
    //   25	73	123	finally
    //   73	93	123	finally
    //   96	120	123	finally
  }
  
  private void o()
  {
    UserInterfaceUtil.setAlpha(this.z, 0.3F + 0.7F * this.A);
  }
  
  private void p()
  {
    String str2;
    Object localObject1;
    if (this.E == null)
    {
      str2 = com.venticake.retrica.setting.a.a().f();
      localObject1 = null;
      if (str2 == null) {}
    }
    label267:
    for (;;)
    {
      try
      {
        localObject1 = com.venticake.retrica.engine.a.a.b().a(str2);
        if (localObject1 != null) {
          break label267;
        }
        Object localObject2;
        StringBuilder localStringBuilder;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            localObject2 = com.venticake.retrica.engine.a.a.b().g();
            localObject1 = localObject2;
          }
          catch (Exception localException2)
          {
            String str1;
            continue;
          }
          try
          {
            b((com.venticake.retrica.engine.a.g)localObject1);
            localStringBuilder = new StringBuilder("saved lensID: ");
            if (str2 == null) {
              continue;
            }
            localObject2 = str2;
            Log.d("retrica", (String)localObject2);
            Log.d("retrica", "initialLens: " + ((com.venticake.retrica.engine.a.g)localObject1).toString());
            Log.d("retrica", "eg ori: " + this.f + ", front: " + this.g + ", asp: " + this.h);
            this.E = new RetricaEngine(this, (com.venticake.retrica.engine.a.g)localObject1);
            this.E.setOrientation(0, false, false);
            this.E.setLens((com.venticake.retrica.engine.a.g)localObject1);
            Log.d("retrica", "loadEngine DONE: " + this.E.getCurrentLens());
            return;
          }
          catch (Exception localException3) {}
        }
        localException1 = localException1;
        localObject1 = null;
      }
      continue;
      str1 = "null";
      continue;
      localObject1 = this.E.getCurrentLens();
      b((com.venticake.retrica.engine.a.g)localObject1);
      this.E.setLens((com.venticake.retrica.engine.a.g)localObject1);
    }
  }
  
  private void q()
  {
    a(this.E.getCurrentLens());
  }
  
  private void r()
  {
    b(this.E.getCurrentLens());
  }
  
  private boolean s()
  {
    return this.x.isSelected();
  }
  
  private boolean t()
  {
    return this.y.isSelected();
  }
  
  private void u()
  {
    com.venticake.retrica.engine.a.g localg = this.E.getCurrentLens();
    if (localg == null)
    {
      this.C.setEnabled(false);
      return;
    }
    this.C.setEnabled(true);
    try
    {
      this.G = com.venticake.retrica.engine.a.a.b().b(localg);
      this.C.setSelected(this.G);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void v()
  {
    this.x.setEnabled(false);
    this.y.setEnabled(false);
    this.z.setEnabled(false);
    this.B.setEnabled(false);
    this.C.setEnabled(false);
  }
  
  private void w()
  {
    this.x.setEnabled(true);
    this.y.setEnabled(true);
    this.z.setEnabled(true);
    this.B.setEnabled(true);
    this.C.setEnabled(true);
  }
  
  private void x()
  {
    y();
    z();
  }
  
  private void y()
  {
    this.F = true;
  }
  
  /* Error */
  private void z()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 132	com/venticake/retrica/editor/EditorActivity:F	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc -60
    //   16: ldc_w 536
    //   19: invokestatic 221	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: aload_0
    //   24: invokevirtual 441	com/venticake/retrica/editor/EditorActivity:c	()V
    //   27: aload_0
    //   28: bipush 10
    //   30: invokevirtual 539	com/venticake/retrica/editor/EditorActivity:a	(I)V
    //   33: aload_0
    //   34: getfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   37: ifnull +14 -> 51
    //   40: aload_0
    //   41: getfield 418	com/venticake/retrica/editor/EditorActivity:J	Landroid/os/Handler;
    //   44: aload_0
    //   45: getfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   48: invokevirtual 424	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   51: aload_0
    //   52: new 42	com/venticake/retrica/editor/EditorActivity$7
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 541	com/venticake/retrica/editor/EditorActivity$7:<init>	(Lcom/venticake/retrica/editor/EditorActivity;)V
    //   60: putfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   63: aload_0
    //   64: getfield 418	com/venticake/retrica/editor/EditorActivity:J	Landroid/os/Handler;
    //   67: aload_0
    //   68: getfield 416	com/venticake/retrica/editor/EditorActivity:K	Ljava/lang/Runnable;
    //   71: invokevirtual 445	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   74: pop
    //   75: goto -64 -> 11
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	EditorActivity
    //   6	2	1	bool	boolean
    //   78	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	78	finally
    //   14	51	78	finally
    //   51	75	78	finally
  }
  
  protected void a()
  {
    this.s.setOnLoadingFinishListner(new LazyImageView.LoadingFinishListner()
    {
      public void onLoadingFinish(Bitmap paramAnonymousBitmap)
      {
        EditorActivity.a(EditorActivity.this, paramAnonymousBitmap);
        EditorActivity.g(EditorActivity.this);
      }
    });
    if ((this.e != null) && (this.d == null))
    {
      this.d = BitmapFactory.decodeByteArray(this.e, 0, this.e.length);
      b(this.d);
      this.s.loadImage(this.d);
      return;
    }
    if (this.c != null)
    {
      this.s.setOnURILoadingFinishListner(new LazyImageView.URILoadingFinishListner()
      {
        public void onURILoadingFinish(Bitmap paramAnonymousBitmap)
        {
          EditorActivity.b(EditorActivity.this, paramAnonymousBitmap);
          EditorActivity.h(EditorActivity.this);
          EditorActivity.f(EditorActivity.this).setCropRegion(EditorActivity.i(EditorActivity.this));
        }
      });
      this.s.loadImage(this.c);
      return;
    }
    Log.e("retrica", "ERROR!!! mURLString or mBitmap or mBytes needed!!!");
  }
  
  public void a(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.v.setProgress(paramInt);
      return;
    }
    this.q.post(new Runnable()
    {
      public void run()
      {
        EditorActivity.s(EditorActivity.this).setProgress(paramInt);
      }
    });
  }
  
  public void a(Uri paramUri, String paramString)
  {
    Intent localIntent = new Intent(this.a, QuickViewActivity.class);
    localIntent.putExtra("From", "QuickView after NoEffect capture");
    localIntent.putExtra("DisplayAd", true);
    localIntent.putExtra("URI", paramUri.toString());
    if (paramString != null) {
      localIntent.putExtra("DebugText", paramString);
    }
    startActivity(localIntent);
    finish();
  }
  
  /* Error */
  protected void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 617	com/venticake/retrica/editor/EditorActivity:D	Lcom/venticake/retrica/view/LensSelector;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 617	com/venticake/retrica/editor/EditorActivity:D	Lcom/venticake/retrica/view/LensSelector;
    //   13: getfield 623	com/venticake/retrica/view/LensSelector:lensIntensityControlView	Lcom/venticake/retrica/view/LensIntensityControlView;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 534	com/venticake/retrica/editor/EditorActivity:u	Landroid/widget/TextView;
    //   28: invokevirtual 628	android/widget/TextView:clearAnimation	()V
    //   31: aload_0
    //   32: getfield 617	com/venticake/retrica/editor/EditorActivity:D	Lcom/venticake/retrica/view/LensSelector;
    //   35: getfield 623	com/venticake/retrica/view/LensSelector:lensIntensityControlView	Lcom/venticake/retrica/view/LensIntensityControlView;
    //   38: invokevirtual 633	com/venticake/retrica/view/LensIntensityControlView:getIntensity	()F
    //   41: fstore_2
    //   42: aload_0
    //   43: getfield 534	com/venticake/retrica/editor/EditorActivity:u	Landroid/widget/TextView;
    //   46: ldc_w 635
    //   49: iconst_1
    //   50: anewarray 637	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: fload_2
    //   56: ldc_w 638
    //   59: fmul
    //   60: invokestatic 644	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   63: aastore
    //   64: invokestatic 650	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   67: invokevirtual 654	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   70: aload_0
    //   71: getfield 534	com/venticake/retrica/editor/EditorActivity:u	Landroid/widget/TextView;
    //   74: fconst_0
    //   75: iload_1
    //   76: new 48	com/venticake/retrica/editor/EditorActivity$8
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 655	com/venticake/retrica/editor/EditorActivity$8:<init>	(Lcom/venticake/retrica/editor/EditorActivity;)V
    //   84: invokestatic 658	com/venticake/retrica/util/UserInterfaceUtil:setAlpha	(Landroid/view/View;FZLandroid/view/animation/Animation$AnimationListener;)V
    //   87: goto -66 -> 21
    //   90: astore_3
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_3
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	EditorActivity
    //   0	95	1	paramBoolean	boolean
    //   41	15	2	f1	float
    //   16	2	3	localLensIntensityControlView	LensIntensityControlView
    //   90	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	90	finally
    //   24	87	90	finally
  }
  
  protected void b()
  {
    UserInterfaceUtil.displayError(this, getResources().getString(2131165289));
  }
  
  public boolean blurGestureEventEnabled()
  {
    return t();
  }
  
  public void blurTouchViewTouchDown()
  {
    if (!t()) {
      this.t.setVisibility(4);
    }
  }
  
  public void blurTouchViewTouchUp()
  {
    if (!t())
    {
      this.t.setVisibility(0);
      return;
    }
    z();
  }
  
  public void c()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.v.setProgress(0);
      this.v.setVisibility(0);
      this.w.setVisibility(0);
      return;
    }
    this.q.post(new Runnable()
    {
      public void run()
      {
        EditorActivity.s(EditorActivity.this).setProgress(0);
        EditorActivity.s(EditorActivity.this).setVisibility(0);
        EditorActivity.t(EditorActivity.this).setVisibility(0);
      }
    });
  }
  
  public void centerChanged(float paramFloat1, float paramFloat2)
  {
    if (!t()) {
      return;
    }
    d(this.E.getCurrentLens());
    this.t.invalidate();
    y();
  }
  
  public void d()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.v.setVisibility(4);
      this.w.setVisibility(4);
      return;
    }
    this.q.post(new Runnable()
    {
      public void run()
      {
        EditorActivity.s(EditorActivity.this).setVisibility(4);
        EditorActivity.t(EditorActivity.this).setVisibility(4);
      }
    });
  }
  
  protected void e()
  {
    new Handler(getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        jdField_this.finish();
      }
    });
  }
  
  protected void f()
  {
    this.D.show();
  }
  
  /* Error */
  protected void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 617	com/venticake/retrica/editor/EditorActivity:D	Lcom/venticake/retrica/view/LensSelector;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 617	com/venticake/retrica/editor/EditorActivity:D	Lcom/venticake/retrica/view/LensSelector;
    //   13: getfield 623	com/venticake/retrica/view/LensSelector:lensIntensityControlView	Lcom/venticake/retrica/view/LensIntensityControlView;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 617	com/venticake/retrica/editor/EditorActivity:D	Lcom/venticake/retrica/view/LensSelector;
    //   28: getfield 623	com/venticake/retrica/view/LensSelector:lensIntensityControlView	Lcom/venticake/retrica/view/LensIntensityControlView;
    //   31: invokevirtual 633	com/venticake/retrica/view/LensIntensityControlView:getIntensity	()F
    //   34: fstore_1
    //   35: aload_0
    //   36: getfield 534	com/venticake/retrica/editor/EditorActivity:u	Landroid/widget/TextView;
    //   39: invokestatic 697	com/venticake/retrica/util/UserInterfaceUtil:updateTextViewForLensIntensity	(Landroid/widget/TextView;)V
    //   42: aload_0
    //   43: getfield 534	com/venticake/retrica/editor/EditorActivity:u	Landroid/widget/TextView;
    //   46: ldc_w 635
    //   49: iconst_1
    //   50: anewarray 637	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: fload_1
    //   56: ldc_w 638
    //   59: fmul
    //   60: invokestatic 644	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   63: aastore
    //   64: invokestatic 650	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   67: invokevirtual 654	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   70: aload_0
    //   71: getfield 534	com/venticake/retrica/editor/EditorActivity:u	Landroid/widget/TextView;
    //   74: iconst_0
    //   75: invokevirtual 698	android/widget/TextView:setVisibility	(I)V
    //   78: goto -57 -> 21
    //   81: astore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	EditorActivity
    //   34	22	1	f1	float
    //   16	2	2	localLensIntensityControlView	LensIntensityControlView
    //   81	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	81	finally
    //   24	78	81	finally
  }
  
  public void gestureEventFinished() {}
  
  public void gestureEventStarted() {}
  
  public com.venticake.retrica.engine.a.g lensSelectorSelectedLens()
  {
    if (this.E == null) {
      return null;
    }
    return this.E.getCurrentLens();
  }
  
  public void onBackPressed()
  {
    if (this.D.getVisibility() == 0)
    {
      this.D.onBackPressed();
      return;
    }
    if (this.H)
    {
      Log.d("retrica", "isApplingFullsizeBitmap...");
      return;
    }
    super.onBackPressed();
  }
  
  public void onCloseButtonTouched() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903065);
    paramBundle = getIntent();
    this.b = paramBundle.getStringArrayListExtra("URI_LIST");
    this.c = paramBundle.getStringExtra("URI");
    this.d = ((Bitmap)paramBundle.getParcelableExtra("BITMAP"));
    this.e = paramBundle.getByteArrayExtra("BYTES");
    this.f = paramBundle.getIntExtra("ORIENTATION", -1);
    this.g = paramBundle.getBooleanExtra("IS_FRONT_CAMERA", false);
    this.h = paramBundle.getBooleanExtra("SAVE_AS_PREVIEW", false);
    this.i = paramBundle.getIntExtra("COLLAGE_STATUS", 0);
    this.l = ((Location)paramBundle.getParcelableExtra("LOCATION"));
    if ((this.b != null) && (this.b.size() > 0)) {
      this.c = ((String)this.b.get(0));
    }
    this.a = this;
    this.I = new HandlerThread("Editor.Bitmap.Process");
    this.I.start();
    this.J = new Handler(this.I.getLooper());
    this.q = new Handler(Looper.getMainLooper());
    this.r = new com.venticake.retrica.g(this);
    this.s = ((LazyImageView)findViewById(2131296336));
    this.t = ((EditorPreviewImageView)findViewById(2131296337));
    this.t.setEventListner(this);
    this.u = ((TextView)findViewById(2131296338));
    this.v = ((ProgressBar)findViewById(2131296339));
    this.w = ((ProgressBar)findViewById(2131296340));
    this.x = ((EditorHeadButtonLayout)findViewById(2131296341));
    this.x.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        EditorActivity.a(EditorActivity.this);
      }
    });
    this.y = ((EditorHeadButtonLayout)findViewById(2131296343));
    this.y.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        EditorActivity.b(EditorActivity.this);
      }
    });
    this.z = ((EditorHeadButtonLayout)findViewById(2131296345));
    this.z.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        EditorActivity.c(EditorActivity.this);
      }
    });
    this.B = ((ImageButton)findViewById(2131296347));
    this.B.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        EditorActivity.d(EditorActivity.this);
      }
    });
    this.C = ((ImageButton)findViewById(2131296348));
    this.C.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        EditorActivity.e(EditorActivity.this);
      }
    });
    this.D = ((LensSelector)findViewById(2131296349));
    this.D.setLensSelectorListener(this);
    a(com.venticake.retrica.setting.a.a().g());
    p();
  }
  
  protected void onDestroy()
  {
    Log.d("retrica", "EditorActivity will destroy~~: " + this.c);
    if (this.c != null) {
      com.venticake.retrica.g.a(this, this.c);
    }
    super.onDestroy();
  }
  
  public void onHidden(LensSelector paramLensSelector) {}
  
  public void onIntensityEditModeChanged(LensIntensityControlView paramLensIntensityControlView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g();
      return;
    }
    o();
    r();
    x();
    a(true);
  }
  
  public void onIntensityValueChanged(LensIntensityControlView paramLensIntensityControlView, float paramFloat)
  {
    g();
    a(paramFloat);
  }
  
  protected void onResume()
  {
    super.onResume();
    d();
    u();
    w();
    if (!this.s.isLoaded()) {
      this.s.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        @SuppressLint({"NewApi"})
        public void onGlobalLayout()
        {
          if (Build.VERSION.SDK_INT >= 16) {
            EditorActivity.f(EditorActivity.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
          for (;;)
          {
            Log.d("retrica", "onGlobalLayout - " + EditorActivity.f(EditorActivity.this).getMeasuredWidth() + " x " + EditorActivity.f(EditorActivity.this).getMeasuredHeight());
            EditorActivity.this.a();
            return;
            EditorActivity.f(EditorActivity.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      });
    }
  }
  
  public void onSelectLens(com.venticake.retrica.engine.a.g paramg, LensSelector paramLensSelector)
  {
    c(paramg);
  }
  
  public void onShown(LensSelector paramLensSelector) {}
  
  public void radiusChanged(float paramFloat)
  {
    if (!t()) {
      return;
    }
    d(this.E.getCurrentLens());
    this.t.invalidate();
    y();
  }
  
  public void swipedToLeft() {}
  
  public void swipedToRight() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/editor/EditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */