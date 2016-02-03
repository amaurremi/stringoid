package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
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
import com.google.android.gms.internal.lk;
import com.google.android.gms.internal.ls;

class f
  extends a<e>
  implements View.OnClickListener
{
  private f(SupportWalletFragment paramSupportWalletFragment) {}
  
  protected void a(FrameLayout paramFrameLayout)
  {
    Button localButton = new Button(SupportWalletFragment.a(this.a).getActivity());
    localButton.setText(R.string.wallet_buy_button_place_holder);
    int k = -1;
    int m = -2;
    int j = m;
    int i = k;
    if (SupportWalletFragment.e(this.a) != null)
    {
      WalletFragmentStyle localWalletFragmentStyle = SupportWalletFragment.e(this.a).getFragmentStyle();
      j = m;
      i = k;
      if (localWalletFragmentStyle != null)
      {
        DisplayMetrics localDisplayMetrics = SupportWalletFragment.a(this.a).getResources().getDisplayMetrics();
        i = localWalletFragmentStyle.a("buyButtonWidth", localDisplayMetrics, -1);
        j = localWalletFragmentStyle.a("buyButtonHeight", localDisplayMetrics, -2);
      }
    }
    localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
    localButton.setOnClickListener(this);
    paramFrameLayout.addView(localButton);
  }
  
  protected void a(com.google.android.gms.dynamic.f<e> paramf)
  {
    Object localObject = SupportWalletFragment.a(this.a).getActivity();
    if ((SupportWalletFragment.b(this.a) == null) && (SupportWalletFragment.c(this.a)) && (localObject != null)) {}
    try
    {
      localObject = ls.a((Activity)localObject, SupportWalletFragment.d(this.a), SupportWalletFragment.e(this.a), SupportWalletFragment.f(this.a));
      SupportWalletFragment.a(this.a, new e((lk)localObject, null));
      SupportWalletFragment.a(this.a, null);
      paramf.a(SupportWalletFragment.b(this.a));
      if (SupportWalletFragment.g(this.a) != null)
      {
        e.a(SupportWalletFragment.b(this.a), SupportWalletFragment.g(this.a));
        SupportWalletFragment.a(this.a, null);
      }
      if (SupportWalletFragment.h(this.a) != null)
      {
        e.a(SupportWalletFragment.b(this.a), SupportWalletFragment.h(this.a));
        SupportWalletFragment.a(this.a, null);
      }
      if (SupportWalletFragment.i(this.a) != null)
      {
        e.a(SupportWalletFragment.b(this.a), SupportWalletFragment.i(this.a));
        SupportWalletFragment.a(this.a, null);
      }
      if (SupportWalletFragment.j(this.a) != null)
      {
        e.a(SupportWalletFragment.b(this.a), SupportWalletFragment.j(this.a).booleanValue());
        SupportWalletFragment.a(this.a, null);
      }
      return;
    }
    catch (GooglePlayServicesNotAvailableException paramf) {}
  }
  
  public void onClick(View paramView)
  {
    paramView = SupportWalletFragment.a(this.a).getActivity();
    GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramView), paramView, -1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */