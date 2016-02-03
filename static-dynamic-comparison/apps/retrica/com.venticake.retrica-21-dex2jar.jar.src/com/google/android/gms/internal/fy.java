package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import java.util.List;

public final class fy
  implements AppIndexApi, ft
{
  static Uri a(String paramString, Uri paramUri)
  {
    if (!"android-app".equals(paramUri.getScheme())) {
      throw new IllegalArgumentException("Uri scheme must be android-app: " + paramUri);
    }
    if (!paramString.equals(paramUri.getHost())) {
      throw new IllegalArgumentException("Uri host must match package name: " + paramUri);
    }
    paramString = paramUri.getPathSegments();
    if ((paramString.isEmpty()) || (((String)paramString.get(0)).isEmpty())) {
      throw new IllegalArgumentException("Uri path must exist: " + paramUri);
    }
    String str = (String)paramString.get(0);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme(str);
    if (paramString.size() > 1)
    {
      localBuilder.authority((String)paramString.get(1));
      int i = 2;
      while (i < paramString.size())
      {
        localBuilder.appendPath((String)paramString.get(i));
        i += 1;
      }
    }
    localBuilder.encodedQuery(paramUri.getEncodedQuery());
    localBuilder.encodedFragment(paramUri.getEncodedFragment());
    return localBuilder.build();
  }
  
  public PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final fr... paramVarArgs)
  {
    paramGoogleApiClient.a(new nx(((fx)paramGoogleApiClient.a(ff.xI)).getContext().getPackageName())
    {
      protected void a(fu paramAnonymousfu)
      {
        paramAnonymousfu.a(new ny(this), this.a, paramVarArgs);
      }
    });
  }
  
  public PendingResult<Status> view(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Intent paramIntent, String paramString, Uri paramUri, List<AppIndexApi.AppIndexingLink> paramList)
  {
    return a(paramGoogleApiClient, new fr[] { new fr(((fx)paramGoogleApiClient.a(ff.xI)).getContext().getPackageName(), paramIntent, paramString, paramUri, null, paramList) });
  }
  
  public PendingResult<Status> view(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Uri paramUri1, String paramString, Uri paramUri2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    return view(paramGoogleApiClient, paramActivity, new Intent("android.intent.action.VIEW", a(((fx)paramGoogleApiClient.a(ff.xI)).getContext().getPackageName(), paramUri1)), paramString, paramUri2, paramList);
  }
  
  public PendingResult<Status> viewEnd(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Intent paramIntent)
  {
    return a(paramGoogleApiClient, new fr[] { new fr(fr.a(((fx)paramGoogleApiClient.a(ff.xI)).getContext().getPackageName(), paramIntent), System.currentTimeMillis(), 3) });
  }
  
  public PendingResult<Status> viewEnd(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Uri paramUri)
  {
    return viewEnd(paramGoogleApiClient, paramActivity, new Intent("android.intent.action.VIEW", a(((fx)paramGoogleApiClient.a(ff.xI)).getContext().getPackageName(), paramUri)));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */