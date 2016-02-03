package com.jiubang.playsdk.views;

import android.content.Context;
import android.os.AsyncTask;
import com.jiubang.playsdk.a.a.b;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.main.c;
import java.util.ArrayList;
import java.util.List;

class t
  extends AsyncTask
{
  private Context b;
  
  public t(MineView paramMineView, Context paramContext)
  {
    this.b = paramContext;
  }
  
  protected List a(Void... paramVarArgs)
  {
    paramVarArgs = new ArrayList();
    c localc = aa.a().b();
    Object localObject = localc.n();
    if (localObject != null)
    {
      localObject = ((b)localObject).b();
      int i = 0;
      while (i < localObject.length)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = localc.a(this.b, localObject[i]);
        if (localArrayList2 != null)
        {
          localArrayList1.addAll(localArrayList2);
          localArrayList1.add(null);
          paramVarArgs.add(localArrayList1);
        }
        i += 1;
      }
    }
    return paramVarArgs;
  }
  
  protected void a(List paramList)
  {
    if (MineView.a(this.a) != null) {
      MineView.a(this.a).setVisibility(8);
    }
    MineView.a(this.a, paramList);
  }
  
  protected void onPreExecute()
  {
    if (MineView.a(this.a) != null) {
      MineView.a(this.a).setVisibility(0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */