package com.millennialmedia.android;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class BridgeMMSpeechkit
  extends MMJSObject
  implements MediaPlayer.OnCompletionListener, BridgeMMMedia.Audio.PeriodicListener
{
  private NVASpeechKit getCreateSpeechKit()
  {
    NVASpeechKit localNVASpeechKit2 = null;
    Object localObject = (MMWebView)this.mmWebViewRef.get();
    NVASpeechKit localNVASpeechKit1 = localNVASpeechKit2;
    if (localObject != null)
    {
      localNVASpeechKit1 = localNVASpeechKit2;
      if (((MMWebView)localObject).allowSpeechCreationCommands())
      {
        if (getSpeechKitInternal() != null) {
          return getSpeechKitInternal();
        }
        Context localContext = ((MMWebView)localObject).getContext();
        localNVASpeechKit1 = localNVASpeechKit2;
        if (localContext != null)
        {
          localNVASpeechKit2 = new NVASpeechKit((MMWebView)localObject);
          setSpeechKit(localNVASpeechKit2);
          localObject = HandShake.sharedHandShake(localContext).nuanceCredentials;
          localNVASpeechKit1 = localNVASpeechKit2;
          if (localObject != null)
          {
            localNVASpeechKit2.initialize((HandShake.NuanceCredentials)localObject, localContext.getApplicationContext());
            localNVASpeechKit1 = localNVASpeechKit2;
          }
        }
      }
    }
    return localNVASpeechKit1;
  }
  
  static SpeechKitHolder getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  private NVASpeechKit getSpeechKit()
  {
    MMWebView localMMWebView = (MMWebView)this.mmWebViewRef.get();
    if ((localMMWebView != null) && (localMMWebView.allowRecordingCommands())) {
      return getSpeechKitInternal();
    }
    return null;
  }
  
  static NVASpeechKit getSpeechKitInternal()
  {
    return getInstance().getSpeechKit();
  }
  
  private NVASpeechKit getSpeechKitRelease()
  {
    return getSpeechKitInternal();
  }
  
  static boolean releaseSpeechKit()
  {
    return getInstance().release();
  }
  
  static void setSpeechKit(NVASpeechKit paramNVASpeechKit)
  {
    getInstance().release();
    getInstance().setSpeechKit(paramNVASpeechKit);
  }
  
  public MMJSResponse addCustomVoiceWords(HashMap<String, String> paramHashMap)
  {
    NVASpeechKit localNVASpeechKit = getCreateSpeechKit();
    if (localNVASpeechKit == null) {
      return MMJSResponse.responseWithError("Unable to create speech kit");
    }
    paramHashMap = (String)paramHashMap.get("words");
    if (!TextUtils.isEmpty(paramHashMap))
    {
      String[] arrayOfString = paramHashMap.split(",");
      localNVASpeechKit.updateCustomWords(NVASpeechKit.CustomWordsOp.Add, arrayOfString);
      injectJavascript("javascript:MMJS.sdk.customVoiceWordsAdded()");
      return MMJSResponse.responseWithSuccess("Added " + paramHashMap);
    }
    return null;
  }
  
  public MMJSResponse cacheAudio(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("url");
    if (!URLUtil.isValidUrl(paramHashMap)) {
      return MMJSResponse.responseWithError("Invalid url");
    }
    if (this.contextRef != null)
    {
      Context localContext = (Context)this.contextRef.get();
      if ((localContext != null) && (AdCache.downloadComponentToCache(paramHashMap, paramHashMap.substring(paramHashMap.lastIndexOf("/") + 1), localContext)))
      {
        injectJavascript("javascript:MMJS.sdk.audioCached()");
        return MMJSResponse.responseWithSuccess("Successfully cached audio at " + paramHashMap);
      }
    }
    return MMJSResponse.responseWithError("Failed to cache audio at" + paramHashMap);
  }
  
  public MMJSResponse deleteCustomVoiceWords(HashMap<String, String> paramHashMap)
  {
    NVASpeechKit localNVASpeechKit = getCreateSpeechKit();
    if (localNVASpeechKit == null) {
      return MMJSResponse.responseWithError("Unable to create speech kit");
    }
    paramHashMap = (String)paramHashMap.get("words");
    if (!TextUtils.isEmpty(paramHashMap))
    {
      String[] arrayOfString = paramHashMap.split(",");
      localNVASpeechKit.updateCustomWords(NVASpeechKit.CustomWordsOp.Remove, arrayOfString);
      injectJavascript("javascript:MMJS.sdk.customVoiceWordsDeleted()");
      return MMJSResponse.responseWithSuccess("Deleted " + paramHashMap);
    }
    return null;
  }
  
  public MMJSResponse endRecording(HashMap<String, String> paramHashMap)
  {
    paramHashMap = getSpeechKit();
    if (paramHashMap == null) {
      return MMJSResponse.responseWithError("Unable to get speech kit");
    }
    try
    {
      if (paramHashMap.endRecording())
      {
        MMJSResponse localMMJSResponse = MMJSResponse.responseWithSuccess();
        return localMMJSResponse;
      }
    }
    finally {}
    return MMJSResponse.responseWithError("Failed in speechKit");
  }
  
  public MMJSResponse getSessionId(HashMap<String, String> paramHashMap)
  {
    paramHashMap = getSpeechKit();
    if (paramHashMap == null) {
      return MMJSResponse.responseWithError("No SpeechKit session open.");
    }
    paramHashMap = paramHashMap.getSessionId();
    if (!TextUtils.isEmpty(paramHashMap)) {
      return MMJSResponse.responseWithSuccess(paramHashMap);
    }
    return MMJSResponse.responseWithError("No SpeechKit session open.");
  }
  
  void injectJavascript(String paramString)
  {
    MMWebView localMMWebView = (MMWebView)this.mmWebViewRef.get();
    if (localMMWebView != null) {
      localMMWebView.loadUrl(paramString);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    injectJavascript("javascript:MMJS.sdk.audioCompleted()");
    paramMediaPlayer = (Context)this.contextRef.get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer = BridgeMMMedia.Audio.sharedAudio(paramMediaPlayer);
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.removeCompletionListener(this);
        paramMediaPlayer.removePeriodicListener(this);
      }
    }
  }
  
  public void onUpdate(int paramInt)
  {
    injectJavascript("javascript:MMJS.sdk.audioPositionChange(" + paramInt + ")");
  }
  
  public MMJSResponse playAudio(HashMap<String, String> paramHashMap)
  {
    if (getCreateSpeechKit() == null) {
      paramHashMap = MMJSResponse.responseWithError("Unable to create speech kit");
    }
    Object localObject1;
    do
    {
      do
      {
        return paramHashMap;
        if (!URLUtil.isValidUrl((String)paramHashMap.get("url"))) {
          return MMJSResponse.responseWithError("Invalid url");
        }
        localObject1 = new BridgeMMMedia();
        if (this.contextRef == null) {
          break;
        }
        ((BridgeMMMedia)localObject1).setContext((Context)this.contextRef.get());
        String str = (String)paramHashMap.get("url");
        if (TextUtils.isEmpty(str)) {
          break;
        }
        Object localObject2 = (Context)this.contextRef.get();
        if (localObject2 == null) {
          break;
        }
        localObject2 = BridgeMMMedia.Audio.sharedAudio((Context)localObject2);
        if (localObject2 != null)
        {
          ((BridgeMMMedia.Audio)localObject2).addCompletionListener(this);
          ((BridgeMMMedia.Audio)localObject2).addPeriodicListener(this);
        }
        paramHashMap.put("path", str);
        localObject1 = ((BridgeMMMedia)localObject1).playAudio(paramHashMap);
        paramHashMap = (HashMap<String, String>)localObject1;
      } while (localObject1 == null);
      paramHashMap = (HashMap<String, String>)localObject1;
    } while (((MMJSResponse)localObject1).result != 1);
    injectJavascript("javascript:MMJS.sdk.audioStarted()");
    return (MMJSResponse)localObject1;
    return null;
  }
  
  public MMJSResponse releaseVoice(HashMap<String, String> paramHashMap)
  {
    if (releaseSpeechKit()) {
      return MMJSResponse.responseWithError("Unable to get speech kit");
    }
    return MMJSResponse.responseWithSuccess("released speechkit");
  }
  
  public MMJSResponse sampleBackgroundAudioLevel(HashMap<String, String> paramHashMap)
  {
    paramHashMap = getCreateSpeechKit();
    if (paramHashMap == null) {
      return MMJSResponse.responseWithError("Unable to create speech kit");
    }
    paramHashMap.startSampleRecording();
    return null;
  }
  
  public MMJSResponse startRecording(HashMap<String, String> paramHashMap)
  {
    NVASpeechKit localNVASpeechKit = getCreateSpeechKit();
    if (localNVASpeechKit == null) {
      return MMJSResponse.responseWithError("Unable to create speech kit");
    }
    String str = (String)paramHashMap.get("language");
    paramHashMap = str;
    if (TextUtils.isEmpty(str)) {
      paramHashMap = "en_GB";
    }
    if (localNVASpeechKit.startRecording(paramHashMap)) {
      return MMJSResponse.responseWithSuccess();
    }
    return MMJSResponse.responseWithError("Failed in speechKit");
  }
  
  public MMJSResponse stopAudio(HashMap<String, String> paramHashMap)
  {
    Object localObject = getSpeechKit();
    if (localObject == null) {
      return MMJSResponse.responseWithError("Unable to get speech kit");
    }
    ((NVASpeechKit)localObject).stopActions();
    localObject = new BridgeMMMedia();
    if (this.contextRef != null)
    {
      ((BridgeMMMedia)localObject).setContext((Context)this.contextRef.get());
      return ((BridgeMMMedia)localObject).stopAudio(paramHashMap);
    }
    return MMJSResponse.responseWithSuccess();
  }
  
  public MMJSResponse textToSpeech(HashMap<String, String> paramHashMap)
  {
    MMSDK.Log.d("@@-Calling textToSpeech");
    NVASpeechKit localNVASpeechKit = getCreateSpeechKit();
    if (localNVASpeechKit == null) {
      return MMJSResponse.responseWithError("Unable to create speech kit");
    }
    String str1 = (String)paramHashMap.get("language");
    String str2 = (String)paramHashMap.get("text");
    paramHashMap = str1;
    if (TextUtils.isEmpty(str1)) {
      paramHashMap = "en_GB";
    }
    localNVASpeechKit.stopActions();
    if (localNVASpeechKit.textToSpeech(str2, paramHashMap)) {
      return MMJSResponse.responseWithSuccess();
    }
    return MMJSResponse.responseWithError("Failed in speechKit");
  }
  
  private static class SingletonHolder
  {
    public static final BridgeMMSpeechkit.SpeechKitHolder INSTANCE = new BridgeMMSpeechkit.SpeechKitHolder(null);
  }
  
  private static class SpeechKitHolder
  {
    private NVASpeechKit _speechKit;
    
    public NVASpeechKit getSpeechKit()
    {
      return this._speechKit;
    }
    
    public boolean release()
    {
      if (this._speechKit == null) {
        return false;
      }
      Utils.ThreadUtils.execute(new Runnable()
      {
        public void run()
        {
          synchronized (BridgeMMSpeechkit.SpeechKitHolder.this)
          {
            if (BridgeMMSpeechkit.SpeechKitHolder.this._speechKit != null)
            {
              BridgeMMSpeechkit.SpeechKitHolder.this._speechKit.cancelRecording();
              BridgeMMSpeechkit.SpeechKitHolder.this._speechKit.release();
              BridgeMMSpeechkit.SpeechKitHolder.access$002(BridgeMMSpeechkit.SpeechKitHolder.this, null);
            }
            return;
          }
        }
      });
      return true;
    }
    
    public void setSpeechKit(NVASpeechKit paramNVASpeechKit)
    {
      this._speechKit = paramNVASpeechKit;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/BridgeMMSpeechkit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */