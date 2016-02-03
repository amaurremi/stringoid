package com.google.android.gms.plus;

import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.people.Person;
import java.util.Collection;

@Deprecated
public class PlusClient
  implements GooglePlayServicesClient
{
  final e abt;
  
  PlusClient(e parame)
  {
    this.abt = parame;
  }
  
  @Deprecated
  public void clearDefaultAccount()
  {
    this.abt.clearDefaultAccount();
  }
  
  @Deprecated
  public void connect()
  {
    this.abt.connect();
  }
  
  @Deprecated
  public void disconnect()
  {
    this.abt.disconnect();
  }
  
  @Deprecated
  public String getAccountName()
  {
    return this.abt.getAccountName();
  }
  
  @Deprecated
  public Person getCurrentPerson()
  {
    return this.abt.getCurrentPerson();
  }
  
  @Deprecated
  public boolean isConnected()
  {
    return this.abt.isConnected();
  }
  
  @Deprecated
  public boolean isConnecting()
  {
    return this.abt.isConnecting();
  }
  
  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.abt.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.abt.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  e jS()
  {
    return this.abt;
  }
  
  @Deprecated
  public void loadMoments(final PlusClient.OnMomentsLoadedListener paramOnMomentsLoadedListener)
  {
    this.abt.k(new a.d()
    {
      public void a(Moments.LoadMomentsResult paramAnonymousLoadMomentsResult)
      {
        paramOnMomentsLoadedListener.onMomentsLoaded(paramAnonymousLoadMomentsResult.getStatus().eR(), paramAnonymousLoadMomentsResult.getMomentBuffer(), paramAnonymousLoadMomentsResult.getNextPageToken(), paramAnonymousLoadMomentsResult.getUpdated());
      }
    });
  }
  
  @Deprecated
  public void loadMoments(final PlusClient.OnMomentsLoadedListener paramOnMomentsLoadedListener, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    this.abt.a(new a.d()
    {
      public void a(Moments.LoadMomentsResult paramAnonymousLoadMomentsResult)
      {
        paramOnMomentsLoadedListener.onMomentsLoaded(paramAnonymousLoadMomentsResult.getStatus().eR(), paramAnonymousLoadMomentsResult.getMomentBuffer(), paramAnonymousLoadMomentsResult.getNextPageToken(), paramAnonymousLoadMomentsResult.getUpdated());
      }
    }, paramInt, paramString1, paramUri, paramString2, paramString3);
  }
  
  @Deprecated
  public void loadPeople(final PlusClient.OnPeopleLoadedListener paramOnPeopleLoadedListener, Collection<String> paramCollection)
  {
    this.abt.a(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eR(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramCollection);
  }
  
  @Deprecated
  public void loadPeople(final PlusClient.OnPeopleLoadedListener paramOnPeopleLoadedListener, String... paramVarArgs)
  {
    this.abt.d(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eR(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramVarArgs);
  }
  
  @Deprecated
  public void loadVisiblePeople(final PlusClient.OnPeopleLoadedListener paramOnPeopleLoadedListener, int paramInt, String paramString)
  {
    this.abt.a(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eR(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramInt, paramString);
  }
  
  @Deprecated
  public void loadVisiblePeople(final PlusClient.OnPeopleLoadedListener paramOnPeopleLoadedListener, String paramString)
  {
    this.abt.r(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eR(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramString);
  }
  
  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.abt.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.abt.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void removeMoment(String paramString)
  {
    this.abt.removeMoment(paramString);
  }
  
  @Deprecated
  public void revokeAccessAndDisconnect(final PlusClient.OnAccessRevokedListener paramOnAccessRevokedListener)
  {
    this.abt.m(new a.d()
    {
      public void a(Status paramAnonymousStatus)
      {
        paramOnAccessRevokedListener.onAccessRevoked(paramAnonymousStatus.getStatus().eR());
      }
    });
  }
  
  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.abt.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.abt.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void writeMoment(Moment paramMoment)
  {
    this.abt.a(null, paramMoment);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/PlusClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */