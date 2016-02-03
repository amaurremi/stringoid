package com.pocket.list.widget.b;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.pocket.list.widget.b.b.b;

class c
{
  private b b;
  private com.pocket.list.widget.b.c.c c;
  private final Rect d = new Rect();
  private final TextPaint e = new TextPaint();
  
  private c(a parama) {}
  
  private void c(int[] paramArrayOfInt)
  {
    Spanned localSpanned;
    if ((this.c != null) && ((this.c.b().getText() instanceof Spanned)))
    {
      localSpanned = (Spanned)this.c.b().getText();
      if (this.b.f == null) {
        break label75;
      }
      com.pocket.text.c.a(this.b.f.getColorForState(paramArrayOfInt, 0), localSpanned);
    }
    for (;;)
    {
      com.pocket.text.c.a(this.b.g, localSpanned);
      return;
      label75:
      com.pocket.text.c.a(localSpanned);
    }
  }
  
  public void a(b paramb)
  {
    this.b = paramb;
    this.d.set(paramb.b);
    paramb.a(this.e);
  }
  
  public void a(com.pocket.list.widget.b.c.c paramc)
  {
    this.c = paramc;
    a(this.a.getDrawableState());
  }
  
  public void a(int[] paramArrayOfInt)
  {
    b(paramArrayOfInt);
    c(paramArrayOfInt);
  }
  
  public void b(int[] paramArrayOfInt)
  {
    if (this.c == null) {
      return;
    }
    if (!a.a(this.a))
    {
      int i = this.b.c.getColorForState(paramArrayOfInt, 0);
      this.e.setColor(Color.argb(102, Color.red(i), Color.green(i), Color.blue(i)));
      return;
    }
    this.e.setColor(this.b.c.getColorForState(paramArrayOfInt, 0));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */