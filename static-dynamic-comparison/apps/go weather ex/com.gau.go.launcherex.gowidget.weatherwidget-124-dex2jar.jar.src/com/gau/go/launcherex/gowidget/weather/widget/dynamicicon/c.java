package com.gau.go.launcherex.gowidget.weather.widget.dynamicicon;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.scriptengine.parser.ae;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class c
  extends AsyncTask
{
  private c(a parama) {}
  
  protected d a(d... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if ((!TextUtils.isEmpty(paramVarArgs.c)) && (!TextUtils.isEmpty(paramVarArgs.g)))
    {
      if (paramVarArgs.b == null) {
        paramVarArgs.b = new ae(a.a(this.a)).b(paramVarArgs.c, paramVarArgs.g);
      }
      if (paramVarArgs.b != null) {
        paramVarArgs.a = new com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.a(paramVarArgs.b, a.a(this.a), paramVarArgs.g, a.b(this.a), a.c(this.a)).a(paramVarArgs.g);
      }
    }
    return paramVarArgs;
  }
  
  protected void a(d paramd)
  {
    if (paramd.h != null) {
      paramd.h.a(paramd.h, paramd.a, paramd.d, paramd.e, paramd.f);
    }
    a.a(this.a, paramd.b, paramd.c);
    a.d(this.a).remove(paramd.c);
    Object localObject = new ArrayList();
    Iterator localIterator = a.e(this.a).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.c.equals(paramd.c))
      {
        locald.a = paramd.a;
        ((ArrayList)localObject).add(locald);
      }
    }
    paramd = ((ArrayList)localObject).iterator();
    while (paramd.hasNext())
    {
      localObject = (d)paramd.next();
      a.e(this.a).remove(localObject);
      if (((d)localObject).h != null) {
        ((d)localObject).h.a(((d)localObject).h, ((d)localObject).a, ((d)localObject).d, ((d)localObject).e, ((d)localObject).f);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/widget/dynamicicon/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */