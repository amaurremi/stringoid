package com.vungle.publisher;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.vungle.publisher.db.DatabaseHelper;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.service.DownloadIntentHandlerFactory;
import com.vungle.publisher.service.ExternalHttpIntentHandlerFactory;
import com.vungle.publisher.service.PrepareLocalAdIntentHandler;
import com.vungle.publisher.service.PrepareLocalAdIntentHandler.Factory;
import com.vungle.publisher.service.ProtocolIntentHandlerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;

public class VungleService
  extends Service
{
  public static final String ACTIVITY_EVENT_EXTRA_KEY = "activityEvent";
  public static final String ACTIVITY_PAUSE = "activityPause";
  public static final String ACTIVITY_PAUSE_SECONDS_EXTRA_KEY = "activityPauseSeconds";
  public static final String ACTIVITY_RESUME = "activityResume";
  public static final String AD_ID_EXTRA_KEY = "adId";
  public static final String DOWNLOAD_ACTION;
  public static final String DOWNLOAD_ACTION_SHORT_NAME = "DOWNLOAD";
  public static final String EXTERNAL_REQUEST_ACTION = g + ".HTTP";
  public static final String EXTERNAL_REQUEST_ACTION_SHORT_NAME = "HTTP";
  public static final String HTTP_TRANSACTION_EXTRA_KEY = "transaction";
  public static final String PREPARE_AD_ACTION;
  public static final String PREPARE_AD_ACTION_SHORT_NAME = "PREPARE_AD";
  public static final String PROTOCOL_ACTION = g + ".PROTOCOL";
  public static final String PROTOCOL_ACTION_SHORT_NAME = "PROTOCOL";
  public static final String SESSION_EVENT_ACTION = g + ".SESSION";
  public static final String SESSION_EVENT_ACTION_SHORT_NAME = "SESSION";
  public static final String SESSION_START_SECONDS_EXTRA_KEY = "sessionStartSeconds";
  public static final String VIEWABLE_SIZE_EXTRA_KEY = "viewableSize";
  public static final String VIEWABLE_TYPE_EXTRA_KEY = "viewableType";
  private static final String g = VungleService.class.getName();
  final String a = getClass().getSimpleName();
  @Inject
  DownloadIntentHandlerFactory b;
  @Inject
  ExternalHttpIntentHandlerFactory c;
  @Inject
  PrepareLocalAdIntentHandler.Factory d;
  @Inject
  ProtocolIntentHandlerFactory e;
  @Inject
  DatabaseHelper f;
  private final a h = new a();
  
  static
  {
    DOWNLOAD_ACTION = g + ".DOWNLOAD";
    PREPARE_AD_ACTION = g + ".PREPARE_AD";
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    throw new UnsupportedOperationException();
  }
  
  public void onCreate()
  {
    try
    {
      super.onCreate();
      Injector.getInstance().a.a(this);
      a locala = this.h;
      locala.a.put(DOWNLOAD_ACTION, new VungleService.a.a(locala));
      locala.a.put(EXTERNAL_REQUEST_ACTION, new VungleService.a.b(locala));
      locala.a.put(PREPARE_AD_ACTION, new VungleService.a.d(locala));
      locala.a.put(PROTOCOL_ACTION, new VungleService.a.e(locala));
      locala.a.put(SESSION_EVENT_ACTION, new VungleService.a.f(locala));
      return;
    }
    catch (Exception localException)
    {
      Logger.e("VungleService", localException);
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    if (paramIntent != null) {}
    try
    {
      a locala = this.h;
      String str = paramIntent.getAction();
      localg = (VungleService.a.g)locala.a.get(str);
      if (localg == null)
      {
        locala.a(paramInt);
        throw new IllegalArgumentException("unknown action: " + str);
      }
    }
    catch (IllegalArgumentException paramIntent)
    {
      VungleService.a.g localg;
      Logger.w("VungleService", paramIntent.getMessage());
      return;
      localg.b(paramInt);
      localg.f.a(paramInt);
      localg.d.a(paramIntent, paramInt);
      return;
    }
    catch (Exception paramIntent)
    {
      Logger.e("VungleService", paramIntent);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return 2;
  }
  
  final class a
  {
    final Map<String, g> a = new HashMap();
    volatile int b;
    
    a() {}
    
    final void a(int paramInt)
    {
      Logger.v("VungleService", VungleService.this.a + " service last task ID: " + paramInt);
      this.b = paramInt;
    }
    
    final class a
      extends VungleService.a.h
    {
      a()
      {
        super("DOWNLOAD");
      }
      
      final void a()
      {
        this.d = VungleService.this.b.a(this.c, new ce.a[] { this });
      }
    }
    
    final class b
      extends VungleService.a.h
    {
      b()
      {
        super("HTTP");
      }
      
      final void a()
      {
        this.d = VungleService.this.c.a(this.c, new ce.a[] { this });
      }
    }
    
    abstract class c
      extends VungleService.a.g
    {
      c(String paramString)
      {
        super(paramString);
      }
      
      public final void a(int paramInt)
      {
        cn localcn = this.e;
        localcn.b();
        ci.a(0);
        int i;
        int j;
        do
        {
          i = localcn.b.get();
          j = ci.a(i, 0);
        } while (!localcn.b.compareAndSet(i, j));
        Logger.d("VungleService", this.c + " service forced shutdown: received last task ID" + paramInt + ", actual last task ID: " + this.e.b.get());
        d(VungleService.a.this.b);
      }
      
      final void b(int paramInt)
      {
        cn localcn = this.e;
        localcn.a(paramInt);
        localcn.b();
        int i;
        int j;
        do
        {
          i = localcn.b.get();
          j = localcn.a(paramInt, ci.a(i, 1));
        } while (!localcn.b.compareAndSet(i, j));
      }
    }
    
    final class d
      extends VungleService.a.h
    {
      d()
      {
        super("PREPARE_AD");
      }
      
      final void a()
      {
        PrepareLocalAdIntentHandler.Factory localFactory = VungleService.this.d;
        PrepareLocalAdIntentHandler localPrepareLocalAdIntentHandler = new PrepareLocalAdIntentHandler(this.c);
        localPrepareLocalAdIntentHandler.f = localFactory.a;
        localPrepareLocalAdIntentHandler.g = localFactory.b;
        localPrepareLocalAdIntentHandler.h = localFactory.c;
        localPrepareLocalAdIntentHandler.i = localFactory.d;
        localPrepareLocalAdIntentHandler.j = localFactory.e;
        localPrepareLocalAdIntentHandler.a(new ce.a[] { this });
        this.d = localPrepareLocalAdIntentHandler;
      }
    }
    
    final class e
      extends VungleService.a.h
    {
      e()
      {
        super("PROTOCOL");
      }
      
      final void a()
      {
        this.d = VungleService.this.e.a(this.c, new ce.a[] { this });
      }
    }
    
    final class f
      extends VungleService.a.c
    {
      f()
      {
        super("SESSION");
      }
      
      final void a()
      {
        this.d = new cg(this.c);
        this.d.a(new ce.a[] { this });
      }
    }
    
    abstract class g
      implements ce.a
    {
      final String c;
      ce d;
      final cn e = new cn();
      
      g(String paramString)
      {
        this.c = (VungleService.this.a + "[" + paramString + "]");
        a();
      }
      
      abstract void a();
      
      abstract void b(int paramInt);
      
      public final void c(int paramInt)
      {
        int i = VungleService.a.this.b;
        if (this.e.a(paramInt, 0, false))
        {
          d(i);
          return;
        }
        Logger.d("VungleService", this.c + " subservice shutdown ignored: received token " + paramInt + ", expected token " + this.e.a());
      }
      
      final void d(int paramInt)
      {
        Object localObject = VungleService.a.this;
        ArrayList localArrayList = new ArrayList();
        localObject = ((VungleService.a)localObject).a.values().iterator();
        label102:
        while (((Iterator)localObject).hasNext())
        {
          g localg = (g)((Iterator)localObject).next();
          cn localcn = localg.e;
          localcn.b();
          if ((localcn.b.get() & 0x1) != 0) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label102;
            }
            localArrayList.add(localg.c);
            break;
          }
        }
        if (localArrayList.isEmpty())
        {
          Logger.d("VungleService", this.c + " sending " + VungleService.this.a + " shutdown signal: " + paramInt);
          if (VungleService.this.stopSelfResult(paramInt))
          {
            Logger.i("VungleService", this.c + " " + VungleService.this.a + " shutdown");
            return;
          }
          Logger.d("VungleService", this.c + " " + VungleService.this.a + " shutdown ignored: received token " + paramInt + ", expected token " + VungleService.a.this.b);
          return;
        }
        Logger.d("VungleService", this.c + " " + VungleService.this.a + " shutdown ignored: " + localArrayList + " still running");
      }
    }
    
    abstract class h
      extends VungleService.a.g
    {
      h(String paramString)
      {
        super(paramString);
      }
      
      public final void a(int paramInt)
      {
        int i = VungleService.a.this.b;
        for (;;)
        {
          int j = this.e.a();
          int k = j - paramInt;
          if (k != 0) {}
          for (boolean bool = true; this.e.a(j, k, bool); bool = false)
          {
            Logger.d("VungleService", this.c + " " + VungleService.this.a + " forced shutdown: current number of tasks " + k);
            if (!bool) {
              d(i);
            }
            return;
          }
        }
      }
      
      final void b(int paramInt)
      {
        cn localcn = this.e;
        if ((localcn.c() & 0x1) != 1) {
          throw new IllegalArgumentException("bit array has out of range bits set: 1 (max bits: " + localcn.a + ")");
        }
        int i;
        do
        {
          paramInt = localcn.b.get();
          i = localcn.a((paramInt >>> localcn.a) + 1, 1);
        } while (!localcn.b.compareAndSet(paramInt, i));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/VungleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */