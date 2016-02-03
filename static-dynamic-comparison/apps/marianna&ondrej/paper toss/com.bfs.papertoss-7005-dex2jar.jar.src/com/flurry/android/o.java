package com.flurry.android;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

final class o
  extends RelativeLayout
{
  private u a;
  private Context b;
  private String c;
  private int d;
  private boolean e;
  private boolean f;
  
  o(u paramu, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.a = paramu;
    this.b = paramContext;
    this.c = paramString;
    this.d = paramInt;
  }
  
  private static RelativeLayout.LayoutParams b()
  {
    return new RelativeLayout.LayoutParams(-1, -1);
  }
  
  private y c()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.a.a(this.b, Arrays.asList(new String[] { this.c }), null, this.d, false);
        if (!((List)localObject1).isEmpty())
        {
          localObject1 = (y)((List)localObject1).get(0);
          ((y)localObject1).setOnClickListener(this.a);
          return (y)localObject1;
        }
      }
      finally
      {
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      Object localObject3 = null;
    }
  }
  
  final void a()
  {
    Object localObject;
    if (!this.e)
    {
      localObject = c();
      if (localObject == null) {
        break label61;
      }
      removeAllViews();
      addView((View)localObject, b());
      ((y)localObject).a().a(new f((byte)3, this.a.j()));
      this.e = true;
    }
    for (;;)
    {
      this.f = true;
      return;
      label61:
      if (!this.f)
      {
        localObject = new TextView(this.b);
        ((TextView)localObject).setText(u.b);
        ((TextView)localObject).setTextSize(1, 20.0F);
        addView((View)localObject, b());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */