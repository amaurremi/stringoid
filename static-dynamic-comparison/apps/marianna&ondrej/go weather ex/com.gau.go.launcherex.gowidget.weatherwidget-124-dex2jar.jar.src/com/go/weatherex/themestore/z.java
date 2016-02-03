package com.go.weatherex.themestore;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.gau.go.launcherex.goweather.goplay.q;

class z
  extends AsyncTask
{
  z(u paramu) {}
  
  protected SparseArray a(Void... paramVarArgs)
  {
    paramVarArgs = new SparseArray(3);
    paramVarArgs.put(1, u.l(this.a).a(u.k(this.a), 1));
    paramVarArgs.put(2, u.l(this.a).a(u.k(this.a), 2));
    paramVarArgs.put(3, u.l(this.a).a(u.k(this.a), 3));
    return paramVarArgs;
  }
  
  protected void a(SparseArray paramSparseArray)
  {
    u.m(this.a).clear();
    int j = paramSparseArray.size();
    int i = 0;
    while (i < j)
    {
      u.m(this.a).put(paramSparseArray.keyAt(i), paramSparseArray.valueAt(i));
      i += 1;
    }
    u.a(this.a, u.m(this.a));
    u.d(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */