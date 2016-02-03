package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class TrackInstallHttpRequest$Creator$$InjectAdapter
  extends cs<TrackInstallHttpRequest.Creator>
  implements cp<TrackInstallHttpRequest.Creator>, Provider<TrackInstallHttpRequest.Creator>
{
  private cs<TrackInstallHttpRequest.Factory> a;
  
  public TrackInstallHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.TrackInstallHttpRequest$Creator", "members/com.vungle.publisher.protocol.TrackInstallHttpRequest$Creator", true, TrackInstallHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.TrackInstallHttpRequest$Factory", TrackInstallHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final TrackInstallHttpRequest.Creator get()
  {
    TrackInstallHttpRequest.Creator localCreator = new TrackInstallHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(TrackInstallHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((TrackInstallHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackInstallHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */