package org.osmdroid.views.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.List;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;

public class ItemizedOverlayWithFocus<Item extends OverlayItem>
  extends ItemizedIconOverlay<Item>
{
  protected static final int DEFAULTMARKER_BACKGROUNDCOLOR = Color.rgb(101, 185, 74);
  public static final int DESCRIPTION_BOX_CORNERWIDTH = 3;
  public static final int DESCRIPTION_BOX_PADDING = 3;
  public static final int DESCRIPTION_LINE_HEIGHT = 12;
  protected static final int DESCRIPTION_MAXWIDTH = 200;
  public static final int DESCRIPTION_TITLE_EXTRA_LINE_HEIGHT = 2;
  private final String UNKNOWN = this.mResourceProxy.getString(ResourceProxy.string.unknown);
  protected final Paint mDescriptionPaint;
  protected boolean mFocusItemsOnTap;
  protected int mFocusedItemIndex;
  private final Point mFocusedScreenCoords = new Point();
  protected final Paint mMarkerBackgroundPaint;
  protected final int mMarkerFocusedBackgroundColor;
  protected Drawable mMarkerFocusedBase;
  private final Rect mRect = new Rect();
  protected final Paint mTitlePaint;
  
  public ItemizedOverlayWithFocus(Context paramContext, List<Item> paramList, ItemizedIconOverlay.OnItemGestureListener<Item> paramOnItemGestureListener)
  {
    this(paramList, paramOnItemGestureListener, new DefaultResourceProxyImpl(paramContext));
  }
  
  public ItemizedOverlayWithFocus(List<Item> paramList, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt, ItemizedIconOverlay.OnItemGestureListener<Item> paramOnItemGestureListener, ResourceProxy paramResourceProxy)
  {
    super(paramList, paramDrawable1, paramOnItemGestureListener, paramResourceProxy);
    if (paramDrawable2 == null)
    {
      this.mMarkerFocusedBase = boundToHotspot(this.mResourceProxy.getDrawable(ResourceProxy.bitmap.marker_default_focused_base), OverlayItem.HotspotPlace.BOTTOM_CENTER);
      if (paramInt == Integer.MIN_VALUE) {
        break label158;
      }
    }
    for (;;)
    {
      this.mMarkerFocusedBackgroundColor = paramInt;
      this.mMarkerBackgroundPaint = new Paint();
      this.mDescriptionPaint = new Paint();
      this.mDescriptionPaint.setAntiAlias(true);
      this.mTitlePaint = new Paint();
      this.mTitlePaint.setFakeBoldText(true);
      this.mTitlePaint.setAntiAlias(true);
      unSetFocusedItem();
      return;
      this.mMarkerFocusedBase = paramDrawable2;
      break;
      label158:
      paramInt = DEFAULTMARKER_BACKGROUNDCOLOR;
    }
  }
  
  public ItemizedOverlayWithFocus(List<Item> paramList, ItemizedIconOverlay.OnItemGestureListener<Item> paramOnItemGestureListener, ResourceProxy paramResourceProxy)
  {
    this(paramList, paramResourceProxy.getDrawable(ResourceProxy.bitmap.marker_default), null, Integer.MIN_VALUE, paramOnItemGestureListener, paramResourceProxy);
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    super.draw(paramCanvas, paramMapView, paramBoolean);
    if (paramBoolean) {}
    while (this.mFocusedItemIndex == Integer.MIN_VALUE) {
      return;
    }
    Object localObject3 = (OverlayItem)this.mItemList.get(this.mFocusedItemIndex);
    Object localObject2 = ((OverlayItem)localObject3).getMarker(4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.mMarkerFocusedBase;
    }
    paramMapView.getProjection().toMapPixels(((OverlayItem)localObject3).getPoint(), this.mFocusedScreenCoords);
    ((Drawable)localObject1).copyBounds(this.mRect);
    this.mRect.offset(this.mFocusedScreenCoords.x, this.mFocusedScreenCoords.y);
    label137:
    StringBuilder localStringBuilder;
    label182:
    float f;
    int i4;
    int i3;
    int i2;
    int i1;
    if (((OverlayItem)localObject3).getTitle() == null)
    {
      localObject2 = this.UNKNOWN;
      if (((OverlayItem)localObject3).getSnippet() != null) {
        break label334;
      }
      localObject3 = this.UNKNOWN;
      float[] arrayOfFloat = new float[((String)localObject3).length()];
      this.mDescriptionPaint.getTextWidths((String)localObject3, arrayOfFloat);
      localStringBuilder = new StringBuilder();
      j = 0;
      m = 0;
      n = 0;
      k = 0;
      i = 0;
      if (i >= arrayOfFloat.length) {
        break label351;
      }
      if (!Character.isLetter(((String)localObject3).charAt(i))) {
        k = i;
      }
      f = arrayOfFloat[i];
      i4 = m;
      i3 = i;
      i2 = n;
      i1 = j;
      if (m + f > 200.0F)
      {
        if (n != k) {
          break label344;
        }
        i -= 1;
      }
    }
    for (;;)
    {
      localStringBuilder.append(((String)localObject3).subSequence(n, i));
      localStringBuilder.append('\n');
      i2 = i;
      i1 = Math.max(j, m);
      i4 = 0;
      i3 = i;
      m = (int)(i4 + f);
      i = i3 + 1;
      n = i2;
      j = i1;
      break label182;
      localObject2 = ((OverlayItem)localObject3).getTitle();
      break;
      label334:
      localObject3 = ((OverlayItem)localObject3).getSnippet();
      break label137;
      label344:
      i = k;
    }
    label351:
    int k = j;
    if (i != n)
    {
      localObject3 = ((String)localObject3).substring(n, i);
      k = Math.max(j, (int)this.mDescriptionPaint.measureText((String)localObject3));
      localStringBuilder.append((String)localObject3);
    }
    localObject3 = localStringBuilder.toString().split("\n");
    int i = Math.min(Math.max(k, (int)this.mDescriptionPaint.measureText((String)localObject2)), 200);
    k = this.mRect.left - i / 2 - 3 + this.mRect.width() / 2;
    int m = k + i + 6;
    i = this.mRect.top;
    int j = i - 2 - (localObject3.length + 1) * 12 - 6;
    this.mMarkerBackgroundPaint.setColor(-16777216);
    paramCanvas.drawRoundRect(new RectF(k - 1, j - 1, m + 1, i + 1), 3.0F, 3.0F, this.mDescriptionPaint);
    this.mMarkerBackgroundPaint.setColor(this.mMarkerFocusedBackgroundColor);
    paramCanvas.drawRoundRect(new RectF(k, j, m, i), 3.0F, 3.0F, this.mMarkerBackgroundPaint);
    int n = k + 3;
    j = i - 3;
    i = localObject3.length - 1;
    while (i >= 0)
    {
      paramCanvas.drawText(localObject3[i].trim(), n, j, this.mDescriptionPaint);
      j -= 12;
      i -= 1;
    }
    paramCanvas.drawText((String)localObject2, n, j - 2, this.mTitlePaint);
    paramCanvas.drawLine(k, j, m, j, this.mDescriptionPaint);
    Overlay.drawAt(paramCanvas, (Drawable)localObject1, this.mFocusedScreenCoords.x, this.mFocusedScreenCoords.y, false, paramMapView.getMapOrientation());
  }
  
  public Item getFocusedItem()
  {
    if (this.mFocusedItemIndex == Integer.MIN_VALUE) {
      return null;
    }
    return (OverlayItem)this.mItemList.get(this.mFocusedItemIndex);
  }
  
  protected boolean onSingleTapUpHelper(int paramInt, Item paramItem, MapView paramMapView)
  {
    if (this.mFocusItemsOnTap)
    {
      this.mFocusedItemIndex = paramInt;
      paramMapView.postInvalidate();
    }
    return this.mOnItemGestureListener.onItemSingleTapUp(paramInt, paramItem);
  }
  
  public void setFocusItemsOnTap(boolean paramBoolean)
  {
    this.mFocusItemsOnTap = paramBoolean;
  }
  
  public void setFocusedItem(int paramInt)
  {
    this.mFocusedItemIndex = paramInt;
  }
  
  public void setFocusedItem(Item paramItem)
  {
    int i = this.mItemList.indexOf(paramItem);
    if (i < 0) {
      throw new IllegalArgumentException();
    }
    setFocusedItem(i);
  }
  
  public void unSetFocusedItem()
  {
    this.mFocusedItemIndex = Integer.MIN_VALUE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/ItemizedOverlayWithFocus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */