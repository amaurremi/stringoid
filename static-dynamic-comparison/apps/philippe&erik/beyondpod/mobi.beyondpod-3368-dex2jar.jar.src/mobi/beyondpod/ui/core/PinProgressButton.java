package mobi.beyondpod.ui.core;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import mobi.beyondpod.R.color;
import mobi.beyondpod.R.dimen;
import mobi.beyondpod.R.drawable;
import mobi.beyondpod.R.styleable;

public class PinProgressButton
  extends DontPressWithParentImageView
{
  public static final int STATE_DOWNLOAD = 0;
  public static final int STATE_DOWNLOADED = 6;
  public static final int STATE_DOWNLOADING = 3;
  public static final int STATE_DOWNLOADING_UNKNOWN = 4;
  public static final int STATE_DOWNLOAD_ERROR = 5;
  public static final int STATE_DOWNLOAD_PENDING = 1;
  public static final int STATE_RE_DOWNLOAD = 2;
  private Paint mCirclePaint;
  private int mDrawableSize;
  private int mInnerSize;
  private int mMax = 100;
  private Drawable mPinnedDrawable;
  private Drawable mPinnedPausedDrawable;
  private int mProgress;
  private Paint mProgressPaint;
  private Drawable mShadowDrawable;
  private int mState;
  private Rect mTempRect = new Rect();
  private RectF mTempRectF = new RectF();
  private int mUnknownStart = -90;
  private Drawable mUnpinnedDrawable;
  private Drawable mUnpinnedRedownloadDrawable;
  
  public PinProgressButton(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null, 0);
  }
  
  public PinProgressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet, 0);
  }
  
  public PinProgressButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.mMax = 100;
    this.mProgress = 0;
    this.mState = 0;
    Resources localResources = getResources();
    int m = localResources.getColor(R.color.pin_progress_default_circle_color);
    int k = localResources.getColor(R.color.pin_progress_default_progress_color);
    int j = m;
    int i = k;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PinProgressButton, paramInt, 0);
      this.mMax = paramContext.getInteger(2, this.mMax);
      this.mProgress = paramContext.getInteger(1, this.mProgress);
      j = paramContext.getColor(3, m);
      i = paramContext.getColor(4, k);
      paramContext.recycle();
    }
    this.mPinnedDrawable = localResources.getDrawable(R.drawable.pin_progress_pinned);
    this.mPinnedDrawable.setCallback(this);
    this.mUnpinnedDrawable = localResources.getDrawable(R.drawable.pin_progress_unpinned);
    this.mUnpinnedDrawable.setCallback(this);
    this.mShadowDrawable = localResources.getDrawable(R.drawable.pin_progress_shadow);
    this.mShadowDrawable.setCallback(this);
    this.mPinnedPausedDrawable = localResources.getDrawable(R.drawable.pin_progress_pinned_paused);
    this.mPinnedPausedDrawable.setCallback(this);
    this.mUnpinnedRedownloadDrawable = localResources.getDrawable(R.drawable.pin_progress_unpinned_redownload);
    this.mUnpinnedRedownloadDrawable.setCallback(this);
    this.mDrawableSize = this.mShadowDrawable.getIntrinsicWidth();
    this.mInnerSize = localResources.getDimensionPixelSize(R.dimen.pin_progress_inner_size);
    this.mCirclePaint = new Paint();
    this.mCirclePaint.setColor(j);
    this.mCirclePaint.setAntiAlias(true);
    this.mProgressPaint = new Paint();
    this.mProgressPaint.setColor(i);
    this.mProgressPaint.setAntiAlias(true);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mPinnedDrawable.isStateful()) {
      this.mPinnedDrawable.setState(getDrawableState());
    }
    if (this.mUnpinnedDrawable.isStateful()) {
      this.mUnpinnedDrawable.setState(getDrawableState());
    }
    if (this.mShadowDrawable.isStateful()) {
      this.mShadowDrawable.setState(getDrawableState());
    }
  }
  
  public int getMax()
  {
    return this.mMax;
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mTempRect.set(0, 0, this.mDrawableSize, this.mDrawableSize);
    this.mTempRect.offset((getWidth() - this.mDrawableSize) / 2, (getHeight() - this.mDrawableSize) / 2);
    this.mTempRectF.set(-0.5F, -0.5F, this.mInnerSize + 0.5F, this.mInnerSize + 0.5F);
    this.mTempRectF.offset((getWidth() - this.mInnerSize) / 2, (getHeight() - this.mInnerSize) / 2);
    paramCanvas.drawArc(this.mTempRectF, 0.0F, 360.0F, true, this.mCirclePaint);
    Drawable localDrawable;
    if (this.mState == 4)
    {
      paramCanvas.drawArc(this.mTempRectF, this.mUnknownStart, 45.0F, true, this.mProgressPaint);
      localDrawable = this.mUnpinnedDrawable;
      switch (this.mState)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        localDrawable = this.mPinnedDrawable;
      }
    }
    for (;;)
    {
      localDrawable.setBounds(this.mTempRect);
      localDrawable.draw(paramCanvas);
      this.mShadowDrawable.setBounds(this.mTempRect);
      this.mShadowDrawable.draw(paramCanvas);
      return;
      paramCanvas.drawArc(this.mTempRectF, -90.0F, this.mProgress * 360 / this.mMax, true, this.mProgressPaint);
      break;
      localDrawable = this.mUnpinnedDrawable;
      continue;
      localDrawable = this.mUnpinnedRedownloadDrawable;
      continue;
      localDrawable = this.mPinnedPausedDrawable;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(resolveSize(this.mDrawableSize, paramInt1), resolveSize(this.mDrawableSize, paramInt2));
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.mMax = paramParcelable.mMax;
    this.mProgress = paramParcelable.mProgress;
    this.mState = paramParcelable.mState;
  }
  
  public Parcelable onSaveInstanceState()
  {
    Object localObject = super.onSaveInstanceState();
    if (isSaveEnabled())
    {
      localObject = new SavedState((Parcelable)localObject);
      ((SavedState)localObject).mMax = this.mMax;
      ((SavedState)localObject).mProgress = this.mProgress;
      ((SavedState)localObject).mState = this.mState;
      return (Parcelable)localObject;
    }
    return (Parcelable)localObject;
  }
  
  public void setDownloadError(int paramInt)
  {
    this.mState = 5;
    this.mProgress = paramInt;
    invalidate();
  }
  
  public void setMax(int paramInt)
  {
    this.mMax = paramInt;
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 3) {
      i = 3;
    }
    this.mState = 3;
    this.mProgress = i;
    invalidate();
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
    if (paramInt == 6) {}
    for (this.mProgress = 100;; this.mProgress = 0)
    {
      invalidate();
      return;
    }
  }
  
  public void setUnknownProgress(long paramLong)
  {
    this.mState = 4;
    this.mUnknownStart += 45;
    if (this.mUnknownStart >= 270) {
      this.mUnknownStart = -90;
    }
    invalidate();
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public PinProgressButton.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new PinProgressButton.SavedState(paramAnonymousParcel, null);
      }
      
      public PinProgressButton.SavedState[] newArray(int paramAnonymousInt)
      {
        return new PinProgressButton.SavedState[paramAnonymousInt];
      }
    };
    private int mMax;
    private int mProgress;
    private int mState;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.mProgress = paramParcel.readInt();
      this.mMax = paramParcel.readInt();
      this.mState = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mProgress);
      paramParcel.writeInt(this.mMax);
      paramParcel.writeInt(this.mState);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/PinProgressButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */