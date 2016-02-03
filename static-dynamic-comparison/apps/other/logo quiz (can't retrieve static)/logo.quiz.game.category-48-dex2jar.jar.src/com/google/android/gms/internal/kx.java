package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.i;
import com.google.android.gms.fitness.result.DataTypeResult;

public class kx
  implements ConfigApi
{
  public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient paramGoogleApiClient, final DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    paramGoogleApiClient.b(new kj.a()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kx.a locala = new kx.a(this, null);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramDataTypeCreateRequest, locala, str);
      }
      
      protected DataTypeResult x(Status paramAnonymousStatus)
      {
        return DataTypeResult.F(paramAnonymousStatus);
      }
    });
  }
  
  public PendingResult<Status> disableFit(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.b(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(localb, str);
      }
    });
  }
  
  public PendingResult<DataTypeResult> readDataType(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    paramGoogleApiClient.a(new kj.a()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kx.a locala = new kx.a(this, null);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(this.Tw, locala, str);
      }
      
      protected DataTypeResult x(Status paramAnonymousStatus)
      {
        return DataTypeResult.F(paramAnonymousStatus);
      }
    });
  }
  
  private static class a
    extends kn.a
  {
    private final BaseImplementation.b<DataTypeResult> De;
    
    private a(BaseImplementation.b<DataTypeResult> paramb)
    {
      this.De = paramb;
    }
    
    public void a(DataTypeResult paramDataTypeResult)
    {
      this.De.b(paramDataTypeResult);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/kx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */