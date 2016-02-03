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
import com.google.android.gms.internal.oq;
import com.google.android.gms.internal.or.a;
import com.google.android.gms.internal.oy;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment
  extends Fragment
{
  private final Fragment Sb = this;
  private WalletFragmentOptions atJ;
  private WalletFragmentInitParams atK;
  private MaskedWalletRequest atL;
  private MaskedWallet atM;
  private Boolean atN;
  private b atS;
  private final b atT = b.a(this);
  private final c atU = new c(null);
  private a atV = new a(this);
  private boolean mCreated = false;
  
  public static WalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    WalletFragment localWalletFragment = new WalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localWalletFragment.Sb.setArguments(localBundle);
    return localWalletFragment;
  }
  
  public int getState()
  {
    if (this.atS != null) {
      return b.a(this.atS);
    }
    return 0;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.atS != null)
    {
      b.a(this.atS, paramWalletFragmentInitParams);
      this.atK = null;
    }
    do
    {
      return;
      if (this.atK != null) {
        break;
      }
      this.atK = paramWalletFragmentInitParams;
      if (this.atL != null) {
        Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
      }
    } while (this.atM == null);
    Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
    return;
    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.atS != null) {
      b.a(this.atS, paramInt1, paramInt2, paramIntent);
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
        if (this.atK != null) {
          Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
        }
        this.atK = ((WalletFragmentInitParams)localObject);
      }
      if (this.atL == null) {
        this.atL = ((MaskedWalletRequest)paramBundle.getParcelable("maskedWalletRequest"));
      }
      if (this.atM == null) {
        this.atM = ((MaskedWallet)paramBundle.getParcelable("maskedWallet"));
      }
      if (paramBundle.containsKey("walletFragmentOptions")) {
        this.atJ = ((WalletFragmentOptions)paramBundle.getParcelable("walletFragmentOptions"));
      }
      if (paramBundle.containsKey("enabled")) {
        this.atN = Boolean.valueOf(paramBundle.getBoolean("enabled"));
      }
    }
    for (;;)
    {
      this.mCreated = true;
      this.atU.onCreate(paramBundle);
      return;
      if (this.Sb.getArguments() != null)
      {
        localObject = (WalletFragmentOptions)this.Sb.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localObject != null)
        {
          ((WalletFragmentOptions)localObject).Z(this.Sb.getActivity());
          this.atJ = ((WalletFragmentOptions)localObject);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.atU.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mCreated = false;
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    if (this.atJ == null) {
      this.atJ = WalletFragmentOptions.a(paramActivity, paramAttributeSet);
    }
    paramAttributeSet = new Bundle();
    paramAttributeSet.putParcelable("attrKeyWalletFragmentOptions", this.atJ);
    this.atU.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.atU.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.atU.onResume();
    FragmentManager localFragmentManager = this.Sb.getActivity().getFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Sb.getActivity()), this.Sb.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.atU.onSaveInstanceState(paramBundle);
    if (this.atK != null)
    {
      paramBundle.putParcelable("walletFragmentInitParams", this.atK);
      this.atK = null;
    }
    if (this.atL != null)
    {
      paramBundle.putParcelable("maskedWalletRequest", this.atL);
      this.atL = null;
    }
    if (this.atM != null)
    {
      paramBundle.putParcelable("maskedWallet", this.atM);
      this.atM = null;
    }
    if (this.atJ != null)
    {
      paramBundle.putParcelable("walletFragmentOptions", this.atJ);
      this.atJ = null;
    }
    if (this.atN != null)
    {
      paramBundle.putBoolean("enabled", this.atN.booleanValue());
      this.atN = null;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.atU.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.atU.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.atS != null)
    {
      b.a(this.atS, paramBoolean);
      this.atN = null;
      return;
    }
    this.atN = Boolean.valueOf(paramBoolean);
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.atV.a(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.atS != null)
    {
      b.a(this.atS, paramMaskedWallet);
      this.atM = null;
      return;
    }
    this.atM = paramMaskedWallet;
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.atS != null)
    {
      b.a(this.atS, paramMaskedWalletRequest);
      this.atL = null;
      return;
    }
    this.atL = paramMaskedWalletRequest;
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void onStateChanged(WalletFragment paramWalletFragment, int paramInt1, int paramInt2, Bundle paramBundle);
  }
  
  static class a
    extends or.a
  {
    private WalletFragment.OnStateChangedListener atW;
    private final WalletFragment atX;
    
    a(WalletFragment paramWalletFragment)
    {
      this.atX = paramWalletFragment;
    }
    
    public void a(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (this.atW != null) {
        this.atW.onStateChanged(this.atX, paramInt1, paramInt2, paramBundle);
      }
    }
    
    public void a(WalletFragment.OnStateChangedListener paramOnStateChangedListener)
    {
      this.atW = paramOnStateChangedListener;
    }
  }
  
  private static class b
    implements LifecycleDelegate
  {
    private final oq atQ;
    
    private b(oq paramoq)
    {
      this.atQ = paramoq;
    }
    
    private int getState()
    {
      try
      {
        int i = this.atQ.getState();
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
        this.atQ.initialize(paramWalletFragmentInitParams);
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
        this.atQ.onActivityResult(paramInt1, paramInt2, paramIntent);
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
        this.atQ.setEnabled(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void updateMaskedWallet(MaskedWallet paramMaskedWallet)
    {
      try
      {
        this.atQ.updateMaskedWallet(paramMaskedWallet);
        return;
      }
      catch (RemoteException paramMaskedWallet)
      {
        throw new RuntimeException(paramMaskedWallet);
      }
    }
    
    private void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
    {
      try
      {
        this.atQ.updateMaskedWalletRequest(paramMaskedWalletRequest);
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
        this.atQ.onCreate(paramBundle);
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
        paramLayoutInflater = (View)e.f(this.atQ.onCreateView(e.k(paramLayoutInflater), e.k(paramViewGroup), paramBundle));
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
        this.atQ.a(e.k(paramActivity), paramBundle1, paramBundle2);
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
        this.atQ.onPause();
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
        this.atQ.onResume();
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
        this.atQ.onSaveInstanceState(paramBundle);
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
        this.atQ.onStart();
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
        this.atQ.onStop();
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
        localObject = oy.a((Activity)localObject, WalletFragment.d(WalletFragment.this), WalletFragment.e(WalletFragment.this), WalletFragment.f(WalletFragment.this));
        WalletFragment.a(WalletFragment.this, new WalletFragment.b((oq)localObject, null));
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
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.i(WalletFragment.this));
          WalletFragment.a(WalletFragment.this, null);
        }
        if (WalletFragment.j(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.j(WalletFragment.this).booleanValue());
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */