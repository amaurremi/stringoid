package org.osmdroid.views.overlay.compass;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.FloatMath;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.overlay.IOverlayMenuProvider;
import org.osmdroid.views.overlay.SafeDrawOverlay;
import org.osmdroid.views.safecanvas.ISafeCanvas;
import org.osmdroid.views.safecanvas.SafePaint;

public class CompassOverlay
  extends SafeDrawOverlay
  implements IOverlayMenuProvider, IOrientationConsumer
{
  public static final int MENU_COMPASS = ;
  private float mAzimuth = NaN.0F;
  private float mCompassCenterX = 35.0F;
  private float mCompassCenterY = 35.0F;
  protected final Picture mCompassFrame = new Picture();
  protected final float mCompassFrameCenterX;
  protected final float mCompassFrameCenterY;
  private final Matrix mCompassMatrix = new Matrix();
  private final float mCompassRadius = 20.0F;
  protected final Picture mCompassRose = new Picture();
  protected final float mCompassRoseCenterX;
  protected final float mCompassRoseCenterY;
  private final Display mDisplay;
  private boolean mIsCompassEnabled;
  protected final MapView mMapView;
  private boolean mOptionsMenuEnabled = true;
  public IOrientationProvider mOrientationProvider;
  protected final SafePaint mPaint = new SafePaint();
  
  public CompassOverlay(Context paramContext, MapView paramMapView)
  {
    this(paramContext, new InternalCompassOrientationProvider(paramContext), paramMapView);
  }
  
  public CompassOverlay(Context paramContext, IOrientationProvider paramIOrientationProvider, MapView paramMapView)
  {
    this(paramContext, paramIOrientationProvider, paramMapView, new DefaultResourceProxyImpl(paramContext));
  }
  
  public CompassOverlay(Context paramContext, IOrientationProvider paramIOrientationProvider, MapView paramMapView, ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
    this.mMapView = paramMapView;
    this.mDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    createCompassFramePicture();
    createCompassRosePicture();
    this.mCompassFrameCenterX = (this.mCompassFrame.getWidth() / 2 - 0.5F);
    this.mCompassFrameCenterY = (this.mCompassFrame.getHeight() / 2 - 0.5F);
    this.mCompassRoseCenterX = (this.mCompassRose.getWidth() / 2 - 0.5F);
    this.mCompassRoseCenterY = (this.mCompassRose.getHeight() / 2 - 0.5F);
    setOrientationProvider(paramIOrientationProvider);
  }
  
  private Point calculatePointOnCircle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    double d = Math.toRadians(-paramFloat4 + 90.0F);
    int i = (int)(paramFloat3 * Math.cos(d));
    int j = (int)(paramFloat3 * Math.sin(d));
    return new Point((int)paramFloat1 + i, (int)paramFloat2 - j);
  }
  
  private void createCompassFramePicture()
  {
    Paint localPaint1 = new Paint();
    localPaint1.setColor(-1);
    localPaint1.setAntiAlias(true);
    localPaint1.setStyle(Paint.Style.FILL);
    localPaint1.setAlpha(200);
    Paint localPaint2 = new Paint();
    localPaint2.setColor(-7829368);
    localPaint2.setAntiAlias(true);
    localPaint2.setStyle(Paint.Style.STROKE);
    localPaint2.setStrokeWidth(2.0F);
    localPaint2.setAlpha(200);
    Canvas localCanvas = this.mCompassFrame.beginRecording(50, 50);
    localCanvas.drawCircle(25.0F, 25.0F, this.mScale * 20.0F, localPaint1);
    localCanvas.drawCircle(25.0F, 25.0F, this.mScale * 20.0F, localPaint2);
    drawTriangle(localCanvas, 25.0F, 25.0F, 20.0F * this.mScale, 0.0F, localPaint2);
    drawTriangle(localCanvas, 25.0F, 25.0F, 20.0F * this.mScale, 90.0F, localPaint2);
    drawTriangle(localCanvas, 25.0F, 25.0F, 20.0F * this.mScale, 180.0F, localPaint2);
    drawTriangle(localCanvas, 25.0F, 25.0F, 20.0F * this.mScale, 270.0F, localPaint2);
    this.mCompassFrame.endRecording();
  }
  
  private void createCompassRosePicture()
  {
    Object localObject = new Paint();
    ((Paint)localObject).setColor(-6291456);
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setStyle(Paint.Style.FILL);
    ((Paint)localObject).setAlpha(220);
    Paint localPaint1 = new Paint();
    localPaint1.setColor(-16777216);
    localPaint1.setAntiAlias(true);
    localPaint1.setStyle(Paint.Style.FILL);
    localPaint1.setAlpha(220);
    Paint localPaint2 = new Paint();
    localPaint2.setColor(-1);
    localPaint2.setAntiAlias(true);
    localPaint2.setStyle(Paint.Style.FILL);
    localPaint2.setAlpha(220);
    Canvas localCanvas = this.mCompassRose.beginRecording(50, 50);
    Path localPath = new Path();
    localPath.moveTo(25.0F, 25.0F - this.mScale * 17.0F);
    localPath.lineTo(this.mScale * 4.0F + 25.0F, 25.0F);
    localPath.lineTo(25.0F - this.mScale * 4.0F, 25.0F);
    localPath.lineTo(25.0F, 25.0F - this.mScale * 17.0F);
    localPath.close();
    localCanvas.drawPath(localPath, (Paint)localObject);
    localObject = new Path();
    ((Path)localObject).moveTo(25.0F, this.mScale * 17.0F + 25.0F);
    ((Path)localObject).lineTo(this.mScale * 4.0F + 25.0F, 25.0F);
    ((Path)localObject).lineTo(25.0F - this.mScale * 4.0F, 25.0F);
    ((Path)localObject).lineTo(25.0F, this.mScale * 17.0F + 25.0F);
    ((Path)localObject).close();
    localCanvas.drawPath((Path)localObject, localPaint1);
    localCanvas.drawCircle(25.0F, 25.0F, 2.0F, localPaint2);
    this.mCompassRose.endRecording();
  }
  
  private void drawTriangle(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Paint paramPaint)
  {
    paramCanvas.save();
    Point localPoint = calculatePointOnCircle(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.rotate(paramFloat4, localPoint.x, localPoint.y);
    Path localPath = new Path();
    localPath.moveTo(localPoint.x - this.mScale * 2.0F, localPoint.y);
    localPath.lineTo(localPoint.x + this.mScale * 2.0F, localPoint.y);
    localPath.lineTo(localPoint.x, localPoint.y - 5.0F * this.mScale);
    localPath.close();
    paramCanvas.drawPath(localPath, paramPaint);
    paramCanvas.restore();
  }
  
  private int getDisplayOrientation()
  {
    switch (this.mDisplay.getOrientation())
    {
    default: 
      return 0;
    case 1: 
      return 90;
    case 2: 
      return 180;
    }
    return 270;
  }
  
  private void invalidateCompass()
  {
    Rect localRect = this.mMapView.getProjection().getScreenRect();
    int i = localRect.left;
    int j = this.mMapView.getWidth() / 2;
    int k = (int)FloatMath.ceil((this.mCompassCenterX - this.mCompassFrameCenterX) * this.mScale);
    int m = localRect.top;
    int n = this.mMapView.getHeight() / 2;
    int i1 = (int)FloatMath.ceil((this.mCompassCenterY - this.mCompassFrameCenterY) * this.mScale);
    int i2 = localRect.left;
    int i3 = this.mMapView.getWidth() / 2;
    int i4 = (int)FloatMath.ceil((this.mCompassCenterX + this.mCompassFrameCenterX) * this.mScale);
    int i5 = localRect.top;
    int i6 = this.mMapView.getHeight() / 2;
    int i7 = (int)FloatMath.ceil((this.mCompassCenterY + this.mCompassFrameCenterY) * this.mScale);
    this.mMapView.postInvalidate(i + j + k - 2, m + n + i1 - 2, i2 + i3 + i4 + 2, i5 + i6 + i7 + 2);
  }
  
  public void disableCompass()
  {
    this.mIsCompassEnabled = false;
    if (this.mOrientationProvider != null) {
      this.mOrientationProvider.stopOrientationProvider();
    }
    this.mAzimuth = NaN.0F;
    if (this.mMapView != null) {
      invalidateCompass();
    }
  }
  
  protected void drawCompass(ISafeCanvas paramISafeCanvas, float paramFloat, Rect paramRect)
  {
    float f1 = this.mCompassCenterX * this.mScale;
    float f2 = this.mCompassCenterY * this.mScale + (paramISafeCanvas.getHeight() - this.mMapView.getHeight());
    this.mCompassMatrix.setTranslate(-this.mCompassFrameCenterX, -this.mCompassFrameCenterY);
    this.mCompassMatrix.postTranslate(f1, f2);
    paramISafeCanvas.save();
    paramISafeCanvas.setMatrix(this.mCompassMatrix);
    paramISafeCanvas.drawPicture(this.mCompassFrame);
    this.mCompassMatrix.setRotate(-paramFloat, this.mCompassRoseCenterX, this.mCompassRoseCenterY);
    this.mCompassMatrix.postTranslate(-this.mCompassRoseCenterX, -this.mCompassRoseCenterY);
    this.mCompassMatrix.postTranslate(f1, f2);
    paramISafeCanvas.setMatrix(this.mCompassMatrix);
    paramISafeCanvas.drawPicture(this.mCompassRose);
    paramISafeCanvas.restore();
  }
  
  protected void drawSafe(ISafeCanvas paramISafeCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((!isCompassEnabled()) || (Float.isNaN(this.mAzimuth))) {
      return;
    }
    drawCompass(paramISafeCanvas, this.mAzimuth + getDisplayOrientation(), paramMapView.getProjection().getScreenRect());
  }
  
  public boolean enableCompass()
  {
    if (this.mIsCompassEnabled) {
      this.mOrientationProvider.stopOrientationProvider();
    }
    boolean bool = this.mOrientationProvider.startOrientationProvider(this);
    this.mIsCompassEnabled = bool;
    if (this.mMapView != null) {
      invalidateCompass();
    }
    return bool;
  }
  
  public boolean enableCompass(IOrientationProvider paramIOrientationProvider)
  {
    setOrientationProvider(paramIOrientationProvider);
    this.mIsCompassEnabled = false;
    return enableCompass();
  }
  
  public float getOrientation()
  {
    return this.mAzimuth;
  }
  
  public IOrientationProvider getOrientationProvider()
  {
    return this.mOrientationProvider;
  }
  
  public boolean isCompassEnabled()
  {
    return this.mIsCompassEnabled;
  }
  
  public boolean isOptionsMenuEnabled()
  {
    return this.mOptionsMenuEnabled;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    paramMenu.add(0, MENU_COMPASS + paramInt, 0, this.mResourceProxy.getString(ResourceProxy.string.compass)).setIcon(this.mResourceProxy.getDrawable(ResourceProxy.bitmap.ic_menu_compass)).setCheckable(true);
    return true;
  }
  
  public void onDetach(MapView paramMapView)
  {
    disableCompass();
    super.onDetach(paramMapView);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem, int paramInt, MapView paramMapView)
  {
    if (paramMenuItem.getItemId() - paramInt == MENU_COMPASS)
    {
      if (isCompassEnabled()) {
        disableCompass();
      }
      for (;;)
      {
        return true;
        enableCompass();
      }
    }
    return false;
  }
  
  public void onOrientationChanged(float paramFloat, IOrientationProvider paramIOrientationProvider)
  {
    this.mAzimuth = paramFloat;
    invalidateCompass();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView)
  {
    paramMenu.findItem(MENU_COMPASS + paramInt).setChecked(isCompassEnabled());
    return false;
  }
  
  public void setCompassCenter(float paramFloat1, float paramFloat2)
  {
    this.mCompassCenterX = paramFloat1;
    this.mCompassCenterY = paramFloat2;
  }
  
  public void setOptionsMenuEnabled(boolean paramBoolean)
  {
    this.mOptionsMenuEnabled = paramBoolean;
  }
  
  protected void setOrientationProvider(IOrientationProvider paramIOrientationProvider)
  {
    if (paramIOrientationProvider == null) {
      throw new RuntimeException("You must pass an IOrientationProvider to setOrientationProvider()");
    }
    if (this.mOrientationProvider != null) {
      this.mOrientationProvider.stopOrientationProvider();
    }
    this.mOrientationProvider = paramIOrientationProvider;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/compass/CompassOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */