package com.ideashower.readitlater.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.views.RilButton;
import com.pocket.billing.PremiumGiftMessage;
import com.pocket.p.k;
import com.pocket.p.l;
import com.pocket.widget.premium.PremiumPurchasedView;

public class t
  extends f
{
  public static l Y()
  {
    return l.c;
  }
  
  public static t Z()
  {
    return new t();
  }
  
  private void aa()
  {
    PremiumGiftMessage.c();
    a.a(m()).q();
    P();
  }
  
  public String K()
  {
    return "gifted";
  }
  
  public void O()
  {
    aa();
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903046, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    paramBundle = PremiumGiftMessage.b();
    if (paramBundle == null)
    {
      aa();
      return;
    }
    k.a(this);
    Object localObject = (PremiumPurchasedView)c(2131230763);
    ((PremiumPurchasedView)localObject).a(paramBundle.d(), paramBundle.e(), paramBundle.f(), paramBundle.g());
    ((PremiumPurchasedView)localObject).getButton().setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        t.a(t.this);
      }
    });
    paramBundle = ((PremiumPurchasedView)localObject).findViewById(2131231123);
    localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */