package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.ny;

public abstract class a
  extends b.a
{
  public void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
    throws RemoteException
  {}
  
  public void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException
  {}
  
  public final void a(int paramInt, Bundle paramBundle, jp paramjp) {}
  
  public void a(int paramInt, ny paramny) {}
  
  public void a(DataHolder paramDataHolder, String paramString) {}
  
  public void a(DataHolder paramDataHolder, String paramString1, String paramString2) {}
  
  public void aB(Status paramStatus) {}
  
  public void cb(String paramString)
    throws RemoteException
  {}
  
  public void cc(String paramString) {}
  
  public void h(int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/plus/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */