package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.net.http.HttpRequest.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class TrackEventHttpRequest$Factory$$InjectAdapter
  extends cs<TrackEventHttpRequest.Factory>
  implements cp<TrackEventHttpRequest.Factory>, Provider<TrackEventHttpRequest.Factory>
{
  private cs<HttpRequest.Factory> a;
  
  public TrackEventHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.TrackEventHttpRequest$Factory", "members/com.vungle.publisher.protocol.TrackEventHttpRequest$Factory", true, TrackEventHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.net.http.HttpRequest$Factory", TrackEventHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final TrackEventHttpRequest.Factory get()
  {
    TrackEventHttpRequest.Factory localFactory = new TrackEventHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(TrackEventHttpRequest.Factory paramFactory)
  {
    this.a.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackEventHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */