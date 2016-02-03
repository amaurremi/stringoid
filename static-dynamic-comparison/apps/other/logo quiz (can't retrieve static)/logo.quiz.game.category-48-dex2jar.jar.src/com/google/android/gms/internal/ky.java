package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataInsertRequest.Builder;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;

public class ky
  implements HistoryApi
{
  public PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, final DataDeleteRequest paramDataDeleteRequest)
  {
    paramGoogleApiClient.a(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramDataDeleteRequest, localb, str);
      }
    });
  }
  
  @Deprecated
  public PendingResult<Status> insert(GoogleApiClient paramGoogleApiClient, final DataInsertRequest paramDataInsertRequest)
  {
    paramGoogleApiClient.a(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramDataInsertRequest, localb, str);
      }
    });
  }
  
  public PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet)
  {
    return insert(paramGoogleApiClient, new DataInsertRequest.Builder().setDataSet(paramDataSet).build());
  }
  
  public PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, final DataReadRequest paramDataReadRequest)
  {
    paramGoogleApiClient.a(new kj.a()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        ky.a locala = new ky.a(this, null);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramDataReadRequest, locala, str);
      }
      
      protected DataReadResult y(Status paramAnonymousStatus)
      {
        return DataReadResult.a(paramAnonymousStatus, paramDataReadRequest);
      }
    });
  }
  
  private static class a
    extends kl.a
  {
    private final BaseImplementation.b<DataReadResult> De;
    private int TB = 0;
    private DataReadResult TC = null;
    
    private a(BaseImplementation.b<DataReadResult> paramb)
    {
      this.De = paramb;
    }
    
    /* Error */
    public void a(DataReadResult paramDataReadResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 34
      //   4: ldc 36
      //   6: invokestatic 42	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   9: pop
      //   10: aload_0
      //   11: getfield 23	com/google/android/gms/internal/ky$a:TC	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   14: ifnonnull +48 -> 62
      //   17: aload_0
      //   18: aload_1
      //   19: putfield 23	com/google/android/gms/internal/ky$a:TC	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   22: aload_0
      //   23: aload_0
      //   24: getfield 21	com/google/android/gms/internal/ky$a:TB	I
      //   27: iconst_1
      //   28: iadd
      //   29: putfield 21	com/google/android/gms/internal/ky$a:TB	I
      //   32: aload_0
      //   33: getfield 21	com/google/android/gms/internal/ky$a:TB	I
      //   36: aload_0
      //   37: getfield 23	com/google/android/gms/internal/ky$a:TC	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   40: invokevirtual 48	com/google/android/gms/fitness/result/DataReadResult:jF	()I
      //   43: if_icmpne +16 -> 59
      //   46: aload_0
      //   47: getfield 25	com/google/android/gms/internal/ky$a:De	Lcom/google/android/gms/common/api/BaseImplementation$b;
      //   50: aload_0
      //   51: getfield 23	com/google/android/gms/internal/ky$a:TC	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   54: invokeinterface 54 2 0
      //   59: aload_0
      //   60: monitorexit
      //   61: return
      //   62: aload_0
      //   63: getfield 23	com/google/android/gms/internal/ky$a:TC	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   66: aload_1
      //   67: invokevirtual 56	com/google/android/gms/fitness/result/DataReadResult:b	(Lcom/google/android/gms/fitness/result/DataReadResult;)V
      //   70: goto -48 -> 22
      //   73: astore_1
      //   74: aload_0
      //   75: monitorexit
      //   76: aload_1
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	paramDataReadResult	DataReadResult
      // Exception table:
      //   from	to	target	type
      //   2	22	73	finally
      //   22	59	73	finally
      //   59	61	73	finally
      //   62	70	73	finally
      //   74	76	73	finally
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */