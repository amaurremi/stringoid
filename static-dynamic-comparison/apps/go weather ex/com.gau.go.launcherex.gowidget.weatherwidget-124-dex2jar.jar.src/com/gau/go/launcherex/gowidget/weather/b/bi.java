package com.gau.go.launcherex.gowidget.weather.b;

import android.os.AsyncTask;
import com.gtp.a.a.b.c;
import com.jiubang.goweather.a.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bi
  extends AsyncTask
{
  private bi(bg parambg) {}
  
  protected ArrayList a(bj... paramVarArgs)
  {
    Object localObject1 = paramVarArgs[0];
    paramVarArgs = new ArrayList();
    localObject1 = bj.a((bj)localObject1);
    int i = 0;
    while (i < ((ArrayList)localObject1).size())
    {
      Object localObject2 = ((com.jiubang.goweather.a.a)((ArrayList)localObject1).get(i)).m;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          f localf = (f)((Iterator)localObject2).next();
          int k = localf.a();
          int j = 0;
          while (j < k)
          {
            com.jiubang.goweather.a.g localg = localf.a(j);
            String str = com.jiubang.core.c.a.g.a(localg.c);
            File localFile = new File(com.gtp.a.a.b.a.c);
            c.a("WeatherHandler", localFile.getPath());
            if (!new File(localFile.getPath() + File.separator + str + ".png").exists()) {
              paramVarArgs.add(new com.jiubang.core.c.a.a(localg.c, localFile.getPath(), str + ".png"));
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    return paramVarArgs;
  }
  
  protected void a(ArrayList paramArrayList)
  {
    super.onPostExecute(paramArrayList);
    if (paramArrayList.size() > 0)
    {
      com.jiubang.core.c.a.g localg = com.jiubang.core.c.a.g.a(bg.a(this.a));
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localg.a((com.jiubang.core.c.a.a)paramArrayList.next());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */