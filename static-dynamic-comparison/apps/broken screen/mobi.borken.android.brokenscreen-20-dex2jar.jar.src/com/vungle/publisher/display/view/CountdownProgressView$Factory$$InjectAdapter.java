package com.vungle.publisher.display.view;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.image.BitmapFactory;
import java.util.Set;
import javax.inject.Provider;

public final class CountdownProgressView$Factory$$InjectAdapter
  extends cs<CountdownProgressView.Factory>
  implements cp<CountdownProgressView.Factory>, Provider<CountdownProgressView.Factory>
{
  private cs<BitmapFactory> a;
  
  public CountdownProgressView$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.display.view.CountdownProgressView$Factory", "members/com.vungle.publisher.display.view.CountdownProgressView$Factory", true, CountdownProgressView.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.image.BitmapFactory", CountdownProgressView.Factory.class, getClass().getClassLoader());
  }
  
  public final CountdownProgressView.Factory get()
  {
    CountdownProgressView.Factory localFactory = new CountdownProgressView.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(CountdownProgressView.Factory paramFactory)
  {
    paramFactory.a = ((BitmapFactory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/display/view/CountdownProgressView$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */