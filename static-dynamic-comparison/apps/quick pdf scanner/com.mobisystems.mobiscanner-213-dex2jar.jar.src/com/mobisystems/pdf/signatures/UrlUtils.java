package com.mobisystems.pdf.signatures;

import com.mobisystems.pdf.PDFTrace;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;

public class UrlUtils
{
  private static final int MIN_PROGRESS_UPDATE_DURATION = 1000;
  private static final int STREAM_BUFF_SIZE = 8192;
  private static final int URL_CONNECT_TIMEOUT = 10000;
  private static final int URL_READ_TIMEOUT = 10000;
  
  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream, AsyncTaskCallback<Integer> paramAsyncTaskCallback)
  {
    byte[] arrayOfByte = new byte[' '];
    if (FileInputStream.class.isInstance(paramInputStream)) {}
    for (long l1 = ((FileInputStream)paramInputStream).getChannel().size();; l1 = 0L)
    {
      long l2 = 0L;
      int k = 100;
      int j = 0;
      int i = 0;
      if (paramAsyncTaskCallback != null)
      {
        k = ((Integer)paramAsyncTaskCallback.getMaxProgress()).intValue();
        i = ((Integer)paramAsyncTaskCallback.getCurrentProgress()).intValue();
        j = i;
      }
      long l3 = System.currentTimeMillis();
      for (;;)
      {
        int m = paramInputStream.read(arrayOfByte);
        if (m <= 0) {
          break;
        }
        if ((paramAsyncTaskCallback != null) && (paramAsyncTaskCallback.isWorkCancelled())) {
          throw new InterruptedException("Cancelled");
        }
        paramOutputStream.write(arrayOfByte, 0, m);
        long l4 = l2 + m;
        l2 = l4;
        if (paramAsyncTaskCallback != null)
        {
          long l5 = System.currentTimeMillis();
          l2 = l4;
          if (l5 - l3 >= 1000L)
          {
            l2 = l4;
            if (l1 > 0L)
            {
              i = (int)(j + (k - j) * l4 / l1);
              paramAsyncTaskCallback.setProgress(Integer.valueOf(i));
              l3 = l5;
              l2 = l4;
            }
          }
        }
      }
      if ((paramAsyncTaskCallback != null) && (i < k)) {
        paramAsyncTaskCallback.setProgress(Integer.valueOf(k));
      }
      return;
    }
  }
  
  public static void downloadUrl(URL paramURL, OutputStream paramOutputStream, AsyncTaskCallback<Integer> paramAsyncTaskCallback)
  {
    Object localObject2 = null;
    localObject1 = localObject2;
    try
    {
      paramURL = paramURL.openConnection();
      localObject1 = localObject2;
      paramURL.setConnectTimeout(10000);
      localObject1 = localObject2;
      paramURL.setReadTimeout(10000);
      localObject1 = localObject2;
      paramURL = paramURL.getInputStream();
      localObject1 = paramURL;
      copyStream(paramURL, paramOutputStream, paramAsyncTaskCallback);
      if (paramURL != null) {}
      try
      {
        paramURL.close();
        return;
      }
      catch (IOException paramURL)
      {
        PDFTrace.e("Error closing the input stream while downloading an URL", paramURL);
        return;
      }
      try
      {
        ((InputStream)localObject1).close();
        throw paramURL;
      }
      catch (IOException paramOutputStream)
      {
        for (;;)
        {
          PDFTrace.e("Error closing the input stream while downloading an URL", paramOutputStream);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static void downloadUrlPost(URL paramURL, byte[] paramArrayOfByte, String paramString1, String paramString2, OutputStream paramOutputStream, AsyncTaskCallback<Integer> paramAsyncTaskCallback)
  {
    localObject1 = null;
    localObject2 = null;
    try
    {
      paramURL = paramURL.openConnection();
      if (!(paramURL instanceof HttpURLConnection)) {
        break label158;
      }
      localHttpURLConnection = (HttpURLConnection)paramURL;
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setRequestProperty("Content-Type", paramString1);
      localHttpURLConnection.setRequestProperty("Accept", paramString2);
      paramString1 = localHttpURLConnection.getOutputStream();
      paramURL = (URL)localObject2;
      try
      {
        paramString1.write(paramArrayOfByte);
        paramURL = (URL)localObject2;
        paramString1.flush();
        paramURL = (URL)localObject2;
        int i = localHttpURLConnection.getResponseCode();
        if (i == 200) {
          break label177;
        }
        paramURL = (URL)localObject2;
        throw new IOException("Error sending HTTP request: " + String.valueOf(i));
      }
      finally
      {
        paramArrayOfByte = paramURL;
        paramURL = paramString2;
      }
    }
    finally
    {
      try
      {
        paramArrayOfByte.close();
        if (paramString1 == null) {
          break label156;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          HttpURLConnection localHttpURLConnection;
          for (;;)
          {
            paramString1.close();
            throw paramURL;
            throw new IOException("Unexpected URL connection class");
            paramURL = finally;
            paramString1 = null;
            paramArrayOfByte = (byte[])localObject1;
          }
          paramURL = (URL)localObject2;
          paramArrayOfByte = localHttpURLConnection.getInputStream();
          paramURL = paramArrayOfByte;
          copyStream(paramArrayOfByte, paramOutputStream, paramAsyncTaskCallback);
          if (paramArrayOfByte == null) {
            break label204;
          }
          try
          {
            paramArrayOfByte.close();
            if (paramString1 == null) {}
          }
          catch (IOException paramURL)
          {
            for (;;)
            {
              try
              {
                paramString1.close();
                return;
              }
              catch (IOException paramURL)
              {
                PDFTrace.e("Error closing the request stream while executing a POST HTTP request", paramURL);
                return;
              }
              paramURL = paramURL;
              PDFTrace.e("Error closing the input stream while executing a POST HTTP request", paramURL);
            }
          }
          paramArrayOfByte = paramArrayOfByte;
          PDFTrace.e("Error closing the input stream while executing a POST HTTP request", paramArrayOfByte);
        }
        catch (IOException paramArrayOfByte)
        {
          for (;;)
          {
            PDFTrace.e("Error closing the request stream while executing a POST HTTP request", paramArrayOfByte);
          }
        }
      }
    }
    if (paramArrayOfByte == null) {}
  }
  
  public static abstract interface AsyncTaskCallback<T>
  {
    public abstract T getCurrentProgress();
    
    public abstract T getMaxProgress();
    
    public abstract boolean isWorkCancelled();
    
    public abstract void setProgress(T paramT);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/UrlUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */