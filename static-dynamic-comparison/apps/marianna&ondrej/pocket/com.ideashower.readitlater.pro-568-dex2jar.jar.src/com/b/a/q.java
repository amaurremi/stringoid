package com.b.a;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

class q
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    ArrayList localArrayList1 = (ArrayList)p.j().get();
    ArrayList localArrayList2 = (ArrayList)p.k().get();
    int i;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = (ArrayList)p.l().get();
      if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0)) {
        i = 0;
      }
      break;
    }
    for (;;)
    {
      int k = i;
      Object localObject;
      int j;
      p localp;
      if (paramMessage.size() > 0)
      {
        localObject = (ArrayList)paramMessage.clone();
        paramMessage.clear();
        k = ((ArrayList)localObject).size();
        j = 0;
        if (j < k)
        {
          localp = (p)((ArrayList)localObject).get(j);
          if (p.a(localp) == 0L) {
            p.b(localp);
          }
          for (;;)
          {
            j += 1;
            break;
            localArrayList2.add(localp);
          }
          k = 1;
        }
      }
      else
      {
        long l = AnimationUtils.currentAnimationTimeMillis();
        localObject = (ArrayList)p.m().get();
        paramMessage = (ArrayList)p.n().get();
        j = localArrayList2.size();
        i = 0;
        while (i < j)
        {
          localp = (p)localArrayList2.get(i);
          if (p.a(localp, l)) {
            ((ArrayList)localObject).add(localp);
          }
          i += 1;
        }
        j = ((ArrayList)localObject).size();
        if (j > 0)
        {
          i = 0;
          while (i < j)
          {
            localp = (p)((ArrayList)localObject).get(i);
            p.b(localp);
            p.a(localp, true);
            localArrayList2.remove(localp);
            i += 1;
          }
          ((ArrayList)localObject).clear();
        }
        i = localArrayList1.size();
        j = 0;
        if (j < i)
        {
          localObject = (p)localArrayList1.get(j);
          if (((p)localObject).d(l)) {
            paramMessage.add(localObject);
          }
          int m;
          if (localArrayList1.size() == i)
          {
            m = j + 1;
            j = i;
            i = m;
          }
          for (;;)
          {
            m = j;
            j = i;
            i = m;
            break;
            paramMessage.remove(localObject);
            m = i - 1;
            i = j;
            j = m;
          }
        }
        if (paramMessage.size() > 0)
        {
          i = 0;
          while (i < paramMessage.size())
          {
            p.c((p)paramMessage.get(i));
            i += 1;
          }
          paramMessage.clear();
        }
        if ((k == 0) || ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty()))) {
          break;
        }
        sendEmptyMessageDelayed(1, Math.max(0L, p.o() - (AnimationUtils.currentAnimationTimeMillis() - l)));
        return;
        i = 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */