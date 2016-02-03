package com.parse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

class ParseRequestRetryer
{
  public static HttpClient testClient = null;
  private int attemptsMade = 0;
  private HttpClient client;
  private long delay;
  private int maxAttempts;
  private HttpUriRequest request;
  
  public ParseRequestRetryer(HttpUriRequest paramHttpUriRequest, long paramLong, int paramInt)
  {
    if (testClient != null)
    {
      this.client = testClient;
      paramLong = 1L;
    }
    for (;;)
    {
      this.request = paramHttpUriRequest;
      this.maxAttempts = paramInt;
      this.delay = ((paramLong * Math.random()) + paramLong);
      return;
      this.client = new DefaultHttpClient();
      this.client.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    }
  }
  
  private Task<byte[]> sendOneRequestAsync(final ProgressCallback paramProgressCallback)
  {
    Task.call(new Callable()
    {
      public byte[] call()
        throws Exception
      {
        try
        {
          Object localObject1 = ParseRequestRetryer.this.client.execute(ParseRequestRetryer.this.request);
          if (ParseRequestRetryer.this.request.getMethod().equals("GET"))
          {
            int i = -1;
            Object localObject2 = ((HttpResponse)localObject1).getHeaders("Content-Length");
            if (localObject2.length > 0) {
              i = Integer.parseInt(localObject2[0].getValue());
            }
            int j = 0;
            localObject1 = ((HttpResponse)localObject1).getEntity().getContent();
            localObject2 = new ByteArrayOutputStream();
            byte[] arrayOfByte = new byte[32768];
            for (;;)
            {
              int k = ((InputStream)localObject1).read(arrayOfByte, 0, arrayOfByte.length);
              if (k == -1)
              {
                ((ByteArrayOutputStream)localObject2).flush();
                return ((ByteArrayOutputStream)localObject2).toByteArray();
              }
              ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, k);
              k = j + k;
              j = k;
              if (paramProgressCallback != null)
              {
                j = k;
                if (i != -1)
                {
                  Parse.callbackOnMainThreadAsync(Task.forResult(Integer.valueOf(Math.round(k / i * 100.0F))), paramProgressCallback);
                  j = k;
                }
              }
            }
          }
          if (localIOException.getStatusLine().getStatusCode() / 100 == 2) {
            break label306;
          }
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          ParseRequestRetryer.this.client.getConnectionManager().shutdown();
          throw ParseRequestRetryer.this.connectionFailed("bad protocol", localClientProtocolException);
        }
        catch (IOException localIOException)
        {
          ParseRequestRetryer.this.client.getConnectionManager().shutdown();
          throw ParseRequestRetryer.this.connectionFailed("i/o failure", localIOException);
        }
        throw new ParseException(100, String.format("Upload to S3 failed. %s", new Object[] { localIOException.getStatusLine().getReasonPhrase() }));
        label306:
        return null;
      }
    }, ParseCommand.networkThreadPool);
  }
  
  ParseException connectionFailed(String paramString, Exception paramException)
  {
    return new ParseException(100, paramString + ": " + paramException.getClass().getName() + ": " + paramException.getMessage());
  }
  
  public Task<byte[]> goAsync(final ProgressCallback paramProgressCallback)
  {
    sendOneRequestAsync(paramProgressCallback).continueWithTask(new Continuation()
    {
      public Task<byte[]> then(final Task<byte[]> paramAnonymousTask)
        throws Exception
      {
        Object localObject = paramAnonymousTask;
        if (paramAnonymousTask.isFaulted())
        {
          localObject = paramAnonymousTask;
          if ((paramAnonymousTask.getError() instanceof ParseException))
          {
            localObject = ParseRequestRetryer.this;
            ((ParseRequestRetryer)localObject).attemptsMade += 1;
            if (ParseRequestRetryer.this.attemptsMade >= ParseRequestRetryer.this.maxAttempts) {
              break label140;
            }
            Parse.logI("com.parse.ParseRequestRetryer", "Request failed. Waiting " + ParseRequestRetryer.this.delay + " milliseconds before attempt #" + (ParseRequestRetryer.this.attemptsMade + 1));
            paramAnonymousTask = Task.create();
            ParseCommand.networkThreadPool.schedule(new Runnable()
            {
              public void run()
              {
                ParseRequestRetryer localParseRequestRetryer = ParseRequestRetryer.this;
                localParseRequestRetryer.delay *= 2L;
                ParseRequestRetryer.this.goAsync(this.val$progressCallback).continueWithTask(new Continuation()
                {
                  public Task<Void> then(Task<byte[]> paramAnonymous3Task)
                    throws Exception
                  {
                    if (paramAnonymous3Task.isCancelled()) {
                      this.val$retryTask.setCancelled();
                    }
                    for (;;)
                    {
                      return null;
                      if (paramAnonymous3Task.isFaulted()) {
                        this.val$retryTask.setError(paramAnonymous3Task.getError());
                      } else {
                        this.val$retryTask.setResult((byte[])paramAnonymous3Task.getResult());
                      }
                    }
                  }
                });
              }
            }, ParseRequestRetryer.this.delay, TimeUnit.MILLISECONDS);
            localObject = paramAnonymousTask.getTask();
          }
        }
        label140:
        do
        {
          return (Task<byte[]>)localObject;
          localObject = paramAnonymousTask;
        } while (ParseRequestRetryer.this.request.isAborted());
        Parse.logI("com.parse.ParseRequestRetryer", "Request failed. Giving up.");
        return paramAnonymousTask;
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseRequestRetryer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */