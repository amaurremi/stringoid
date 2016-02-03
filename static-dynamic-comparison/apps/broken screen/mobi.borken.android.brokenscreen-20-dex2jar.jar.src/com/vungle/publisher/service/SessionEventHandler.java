package com.vungle.publisher.service;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.vungle.publisher.bo;
import com.vungle.publisher.cg.a;
import com.vungle.publisher.ch.a;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.ProtocolHttpGateway;
import com.vungle.publisher.protocol.SessionEndHttpTransactionFactory;
import com.vungle.publisher.protocol.SessionStartHttpTransactionFactory;
import java.util.Collection;
import java.util.Iterator;
import javax.inject.Inject;
import org.json.JSONException;

public class SessionEventHandler
  extends BaseHandler
{
  @Inject
  ProtocolHttpGateway e;
  @Inject
  Collection<cg.a> f;
  
  public SessionEventHandler(Looper paramLooper, ch.a parama)
  {
    super(paramLooper, parama);
    Injector.getInstance().a.a(this);
  }
  
  protected final void a(Message paramMessage)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = (String)paramMessage.obj;
        if ("activityResume".equals(localObject))
        {
          paramMessage = paramMessage.getData();
          if (!paramMessage.containsKey("sessionStartSeconds")) {
            break label283;
          }
          paramMessage = Long.valueOf(paramMessage.getLong("sessionStartSeconds"));
          if (paramMessage == null)
          {
            Logger.d("VungleService", "processing session continuation");
            Logger.d("VungleService", "removing activityPause messages from queue");
            removeMessages(1, "activityPause");
            return;
          }
          Logger.d("VungleService", "processing session start");
          localObject = this.e;
          l1 = paramMessage.longValue();
          ((ProtocolHttpGateway)localObject).a(((ProtocolHttpGateway)localObject).i.a(l1));
          continue;
        }
        if (!"activityPause".equals(localObject)) {
          break label260;
        }
      }
      catch (JSONException paramMessage)
      {
        throw new bo(paramMessage);
      }
      Logger.d("VungleService", "processing session end");
      paramMessage = paramMessage.getData();
      long l1 = paramMessage.getLong("sessionStartSeconds");
      long l2 = paramMessage.getLong("activityPauseSeconds");
      paramMessage = this.e;
      paramMessage.a(paramMessage.h.a(l1, l2));
      if ((this.f != null) && (!this.f.isEmpty()))
      {
        Logger.d("VungleService", "notifying " + this.f.size() + " session end listeners");
        paramMessage = this.f.iterator();
        while (paramMessage.hasNext())
        {
          ((cg.a)paramMessage.next()).a(l1);
          continue;
          label260:
          Logger.w("VungleService", "unknown activity event in message: " + (String)localObject);
        }
      }
      return;
      label283:
      paramMessage = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/service/SessionEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */