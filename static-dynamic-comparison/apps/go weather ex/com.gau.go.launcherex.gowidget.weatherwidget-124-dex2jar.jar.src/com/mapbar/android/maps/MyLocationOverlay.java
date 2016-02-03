package com.mapbar.android.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyLocationOverlay
  extends Overlay
  implements SensorEventListener, LocationListener, Overlay.Snappable
{
  static double a;
  private static final String[] c = { "gps" };
  private static final Paint d;
  private static final Paint e;
  private static Drawable u;
  private static Drawable v;
  private static LevelListDrawable w;
  private static int x;
  private static int y;
  private Sensor A;
  private long B;
  private Runnable C = new Runnable()
  {
    public void run()
    {
      MyLocationOverlay.this.z.userActivity(SystemClock.uptimeMillis(), true);
    }
  };
  private Handler D = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (MyLocationOverlay.this.b != null) {
        MyLocationOverlay.this.onLocationChanged(MyLocationOverlay.this.b);
      }
    }
  };
  Location b = null;
  private final Context f;
  private final MapView g;
  private volatile boolean h = false;
  private volatile float i = NaN.0F;
  private volatile boolean j = false;
  private volatile boolean k = false;
  private volatile Location l = null;
  private volatile GeoPoint m = null;
  private volatile long n;
  private volatile boolean o = false;
  private volatile boolean p = true;
  private final ArrayList<NameAndDate> q = new ArrayList(2);
  private final Point r = new Point();
  private final Rect s = new Rect();
  private final Queue<Runnable> t = new LinkedList();
  private PowerManager z;
  
  static
  {
    a = 1.0D;
    u = null;
    v = null;
    Paint localPaint = new Paint();
    d = localPaint;
    localPaint.setARGB(35, 131, 182, 222);
    d.setStyle(Paint.Style.FILL);
    localPaint = new Paint();
    e = localPaint;
    localPaint.setARGB(225, 131, 182, 222);
    e.setStrokeWidth(1.5F);
    e.setStyle(Paint.Style.STROKE);
    e.setAntiAlias(true);
  }
  
  public MyLocationOverlay(Context paramContext, MapView paramMapView)
  {
    if (paramMapView == null) {
      throw new IllegalArgumentException("mapView == null");
    }
    this.f = paramContext;
    this.g = paramMapView;
    this.z = ((PowerManager)paramContext.getSystemService("power"));
    a = paramMapView.getScreenDensity();
  }
  
  private void clearNetworkLocationRebroadcasts()
  {
    this.b = null;
    this.D.removeMessages(1);
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i1, i2, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      return (Bitmap)localObject;
    }
  }
  
  private Drawable getCompassArrow()
  {
    if (u == null)
    {
      u = getResDrawable("/res/compass_arrow.png");
      int i1 = (int)(a * 20.0D);
      int i2 = (int)(a * 20.0D);
      u.setBounds(-i1, -i2, i1, i2);
    }
    return u;
  }
  
  private Drawable getDot()
  {
    if (v == null)
    {
      v = getResDrawable("/res/mylocality.png");
      int i1 = (int)(a * 20.0D);
      int i2 = (int)(a * 20.0D);
      v.setBounds(-i1, -i2, i1, i2);
    }
    return v;
  }
  
  private LevelListDrawable getLocationDot()
  {
    if (w == null)
    {
      w = new LevelListDrawable();
      Drawable localDrawable = getResDrawable("/res/mylocality1.png");
      w.addLevel(0, 2500, localDrawable);
      localDrawable = getResDrawable("/res/mylocality2.png");
      w.addLevel(2500, 5000, localDrawable);
      localDrawable = getResDrawable("/res/mylocality3.png");
      w.addLevel(5000, 7500, localDrawable);
      localDrawable = getResDrawable("/res/mylocality4.png");
      w.addLevel(7500, 10000, localDrawable);
      x = (int)(a * 22.0D);
      y = (int)(a * 22.0D);
      w.setBounds(-x, -y, x, y);
    }
    return w;
  }
  
  /* Error */
  private Drawable getResDrawable(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 295	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: aload_1
    //   5: invokevirtual 301	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: new 303	android/graphics/drawable/BitmapDrawable
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 306	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   19: astore_3
    //   20: aload_2
    //   21: ifnull +7 -> 28
    //   24: aload_2
    //   25: invokevirtual 311	java/io/InputStream:close	()V
    //   28: aload_3
    //   29: areturn
    //   30: astore_3
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   39: aload_2
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: invokevirtual 311	java/io/InputStream:close	()V
    //   47: aconst_null
    //   48: areturn
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 311	java/io/InputStream:close	()V
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
    //   0	81	0	this	MyLocationOverlay
    //   0	81	1	paramString	String
    //   8	36	2	localInputStream	java.io.InputStream
    //   49	12	2	localObject1	Object
    //   73	1	2	localObject2	Object
    //   19	10	3	localBitmapDrawable	android.graphics.drawable.BitmapDrawable
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
  
  private boolean isCloseToPoint(int paramInt1, int paramInt2, MapView paramMapView)
  {
    if (this.m == null) {}
    long l1;
    long l2;
    do
    {
      return false;
      paramMapView.getProjection().toPixels(this.m, this.r);
      l1 = Math.abs(paramInt1 - this.r.x);
      l2 = Math.abs(paramInt2 - this.r.y);
    } while ((float)(l1 * l1 + l2 * l2) >= 1024.0F);
    return true;
  }
  
  private boolean isLocationOnScreen(MapView paramMapView, GeoPoint paramGeoPoint)
  {
    Point localPoint = new Point();
    paramMapView.getProjection().toPixels(paramGeoPoint, localPoint);
    paramGeoPoint = new Rect();
    paramGeoPoint.set(0, 0, paramMapView.getWidth(), paramMapView.getHeight());
    return paramGeoPoint.contains(localPoint.x, localPoint.y);
  }
  
  private float isect(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 0.0F;
    paramFloat2 = paramFloat2 * paramFloat2 - paramFloat1 * paramFloat1 + 2.0F * paramFloat1 * paramFloat3 - paramFloat3 * paramFloat3;
    paramFloat1 = f1;
    if (paramFloat2 > 0.0F) {
      paramFloat1 = (float)Math.sqrt(paramFloat2);
    }
    return paramFloat1;
  }
  
  public void disableCompass()
  {
    try
    {
      if (this.h)
      {
        SensorManager localSensorManager = (SensorManager)this.f.getSystemService("sensor");
        if ((localSensorManager != null) && (this.A != null))
        {
          localSensorManager.unregisterListener(this, this.A);
          this.A = null;
        }
        this.g.postInvalidate();
        this.h = false;
      }
      return;
    }
    finally {}
  }
  
  public void disableMyLocation()
  {
    try
    {
      ((LocationManager)this.f.getSystemService("location")).removeUpdates(this);
      this.q.clear();
      this.j = false;
      this.b = null;
      this.D.removeMessages(1);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected boolean dispatchTap()
  {
    return false;
  }
  
  public boolean draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (;;)
    {
      return false;
      try
      {
        if (this.m == null) {
          continue;
        }
        if (SystemClock.elapsedRealtime() - this.n < 60000L)
        {
          drawMyLocation(paramCanvas, paramMapView, this.l, this.m, paramLong);
          continue;
        }
      }
      finally {}
      this.m = null;
      this.g.postInvalidate();
    }
  }
  
  protected void drawCompass(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    paramCanvas.rotate(paramFloat);
    drawAt(paramCanvas, getCompassArrow(), 0, 0, false);
    paramCanvas.restore();
  }
  
  protected void drawDot(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    drawAt(paramCanvas, getDot(), 0, 0, false);
    paramCanvas.restore();
  }
  
  protected void drawMyLocation(Canvas paramCanvas, MapView paramMapView, Location paramLocation, GeoPoint paramGeoPoint, long paramLong)
  {
    if (!this.j) {
      return;
    }
    Projection localProjection = paramMapView.getProjection();
    localProjection.toPixels(paramGeoPoint, this.r);
    int i1 = this.r.x;
    int i2 = this.r.y;
    Rect localRect;
    if (((this.h) || (this.k)) && (!Float.isNaN(this.i)))
    {
      drawCompass(paramCanvas, i1, i2, this.i);
      paramGeoPoint = getLocationDot();
      localRect = paramGeoPoint.getBounds();
      if (!paramLocation.hasAccuracy()) {
        break label564;
      }
    }
    label564:
    for (float f1 = localProjection.metersToEquatorPixels((int)paramLocation.getAccuracy());; f1 = 0.0F)
    {
      paramGeoPoint.setLevel((int)(paramLong % 1000L) * 10000 / 1000);
      int i3 = paramMapView.getWidth();
      int i4 = paramMapView.getHeight();
      if (f1 > 0.0F)
      {
        paramCanvas.drawCircle(i1, i2, f1, d);
        paramCanvas.drawCircle(i1, i2, f1, e);
        float f2 = isect(i2, f1, 1.0F);
        if (f2 > 0.0F) {
          paramCanvas.drawLine(i1 - f2, 1.0F, i1 + f2, 1.0F, e);
        }
        f2 = isect(i2, f1, i4 - 1.0F);
        if (f2 > 0.0F) {
          paramCanvas.drawLine(i1 - f2, i4 - 1.0F, i1 + f2, i4 - 1.0F, e);
        }
        f2 = isect(i1, f1, 1.0F);
        if (f2 > 0.0F) {
          paramCanvas.drawLine(1.0F, i2 - f2, 1.0F, i2 + f2, e);
        }
        f1 = isect(i1, f1, i3 - 1.0F);
        if (f1 > 0.0F) {
          paramCanvas.drawLine(i3 - 1.0F, i2 - f1, i3 - 1.0F, i2 + f1, e);
        }
      }
      drawAt(paramCanvas, paramGeoPoint, i1, i2, false);
      this.s.set(0, 0, i3, i4);
      this.p = this.s.intersects(localRect.left + i1, localRect.top + i2, localRect.right + i1, localRect.bottom + i2);
      if (this.p)
      {
        this.g.post(this.C);
        i3 = x;
        i4 = y;
        if ((System.currentTimeMillis() - this.B > 500L) || (this.B == 0L))
        {
          this.B = System.currentTimeMillis();
          this.g.postInvalidateDelayed(500L, i1 - i3, i2 - i4, i3 + i1, i4 + i2);
        }
      }
      for (;;)
      {
        this.o = false;
        return;
        drawDot(paramCanvas, i1, i2);
        break;
        if (this.o) {
          this.g.postInvalidate();
        }
      }
    }
  }
  
  /* Error */
  public boolean enableCompass()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 123	com/mapbar/android/maps/MyLocationOverlay:h	Z
    //   6: ifne +60 -> 66
    //   9: aload_0
    //   10: getfield 179	com/mapbar/android/maps/MyLocationOverlay:f	Landroid/content/Context;
    //   13: ldc_w 359
    //   16: invokevirtual 189	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   19: checkcast 361	android/hardware/SensorManager
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +51 -> 75
    //   27: aload_0
    //   28: aload_2
    //   29: iconst_3
    //   30: invokevirtual 507	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   33: putfield 363	com/mapbar/android/maps/MyLocationOverlay:A	Landroid/hardware/Sensor;
    //   36: aload_0
    //   37: getfield 363	com/mapbar/android/maps/MyLocationOverlay:A	Landroid/hardware/Sensor;
    //   40: ifnull +26 -> 66
    //   43: aload_2
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 363	com/mapbar/android/maps/MyLocationOverlay:A	Landroid/hardware/Sensor;
    //   49: iconst_2
    //   50: invokevirtual 511	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   53: pop
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 123	com/mapbar/android/maps/MyLocationOverlay:h	Z
    //   59: aload_0
    //   60: getfield 181	com/mapbar/android/maps/MyLocationOverlay:g	Lcom/mapbar/android/maps/MapView;
    //   63: invokevirtual 370	com/mapbar/android/maps/MapView:postInvalidate	()V
    //   66: aload_0
    //   67: getfield 123	com/mapbar/android/maps/MyLocationOverlay:h	Z
    //   70: istore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: iload_1
    //   74: ireturn
    //   75: ldc_w 513
    //   78: ldc_w 515
    //   81: invokestatic 520	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   84: pop
    //   85: goto -19 -> 66
    //   88: astore_2
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	MyLocationOverlay
    //   70	4	1	bool	boolean
    //   22	22	2	localSensorManager	SensorManager
    //   88	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	88	finally
    //   27	66	88	finally
    //   66	71	88	finally
    //   75	85	88	finally
  }
  
  /* Error */
  public boolean enableMyLocation()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 179	com/mapbar/android/maps/MyLocationOverlay:f	Landroid/content/Context;
    //   6: ldc_w 373
    //   9: invokevirtual 189	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 375	android/location/LocationManager
    //   15: astore 4
    //   17: aload 4
    //   19: aload_0
    //   20: invokevirtual 379	android/location/LocationManager:removeUpdates	(Landroid/location/LocationListener;)V
    //   23: aload_0
    //   24: getfield 145	com/mapbar/android/maps/MyLocationOverlay:q	Ljava/util/ArrayList;
    //   27: invokevirtual 382	java/util/ArrayList:clear	()V
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 128	com/mapbar/android/maps/MyLocationOverlay:j	Z
    //   35: getstatic 77	com/mapbar/android/maps/MyLocationOverlay:c	[Ljava/lang/String;
    //   38: astore 5
    //   40: aload 5
    //   42: arraylength
    //   43: istore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: iload_1
    //   47: iload_2
    //   48: if_icmpge +182 -> 230
    //   51: aload 5
    //   53: iload_1
    //   54: aaload
    //   55: astore 6
    //   57: aload 4
    //   59: aload 6
    //   61: invokevirtual 527	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   64: ifeq +58 -> 122
    //   67: aload_0
    //   68: getfield 145	com/mapbar/android/maps/MyLocationOverlay:q	Ljava/util/ArrayList;
    //   71: new 16	com/mapbar/android/maps/MyLocationOverlay$NameAndDate
    //   74: dup
    //   75: aload 6
    //   77: invokespecial 528	com/mapbar/android/maps/MyLocationOverlay$NameAndDate:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 532	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   83: pop
    //   84: aload 4
    //   86: aload 6
    //   88: lconst_0
    //   89: fconst_0
    //   90: aload_0
    //   91: invokevirtual 536	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   94: ldc_w 513
    //   97: new 538	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 539	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 541
    //   107: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 6
    //   112: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 549	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 551	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   121: pop
    //   122: iload_1
    //   123: iconst_1
    //   124: iadd
    //   125: istore_1
    //   126: goto -80 -> 46
    //   129: astore 7
    //   131: ldc_w 513
    //   134: new 538	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 539	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 553
    //   144: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 6
    //   149: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc_w 555
    //   155: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 7
    //   160: invokevirtual 558	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 549	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 520	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   172: pop
    //   173: goto -51 -> 122
    //   176: astore 4
    //   178: aload_0
    //   179: monitorexit
    //   180: aload 4
    //   182: athrow
    //   183: astore 7
    //   185: ldc_w 513
    //   188: new 538	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 539	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 553
    //   198: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 6
    //   203: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 555
    //   209: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 7
    //   214: invokevirtual 559	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 545	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 549	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 520	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   226: pop
    //   227: goto -105 -> 122
    //   230: aload_0
    //   231: getfield 128	com/mapbar/android/maps/MyLocationOverlay:j	Z
    //   234: ifne +13 -> 247
    //   237: ldc_w 513
    //   240: ldc_w 561
    //   243: invokestatic 520	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   246: pop
    //   247: aload_0
    //   248: getfield 128	com/mapbar/android/maps/MyLocationOverlay:j	Z
    //   251: istore_3
    //   252: aload_0
    //   253: monitorexit
    //   254: iload_3
    //   255: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	MyLocationOverlay
    //   45	81	1	i1	int
    //   43	6	2	i2	int
    //   251	4	3	bool	boolean
    //   15	70	4	localLocationManager	LocationManager
    //   176	5	4	localObject	Object
    //   38	14	5	arrayOfString	String[]
    //   55	147	6	str	String
    //   129	30	7	localSecurityException	SecurityException
    //   183	30	7	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   57	122	129	java/lang/SecurityException
    //   2	44	176	finally
    //   57	122	176	finally
    //   131	173	176	finally
    //   185	227	176	finally
    //   230	247	176	finally
    //   247	252	176	finally
    //   57	122	183	java/lang/IllegalArgumentException
  }
  
  public Location getLastFix()
  {
    return this.l;
  }
  
  public GeoPoint getMyLocation()
  {
    return this.m;
  }
  
  public float getOrientation()
  {
    return this.i;
  }
  
  public boolean isCompassEnabled()
  {
    return this.h;
  }
  
  public boolean isMyLocationEnabled()
  {
    return this.j;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    for (;;)
    {
      long l1;
      NameAndDate localNameAndDate;
      try
      {
        boolean bool = this.j;
        if ((!bool) || (paramLocation == null)) {
          return;
        }
        Object localObject;
        if (paramLocation.getProvider().equals("network"))
        {
          this.D.removeMessages(1);
          if (this.b == null)
          {
            this.b = new Location(paramLocation);
            localObject = this.D.obtainMessage(1);
            this.D.sendMessageDelayed((Message)localObject, 15000L);
          }
        }
        else
        {
          l1 = SystemClock.elapsedRealtime();
          localObject = paramLocation.getProvider();
          Iterator localIterator = this.q.iterator();
          if (localIterator.hasNext())
          {
            localNameAndDate = (NameAndDate)localIterator.next();
            if (!localNameAndDate.a.equals(localObject)) {
              break label323;
            }
            localNameAndDate.b = l1;
          }
          this.o = true;
          this.m = new GeoPoint((int)(paramLocation.getLatitude() * 1000000.0D), (int)(paramLocation.getLongitude() * 1000000.0D));
          if ((!paramLocation.hasBearing()) || (!paramLocation.hasSpeed()) || (paramLocation.getSpeed() < 1.0F)) {
            break label363;
          }
          this.k = true;
          this.i = paramLocation.getBearing();
          this.n = SystemClock.elapsedRealtime();
          this.l = paramLocation;
          if (isLocationOnScreen(this.g, this.m)) {
            this.g.postInvalidate();
          }
          localObject = (Runnable)this.t.poll();
          if (localObject == null) {
            break label371;
          }
          Log.i("Maps.MyLocationOverlay", "Running deferred on first fix: " + localObject);
          new Thread((Runnable)localObject).start();
          continue;
        }
        this.b.set(paramLocation);
      }
      finally {}
      continue;
      label323:
      if ((localNameAndDate.a.equals("gps")) && (localNameAndDate.b > l1 - 10000L))
      {
        Log.i("Maps.MyLocationOverlay", "Got fallback update soon after preferred udpate, ignoring");
        continue;
        label363:
        this.k = false;
        continue;
        label371:
        x.c = (int)(paramLocation.getLongitude() * 100000.0D);
        x.d = (int)(paramLocation.getLatitude() * 100000.0D);
        x.e = (int)paramLocation.getAccuracy();
        x.f = "cn";
        if (("gps".equals(paramLocation.getProvider())) || ("network".equals(paramLocation.getProvider()))) {
          x.f = "wd";
        }
        x.g = SystemClock.elapsedRealtime();
      }
    }
  }
  
  public void onProviderDisabled(String paramString)
  {
    if (paramString.equals("network")) {
      clearNetworkLocationRebroadcasts();
    }
  }
  
  public void onProviderEnabled(String paramString) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.h) && (paramSensorEvent.sensor == this.A) && (!this.k))
    {
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent != null) && (paramSensorEvent.length > 0)) {
        if (paramSensorEvent.length > 2)
        {
          D.f = (int)paramSensorEvent[2];
          if ((D.e != 270) || (paramSensorEvent[2] <= 30.0F)) {
            break label93;
          }
        }
      }
    }
    for (D.e = 90;; D.e = 270) {
      label93:
      do
      {
        this.i = ((paramSensorEvent[0] + D.e) % 360.0F);
        return;
      } while ((D.e != 90) || (paramSensorEvent[2] >= -30.0F));
    }
  }
  
  public boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, MapView paramMapView)
  {
    if (isCloseToPoint(paramInt1, paramInt2, paramMapView))
    {
      paramPoint.x = this.r.x;
      paramPoint.y = this.r.y;
      return true;
    }
    return false;
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    if ((!paramString.equals("network")) || (paramInt == 2)) {
      return;
    }
    clearNetworkLocationRebroadcasts();
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.m != null)
    {
      paramMapView.getProjection().toPixels(paramGeoPoint, this.r);
      bool1 = bool2;
      if (isCloseToPoint(this.r.x, this.r.y, paramMapView))
      {
        dispatchTap();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  public boolean runOnFirstFix(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 134	com/mapbar/android/maps/MyLocationOverlay:m	Lcom/mapbar/android/maps/GeoPoint;
    //   6: ifnull +15 -> 21
    //   9: aload_1
    //   10: invokeinterface 717 1 0
    //   15: iconst_1
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 160	com/mapbar/android/maps/MyLocationOverlay:t	Ljava/util/Queue;
    //   25: aload_1
    //   26: invokeinterface 720 2 0
    //   31: pop
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -17 -> 17
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MyLocationOverlay
    //   0	42	1	paramRunnable	Runnable
    //   16	18	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	37	finally
    //   21	32	37	finally
  }
  
  private static class NameAndDate
  {
    public String a;
    public long b;
    
    public NameAndDate(String paramString)
    {
      this.a = paramString;
      this.b = Long.MIN_VALUE;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/MyLocationOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */