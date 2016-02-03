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
  final e abq;
  
  PlusClient(e parame)
  {
    this.abq = parame;
  }
  
  @Deprecated
  public void clearDefaultAccount()
  {
    this.abq.clearDefaultAccount();
  }
  
  @Deprecated
  public void connect()
  {
    this.abq.connect();
  }
  
  @Deprecated
  public void disconnect()
  {
    this.abq.disconnect();
  }
  
  @Deprecated
  public String getAccountName()
  {
    return this.abq.getAccountName();
  }
  
  @Deprecated
  public Person getCurrentPerson()
  {
    return this.abq.getCurrentPerson();
  }
  
  @Deprecated
  public boolean isConnected()
  {
    return this.abq.isConnected();
  }
  
  @Deprecated
  public boolean isConnecting()
  {
    return this.abq.isConnecting();
  }
  
  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.abq.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.abq.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  e jN()
  {
    return this.abq;
  }
  
  @Deprecated
  public void loadMoments(final OnMomentsLoadedListener paramOnMomentsLoadedListener)
  {
    this.abq.k(new a.d()
    {
      public void a(Moments.LoadMomentsResult paramAnonymousLoadMomentsResult)
      {
        paramOnMomentsLoadedListener.onMomentsLoaded(paramAnonymousLoadMomentsResult.getStatus().eM(), paramAnonymousLoadMomentsResult.getMomentBuffer(), paramAnonymousLoadMomentsResult.getNextPageToken(), paramAnonymousLoadMomentsResult.getUpdated());
      }
    });
  }
  
  @Deprecated
  public void loadMoments(final OnMomentsLoadedListener paramOnMomentsLoadedListener, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    this.abq.a(new a.d()
    {
      public void a(Moments.LoadMomentsResult paramAnonymousLoadMomentsResult)
      {
        paramOnMomentsLoadedListener.onMomentsLoaded(paramAnonymousLoadMomentsResult.getStatus().eM(), paramAnonymousLoadMomentsResult.getMomentBuffer(), paramAnonymousLoadMomentsResult.getNextPageToken(), paramAnonymousLoadMomentsResult.getUpdated());
      }
    }, paramInt, paramString1, paramUri, paramString2, paramString3);
  }
  
  @Deprecated
  public void loadPeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, Collection<String> paramCollection)
  {
    this.abq.a(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eM(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramCollection);
  }
  
  @Deprecated
  public void loadPeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, String... paramVarArgs)
  {
    this.abq.d(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eM(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramVarArgs);
  }
  
  @Deprecated
  public void loadVisiblePeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, int paramInt, String paramString)
  {
    this.abq.a(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eM(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramInt, paramString);
  }
  
  @Deprecated
  public void loadVisiblePeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, String paramString)
  {
    this.abq.r(new a.d()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().eM(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }, paramString);
  }
  
  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.abq.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.abq.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void removeMoment(String paramString)
  {
    this.abq.removeMoment(paramString);
  }
  
  @Deprecated
  public void revokeAccessAndDisconnect(final OnAccessRevokedListener paramOnAccessRevokedListener)
  {
    this.abq.m(new a.d()
    {
      public void al(Status paramAnonymousStatus)
      {
        paramOnAccessRevokedListener.onAccessRevoked(paramAnonymousStatus.getStatus().eM());
      }
    });
  }
  
  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.abq.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.abq.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void writeMoment(Moment paramMoment)
  {
    this.abq.a(null, paramMoment);
  }
  
  @Deprecated
  public static class Builder
  {
    private final GooglePlayServicesClient.ConnectionCallbacks abv;
    private final GooglePlayServicesClient.OnConnectionFailedListener abw;
    private final i abx;
    private final Context mContext;
    
    public Builder(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.mContext = paramContext;
      this.abv = paramConnectionCallbacks;
      this.abw = paramOnConnectionFailedListener;
      this.abx = new i(this.mContext);
    }
    
    public PlusClient build()
    {
      return new PlusClient(new e(this.mContext, this.abv, this.abw, this.abx.ke()));
    }
    
    public Builder clearScopes()
    {
      this.abx.kd();
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      this.abx.bz(paramString);
      return this;
    }
    
    public Builder setActions(String... paramVarArgs)
    {
      this.abx.f(paramVarArgs);
      return this;
    }
    
    public Builder setScopes(String... paramVarArgs)
    {
      this.abx.e(paramVarArgs);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/plus/PlusClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */