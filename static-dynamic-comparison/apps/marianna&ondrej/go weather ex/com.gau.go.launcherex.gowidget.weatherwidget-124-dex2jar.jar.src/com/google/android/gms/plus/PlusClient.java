package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.i;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient
  implements GooglePlayServicesClient
{
  final e TL;
  
  PlusClient(e parame)
  {
    this.TL = parame;
  }
  
  @Deprecated
  public void clearDefaultAccount()
  {
    this.TL.clearDefaultAccount();
  }
  
  @Deprecated
  public void connect()
  {
    this.TL.connect();
  }
  
  @Deprecated
  public void disconnect()
  {
    this.TL.disconnect();
  }
  
  @Deprecated
  public String getAccountName()
  {
    return this.TL.getAccountName();
  }
  
  @Deprecated
  public Person getCurrentPerson()
  {
    return this.TL.getCurrentPerson();
  }
  
  e iI()
  {
    return this.TL;
  }
  
  @Deprecated
  public boolean isConnected()
  {
    return this.TL.isConnected();
  }
  
  @Deprecated
  public boolean isConnecting()
  {
    return this.TL.isConnecting();
  }
  
  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.TL.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.TL.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void loadMoments(final OnMomentsLoadedListener paramOnMomentsLoadedListener)
  {
    this.TL.l(new a.d()
    {
      public void a(Moments.LoadMomentsResult paramAnonymousLoadMomentsResult)
      {
        paramOnMomentsLoadedListener.onMomentsLoaded(paramAnonymousLoadMomentsResult.getStatus().eq(), paramAnonymousLoadMomentsResult.getMomentBuffer(), paramAnonymousLoadMomentsResult.getNextPageToken(), paramAnonymousLoadMomentsResult.getUpdated());
      }
    });
  }
  
  @Deprecated
  public void loadMoments(final OnMomentsLoadedListener paramOnMomentsLoadedListener, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    this.TL.a(new a.d()
    {
      public void a(Moments.LoadMomentsResult paramAnonymousLoadMomentsResult)
      {
        paramOnMomentsLoadedListener.onMomentsLoaded(paramAnonymousLoadMomentsResult.getStatus().eq(), paramAnonymousLoadMomentsResult.getMomentBuffer(), paramAnonymousLoadMomentsResult.getNextPageToken(), paramAnonymousLoadMomentsResult.getUpdated());
      }
    }, paramInt, paramString1, paramUri, paramString2, paramString3);
  }
  
  @Deprecated
  public void loadPeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, Collection<String> paramCollection)
  {
    this.TL.a(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eq(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramCollection);
  }
  
  @Deprecated
  public void loadPeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, String... paramVarArgs)
  {
    this.TL.d(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eq(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramVarArgs);
  }
  
  @Deprecated
  public void loadVisiblePeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, int paramInt, String paramString)
  {
    this.TL.a(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eq(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramInt, paramString);
  }
  
  @Deprecated
  public void loadVisiblePeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, String paramString)
  {
    this.TL.o(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eq(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramString);
  }
  
  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.TL.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.TL.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void removeMoment(String paramString)
  {
    this.TL.removeMoment(paramString);
  }
  
  @Deprecated
  public void revokeAccessAndDisconnect(final OnAccessRevokedListener paramOnAccessRevokedListener)
  {
    this.TL.n(new a.d()
    {
      public void Y(Status paramAnonymousStatus)
      {
        paramOnAccessRevokedListener.onAccessRevoked(paramAnonymousStatus.getStatus().eq());
      }
    });
  }
  
  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.TL.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.TL.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void writeMoment(Moment paramMoment)
  {
    this.TL.a(null, paramMoment);
  }
  
  @Deprecated
  public static class Builder
  {
    private final GooglePlayServicesClient.ConnectionCallbacks TQ;
    private final GooglePlayServicesClient.OnConnectionFailedListener TR;
    private final i TS;
    private final Context mContext;
    
    public Builder(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.mContext = paramContext;
      this.TQ = paramConnectionCallbacks;
      this.TR = paramOnConnectionFailedListener;
      this.TS = new i(this.mContext);
    }
    
    public PlusClient build()
    {
      return new PlusClient(new e(this.mContext, this.TQ, this.TR, this.TS.iZ()));
    }
    
    public Builder clearScopes()
    {
      this.TS.iY();
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      this.TS.bh(paramString);
      return this;
    }
    
    public Builder setActions(String... paramVarArgs)
    {
      this.TS.f(paramVarArgs);
      return this;
    }
    
    public Builder setScopes(String... paramVarArgs)
    {
      this.TS.e(paramVarArgs);
      return this;
    }
  }
  
  @Deprecated
  public static abstract interface OnAccessRevokedListener
  {
    public abstract void onAccessRevoked(ConnectionResult paramConnectionResult);
  }
  
  @Deprecated
  public static abstract interface OnMomentsLoadedListener
  {
    @Deprecated
    public abstract void onMomentsLoaded(ConnectionResult paramConnectionResult, MomentBuffer paramMomentBuffer, String paramString1, String paramString2);
  }
  
  @Deprecated
  public static abstract interface OnPeopleLoadedListener
  {
    public abstract void onPeopleLoaded(ConnectionResult paramConnectionResult, PersonBuffer paramPersonBuffer, String paramString);
  }
  
  @Deprecated
  public static abstract interface OrderBy
  {
    @Deprecated
    public static final int ALPHABETICAL = 0;
    @Deprecated
    public static final int BEST = 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/plus/PlusClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */