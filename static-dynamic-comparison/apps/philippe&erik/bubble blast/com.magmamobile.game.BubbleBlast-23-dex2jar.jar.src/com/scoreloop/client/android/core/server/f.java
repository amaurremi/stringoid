package com.scoreloop.client.android.core.server;

import android.os.Handler;
import android.os.Message;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

class f
  extends Thread
  implements BayeuxConnectionObserver
{
  private static int i;
  private boolean b;
  private final Handler c;
  private a d;
  private Game e;
  private volatile Request f;
  private volatile a.a g;
  private volatile boolean h;
  
  static
  {
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      i = 0;
      return;
    }
  }
  
  f(Handler paramHandler)
  {
    this.c = paramHandler;
    this.h = true;
    paramHandler = new StringBuilder().append(getClass().getSimpleName());
    int j = i;
    i = j + 1;
    setName(j);
    setDaemon(true);
  }
  
  private void a(Response paramResponse, int paramInt, Exception paramException)
  {
    for (;;)
    {
      Message localMessage;
      try
      {
        this.f = null;
        this.g = null;
        localMessage = this.c.obtainMessage(paramInt);
        if (paramInt == 1)
        {
          localMessage.obj = paramResponse;
          localMessage.sendToTarget();
          return;
        }
      }
      finally {}
      localMessage.obj = paramException;
    }
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 43	com/scoreloop/client/android/core/server/f:h	Z
    //   7: aload_0
    //   8: getfield 79	com/scoreloop/client/android/core/server/f:g	Lcom/scoreloop/client/android/core/server/a$a;
    //   11: ifnull +17 -> 28
    //   14: aload_0
    //   15: getfield 79	com/scoreloop/client/android/core/server/f:g	Lcom/scoreloop/client/android/core/server/a$a;
    //   18: invokevirtual 100	com/scoreloop/client/android/core/server/a$a:a	()V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_0
    //   24: invokevirtual 103	com/scoreloop/client/android/core/server/f:join	()V
    //   27: return
    //   28: aload_0
    //   29: invokevirtual 106	java/lang/Object:notify	()V
    //   32: goto -11 -> 21
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	f
    //   35	4	1	localObject	Object
    //   40	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	21	35	finally
    //   21	23	35	finally
    //   28	32	35	finally
    //   36	38	35	finally
    //   23	27	40	java/lang/InterruptedException
  }
  
  void a(Game paramGame)
  {
    this.e = paramGame;
  }
  
  void a(Request paramRequest)
  {
    int j = 0;
    try
    {
      if (this.f != null) {
        throw new IllegalStateException("Previous request not finished yet");
      }
    }
    finally {}
    if (!paramRequest.k())
    {
      this.f = paramRequest;
      this.g = this.d.a();
      this.g.a(this.f.h(), this.f.a(), this.f.b(), this.f.g());
      notify();
    }
    for (;;)
    {
      if (j != 0)
      {
        Logger.a("ServerCommThread", "startRequest(): Request was cancelled early");
        a(null, 2, null);
      }
      return;
      j = 1;
    }
  }
  
  void a(a parama)
  {
    this.d = parama;
  }
  
  public void a(a parama, Integer paramInteger, Object paramObject, String paramString, int paramInt)
  {
    this.b = true;
    a(new Response(paramObject, paramString, paramInt, paramInteger), 1, null);
  }
  
  public void a(a parama, JSONObject paramJSONObject) {}
  
  public JSONObject b(a parama, JSONObject paramJSONObject)
  {
    try
    {
      if (this.e != null)
      {
        parama = paramJSONObject.getJSONObject("ext");
        JSONObject localJSONObject = new JSONObject();
        parama.put("game", localJSONObject);
        localJSONObject.put("id", this.e.getIdentifier());
        localJSONObject.put("secret", this.e.a());
        localJSONObject.put("version", this.e.getVersion());
      }
      return paramJSONObject;
    }
    catch (JSONException parama)
    {
      throw new IllegalStateException("Should never happen");
    }
  }
  
  void b()
  {
    Logger.a("ServerCommThread", "abortCurrentRequest() called");
    try
    {
      if (this.g != null) {
        this.g.a();
      }
      return;
    }
    finally {}
  }
  
  public void run()
  {
    Logger.a("ServerCommThread", "run(): entering loop");
    while (this.h)
    {
      try
      {
        try
        {
          if ((this.g == null) && (this.h)) {
            wait();
          }
          if (this.g == null) {
            continue;
          }
        }
        finally {}
      }
      catch (InterruptedException localInterruptedException)
      {
        Logger.a("ServerCommThread", "run(): interrupted while waiting for request");
      }
      try
      {
        Logger.a("ServerCommThread", "run(): got bayeux request to process");
        this.b = false;
        this.d.a(this.g);
        if ((!a) && (!this.b)) {
          throw new AssertionError();
        }
      }
      catch (c localc)
      {
        Logger.a("ServerCommThread", "run(): Request processing was interrupted\n" + localc);
        a(null, 2, localc);
      }
      catch (e locale)
      {
        Logger.a("ServerCommThread", "run(): publish() failed\n" + locale);
        a(null, 3, locale);
      }
      catch (Exception localException)
      {
        Logger.a("ServerCommThread", "run(): publish() failed\n" + localException);
        a(null, 3, localException);
      }
    }
    Logger.a("ServerCommThread", "run(): exitting loop");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/server/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */