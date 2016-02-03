package com.android.ex.chips;

import android.os.AsyncTask;
import android.os.Handler;
import android.text.Spannable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class o
  extends AsyncTask
{
  protected o(n paramn) {}
  
  protected Void a(Object... paramVarArgs)
  {
    Object localObject = (ArrayList)paramVarArgs[0];
    paramVarArgs = new ArrayList();
    int i = 0;
    final z localz;
    while (i < ((ArrayList)localObject).size())
    {
      localz = (z)((ArrayList)localObject).get(i);
      if (localz != null) {
        paramVarArgs.add(n.a(this.a, localz.e()));
      }
      i += 1;
    }
    paramVarArgs = x.a(this.a.getContext(), paramVarArgs);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localz = (z)((Iterator)localObject).next();
      if ((aa.a(localz.e().d())) && (this.a.getSpannable().getSpanStart(localz) != -1))
      {
        final aa localaa = this.a.b((aa)paramVarArgs.get(this.a.a(localz.e().c()).toLowerCase()));
        if (localaa != null) {
          this.a.g.post(new Runnable()
          {
            public void run()
            {
              o.this.a.a(localz, localaa);
            }
          });
        }
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */