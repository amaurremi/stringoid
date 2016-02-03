package org.osmdroid.views.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.constants.GeoConstants;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.safecanvas.ISafeCanvas;

public class ScaleBarOverlay
  extends SafeDrawOverlay
  implements GeoConstants
{
  private boolean adjustLength = false;
  private Paint barPaint;
  private Paint bgPaint;
  private boolean centred = false;
  private final Context context;
  boolean imperial = false;
  private float lastLatitude = 0.0F;
  private int lastZoomLevel = -1;
  boolean latitudeBar = true;
  float lineWidth = 2.0F;
  boolean longitudeBar = false;
  private final Rect mBounds = new Rect();
  private final Matrix mIdentityMatrix = new Matrix();
  private float maxLength;
  int minZoom = 0;
  boolean nautical = false;
  private MapView.Projection projection;
  private final ResourceProxy resourceProxy;
  protected final Picture scaleBarPicture = new Picture();
  public int screenHeight;
  public int screenWidth;
  private Paint textPaint;
  final int textSize = 12;
  float xOffset = 10.0F;
  public float xdpi;
  float yOffset = 10.0F;
  public float ydpi;
  
  public ScaleBarOverlay(Context paramContext)
  {
    this(paramContext, new DefaultResourceProxyImpl(paramContext));
  }
  
  public ScaleBarOverlay(Context paramContext, ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
    this.resourceProxy = paramResourceProxy;
    this.context = paramContext;
    this.barPaint = new Paint();
    this.barPaint.setColor(-16777216);
    this.barPaint.setAntiAlias(true);
    this.barPaint.setStyle(Paint.Style.FILL);
    this.barPaint.setAlpha(255);
    this.bgPaint = null;
    this.textPaint = new Paint();
    this.textPaint.setColor(-16777216);
    this.textPaint.setAntiAlias(true);
    this.textPaint.setStyle(Paint.Style.FILL);
    this.textPaint.setAlpha(255);
    this.textPaint.setTextSize(12.0F);
    this.xdpi = this.context.getResources().getDisplayMetrics().xdpi;
    this.ydpi = this.context.getResources().getDisplayMetrics().ydpi;
    this.screenWidth = this.context.getResources().getDisplayMetrics().widthPixels;
    this.screenHeight = this.context.getResources().getDisplayMetrics().heightPixels;
    paramContext = null;
    try
    {
      paramResourceProxy = (String)Build.class.getField("MANUFACTURER").get(null);
      paramContext = paramResourceProxy;
    }
    catch (Exception paramResourceProxy)
    {
      for (;;) {}
    }
    if (("motorola".equals(paramContext)) && ("DROIDX".equals(Build.MODEL))) {
      if (((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getOrientation() > 0)
      {
        this.xdpi = ((float)(this.screenWidth / 3.75D));
        this.ydpi = ((float)(this.screenHeight / 2.1D));
      }
    }
    for (;;)
    {
      this.maxLength = 2.54F;
      return;
      this.xdpi = ((float)(this.screenWidth / 2.1D));
      this.ydpi = ((float)(this.screenHeight / 3.75D));
      continue;
      if (("motorola".equals(paramContext)) && ("Droid".equals(Build.MODEL)))
      {
        this.xdpi = 264.0F;
        this.ydpi = 264.0F;
      }
    }
  }
  
  private double adjustScaleBarLength(double paramDouble)
  {
    long l2 = 0L;
    int j = 0;
    double d;
    long l1;
    int i;
    if (this.imperial) {
      if (paramDouble >= 321.8688D)
      {
        d = paramDouble / 1609.344D;
        l1 = l2;
        i = j;
      }
    }
    for (;;)
    {
      l2 = l1;
      paramDouble = d;
      if (d < 10.0D) {
        break;
      }
      l1 += 1L;
      d /= 10.0D;
      continue;
      d = paramDouble * 3.2808399D;
      i = 1;
      l1 = l2;
      continue;
      i = j;
      l1 = l2;
      d = paramDouble;
      if (this.nautical) {
        if (paramDouble >= 370.4D)
        {
          d = paramDouble / 1852.0D;
          i = j;
          l1 = l2;
        }
        else
        {
          d = paramDouble * 3.2808399D;
          i = 1;
          l1 = l2;
        }
      }
    }
    while ((paramDouble < 1.0D) && (paramDouble > 0.0D))
    {
      l2 -= 1L;
      paramDouble *= 10.0D;
    }
    if (paramDouble < 2.0D)
    {
      paramDouble = 1.0D;
      if (i == 0) {
        break label220;
      }
      d = paramDouble / 3.2808399D;
    }
    for (;;)
    {
      return d * Math.pow(10.0D, l2);
      if (paramDouble < 5.0D)
      {
        paramDouble = 2.0D;
        break;
      }
      paramDouble = 5.0D;
      break;
      label220:
      if (this.imperial)
      {
        d = paramDouble * 1609.344D;
      }
      else
      {
        d = paramDouble;
        if (this.nautical) {
          d = paramDouble * 1852.0D;
        }
      }
    }
  }
  
  private void createScaleBarPicture(MapView paramMapView)
  {
    this.projection = paramMapView.getProjection();
    if (this.projection == null) {
      return;
    }
    int i = (int)(this.xdpi / 2.54D);
    int j = (int)(this.ydpi / 2.54D);
    i = (int)(this.maxLength * i);
    j = (int)(this.maxLength * j);
    paramMapView = this.projection.fromPixels(this.screenWidth / 2 - i / 2, this.yOffset);
    Object localObject = this.projection.fromPixels(this.screenWidth / 2 + i / 2, this.yOffset);
    int k = ((GeoPoint)paramMapView).distanceTo((IGeoPoint)localObject);
    double d1;
    if (this.adjustLength)
    {
      d1 = adjustScaleBarLength(k);
      i = (int)(i * d1 / k);
      paramMapView = this.projection.fromPixels(this.screenWidth / 2, this.screenHeight / 2 - j / 2);
      localObject = this.projection.fromPixels(this.screenWidth / 2, this.screenHeight / 2 + j / 2);
      k = ((GeoPoint)paramMapView).distanceTo((IGeoPoint)localObject);
      if (!this.adjustLength) {
        break label830;
      }
    }
    label830:
    for (double d2 = adjustScaleBarLength(k);; d2 = k)
    {
      j = (int)(j * d2 / k);
      paramMapView = this.scaleBarPicture.beginRecording(i, j);
      localObject = scaleBarLengthText((int)d1, this.imperial, this.nautical);
      Rect localRect1 = new Rect();
      this.textPaint.getTextBounds((String)localObject, 0, ((String)localObject).length(), localRect1);
      k = (int)(localRect1.height() / 5.0D);
      String str = scaleBarLengthText((int)d2, this.imperial, this.nautical);
      Rect localRect2 = new Rect();
      this.textPaint.getTextBounds(str, 0, str.length(), localRect2);
      int m = (int)(localRect2.height() / 5.0D);
      if (this.bgPaint != null)
      {
        paramMapView.drawRect(0.0F, 0.0F, localRect2.height() + 2.0F * this.lineWidth + m, localRect1.height() + 2.0F * this.lineWidth + k, this.bgPaint);
        if (this.latitudeBar) {
          paramMapView.drawRect(localRect2.height() + 2.0F * this.lineWidth + m, 0.0F, i + this.lineWidth, localRect1.height() + 2.0F * this.lineWidth + k, this.bgPaint);
        }
        if (this.longitudeBar) {
          paramMapView.drawRect(0.0F, localRect1.height() + 2.0F * this.lineWidth + k, localRect2.height() + 2.0F * this.lineWidth + m, j + this.lineWidth, this.bgPaint);
        }
      }
      if (this.latitudeBar)
      {
        paramMapView.drawRect(0.0F, 0.0F, i, this.lineWidth, this.barPaint);
        paramMapView.drawRect(i, 0.0F, i + this.lineWidth, localRect1.height() + this.lineWidth + k, this.barPaint);
        if (!this.longitudeBar) {
          paramMapView.drawRect(0.0F, 0.0F, this.lineWidth, localRect1.height() + this.lineWidth + k, this.barPaint);
        }
        paramMapView.drawText((String)localObject, i / 2 - localRect1.width() / 2, localRect1.height() + this.lineWidth + k, this.textPaint);
      }
      if (this.longitudeBar)
      {
        paramMapView.drawRect(0.0F, 0.0F, this.lineWidth, j, this.barPaint);
        paramMapView.drawRect(0.0F, j, localRect2.height() + this.lineWidth + m, j + this.lineWidth, this.barPaint);
        if (!this.latitudeBar) {
          paramMapView.drawRect(0.0F, 0.0F, localRect2.height() + this.lineWidth + m, this.lineWidth, this.barPaint);
        }
        float f1 = localRect2.height() + this.lineWidth + m;
        float f2 = j / 2 + localRect2.width() / 2;
        paramMapView.rotate(-90.0F, f1, f2);
        paramMapView.drawText(str, f1, f2, this.textPaint);
      }
      this.scaleBarPicture.endRecording();
      return;
      d1 = k;
      break;
    }
  }
  
  public void disableScaleBar()
  {
    setEnabled(false);
  }
  
  public void drawLatitudeScale(boolean paramBoolean)
  {
    this.latitudeBar = paramBoolean;
    this.lastZoomLevel = -1;
  }
  
  public void drawLongitudeScale(boolean paramBoolean)
  {
    this.longitudeBar = paramBoolean;
    this.lastZoomLevel = -1;
  }
  
  public void drawSafe(ISafeCanvas paramISafeCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramMapView.isAnimating());
        i = paramMapView.getZoomLevel();
      } while (i < this.minZoom);
      localObject = paramMapView.getProjection();
    } while (localObject == null);
    Object localObject = ((MapView.Projection)localObject).fromPixels(this.screenWidth / 2, this.screenHeight / 2);
    if ((i != this.lastZoomLevel) || ((int)(((IGeoPoint)localObject).getLatitudeE6() / 1000000.0D) != (int)(this.lastLatitude / 1000000.0D)))
    {
      this.lastZoomLevel = i;
      this.lastLatitude = ((IGeoPoint)localObject).getLatitudeE6();
      createScaleBarPicture(paramMapView);
    }
    this.mBounds.set(0, 0, this.scaleBarPicture.getWidth(), this.scaleBarPicture.getHeight());
    this.mBounds.offset((int)this.xOffset, (int)this.yOffset);
    if ((this.centred) && (this.latitudeBar)) {
      this.mBounds.offset(-this.scaleBarPicture.getWidth() / 2, 0);
    }
    if ((this.centred) && (this.longitudeBar)) {
      this.mBounds.offset(0, -this.scaleBarPicture.getHeight() / 2);
    }
    this.mBounds.set(this.mBounds);
    paramISafeCanvas.save();
    paramISafeCanvas.setMatrix(this.mIdentityMatrix);
    paramISafeCanvas.translate(0.0F, paramISafeCanvas.getHeight() - paramMapView.getHeight());
    paramISafeCanvas.getWrappedCanvas().drawPicture(this.scaleBarPicture, this.mBounds);
    paramISafeCanvas.restore();
  }
  
  public void enableScaleBar()
  {
    setEnabled(true);
  }
  
  public Paint getBarPaint()
  {
    return this.barPaint;
  }
  
  public Paint getTextPaint()
  {
    return this.textPaint;
  }
  
  protected String scaleBarLengthText(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.imperial)
    {
      if (paramInt >= 8046.72D) {
        return this.resourceProxy.getString(ResourceProxy.string.format_distance_miles, new Object[] { Integer.valueOf((int)(paramInt / 1609.344D)) });
      }
      if (paramInt >= 321.8688D) {
        return this.resourceProxy.getString(ResourceProxy.string.format_distance_miles, new Object[] { Double.valueOf((int)(paramInt / 160.9344D) / 10.0D) });
      }
      return this.resourceProxy.getString(ResourceProxy.string.format_distance_feet, new Object[] { Integer.valueOf((int)(paramInt * 3.2808399D)) });
    }
    if (this.nautical)
    {
      if (paramInt >= 9260.0D) {
        return this.resourceProxy.getString(ResourceProxy.string.format_distance_nautical_miles, new Object[] { Integer.valueOf((int)(paramInt / 1852.0D)) });
      }
      if (paramInt >= 370.4D) {
        return this.resourceProxy.getString(ResourceProxy.string.format_distance_nautical_miles, new Object[] { Double.valueOf((int)(paramInt / 185.2D) / 10.0D) });
      }
      return this.resourceProxy.getString(ResourceProxy.string.format_distance_feet, new Object[] { Integer.valueOf((int)(paramInt * 3.2808399D)) });
    }
    if (paramInt >= 5000) {
      return this.resourceProxy.getString(ResourceProxy.string.format_distance_kilometers, new Object[] { Integer.valueOf(paramInt / 1000) });
    }
    if (paramInt >= 200) {
      return this.resourceProxy.getString(ResourceProxy.string.format_distance_kilometers, new Object[] { Double.valueOf((int)(paramInt / 100.0D) / 10.0D) });
    }
    return this.resourceProxy.getString(ResourceProxy.string.format_distance_meters, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setBackgroundPaint(Paint paramPaint)
  {
    this.bgPaint = paramPaint;
    this.lastZoomLevel = -1;
  }
  
  public void setBarPaint(Paint paramPaint)
  {
    if (paramPaint == null) {
      throw new IllegalArgumentException("pBarPaint argument cannot be null");
    }
    this.barPaint = paramPaint;
    this.lastZoomLevel = -1;
  }
  
  public void setCentred(boolean paramBoolean)
  {
    this.centred = paramBoolean;
    this.lastZoomLevel = -1;
  }
  
  public void setEnableAdjustLength(boolean paramBoolean)
  {
    this.adjustLength = paramBoolean;
    this.lastZoomLevel = -1;
  }
  
  public void setImperial()
  {
    this.imperial = true;
    this.nautical = false;
    this.lastZoomLevel = -1;
  }
  
  public void setLineWidth(float paramFloat)
  {
    this.lineWidth = paramFloat;
  }
  
  public void setMaxLength(float paramFloat)
  {
    this.maxLength = paramFloat;
    this.lastZoomLevel = -1;
  }
  
  public void setMetric()
  {
    this.nautical = false;
    this.imperial = false;
    this.lastZoomLevel = -1;
  }
  
  public void setMinZoom(int paramInt)
  {
    this.minZoom = paramInt;
  }
  
  public void setNautical()
  {
    this.nautical = true;
    this.imperial = false;
    this.lastZoomLevel = -1;
  }
  
  public void setScaleBarOffset(float paramFloat1, float paramFloat2)
  {
    this.xOffset = paramFloat1;
    this.yOffset = paramFloat2;
  }
  
  public void setTextPaint(Paint paramPaint)
  {
    if (paramPaint == null) {
      throw new IllegalArgumentException("pTextPaint argument cannot be null");
    }
    this.textPaint = paramPaint;
    this.lastZoomLevel = -1;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.textPaint.setTextSize(paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/ScaleBarOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */