package com.gtp.go.weather.sharephoto.photo;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.go.weather.sharephoto.b.a.d;
import com.gtp.go.weather.sharephoto.b.e;
import com.gtp.go.weather.sharephoto.b.g;
import com.gtp.go.weather.sharephoto.b.p;
import java.util.ArrayList;
import java.util.Iterator;

class am
  extends AsyncTask
{
  private ak b;
  private aj c;
  
  public am(ad paramad, aj paramaj)
  {
    this.b = new ak(paramad);
    this.c = paramaj;
  }
  
  private void a(aj paramaj)
  {
    this.c = paramaj;
  }
  
  private void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (!paramArrayList1.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList1 = paramArrayList1.iterator();
      for (;;)
      {
        if (!paramArrayList1.hasNext()) {
          break label92;
        }
        e locale = (e)paramArrayList1.next();
        Iterator localIterator = paramArrayList2.iterator();
        if (localIterator.hasNext())
        {
          g localg = (g)localIterator.next();
          if (locale.f() != localg.a()) {
            break;
          }
          localArrayList.add(locale);
        }
      }
      label92:
      d.a(ad.b(this.a), localArrayList);
    }
  }
  
  protected ArrayList a(Integer... paramVarArgs)
  {
    this.b.b = paramVarArgs[0].intValue();
    paramVarArgs = new ArrayList();
    Object localObject;
    if (this.b.b == 0)
    {
      localArrayList = new ArrayList();
      paramVarArgs = (ArrayList)ad.g(this.a);
      if (!paramVarArgs.isEmpty()) {
        localArrayList.addAll(p.a(paramVarArgs));
      }
      localObject = ad.a(this.a, 0).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new p((g)((Iterator)localObject).next()));
      }
      publishProgress(new ArrayList[] { localArrayList });
    }
    ArrayList localArrayList = new ArrayList();
    if ((r.c(ad.b(this.a))) && (ad.a(this.a, this.b)))
    {
      localObject = ad.a(this.a, this.b.b);
      a(paramVarArgs, (ArrayList)localObject);
      if (localObject != null)
      {
        if (!((ArrayList)localObject).isEmpty()) {
          break label200;
        }
        this.b.c = 1;
      }
    }
    return localArrayList;
    label200:
    this.a.a((ArrayList)localObject);
    if ((this.b.a == 0) || (this.b.a == 1)) {}
    for (this.b.c = 1;; this.b.c = ad.c(this.a, (ArrayList)localObject))
    {
      paramVarArgs = ((ArrayList)localObject).iterator();
      while (paramVarArgs.hasNext()) {
        localArrayList.add(new p((g)paramVarArgs.next()));
      }
      break;
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    ad.a().remove(this.b.b);
    this.c.a(this.b.c, paramArrayList);
  }
  
  protected void a(ArrayList... paramVarArgs)
  {
    this.c.a(paramVarArgs[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */