package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment
  extends Fragment
{
  private final Fragment Mj = this;
  private WalletFragmentOptions akk;
  private WalletFragmentInitParams akl;
  private MaskedWalletRequest akm;
  private MaskedWallet akn;
  private Boolean ako;
  private h akt;
  private final b aku = b.a(this);
  private final i akv = new i(this, null);
  private g akw = new g(this);
  private boolean mCreated = false;
  
  public static WalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    WalletFragment localWalletFragment = new WalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localWalletFragment.Mj.setArguments(localBundle);
    return localWalletFragment;
  }
  
  public int getState()
  {
    if (this.akt != null) {
      return h.a(this.akt);
    }
    return 0;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.akt != null)
    {
      h.a(this.akt, paramWalletFragmentInitParams);
      this.akl = null;
    }
    do
    {
      return;
      if (this.akl != null) {
        break;
      }
      this.akl = paramWalletFragmentInitParams;
      if (this.akm != null) {
        Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
      }
    } while (this.akn == null);
    Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
    return;
    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.akt != null) {
      h.a(this.akt, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject;
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
      localObject = (WalletFragmentInitParams)paramBundle.getParcelable("walletFragmentInitParams");
      if (localObject != null)
      {
        if (this.akl != null) {
          Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
        }
        this.akl = ((WalletFragmentInitParams)localObject);
      }
      if (this.akm == null) {
        this.akm = ((MaskedWalletRequest)paramBundle.getParcelable("maskedWalletRequest"));
      }
      if (this.akn == null) {
        this.akn = ((MaskedWallet)paramBundle.getParcelable("maskedWallet"));
      }
      if (paramBundle.containsKey("walletFragmentOptions")) {
        this.akk = ((WalletFragmentOptions)paramBundle.getParcelable("walletFragmentOptions"));
      }
      if (paramBundle.containsKey("enabled")) {
        this.ako = Boolean.valueOf(paramBundle.getBoolean("enabled"));
      }
    }
    for (;;)
    {
      this.mCreated = true;
      this.akv.onCreate(paramBundle);
      return;
      if (this.Mj.getArguments() != null)
      {
        localObject = (WalletFragmentOptions)this.Mj.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localObject != null)
        {
          ((WalletFragmentOptions)localObject).Q(this.Mj.getActivity());
          this.akk = ((WalletFragmentOptions)localObject);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.akv.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mCreated = false;
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    if (this.akk == null) {
      this.akk = WalletFragmentOptions.a(paramActivity, paramAttributeSet);
    }
    paramAttributeSet = new Bundle();
    paramAttributeSet.putParcelable("attrKeyWalletFragmentOptions", this.akk);
    this.akv.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.akv.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.akv.onResume();
    FragmentManager localFragmentManager = this.Mj.getActivity().getFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Mj.getActivity()), this.Mj.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.akv.onSaveInstanceState(paramBundle);
    if (this.akl != null)
    {
      paramBundle.putParcelable("walletFragmentInitParams", this.akl);
      this.akl = null;
    }
    if (this.akm != null)
    {
      paramBundle.putParcelable("maskedWalletRequest", this.akm);
      this.akm = null;
    }
    if (this.akn != null)
    {
      paramBundle.putParcelable("maskedWallet", this.akn);
      this.akn = null;
    }
    if (this.akk != null)
    {
      paramBundle.putParcelable("walletFragmentOptions", this.akk);
      this.akk = null;
    }
    if (this.ako != null)
    {
      paramBundle.putBoolean("enabled", this.ako.booleanValue());
      this.ako = null;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.akv.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.akv.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.akt != null)
    {
      h.a(this.akt, paramBoolean);
      this.ako = null;
      return;
    }
    this.ako = Boolean.valueOf(paramBoolean);
  }
  
  public void setOnStateChangedListener(WalletFragment.OnStateChangedListener paramOnStateChangedListener)
  {
    this.akw.a(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.akt != null)
    {
      h.a(this.akt, paramMaskedWallet);
      this.akn = null;
      return;
    }
    this.akn = paramMaskedWallet;
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.akt != null)
    {
      h.a(this.akt, paramMaskedWalletRequest);
      this.akm = null;
      return;
    }
    this.akm = paramMaskedWalletRequest;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */