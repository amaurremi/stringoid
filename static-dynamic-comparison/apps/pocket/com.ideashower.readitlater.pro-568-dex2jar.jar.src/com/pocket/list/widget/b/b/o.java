package com.pocket.list.widget.b.b;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ideashower.readitlater.util.j;
import com.pocket.list.widget.b;

public class o
  extends n
{
  public o(Resources paramResources, b paramb)
  {
    super(paramResources, paramb);
  }
  
  public boolean N()
  {
    return true;
  }
  
  protected void a(RectF paramRectF)
  {
    a(paramRectF, 6.0F, 4.5F, 6.0F + 18.0F, 18.0F + 4.5F);
  }
  
  public boolean am()
  {
    return true;
  }
  
  protected void b(Rect paramRect)
  {
    super.b(paramRect);
    paramRect.top = 0;
  }
  
  protected void d(Rect paramRect)
  {
    a(paramRect, 0.0F, 72.0F, ag(), 152.0F);
  }
  
  protected void f(Rect paramRect)
  {
    super.f(paramRect);
    paramRect.top = (j.a(38.0F) + paramRect.top);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */