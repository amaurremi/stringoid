package com.pocket.list.widget.b.c;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.ideashower.readitlater.util.j;

public class c
{
  public final int a;
  public final int b;
  private final StaticLayout c;
  
  public c(CharSequence paramCharSequence, Rect paramRect, TextPaint paramTextPaint, float paramFloat, int paramInt)
  {
    this.a = paramRect.left;
    this.b = paramRect.top;
    float f;
    if (paramInt > 0)
    {
      f = paramTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length()) + j.a(2.0F);
      if (f <= paramInt) {
        break label117;
      }
    }
    StaticLayout localStaticLayout;
    label117:
    for (paramRect.right = (paramRect.left + paramInt);; paramRect.right = ((int)(f + paramRect.left)))
    {
      localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, paramRect.right - paramRect.left, Layout.Alignment.ALIGN_NORMAL, paramFloat, 0.0F, false);
      if (paramRect.bottom != -2) {
        break label170;
      }
      if (localStaticLayout.getLineCount() > 1) {
        break;
      }
      this.c = localStaticLayout;
      return;
    }
    this.c = new StaticLayout(a(paramCharSequence, localStaticLayout, 0), paramTextPaint, paramRect.right - paramRect.left, Layout.Alignment.ALIGN_NORMAL, paramFloat, 0.0F, false);
    return;
    label170:
    int i = paramRect.bottom - paramRect.top;
    if ((paramRect.bottom == -1) || (localStaticLayout.getLineTop(localStaticLayout.getLineCount()) < i))
    {
      this.c = localStaticLayout;
      return;
    }
    paramInt = localStaticLayout.getLineCount() - 1;
    if (paramInt > 0) {
      if (localStaticLayout.getLineTop(paramInt) < i) {
        paramInt -= 1;
      }
    }
    for (;;)
    {
      this.c = new StaticLayout(a(paramCharSequence, localStaticLayout, paramInt), paramTextPaint, paramRect.right - paramRect.left, Layout.Alignment.ALIGN_NORMAL, paramFloat, 0.0F, false);
      return;
      paramInt -= 1;
      break;
      paramInt = 0;
    }
  }
  
  public int a()
  {
    return this.b + this.c.getLineTop(this.c.getLineCount());
  }
  
  protected CharSequence a(CharSequence paramCharSequence, StaticLayout paramStaticLayout, int paramInt)
  {
    return paramCharSequence.subSequence(0, paramStaticLayout.getLineEnd(paramInt));
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.a, this.b);
    this.c.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public StaticLayout b()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */