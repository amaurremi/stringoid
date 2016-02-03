package com.vungle.publisher.net.http;

import com.vungle.publisher.VungleService;
import com.vungle.publisher.bu;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DownloadHttpGateway
  extends bu
{
  @Inject
  public DownloadHttpTransactionFactory a;
  
  protected final String a()
  {
    return VungleService.DOWNLOAD_ACTION;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpGateway.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */