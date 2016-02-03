package com.vungle.publisher.protocol;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.vungle.publisher.bc;
import com.vungle.publisher.be;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.HttpRequest.a;
import com.vungle.publisher.net.http.HttpRequest.b;
import com.vungle.publisher.protocol.message.RequestLocalAd.Factory;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class TrackInstallHttpRequest
  extends ProtocolHttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.c;
  }
  
  protected final HttpRequest.b b()
  {
    return HttpRequest.b.i;
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<TrackInstallHttpRequest>
  {
    @Inject
    TrackInstallHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends ProtocolHttpRequest.a<TrackInstallHttpRequest>
  {
    @Inject
    bc f;
    @Inject
    RequestLocalAd.Factory g;
    
    protected static TrackInstallHttpRequest e()
    {
      return new TrackInstallHttpRequest();
    }
    
    public final TrackInstallHttpRequest d()
    {
      TrackInstallHttpRequest localTrackInstallHttpRequest = (TrackInstallHttpRequest)super.a();
      Uri.Builder localBuilder = Uri.parse(this.e + "new").buildUpon().appendQueryParameter("app_id", this.d.b()).appendQueryParameter("isu", this.f.a());
      String str = this.f.e();
      if (!TextUtils.isEmpty(str)) {
        localBuilder.appendQueryParameter("serial", str);
      }
      localTrackInstallHttpRequest.b = localBuilder.toString();
      return localTrackInstallHttpRequest;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackInstallHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */