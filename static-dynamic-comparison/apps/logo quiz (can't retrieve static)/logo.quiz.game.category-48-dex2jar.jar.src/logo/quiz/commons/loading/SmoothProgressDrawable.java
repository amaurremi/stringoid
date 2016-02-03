package logo.quiz.commons.loading;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import fr.castorflex.android.smoothprogressbar.R.bool;
import fr.castorflex.android.smoothprogressbar.R.color;
import fr.castorflex.android.smoothprogressbar.R.dimen;
import fr.castorflex.android.smoothprogressbar.R.integer;
import fr.castorflex.android.smoothprogressbar.R.string;

public class SmoothProgressDrawable
  extends Drawable
  implements Animatable
{
  private static final long FRAME_DURATION = 16L;
  private static final float OFFSET_PER_FRAME = 0.01F;
  private Rect mBounds;
  private int[] mColors;
  private int mColorsIndex;
  private float mCurrentOffset;
  private Interpolator mInterpolator;
  private float mMaxOffset;
  private boolean mMirrorMode;
  private boolean mNewTurn;
  private Paint mPaint;
  private boolean mReversed;
  private boolean mRunning = false;
  private int mSectionsCount;
  private int mSeparatorLength;
  private float mSpeed;
  private final Runnable mUpdater = new Runnable()
  {
    public void run()
    {
      SmoothProgressDrawable.access$016(SmoothProgressDrawable.this, 0.01F * SmoothProgressDrawable.this.mSpeed);
      if (SmoothProgressDrawable.this.mCurrentOffset >= SmoothProgressDrawable.this.mMaxOffset)
      {
        SmoothProgressDrawable.access$302(SmoothProgressDrawable.this, true);
        SmoothProgressDrawable.access$024(SmoothProgressDrawable.this, SmoothProgressDrawable.this.mMaxOffset);
      }
      SmoothProgressDrawable.this.scheduleSelf(SmoothProgressDrawable.this.mUpdater, SystemClock.uptimeMillis() + 16L);
      SmoothProgressDrawable.this.invalidateSelf();
    }
  };
  
  private SmoothProgressDrawable(Interpolator paramInterpolator, int paramInt1, int paramInt2, int[] paramArrayOfInt, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mInterpolator = paramInterpolator;
    this.mSectionsCount = paramInt1;
    this.mSeparatorLength = paramInt2;
    this.mSpeed = paramFloat2;
    this.mReversed = paramBoolean1;
    this.mColors = paramArrayOfInt;
    this.mColorsIndex = 0;
    this.mMirrorMode = paramBoolean2;
    this.mMaxOffset = (1.0F / this.mSectionsCount);
    this.mPaint = new Paint();
    this.mPaint.setStrokeWidth(paramFloat1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setDither(false);
    this.mPaint.setAntiAlias(false);
  }
  
  private int decrementColor(int paramInt)
  {
    int i = paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = this.mColors.length - 1;
    }
    return paramInt;
  }
  
  private void drawLine(Canvas paramCanvas, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.mPaint.setColor(this.mColors[paramInt2]);
    if (!this.mMirrorMode) {
      paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.mPaint);
    }
    for (;;)
    {
      paramCanvas.save();
      return;
      if (this.mReversed)
      {
        paramCanvas.drawLine(paramInt1 + paramFloat1, paramFloat2, paramInt1 + paramFloat3, paramFloat4, this.mPaint);
        paramCanvas.drawLine(paramInt1 - paramFloat1, paramFloat2, paramInt1 - paramFloat3, paramFloat4, this.mPaint);
      }
      else
      {
        paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.mPaint);
        paramCanvas.drawLine(paramInt1 * 2 - paramFloat1, paramFloat2, paramInt1 * 2 - paramFloat3, paramFloat4, this.mPaint);
      }
    }
  }
  
  private void drawStrokes(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    int j = this.mBounds.width();
    int i = j;
    if (this.mMirrorMode) {
      i = j / 2;
    }
    int m = this.mSeparatorLength + i + this.mSectionsCount;
    int n = this.mBounds.centerY();
    float f4 = 1.0F / this.mSectionsCount;
    if (this.mNewTurn)
    {
      this.mColorsIndex = decrementColor(this.mColorsIndex);
      this.mNewTurn = false;
    }
    int k = this.mColorsIndex;
    j = 0;
    if (j <= this.mSectionsCount)
    {
      float f3 = j * f4 + this.mCurrentOffset;
      float f2 = Math.max(0.0F, f3 - f4);
      f3 = Math.abs(this.mInterpolator.getInterpolation(f2) - this.mInterpolator.getInterpolation(Math.min(f3, 1.0F)));
      f3 = (int)(m * f3);
      if (f3 + f2 < m)
      {
        f2 = Math.min(f3, this.mSeparatorLength);
        label188:
        if (f3 <= f2) {
          break label271;
        }
      }
      label271:
      for (f3 -= f2;; f3 = 0.0F)
      {
        f3 = f1 + f3;
        if (f3 > f1) {
          drawLine(paramCanvas, i, Math.min(i, f1), n, Math.min(i, f3), n, k);
        }
        f1 = f3 + f2;
        k = incrementColor(k);
        j += 1;
        break;
        f2 = 0.0F;
        break label188;
      }
    }
  }
  
  private int incrementColor(int paramInt)
  {
    int i = paramInt + 1;
    paramInt = i;
    if (i >= this.mColors.length) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mBounds = getBounds();
    paramCanvas.clipRect(this.mBounds);
    int i = this.mBounds.width();
    if (this.mReversed)
    {
      paramCanvas.translate(i, 0.0F);
      paramCanvas.scale(-1.0F, 1.0F);
    }
    drawStrokes(paramCanvas);
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.mRunning;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    this.mRunning = true;
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setColor(int paramInt)
  {
    setColors(new int[] { paramInt });
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setColors(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      throw new IllegalArgumentException("Colors cannot be null or empty");
    }
    this.mColorsIndex = 0;
    this.mColors = paramArrayOfInt;
    invalidateSelf();
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    if (paramInterpolator == null) {
      throw new IllegalArgumentException("Interpolator cannot be null");
    }
    this.mInterpolator = paramInterpolator;
    invalidateSelf();
  }
  
  public void setMirrorMode(boolean paramBoolean)
  {
    if (this.mMirrorMode == paramBoolean) {
      return;
    }
    this.mMirrorMode = paramBoolean;
    invalidateSelf();
  }
  
  public void setReversed(boolean paramBoolean)
  {
    if (this.mReversed == paramBoolean) {
      return;
    }
    this.mReversed = paramBoolean;
    invalidateSelf();
  }
  
  public void setSectionsCount(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("SectionsCount must be > 0");
    }
    this.mSectionsCount = paramInt;
    this.mMaxOffset = (1.0F / this.mSectionsCount);
    this.mCurrentOffset %= this.mMaxOffset;
    invalidateSelf();
  }
  
  public void setSeparatorLength(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("SeparatorLength must be >= 0");
    }
    this.mSeparatorLength = paramInt;
    invalidateSelf();
  }
  
  public void setSpeed(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Speed must be >= 0");
    }
    this.mSpeed = paramFloat;
    invalidateSelf();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("The strokeWidth must be >= 0");
    }
    this.mPaint.setStrokeWidth(paramFloat);
    invalidateSelf();
  }
  
  public void start()
  {
    if (isRunning()) {
      return;
    }
    scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16L);
    invalidateSelf();
  }
  
  public void stop()
  {
    if (!isRunning()) {
      return;
    }
    this.mRunning = false;
    unscheduleSelf(this.mUpdater);
  }
  
  public static class Builder
  {
    private int[] mColors;
    private Interpolator mInterpolator;
    private boolean mMirrorMode;
    private boolean mReversed;
    private int mSectionsCount;
    private float mSpeed;
    private int mStrokeSeparatorLength;
    private float mStrokeWidth;
    
    public Builder(Context paramContext)
    {
      initValues(paramContext);
    }
    
    private void initValues(Context paramContext)
    {
      paramContext = paramContext.getResources();
      this.mInterpolator = new AccelerateInterpolator();
      this.mSectionsCount = paramContext.getInteger(R.integer.spb_default_sections_count);
      this.mColors = new int[] { paramContext.getColor(R.color.spb_default_color) };
      this.mSpeed = Float.parseFloat(paramContext.getString(R.string.spb_default_speed));
      this.mReversed = paramContext.getBoolean(R.bool.spb_default_reversed);
      this.mStrokeSeparatorLength = paramContext.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length);
      this.mStrokeWidth = paramContext.getDimensionPixelOffset(R.dimen.spb_default_stroke_width);
    }
    
    public SmoothProgressDrawable build()
    {
      return new SmoothProgressDrawable(this.mInterpolator, this.mSectionsCount, this.mStrokeSeparatorLength, this.mColors, this.mStrokeWidth, this.mSpeed, this.mReversed, this.mMirrorMode, null);
    }
    
    public Builder color(int paramInt)
    {
      this.mColors = new int[] { paramInt };
      return this;
    }
    
    public Builder colors(int[] paramArrayOfInt)
    {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
        throw new IllegalArgumentException("Your color array must not be empty");
      }
      this.mColors = paramArrayOfInt;
      return this;
    }
    
    public Builder interpolator(Interpolator paramInterpolator)
    {
      if (paramInterpolator == null) {
        throw new IllegalArgumentException("Interpolator can't be null");
      }
      this.mInterpolator = paramInterpolator;
      return this;
    }
    
    public Builder mirrorMode(boolean paramBoolean)
    {
      this.mMirrorMode = paramBoolean;
      return this;
    }
    
    public Builder reversed(boolean paramBoolean)
    {
      this.mReversed = paramBoolean;
      return this;
    }
    
    public Builder sectionsCount(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("SectionsCount must be > 0");
      }
      this.mSectionsCount = paramInt;
      return this;
    }
    
    public Builder separatorLength(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("SeparatorLength must be >= 0");
      }
      this.mStrokeSeparatorLength = paramInt;
      return this;
    }
    
    public Builder speed(float paramFloat)
    {
      if (paramFloat < 0.0F) {
        throw new IllegalArgumentException("Speed must be >= 0");
      }
      this.mSpeed = paramFloat;
      return this;
    }
    
    public Builder strokeWidth(float paramFloat)
    {
      if (paramFloat < 0.0F) {
        throw new IllegalArgumentException("The width must be >= 0");
      }
      this.mStrokeWidth = paramFloat;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/loading/SmoothProgressDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */