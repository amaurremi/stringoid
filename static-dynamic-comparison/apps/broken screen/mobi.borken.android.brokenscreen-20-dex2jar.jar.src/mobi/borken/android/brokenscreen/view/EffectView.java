package mobi.borken.android.brokenscreen.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

public class EffectView
  extends View
{
  private int bitmapId = -1;
  private Bitmap bmp;
  private int opacity;
  private Paint paint;
  private Xfermode xfermode;
  
  public EffectView(Context paramContext)
  {
    super(paramContext);
    setup(paramContext);
  }
  
  public EffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setup(paramContext);
  }
  
  public EffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setup(paramContext);
  }
  
  private void applyBitmap()
  {
    if ((getWidth() > 0) && (getHeight() > 0)) {}
    try
    {
      localBitmap1 = BitmapFactory.decodeResource(getContext().getResources(), this.bitmapId);
      float f1 = getWidth() / localBitmap1.getWidth();
      float f2 = getHeight() / localBitmap1.getHeight();
      localMatrix = new Matrix();
      localMatrix.setScale(f1, f2);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          Bitmap localBitmap1;
          this.bmp = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), localMatrix, false);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Matrix localMatrix;
          Bitmap localBitmap2;
          if (this.bmp == null) {
            continue;
          }
          this.bmp.recycle();
          System.gc();
          this.bmp = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), localMatrix, false);
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        System.gc();
        localBitmap2 = BitmapFactory.decodeResource(getContext().getResources(), this.bitmapId);
      }
    }
  }
  
  private boolean hasBitmap()
  {
    return this.bitmapId > 0;
  }
  
  private void setup(Context paramContext)
  {
    this.paint = new Paint();
    this.paint.setFilterBitmap(false);
    this.paint.setAlpha(this.opacity);
    this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DARKEN);
    this.paint.setXfermode(this.xfermode);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0);
    if (hasBitmap())
    {
      paramCanvas.drawBitmap(this.bmp, 0.0F, 0.0F, this.paint);
      this.paint.setXfermode(null);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (hasBitmap())) {
      applyBitmap();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBitmapResourceId(int paramInt)
  {
    this.bitmapId = paramInt;
    applyBitmap();
  }
  
  public void setOpacity(float paramFloat)
  {
    this.opacity = ((int)(2.55F * paramFloat));
    if (this.paint != null) {
      this.paint.setAlpha(this.opacity);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/brokenscreen/view/EffectView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */