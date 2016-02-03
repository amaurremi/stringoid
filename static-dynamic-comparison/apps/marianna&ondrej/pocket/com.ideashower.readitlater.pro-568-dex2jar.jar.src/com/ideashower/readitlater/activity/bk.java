package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.g.a;
import com.pocket.p.k;
import com.pocket.p.l;
import com.pocket.p.o;

public class bk
  extends f
{
  protected View Y;
  protected View Z;
  protected RilButton aa;
  protected RilButton ab;
  
  public static l Y()
  {
    return l.c;
  }
  
  public static bk Z()
  {
    return new bk();
  }
  
  public String K()
  {
    return "whats_new";
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903066, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    boolean bool = true;
    super.d(paramBundle);
    k.a(this);
    paramBundle = (StyledToolbar)c(2131230742);
    paramBundle.a(true, this);
    if (j.c()) {
      paramBundle.setTitle("Pocket " + g.b().i());
    }
    if (!e()) {}
    for (;;)
    {
      paramBundle.setIsRainbowified(bool);
      this.Y = c(2131230897);
      this.Y.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Object localObject = g.b().i();
          if (((String)localObject).equals("4.2.1")) {
            paramAnonymousView = "4.2";
          }
          for (;;)
          {
            localObject = new Intent(bk.this.m(), FramedWebViewActivity.class);
            ((Intent)localObject).putExtra("pathToLoad", "http://getpocket.com/android/updated/" + paramAnonymousView + "?from=" + g.r() + "&to=" + g.b().j());
            ((Intent)localObject).putExtra("com.ideashower.readitlater.extra.title", bk.this.a(2131492962));
            bk.this.a((Intent)localObject);
            return;
            if (((String)localObject).equals("4.3.1"))
            {
              paramAnonymousView = "4.3";
            }
            else if (((String)localObject).equals("4.7.2"))
            {
              paramAnonymousView = "4.7.1";
            }
            else if ((((String)localObject).equals("5.1.1")) || (((String)localObject).equals("5.1.2")))
            {
              paramAnonymousView = "5.1";
            }
            else if ((((String)localObject).equals("5.3.1")) || (((String)localObject).equals("5.3.2")) || (((String)localObject).equals("5.3.3")))
            {
              paramAnonymousView = "5.3";
            }
            else
            {
              paramAnonymousView = (View)localObject;
              if (((String)localObject).startsWith("5.6.")) {
                paramAnonymousView = "5.6";
              }
            }
          }
        }
      });
      this.Z = c(2131230899);
      this.Z.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          bk.this.m().finish();
        }
      });
      this.aa = ((RilButton)c(2131230863));
      this.aa.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          bk.this.m().finish();
        }
      });
      this.ab = ((RilButton)c(2131230898));
      this.ab.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse(g.b().d()));
          paramAnonymousView.addFlags(524288);
          if (o.a(bk.this.m(), paramAnonymousView))
          {
            bk.this.a(paramAnonymousView);
            return;
          }
          new AlertDialog.Builder(bk.this.m()).setTitle(2131493117).setMessage(2131493116).setNeutralButton(2131492924, null).show();
        }
      });
      i.a(i.a, c(2131230730));
      this.ab.setTypeface(Typeface.DEFAULT);
      return;
      bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */