package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.AvatarView;
import com.pocket.p.k;
import com.pocket.p.l;
import com.pocket.stats.c;
import com.pocket.widget.ValidatedEditText;
import com.pocket.widget.au;

public class af
  extends f
{
  private au Y;
  private ProgressDialog Z;
  private ValidatedEditText aa;
  
  public static l Y()
  {
    if (j.g()) {
      return l.c;
    }
    return l.b;
  }
  
  public static af Z()
  {
    return new af();
  }
  
  private void aa()
  {
    if (!this.Y.a())
    {
      c.A.b();
      return;
    }
    z.b(false, this.aa);
    String str = this.aa.getText().toString();
    this.Z.show();
    com.pocket.c.d.a(str, new com.pocket.oauth.i()
    {
      private void a()
      {
        c.B.b();
        new AlertDialog.Builder(af.this.m()).setTitle(2131493429).setMessage(2131493428).setPositiveButton(2131492924, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.n, false);
            a.b(af.this.m());
            af.this.m().finish();
          }
        }).show();
      }
      
      public void a(com.pocket.c.f paramAnonymousf, boolean paramAnonymousBoolean)
      {
        af.b(af.this).hide();
        if (paramAnonymousBoolean)
        {
          com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.n, false);
          a.b(af.this.m());
          af.this.m().finish();
          c.z.b();
          return;
        }
        if (((paramAnonymousf instanceof com.pocket.c.d)) && (((com.pocket.c.d)paramAnonymousf).n()))
        {
          a();
          return;
        }
        com.ideashower.readitlater.activity.a.d.a(0, paramAnonymousf.t()).a((a)af.this.m());
        c.A.b();
      }
      
      public boolean a(int paramAnonymousInt)
      {
        af.b(af.this).hide();
        a();
        return true;
      }
      
      public boolean a(Intent paramAnonymousIntent)
      {
        af.b(af.this).hide();
        a();
        return true;
      }
    }).h();
  }
  
  public String K()
  {
    return getClass().getName();
  }
  
  public void a(Activity paramActivity)
  {
    if (!(paramActivity instanceof LoginPromptPasswordActivity)) {
      throw new RuntimeException("unsupported activity");
    }
    super.a(paramActivity);
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903056, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.Z = new ProgressDialog(m());
    this.Z.setMessage(a(2131493144));
    ((AvatarView)c(2131230733)).setFriend(o.c().e());
    ((TextView)c(2131230833)).setText(a(2131493435, new Object[] { as.k().j() }));
    ((TextView)c(2131230737)).setText(as.k().f());
    this.aa = ((ValidatedEditText)c(2131230747));
    this.aa.setTypeface(Typeface.DEFAULT);
    this.Y = new au(this, 2131230804);
    this.Y.a(2131230747, true, as.a(this.Y));
    c(2131230834).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        af.a(af.this);
      }
    });
    c.y.b();
  }
  
  public void w()
  {
    super.w();
    k.a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */