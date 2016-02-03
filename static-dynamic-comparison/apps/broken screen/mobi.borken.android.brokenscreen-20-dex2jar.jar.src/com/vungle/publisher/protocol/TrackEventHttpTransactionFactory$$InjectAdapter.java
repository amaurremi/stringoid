package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler;
import java.util.Set;
import javax.inject.Provider;

public final class TrackEventHttpTransactionFactory$$InjectAdapter
  extends cs<TrackEventHttpTransactionFactory>
  implements cp<TrackEventHttpTransactionFactory>, Provider<TrackEventHttpTransactionFactory>
{
  private cs<TrackEventHttpRequest.Factory> a;
  private cs<FireAndForgetHttpResponseHandler> b;
  
  public TrackEventHttpTransactionFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.TrackEventHttpTransactionFactory", "members/com.vungle.publisher.protocol.TrackEventHttpTransactionFactory", true, TrackEventHttpTransactionFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.TrackEventHttpRequest$Factory", TrackEventHttpTransactionFactory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler", TrackEventHttpTransactionFactory.class, getClass().getClassLoader());
  }
  
  public final TrackEventHttpTransactionFactory get()
  {
    TrackEventHttpTransactionFactory localTrackEventHttpTransactionFactory = new TrackEventHttpTransactionFactory();
    injectMembers(localTrackEventHttpTransactionFactory);
    return localTrackEventHttpTransactionFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(TrackEventHttpTransactionFactory paramTrackEventHttpTransactionFactory)
  {
    paramTrackEventHttpTransactionFactory.a = ((TrackEventHttpRequest.Factory)this.a.get());
    paramTrackEventHttpTransactionFactory.b = ((FireAndForgetHttpResponseHandler)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackEventHttpTransactionFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */