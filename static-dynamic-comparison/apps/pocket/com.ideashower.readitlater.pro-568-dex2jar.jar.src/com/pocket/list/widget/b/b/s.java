package com.pocket.list.widget.b.b;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ideashower.readitlater.util.j;
import com.pocket.list.widget.b;

public class s
  extends r
{
  public s(Resources paramResources, b paramb)
  {
    super(paramResources, paramb);
  }
  
  public boolean N()
  {
    return true;
  }
  
  protected void a(RectF paramRectF)
  {
    a(paramRectF, 11.0F, 4.5F, 11.0F + 19.0F, 19.0F + 4.5F);
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
    super.d(paramRect);
    paramRect.top += j.a(10.5F);
  }
  
  protected void f(Rect paramRect)
  {
    super.f(paramRect);
    paramRect.top += j.a(39.0F);
    paramRect.bottom += j.a(15.0F);
  }
  
  protected void j(Rect paramRect)
  {
    super.j(paramRect);
    paramRect.left -= j.a(3.5F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */