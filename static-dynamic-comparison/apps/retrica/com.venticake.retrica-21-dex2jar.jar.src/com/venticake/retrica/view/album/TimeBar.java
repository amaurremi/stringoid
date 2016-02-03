package com.venticake.retrica.view.album;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.microedition.khronos.opengles.GL11;

public final class TimeBar
  extends Layer
  implements MediaFeed.Listener
{
  private static final float AUTO_SCROLL_MARGIN = 100.0F;
  public static final int HEIGHT = 48;
  private static final int KNOB = 2130837664;
  private static final int KNOB_PRESSED = 2130837665;
  private static final int MARKER_SPACING_PIXELS = 50;
  private static final Paint SRC_PAINT = new Paint();
  private float mAnimTextAlpha = 0.0F;
  private NinePatch mBackground;
  private Rect mBackgroundRect;
  private BitmapTexture mBackgroundTexture;
  private StringTexture mDateUnknown;
  private final StringTexture.Config mDayFormat = new StringTexture.Config();
  private final StringTexture[] mDayLabels = new StringTexture[32];
  private final StringTexture mDot = new StringTexture("");
  private float mDragX = 0.0F;
  private MediaFeed mFeed = null;
  private boolean mInDrag = false;
  private TimeBar.Listener mListener = null;
  private ArrayList<TimeBar.Marker> mMarkers = new ArrayList();
  private ArrayList<TimeBar.Marker> mMarkersCopy = new ArrayList();
  private final StringTexture[] mMonthLabels = new StringTexture[12];
  private final StringTexture.Config mMonthYearFormat = new StringTexture.Config();
  private final StringTexture[] mOpaqueDayLabels = new StringTexture[32];
  private float mPosition = 0.0F;
  private float mPositionAnim = 0.0F;
  private float mScroll = 0.0F;
  private float mScrollAnim = 0.0F;
  private boolean mShowTime;
  private int mState;
  private float mTextAlpha = 0.0F;
  private float mTotalWidth = 0.0F;
  private final HashMap<MediaItem, TimeBar.Marker> mTracker = new HashMap(1024);
  private final SparseArray<StringTexture> mYearLabels = new SparseArray();
  
  TimeBar(Context paramContext)
  {
    this.mMonthYearFormat.fontSize = (Gallery.PIXEL_DENSITY * 17.0F);
    this.mMonthYearFormat.bold = true;
    this.mMonthYearFormat.a = 0.85F;
    this.mDayFormat.fontSize = (Gallery.PIXEL_DENSITY * 17.0F);
    this.mDayFormat.a = 0.61F;
    regenerateStringsForContext(paramContext);
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130837661);
    this.mBackground = new NinePatch(paramContext, paramContext.getNinePatchChunk(), null);
    this.mBackgroundRect = new Rect();
    SRC_PAINT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
  }
  
  private float addMarker(TimeBar.Marker paramMarker)
  {
    this.mMarkers.add(paramMarker);
    return paramMarker.x + 50.0F * Gallery.PIXEL_DENSITY;
  }
  
  private TimeBar.Marker getAnchorMarker()
  {
    synchronized (this.mMarkers)
    {
      int k = this.mMarkers.size();
      if (k == 0) {
        return null;
      }
      int j = (int)(this.mPosition * k);
      int i = j;
      if (j >= k) {
        i = k - 1;
      }
      TimeBar.Marker localMarker = (TimeBar.Marker)this.mMarkers.get(i);
      return localMarker;
    }
  }
  
  private float getKnobXForPosition(float paramFloat)
  {
    return this.mTotalWidth * paramFloat;
  }
  
  private float getPositionForKnobX(float paramFloat)
  {
    if (this.mTotalWidth == 0.0F) {}
    for (paramFloat = 0.0F;; paramFloat /= this.mTotalWidth) {
      return Math.max(0.0F, Math.min(1.0F, paramFloat));
    }
  }
  
  private float getPositionForScroll(float paramFloat)
  {
    float f = this.mWidth;
    if (this.mTotalWidth == 0.0F) {
      return 0.0F;
    }
    return (paramFloat + f * 0.5F) / this.mTotalWidth;
  }
  
  private float getScrollForPosition(float paramFloat)
  {
    float f1 = this.mWidth * 0.5F;
    float f2 = -f1;
    return (this.mTotalWidth - f1) * paramFloat + (1.0F - paramFloat) * f2;
  }
  
  private StringTexture getYearLabel(int paramInt)
  {
    if (paramInt <= 1970) {
      localObject = this.mDot;
    }
    StringTexture localStringTexture;
    do
    {
      return (StringTexture)localObject;
      localStringTexture = (StringTexture)this.mYearLabels.get(paramInt);
      localObject = localStringTexture;
    } while (localStringTexture != null);
    Object localObject = new StringTexture(Integer.toString(paramInt), this.mMonthYearFormat);
    this.mYearLabels.put(paramInt, localObject);
    return (StringTexture)localObject;
  }
  
  private void layout()
  {
    if (this.mFeed != null) {
      this.mTracker.clear();
    }
    label122:
    label134:
    label330:
    label737:
    label752:
    label766:
    label789:
    for (;;)
    {
      int j;
      int k;
      float f2;
      float f1;
      int n;
      Object localObject4;
      ArrayList localArrayList;
      int m;
      int i;
      synchronized (this.mMarkers)
      {
        this.mMarkers.clear();
        float f3 = this.mScroll;
        ??? = this.mFeed;
        j = -1;
        k = -1;
        f2 = 0.0F;
        f1 = 0.0F;
        n = 12;
        this.mShowTime = true;
        if (this.mState == 1)
        {
          MediaSet localMediaSet1 = ((MediaFeed)???).getFilteredSet();
          if (localMediaSet1 != null) {
            break label789;
          }
          localMediaSet1 = ((MediaFeed)???).getCurrentSet();
          if (localMediaSet1 != null)
          {
            localObject4 = new GregorianCalendar();
            localArrayList = localMediaSet1.getItems();
            if (localArrayList != null)
            {
              m = 0;
              i = -1;
              if (m < localMediaSet1.getNumItems()) {
                break label330;
              }
              f2 = f1;
            }
            this.mTotalWidth = (f2 - 50.0F * Gallery.PIXEL_DENSITY);
          }
          this.mPosition = getPositionForScroll(f3);
          this.mPositionAnim = this.mPosition;
        }
      }
      for (;;)
      {
        synchronized (this.mMarkersCopy)
        {
          j = this.mMarkers.size();
          this.mMarkersCopy.clear();
          this.mMarkersCopy.ensureCapacity(j);
          i = 0;
          if (i >= j)
          {
            return;
            localObject2 = finally;
            throw ((Throwable)localObject2);
            n = 2;
            if (!((MediaFeed)???).hasExpandedMediaSet()) {
              this.mShowTime = false;
            }
            MediaSet localMediaSet2 = new MediaSet();
            m = ((MediaFeed)???).getNumSlots();
            i = 0;
            if (i >= m) {
              break;
            }
            localObject4 = ((MediaFeed)???).getSetForSlot(i);
            if (localObject4 != null)
            {
              localArrayList = ((MediaSet)localObject4).getItems();
              if ((localArrayList != null) && (((MediaSet)localObject4).getNumItems() > 0))
              {
                localObject4 = (MediaItem)localArrayList.get(0);
                if (localObject4 != null) {
                  localMediaSet2.addItem((MediaItem)localObject4);
                }
              }
            }
            i += 1;
            continue;
            ??? = (MediaItem)localArrayList.get(m);
            if (??? == null) {
              break label122;
            }
            ((GregorianCalendar)localObject4).setTimeInMillis(((MediaItem)???).mDateTakenInMs);
            int i3 = ((GregorianCalendar)localObject4).get(1);
            if (i3 == i) {
              break label766;
            }
            j = -1;
            i = -1;
            k = i3;
            i2 = ((GregorianCalendar)localObject4).get(2);
            i1 = ((GregorianCalendar)localObject4).get(5);
            if (i2 != i)
            {
              ??? = new TimeBar.Marker(f1, ((GregorianCalendar)localObject4).getTimeInMillis(), i3, i2, i1, 1, n);
              f1 = addMarker((TimeBar.Marker)???);
              i = -1;
              j = i2;
              i1 = 0;
              if (i1 < n) {
                continue;
              }
              f2 = f1;
              if (m == localArrayList.size() - 1) {
                break label134;
              }
              m += n;
              if (m < localArrayList.size() - 1) {
                break label737;
              }
              i1 = localArrayList.size() - 1;
              m = k;
              k = i;
              i = m;
              m = i1;
              break label122;
            }
            if (i1 != j)
            {
              if (i1 == 0) {
                break label752;
              }
              ??? = new TimeBar.Marker(f1, ((GregorianCalendar)localObject4).getTimeInMillis(), i3, i2, i1, 2, n);
              f1 = addMarker((TimeBar.Marker)???);
              j = i;
              i = i1;
              continue;
            }
            ??? = new TimeBar.Marker(f1, ((GregorianCalendar)localObject4).getTimeInMillis(), i3, i2, i1, 3, n);
            f1 = addMarker((TimeBar.Marker)???);
            i1 = i;
            i = j;
            j = i1;
            continue;
            i2 = i1 + m;
            if (i2 < 0)
            {
              i1 += 1;
              continue;
            }
            if ((i2 >= localArrayList.size()) || ((i2 == localArrayList.size() - 1) && (i1 != 0))) {
              continue;
            }
            MediaItem localMediaItem = (MediaItem)localArrayList.get(i2);
            ((TimeBar.Marker)???).items.add(localMediaItem);
            this.mTracker.put(localMediaItem, ???);
            continue;
          }
          this.mMarkersCopy.add((TimeBar.Marker)this.mMarkers.get(i));
          i += 1;
        }
        int i1 = k;
        k = i;
        i = i1;
        break label122;
        ??? = null;
        j = i;
        i = i1;
        continue;
        i1 = k;
        int i2 = j;
        k = i;
        j = i1;
        i = i2;
      }
    }
  }
  
  public void generate(RenderView paramRenderView, RenderView.Lists paramLists)
  {
    paramLists.updateList.add(this);
    paramLists.blendedList.add(this);
    paramLists.hitTestList.add(this);
  }
  
  public MediaItem getItem()
  {
    label171:
    for (;;)
    {
      synchronized (this.mMarkers)
      {
        int j = this.mMarkers.size();
        if (j == 0) {
          return null;
        }
        int i = (int)(this.mPosition * j);
        if (i < j) {
          break label171;
        }
        i = j - 1;
        Object localObject1 = (TimeBar.Marker)this.mMarkers.get(i);
        if (localObject1 != null)
        {
          float f1 = 1.0F / j;
          float f2 = this.mPosition;
          float f3 = i;
          int k = ((TimeBar.Marker)localObject1).items.size();
          if (k == 0) {
            return null;
          }
          j = (int)(k * (f2 - f3 * f1) / f1);
          i = j;
          if (j >= k) {
            i = k - 1;
          }
          localObject1 = (MediaItem)((TimeBar.Marker)localObject1).items.get(i);
          return (MediaItem)localObject1;
        }
      }
      return null;
    }
  }
  
  public boolean isDragged()
  {
    return this.mInDrag;
  }
  
  public void onFeedAboutToChange(MediaFeed paramMediaFeed) {}
  
  public void onFeedChanged(MediaFeed paramMediaFeed, boolean paramBoolean)
  {
    layout();
  }
  
  protected void onSizeChanged()
  {
    this.mScroll = getScrollForPosition(this.mPosition);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mDragX = paramMotionEvent.getX();
    this.mPosition = getPositionForKnobX(this.mDragX + this.mScroll);
    if (this.mListener != null) {
      this.mListener.onTimeChanged(this);
    }
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      this.mInDrag = true;
      return true;
    }
    this.mInDrag = false;
    setItem(getItem());
    return true;
  }
  
  public void regenerateStringsForContext(Context paramContext)
  {
    int j = 0;
    paramContext = paramContext.getResources().getStringArray(2131558400);
    int i = 0;
    if (i >= paramContext.length) {
      i = j;
    }
    for (;;)
    {
      if (i > 31)
      {
        this.mDateUnknown = new StringTexture("date unkown", this.mMonthYearFormat);
        this.mBackgroundTexture = null;
        return;
        this.mMonthLabels[i] = new StringTexture(paramContext[i], this.mMonthYearFormat);
        i += 1;
        break;
      }
      this.mDayLabels[i] = new StringTexture(Integer.toString(i), this.mDayFormat);
      this.mOpaqueDayLabels[i] = new StringTexture(Integer.toString(i), this.mMonthYearFormat);
      i += 1;
    }
  }
  
  public void renderBlended(RenderView paramRenderView, GL11 paramGL11)
  {
    float f1 = this.mX;
    float f3 = this.mY;
    f1 -= this.mScrollAnim;
    float f2 = this.mPositionAnim;
    float f4;
    if (this.mInDrag)
    {
      i = 2130837665;
      localObject1 = paramRenderView.getResource(i);
      if (this.mShowTime) {
        break label104;
      }
      if (paramRenderView.bind((Texture)localObject1))
      {
        f4 = ((Texture)localObject1).getWidth();
        paramRenderView.draw2D(f1 + getKnobXForPosition(f2) - 0.5F * f4, f3, 0.0F, f4, ((Texture)localObject1).getHeight());
      }
    }
    label104:
    Object localObject2;
    do
    {
      do
      {
        return;
        i = 2130837664;
        break;
        if (paramRenderView.bind((Texture)localObject1))
        {
          f3 = ((Texture)localObject1).getWidth();
          f4 = ((Texture)localObject1).getHeight();
          paramRenderView.draw2D(getKnobXForPosition(f2) + f1 - 0.5F * f3, paramRenderView.getHeight() - f4, 0.0F, f3, f4);
        }
      } while ((!this.mInDrag) && (this.mAnimTextAlpha == 0.0F));
      localObject2 = getAnchorMarker();
    } while (localObject2 == null);
    StringTexture localStringTexture2 = this.mMonthLabels[localObject2.month];
    StringTexture localStringTexture1 = this.mOpaqueDayLabels[localObject2.day];
    Object localObject1 = getYearLabel(((TimeBar.Marker)localObject2).year);
    int i = 1;
    if (((TimeBar.Marker)localObject2).year <= 1970)
    {
      localStringTexture2 = this.mDateUnknown;
      localStringTexture1 = null;
      localObject1 = null;
      i = 0;
    }
    paramRenderView.loadTexture(localStringTexture2);
    if (i != 0)
    {
      paramRenderView.loadTexture(localStringTexture1);
      paramRenderView.loadTexture((Texture)localObject1);
    }
    f2 = localStringTexture2.getWidth();
    if (i != 0) {
      f1 = localStringTexture1.getWidth() + ((Texture)localObject1).getWidth() + 10.0F * Gallery.PIXEL_DENSITY;
    }
    for (;;)
    {
      f1 += f2;
      if (70 * Gallery.PIXEL_DENSITY + f1 != this.mBackgroundRect.right)
      {
        this.mBackgroundRect.right = ((int)(70 * Gallery.PIXEL_DENSITY + f1));
        this.mBackgroundRect.bottom = ((int)(localStringTexture2.getHeight() + 20.0F * Gallery.PIXEL_DENSITY));
      }
      try
      {
        localObject2 = Bitmap.createBitmap(this.mBackgroundRect.right, this.mBackgroundRect.bottom, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas();
        localCanvas.setBitmap((Bitmap)localObject2);
        this.mBackground.draw(localCanvas, this.mBackgroundRect, SRC_PAINT);
        this.mBackgroundTexture = new BitmapTexture((Bitmap)localObject2);
        paramRenderView.loadTexture(this.mBackgroundTexture);
        ((Bitmap)localObject2).recycle();
        paramGL11.glTexEnvf(8960, 8704, 8448.0F);
        paramGL11.glColor4f(this.mAnimTextAlpha, this.mAnimTextAlpha, this.mAnimTextAlpha, this.mAnimTextAlpha);
        f2 = (paramRenderView.getWidth() - f1 - 70 * Gallery.PIXEL_DENSITY) / 2.0F;
        f3 = paramRenderView.getHeight();
        f4 = Gallery.PIXEL_DENSITY;
        if (this.mBackgroundTexture != null) {
          paramRenderView.draw2D(this.mBackgroundTexture, f2, (f3 - 10.0F * f4) * 0.5F);
        }
        f2 = paramRenderView.getHeight() * 0.5F;
        f1 = (paramRenderView.getWidth() - f1) / 2.0F;
        paramRenderView.draw2D(localStringTexture2, f1, f2);
        if (i != 0)
        {
          f1 = localStringTexture2.getWidth() + 3.0F * Gallery.PIXEL_DENSITY + f1;
          paramRenderView.draw2D(localStringTexture1, f1, f2);
          paramRenderView.draw2D((Texture)localObject1, f1 + (localStringTexture1.getWidth() + 7.0F * Gallery.PIXEL_DENSITY), f2);
        }
        if (this.mAnimTextAlpha != 1.0F) {
          paramGL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        paramGL11.glTexEnvf(8960, 8704, 7681.0F);
        return;
        f1 = 0.0F;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;) {}
      }
    }
  }
  
  public void setFeed(MediaFeed paramMediaFeed, int paramInt, boolean paramBoolean)
  {
    this.mFeed = paramMediaFeed;
    this.mState = paramInt;
    layout();
    if (paramBoolean)
    {
      this.mPosition = 0.0F;
      this.mScroll = getScrollForPosition(this.mPosition);
    }
  }
  
  public void setItem(MediaItem paramMediaItem)
  {
    paramMediaItem = (TimeBar.Marker)this.mTracker.get(paramMediaItem);
    if (paramMediaItem != null) {
      if (this.mTotalWidth != 0.0F) {
        break label53;
      }
    }
    label53:
    for (float f = 0.0F;; f = paramMediaItem.x / this.mTotalWidth)
    {
      this.mPosition = Math.max(0.0F, Math.min(1.0F, f));
      this.mScroll = getScrollForPosition(this.mPosition);
      return;
    }
  }
  
  public void setListener(TimeBar.Listener paramListener)
  {
    this.mListener = paramListener;
  }
  
  public boolean update(RenderView paramRenderView, float paramFloat)
  {
    float f1 = 0.0F;
    float f2 = Math.min(1.0F, 10.0F * paramFloat);
    float f3 = 1.0F - f2;
    this.mPositionAnim = (this.mPosition * f2 + this.mPositionAnim * f3);
    this.mScrollAnim = (f2 * this.mScroll + f3 * this.mScrollAnim);
    if (this.mInDrag)
    {
      f2 = getKnobXForPosition(this.mPosition) - this.mScrollAnim;
      f3 = 100.0F * Gallery.PIXEL_DENSITY;
      if (f2 < f3)
      {
        f1 = -(float)Math.pow(1.0F - f2 / f3, 2.0D);
        this.mScroll = (f1 * 400.0F * paramFloat + this.mScroll);
        this.mPosition = getPositionForKnobX(this.mDragX + this.mScroll);
      }
    }
    for (this.mTextAlpha = 1.0F;; this.mTextAlpha = 0.0F)
    {
      this.mAnimTextAlpha = FloatUtils.animate(this.mAnimTextAlpha, this.mTextAlpha, paramFloat);
      if (this.mAnimTextAlpha == this.mTextAlpha) {
        break label225;
      }
      return true;
      if (f2 <= this.mWidth - f3) {
        break;
      }
      f1 = (float)Math.pow(1.0F - (this.mWidth - f2) / f3, 2.0D);
      break;
    }
    label225:
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/TimeBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */