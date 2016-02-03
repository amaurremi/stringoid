package com.jumptap.adtag.utils;

import android.content.Context;
import android.util.Log;
import com.jumptap.adtag.listeners.JtAdViewInnerListener;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class JtAdFetcher
  implements Runnable
{
  private static final String ADVIEW_HTML_FILE_NAME = "adview.html";
  private static final String ADVIEW_JS_FILE_NAME = "adview.js";
  private static final String AD_CONTENT_HERE_STR = "%AD_CONTENT_HERE%";
  private static final int BUFFER_SIZE = 1024;
  private static final String JS_CONTENT_HERE_STR = "%JS_CONTENT_HERE%";
  private static final String XJT_RESPONSE_ID = "Xjt-Responseid";
  private String adRequestId;
  private JtAdViewInnerListener contentListener = null;
  private Context context;
  private boolean shouldDebugNetworkTraffic = false;
  private String url;
  private String wrapperContent = null;
  
  public JtAdFetcher(Context paramContext, JtAdViewInnerListener paramJtAdViewInnerListener)
    throws JtException
  {
    this.contentListener = paramJtAdViewInnerListener;
    this.context = paramContext;
    makeContentWrapper();
  }
  
  private void makeContentWrapper()
    throws JtException
  {
    if (this.wrapperContent == null)
    {
      StringBuilder localStringBuilder1 = FileReaderUtil.getFileContent(this.context, "adview.html");
      StringBuilder localStringBuilder2 = FileReaderUtil.getFileContent(this.context, "adview.js");
      this.wrapperContent = localStringBuilder1.toString().replace("%JS_CONTENT_HERE%", localStringBuilder2);
    }
  }
  
  private String modifyHtml(String paramString)
  {
    String str = null;
    if (paramString != null)
    {
      if (paramString.length() > 0) {
        str = this.wrapperContent.replace("%AD_CONTENT_HERE%", paramString);
      }
    }
    else {
      return str;
    }
    return "";
  }
  
  public String getAdContent()
  {
    Object localObject1 = new DefaultHttpClient();
    Object localObject2 = new HttpGet(this.url);
    if (this.shouldDebugNetworkTraffic) {
      Log.d("JtAd", "Created html client for: " + this.url);
    }
    int i;
    try
    {
      localObject1 = ((HttpClient)localObject1).execute((HttpUriRequest)localObject2);
      localObject2 = ((HttpResponse)localObject1).getFirstHeader("Xjt-Responseid");
      if (localObject2 != null) {
        this.adRequestId = ((Header)localObject2).getValue();
      }
      i = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
      if (i == 200)
      {
        localObject1 = ((HttpResponse)localObject1).getEntity();
        i = (int)((HttpEntity)localObject1).getContentLength();
        localObject1 = ((HttpEntity)localObject1).getContent();
        localObject2 = new byte['Ѐ'];
        StringBuilder localStringBuilder = new StringBuilder();
        for (;;)
        {
          i = ((InputStream)localObject1).read((byte[])localObject2);
          if (i <= 0) {
            break;
          }
          localStringBuilder.append(new StringBuffer(new String((byte[])localObject2, 0, i)));
        }
        return localStringBuilder.toString();
      }
    }
    catch (IOException localIOException)
    {
      Log.e("JtAd", "JtAdFetcher.getAdContent:" + localIOException.toString());
      return null;
    }
    Log.e("JtAd", "JtAdFetcher.getAdContent: Recieve error Code=[" + i + "] when sending url=[" + this.url + "]");
    return null;
  }
  
  public String getAdRequestId()
  {
    return this.adRequestId;
  }
  
  public void kickOffUrlFetch(String paramString)
  {
    Log.d("JtAd", "Kicked off fetcher");
    this.url = paramString;
    new Thread(this).start();
  }
  
  public void run()
  {
    Log.d("JtAd", "Started Url Thread");
    String str = modifyHtml(getAdContent());
    if (this.contentListener != null) {
      this.contentListener.setContent(str, this.adRequestId);
    }
  }
  
  public void setShouldDebugNetworkTraffic(boolean paramBoolean)
  {
    this.shouldDebugNetworkTraffic = paramBoolean;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/utils/JtAdFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */