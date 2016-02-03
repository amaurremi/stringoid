package com.ideashower.readitlater.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ideashower.readitlater.a.v;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.UrlImageView;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.c.e;
import com.pocket.p.l;

public class w
  extends f
{
  private static String ab = "?v=501";
  protected ToolbarLayout Y;
  protected StyledToolbar Z;
  protected LinearLayout aa;
  
  public static l Y()
  {
    if (j.g()) {
      return l.a;
    }
    return l.b;
  }
  
  public static w Z()
  {
    return new w();
  }
  
  private View a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramString, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean, 0, null);
  }
  
  private View a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7, View.OnClickListener paramOnClickListener)
  {
    View localView = LayoutInflater.from(m()).inflate(2130903148, null, false);
    Object localObject = (TextView)localView.findViewById(2131230768);
    ((TextView)localObject).setText(paramInt1);
    i.a(i.a, (View)localObject);
    TextView localTextView = (TextView)localView.findViewById(2131230793);
    localTextView.setText(Html.fromHtml(a(paramInt2)));
    i.a(i.c, localTextView);
    UrlImageView localUrlImageView = (UrlImageView)localView.findViewById(2131230925);
    if (j.c()) {
      paramString = paramString + "-tablet";
    }
    for (;;)
    {
      localObject = paramString;
      if (paramBoolean)
      {
        localObject = paramString;
        if (m.b(m())) {
          localObject = paramString + "-night";
        }
      }
      localUrlImageView.setImageUrl((String)localObject + ".png" + ab);
      paramString = localUrlImageView.getLayoutParams();
      if (j.c()) {
        paramString.width = j.a(paramInt5);
      }
      for (paramString.height = j.a(paramInt6);; paramString.height = j.a(paramInt4))
      {
        localUrlImageView.setLayoutParams(paramString);
        paramString = (Button)localView.findViewById(2131230774);
        if ((paramInt7 == 0) || (paramOnClickListener == null)) {
          break;
        }
        paramString.setText(paramInt7);
        localTextView.setOnClickListener(paramOnClickListener);
        return localView;
        paramString.width = j.a(paramInt3);
      }
      paramString.setVisibility(8);
      z.b(localTextView, localTextView.getPaddingTop());
      localTextView.setClickable(false);
      return localView;
    }
  }
  
  public static void a(android.support.v4.app.f paramf)
  {
    if (Y() == l.a)
    {
      com.pocket.p.k.a(Z(), paramf);
      return;
    }
    HTSActivity.d(paramf);
  }
  
  public String K()
  {
    return "how_to_save";
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903050, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.Y = ((ToolbarLayout)c(2131230729));
    this.Z = ((StyledToolbar)this.Y.getTopToolbar());
    this.Z.a(true, this);
    this.Z.setTitle(2131493512);
    this.Z.setIsRainbowified(true);
    this.aa = ((LinearLayout)c(2131230794));
    this.aa.addView(a(2131493252, 2131493251, "http://assets.getpocket.com/images/howtoadd/howtoadd-apps-android", 154, 160, 178, 159, false, 2131492908, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        v.b(3);
        com.ideashower.readitlater.util.k.a(5, (a)w.this.m());
      }
    }));
    this.aa.addView(a(2131493258, 2131493257, "http://assets.getpocket.com/images/howtoadd/howtoadd-save-via-email-android", 156, 160, 178, 159, true, 2131492908, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HelpPageFragment.a(w.this.m(), 2131493245, "help-save-via-email.html");
      }
    }));
    this.aa.addView(a(2131493256, 2131493255, "http://assets.getpocket.com/images/howtoadd/howtoadd-from-your-computer", 156, 160, 161, 159, true, 2131492899, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        v.h();
        e.a("pocket_help", "browser-setup-gs");
      }
    }));
    this.aa.addView(a(2131493254, 2131493253, "http://assets.getpocket.com/images/howtoadd/howtoadd-copy-url", 154, 160, 154, 160, true));
    com.pocket.stats.f.a("help", "howtoadd", "open", "1");
    v.g();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */