package com.vungle.publisher.protocol;

import android.os.Parcelable.Creator;
import com.vungle.publisher.bv;
import com.vungle.publisher.cq;
import com.vungle.publisher.db.model.LocalAdReport.Factory;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.net.http.HttpTransaction.a;
import com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler;
import com.vungle.publisher.reporting.ReportManager;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
public class ReportAdHttpResponseHandler
  extends InfiniteRetryHttpResponseHandler
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  @Inject
  Provider<ReportManager> a;
  
  protected final void a(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama)
    throws IOException, JSONException
  {
    parambv = (ReportManager)this.a.get();
    paramHttpTransaction = ((ReportAdHttpRequest)paramHttpTransaction.a).e;
    Logger.i("VungleReport", "deleting report " + paramHttpTransaction);
    parambv.a.a(new Integer[] { paramHttpTransaction });
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<ReportAdHttpResponseHandler>
  {
    @Inject
    ReportAdHttpResponseHandler a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportAdHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */