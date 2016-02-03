package uk.co.senab.photoview.b;

import android.content.Context;
import android.widget.Scroller;

public class c
  extends d
{
  private Scroller a;
  
  public c(Context paramContext)
  {
    this.a = new Scroller(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.forceFinished(paramBoolean);
  }
  
  public boolean a()
  {
    return this.a.computeScrollOffset();
  }
  
  public boolean b()
  {
    return this.a.isFinished();
  }
  
  public int c()
  {
    return this.a.getCurrX();
  }
  
  public int d()
  {
    return this.a.getCurrY();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */