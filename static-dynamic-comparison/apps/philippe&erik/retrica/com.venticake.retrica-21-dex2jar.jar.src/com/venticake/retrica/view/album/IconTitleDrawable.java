package com.venticake.retrica.view.album;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public final class IconTitleDrawable
  extends Drawable
{
  private final IconTitleDrawable.Config mConfig;
  private final Drawable mIcon;
  private final String mTitle;
  private StaticLayout mTitleLayout = null;
  private final int mTitleWidth;
  private int mTitleY;
  
  public IconTitleDrawable(String paramString, Drawable paramDrawable, IconTitleDrawable.Config paramConfig)
  {
    this.mTitle = paramString;
    this.mTitleWidth = ((int)StaticLayout.getDesiredWidth(this.mTitle, IconTitleDrawable.Config.access$0(paramConfig)));
    this.mIcon = paramDrawable;
    this.mConfig = paramConfig;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.mIcon;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    int i = getBounds().left + IconTitleDrawable.Config.access$1(this.mConfig);
    int j = this.mTitleY;
    paramCanvas.translate(i, j);
    this.mTitleLayout.draw(paramCanvas);
    paramCanvas.translate(-i, -j);
  }
  
  public int getIntrinsicHeight()
  {
    IconTitleDrawable.Config localConfig = this.mConfig;
    return Math.max(IconTitleDrawable.Config.access$2(localConfig), IconTitleDrawable.Config.access$0(localConfig).getFontMetricsInt(null));
  }
  
  public int getIntrinsicWidth()
  {
    return IconTitleDrawable.Config.access$1(this.mConfig) + this.mTitleWidth + 15;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int m = paramRect.left;
    int i = paramRect.top;
    int k = paramRect.right;
    int j = paramRect.bottom - i;
    paramRect = this.mConfig;
    m += IconTitleDrawable.Config.access$3(paramRect);
    int n = IconTitleDrawable.Config.access$2(paramRect);
    Object localObject = this.mIcon;
    if (localObject != null) {
      ((Drawable)localObject).setBounds(m, (j - n) / 2 + i, m + n, n + i);
    }
    k -= IconTitleDrawable.Config.access$1(paramRect);
    localObject = this.mTitle;
    this.mTitleLayout = new StaticLayout((CharSequence)localObject, 0, ((String)localObject).length(), IconTitleDrawable.Config.access$0(paramRect), k, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true, TextUtils.TruncateAt.MIDDLE, k);
    this.mTitleY = ((j - this.mTitleLayout.getHeight()) / 2 + i);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/IconTitleDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */