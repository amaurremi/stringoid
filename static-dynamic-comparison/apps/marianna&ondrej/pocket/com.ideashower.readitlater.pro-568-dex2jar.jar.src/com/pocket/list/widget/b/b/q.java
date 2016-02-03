package com.pocket.list.widget.b.b;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.d;
import com.pocket.list.widget.b;

public class q
  extends p
{
  public q(Resources paramResources, b paramb)
  {
    super(paramResources, paramb);
  }
  
  public boolean N()
  {
    return true;
  }
  
  protected void a(RectF paramRectF)
  {
    a(paramRectF, 10.5F, 4.5F, 10.5F + 19.0F, 19.0F + 4.5F);
    paramRectF.left += V().left;
    paramRectF.right += V().left;
  }
  
  public void a(d paramd)
  {
    super.a(paramd);
    Rect localRect = paramd.getBounds();
    paramd.setBounds(this.a.getSingleSpaceWidth() + j.a(0.5F), localRect.top, af(), localRect.bottom);
    paramd.a(j.a(24.0F));
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
  
  protected void f(Rect paramRect)
  {
    super.f(paramRect);
    paramRect.top += j.a(39.0F);
    paramRect.bottom += j.a(15.0F);
  }
  
  protected void g(Rect paramRect)
  {
    super.g(paramRect);
    paramRect.top += j.a(20.0F);
  }
  
  protected void j(Rect paramRect)
  {
    super.j(paramRect);
    paramRect.left -= j.a(5.5F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */