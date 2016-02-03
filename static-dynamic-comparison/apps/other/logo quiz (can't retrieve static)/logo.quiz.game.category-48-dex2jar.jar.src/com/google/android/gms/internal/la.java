package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.data.Subscription.a;
import com.google.android.gms.fitness.request.ae;
import com.google.android.gms.fitness.request.ae.a;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.request.ah.a;
import com.google.android.gms.fitness.request.l;
import com.google.android.gms.fitness.request.l.a;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class la
  implements RecordingApi
{
  public PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final ae paramae)
  {
    paramGoogleApiClient.a(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramae, localb, str);
      }
    });
  }
  
  public PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final ah paramah)
  {
    paramGoogleApiClient.b(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramah, localb, str);
      }
    });
  }
  
  public PendingResult<ListSubscriptionsResult> a(GoogleApiClient paramGoogleApiClient, final l paraml)
  {
    paramGoogleApiClient.a(new kj.a()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        la.a locala = new la.a(this, null);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paraml, locala, str);
      }
      
      protected ListSubscriptionsResult z(Status paramAnonymousStatus)
      {
        return ListSubscriptionsResult.G(paramAnonymousStatus);
      }
    });
  }
  
  public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient)
  {
    return a(paramGoogleApiClient, new l.a().jk());
  }
  
  public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return a(paramGoogleApiClient, new l.a().c(paramDataType).jk());
  }
  
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return a(paramGoogleApiClient, new ae.a().b(new Subscription.a().b(paramDataSource).iR()).jD());
  }
  
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return a(paramGoogleApiClient, new ae.a().b(new Subscription.a().b(paramDataType).iR()).jD());
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return a(paramGoogleApiClient, new ah.a().d(paramDataSource).jE());
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return a(paramGoogleApiClient, new ah.a().d(paramDataType).jE());
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, Subscription paramSubscription)
  {
    if (paramSubscription.getDataType() == null) {
      return unsubscribe(paramGoogleApiClient, paramSubscription.getDataSource());
    }
    return unsubscribe(paramGoogleApiClient, paramSubscription.getDataType());
  }
  
  private static class a
    extends kp.a
  {
    private final BaseImplementation.b<ListSubscriptionsResult> De;
    
    private a(BaseImplementation.b<ListSubscriptionsResult> paramb)
    {
      this.De = paramb;
    }
    
    public void a(ListSubscriptionsResult paramListSubscriptionsResult)
    {
      this.De.b(paramListSubscriptionsResult);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/la.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */