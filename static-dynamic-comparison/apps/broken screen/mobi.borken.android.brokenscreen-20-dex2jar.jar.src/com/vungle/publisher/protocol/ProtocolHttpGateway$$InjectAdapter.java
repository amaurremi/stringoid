package com.vungle.publisher.protocol;

import com.vungle.publisher.bu;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.reporting.AdServiceReportingHandler;
import java.util.Set;
import javax.inject.Provider;

public final class ProtocolHttpGateway$$InjectAdapter
  extends cs<ProtocolHttpGateway>
  implements cp<ProtocolHttpGateway>, Provider<ProtocolHttpGateway>
{
  private cs<ProtocolHttpGateway.PrepareLocalAdEventListener> a;
  private cs<ReportAdHttpTransactionFactory> b;
  private cs<HttpTransaction> c;
  private cs<Provider<HttpTransaction>> d;
  private cs<RequestStreamingAdHttpTransactionFactory> e;
  private cs<SessionEndHttpTransactionFactory> f;
  private cs<SessionStartHttpTransactionFactory> g;
  private cs<Provider<HttpTransaction>> h;
  private cs<UnfilledAdHttpTransactionFactory> i;
  private cs<AdServiceReportingHandler> j;
  private cs<bu> k;
  
  public ProtocolHttpGateway$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.ProtocolHttpGateway", "members/com.vungle.publisher.protocol.ProtocolHttpGateway", true, ProtocolHttpGateway.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.ProtocolHttpGateway$PrepareLocalAdEventListener", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.ReportAdHttpTransactionFactory", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.c = paramcy.a("@com.vungle.publisher.inject.annotations.RequestConfigHttpTransaction()/com.vungle.publisher.net.http.HttpTransaction", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.d = paramcy.a("@com.vungle.publisher.inject.annotations.RequestLocalAdHttpTransaction()/javax.inject.Provider<com.vungle.publisher.net.http.HttpTransaction>", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.protocol.RequestStreamingAdHttpTransactionFactory", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.f = paramcy.a("com.vungle.publisher.protocol.SessionEndHttpTransactionFactory", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.g = paramcy.a("com.vungle.publisher.protocol.SessionStartHttpTransactionFactory", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.h = paramcy.a("@com.vungle.publisher.inject.annotations.TrackInstallHttpTransaction()/javax.inject.Provider<com.vungle.publisher.net.http.HttpTransaction>", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.i = paramcy.a("com.vungle.publisher.protocol.UnfilledAdHttpTransactionFactory", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.j = paramcy.a("com.vungle.publisher.reporting.AdServiceReportingHandler", ProtocolHttpGateway.class, getClass().getClassLoader());
    this.k = paramcy.a("members/com.vungle.publisher.net.http.HttpGateway", ProtocolHttpGateway.class, getClass().getClassLoader(), false);
  }
  
  public final ProtocolHttpGateway get()
  {
    ProtocolHttpGateway localProtocolHttpGateway = new ProtocolHttpGateway();
    injectMembers(localProtocolHttpGateway);
    return localProtocolHttpGateway;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
    paramSet2.add(this.f);
    paramSet2.add(this.g);
    paramSet2.add(this.h);
    paramSet2.add(this.i);
    paramSet2.add(this.j);
    paramSet2.add(this.k);
  }
  
  public final void injectMembers(ProtocolHttpGateway paramProtocolHttpGateway)
  {
    paramProtocolHttpGateway.a = ((ProtocolHttpGateway.PrepareLocalAdEventListener)this.a.get());
    paramProtocolHttpGateway.d = ((ReportAdHttpTransactionFactory)this.b.get());
    paramProtocolHttpGateway.e = ((HttpTransaction)this.c.get());
    paramProtocolHttpGateway.f = ((Provider)this.d.get());
    paramProtocolHttpGateway.g = ((RequestStreamingAdHttpTransactionFactory)this.e.get());
    paramProtocolHttpGateway.h = ((SessionEndHttpTransactionFactory)this.f.get());
    paramProtocolHttpGateway.i = ((SessionStartHttpTransactionFactory)this.g.get());
    paramProtocolHttpGateway.j = ((Provider)this.h.get());
    paramProtocolHttpGateway.k = ((UnfilledAdHttpTransactionFactory)this.i.get());
    paramProtocolHttpGateway.l = ((AdServiceReportingHandler)this.j.get());
    this.k.injectMembers(paramProtocolHttpGateway);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ProtocolHttpGateway$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */