package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.t;
import com.google.android.gms.fitness.request.v.a;
import com.google.android.gms.fitness.request.x.a;
import com.google.android.gms.fitness.request.z;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

public class lc
  implements SessionsApi
{
  public PendingResult<Status> insertSession(GoogleApiClient paramGoogleApiClient, final SessionInsertRequest paramSessionInsertRequest)
  {
    paramGoogleApiClient.a(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramSessionInsertRequest, localb, str);
      }
    });
  }
  
  public PendingResult<SessionReadResult> readSession(GoogleApiClient paramGoogleApiClient, final SessionReadRequest paramSessionReadRequest)
  {
    paramGoogleApiClient.a(new kj.a()
    {
      protected SessionReadResult C(Status paramAnonymousStatus)
      {
        return SessionReadResult.H(paramAnonymousStatus);
      }
      
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        lc.a locala = new lc.a(this, null);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramSessionReadRequest, locala, str);
      }
    });
  }
  
  public PendingResult<Status> registerForSessions(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        t localt = new t(paramPendingIntent);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(localt, localb, str);
      }
    });
  }
  
  public PendingResult<Status> startSession(GoogleApiClient paramGoogleApiClient, final Session paramSession)
  {
    paramGoogleApiClient.b(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(new v.a().b(paramSession).jx(), localb, str);
      }
    });
  }
  
  public PendingResult<SessionStopResult> stopSession(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    paramGoogleApiClient.b(new kj.a()
    {
      protected SessionStopResult B(Status paramAnonymousStatus)
      {
        return SessionStopResult.I(paramAnonymousStatus);
      }
      
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        lc.b localb = new lc.b(this, null);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(new x.a().br(paramString1).bs(paramString2).jy(), localb, str);
      }
    });
  }
  
  public PendingResult<Status> unregisterForSessions(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        z localz = new z(paramPendingIntent);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(localz, localb, str);
      }
    });
  }
  
  private static class a
    extends kq.a
  {
    private final BaseImplementation.b<SessionReadResult> De;
    
    private a(BaseImplementation.b<SessionReadResult> paramb)
    {
      this.De = paramb;
    }
    
    public void a(SessionReadResult paramSessionReadResult)
      throws RemoteException
    {
      this.De.b(paramSessionReadResult);
    }
  }
  
  private static class b
    extends kr.a
  {
    private final BaseImplementation.b<SessionStopResult> De;
    
    private b(BaseImplementation.b<SessionStopResult> paramb)
    {
      this.De = paramb;
    }
    
    public void a(SessionStopResult paramSessionStopResult)
    {
      this.De.b(paramSessionStopResult);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */