package com.mapbar.android.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.mapbar.map.MapPoint;
import com.mapbar.map.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PWebOverlay
  extends Overlay
  implements f
{
  private Context a;
  private j b;
  private int c = 300;
  private int d = this.c;
  private int e = 12;
  private PWebOverlayType f;
  private Point g = new Point();
  private OnTapOverlayItemListener h;
  private Drawable i;
  private Drawable j;
  private l k;
  private int l = 1;
  private int m = 14;
  private Map<String, String> n = new HashMap();
  
  public PWebOverlay(Context paramContext, PWebOverlayType paramPWebOverlayType)
  {
    new Paint();
    this.a = paramContext;
    this.f = paramPWebOverlayType;
  }
  
  public PWebOverlay(Context paramContext, String paramString1, String paramString2)
  {
    new Paint();
    this.a = paramContext;
    this.f = new PWebOverlayType(paramString1, paramString2);
  }
  
  private static int ceil(int paramInt1, int paramInt2)
  {
    if (paramInt1 % paramInt2 != 0) {
      return paramInt1 / paramInt2 + 1;
    }
    return paramInt1 / paramInt2;
  }
  
  private void drawAllOverlayItems(Canvas paramCanvas, MapView paramMapView)
  {
    int i5;
    int i6;
    int i7;
    int i3;
    int i4;
    int i13;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    for (;;)
    {
      synchronized (this.n)
      {
        this.n.clear();
        ??? = paramMapView.getMapCenter().getMapPoint();
        i5 = paramMapView.getZoomLevel();
        i1 = ((MapPoint)???).getLongitude();
        i2 = ((MapPoint)???).getLatitude();
        i6 = D.a(i5);
        i7 = D.b(i5);
        i1 = paramMapView.getWidth() / 2 - i1 % i6 * this.c / i6;
        i3 = paramMapView.getHeight() / 2;
        i4 = this.d;
        i2 = i2 % i7 * this.d / i7 + (i3 - i4) + D.c(i5);
        i13 = -ceil(i1 * 1000 / this.c, 1000);
        i8 = ceil((paramMapView.getWidth() - i1 - this.c) * 1000 / this.c, 1000);
        i9 = -ceil(i2 * 1000 / this.d, 1000);
        i10 = ceil((paramMapView.getHeight() - i2 - this.d) * 1000 / this.d, 1000);
        i11 = this.c * i13 + i1;
        i12 = this.d * i9 + i2;
        i2 = -i13;
        i1 = 0;
        if (i1 < i13) {
          break;
        }
        i4 = -i9;
        i3 = 0;
        if (i3 >= i9)
        {
          setMapTile(paramCanvas, i1, i3, i6, i7, i2, i4, (MapPoint)???, i5, i11, i12, paramMapView);
          i4 -= 1;
          i3 -= 1;
        }
      }
      i3 = 1;
      while (i3 <= i10)
      {
        setMapTile(paramCanvas, i1, i3, i6, i7, i2, i4, (MapPoint)???, i5, i11, i12, paramMapView);
        i4 += 1;
        i3 += 1;
      }
      i2 -= 1;
      i1 -= 1;
    }
    int i2 = -i13 + 1;
    int i1 = 1;
    while (i1 <= i8)
    {
      i4 = -i9;
      i3 = 0;
      while (i3 >= i9)
      {
        setMapTile(paramCanvas, i1, i3, i6, i7, i2, i4, (MapPoint)???, i5, i11, i12, paramMapView);
        i4 -= 1;
        i3 -= 1;
      }
      i4 = -i9 + 1;
      i3 = 1;
      while (i3 <= i10)
      {
        setMapTile(paramCanvas, i1, i3, i6, i7, i2, i4, (MapPoint)???, i5, i11, i12, paramMapView);
        i4 += 1;
        i3 += 1;
      }
      i2 += 1;
      i1 += 1;
    }
  }
  
  private void drawFocusOverlayItem(Canvas paramCanvas, MapView paramMapView)
  {
    if ((this.k == null) || (getMarkerFocusDrawable() == null)) {
      return;
    }
    paramMapView.getProjection().toPixels(this.k.f(), this.g);
    paramCanvas.save();
    paramCanvas.translate(this.g.x, this.g.y);
    getMarkerFocusDrawable().draw(paramCanvas);
    paramCanvas.restore();
  }
  
  private l getItemByLocation(Point paramPoint)
  {
    synchronized (this.n)
    {
      String[] arrayOfString = (String[])this.n.keySet().toArray(new String[0]);
      int i1 = arrayOfString.length - 1;
      while (i1 >= 0)
      {
        Object localObject = arrayOfString[i1].split("_");
        int i2 = Integer.parseInt(localObject[0]);
        int i3 = Integer.parseInt(localObject[1]);
        if ((i2 <= paramPoint.x) && (i3 <= paramPoint.y) && (i2 + 300 >= paramPoint.x) && (i3 + 300 >= paramPoint.y))
        {
          localObject = (String)this.n.get(arrayOfString[i1]);
          localObject = (k)getPOIImageCache().a(localObject);
          if (localObject != null)
          {
            this.g.x = (paramPoint.x - i2);
            this.g.y = (paramPoint.y - i3);
            paramPoint = ((k)localObject).a(this.g, 40);
            return paramPoint;
          }
        }
        i1 -= 1;
      }
      return null;
    }
  }
  
  private j getPOIImageCache()
  {
    if (this.b == null) {}
    for (;;)
    {
      try
      {
        localFile = new File(this.a.getCacheDir(), "POI_" + this.f.getCatalogName());
        if (!localFile.exists()) {
          continue;
        }
        if (!localFile.isDirectory())
        {
          localFile.delete();
          localFile.mkdirs();
        }
        h.b local1 = new h.b()
        {
          public boolean eject(File paramAnonymousFile)
          {
            return System.currentTimeMillis() - paramAnonymousFile.lastModified() > 604800000L;
          }
        };
        this.b = new j(this.a, localFile, local1, this.e, this.j);
      }
      catch (Exception localException)
      {
        File localFile;
        continue;
      }
      return this.b;
      localFile.mkdirs();
    }
  }
  
  private void setMapTile(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, MapPoint paramMapPoint, int paramInt7, int paramInt8, int paramInt9, MapView paramMapView)
  {
    ??? = b.a(paramMapPoint.getLongitude() + paramInt1 * paramInt3, paramMapPoint.getLatitude() - paramInt2 * paramInt4, paramInt7);
    paramInt1 = this.c * paramInt5 + paramInt8;
    paramInt2 = this.c * paramInt6 + paramInt9;
    try
    {
      new StringBuilder().append(D.h).append(this.c).append("/").append((String)???).append(".png");
      paramMapPoint = new StringBuilder();
      paramMapPoint.append(this.f.getCatalogName()).append("/").append((String)???).append(".js");
      if ((paramInt7 < getMaxLevel()) && (paramInt7 > getMinLevel())) {
        synchronized (this.n)
        {
          this.n.put(paramInt1 + "_" + paramInt2, paramMapPoint.toString());
          getPOIImageCache().a(paramMapView, paramCanvas, this.e, paramInt1, paramInt2, true, paramMapPoint.toString(), null);
          return;
        }
      }
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  public void destory()
  {
    if (this.b != null)
    {
      this.b.destory();
      this.b = null;
    }
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    this.e = ((paramMapView.getMeasuredWidth() / this.c + 2) * (paramMapView.getMeasuredHeight() / this.c + 2));
    if ((paramMapView.getZoomLevel() > getMaxLevel()) || (paramMapView.getZoomLevel() < getMinLevel())) {
      return;
    }
    drawAllOverlayItems(paramCanvas, paramMapView);
    drawFocusOverlayItem(paramCanvas, paramMapView);
  }
  
  public Drawable getMarkerDrawable()
  {
    return this.j;
  }
  
  public Drawable getMarkerFocusDrawable()
  {
    return this.i;
  }
  
  public int getMaxLevel()
  {
    return this.m;
  }
  
  public int getMinLevel()
  {
    return this.l;
  }
  
  public OnTapOverlayItemListener getOnTapOverlayItemListener()
  {
    return this.h;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    if (this.h == null) {}
    do
    {
      return false;
      paramMapView.getProjection().toPixels(paramGeoPoint, this.g);
      paramGeoPoint = getItemByLocation(this.g);
    } while (paramGeoPoint == null);
    this.k = paramGeoPoint;
    this.h.onTapOverlayItem(paramGeoPoint);
    paramMapView.invalidate();
    return true;
  }
  
  public void setMarkerDrawable(Drawable paramDrawable)
  {
    this.j = paramDrawable;
    if (this.j != null)
    {
      int i1 = ((BitmapDrawable)this.j).getBitmap().getWidth() / 2;
      int i2 = ((BitmapDrawable)this.j).getBitmap().getHeight() / 2;
      this.j.setBounds(-i1, -i2, i1, i2);
    }
  }
  
  public void setMarkerFocusDrawable(Drawable paramDrawable)
  {
    this.i = paramDrawable;
    if (this.i != null)
    {
      int i1 = ((BitmapDrawable)this.i).getBitmap().getWidth() / 2;
      int i2 = ((BitmapDrawable)this.i).getBitmap().getHeight() / 2;
      this.i.setBounds(-i1, -i2 << 1, i1, 0);
    }
  }
  
  public void setMaxLevel(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setMinLevel(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setOnTapOverlayItemListener(OnTapOverlayItemListener paramOnTapOverlayItemListener)
  {
    this.h = paramOnTapOverlayItemListener;
  }
  
  public static abstract interface OnTapOverlayItemListener
  {
    public abstract void onTapOverlayItem(l paraml);
  }
  
  public static class PWebOverlayType
  {
    public static final PWebOverlayType BankType;
    public static final PWebOverlayType DrugstoreType;
    public static final PWebOverlayType FoodType = new PWebOverlayType("餐馆", "food");
    public static final PWebOverlayType GreaseType = new PWebOverlayType("加油站", "grease");
    public static final PWebOverlayType HospitalType;
    public static final PWebOverlayType HotelType;
    public static final PWebOverlayType MarketType;
    public static final PWebOverlayType ParkType;
    public static final PWebOverlayType PostType;
    public static final PWebOverlayType SuperMarketType;
    protected String mCatalogName;
    protected String mDisplayName;
    
    static
    {
      BankType = new PWebOverlayType("银行", "bank");
      HotelType = new PWebOverlayType("酒店", "hotel");
      MarketType = new PWebOverlayType("商场", "market");
      SuperMarketType = new PWebOverlayType("超市", "supermarket");
      HospitalType = new PWebOverlayType("医院", "hospital");
      DrugstoreType = new PWebOverlayType("药店", "drugstore");
      PostType = new PWebOverlayType("邮局", "post");
      ParkType = new PWebOverlayType("停车场", "park");
    }
    
    public PWebOverlayType(String paramString1, String paramString2)
    {
      this.mDisplayName = paramString1;
      this.mCatalogName = paramString2;
    }
    
    public String getCatalogName()
    {
      return this.mCatalogName;
    }
    
    public String getDisplayName()
    {
      return this.mDisplayName;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/PWebOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */