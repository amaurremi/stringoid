package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.lk;
import com.google.android.gms.internal.ls;

class i
  extends a<h>
  implements View.OnClickListener
{
  private i(WalletFragment paramWalletFragment) {}
  
  protected void a(FrameLayout paramFrameLayout)
  {
    Button localButton = new Button(WalletFragment.a(this.a).getActivity());
    localButton.setText(R.string.wallet_buy_button_place_holder);
    int k = -1;
    int m = -2;
    int j = m;
    int i = k;
    if (WalletFragment.e(this.a) != null)
    {
      WalletFragmentStyle localWalletFragmentStyle = WalletFragment.e(this.a).getFragmentStyle();
      j = m;
      i = k;
      if (localWalletFragmentStyle != null)
      {
        DisplayMetrics localDisplayMetrics = WalletFragment.a(this.a).getResources().getDisplayMetrics();
        i = localWalletFragmentStyle.a("buyButtonWidth", localDisplayMetrics, -1);
        j = localWalletFragmentStyle.a("buyButtonHeight", localDisplayMetrics, -2);
      }
    }
    localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
    localButton.setOnClickListener(this);
    paramFrameLayout.addView(localButton);
  }
  
  protected void a(f<h> paramf)
  {
    Object localObject = WalletFragment.a(this.a).getActivity();
    if ((WalletFragment.b(this.a) == null) && (WalletFragment.c(this.a)) && (localObject != null)) {}
    try
    {
      localObject = ls.a((Activity)localObject, WalletFragment.d(this.a), WalletFragment.e(this.a), WalletFragment.f(this.a));
      WalletFragment.a(this.a, new h((lk)localObject, null));
      WalletFragment.a(this.a, null);
      paramf.a(WalletFragment.b(this.a));
      if (WalletFragment.g(this.a) != null)
      {
        h.a(WalletFragment.b(this.a), WalletFragment.g(this.a));
        WalletFragment.a(this.a, null);
      }
      if (WalletFragment.h(this.a) != null)
      {
        h.a(WalletFragment.b(this.a), WalletFragment.h(this.a));
        WalletFragment.a(this.a, null);
      }
      if (WalletFragment.i(this.a) != null)
      {
        h.a(WalletFragment.b(this.a), WalletFragment.i(this.a));
        WalletFragment.a(this.a, null);
      }
      if (WalletFragment.j(this.a) != null)
      {
        h.a(WalletFragment.b(this.a), WalletFragment.j(this.a).booleanValue());
        WalletFragment.a(this.a, null);
      }
      return;
    }
    catch (GooglePlayServicesNotAvailableException paramf) {}
  }
  
  public void onClick(View paramView)
  {
    paramView = WalletFragment.a(this.a).getActivity();
    GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramView), paramView, -1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */