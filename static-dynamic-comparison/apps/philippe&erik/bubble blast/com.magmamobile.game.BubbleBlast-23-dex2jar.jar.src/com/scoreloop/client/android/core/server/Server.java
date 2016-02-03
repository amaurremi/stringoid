package com.scoreloop.client.android.core.server;

import android.os.Handler;
import android.os.Message;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.utils.Base64;
import com.scoreloop.client.android.core.utils.Logger;
import java.net.URL;
import java.nio.channels.IllegalSelectorException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class Server
{
  private final URL b;
  private final f c;
  private final a d;
  private a e;
  private Request f;
  private final LinkedList<Request> g;
  
  static
  {
    if (!Server.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public Server(URL paramURL)
  {
    this.b = paramURL;
    this.g = new LinkedList();
    this.d = new a(null);
    this.c = new f(this.d);
    this.c.setPriority(1);
    Object localObject;
    try
    {
      localObject = MessageDigest.getInstance("SHA1");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update("https://api.scoreloop.com/bayeux/android/v2".getBytes());
      paramURL = ((MessageDigest)localObject).digest();
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update("https://www.scoreloop.com/android/updates".getBytes());
      localObject = ((MessageDigest)localObject).digest();
      byte[] arrayOfByte = new byte[16];
      i = 0;
      while (i < arrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)(paramURL[((i + 6) % paramURL.length)] ^ localObject[((i + 3) % localObject.length)] ^ 0x3E));
        i += 1;
      }
      this.e = new a(b(), this.c, arrayOfByte);
    }
    catch (NoSuchAlgorithmException paramURL)
    {
      throw new IllegalStateException();
    }
    int i = 0;
    while (i < paramURL.length)
    {
      paramURL[i] = ((byte)(paramURL[i] ^ 0x1A));
      i += 1;
    }
    this.e.b(Base64.a(paramURL));
    i = j;
    while (i < localObject.length)
    {
      localObject[i] = ((byte)(localObject[i] ^ 0x35));
      i += 1;
    }
    this.e.a(Base64.a((byte[])localObject));
    this.c.a(this.e);
    this.c.start();
  }
  
  private void c()
  {
    if (this.f != null)
    {
      Logger.a("Server", "doCancelCurrentRequest canceling request: " + this.f.toString());
      this.f.l();
      this.f.e().a(this.f);
      this.c.b();
    }
  }
  
  private void c(Request paramRequest)
  {
    Logger.a("Server", "startProcessingRequest: " + paramRequest.toString());
    if ((!a) && (paramRequest == null)) {
      throw new AssertionError();
    }
    if ((!a) && (paramRequest.k())) {
      throw new AssertionError();
    }
    if ((!a) && (this.f != null)) {
      throw new AssertionError();
    }
    this.f = paramRequest;
    this.f.e().b(this.f);
    this.f.n();
    this.c.a(this.f);
  }
  
  private void d()
  {
    Object localObject2 = new StringBuilder().append("currentRequest: ");
    if (this.f != null) {}
    for (Object localObject1 = this.f.toString();; localObject1 = "null")
    {
      Logger.a("dumpQueue: ", (String)localObject1);
      localObject1 = this.g.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Request)((Iterator)localObject1).next();
        Logger.a("dumpQueue: ", localObject2.toString() + ", " + ((Request)localObject2).j().toString());
      }
    }
  }
  
  private void e()
  {
    if ((!a) && (this.f != null)) {
      throw new AssertionError();
    }
    Request localRequest;
    do
    {
      localRequest = (Request)this.g.poll();
      if ((localRequest != null) && (!localRequest.k()))
      {
        c(localRequest);
        return;
      }
    } while (localRequest != null);
  }
  
  public void a()
  {
    this.c.a();
  }
  
  public void a(Game paramGame)
  {
    this.c.a(paramGame);
  }
  
  public void a(Request paramRequest)
  {
    Logger.a("Server", "addRequest: " + paramRequest.toString());
    if ((paramRequest.j() == Request.State.ENQUEUED) || (paramRequest.j() == Request.State.EXECUTING)) {
      throw new IllegalStateException("Request already enqueued or executing");
    }
    if (paramRequest.a() == null) {
      throw new IllegalStateException("Request channel is not set");
    }
    if (paramRequest.c() == null) {
      throw new IllegalStateException("Request method is not set");
    }
    if (paramRequest.g() == null) {
      paramRequest.a(new JSONObject());
    }
    try
    {
      paramRequest.g().put("method", paramRequest.c().toString());
      if ((this.f == null) && (this.g.isEmpty()))
      {
        c(paramRequest);
        return;
      }
    }
    catch (JSONException paramRequest)
    {
      throw new IllegalSelectorException();
    }
    paramRequest.m();
    this.g.add(paramRequest);
  }
  
  URL b()
  {
    return this.b;
  }
  
  public void b(Request paramRequest)
  {
    Logger.a("Server", "cancelRequest: " + paramRequest.toString());
    if (this.f == paramRequest)
    {
      c();
      return;
    }
    paramRequest.l();
    paramRequest.e().a(paramRequest);
  }
  
  protected void finalize()
    throws Throwable
  {
    a();
    super.finalize();
  }
  
  private class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      Request localRequest = Server.a(Server.this);
      Server.a(Server.this, null);
      Integer localInteger;
      if (localRequest.j() != Request.State.CANCELLED) {
        switch (paramMessage.what)
        {
        default: 
          throw new IllegalStateException("Unknown message type");
        case 1: 
          paramMessage = (Response)paramMessage.obj;
          localInteger = paramMessage.b();
          if ((localInteger != null) && (localInteger.intValue() == localRequest.h())) {
            localRequest.a(paramMessage);
          }
          break;
        }
      }
      for (;;)
      {
        localRequest.e().a(localRequest);
        Server.b(Server.this);
        if (Server.a(Server.this) == null) {
          Server.c(Server.this);
        }
        return;
        localRequest.a(new Exception("Invalid response ID, expected:" + localRequest.h() + ", but was:" + localInteger));
        continue;
        localRequest.a((Exception)paramMessage.obj);
        continue;
        localRequest.a((Exception)paramMessage.obj);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/server/Server.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */