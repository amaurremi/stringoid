package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class UnfilledAdHttpRequest$Creator$$InjectAdapter
  extends cs<UnfilledAdHttpRequest.Creator>
  implements cp<UnfilledAdHttpRequest.Creator>, Provider<UnfilledAdHttpRequest.Creator>
{
  private cs<UnfilledAdHttpRequest.Factory> a;
  
  public UnfilledAdHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.UnfilledAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.UnfilledAdHttpRequest$Creator", true, UnfilledAdHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.UnfilledAdHttpRequest$Factory", UnfilledAdHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final UnfilledAdHttpRequest.Creator get()
  {
    UnfilledAdHttpRequest.Creator localCreator = new UnfilledAdHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(UnfilledAdHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((UnfilledAdHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/UnfilledAdHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */