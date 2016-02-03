package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class ae
  implements MessageApi
{
  private PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final MessageApi.MessageListener paramMessageListener, final IntentFilter[] paramArrayOfIntentFilter)
  {
    paramGoogleApiClient.a(new az()
    {
      public Status a(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramMessageListener, paramArrayOfIntentFilter);
      }
    });
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    return a(paramGoogleApiClient, paramMessageListener, null);
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final MessageApi.MessageListener paramMessageListener)
  {
    paramGoogleApiClient.a(new az()
    {
      public Status a(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramMessageListener);
      }
    });
  }
  
  public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    paramGoogleApiClient.a(new az()
    {
      protected MessageApi.SendMessageResult a(Status paramAnonymousStatus)
      {
        return new ae.a(paramAnonymousStatus, -1);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramString1, paramString2, paramArrayOfByte);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */