package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.lk;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

class e
  implements LifecycleDelegate
{
  private final lk a;
  
  private e(lk paramlk)
  {
    this.a = paramlk;
  }
  
  private int a()
  {
    try
    {
      int i = this.a.getState();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (RemoteException paramIntent)
    {
      throw new RuntimeException(paramIntent);
    }
  }
  
  private void a(MaskedWallet paramMaskedWallet)
  {
    try
    {
      this.a.updateMaskedWallet(paramMaskedWallet);
      return;
    }
    catch (RemoteException paramMaskedWallet)
    {
      throw new RuntimeException(paramMaskedWallet);
    }
  }
  
  private void a(MaskedWalletRequest paramMaskedWalletRequest)
  {
    try
    {
      this.a.updateMaskedWalletRequest(paramMaskedWalletRequest);
      return;
    }
    catch (RemoteException paramMaskedWalletRequest)
    {
      throw new RuntimeException(paramMaskedWalletRequest);
    }
  }
  
  private void a(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    try
    {
      this.a.initialize(paramWalletFragmentInitParams);
      return;
    }
    catch (RemoteException paramWalletFragmentInitParams)
    {
      throw new RuntimeException(paramWalletFragmentInitParams);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      this.a.setEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      this.a.onCreate(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      throw new RuntimeException(paramBundle);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      paramLayoutInflater = (View)com.google.android.gms.dynamic.e.e(this.a.onCreateView(com.google.android.gms.dynamic.e.h(paramLayoutInflater), com.google.android.gms.dynamic.e.h(paramViewGroup), paramBundle));
      return paramLayoutInflater;
    }
    catch (RemoteException paramLayoutInflater)
    {
      throw new RuntimeException(paramLayoutInflater);
    }
  }
  
  public void onDestroy() {}
  
  public void onDestroyView() {}
  
  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle1 = (WalletFragmentOptions)paramBundle1.getParcelable("extraWalletFragmentOptions");
    try
    {
      this.a.a(com.google.android.gms.dynamic.e.h(paramActivity), paramBundle1, paramBundle2);
      return;
    }
    catch (RemoteException paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
  }
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    try
    {
      this.a.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public void onResume()
  {
    try
    {
      this.a.onResume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      this.a.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      throw new RuntimeException(paramBundle);
    }
  }
  
  public void onStart()
  {
    try
    {
      this.a.onStart();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public void onStop()
  {
    try
    {
      this.a.onStop();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */