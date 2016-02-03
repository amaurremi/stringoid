package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.l;
import com.google.android.gms.fitness.data.l.a;
import com.google.android.gms.fitness.request.DataSourceListener;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.n;
import com.google.android.gms.fitness.request.p;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class lb
  implements SensorsApi
{
  private PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final n paramn)
  {
    paramGoogleApiClient.a(new a()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramn, localb, str);
      }
      
      protected Status d(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  private PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final p paramp, final DataSourceListener paramDataSourceListener)
  {
    paramGoogleApiClient.b(new a()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        lb.c localc = new lb.c(this, paramDataSourceListener, null);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramp, localc, str);
      }
      
      protected Status d(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient paramGoogleApiClient, final DataSourcesRequest paramDataSourcesRequest)
  {
    paramGoogleApiClient.a(new a()
    {
      protected DataSourcesResult A(Status paramAnonymousStatus)
      {
        return DataSourcesResult.E(paramAnonymousStatus);
      }
      
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        lb.b localb = new lb.b(this, null);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramDataSourcesRequest, localb, str);
      }
    });
  }
  
  public PendingResult<Status> register(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, PendingIntent paramPendingIntent)
  {
    return a(paramGoogleApiClient, new n(paramSensorRequest, null, paramPendingIntent));
  }
  
  public PendingResult<Status> register(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, DataSourceListener paramDataSourceListener)
  {
    return a(paramGoogleApiClient, new n(paramSensorRequest, l.a.iO().a(paramDataSourceListener), null));
  }
  
  public PendingResult<Status> unregister(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return a(paramGoogleApiClient, new p(null, paramPendingIntent), null);
  }
  
  public PendingResult<Status> unregister(GoogleApiClient paramGoogleApiClient, DataSourceListener paramDataSourceListener)
  {
    l locall = l.a.iO().b(paramDataSourceListener);
    if (locall == null) {
      return new kt(Status.Jo);
    }
    return a(paramGoogleApiClient, new p(locall, null), paramDataSourceListener);
  }
  
  private static abstract class a<R extends Result>
    extends BaseImplementation.a<R, kj>
  {
    public a()
    {
      super();
    }
  }
  
  private static class b
    extends km.a
  {
    private final BaseImplementation.b<DataSourcesResult> De;
    
    private b(BaseImplementation.b<DataSourcesResult> paramb)
    {
      this.De = paramb;
    }
    
    public void a(DataSourcesResult paramDataSourcesResult)
    {
      this.De.b(paramDataSourcesResult);
    }
  }
  
  private static class c
    extends ks.a
  {
    private final BaseImplementation.b<Status> De;
    private final DataSourceListener TM;
    
    private c(BaseImplementation.b<Status> paramb, DataSourceListener paramDataSourceListener)
    {
      this.De = paramb;
      this.TM = paramDataSourceListener;
    }
    
    public void k(Status paramStatus)
    {
      if ((this.TM != null) && (paramStatus.isSuccess())) {
        l.a.iO().c(this.TM);
      }
      this.De.b(paramStatus);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */