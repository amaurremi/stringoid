package mobi.beyondpod.aggregators;

import android.os.Process;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.downloadengine.BeyondPodHttpClient;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;

public class AggregatorRequestQueue
  implements Runnable
{
  private static final String TAG = AggregatorRequestQueue.class.getSimpleName();
  private Thread _CallerThread = null;
  private volatile boolean _DownloadThreadIsDownloading;
  private BeyondPodHttpClient _HttpClient;
  QueueListener _QueueListener;
  ArrayList<RequestBase> _RequestQueue = new ArrayList();
  
  public AggregatorRequestQueue(QueueListener paramQueueListener)
  {
    this._QueueListener = paramQueueListener;
    this._HttpClient = BeyondPodHttpClient.newInstance(Configuration.DefaultUserAgent());
  }
  
  public static boolean ExecuteRequest(RequestBase paramRequestBase, BeyondPodHttpClient paramBeyondPodHttpClient)
  {
    HttpUriRequest localHttpUriRequest = paramRequestBase.Request();
    if (localHttpUriRequest == null) {
      return false;
    }
    int i;
    try
    {
      CoreHelper.WriteTraceEntry(TAG, "");
      CoreHelper.WriteTraceEntry(TAG, "--- Executing Aggregator API: " + paramRequestBase);
      CoreHelper.WriteTraceEntry(TAG, "--- Sending Request ");
      CoreHelper.KeepDeviceAwake();
      paramBeyondPodHttpClient = paramBeyondPodHttpClient.execute(localHttpUriRequest);
      CoreHelper.KeepDeviceAwake();
      i = paramBeyondPodHttpClient.getStatusLine().getStatusCode();
      CoreHelper.WriteTraceEntry(TAG, "--- Got Response! Status: " + i + " (" + paramBeyondPodHttpClient.getStatusLine().getReasonPhrase() + ")");
      if ((i != 200) && (i != 403) && (i != 401)) {
        throw new HttpException(paramBeyondPodHttpClient.getStatusLine().getReasonPhrase());
      }
    }
    catch (Exception paramBeyondPodHttpClient)
    {
      CoreHelper.WriteTraceEntry(TAG, "--- Error during Aggregator Sync: " + localHttpUriRequest.getURI() + ". Reason: " + paramBeyondPodHttpClient);
      paramRequestBase.OnFail(paramBeyondPodHttpClient);
      return false;
    }
    HttpEntity localHttpEntity = paramBeyondPodHttpClient.getEntity();
    paramBeyondPodHttpClient = null;
    if (localHttpEntity != null) {}
    Object localObject;
    try
    {
      paramBeyondPodHttpClient = new BufferedReader(new InputStreamReader(localHttpEntity.getContent()), 4096);
      localObject = new StringBuilder();
      for (;;)
      {
        String str = paramBeyondPodHttpClient.readLine();
        if (str == null)
        {
          paramBeyondPodHttpClient.close();
          localObject = ((StringBuilder)localObject).toString();
          paramBeyondPodHttpClient = (BeyondPodHttpClient)localObject;
          if (localHttpEntity != null)
          {
            localHttpEntity.consumeContent();
            paramBeyondPodHttpClient = (BeyondPodHttpClient)localObject;
          }
          CoreHelper.WriteTraceEntry(TAG, "--- Request completed!");
          if ((i != 403) && (i != 401)) {
            break;
          }
          throw new AggregatorLoginHelper.AuthenticationException(paramBeyondPodHttpClient);
        }
        ((StringBuilder)localObject).append(str + "\n");
      }
      localObject = paramBeyondPodHttpClient;
    }
    finally
    {
      if (localHttpEntity != null) {
        localHttpEntity.consumeContent();
      }
    }
    if (i == 200)
    {
      localObject = paramBeyondPodHttpClient;
      if (StringUtils.IsNullOrEmpty(paramBeyondPodHttpClient)) {
        localObject = "OK";
      }
    }
    paramRequestBase.OnSuccess((String)localObject);
    return true;
  }
  
  private void OnQueueCompleted(boolean paramBoolean)
  {
    this._DownloadThreadIsDownloading = false;
    if (this._QueueListener != null) {
      this._QueueListener.OnQueueCompleted(paramBoolean, this._RequestQueue);
    }
    this._HttpClient.close();
  }
  
  private void OnQueueProgress(int paramInt1, int paramInt2)
  {
    if (this._QueueListener != null) {
      this._QueueListener.OnQueueProgress(paramInt1, paramInt2);
    }
  }
  
  private void OnQueueStarted()
  {
    this._DownloadThreadIsDownloading = true;
    if (this._QueueListener != null) {
      this._QueueListener.OnQueueStarted(this._RequestQueue.size());
    }
  }
  
  public void ExecuteQueuedRequests()
    throws Exception
  {
    if (this._CallerThread != null) {
      throw new Exception("You must use a new instance of this class for each new download!");
    }
    if (this._DownloadThreadIsDownloading) {
      throw new Exception("Downlod is already in progress!");
    }
    this._DownloadThreadIsDownloading = true;
    this._CallerThread = new Thread(this);
    this._CallerThread.setName("Aggregator caller thread");
    this._CallerThread.setPriority(4);
    this._CallerThread.start();
  }
  
  public boolean IsWorking()
  {
    return this._DownloadThreadIsDownloading;
  }
  
  public void QueueRequest(RequestBase paramRequestBase)
  {
    this._RequestQueue.add(paramRequestBase);
  }
  
  public void Stop()
  {
    if ((this._CallerThread != null) && (!this._CallerThread.isInterrupted())) {
      this._CallerThread.interrupt();
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    for (;;)
    {
      int i;
      try
      {
        k = this._RequestQueue.size();
        OnQueueStarted();
        CoreHelper.WriteTraceEntry(TAG, "--- Starting the execution of " + k + " synchronization requests...");
        i = 0;
        localIterator = this._RequestQueue.iterator();
      }
      catch (Exception localException)
      {
        int k;
        Iterator localIterator;
        CoreHelper.LogException(TAG, "--- Failed to process Aggregator request queue", localException);
        return;
        j = i + 1;
        OnQueueProgress(j, k);
        i = j;
        if (ExecuteRequest(localRequestBase, this._HttpClient)) {
          continue;
        }
        if (!localRequestBase.ShouldAbort()) {
          break label266;
        }
        CoreHelper.WriteTraceEntry(TAG, "--- Request queue processing aborted as a result of request " + localRequestBase);
        continue;
      }
      finally
      {
        OnQueueCompleted(Thread.interrupted());
        this._HttpClient.close();
      }
      boolean bool = localIterator.hasNext();
      if (!bool)
      {
        OnQueueCompleted(Thread.interrupted());
        this._HttpClient.close();
        return;
      }
      RequestBase localRequestBase = (RequestBase)localIterator.next();
      if (Thread.interrupted())
      {
        CoreHelper.WriteTraceEntry(TAG, "--- Request Queue processing was interrupted.");
      }
      else
      {
        int j;
        label266:
        do
        {
          CoreHelper.WriteTraceEntry(TAG, "--- Retrying request: " + localRequestBase.getClass().getSimpleName());
          i = j;
          if (ExecuteRequest(localRequestBase, this._HttpClient)) {
            break;
          }
          bool = localRequestBase.ShouldRetry();
        } while (bool);
        i = j;
      }
    }
  }
  
  public static abstract interface QueueListener
  {
    public abstract void OnQueueCompleted(boolean paramBoolean, List<RequestBase> paramList);
    
    public abstract void OnQueueProgress(int paramInt1, int paramInt2);
    
    public abstract void OnQueueStarted(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/AggregatorRequestQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */