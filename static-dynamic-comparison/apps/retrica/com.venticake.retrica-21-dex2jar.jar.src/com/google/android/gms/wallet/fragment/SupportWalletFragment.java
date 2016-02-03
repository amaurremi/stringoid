package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.l;
import android.support.v4.app.p;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment
  extends Fragment
{
  private final Fragment FV = this;
  private e akg;
  private final com.google.android.gms.dynamic.h akh = com.google.android.gms.dynamic.h.a(this);
  private final f aki = new f(this, null);
  private d akj = new d(this);
  private WalletFragmentOptions akk;
  private WalletFragmentInitParams akl;
  private MaskedWalletRequest akm;
  private MaskedWallet akn;
  private Boolean ako;
  private boolean mCreated = false;
  
  public static SupportWalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    SupportWalletFragment localSupportWalletFragment = new SupportWalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localSupportWalletFragment.FV.setArguments(localBundle);
    return localSupportWalletFragment;
  }
  
  public int getState()
  {
    if (this.akg != null) {
      return e.a(this.akg);
    }
    return 0;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.akg != null)
    {
      e.a(this.akg, paramWalletFragmentInitParams);
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
        Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
      }
    } while (this.akn == null);
    Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
    return;
    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.akg != null) {
      e.a(this.akg, paramInt1, paramInt2, paramIntent);
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
          Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
      this.aki.onCreate(paramBundle);
      return;
      if (this.FV.getArguments() != null)
      {
        localObject = (WalletFragmentOptions)this.FV.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localObject != null)
        {
          ((WalletFragmentOptions)localObject).Q(this.FV.getActivity());
          this.akk = ((WalletFragmentOptions)localObject);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.aki.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
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
    this.aki.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.aki.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.aki.onResume();
    l locall = this.FV.getActivity().e();
    Fragment localFragment = locall.a("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      locall.a().a(localFragment).a();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.FV.getActivity()), this.FV.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.aki.onSaveInstanceState(paramBundle);
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
    this.aki.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.aki.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.akg != null)
    {
      e.a(this.akg, paramBoolean);
      this.ako = null;
      return;
    }
    this.ako = Boolean.valueOf(paramBoolean);
  }
  
  public void setOnStateChangedListener(SupportWalletFragment.OnStateChangedListener paramOnStateChangedListener)
  {
    this.akj.a(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.akg != null)
    {
      e.a(this.akg, paramMaskedWallet);
      this.akn = null;
      return;
    }
    this.akn = paramMaskedWallet;
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.akg != null)
    {
      e.a(this.akg, paramMaskedWalletRequest);
      this.akm = null;
      return;
    }
    this.akm = paramMaskedWalletRequest;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/SupportWalletFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */