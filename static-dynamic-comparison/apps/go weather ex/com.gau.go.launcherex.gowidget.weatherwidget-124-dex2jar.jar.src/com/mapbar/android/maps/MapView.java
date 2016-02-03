package com.mapbar.android.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Scroller;
import android.widget.ZoomControls;
import com.mapbar.map.MapPoint;
import com.mapbar.map.b;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class MapView
  extends ViewGroup
{
  private int A = this.y;
  private int B = 0;
  private int C = 0;
  private Drawable D;
  private int E;
  private int F;
  private double G;
  private boolean H;
  private String I;
  private q J;
  private int K;
  private boolean L;
  private boolean M;
  private boolean N;
  private Bitmap O;
  private Handler P;
  private boolean Q;
  final Repainter a;
  int b = 0;
  int c = 0;
  int d;
  int e;
  private H f = new C("");
  private MapPoint g = new MapPoint(0, 0);
  private o h;
  private n i;
  private Context j;
  private Handler k;
  private ZoomHelper l;
  private PixelConverter m;
  protected Scroller mScroller;
  private MapController n;
  private OverlayBundle o;
  private GestureDetector p;
  private TrackballGestureDetector q;
  private ZoomControls r = new ZoomControls(getContext());
  private MultiTouchHelper s;
  private int t;
  private int u;
  private int v = 8;
  private int w;
  private int x;
  private int y = 12;
  private int z = this.y;
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842890);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    System.currentTimeMillis();
    this.D = null;
    this.E = 59;
    this.F = 28;
    this.G = 1.0D;
    this.J = null;
    this.K = 0;
    this.L = false;
    this.M = false;
    this.N = false;
    this.d = 300;
    this.e = this.d;
    this.O = null;
    this.P = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        MapView.this.P.removeMessages(1);
        if (MapView.this.N) {
          MapView.this.P.sendEmptyMessageDelayed(1, 60000L);
        }
        try
        {
          MapView.this.getTrafficCache().b();
          MapView.this.getTrafficCache().a();
          return;
        }
        catch (Exception paramAnonymousMessage) {}
      }
    };
    this.Q = false;
    if (paramAttributeSet != null) {
      D.c = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "apiKey");
    }
    if (!D.a) {
      D.a = validateKey(D.c);
    }
    this.o = null;
    this.j = paramContext;
    setWillNotDraw(false);
    if ((paramContext instanceof MapActivity))
    {
      ((MapActivity)paramContext).setupMapView(this);
      this.mScroller = new Scroller(paramContext);
      this.a = new Repainter();
      return;
    }
    throw new IllegalArgumentException("MapViews can only be created inside instances of MapActivity.");
  }
  
  public MapView(Context paramContext, String paramString)
  {
    this(paramContext, null, 16842890);
    D.c = paramString;
    if (!D.a) {
      D.a = validateKey(D.c);
    }
  }
  
  private int O5976(int paramInt1, int paramInt2)
  {
    paramInt2 = this.g.getLongitude();
    int i1 = this.b / 2;
    return (paramInt1 - paramInt2) % 36000000 * this.d / D.a(this.v) + i1;
  }
  
  private int SWN4x(int paramInt1, int paramInt2)
  {
    paramInt2 = this.b / 2;
    int i1 = this.g.getLongitude();
    return (paramInt1 - paramInt2) * D.a(this.v) / this.d + i1;
  }
  
  private int TFiU(int paramInt1, int paramInt2)
  {
    paramInt1 = this.c / 2;
    return this.g.getLatitude() - (paramInt2 - paramInt1) * D.b(this.v) / this.e;
  }
  
  private boolean canZoomIn()
  {
    return getZoom().a() < getMaxZoomLevel();
  }
  
  private boolean canZoomOut()
  {
    return getZoom().a() > 0;
  }
  
  private static int ceil(int paramInt1, int paramInt2)
  {
    if (paramInt1 % paramInt2 != 0) {
      return paramInt1 / paramInt2 + 1;
    }
    return paramInt1 / paramInt2;
  }
  
  private boolean checkPaintTimeExceeded(long paramLong)
  {
    return System.currentTimeMillis() - paramLong > 500L;
  }
  
  private void drawLogo(Canvas paramCanvas)
  {
    Drawable localDrawable = getLogo();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  private void drawView(Canvas paramCanvas)
  {
    if (this.M) {}
    int i5;
    int i3;
    do
    {
      return;
      updateZoomControls();
      i5 = getChildCount();
      paramCanvas = new Point();
      i3 = 0;
    } while (i3 >= i5);
    View localView = getChildAt(i3);
    LayoutParams localLayoutParams;
    label123:
    int i6;
    int i7;
    int i4;
    int i1;
    int i2;
    if (localView.getVisibility() != 8)
    {
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.mode != 1)
      {
        if (localLayoutParams.mode != 0) {
          break label278;
        }
        this.m.toPixels(localLayoutParams.point, paramCanvas);
        paramCanvas.x += localLayoutParams.x;
        paramCanvas.y += localLayoutParams.y;
        i6 = localView.getMeasuredWidth();
        i7 = localView.getMeasuredHeight();
        i4 = paramCanvas.x;
        i1 = paramCanvas.y;
        int i8 = localLayoutParams.alignment;
        i2 = i4;
        switch (i8 & 0x7)
        {
        default: 
          i2 = i4;
        case 2: 
        case 3: 
        case 4: 
          label199:
          switch (i8 & 0x70)
          {
          }
          break;
        }
      }
    }
    for (;;)
    {
      i2 = getPaddingLeft() + i2;
      i1 += getPaddingTop();
      localView.layout(i2, i1, i2 + i6, i1 + i7);
      i3 += 1;
      break;
      label278:
      paramCanvas.x = localLayoutParams.x;
      paramCanvas.y = localLayoutParams.y;
      break label123;
      i2 = i4 - i6 / 2;
      break label199;
      i2 = i4 - (i6 - 1);
      break label199;
      continue;
      i1 -= i7 / 2;
      continue;
      i1 -= i7 - 1;
    }
  }
  
  private Drawable getLogo()
  {
    try
    {
      if (this.D == null) {
        initLogo();
      }
      return this.D;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private o getMapCache()
  {
    if (this.h == null) {}
    for (;;)
    {
      try
      {
        localFile = new File(getContext().getCacheDir(), "map");
        if (!localFile.exists()) {
          continue;
        }
        if (!localFile.isDirectory())
        {
          localFile.delete();
          localFile.mkdirs();
        }
        this.h = new o(localFile, new d.b()
        {
          public boolean eject(File paramAnonymousFile)
          {
            return System.currentTimeMillis() - paramAnonymousFile.lastModified() > 604800000L;
          }
        }, this.z);
      }
      catch (Exception localException)
      {
        File localFile;
        localException.printStackTrace();
        continue;
      }
      return this.h;
      localFile.mkdirs();
    }
  }
  
  /* Error */
  private Drawable getResDrawable(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 468	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: aload_1
    //   5: invokevirtual 474	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: new 476	android/graphics/drawable/BitmapDrawable
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 479	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   19: astore_3
    //   20: aload_2
    //   21: ifnull +7 -> 28
    //   24: aload_2
    //   25: invokevirtual 484	java/io/InputStream:close	()V
    //   28: aload_3
    //   29: areturn
    //   30: astore_3
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: invokevirtual 460	java/lang/Exception:printStackTrace	()V
    //   39: aload_2
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: invokevirtual 484	java/io/InputStream:close	()V
    //   47: aconst_null
    //   48: areturn
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 484	java/io/InputStream:close	()V
    //   60: aload_2
    //   61: athrow
    //   62: astore_1
    //   63: aload_3
    //   64: areturn
    //   65: astore_1
    //   66: goto -19 -> 47
    //   69: astore_1
    //   70: goto -10 -> 60
    //   73: astore_2
    //   74: goto -22 -> 52
    //   77: astore_3
    //   78: goto -45 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	MapView
    //   0	81	1	paramString	String
    //   8	36	2	localInputStream	InputStream
    //   49	12	2	localObject1	Object
    //   73	1	2	localObject2	Object
    //   19	10	3	localBitmapDrawable	BitmapDrawable
    //   30	34	3	localException1	Exception
    //   77	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	30	java/lang/Exception
    //   0	9	49	finally
    //   24	28	62	java/lang/Exception
    //   43	47	65	java/lang/Exception
    //   56	60	69	java/lang/Exception
    //   11	20	73	finally
    //   35	39	73	finally
    //   11	20	77	java/lang/Exception
  }
  
  private n getTrafficCache()
  {
    if (this.i == null) {}
    for (;;)
    {
      try
      {
        localFile = new File(this.j.getCacheDir(), "traffic");
        if (!localFile.exists()) {
          continue;
        }
        if (!localFile.isDirectory())
        {
          localFile.delete();
          localFile.mkdirs();
        }
        this.i = new n(localFile, new d.b()
        {
          public boolean eject(File paramAnonymousFile)
          {
            return System.currentTimeMillis() - paramAnonymousFile.lastModified() > 300000L;
          }
        }, this.A);
      }
      catch (Exception localException)
      {
        File localFile;
        continue;
      }
      return this.i;
      localFile.mkdirs();
    }
  }
  
  private void getWebImageVersion()
  {
    try
    {
      A localA = new A(this.j, 3, 1, false);
      localA.a(D.i + D.h + this.d + "/" + "version.txt");
      localA.a(new z()
      {
        public void downloadEnd(Object paramAnonymousObject)
        {
          if (paramAnonymousObject != null) {}
          try
          {
            MapView.access$602(MapView.this, Integer.parseInt(((String)paramAnonymousObject).trim()));
            if (MapView.this.J != null) {
              MapView.this.J.a(MapView.this.K);
            }
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            ((Exception)paramAnonymousObject).printStackTrace();
          }
        }
      });
      localA.b(new Object[0]);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void initLogo()
  {
    try
    {
      if (this.D == null) {
        this.D = getResDrawable("/res/logo.png");
      }
      if (this.D != null)
      {
        int i1 = getMeasuredWidth() - (int)(this.E / 1.5D * this.G);
        int i2 = (int)(this.F * this.G);
        int i3 = (int)(this.E / 2 * this.G);
        int i4 = (int)(this.F / 2 * this.G);
        this.D.setBounds(-i3 + i1, -i4 + i2, i1 + i3, i2 + i4);
      }
      return;
    }
    catch (Exception localException) {}catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private int kjG2C(int paramInt1, int paramInt2)
  {
    return this.c / 2 - (paramInt2 - this.g.getLatitude()) % 36000000 * this.e / D.b(this.v);
  }
  
  private void loadLocalData()
  {
    if (this.L) {
      return;
    }
    this.L = true;
    new Thread(new Runnable()
    {
      public void run()
      {
        if (MapView.this.d == 300)
        {
          if (TextUtils.isEmpty(MapView.this.I)) {
            MapView.access$402(MapView.this, "/sdcard/mapbar/rsf/300/");
          }
          MapView.access$502(MapView.this, q.a(MapView.this.I, 1));
        }
        for (;;)
        {
          if (MapView.this.J != null)
          {
            MapView.this.J.a(MapView.this.K);
            MapView.this.postInvalidate();
          }
          MapView.access$702(MapView.this, false);
          return;
          if (TextUtils.isEmpty(MapView.this.I)) {
            MapView.access$402(MapView.this, "/sdcard/mapbar/rsf/150/");
          }
          MapView.access$502(MapView.this, q.a(MapView.this.I, 0));
        }
      }
    }).start();
    getWebImageVersion();
  }
  
  private void logMapCenterRange()
  {
    GeoPoint localGeoPoint = getMapCenter();
    x.i = Math.max(x.i, localGeoPoint.getLatitudeE6() / 10);
    x.j = Math.max(x.j, localGeoPoint.getLongitudeE6() / 10);
    x.k = Math.min(x.k, localGeoPoint.getLatitudeE6() / 10);
    x.l = Math.min(x.l, localGeoPoint.getLongitudeE6() / 10);
  }
  
  private void logMvCount()
  {
    x.h += 1;
  }
  
  private void logZoomRange()
  {
    int i1 = getZoomLevel();
    x.m = Math.max(x.m, i1);
    x.n = Math.min(x.n, i1);
  }
  
  private void setMapTile(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramInt1 = this.g.getLongitude() + paramInt1 * paramInt3;
    paramInt2 = this.g.getLatitude() - paramInt2 * paramInt4;
    String str = b.a(paramInt1, paramInt2, this.v);
    paramInt3 = this.d * paramInt5 + this.B;
    paramInt4 = this.d * paramInt6 + this.C;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(D.h).append(this.d).append("/").append(str).append(".png");
      getMapCache().a(this, paramCanvas, this.y, paramInt3, paramInt4, true, localStringBuilder.toString(), paramInt1, paramInt2, this.v, this.H, this.J, this.O);
      if ((this.N) && (this.v <= 13) && (this.v >= 8))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(D.k).append(this.d).append("/").append(str).append(".png");
        getTrafficCache().a(this, paramCanvas, this.y, paramInt3, paramInt4, true, localStringBuilder.toString(), this.O);
      }
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  private Point toImageCoordinate(int paramInt1, int paramInt2)
  {
    Point localPoint = new Point();
    localPoint.x = O5976(paramInt1 / 10, paramInt2 / 10);
    localPoint.y = kjG2C(paramInt1 / 10, paramInt2 / 10);
    return localPoint;
  }
  
  private Point toMapCoordinate(int paramInt1, int paramInt2)
  {
    Point localPoint = new Point();
    localPoint.x = SWN4x(paramInt1, paramInt2);
    localPoint.y = TFiU(paramInt1, paramInt2);
    return localPoint;
  }
  
  private void updateZoomControls()
  {
    boolean bool2 = true;
    ZoomControls localZoomControls = this.r;
    if (this.v > 0)
    {
      bool1 = true;
      localZoomControls.setIsZoomOutEnabled(bool1);
      localZoomControls = this.r;
      if (this.v >= getMaxZoomLevel()) {
        break label50;
      }
    }
    label50:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localZoomControls.setIsZoomInEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  private boolean validateKey(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {}
    try
    {
      if ("SYSTEM".equals(D.b)) {
        return true;
      }
      paramString = new t(v.a(paramString));
      if ((paramString != null) && (paramString.a() != null))
      {
        boolean bool = paramString.a().equalsIgnoreCase(D.b);
        if (bool) {
          break label72;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return false;
    label72:
    return true;
  }
  
  protected void animateTo(GeoPoint paramGeoPoint)
  {
    PixelConverter localPixelConverter = (PixelConverter)getProjection();
    Point localPoint = localPixelConverter.toPixels(new GeoPoint(this.g), null);
    paramGeoPoint = localPixelConverter.toPixels(paramGeoPoint, null);
    this.mScroller.startScroll(this.mScroller.getCurrX(), this.mScroller.getCurrY(), paramGeoPoint.x - localPoint.x, paramGeoPoint.y - localPoint.y, 1000);
    postInvalidate();
    logMvCount();
    logMapCenterRange();
  }
  
  public boolean canCoverCenter()
  {
    String str = b.a(this.g.getLongitude(), this.g.getLatitude(), this.v);
    str = D.h + this.d + "/" + str + ".png";
    return getMapCache().b(str);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void closeLocalData()
  {
    this.H = false;
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      int i1 = this.mScroller.getCurrX();
      int i2 = this.t;
      int i3 = this.mScroller.getCurrY();
      int i4 = this.u;
      this.t = this.mScroller.getCurrX();
      this.u = this.mScroller.getCurrY();
      setMapCenter(new InternalProjection(null).pointToGeoPoint(new Point(i1 - i2 + this.b / 2, i3 - i4 + this.c / 2)));
      postInvalidate();
      return;
    }
    super.computeScroll();
  }
  
  void destory()
  {
    this.M = true;
    E.a("MapView", "mDestory=true");
    this.N = false;
    if (this.P != null)
    {
      this.P.removeMessages(1);
      this.P = null;
    }
    if (this.h != null)
    {
      this.h.f();
      this.h = null;
    }
    if (this.i != null)
    {
      this.i.f();
      this.i = null;
    }
    if (this.l != null)
    {
      this.l.destory();
      this.l = null;
    }
    if (this.s != null)
    {
      this.s.destory();
      this.s = null;
    }
    if (this.D != null) {}
    try
    {
      ((BitmapDrawable)this.D).getBitmap().recycle();
      this.D = null;
      if (this.O != null) {}
      try
      {
        this.O.recycle();
        this.O = null;
        if (this.r != null)
        {
          this.r.removeAllViews();
          removeView(this.r);
          this.r = null;
        }
        if (this.J != null)
        {
          this.J.a();
          this.J = null;
        }
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.j = null;
        return;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.r.setVisibility(0);
    bringChildToFront(this.r);
    this.r.layout((this.b - this.r.getMeasuredWidth()) / 2 + getScrollX(), this.c - this.r.getMeasuredHeight() + getScrollY(), (this.b + this.r.getMeasuredWidth()) / 2 + getScrollX(), this.c + getScrollY());
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      getController().setCenter(new GeoPoint(this.g));
    }
  }
  
  public void displayZoomControls(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      addView(this.r);
      requestChildFocus(this.r, this.r);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  boolean doZoom(boolean paramBoolean)
  {
    return doZoom(paramBoolean, this.w / 2, this.x / 2);
  }
  
  boolean doZoom(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (((paramBoolean) && (canZoomIn())) || ((!paramBoolean) && (canZoomOut())))
    {
      this.l.doZoom(paramBoolean, true, paramInt1, paramInt2);
      logMvCount();
      logZoomRange();
      return true;
    }
    return false;
  }
  
  void drawForMultiTouch(Canvas paramCanvas, boolean paramBoolean)
  {
    long l1 = getDrawingTime();
    drawMap(paramCanvas, paramBoolean);
    this.o.draw(paramCanvas, this, l1);
  }
  
  boolean drawMap(Canvas paramCanvas, boolean paramBoolean)
  {
    if (this.M) {
      return false;
    }
    int i1 = this.g.getLongitude();
    int i2 = this.g.getLatitude();
    int i5 = D.a(this.v);
    int i6 = D.b(this.v);
    i1 = this.b / 2 - i1 % i5 * this.d / i5;
    int i3 = this.c / 2;
    int i4 = this.e;
    i2 = i2 % i6 * this.e / i6 + (i3 - i4) + D.c(this.v);
    int i10 = -ceil(i1 * 1000 / this.d, 1000);
    int i7 = ceil((this.b - i1 - this.d) * 1000 / this.d, 1000);
    int i8 = -ceil(i2 * 1000 / this.e, 1000);
    int i9 = ceil((this.c - i2 - this.e) * 1000 / this.e, 1000);
    this.B = (i1 + this.d * i10);
    this.C = (this.e * i8 + i2);
    i2 = -i10;
    i1 = 0;
    while (i1 >= i10)
    {
      i4 = -i8;
      i3 = 0;
      while (i3 >= i8)
      {
        setMapTile(paramCanvas, i1, i3, i5, i6, i2, i4);
        i4 -= 1;
        i3 -= 1;
      }
      i4 = -i8 + 1;
      i3 = 1;
      while (i3 <= i9)
      {
        setMapTile(paramCanvas, i1, i3, i5, i6, i2, i4);
        i4 += 1;
        i3 += 1;
      }
      i2 -= 1;
      i1 -= 1;
    }
    i2 = -i10 + 1;
    i1 = 1;
    while (i1 <= i7)
    {
      i4 = -i8;
      i3 = 0;
      while (i3 >= i8)
      {
        setMapTile(paramCanvas, i1, i3, i5, i6, i2, i4);
        i4 -= 1;
        i3 -= 1;
      }
      i4 = -i8 + 1;
      i3 = 1;
      while (i3 <= i9)
      {
        setMapTile(paramCanvas, i1, i3, i5, i6, i2, i4);
        i4 += 1;
        i3 += 1;
      }
      i2 += 1;
      i1 += 1;
    }
    return !checkPaintTimeExceeded(System.currentTimeMillis());
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public MapController getController()
  {
    return this.n;
  }
  
  public int getLatitudeSpan()
  {
    Object localObject = (PixelConverter)getProjection();
    GeoPoint localGeoPoint = ((PixelConverter)localObject).fromPixels(0, 0);
    localObject = ((PixelConverter)localObject).fromPixels(this.b - 1, this.c - 1);
    return localGeoPoint.getLatitudeE6() - ((GeoPoint)localObject).getLatitudeE6();
  }
  
  public int getLongitudeSpan()
  {
    PixelConverter localPixelConverter = (PixelConverter)getProjection();
    GeoPoint localGeoPoint = localPixelConverter.fromPixels(0, 0);
    return localPixelConverter.fromPixels(this.b - 1, this.c - 1).getLongitudeE6() - localGeoPoint.getLongitudeE6();
  }
  
  public GeoPoint getMapCenter()
  {
    return new GeoPoint(this.g);
  }
  
  public int getMapHeight()
  {
    return this.c;
  }
  
  public int getMapWidth()
  {
    return this.b;
  }
  
  public int getMaxZoomLevel()
  {
    H localH = this.f;
    return 13;
  }
  
  public final List<Overlay> getOverlays()
  {
    if ((this.o == null) || (this.o.getOverlays() == null)) {
      return null;
    }
    return this.o.getOverlays();
  }
  
  Point getPointXY(Point paramPoint)
  {
    Point localPoint = new Point();
    getPointXY(paramPoint, localPoint);
    return localPoint;
  }
  
  void getPointXY(Point paramPoint1, Point paramPoint2)
  {
    paramPoint1 = toImageCoordinate2(paramPoint1.x, paramPoint1.y);
    paramPoint2.x = paramPoint1[0];
    paramPoint2.y = paramPoint1[1];
  }
  
  public Projection getProjection()
  {
    return this.m;
  }
  
  double getScreenDensity()
  {
    return this.G;
  }
  
  com.mapbar.map.c getZoom()
  {
    return com.mapbar.map.c.a(this.v);
  }
  
  @Deprecated
  public View getZoomControls()
  {
    return this.r;
  }
  
  public int getZoomLevel()
  {
    return getZoom().a();
  }
  
  void initMapView(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    paramInt1 = Math.min(paramInt1, paramInt2);
    if (paramInt1 <= 320)
    {
      setScreenDensity(0.6667D);
      if (paramInt1 <= 240) {
        setScreenDensity(0.5D);
      }
    }
    for (;;)
    {
      this.y = ((this.w / this.d + 2) * (this.x / this.d + 2));
      this.z = (this.y << 1);
      this.A = this.y;
      MyLocationOverlay.a = this.G;
      try
      {
        InputStream localInputStream = c.class.getResourceAsStream("/res/wmk" + this.d + ".png");
        this.O = BitmapFactory.decodeStream(localInputStream);
        localInputStream.close();
        initLogo();
        return;
        setScreenDensity(1.0D);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public boolean isSatellite()
  {
    return false;
  }
  
  public boolean isStreetView()
  {
    return false;
  }
  
  public boolean isTraffic()
  {
    return this.N;
  }
  
  protected void onDetachedFromWindow() {}
  
  protected final void onDraw(Canvas paramCanvas)
  {
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = true;
    boolean bool3 = true;
    if (this.M) {
      return;
    }
    if (this.n.isDirty()) {
      drawView(paramCanvas);
    }
    long l1 = getDrawingTime();
    if ((this.s != null) && (this.s.isMultiTouch())) {
      if (this.s.shouldDrawMap(l1))
      {
        if (!drawMap(paramCanvas, true))
        {
          bool1 = bool3;
          bool1 |= false;
        }
      }
      else {
        bool1 |= this.s.onDraw(paramCanvas, this, l1);
      }
    }
    do
    {
      if (bool1)
      {
        requestLayout();
        invalidate();
      }
      drawLogo(paramCanvas);
      return;
      bool1 = false;
      break;
      bool1 = bool5;
    } while (this.l == null);
    bool1 = bool4;
    if (this.l.shouldDrawMap(l1)) {
      if (drawMap(paramCanvas, true)) {
        break label211;
      }
    }
    label211:
    for (bool1 = bool2;; bool1 = false)
    {
      bool1 |= false;
      boolean bool6 = this.l.onDraw(paramCanvas, this, l1);
      boolean bool7 = this.o.draw(paramCanvas, this, l1);
      bool1 = this.n.stepAnimation(l1) | bool6 | bool1 | bool7;
      break;
    }
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (this.M) {
      return;
    }
    if (!paramBoolean) {
      this.n.stopPanning();
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.M) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.o.onKeyDown(paramInt, paramKeyEvent, this));
      bool1 = bool2;
    } while (this.n.onKey(this, paramInt, paramKeyEvent));
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.M) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.o.onKeyUp(paramInt, paramKeyEvent, this));
      bool1 = bool2;
    } while (this.n.onKey(this, paramInt, paramKeyEvent));
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.M) {}
    int i1;
    Point localPoint;
    do
    {
      return;
      updateZoomControls();
      i1 = getChildCount();
      localPoint = new Point();
      paramInt3 = 0;
    } while (paramInt3 >= i1);
    View localView = getChildAt(paramInt3);
    LayoutParams localLayoutParams;
    label120:
    int i2;
    int i3;
    if (localView.getVisibility() != 8)
    {
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.mode != 0) {
        break label278;
      }
      this.m.toPixels(localLayoutParams.point, localPoint);
      localPoint.x += localLayoutParams.x;
      localPoint.y += localLayoutParams.y;
      i2 = localView.getMeasuredWidth();
      i3 = localView.getMeasuredHeight();
      paramInt4 = localPoint.x;
      paramInt1 = localPoint.y;
      int i4 = localLayoutParams.alignment;
      paramInt2 = paramInt4;
      switch (i4 & 0x7)
      {
      default: 
        paramInt2 = paramInt4;
      case 2: 
      case 3: 
      case 4: 
        label199:
        switch (i4 & 0x70)
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramInt2 = getPaddingLeft() + paramInt2;
      paramInt1 += getPaddingTop();
      localView.layout(paramInt2, paramInt1, paramInt2 + i2, paramInt1 + i3);
      paramInt3 += 1;
      break;
      label278:
      localPoint.x = localLayoutParams.x;
      localPoint.y = localLayoutParams.y;
      break label120;
      paramInt2 = paramInt4 - i2 / 2;
      break label199;
      paramInt2 = paramInt4 - (i2 - 1);
      break label199;
      continue;
      paramInt1 -= i3 / 2;
      continue;
      paramInt1 -= i3 - 1;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.M) {
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    measureChildren(paramInt1, paramInt2);
    this.w = getMeasuredWidth();
    this.x = getMeasuredHeight();
    int i3 = this.w;
    int i4 = this.x;
    int i2;
    if (i3 != 0)
    {
      i2 = i3;
      if (i4 != 0) {}
    }
    else
    {
      Display localDisplay = ((WindowManager)this.j.getSystemService("window")).getDefaultDisplay();
      i1 = i3;
      if (i3 == 0) {
        i1 = localDisplay.getWidth();
      }
      i2 = i1;
      if (i4 == 0)
      {
        i3 = localDisplay.getHeight();
        i2 = i1;
      }
    }
    for (int i1 = i3;; i1 = i4)
    {
      setMeasuredDimension(resolveSize(i2, paramInt1), resolveSize(i1, paramInt2));
      this.n.onMeasure();
      return;
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle) {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.M) {
      return;
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    initMapView(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.M) {}
    for (;;)
    {
      return false;
      try
      {
        Thread.sleep(20L);
        if ((isEnabled()) && (isClickable())) {
          if (this.o.onTouchEvent(paramMotionEvent, this)) {
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        if (this.s != null)
        {
          this.s.onMultiTouch(paramMotionEvent);
          if (!this.Q)
          {
            this.Q = this.s.isMultiTouch();
            if (this.Q) {
              return true;
            }
          }
        }
        if (this.Q)
        {
          if (paramMotionEvent.getAction() == 1) {
            this.Q = false;
          }
          return true;
        }
        postInvalidate();
        this.p.onTouchEvent(paramMotionEvent);
      }
    }
    return true;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if (this.M) {}
    do
    {
      return false;
      if (this.o.onTrackballEvent(paramMotionEvent, this)) {
        return true;
      }
      this.q.analyze(paramMotionEvent);
      if (this.q.isScroll())
      {
        this.n.scrollByTrackball((int)(paramMotionEvent.getX() * 30.0F), (int)(paramMotionEvent.getY() * 30.0F));
        return false;
      }
    } while (!this.q.isTap());
    this.o.onTap(new GeoPoint(this.g), this);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (this.M) {
      return;
    }
    if (!paramBoolean) {
      this.n.stopPanning();
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void openLocalData(String paramString)
  {
    E.a("MapView", "mLocalDatas=" + this.J);
    this.H = true;
    if (this.J == null)
    {
      this.I = paramString;
      loadLocalData();
      return;
    }
    if (!paramString.equals(this.I))
    {
      this.I = paramString;
      this.J.a();
      this.J = null;
      loadLocalData();
      return;
    }
    invalidate();
  }
  
  GeoPoint pointToGeoPoint(Point paramPoint)
  {
    return new GeoPoint(TFiU(paramPoint.x, paramPoint.y) * 10, SWN4x(paramPoint.x, paramPoint.y) * 10);
  }
  
  public void preLoad() {}
  
  public void preLoad(Point paramPoint) {}
  
  public void reloadLocalData()
  {
    if (this.J != null)
    {
      this.J.a();
      this.J = null;
    }
    loadLocalData();
  }
  
  public void removeAllBitmap()
  {
    if (this.h != null) {
      this.h.e();
    }
    if (this.i != null) {
      this.i.e();
    }
    if (this.l != null) {
      this.l.destory();
    }
    if (this.s != null) {
      this.s.destory();
    }
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      addView(this.r);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    removeView(this.r);
    return;
  }
  
  void setCenterPoint(Point paramPoint)
  {
    this.g = new MapPoint(paramPoint.y / 10, paramPoint.x / 10);
    logMvCount();
    logMapCenterRange();
  }
  
  void setMapCenter(GeoPoint paramGeoPoint)
  {
    this.g.setLatitude(paramGeoPoint.getLatitudeE6() / 10);
    this.g.setLongitude(paramGeoPoint.getLongitudeE6() / 10);
    postInvalidate();
  }
  
  public void setOnZoomChangeListener(OnZoomChangeListener paramOnZoomChangeListener)
  {
    if (this.l != null) {
      this.l.setOnZoomChangeListener(paramOnZoomChangeListener);
    }
    if (this.s != null) {
      this.s.setOnZoomChangeListener(paramOnZoomChangeListener);
    }
  }
  
  public void setReticleDrawMode(ReticleDrawMode paramReticleDrawMode) {}
  
  public void setSatellite(boolean paramBoolean) {}
  
  void setScreenDensity(double paramDouble)
  {
    this.G = paramDouble;
    if (paramDouble < 1.0D) {}
    for (this.d = 150;; this.d = 300)
    {
      this.e = this.d;
      return;
    }
  }
  
  public void setStreetView(boolean paramBoolean) {}
  
  public void setTraffic(boolean paramBoolean)
  {
    this.N = paramBoolean;
    this.P.sendEmptyMessage(1);
    postInvalidate();
  }
  
  void setZoom(com.mapbar.map.c paramc)
  {
    zoomTo(paramc);
  }
  
  void setup()
  {
    this.o = new OverlayBundle();
    this.n = new MapController(this);
    this.m = new PixelConverter(this);
    this.l = new ZoomHelper(this, null);
    this.s = new MultiTouchHelper(this, this.n);
    this.p = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        MapView.this.logMvCount();
        if (MapView.this.l != null) {
          MapView.this.l.doZoomForDoubleTap((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY());
        }
        return super.onDoubleTap(paramAnonymousMotionEvent);
      }
      
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        if (!MapView.this.mScroller.isFinished()) {
          MapView.this.mScroller.abortAnimation();
        }
        return false;
      }
      
      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        MapView.this.mScroller.abortAnimation();
        MapView.access$1202(MapView.this, 400);
        MapView.access$1302(MapView.this, 400);
        MapView.this.mScroller.fling(MapView.this.t, MapView.this.t, (int)-paramAnonymousFloat1 / 2, (int)-paramAnonymousFloat2 / 2, 0, 800, 0, 800);
        MapView.this.postInvalidate();
        return false;
      }
      
      public void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        MapView.this.logMvCount();
        super.onLongPress(paramAnonymousMotionEvent);
      }
      
      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        paramAnonymousMotionEvent1 = new MapView.InternalProjection(MapView.this, null).pointToGeoPoint(new Point(MapView.this.b / 2 + (int)paramAnonymousFloat1, MapView.this.c / 2 + (int)paramAnonymousFloat2));
        MapView.this.setMapCenter(paramAnonymousMotionEvent1);
        MapView.this.logMvCount();
        MapView.this.logMapCenterRange();
        return true;
      }
      
      public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        MapView.this.logMvCount();
        paramAnonymousMotionEvent = MapView.this.m.fromPixels((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY());
        return MapView.this.o.onTap(paramAnonymousMotionEvent, MapView.this);
      }
    });
    this.p.setIsLongpressEnabled(false);
    this.k = new Handler();
    this.q = new TrackballGestureDetector(this.k);
    this.mScroller = new Scroller(getContext());
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.mode = 1;
    this.r.setLayoutParams(localLayoutParams);
    this.r.setOnZoomOutClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MapView.this.doZoom(false, MapView.this.w / 2, MapView.this.x / 2);
      }
    });
    this.r.setOnZoomInClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MapView.this.doZoom(true, MapView.this.w / 2, MapView.this.x / 2);
      }
    });
    this.r.setVisibility(0);
    this.r.measure(0, 0);
  }
  
  Point toCenterPoint(float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = toMapCoordinate2(this.b / 2 + (int)paramFloat1, this.c / 2 + (int)paramFloat2);
    return new Point(arrayOfInt[0], arrayOfInt[1]);
  }
  
  int[] toImageCoordinate2(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    arrayOfInt[0] = O5976(paramInt1 / 10, paramInt2 / 10);
    arrayOfInt[1] = kjG2C(paramInt1 / 10, paramInt2 / 10);
    return arrayOfInt;
  }
  
  int[] toMapCoordinate2(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    arrayOfInt[0] = (SWN4x(paramInt1, paramInt2) * 10);
    arrayOfInt[1] = (TFiU(paramInt1, paramInt2) * 10);
    return arrayOfInt;
  }
  
  void zoomTo(com.mapbar.map.c paramc)
  {
    if (paramc == null) {
      return;
    }
    this.v = paramc.a();
  }
  
  void zoomToSpan(int paramInt1, int paramInt2) {}
  
  private class InternalProjection
    implements Projection
  {
    private InternalProjection() {}
    
    public GeoPoint fromPixels(int paramInt1, int paramInt2)
    {
      Point localPoint = geoPointToPoint(new GeoPoint(MapView.this.g));
      localPoint.x = (localPoint.x - MapView.this.getWidth() / 2 + paramInt1);
      localPoint.y = (localPoint.y - MapView.this.getHeight() / 2 + paramInt2);
      return pointToGeoPoint(localPoint);
    }
    
    public double geoPointToMeters(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
    {
      double d1 = paramGeoPoint1.getLatitudeE6() / 1000000.0D;
      double d2 = paramGeoPoint2.getLatitudeE6() / 1000000.0D;
      double d3 = paramGeoPoint1.getLongitudeE6() / 1000000.0D;
      double d4 = paramGeoPoint2.getLongitudeE6() / 1000000.0D;
      double d5 = Math.abs(d1 - d2);
      return Math.sqrt(Math.abs(d1 - d2) * d5 + Math.abs(d3 - d4) * Math.abs(d3 - d4)) * 100000.0D;
    }
    
    public Point geoPointToPoint(GeoPoint paramGeoPoint)
    {
      Point localPoint = new Point();
      localPoint.x = MapView.this.O5976(paramGeoPoint.getLongitudeE6() / 10, paramGeoPoint.getLatitudeE6() / 10);
      localPoint.y = MapView.this.kjG2C(paramGeoPoint.getLongitudeE6() / 10, paramGeoPoint.getLatitudeE6() / 10);
      return localPoint;
    }
    
    public float metersToEquatorPixels(float paramFloat)
    {
      return new Double(1.0D / geoPointToMeters(pointToGeoPoint(new Point(0, 0)), pointToGeoPoint(new Point(1, 0)))).floatValue() * paramFloat;
    }
    
    public GeoPoint pointToGeoPoint(Point paramPoint)
    {
      return new GeoPoint(MapView.this.TFiU(paramPoint.x, paramPoint.y) * 10, MapView.this.SWN4x(paramPoint.x, paramPoint.y) * 10);
    }
    
    public Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
    {
      Point localPoint = paramPoint;
      if (paramPoint == null) {
        localPoint = new Point();
      }
      paramGeoPoint = geoPointToPoint(paramGeoPoint);
      paramPoint = geoPointToPoint(new GeoPoint(MapView.this.g));
      localPoint.set(paramGeoPoint.x - paramPoint.x + MapView.this.getWidth() / 2, paramGeoPoint.y - paramPoint.y + MapView.this.getHeight() / 2);
      return localPoint;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public static final int BOTTOM = 80;
    public static final int BOTTOM_CENTER = 81;
    public static final int CENTER = 17;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_VERTICAL = 16;
    public static final int LEFT = 3;
    public static final int MODE_MAP = 0;
    public static final int MODE_VIEW = 1;
    public static final int RIGHT = 5;
    public static final int TOP = 48;
    public static final int TOP_LEFT = 51;
    public int alignment;
    public int mode;
    public GeoPoint point;
    public int x;
    public int y;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt2);
      this.mode = 1;
      this.x = paramInt3;
      this.y = paramInt4;
      this.alignment = paramInt5;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3)
    {
      this(paramInt1, paramInt2, paramGeoPoint, 0, 0, paramInt3);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt2);
      this.mode = 0;
      this.point = paramGeoPoint;
      this.x = paramInt3;
      this.y = paramInt4;
      this.alignment = paramInt5;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.mode = 1;
      this.alignment = 51;
    }
  }
  
  class Repainter
  {
    private Thread b;
    
    Repainter() {}
    
    public void repaint()
    {
      if ((this.b == null) || (!this.b.isAlive()))
      {
        this.b = new Thread()
        {
          public void run()
          {
            try
            {
              sleep(500L);
              MapView.this.postInvalidate();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;) {}
            }
          }
        };
        this.b.start();
      }
    }
  }
  
  public static enum ReticleDrawMode
  {
    private ReticleDrawMode() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */