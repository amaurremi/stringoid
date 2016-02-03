package com.mapbar.android.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.mapbar.map.MapPoint;
import com.mapbar.map.b;
import java.io.File;
import java.io.InputStream;

public class SnapTool
{
  private static final Paint A;
  private static final Paint B;
  private View a;
  private Context b;
  private MapPoint c;
  private int d;
  private boolean e;
  private boolean f = false;
  private int g;
  private int h;
  private int i;
  private int j;
  private double k = 1.0D;
  private o l;
  private n m;
  private int n = 12;
  private int o = this.n;
  private int p = this.n;
  private boolean q = false;
  private q r = null;
  private int s = 300;
  private int t = this.s;
  private Bitmap u = null;
  private Handler v = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      SnapTool.this.v.removeMessages(1);
      if (SnapTool.this.e) {
        SnapTool.this.v.sendEmptyMessageDelayed(1, 300000L);
      }
      try
      {
        SnapTool.this.getTrafficCache().a();
        return;
      }
      catch (Exception paramAnonymousMessage) {}
    }
  };
  private final Point w = new Point();
  private final float[] x = new float[2];
  private final Matrix y = new Matrix();
  private Drawable z = null;
  
  static
  {
    Paint localPaint = new Paint();
    A = localPaint;
    localPaint.setARGB(35, 131, 182, 222);
    A.setStyle(Paint.Style.FILL);
    localPaint = new Paint();
    B = localPaint;
    localPaint.setARGB(225, 131, 182, 222);
    B.setStrokeWidth(1.5F);
    B.setStyle(Paint.Style.STROKE);
    B.setAntiAlias(true);
  }
  
  public SnapTool(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, null, paramInt1, paramInt2);
  }
  
  public SnapTool(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.a = paramView;
    int i2;
    int i3;
    if (paramInt1 > 0)
    {
      i2 = paramInt1;
      i3 = paramInt2;
      if (paramInt2 > 0) {}
    }
    else
    {
      paramContext = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay();
      int i1 = paramInt1;
      if (paramInt1 <= 0) {
        i1 = paramContext.getWidth();
      }
      i2 = i1;
      i3 = paramInt2;
      if (paramInt2 <= 0)
      {
        i3 = paramContext.getHeight();
        i2 = i1;
      }
    }
    initMapView(i2, i3);
  }
  
  private int O5976(int paramInt1, int paramInt2)
  {
    paramInt2 = (paramInt1 - this.c.getLongitude()) % 36000000;
    paramInt1 = paramInt2;
    if (paramInt2 > 18000000) {
      paramInt1 = paramInt2 - 36000000;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < -18000000) {
      paramInt2 = paramInt1 + 36000000;
    }
    paramInt1 = this.g / 2;
    return paramInt2 * this.s / D.a(this.d) + paramInt1;
  }
  
  private int SWN4x(int paramInt1, int paramInt2)
  {
    paramInt2 = this.g / 2;
    int i1 = this.c.getLongitude();
    return (paramInt1 - paramInt2) * D.a(this.d) / this.s + i1;
  }
  
  private int TFiU(int paramInt1, int paramInt2)
  {
    paramInt1 = this.h / 2;
    return this.c.getLatitude() - (paramInt2 - paramInt1) * D.b(this.d) / this.t;
  }
  
  private static int ceil(int paramInt1, int paramInt2)
  {
    if (paramInt1 % paramInt2 != 0) {
      return paramInt1 / paramInt2 + 1;
    }
    return paramInt1 / paramInt2;
  }
  
  protected static void drawAt(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 > 16000) || (paramInt2 > 16000) || (paramInt1 < 49536) || (paramInt2 < 49536)) {
      return;
    }
    if (paramBoolean) {
      paramDrawable.setColorFilter(2130706432, PorterDuff.Mode.SRC_IN);
    }
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    if (paramBoolean)
    {
      paramCanvas.skew(-0.9F, 0.0F);
      paramCanvas.scale(1.0F, 0.5F);
    }
    paramDrawable.draw(paramCanvas);
    if (paramBoolean) {
      paramDrawable.clearColorFilter();
    }
    paramCanvas.restore();
  }
  
  private void drawMap(Canvas paramCanvas, boolean paramBoolean)
  {
    int i1 = this.c.getLongitude();
    int i2 = this.c.getLatitude();
    int i5 = D.a(this.d);
    int i6 = D.b(this.d);
    i1 = this.g / 2 - i1 % i5 * this.s / i5;
    int i3 = this.h / 2;
    int i4 = this.t;
    i2 = i2 % i6 * this.t / i6 + (i3 - i4) + D.c(this.d);
    int i10 = -ceil(i1 * 1000 / this.s, 1000);
    int i7 = ceil((this.g - i1 - this.s) * 1000 / this.s, 1000);
    int i8 = -ceil(i2 * 1000 / this.t, 1000);
    int i9 = ceil((this.h - i2 - this.t) * 1000 / this.t, 1000);
    this.i = (i1 + this.s * i10);
    this.j = (this.t * i8 + i2);
    i2 = -i10;
    i1 = 0;
    while (i1 >= i10)
    {
      i4 = -i8;
      i3 = 0;
      while (i3 >= i8)
      {
        setMapTile(paramCanvas, i1, i3, i5, i6, i2, i4, paramBoolean);
        i4 -= 1;
        i3 -= 1;
      }
      i4 = -i8 + 1;
      i3 = 1;
      while (i3 <= i9)
      {
        setMapTile(paramCanvas, i1, i3, i5, i6, i2, i4, paramBoolean);
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
        setMapTile(paramCanvas, i1, i3, i5, i6, i2, i4, paramBoolean);
        i4 -= 1;
        i3 -= 1;
      }
      i4 = -i8 + 1;
      i3 = 1;
      while (i3 <= i9)
      {
        setMapTile(paramCanvas, i1, i3, i5, i6, i2, i4, paramBoolean);
        i4 += 1;
        i3 += 1;
      }
      i2 += 1;
      i1 += 1;
    }
  }
  
  private void drawMyLocation(Canvas paramCanvas, GeoPoint paramGeoPoint, float paramFloat)
  {
    toPixels(paramGeoPoint, this.w);
    int i1 = this.w.x;
    int i2 = this.w.y;
    drawDot(paramCanvas, i1, i2);
    if (paramFloat > 0.0F) {}
    for (paramFloat = metersToEquatorPixels((int)paramFloat);; paramFloat = 0.0F)
    {
      if (paramFloat > 0.0F)
      {
        paramCanvas.drawCircle(i1, i2, paramFloat, A);
        paramCanvas.drawCircle(i1, i2, paramFloat, B);
      }
      if (this.a != null) {
        this.a.postInvalidate();
      }
      return;
    }
  }
  
  private Drawable getDot()
  {
    if (this.z == null)
    {
      this.z = getResDrawable("/res/mylocality.png");
      int i1 = (int)(this.k * 20.0D);
      int i2 = (int)(this.k * 20.0D);
      this.z.setBounds(-i1, -i2, i1, i2);
    }
    return this.z;
  }
  
  private o getMapCache()
  {
    if (this.l == null) {}
    for (;;)
    {
      try
      {
        localFile = new File(this.b.getCacheDir(), "map");
        if (!localFile.exists()) {
          continue;
        }
        if (!localFile.isDirectory())
        {
          localFile.delete();
          localFile.mkdirs();
        }
        this.l = new o(localFile, new d.b()
        {
          public boolean eject(File paramAnonymousFile)
          {
            return System.currentTimeMillis() - paramAnonymousFile.lastModified() > 604800000L;
          }
        }, this.o);
      }
      catch (Exception localException)
      {
        File localFile;
        localException.printStackTrace();
        continue;
      }
      return this.l;
      localFile.mkdirs();
    }
  }
  
  private void getPointXY(Point paramPoint1, Point paramPoint2)
  {
    paramPoint1 = toImageCoordinate2(paramPoint1.x, paramPoint1.y);
    paramPoint2.x = paramPoint1[0];
    paramPoint2.y = paramPoint1[1];
  }
  
  /* Error */
  private Drawable getResDrawable(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 355	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: aload_1
    //   5: invokevirtual 361	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: new 363	android/graphics/drawable/BitmapDrawable
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 366	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   19: astore_3
    //   20: aload_2
    //   21: ifnull +7 -> 28
    //   24: aload_2
    //   25: invokevirtual 371	java/io/InputStream:close	()V
    //   28: aload_3
    //   29: areturn
    //   30: astore_3
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: invokevirtual 345	java/lang/Exception:printStackTrace	()V
    //   39: aload_2
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: invokevirtual 371	java/io/InputStream:close	()V
    //   47: aconst_null
    //   48: areturn
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 371	java/io/InputStream:close	()V
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
    //   0	81	0	this	SnapTool
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
    if (this.m == null) {}
    for (;;)
    {
      try
      {
        localFile = new File(this.b.getCacheDir(), "traffic");
        if (!localFile.exists()) {
          continue;
        }
        if (!localFile.isDirectory())
        {
          localFile.delete();
          localFile.mkdirs();
        }
        this.m = new n(localFile, new d.b()
        {
          public boolean eject(File paramAnonymousFile)
          {
            return System.currentTimeMillis() - paramAnonymousFile.lastModified() > 300000L;
          }
        }, this.p);
      }
      catch (Exception localException)
      {
        File localFile;
        continue;
      }
      return this.m;
      localFile.mkdirs();
    }
  }
  
  private void initMapView(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    int i1 = Math.min(paramInt1, paramInt2);
    if (i1 <= 320)
    {
      setScreenDensity(0.6667D);
      if (i1 <= 240) {
        setScreenDensity(0.5D);
      }
    }
    this.n = ((paramInt1 / this.s + 2) * (paramInt2 / this.s + 2));
    this.o = (this.n << 1);
    this.p = this.n;
    MyLocationOverlay.a = this.k;
    try
    {
      InputStream localInputStream = c.class.getResourceAsStream("/res/wmk" + this.s + ".png");
      this.u = BitmapFactory.decodeStream(localInputStream);
      localInputStream.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int kjG2C(int paramInt1, int paramInt2)
  {
    return this.h / 2 - (paramInt2 - this.c.getLatitude()) % 36000000 * this.t / D.b(this.d);
  }
  
  private GeoPoint pointToGeoPoint(Point paramPoint)
  {
    return new GeoPoint(TFiU(paramPoint.x, paramPoint.y) * 10, SWN4x(paramPoint.x, paramPoint.y) * 10);
  }
  
  private void setMapTile(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    paramInt1 = this.c.getLongitude() + paramInt1 * paramInt3;
    paramInt2 = this.c.getLatitude() - paramInt2 * paramInt4;
    String str = b.a(paramInt1, paramInt2, this.d);
    paramInt3 = this.s * paramInt5 + this.i;
    paramInt4 = this.s * paramInt6 + this.j;
    if (paramBoolean) {}
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(D.k).append(this.s).append("/").append(str).append(".png");
      getTrafficCache().a(this.a, paramCanvas, this.n, paramInt3, paramInt4, false, localStringBuilder.toString(), this.u);
      return;
    }
    catch (Exception paramCanvas) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(D.h).append(this.s).append("/").append(str).append(".png");
    getMapCache().a(this.a, paramCanvas, this.n, paramInt3, paramInt4, true, localStringBuilder.toString(), paramInt1, paramInt2, this.d, false, null, this.u);
    return;
  }
  
  private void setScreenDensity(double paramDouble)
  {
    this.k = paramDouble;
    if (paramDouble < 1.0D) {}
    for (this.s = 150;; this.s = 300)
    {
      this.t = this.s;
      return;
    }
  }
  
  private int[] toImageCoordinate2(int paramInt1, int paramInt2)
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
  
  private Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    return toPixels(paramGeoPoint, paramPoint, true);
  }
  
  private Point toPixels(GeoPoint paramGeoPoint, Point arg2, boolean paramBoolean)
  {
    if (paramGeoPoint == null) {
      return null;
    }
    Point localPoint = ???;
    if (??? == null) {
      localPoint = new Point();
    }
    synchronized (this.w)
    {
      getPointXY(paramGeoPoint.getPoint(), this.w);
      if (paramBoolean) {
        transformTempPoint();
      }
      localPoint.x = this.w.x;
      localPoint.y = this.w.y;
      return localPoint;
    }
  }
  
  private void transformTempPoint()
  {
    this.x[0] = this.w.x;
    this.x[1] = this.w.y;
    this.y.mapPoints(this.x);
    this.w.x = ((int)this.x[0]);
    this.w.y = ((int)this.x[1]);
  }
  
  public void destory()
  {
    this.f = true;
    this.e = false;
    if (this.v != null)
    {
      this.v.removeMessages(1);
      this.v = null;
    }
    if (this.l != null)
    {
      this.l.f();
      this.l = null;
    }
    if (this.m != null)
    {
      this.m.f();
      this.m = null;
    }
    if (this.u != null) {}
    try
    {
      this.u.recycle();
      this.u = null;
      this.b = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void drawDot(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    drawAt(paramCanvas, getDot(), 0, 0, false);
    paramCanvas.restore();
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
  
  public View getView()
  {
    return this.a;
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    return new Double(1.0D / geoPointToMeters(pointToGeoPoint(new Point(0, 0)), pointToGeoPoint(new Point(1, 0)))).floatValue() * paramFloat;
  }
  
  public void setTraffic(boolean paramBoolean)
  {
    if (this.f) {
      return;
    }
    this.e = paramBoolean;
    this.v.sendEmptyMessage(1);
  }
  
  public Bitmap snapLocation(Location paramLocation, GeoPoint paramGeoPoint, int paramInt)
  {
    if ((this.f) || (this.b == null) || (paramLocation == null)) {
      return null;
    }
    this.c = new MapPoint(paramGeoPoint.getLatitudeE6() / 10, paramGeoPoint.getLongitudeE6() / 10);
    this.d = paramInt;
    paramGeoPoint = Bitmap.createBitmap(this.g, this.h, Bitmap.Config.ARGB_4444);
    drawMyLocation(new Canvas(paramGeoPoint), new GeoPoint(paramLocation.getLatitude(), paramLocation.getLongitude()), paramLocation.getAccuracy());
    if (this.a != null)
    {
      if (!(this.a instanceof ImageView)) {
        break label139;
      }
      ((ImageView)this.a).setScaleType(ImageView.ScaleType.CENTER);
      ((ImageView)this.a).setImageBitmap(paramGeoPoint);
    }
    for (;;)
    {
      return paramGeoPoint;
      label139:
      paramLocation = new BitmapDrawable(paramGeoPoint);
      paramLocation.setTileModeXY(Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.a.setBackgroundDrawable(paramLocation);
    }
  }
  
  public Bitmap snapMap(GeoPoint paramGeoPoint, int paramInt)
  {
    if ((this.f) || (this.b == null)) {
      return null;
    }
    this.c = new MapPoint(paramGeoPoint.getLatitudeE6() / 10, paramGeoPoint.getLongitudeE6() / 10);
    this.d = paramInt;
    paramGeoPoint = Bitmap.createBitmap(this.g, this.h, Bitmap.Config.RGB_565);
    Object localObject = new Canvas(paramGeoPoint);
    drawMap((Canvas)localObject, false);
    if ((this.e) && (this.d <= 13) && (this.d >= 8)) {
      drawMap((Canvas)localObject, true);
    }
    if (this.a != null)
    {
      if (!(this.a instanceof ImageView)) {
        break label150;
      }
      ((ImageView)this.a).setScaleType(ImageView.ScaleType.CENTER);
      ((ImageView)this.a).setImageBitmap(paramGeoPoint);
    }
    for (;;)
    {
      return paramGeoPoint;
      label150:
      localObject = new BitmapDrawable(paramGeoPoint);
      ((BitmapDrawable)localObject).setTileModeXY(Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.a.setBackgroundDrawable((Drawable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/SnapTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */