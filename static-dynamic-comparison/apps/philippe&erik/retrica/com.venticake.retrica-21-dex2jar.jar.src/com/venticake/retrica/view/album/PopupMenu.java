package com.venticake.retrica.view.album;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.SystemClock;
import android.text.TextPaint;
import android.view.MotionEvent;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL11;

@SuppressLint({"NewApi"})
public final class PopupMenu
  extends Layer
{
  private static final IconTitleDrawable.Config ICON_TITLE_CONFIG;
  private static final int ICON_TITLE_MIN_WIDTH = 100;
  private static final int PADDING_BOTTOM = 40;
  private static final int PADDING_LEFT = 15;
  private static final int PADDING_RIGHT = 15;
  private static final int PADDING_TOP = 13;
  private static final int POPUP_TRIANGLE_EXTRA_HEIGHT = 14;
  private static final int POPUP_TRIANGLE_X_MARGIN = 16;
  private static final int POPUP_Y_OFFSET = 20;
  private static final Paint SRC_PAINT = new Paint();
  private PopupMenu.Listener mListener = null;
  private boolean mNeedsLayout = false;
  private PopupMenu.Option[] mOptions = new PopupMenu.Option[0];
  private PopupMenu.PopupTexture mPopupTexture;
  private int mRowHeight = 36;
  private int mSelectedItem = -1;
  private boolean mShow = false;
  private final FloatAnim mShowAnim = new FloatAnim(0.0F);
  
  static
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(17.0F * Gallery.PIXEL_DENSITY);
    localTextPaint.setColor(-1);
    localTextPaint.setAntiAlias(true);
    ICON_TITLE_CONFIG = new IconTitleDrawable.Config((int)(45.0F * Gallery.PIXEL_DENSITY), (int)(34.0F * Gallery.PIXEL_DENSITY), localTextPaint);
    SRC_PAINT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
  }
  
  public PopupMenu(Context paramContext)
  {
    this.mPopupTexture = new PopupMenu.PopupTexture(this, paramContext);
    setHidden(true);
  }
  
  private int hitTestOptions(int paramInt1, int paramInt2)
  {
    PopupMenu.Option[] arrayOfOption = this.mOptions;
    int i = arrayOfOption.length;
    paramInt1 = (int)(paramInt1 - this.mX);
    int j = (int)(paramInt2 - this.mY);
    if ((i != 0) && (paramInt1 >= 0) && (paramInt1 < this.mWidth) && (j >= 0)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 == i) {
        paramInt2 = -1;
      }
      do
      {
        return paramInt2;
        paramInt2 = paramInt1;
      } while (j < PopupMenu.Option.access$6(arrayOfOption[paramInt1]));
      paramInt1 += 1;
    }
  }
  
  private void layout()
  {
    this.mNeedsLayout = false;
    PopupMenu.Option[] arrayOfOption = this.mOptions;
    int m = arrayOfOption.length;
    int i = (int)(100.0F * Gallery.PIXEL_DENSITY);
    int j = 0;
    int k;
    int n;
    int i1;
    label68:
    IconTitleDrawable localIconTitleDrawable;
    Object localObject;
    if (j == m)
    {
      k = (int)(this.mRowHeight * Gallery.PIXEL_DENSITY);
      n = (int)(Gallery.PIXEL_DENSITY * 15.0F);
      j = (int)(13.0F * Gallery.PIXEL_DENSITY);
      i1 = n + i;
      i = 0;
      if (i == m) {
        setSize(i1 + Gallery.PIXEL_DENSITY * 15.0F, j + 40.0F * Gallery.PIXEL_DENSITY);
      }
    }
    else
    {
      PopupMenu.Option localOption = arrayOfOption[j];
      localIconTitleDrawable = PopupMenu.Option.access$0(localOption);
      localObject = localIconTitleDrawable;
      if (localIconTitleDrawable == null)
      {
        localObject = new IconTitleDrawable(PopupMenu.Option.access$2(localOption), PopupMenu.Option.access$3(localOption), ICON_TITLE_CONFIG);
        PopupMenu.Option.access$4(localOption, (IconTitleDrawable)localObject);
      }
      k = ((IconTitleDrawable)localObject).getIntrinsicWidth();
      if (k <= i) {
        break label216;
      }
      i = k;
    }
    label216:
    for (;;)
    {
      j += 1;
      break;
      localObject = arrayOfOption[i];
      localIconTitleDrawable = PopupMenu.Option.access$0((PopupMenu.Option)localObject);
      PopupMenu.Option.access$5((PopupMenu.Option)localObject, j + k);
      localIconTitleDrawable.setBounds(n, j, i1, PopupMenu.Option.access$6((PopupMenu.Option)localObject));
      j += k;
      i += 1;
      break label68;
    }
  }
  
  private void setSelectedItem(int paramInt)
  {
    if (this.mSelectedItem != paramInt)
    {
      this.mSelectedItem = paramInt;
      this.mPopupTexture.setNeedsDraw();
      if (this.mListener != null) {
        this.mListener.onSelectionChanged(this, paramInt);
      }
    }
  }
  
  public void close(boolean paramBoolean)
  {
    if (this.mShow)
    {
      if (!paramBoolean) {
        break label35;
      }
      this.mShowAnim.animateValue(0.0F, 0.3F, SystemClock.uptimeMillis());
    }
    for (;;)
    {
      this.mShow = false;
      this.mSelectedItem = -1;
      return;
      label35:
      this.mShowAnim.setValue(0.0F);
    }
  }
  
  public void generate(RenderView paramRenderView, RenderView.Lists paramLists)
  {
    paramLists.blendedList.add(this);
    paramLists.hitTestList.add(this);
    paramLists.systemList.add(this);
    paramLists.updateList.add(this);
  }
  
  protected void onSizeChanged()
  {
    super.onSizeChanged();
    this.mPopupTexture.setSize((int)this.mWidth, (int)this.mHeight);
  }
  
  protected void onSurfaceCreated(RenderView paramRenderView, GL11 paramGL11)
  {
    close(false);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = hitTestOptions((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      setSelectedItem(i);
      continue;
      if ((i != -1) && (this.mSelectedItem == i))
      {
        PopupMenu.Option.access$1(this.mOptions[i]).run();
        if (this.mListener != null) {
          this.mListener.onSelectionClicked(this, i);
        }
      }
      setSelectedItem(-1);
    }
  }
  
  public void renderBlended(RenderView paramRenderView, GL11 paramGL11)
  {
    float f2 = this.mShowAnim.getValue(SystemClock.uptimeMillis());
    boolean bool = this.mShow;
    if ((f2 < 0.003F) && (!bool)) {
      setHidden(true);
    }
    int i = (int)this.mX;
    int j = (int)this.mY;
    float f1;
    if ((bool) && (f2 < 1.0F)) {
      if (f2 < 0.7F)
      {
        f1 = 0.8F + 0.3F * f2 / 0.7F;
        this.mPopupTexture.drawWithEffect(paramRenderView, paramGL11, i, j, 0.5F, 0.65F, f2, f1);
      }
    }
    do
    {
      return;
      f1 = 1.0F + (1.0F - f2) / (1.0F - 0.7F) * 0.1F;
      break;
      if (f2 < 1.0F) {
        paramRenderView.setAlpha(f2);
      }
      this.mPopupTexture.draw(paramRenderView, paramGL11, i, j);
    } while (f2 >= 1.0F);
    paramRenderView.resetColor();
  }
  
  public void setListener(PopupMenu.Listener paramListener)
  {
    this.mListener = paramListener;
  }
  
  public void setOptions(PopupMenu.Option[] paramArrayOfOption)
  {
    close(false);
    this.mOptions = paramArrayOfOption;
    this.mNeedsLayout = true;
  }
  
  public void showAtPoint(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mNeedsLayout) {
      layout();
    }
    paramInt4 = (int)this.mWidth;
    int i = (int)this.mHeight;
    int j = paramInt4 / 2;
    paramInt1 -= j;
    paramInt3 = Shared.clamp(paramInt1, 0, paramInt3 - paramInt4);
    int k = PopupMenu.PopupTexture.access$0(this.mPopupTexture).getWidth() / 2;
    PopupMenu.PopupTexture.access$1(this.mPopupTexture, Shared.clamp(j + (paramInt1 - paramInt3) - k, 16, paramInt4 - 32));
    this.mPopupTexture.setNeedsDraw();
    setPosition(paramInt3, paramInt2 + 20 - i);
    this.mShow = true;
    setHidden(false);
    this.mShowAnim.setValue(0.0F);
    this.mShowAnim.animateValue(1.0F, 0.4F, SystemClock.uptimeMillis());
  }
  
  public boolean update(RenderView paramRenderView, float paramFloat)
  {
    return this.mShowAnim.getTimeRemaining(SystemClock.uptimeMillis()) > 0.0F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/PopupMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */