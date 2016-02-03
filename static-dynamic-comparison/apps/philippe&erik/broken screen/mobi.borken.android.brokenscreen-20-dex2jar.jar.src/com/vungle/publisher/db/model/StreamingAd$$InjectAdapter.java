package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingAd$$InjectAdapter
  extends cs<StreamingAd>
  implements cp<StreamingAd>, Provider<StreamingAd>
{
  private cs<StreamingAd.Factory> a;
  private cs<Ad> b;
  
  public StreamingAd$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingAd", "members/com.vungle.publisher.db.model.StreamingAd", false, StreamingAd.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.StreamingAd$Factory", StreamingAd.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.Ad", StreamingAd.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingAd get()
  {
    StreamingAd localStreamingAd = new StreamingAd();
    injectMembers(localStreamingAd);
    return localStreamingAd;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(StreamingAd paramStreamingAd)
  {
    paramStreamingAd.p = ((StreamingAd.Factory)this.a.get());
    this.b.injectMembers(paramStreamingAd);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAd$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */