package com.ideashower.readitlater.reader.twitter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.ideashower.readitlater.views.ImageRequestView;

public class TwitterAvatarImageView
  extends ImageRequestView
{
  private final RectF a = new RectF();
  private final PorterDuffXfermode b = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
  
  public TwitterAvatarImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TwitterAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TwitterAvatarImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getDrawable();
    if (localObject == null) {
      return;
    }
    localObject = ((BitmapDrawable)localObject).getPaint();
    int i = paramCanvas.saveLayer(this.a, null, 31);
    paramCanvas.drawRoundRect(this.a, 5.0F, 5.0F, (Paint)localObject);
    Xfermode localXfermode = ((Paint)localObject).getXfermode();
    ((Paint)localObject).setXfermode(this.b);
    super.onDraw(paramCanvas);
    ((Paint)localObject).setXfermode(localXfermode);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.set(0.0F, 0.0F, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/twitter/TwitterAvatarImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */