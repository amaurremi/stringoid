package com.vungle.publisher.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vungle.publisher.ch;
import com.vungle.publisher.ch.a;
import com.vungle.publisher.ch.a.a;
import com.vungle.publisher.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseHandler
  extends Handler
  implements ch, ch.a.a
{
  final ch.a a;
  final int b;
  final List<a> c = new ArrayList();
  int d;
  
  protected BaseHandler(Looper paramLooper, ch.a parama)
  {
    super(paramLooper);
    this.a = parama;
    this.b = 30;
  }
  
  private boolean a()
  {
    return (!hasMessages(1)) && (!hasMessages(-1));
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramInt);
    }
    getLooper().quit();
    localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  protected abstract void a(Message paramMessage);
  
  public final void a(a... paramVarArgs)
  {
    int i = 0;
    while (i <= 0)
    {
      a locala = paramVarArgs[0];
      this.c.add(locala);
      i += 1;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramInt1, paramInt2);
    }
    getLooper().quit();
    localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt1);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    try
    {
      if (paramMessage.what == -1)
      {
        if (!a()) {
          return;
        }
        this.a.b(this.d, this);
        return;
      }
      i = paramMessage.arg1;
      this.d = i;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).d(i);
      }
      a(paramMessage);
    }
    catch (Exception paramMessage)
    {
      Logger.e("VungleService", paramMessage);
      return;
    }
    paramMessage = this.c.iterator();
    while (paramMessage.hasNext()) {
      ((a)paramMessage.next()).e(i);
    }
    if (a())
    {
      sendEmptyMessageDelayed(-1, this.b * 1000);
      paramMessage = this.c.iterator();
      while (paramMessage.hasNext()) {
        ((a)paramMessage.next()).c(this.d);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void b(int paramInt);
    
    public abstract void b(int paramInt1, int paramInt2);
    
    public abstract void c(int paramInt);
    
    public abstract void d(int paramInt);
    
    public abstract void e(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/service/BaseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */