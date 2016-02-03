package org.osmdroid.views.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import org.osmdroid.tileprovider.MapTileProviderBase;
import org.osmdroid.tileprovider.MapTileProviderBasic;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.util.TileSystem;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.safecanvas.ISafeCanvas;
import org.osmdroid.views.safecanvas.SafePaint;

public class MinimapOverlay
  extends TilesOverlay
{
  private int mHeight = 100;
  private final Rect mIntersectionRect = new Rect();
  private final Rect mMiniMapCanvasRect = new Rect();
  private int mPadding = 10;
  private final SafePaint mPaint;
  private final Rect mTileArea = new Rect();
  private final Rect mViewportRect = new Rect();
  private int mWidth = 100;
  private int mWorldSize_2;
  private int mZoomDifference;
  
  public MinimapOverlay(Context paramContext, Handler paramHandler)
  {
    this(paramContext, paramHandler, new MapTileProviderBasic(paramContext));
  }
  
  public MinimapOverlay(Context paramContext, Handler paramHandler, MapTileProviderBase paramMapTileProviderBase)
  {
    this(paramContext, paramHandler, paramMapTileProviderBase, 3);
  }
  
  public MinimapOverlay(Context paramContext, Handler paramHandler, MapTileProviderBase paramMapTileProviderBase, int paramInt)
  {
    super(paramMapTileProviderBase, paramContext);
    setZoomDifference(paramInt);
    this.mTileProvider.setTileRequestCompleteHandler(paramHandler);
    setLoadingLineColor(getLoadingBackgroundColor());
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mWidth = ((int)(this.mWidth * f));
    this.mHeight = ((int)(this.mHeight * f));
    this.mPaint = new SafePaint();
    this.mPaint.setColor(-7829368);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(2.0F);
  }
  
  protected void drawSafe(ISafeCanvas paramISafeCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (paramMapView.isAnimating()) {
      return;
    }
    paramMapView = paramMapView.getProjection();
    int k = paramMapView.getZoomLevel();
    this.mWorldSize_2 = (TileSystem.MapSize(k) / 2);
    this.mViewportRect.set(paramMapView.getScreenRect());
    this.mViewportRect.offset(this.mWorldSize_2, this.mWorldSize_2);
    this.mTileArea.set(this.mViewportRect);
    int j = getZoomDifference();
    int i = j;
    if (k - getZoomDifference() < this.mTileProvider.getMinimumZoomLevel()) {
      i = j + (k - getZoomDifference() - this.mTileProvider.getMinimumZoomLevel());
    }
    this.mTileArea.set(this.mTileArea.left >> i, this.mTileArea.top >> i, this.mTileArea.right >> i, this.mTileArea.bottom >> i);
    this.mTileArea.set(this.mTileArea.centerX() - getWidth() / 2, this.mTileArea.centerY() - getHeight() / 2, this.mTileArea.centerX() + getWidth() / 2, this.mTileArea.centerY() + getHeight() / 2);
    this.mMiniMapCanvasRect.set(this.mViewportRect.right - getPadding() - getWidth(), this.mViewportRect.bottom - getPadding() - getHeight(), this.mViewportRect.right - getPadding(), this.mViewportRect.bottom - getPadding());
    this.mMiniMapCanvasRect.offset(-this.mWorldSize_2, -this.mWorldSize_2);
    paramISafeCanvas.drawRect(this.mMiniMapCanvasRect.left - 2, this.mMiniMapCanvasRect.top - 2, this.mMiniMapCanvasRect.right + 2, this.mMiniMapCanvasRect.bottom + 2, this.mPaint);
    super.drawTiles(paramISafeCanvas.getSafeCanvas(), paramMapView.getZoomLevel() - i, TileSystem.getTileSize(), this.mTileArea);
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getPadding()
  {
    return this.mPadding;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public int getZoomDifference()
  {
    return this.mZoomDifference;
  }
  
  public boolean isOptionsMenuEnabled()
  {
    return false;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return this.mMiniMapCanvasRect.contains((int)paramMotionEvent.getX() + this.mViewportRect.left - this.mWorldSize_2, (int)paramMotionEvent.getY() + this.mViewportRect.top - this.mWorldSize_2);
  }
  
  public boolean onLongPress(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return this.mMiniMapCanvasRect.contains((int)paramMotionEvent.getX() + this.mViewportRect.left - this.mWorldSize_2, (int)paramMotionEvent.getY() + this.mViewportRect.top - this.mWorldSize_2);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return this.mMiniMapCanvasRect.contains((int)paramMotionEvent.getX() + this.mViewportRect.left - this.mWorldSize_2, (int)paramMotionEvent.getY() + this.mViewportRect.top - this.mWorldSize_2);
  }
  
  protected void onTileReadyToDraw(Canvas paramCanvas, Drawable paramDrawable, Rect paramRect)
  {
    int i = paramRect.left - this.mTileArea.left + this.mMiniMapCanvasRect.left;
    int j = paramRect.top - this.mTileArea.top + this.mMiniMapCanvasRect.top;
    paramDrawable.setBounds(i, j, paramRect.width() + i, paramRect.height() + j);
    paramRect = paramCanvas.getClipBounds();
    if (this.mIntersectionRect.setIntersect(paramRect, this.mMiniMapCanvasRect))
    {
      paramCanvas.clipRect(this.mIntersectionRect);
      paramDrawable.draw(paramCanvas);
      paramCanvas.clipRect(paramRect);
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setPadding(int paramInt)
  {
    this.mPadding = paramInt;
  }
  
  public void setTileSource(ITileSource paramITileSource)
  {
    this.mTileProvider.setTileSource(paramITileSource);
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  public void setZoomDifference(int paramInt)
  {
    this.mZoomDifference = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/MinimapOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */