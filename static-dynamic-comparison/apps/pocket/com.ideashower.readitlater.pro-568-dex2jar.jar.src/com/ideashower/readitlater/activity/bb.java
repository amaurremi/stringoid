package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.ideashower.readitlater.activity.a.b;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.LabelEditText;
import com.ideashower.readitlater.views.RilButton;
import com.pocket.c.g;
import java.net.URI;
import java.net.URISyntaxException;

public class bb
  extends k
{
  private String as;
  
  public static void a(android.support.v4.app.f paramf)
  {
    if (ah() == com.pocket.p.l.a)
    {
      com.pocket.p.k.a(ai(), paramf);
      return;
    }
    SubscriptionCustomActivity.d(paramf);
  }
  
  public static com.pocket.p.l ah()
  {
    if (j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  public static bb ai()
  {
    i.b().a(com.ideashower.readitlater.h.a.aF, null).a();
    return new bb();
  }
  
  private void aj()
  {
    if (this.as != null)
    {
      String str = i.a(com.ideashower.readitlater.h.a.aF);
      if (this.as.equals(str))
      {
        i.b().a(com.ideashower.readitlater.h.a.aF, null).a();
        P();
      }
    }
  }
  
  public String K()
  {
    return "subscription_custom_login";
  }
  
  public void L()
  {
    super.L();
  }
  
  protected void Y()
  {
    this.ad.setLabel(2131493376);
    this.ad.setHint(2131493377);
    this.ad.setInputType(16);
    this.ae.setVisibility(8);
    this.ag.setVisibility(8);
    if (this.as != null) {
      this.ad.setText(this.as);
    }
    this.ab.setVisibility(0);
    this.ab.setIsBrightStyle(true);
    this.ab.setText(2131492901);
    this.ab.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Object localObject1 = bb.this.ad.getText().toString().toLowerCase();
        if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
          if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://"))) {
            paramAnonymousView = "http://".concat((String)localObject1);
          }
        }
        for (;;)
        {
          Object localObject2;
          try
          {
            localURI = new URI(paramAnonymousView);
            localObject1 = paramAnonymousView;
            paramAnonymousView = localURI;
          }
          catch (URISyntaxException localURISyntaxException)
          {
            e.a(localURISyntaxException);
            URI localURI = null;
            localObject2 = paramAnonymousView;
            paramAnonymousView = localURI;
            continue;
            bb.a(bb.this, (String)localObject2);
            localObject2 = new Intent(bb.this.m(), SubscriptionCustomWebActivity.class);
            ((Intent)localObject2).putExtra("RILextraDomain", paramAnonymousView.toString());
            bb.this.a((Intent)localObject2, 0);
            return;
          }
          if (paramAnonymousView == null)
          {
            b.b(2131493075, 2131493074).a((a)bb.this.m());
            return;
          }
          paramAnonymousView = (View)localObject2;
          continue;
          paramAnonymousView = null;
        }
      }
    });
  }
  
  protected void a(com.pocket.c.f paramf) {}
  
  protected boolean a(int paramInt, g paramg)
  {
    return false;
  }
  
  protected int ab()
  {
    return 2131493500;
  }
  
  protected int ac()
  {
    return 0;
  }
  
  protected void af() {}
  
  public void d(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.as = paramBundle.getString("statePendingDomain");
    }
    super.d(paramBundle);
  }
  
  public void w()
  {
    super.w();
    aj();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */