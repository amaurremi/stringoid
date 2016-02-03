package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

class l
  extends Handler
{
  WeakReference a;
  
  public l(i parami)
  {
    this.a = new WeakReference(parami);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    i locali = (i)this.a.get();
    if (locali == null) {}
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramMessage.what != 1) {
                  break;
                }
                paramMessage = (Object[])paramMessage.obj;
                localObject1 = (String)paramMessage[0];
                localObject2 = (z)paramMessage[1];
              } while (((Integer)paramMessage[2]).intValue() != i.a(locali));
              locali.a.remove(localObject1);
              locali.b.put(localObject1, localObject2);
            } while (i.b(locali) != locali.b.size());
            locali.a.clear();
            locali.a.putAll(locali.b);
            locali.b.clear();
            if (i.c(locali))
            {
              i.a(locali, 5);
              i.a(locali, false);
            }
            i.d(locali).sendBroadcast(new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_LOADING_FINISH"));
            return;
            if (paramMessage.what != 2) {
              break;
            }
            paramMessage = (Object[])paramMessage.obj;
            localObject1 = (String)paramMessage[0];
            localObject2 = (z)paramMessage[1];
          } while (((Integer)paramMessage[2]).intValue() != i.a(locali));
          locali.a.put(localObject1, localObject2);
          paramMessage = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_ONE_RELOAD_DONE");
          i.d(locali).sendBroadcast(paramMessage);
          return;
          ExecutorService localExecutorService;
          if (paramMessage.what == 0)
          {
            paramMessage = i.b(locali, i.e(locali));
            i.b(locali, paramMessage.size());
            i.c(locali, 0);
            localObject1 = paramMessage.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              localExecutorService = i.f(locali);
              locali.getClass();
              localExecutorService.execute(new n(locali, i.d(locali), (String)localObject2, i.a(locali), true, false));
            }
            paramMessage.clear();
            return;
          }
          if (paramMessage.what == 3)
          {
            paramMessage = i.b(locali, i.e(locali));
            i.b(locali, paramMessage.size());
            i.c(locali, 3);
            localObject1 = paramMessage.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              localExecutorService = i.f(locali);
              locali.getClass();
              localExecutorService.execute(new n(locali, i.d(locali), (String)localObject2, i.a(locali), true, true));
            }
            paramMessage.clear();
            return;
          }
        } while (paramMessage.what != 4);
        localObject1 = (Object[])paramMessage.obj;
        paramMessage = (String)localObject1[0];
        localObject2 = (z)localObject1[1];
      } while (((Integer)localObject1[2]).intValue() != i.a(locali));
      locali.b.put(paramMessage, localObject2);
      locali.a.remove(paramMessage);
      Object localObject1 = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_BACKGROUND_CHANGE_FINISH");
      ((Intent)localObject1).putExtra("extra_background_loaded", paramMessage);
      i.d(locali).sendBroadcast((Intent)localObject1);
    } while (i.b(locali) != locali.b.size());
    locali.a.clear();
    locali.a.putAll(locali.b);
    locali.b.clear();
    paramMessage = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_ALL_SCRIPT_DONE");
    i.d(locali).sendBroadcast(paramMessage);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */