package com.ideashower.readitlater.activity;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.av;
import com.ideashower.readitlater.a.aw;
import com.ideashower.readitlater.activity.a.b;
import com.ideashower.readitlater.activity.a.d;
import com.ideashower.readitlater.activity.a.o;
import com.ideashower.readitlater.activity.a.p;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.LabelEditText;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.user.UserMeta;

public class q
  extends f
{
  protected ToolbarLayout Y;
  protected StyledToolbar Z;
  protected RilButton aa;
  protected LabelEditText ab;
  protected LabelEditText ac;
  protected EditText ad;
  protected com.ideashower.readitlater.activity.a.l ae;
  protected UserMeta af;
  
  public static com.pocket.p.l Y()
  {
    if (j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  public static q a(UserMeta paramUserMeta)
  {
    q localq = new q();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("userMeta", paramUserMeta);
    localq.g(localBundle);
    return localq;
  }
  
  public String K()
  {
    return "edit_password";
  }
  
  protected void Z()
  {
    if (this.ae != null) {
      return;
    }
    if (this.ab.getText().toString().trim().length() == 0)
    {
      b.b(2131493090, 2131493120).a((a)m());
      return;
    }
    if (!this.ac.getText().toString().trim().equals(this.ad.getText().toString().trim()))
    {
      b.b(2131493090, 2131493133).a((a)m());
      return;
    }
    if (this.ac.getText().toString().trim().length() == 0)
    {
      b.b(2131493090, 2131493132).a((a)m());
      return;
    }
    aa();
    String str1 = this.ac.getText().toString().trim();
    String str2 = this.ab.getText().toString().trim();
    final a locala = (a)m();
    as.x().b(str1).a(str2, new aw()
    {
      public void a()
      {
        q.this.ab();
        Toast.makeText(locala, q.this.d(2131493743), 1).show();
        q.this.P();
      }
      
      public void a(ErrorReport paramAnonymousErrorReport)
      {
        q.this.ab();
        d.a(4, paramAnonymousErrorReport).a(locala);
      }
    });
  }
  
  protected void aa()
  {
    this.ae = com.ideashower.readitlater.activity.a.l.a(2131493143, null, true);
    this.ae.a((a)m());
    this.ae.a(new p()
    {
      public void a(o paramAnonymouso)
      {
        q.this.ae = null;
      }
      
      public void b(o paramAnonymouso)
      {
        q.this.ab();
      }
    });
  }
  
  protected void ab()
  {
    if (this.ae != null)
    {
      this.ae.a();
      this.ae = null;
    }
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903058, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.af = ((UserMeta)l().getParcelable("userMeta"));
    this.Y = ((ToolbarLayout)c(2131230729));
    this.aa = ((RilButton)c(2131230743));
    this.ab = ((LabelEditText)c(2131230847));
    this.ac = ((LabelEditText)c(2131230848));
    this.ad = ((EditText)c(2131230849));
    if (e())
    {
      int i = (int)n().getDimension(2131296296);
      int j = j.a(50.0F);
      c(2131230731).setPadding(j, i, j, i);
    }
    this.Z = ((StyledToolbar)this.Y.getTopToolbar());
    this.Z.a(true, this);
    paramBundle = this.Z;
    if (!e()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setIsRainbowified(bool);
      this.Z.a(StyledToolbar.a, false);
      this.Z.setTitle(2131493503);
      this.ab.setTypeface(Typeface.DEFAULT);
      this.ac.setTypeface(Typeface.DEFAULT);
      this.ad.setTypeface(Typeface.DEFAULT);
      this.aa.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          q.this.Z();
        }
      });
      this.ab.post(new Runnable()
      {
        public void run()
        {
          z.a(true, q.this.ab);
        }
      });
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */