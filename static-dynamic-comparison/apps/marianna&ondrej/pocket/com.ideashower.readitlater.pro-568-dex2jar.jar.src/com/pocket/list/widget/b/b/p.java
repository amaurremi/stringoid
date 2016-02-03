package com.pocket.list.widget.b.b;

import android.content.res.Resources;
import android.graphics.Rect;
import com.pocket.list.widget.b;

public class p
  extends h
{
  public p(Resources paramResources, b paramb)
  {
    super(paramResources, paramb);
  }
  
  public boolean O()
  {
    return true;
  }
  
  protected float R()
  {
    return 0.9F;
  }
  
  public int T()
  {
    return 2;
  }
  
  protected void a(Rect paramRect)
  {
    paramRect.set(af() - this.a.getSingleSpaceWidth() - 0, 0, af() - 0, ad());
  }
  
  protected int ai()
  {
    return this.a.getSingleTileWidthMin();
  }
  
  protected int aj()
  {
    return this.a.getSingleTileWidthMax();
  }
  
  protected boolean ak()
  {
    return false;
  }
  
  protected void d(Rect paramRect)
  {
    paramRect.set(0, 0, this.a.getSingleSpaceWidth(), ad());
  }
  
  protected void f(Rect paramRect)
  {
    a(paramRect, 0.0F, 0.0F, Y(), 95.0F);
  }
  
  protected void g(Rect paramRect)
  {
    a(paramRect, 0.0F, 105.0F, Y(), 235.0F);
  }
  
  protected float x()
  {
    return 28.0F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */