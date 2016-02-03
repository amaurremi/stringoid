package org.osmdroid.tileprovider.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.osmdroid.http.HttpClientFactory;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloudmadeUtil
  implements OpenStreetMapTileProviderConstants
{
  private static final String CLOUDMADE_ID = "CLOUDMADE_ID";
  private static final String CLOUDMADE_KEY = "CLOUDMADE_KEY";
  private static final String CLOUDMADE_TOKEN = "CLOUDMADE_TOKEN";
  private static final Logger logger = LoggerFactory.getLogger(CloudmadeUtil.class);
  private static String mAndroidId = "android_id";
  private static String mKey = "";
  private static SharedPreferences.Editor mPreferenceEditor;
  private static String mToken = "";
  
  public static String getCloudmadeKey()
  {
    return mKey;
  }
  
  public static String getCloudmadeToken()
  {
    if (mToken.length() == 0) {}
    synchronized (mToken)
    {
      Object localObject3;
      Object localObject1;
      if (mToken.length() == 0)
      {
        localObject3 = "http://auth.cloudmade.com/token/" + mKey + "?userid=" + mAndroidId;
        localObject1 = HttpClientFactory.createHttpClient();
        localObject3 = new HttpPost((String)localObject3);
      }
      try
      {
        ((HttpPost)localObject3).setEntity(new StringEntity("", "utf-8"));
        localObject1 = ((HttpClient)localObject1).execute((HttpUriRequest)localObject3);
        if (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200)
        {
          mToken = new BufferedReader(new InputStreamReader(((HttpResponse)localObject1).getEntity().getContent()), 8192).readLine().trim();
          if (mToken.length() <= 0) {
            break label189;
          }
          mPreferenceEditor.putString("CLOUDMADE_TOKEN", mToken);
          mPreferenceEditor.commit();
          mPreferenceEditor = null;
        }
        for (;;)
        {
          return mToken;
          label189:
          logger.error("No authorization token received from Cloudmade");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          logger.error("No authorization token received from Cloudmade: " + localIOException);
        }
      }
    }
  }
  
  public static void retrieveCloudmadeKey(Context paramContext)
  {
    mAndroidId = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    mKey = ManifestUtil.retrieveKey(paramContext, "CLOUDMADE_KEY");
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    mPreferenceEditor = paramContext.edit();
    if (paramContext.getString("CLOUDMADE_ID", "").equals(mAndroidId))
    {
      mToken = paramContext.getString("CLOUDMADE_TOKEN", "");
      if (mToken.length() > 0) {
        mPreferenceEditor = null;
      }
      return;
    }
    mPreferenceEditor.putString("CLOUDMADE_ID", mAndroidId);
    mPreferenceEditor.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/util/CloudmadeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */