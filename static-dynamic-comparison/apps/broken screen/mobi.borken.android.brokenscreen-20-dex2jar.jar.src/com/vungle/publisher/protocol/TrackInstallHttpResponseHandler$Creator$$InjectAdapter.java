package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class TrackInstallHttpResponseHandler$Creator$$InjectAdapter
  extends cs<TrackInstallHttpResponseHandler.Creator>
  implements cp<TrackInstallHttpResponseHandler.Creator>, Provider<TrackInstallHttpResponseHandler.Creator>
{
  private cs<Provider<TrackInstallHttpResponseHandler>> a;
  
  public TrackInstallHttpResponseHandler$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.TrackInstallHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.TrackInstallHttpResponseHandler$Creator", true, TrackInstallHttpResponseHandler.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.protocol.TrackInstallHttpResponseHandler>", TrackInstallHttpResponseHandler.Creator.class, getClass().getClassLoader());
  }
  
  public final TrackInstallHttpResponseHandler.Creator get()
  {
    TrackInstallHttpResponseHandler.Creator localCreator = new TrackInstallHttpResponseHandler.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(TrackInstallHttpResponseHandler.Creator paramCreator)
  {
    paramCreator.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackInstallHttpResponseHandler$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */