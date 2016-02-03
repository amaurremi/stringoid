package com.vungle.publisher;

import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.display.view.VideoFragment.Factory;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.reporting.AdReportingHandler.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class FullScreenAdActivity$$InjectAdapter
  extends cs<FullScreenAdActivity>
  implements cp<FullScreenAdActivity>, Provider<FullScreenAdActivity>
{
  private cs<AdManager> a;
  private cs<AdReportingHandler.Factory> b;
  private cs<di> c;
  private cs<VideoFragment.Factory> d;
  private cs<SdkState> e;
  
  public FullScreenAdActivity$$InjectAdapter()
  {
    super("com.vungle.publisher.FullScreenAdActivity", "members/com.vungle.publisher.FullScreenAdActivity", false, FullScreenAdActivity.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.ad.AdManager", FullScreenAdActivity.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.reporting.AdReportingHandler$Factory", FullScreenAdActivity.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.di", FullScreenAdActivity.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.display.view.VideoFragment$Factory", FullScreenAdActivity.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.env.SdkState", FullScreenAdActivity.class, getClass().getClassLoader());
  }
  
  public final FullScreenAdActivity get()
  {
    FullScreenAdActivity localFullScreenAdActivity = new FullScreenAdActivity();
    injectMembers(localFullScreenAdActivity);
    return localFullScreenAdActivity;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
  }
  
  public final void injectMembers(FullScreenAdActivity paramFullScreenAdActivity)
  {
    paramFullScreenAdActivity.a = ((AdManager)this.a.get());
    paramFullScreenAdActivity.b = ((AdReportingHandler.Factory)this.b.get());
    paramFullScreenAdActivity.c = ((di)this.c.get());
    paramFullScreenAdActivity.d = ((VideoFragment.Factory)this.d.get());
    paramFullScreenAdActivity.e = ((SdkState)this.e.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/FullScreenAdActivity$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */