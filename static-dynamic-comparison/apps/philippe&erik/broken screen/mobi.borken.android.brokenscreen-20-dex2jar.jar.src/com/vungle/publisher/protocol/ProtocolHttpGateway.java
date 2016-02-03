package com.vungle.publisher.protocol;

import android.os.SystemClock;
import com.vungle.publisher.VungleService;
import com.vungle.publisher.ai;
import com.vungle.publisher.aj;
import com.vungle.publisher.ak;
import com.vungle.publisher.bh;
import com.vungle.publisher.bu;
import com.vungle.publisher.env.SdkConfig;
import com.vungle.publisher.inject.annotations.RequestConfigHttpTransaction;
import com.vungle.publisher.inject.annotations.RequestLocalAdHttpTransaction;
import com.vungle.publisher.inject.annotations.TrackInstallHttpTransaction;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.reporting.AdServiceReportingHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class ProtocolHttpGateway
  extends bu
{
  @Inject
  PrepareLocalAdEventListener a;
  @Inject
  public ReportAdHttpTransactionFactory d;
  @RequestConfigHttpTransaction
  @Inject
  HttpTransaction e;
  @RequestLocalAdHttpTransaction
  @Inject
  Provider<HttpTransaction> f;
  @Inject
  public RequestStreamingAdHttpTransactionFactory g;
  @Inject
  public SessionEndHttpTransactionFactory h;
  @Inject
  public SessionStartHttpTransactionFactory i;
  @TrackInstallHttpTransaction
  @Inject
  public Provider<HttpTransaction> j;
  @Inject
  UnfilledAdHttpTransactionFactory k;
  @Inject
  AdServiceReportingHandler l;
  private AtomicBoolean m = new AtomicBoolean();
  
  protected final String a()
  {
    return VungleService.PROTOCOL_ACTION;
  }
  
  protected final String b()
  {
    return "VungleProtocol";
  }
  
  public final void c()
  {
    a(this.e);
  }
  
  public final void d()
  {
    if (this.m.compareAndSet(false, true))
    {
      this.l.a = SystemClock.elapsedRealtime();
      this.a.b();
      a((HttpTransaction)this.f.get());
      return;
    }
    Logger.d("VungleProtocol", "request ad already in progress");
  }
  
  public final void e()
  {
    UnfilledAdHttpTransactionFactory localUnfilledAdHttpTransactionFactory = this.k;
    long l1 = System.currentTimeMillis() / 1000L;
    a(new HttpTransaction(localUnfilledAdHttpTransactionFactory.a.a(l1), localUnfilledAdHttpTransactionFactory.b));
  }
  
  @Singleton
  static class PrepareLocalAdEventListener
    extends bh
  {
    @Inject
    SdkConfig a;
    @Inject
    Provider<ProtocolHttpGateway> b;
    
    private void a(boolean paramBoolean)
    {
      d();
      ProtocolHttpGateway localProtocolHttpGateway = (ProtocolHttpGateway)this.b.get();
      ProtocolHttpGateway.a(localProtocolHttpGateway).set(false);
      if (paramBoolean) {
        localProtocolHttpGateway.d();
      }
    }
    
    public void onEvent(ai paramai)
    {
      a(false);
    }
    
    public void onEvent(aj paramaj)
    {
      a(true);
    }
    
    public void onEvent(ak paramak)
    {
      d();
      ProtocolHttpGateway.a((ProtocolHttpGateway)this.b.get()).set(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ProtocolHttpGateway.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */