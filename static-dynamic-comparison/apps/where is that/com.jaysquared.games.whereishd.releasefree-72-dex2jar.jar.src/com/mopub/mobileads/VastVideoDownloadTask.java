package com.mopub.mobileads;

import android.os.AsyncTask;
import android.util.Log;
import com.mopub.common.util.Streams;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.mobileads.util.HttpClients;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class VastVideoDownloadTask
  extends AsyncTask<String, Void, Boolean>
{
  private static final int HTTP_CLIENT_TIMEOUT = 10000;
  private static final long MAX_TEMP_FILE_LENGTH = 25000000L;
  private static final String TEMP_FILE_PREFIX = "mopub-vast";
  private final DiskLruCache mDiskLruCache;
  private final DefaultHttpClient mHttpClient;
  private final OnDownloadCompleteListener mOnDownloadCompleteListener;
  
  public VastVideoDownloadTask(OnDownloadCompleteListener paramOnDownloadCompleteListener, DiskLruCache paramDiskLruCache)
  {
    this.mOnDownloadCompleteListener = paramOnDownloadCompleteListener;
    this.mDiskLruCache = paramDiskLruCache;
    this.mHttpClient = HttpClientFactory.create(10000);
  }
  
  InputStream connectToUrl(String paramString)
    throws IOException
  {
    if (paramString == null) {
      throw new IOException("Unable to connect to null url.");
    }
    Object localObject = new HttpGet(paramString);
    localObject = this.mHttpClient.execute((HttpUriRequest)localObject);
    if ((localObject == null) || (((HttpResponse)localObject).getEntity() == null)) {
      throw new IOException("Obtained null response from video url: " + paramString);
    }
    return ((HttpResponse)localObject).getEntity().getContent();
  }
  
  File copyInputStreamToTempFile(InputStream paramInputStream)
    throws IOException
  {
    File localFile = File.createTempFile("mopub-vast", null, this.mDiskLruCache.getCacheDirectory());
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile));
    try
    {
      Streams.copyContent(paramInputStream, localBufferedOutputStream, 25000000L);
      return localFile;
    }
    catch (IOException localIOException)
    {
      localFile.delete();
      throw localIOException;
    }
    finally
    {
      Streams.closeStream(paramInputStream);
      Streams.closeStream(localBufferedOutputStream);
    }
  }
  
  boolean copyTempFileIntoCache(String paramString, File paramFile)
    throws FileNotFoundException
  {
    paramFile = new BufferedInputStream(new FileInputStream(paramFile));
    boolean bool = this.mDiskLruCache.putStream(paramString, paramFile);
    Streams.closeStream(paramFile);
    return bool;
  }
  
  protected Boolean doInBackground(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
      return Boolean.valueOf(false);
    }
    return downloadToCache(paramVarArgs[0]);
  }
  
  Boolean downloadToCache(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      File localFile = copyInputStreamToTempFile(connectToUrl(paramString));
      bool1 = bool2;
      bool2 = copyTempFileIntoCache(paramString, localFile);
      bool1 = bool2;
      localFile.delete();
      HttpClients.safeShutdown(this.mHttpClient);
      bool1 = bool2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.d("MoPub", "Failed to download video.");
        HttpClients.safeShutdown(this.mHttpClient);
      }
    }
    finally
    {
      HttpClients.safeShutdown(this.mHttpClient);
    }
    return Boolean.valueOf(bool1);
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      if (this.mOnDownloadCompleteListener != null) {
        this.mOnDownloadCompleteListener.onDownloadSuccess();
      }
    }
    while (this.mOnDownloadCompleteListener == null) {
      return;
    }
    this.mOnDownloadCompleteListener.onDownloadFailed();
  }
  
  public static abstract interface OnDownloadCompleteListener
  {
    public abstract void onDownloadFailed();
    
    public abstract void onDownloadSuccess();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/VastVideoDownloadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */