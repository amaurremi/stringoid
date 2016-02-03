package com.mopub.mobileads.util.vast;

import android.os.AsyncTask;
import android.util.Log;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.mobileads.util.HttpClients;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class VastManager
{
  static final int MAX_TIMES_TO_FOLLOW_VAST_REDIRECT = 20;
  static final int VAST_REDIRECT_TIMEOUT_MILLISECONDS = 30000;
  private String mClickThroughUrl;
  private List<String> mClickTrackers = new ArrayList();
  private HttpClient mHttpClient = HttpClientFactory.create(30000);
  private List<String> mImpressionTrackers = new ArrayList();
  private VastManagerListener mListener;
  private String mMediaFileUrl;
  private int mTimesFollowedVastRedirect;
  private ProcessVastBackgroundTask mVastBackgroundTask;
  private List<String> mVideoCompleteTrackers = new ArrayList();
  private List<String> mVideoFirstQuartileTrackers = new ArrayList();
  private List<String> mVideoMidpointTrackers = new ArrayList();
  private List<String> mVideoStartTrackers = new ArrayList();
  private List<String> mVideoThirdQuartileTrackers = new ArrayList();
  
  private void loadVastDataFromXml(VastXmlManager paramVastXmlManager)
  {
    this.mImpressionTrackers.addAll(paramVastXmlManager.getImpressionTrackers());
    this.mVideoStartTrackers.addAll(paramVastXmlManager.getVideoStartTrackers());
    this.mVideoFirstQuartileTrackers.addAll(paramVastXmlManager.getVideoFirstQuartileTrackers());
    this.mVideoMidpointTrackers.addAll(paramVastXmlManager.getVideoMidpointTrackers());
    this.mVideoThirdQuartileTrackers.addAll(paramVastXmlManager.getVideoThirdQuartileTrackers());
    this.mVideoCompleteTrackers.addAll(paramVastXmlManager.getVideoCompleteTrackers());
    this.mClickTrackers.addAll(paramVastXmlManager.getClickTrackers());
    if (this.mClickThroughUrl == null) {
      this.mClickThroughUrl = paramVastXmlManager.getClickThroughUrl();
    }
    if (this.mMediaFileUrl == null) {
      this.mMediaFileUrl = paramVastXmlManager.getMediaFileUrl();
    }
  }
  
  private String processVastFollowingRedirect(String paramString)
    throws Exception
  {
    Object localObject1 = null;
    Object localObject2 = new VastXmlManager();
    ((VastXmlManager)localObject2).parseVastXml(paramString);
    loadVastDataFromXml((VastXmlManager)localObject2);
    localObject2 = ((VastXmlManager)localObject2).getVastAdTagURI();
    paramString = (String)localObject1;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (this.mTimesFollowedVastRedirect < 20)
      {
        this.mTimesFollowedVastRedirect += 1;
        paramString = new HttpGet((String)localObject2);
        localObject2 = this.mHttpClient.execute(paramString).getEntity();
        paramString = (String)localObject1;
        if (localObject2 != null) {
          paramString = Strings.fromStream(((HttpEntity)localObject2).getContent());
        }
      }
    }
    return paramString;
  }
  
  private void vastProcessComplete(boolean paramBoolean)
  {
    HttpClients.safeShutdown(this.mHttpClient);
    this.mTimesFollowedVastRedirect = 0;
    this.mVastBackgroundTask = null;
    if (!paramBoolean) {
      this.mListener.onComplete(this);
    }
  }
  
  public void cancel()
  {
    if (this.mVastBackgroundTask != null) {
      this.mVastBackgroundTask.cancel(true);
    }
  }
  
  public String getClickThroughUrl()
  {
    return this.mClickThroughUrl;
  }
  
  public List<String> getClickTrackers()
  {
    return this.mClickTrackers;
  }
  
  public List<String> getImpressionTrackers()
  {
    return this.mImpressionTrackers;
  }
  
  public String getMediaFileUrl()
  {
    return this.mMediaFileUrl;
  }
  
  public List<String> getVideoCompleteTrackers()
  {
    return this.mVideoCompleteTrackers;
  }
  
  public List<String> getVideoFirstQuartileTrackers()
  {
    return this.mVideoFirstQuartileTrackers;
  }
  
  public List<String> getVideoMidpointTrackers()
  {
    return this.mVideoMidpointTrackers;
  }
  
  public List<String> getVideoStartTrackers()
  {
    return this.mVideoStartTrackers;
  }
  
  public List<String> getVideoThirdQuartileTrackers()
  {
    return this.mVideoThirdQuartileTrackers;
  }
  
  public void processVast(String paramString, VastManagerListener paramVastManagerListener)
  {
    if (this.mVastBackgroundTask == null)
    {
      this.mListener = paramVastManagerListener;
      this.mVastBackgroundTask = new ProcessVastBackgroundTask(null);
      this.mVastBackgroundTask.execute(new String[] { paramString });
    }
  }
  
  @Deprecated
  void setTimesFollowedVastRedirect(int paramInt)
  {
    this.mTimesFollowedVastRedirect = paramInt;
  }
  
  private class ProcessVastBackgroundTask
    extends AsyncTask<String, Void, Void>
  {
    private ProcessVastBackgroundTask() {}
    
    protected Void doInBackground(String... paramVarArgs)
    {
      if (paramVarArgs != null) {
        try
        {
          if (paramVarArgs.length > 0) {
            for (paramVarArgs = paramVarArgs[0]; (paramVarArgs != null) && (paramVarArgs.length() > 0) && (!isCancelled()); paramVarArgs = VastManager.this.processVastFollowingRedirect(paramVarArgs)) {}
          }
          return null;
        }
        catch (Exception paramVarArgs)
        {
          Log.d("MoPub", "Failed to parse VAST XML", paramVarArgs);
        }
      }
    }
    
    protected void onCancelled()
    {
      VastManager.this.vastProcessComplete(true);
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      VastManager.this.vastProcessComplete(false);
    }
  }
  
  public static abstract interface VastManagerListener
  {
    public abstract void onComplete(VastManager paramVastManager);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/util/vast/VastManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */