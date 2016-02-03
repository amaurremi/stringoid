package com.jiubang.playsdk.imageload;

import android.content.Context;
import com.jiubang.playsdk.g.k;
import com.jiubang.playsdk.main.b;
import java.io.File;

public class a
  implements Runnable
{
  public long a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      int j = paramFile.length;
      long l1 = 0L;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l2 = a(paramFile[i]);
        i += 1;
        l1 = l2 + l1;
      }
    }
    long l2 = paramFile.length();
    return l2;
  }
  
  public void a(Context paramContext)
  {
    paramContext = new k(paramContext, "request_info");
    long l1 = paramContext.b("image_cache_time_id", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 14400000L)
    {
      paramContext.a("image_cache_time_id", l2);
      paramContext.a();
      paramContext = new Thread(this);
      paramContext.setName("DeleteLocalImageCacheRunable");
      paramContext.start();
    }
  }
  
  public void run()
  {
    Object localObject1 = new File(b.d);
    if ((((File)localObject1).exists()) && (a((File)localObject1) >= 209715200L))
    {
      localObject1 = ((File)localObject1).listFiles();
      int i = 0;
      while (i < localObject1.length / 2)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          ((File)localObject2).delete();
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/imageload/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */