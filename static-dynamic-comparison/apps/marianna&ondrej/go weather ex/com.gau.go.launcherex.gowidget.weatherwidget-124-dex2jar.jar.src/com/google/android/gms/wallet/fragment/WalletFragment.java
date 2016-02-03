package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja.a;
import com.google.android.gms.internal.jh;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment
  extends Fragment
{
  private final Fragment Hv = this;
  private WalletFragmentInitParams acA;
  private MaskedWalletRequest acB;
  private Boolean acC;
  private b acH;
  private final b acI = b.a(this);
  private final c acJ = new c(null);
  private a acK = new a(this);
  private WalletFragmentOptions acz;
  private boolean mCreated = false;
  
  public static WalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    WalletFragment localWalletFragment = new WalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localWalletFragment.Hv.setArguments(localBundle);
    return localWalletFragment;
  }
  
  public int getState()
  {
    if (this.acH != null) {
      return b.a(this.acH);
    }
    return 0;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.acH != null)
    {
      b.a(this.acH, paramWalletFragmentInitParams);
      this.acA = null;
    }
    do
    {
      return;
      if (this.acA != null) {
        break;
      }
      this.acA = paramWalletFragmentInitParams;
    } while (this.acB == null);
    Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
    return;
    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.acH != null) {
      b.a(this.acH, paramInt1, paramInt2, paramIntent);
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
        if (this.acA != null) {
          Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
        }
        this.acA = ((WalletFragmentInitParams)localObject);
      }
      if (this.acB == null) {
        this.acB = ((MaskedWalletRequest)paramBundle.getParcelable("maskedWalletRequest"));
      }
      if (paramBundle.containsKey("walletFragmentOptions")) {
        this.acz = ((WalletFragmentOptions)paramBundle.getParcelable("walletFragmentOptions"));
      }
      if (paramBundle.containsKey("enabled")) {
        this.acC = Boolean.valueOf(paramBundle.getBoolean("enabled"));
      }
    }
    for (;;)
    {
      this.mCreated = true;
      this.acJ.onCreate(paramBundle);
      return;
      if (this.Hv.getArguments() != null)
      {
        localObject = (WalletFragmentOptions)this.Hv.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localObject != null)
        {
          ((WalletFragmentOptions)localObject).I(this.Hv.getActivity());
          this.acz = ((WalletFragmentOptions)localObject);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.acJ.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mCreated = false;
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    if (this.acz == null) {
      this.acz = WalletFragmentOptions.a(paramActivity, paramAttributeSet);
    }
    paramAttributeSet = new Bundle();
    paramAttributeSet.putParcelable("attrKeyWalletFragmentOptions", this.acz);
    this.acJ.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.acJ.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.acJ.onResume();
    FragmentManager localFragmentManager = this.Hv.getActivity().getFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Hv.getActivity()), this.Hv.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.acJ.onSaveInstanceState(paramBundle);
    if (this.acA != null)
    {
      paramBundle.putParcelable("walletFragmentInitParams", this.acA);
      this.acA = null;
    }
    if (this.acB != null)
    {
      paramBundle.putParcelable("maskedWalletRequest", this.acB);
      this.acB = null;
    }
    if (this.acz != null)
    {
      paramBundle.putParcelable("walletFragmentOptions", this.acz);
      this.acz = null;
    }
    if (this.acC != null)
    {
      paramBundle.putBoolean("enabled", this.acC.booleanValue());
      this.acC = null;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.acJ.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.acJ.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.acH != null)
    {
      b.a(this.acH, paramBoolean);
      this.acC = null;
      return;
    }
    this.acC = Boolean.valueOf(paramBoolean);
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.acK.a(paramOnStateChangedListener);
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.acH != null)
    {
      b.a(this.acH, paramMaskedWalletRequest);
      this.acB = null;
      return;
    }
    this.acB = paramMaskedWalletRequest;
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void onStateChanged(WalletFragment paramWalletFragment, int paramInt1, int paramInt2, Bundle paramBundle);
  }
  
  static class a
    extends ja.a
  {
    private WalletFragment.OnStateChangedListener acL;
    private final WalletFragment acM;
    
    a(WalletFragment paramWalletFragment)
    {
      this.acM = paramWalletFragment;
    }
    
    public void a(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (this.acL != null) {
        this.acL.onStateChanged(this.acM, paramInt1, paramInt2, paramBundle);
      }
    }
    
    public void a(WalletFragment.OnStateChangedListener paramOnStateChangedListener)
    {
      this.acL = paramOnStateChangedListener;
    }
  }
  
  private static class b
    implements LifecycleDelegate
  {
    private final iz acF;
    
    private b(iz paramiz)
    {
      this.acF = paramiz;
    }
    
    private int getState()
    {
      try
      {
        int i = this.acF.getState();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
    {
      try
      {
        this.acF.initialize(paramWalletFragmentInitParams);
        return;
      }
      catch (RemoteException paramWalletFragmentInitParams)
      {
        throw new RuntimeException(paramWalletFragmentInitParams);
      }
    }
    
    private void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      try
      {
        this.acF.onActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (RemoteException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
    }
    
    private void setEnabled(boolean paramBoolean)
    {
      try
      {
        this.acF.setEnabled(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
    {
      try
      {
        this.acF.updateMaskedWalletRequest(paramMaskedWalletRequest);
        return;
      }
      catch (RemoteException paramMaskedWalletRequest)
      {
        throw new RuntimeException(paramMaskedWalletRequest);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.acF.onCreate(paramBundle);
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
        paramLayoutInflater = (View)e.d(this.acF.onCreateView(e.h(paramLayoutInflater), e.h(paramViewGroup), paramBundle));
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
        this.acF.a(e.h(paramActivity), paramBundle1, paramBundle2);
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
        this.acF.onPause();
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
        this.acF.onResume();
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
        this.acF.onSaveInstanceState(paramBundle);
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
        this.acF.onStart();
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
        this.acF.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
  }
  
  private class c
    extends a<WalletFragment.b>
    implements View.OnClickListener
  {
    private c() {}
    
    protected void a(FrameLayout paramFrameLayout)
    {
      Button localButton = new Button(WalletFragment.a(WalletFragment.this).getActivity());
      localButton.setText(R.string.wallet_buy_button_place_holder);
      int k = -1;
      int m = -2;
      int j = m;
      int i = k;
      if (WalletFragment.e(WalletFragment.this) != null)
      {
        WalletFragmentStyle localWalletFragmentStyle = WalletFragment.e(WalletFragment.this).getFragmentStyle();
        j = m;
        i = k;
        if (localWalletFragmentStyle != null)
        {
          DisplayMetrics localDisplayMetrics = WalletFragment.a(WalletFragment.this).getResources().getDisplayMetrics();
          i = localWalletFragmentStyle.a("buyButtonWidth", localDisplayMetrics, -1);
          j = localWalletFragmentStyle.a("buyButtonHeight", localDisplayMetrics, -2);
        }
      }
      localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
      localButton.setOnClickListener(this);
      paramFrameLayout.addView(localButton);
    }
    
    protected void a(f<WalletFragment.b> paramf)
    {
      Object localObject = WalletFragment.a(WalletFragment.this).getActivity();
      if ((WalletFragment.b(WalletFragment.this) == null) && (WalletFragment.c(WalletFragment.this)) && (localObject != null)) {}
      try
      {
        localObject = jh.a((Activity)localObject, WalletFragment.d(WalletFragment.this), WalletFragment.e(WalletFragment.this), WalletFragment.f(WalletFragment.this));
        WalletFragment.a(WalletFragment.this, new WalletFragment.b((iz)localObject, null));
        WalletFragment.a(WalletFragment.this, null);
        paramf.a(WalletFragment.b(WalletFragment.this));
        if (WalletFragment.g(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.g(WalletFragment.this));
          WalletFragment.a(WalletFragment.this, null);
        }
        if (WalletFragment.h(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.h(WalletFragment.this));
          WalletFragment.a(WalletFragment.this, null);
        }
        if (WalletFragment.i(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.i(WalletFragment.this).booleanValue());
          WalletFragment.a(WalletFragment.this, null);
        }
        return;
      }
      catch (GooglePlayServicesNotAvailableException paramf) {}
    }
    
    public void onClick(View paramView)
    {
      paramView = WalletFragment.a(WalletFragment.this).getActivity();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramView), paramView, -1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */