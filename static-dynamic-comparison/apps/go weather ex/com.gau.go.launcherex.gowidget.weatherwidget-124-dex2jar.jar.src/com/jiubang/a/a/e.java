package com.jiubang.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.a.a.a;
import com.a.a.s;

public class e
  extends d
{
  private long b = 160L;
  private long c = 420L;
  private float d = 50.0F;
  private long e = 0L;
  
  public e(BaseAdapter paramBaseAdapter)
  {
    this(paramBaseAdapter, 160L, 420L, 50.0F);
  }
  
  public e(BaseAdapter paramBaseAdapter, long paramLong1, long paramLong2, float paramFloat)
  {
    super(paramBaseAdapter);
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramFloat;
  }
  
  protected long a()
  {
    return this.b;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    this.e = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramFloat;
  }
  
  protected long b()
  {
    return this.c;
  }
  
  protected a b(ViewGroup paramViewGroup, View paramView)
  {
    return s.a(paramView, "translationY", new float[] { this.d, 0.0F });
  }
  
  protected long c()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */