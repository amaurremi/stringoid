package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.pb.a;
import com.google.android.gms.internal.pm;
import java.util.List;

public class PutDataMapRequest
{
  private final DataMap auM;
  private final PutDataRequest auN;
  
  private PutDataMapRequest(PutDataRequest paramPutDataRequest, DataMap paramDataMap)
  {
    this.auN = paramPutDataRequest;
    this.auM = new DataMap();
    if (paramDataMap != null) {
      this.auM.putAll(paramDataMap);
    }
  }
  
  public static PutDataMapRequest create(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.create(paramString), null);
  }
  
  public static PutDataMapRequest createFromDataMapItem(DataMapItem paramDataMapItem)
  {
    return new PutDataMapRequest(PutDataRequest.k(paramDataMapItem.getUri()), paramDataMapItem.getDataMap());
  }
  
  public static PutDataMapRequest createWithAutoAppendedId(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(paramString), null);
  }
  
  public PutDataRequest asPutDataRequest()
  {
    pb.a locala = pb.a(this.auM);
    this.auN.setData(pm.f(locala.avQ));
    int j = locala.avR.size();
    int i = 0;
    while (i < j)
    {
      String str = Integer.toString(i);
      Asset localAsset = (Asset)locala.avR.get(i);
      if (str == null) {
        throw new IllegalStateException("asset key cannot be null: " + localAsset);
      }
      if (localAsset == null) {
        throw new IllegalStateException("asset cannot be null: key=" + str);
      }
      if (Log.isLoggable("DataMap", 3)) {
        Log.d("DataMap", "asPutDataRequest: adding asset: " + str + " " + localAsset);
      }
      this.auN.putAsset(str, localAsset);
      i += 1;
    }
    return this.auN;
  }
  
  public DataMap getDataMap()
  {
    return this.auM;
  }
  
  public Uri getUri()
  {
    return this.auN.getUri();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/PutDataMapRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */