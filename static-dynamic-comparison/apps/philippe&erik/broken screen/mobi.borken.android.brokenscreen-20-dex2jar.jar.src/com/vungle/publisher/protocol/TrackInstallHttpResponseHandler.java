package com.vungle.publisher.protocol;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcelable.Creator;
import com.vungle.publisher.bv;
import com.vungle.publisher.cq;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.net.http.HttpTransaction.a;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class TrackInstallHttpResponseHandler
  extends FireAndForgetHttpResponseHandler
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  @Inject
  SdkState a;
  
  protected final void a(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama)
    throws IOException
  {
    super.a(paramHttpTransaction, parambv, parama);
    this.a.h.edit().putBoolean("IsVgAppInstalled", true).apply();
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<TrackInstallHttpResponseHandler>
  {
    @Inject
    Provider<TrackInstallHttpResponseHandler> a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackInstallHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */