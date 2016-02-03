package com.vungle.publisher.event;

import com.vungle.publisher.bh;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import java.util.Set;
import javax.inject.Provider;

public final class BaseEventListener$$InjectAdapter
  extends cs<bh>
  implements cp<bh>, Provider<bh>
{
  private cs<di> a;
  
  public BaseEventListener$$InjectAdapter()
  {
    super("com.vungle.publisher.bh", "members/com.vungle.publisher.event.BaseEventListener", false, bh.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.di", bh.class, getClass().getClassLoader());
  }
  
  public final bh get()
  {
    bh localbh = new bh();
    injectMembers(localbh);
    return localbh;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(bh parambh)
  {
    parambh.f = ((di)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/event/BaseEventListener$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */