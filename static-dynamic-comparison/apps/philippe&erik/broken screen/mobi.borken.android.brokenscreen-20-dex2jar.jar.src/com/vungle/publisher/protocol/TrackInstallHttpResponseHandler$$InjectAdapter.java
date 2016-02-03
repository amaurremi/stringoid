package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler;
import java.util.Set;
import javax.inject.Provider;

public final class TrackInstallHttpResponseHandler$$InjectAdapter
  extends cs<TrackInstallHttpResponseHandler>
  implements cp<TrackInstallHttpResponseHandler>, Provider<TrackInstallHttpResponseHandler>
{
  private cs<SdkState> a;
  private cs<FireAndForgetHttpResponseHandler> b;
  
  public TrackInstallHttpResponseHandler$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.TrackInstallHttpResponseHandler", "members/com.vungle.publisher.protocol.TrackInstallHttpResponseHandler", true, TrackInstallHttpResponseHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.env.SdkState", TrackInstallHttpResponseHandler.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler", TrackInstallHttpResponseHandler.class, getClass().getClassLoader(), false);
  }
  
  public final TrackInstallHttpResponseHandler get()
  {
    TrackInstallHttpResponseHandler localTrackInstallHttpResponseHandler = new TrackInstallHttpResponseHandler();
    injectMembers(localTrackInstallHttpResponseHandler);
    return localTrackInstallHttpResponseHandler;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(TrackInstallHttpResponseHandler paramTrackInstallHttpResponseHandler)
  {
    paramTrackInstallHttpResponseHandler.a = ((SdkState)this.a.get());
    this.b.injectMembers(paramTrackInstallHttpResponseHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackInstallHttpResponseHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */