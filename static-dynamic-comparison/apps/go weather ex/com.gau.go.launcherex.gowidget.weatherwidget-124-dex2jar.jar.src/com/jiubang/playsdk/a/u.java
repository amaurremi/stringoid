package com.jiubang.playsdk.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.jiubang.playsdk.e.f;
import com.jiubang.playsdk.main.s;
import java.util.List;

public class u
  implements Runnable
{
  private k a;
  private int b;
  private Handler c;
  private com.jiubang.playsdk.e.d d;
  private Context e;
  
  public u(Context paramContext, k paramk, int paramInt)
  {
    this.e = paramContext;
    this.a = paramk;
    this.b = paramInt;
    this.c = new v(this);
  }
  
  private com.jiubang.playsdk.e.d a(long paramLong, int paramInt)
  {
    com.jiubang.playsdk.e.c localc = null;
    Object localObject2 = null;
    Object localObject1 = localc;
    int i;
    if (aa.a().c(f.b(paramLong, 1, 2, 0)))
    {
      Object localObject3 = aa.a().a(f.b(paramLong, 1, 2, 0));
      localObject1 = localc;
      if (localObject3 != null)
      {
        localObject1 = localc;
        if (((com.jiubang.playsdk.e.d)localObject3).i() == 1)
        {
          localObject3 = ((com.jiubang.playsdk.e.d)localObject3).e();
          localObject1 = localc;
          if (localObject3 != null)
          {
            localObject1 = localc;
            if (((List)localObject3).size() > 0)
            {
              i = 0;
              localObject1 = localObject2;
              if (i < ((List)localObject3).size())
              {
                localc = (com.jiubang.playsdk.e.c)((List)localObject3).get(i);
                if ((localc == null) || (!localc.a(paramInt))) {
                  break label201;
                }
                localObject2 = aa.a().a(f.b(localc.a(), 1, 2, 0));
                localObject1 = localObject2;
                if (localObject2 != null)
                {
                  localObject1 = localObject2;
                  if (((com.jiubang.playsdk.e.d)localObject2).i() == 1)
                  {
                    localObject1 = a(localc.a(), paramInt);
                    if (localObject1 == null) {
                      break label238;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return (com.jiubang.playsdk.e.d)localObject1;
      label201:
      localObject1 = a(localc.a(), paramInt);
      if (localObject1 != null) {}
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        localObject1 = localObject2;
      }
      label238:
      localObject1 = localObject2;
    }
  }
  
  public void a()
  {
    com.jiubang.playsdk.c.d.a(this);
  }
  
  public void run()
  {
    com.jiubang.playsdk.e.d locald2 = a(0L, this.b);
    com.jiubang.playsdk.e.d locald1 = locald2;
    if (locald2 == null)
    {
      Object localObject = aa.a().b();
      locald1 = locald2;
      if (localObject != null)
      {
        localObject = ((com.jiubang.playsdk.main.c)localObject).a(this.e, new s("", this.b));
        locald1 = locald2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          locald1 = new com.jiubang.playsdk.e.d();
          locald1.a((String)localObject);
        }
      }
    }
    this.d = locald1;
    this.c.sendEmptyMessage(1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */