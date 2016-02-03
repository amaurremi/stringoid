package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class TrackEventHttpRequest$Creator$$InjectAdapter
  extends cs<TrackEventHttpRequest.Creator>
  implements cp<TrackEventHttpRequest.Creator>, Provider<TrackEventHttpRequest.Creator>
{
  private cs<TrackEventHttpRequest.Factory> a;
  
  public TrackEventHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.TrackEventHttpRequest$Creator", "members/com.vungle.publisher.protocol.TrackEventHttpRequest$Creator", true, TrackEventHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.TrackEventHttpRequest$Factory", TrackEventHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final TrackEventHttpRequest.Creator get()
  {
    TrackEventHttpRequest.Creator localCreator = new TrackEventHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(TrackEventHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((TrackEventHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackEventHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */