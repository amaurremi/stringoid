package mobi.beyondpod.ui.views.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class AlbumView
  extends RelativeLayout
{
  Animation _FadeInAnimation;
  Animation _FadeOutAnimation;
  private Bitmap mBit;
  private Paint mCoverPaint;
  private Bitmap mPending;
  
  public AlbumView(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  public AlbumView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    this.mCoverPaint = new Paint();
    this.mCoverPaint.setAntiAlias(true);
    this.mCoverPaint.setFilterBitmap(true);
    this.mCoverPaint.setDither(true);
    this.mCoverPaint.setAlpha(255);
    this._FadeOutAnimation = AnimationUtils.loadAnimation(getContext(), 2130968583);
    this._FadeInAnimation = AnimationUtils.loadAnimation(getContext(), 2130968582);
    this._FadeOutAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AlbumView.this.startAnimation(AlbumView.this._FadeInAnimation);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this._FadeInAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AlbumView.this.switchToNewBitmap();
      }
    });
  }
  
  private Bitmap AddReflection(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (Math.max(i, j) / Math.min(i, j) > 1.2D) {}
    int k;
    do
    {
      return paramBitmap;
      float f = getResources().getInteger(2131361811) / 100.0F;
      k = (int)(j * f);
    } while (k < 10);
    int m = paramBitmap.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).preScale(1.0F, -1.0F);
    try
    {
      localObject = Bitmap.createBitmap(paramBitmap, 0, m - k, i, k, (Matrix)localObject, false);
      Bitmap localBitmap = Bitmap.createBitmap(i, j + k, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      Paint localPaint = new Paint();
      localPaint.setColor(0);
      localCanvas.drawRect(0.0F, j, i, j + 4, localPaint);
      localCanvas.drawBitmap((Bitmap)localObject, 0.0F, j + 4, null);
      localPaint = new Paint();
      localPaint.setShader(new LinearGradient(0.0F, paramBitmap.getHeight(), 0.0F, localBitmap.getHeight() + 4, 1895825407, 16777215, Shader.TileMode.CLAMP));
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      localCanvas.drawRect(0.0F, j, i, localBitmap.getHeight() + 4, localPaint);
      ((Bitmap)localObject).recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      CoreHelper.WriteTraceEntry("AlbumView", "Unable to draw image reflection! OutOfMemoryError");
    }
    return paramBitmap;
  }
  
  private void drawArtwork(Canvas paramCanvas)
  {
    if (this.mBit == null) {
      return;
    }
    paramCanvas.save();
    int k = getWidth() - getPaddingLeft() - getPaddingRight();
    int m = getHeight() - getPaddingTop() - getPaddingBottom();
    float f2 = this.mBit.getWidth();
    float f1 = this.mBit.getHeight();
    float f3 = f2 / f1;
    int j = k;
    int n = (int)(j / f3);
    int i = n;
    if (n > m)
    {
      i = m;
      j = (int)(i * f3);
    }
    f2 = j / f2;
    f1 = i / f1;
    paramCanvas.translate(getPaddingLeft() + (k - j) / 2, getPaddingTop() + (m - i) / 2);
    paramCanvas.scale(f2, f1);
    paramCanvas.drawBitmap(this.mBit, 0.0F, 0.0F, this.mCoverPaint);
    paramCanvas.restore();
  }
  
  private void switchToNewBitmap()
  {
    try
    {
      clearBitmap();
      if (this.mPending != null)
      {
        this.mBit = this.mPending;
        this.mPending = null;
      }
      invalidate();
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException("AlbumView", "Failed to set Artwork Image", localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      CoreHelper.WriteLogEntry("AlbumView", "Failed to set Artwork Image. OutOfMemoryError!");
    }
  }
  
  public void clearBitmap()
  {
    if (this.mBit != null)
    {
      this.mBit.recycle();
      this.mBit = null;
    }
  }
  
  public boolean hasBitmap()
  {
    return this.mBit != null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    drawArtwork(paramCanvas);
  }
  
  @TargetApi(12)
  public void setArtwork(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((this.mBit == null) && (paramBitmap == null)) {}
    while ((CoreHelper.ApiLevel() > 11) && (paramBitmap != null) && (paramBitmap.sameAs(this.mBit))) {
      return;
    }
    this.mPending = paramBitmap;
    if (CoreHelper.ApiLevel() > 7)
    {
      this._FadeOutAnimation.cancel();
      this._FadeOutAnimation.reset();
      this._FadeInAnimation.cancel();
      this._FadeInAnimation.reset();
    }
    if ((!paramBoolean) || (this.mBit == null))
    {
      switchToNewBitmap();
      return;
    }
    startAnimation(this._FadeOutAnimation);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/AlbumView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */