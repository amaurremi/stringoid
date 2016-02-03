package com.vungle.publisher.display.view;

import android.content.Context;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class DisplayUtils$$InjectAdapter
  extends cs<DisplayUtils>
  implements cp<DisplayUtils>, Provider<DisplayUtils>
{
  private cs<Context> a;
  
  public DisplayUtils$$InjectAdapter()
  {
    super("com.vungle.publisher.display.view.DisplayUtils", "members/com.vungle.publisher.display.view.DisplayUtils", true, DisplayUtils.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("android.content.Context", DisplayUtils.class, getClass().getClassLoader());
  }
  
  public final DisplayUtils get()
  {
    DisplayUtils localDisplayUtils = new DisplayUtils();
    injectMembers(localDisplayUtils);
    return localDisplayUtils;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(DisplayUtils paramDisplayUtils)
  {
    paramDisplayUtils.a = ((Context)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/display/view/DisplayUtils$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */