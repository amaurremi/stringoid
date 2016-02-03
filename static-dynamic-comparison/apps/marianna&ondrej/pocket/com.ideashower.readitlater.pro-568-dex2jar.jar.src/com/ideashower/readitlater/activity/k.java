package com.ideashower.readitlater.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ideashower.readitlater.activity.a.d;
import com.ideashower.readitlater.activity.a.l;
import com.ideashower.readitlater.activity.a.o;
import com.ideashower.readitlater.activity.a.p;
import com.ideashower.readitlater.views.LabelEditText;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.c.g;

public abstract class k
  extends f
{
  protected ToolbarLayout Y;
  protected StyledToolbar Z;
  protected StyledToolbar aa;
  protected RilButton ab;
  protected RilButton ac;
  protected LabelEditText ad;
  protected LabelEditText ae;
  protected LabelEditText af;
  protected LabelEditText ag;
  protected LabelEditText ah;
  protected TextView ai;
  protected TextView aj;
  protected TextWatcher ak;
  protected TextWatcher al;
  protected String am;
  protected String an;
  protected String ao;
  protected String ap;
  protected String aq;
  protected l ar;
  private int as = 0;
  
  private void c(com.pocket.c.f paramf)
  {
    if ((m() == null) || (m().isFinishing())) {
      return;
    }
    ad();
    if (paramf.u())
    {
      a(paramf);
      return;
    }
    b(paramf);
  }
  
  protected void Y() {}
  
  protected boolean Z()
  {
    return false;
  }
  
  protected abstract void a(com.pocket.c.f paramf);
  
  protected abstract boolean a(int paramInt, g paramg);
  
  protected boolean aa()
  {
    return false;
  }
  
  protected abstract int ab();
  
  protected abstract int ac();
  
  protected void ad()
  {
    if (this.ar != null)
    {
      this.ar.a();
      this.ar = null;
    }
  }
  
  protected void ae()
  {
    this.am = org.apache.a.c.k.c(this.ad.getText().toString()).trim();
    this.an = org.apache.a.c.k.c(this.ae.getText().toString()).trim();
    this.ao = org.apache.a.c.k.c(this.af.getText().toString()).trim();
    this.ap = org.apache.a.c.k.c(this.ag.getText().toString()).trim();
    this.aq = org.apache.a.c.k.c(this.ah.getText().toString()).trim();
  }
  
  protected void af()
  {
    if (this.ar != null) {}
    final int i;
    do
    {
      return;
      ae();
      this.as += 1;
      i = this.as;
    } while (!a(i, new g()
    {
      public void a(com.pocket.c.f paramAnonymousf, boolean paramAnonymousBoolean)
      {
        if (i == k.a(k.this)) {
          k.a(k.this, paramAnonymousf);
        }
      }
    }));
    ag();
  }
  
  protected void ag()
  {
    this.ar = l.a(ac(), null, true);
    this.ar.a((a)m());
    this.ar.a(new p()
    {
      public void a(o paramAnonymouso)
      {
        k.this.ar = null;
      }
      
      public void b(o paramAnonymouso)
      {
        k.this.ad();
      }
    });
  }
  
  protected void b(com.pocket.c.f paramf)
  {
    d.a(3, paramf.t()).a((a)m());
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903042, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.Y = ((ToolbarLayout)c(2131230729));
    this.Z = ((StyledToolbar)this.Y.getTopToolbar());
    this.Z.a(true, this);
    int i = ab();
    if (i == 0)
    {
      this.Y.a(false, false);
      paramBundle = this.Z;
      if (e()) {
        break label367;
      }
    }
    label367:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setIsRainbowified(bool);
      this.Z.a(StyledToolbar.a, false);
      this.aa = ((StyledToolbar)this.Y.getBottomToolbar());
      this.aa.a(StyledToolbar.g, false);
      this.ac = ((RilButton)c(2131230752));
      this.ab = ((RilButton)c(2131230753));
      this.ad = ((LabelEditText)c(2131230736));
      this.ae = ((LabelEditText)c(2131230747));
      this.ae.setTypeface(Typeface.DEFAULT);
      this.ag = ((LabelEditText)c(2131230737));
      this.ai = ((TextView)c(2131230749));
      this.aj = ((TextView)c(2131230750));
      this.af = ((LabelEditText)c(2131230748));
      this.af.setTypeface(Typeface.DEFAULT);
      this.ah = ((LabelEditText)c(2131230738));
      this.ab.setIsBrightStyle(true);
      this.ab.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          k.this.af();
        }
      });
      Y();
      if (Z())
      {
        this.ak = new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymousEditable)
          {
            if (k.this.ae.getText().toString().trim().length() > 0)
            {
              k.this.af.setVisibility(0);
              return;
            }
            k.this.af.setVisibility(8);
          }
          
          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        };
        this.ae.addTextChangedListener(this.ak);
      }
      if (aa())
      {
        this.al = new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymousEditable)
          {
            if (!k.this.ag.getText().toString().trim().equals(this.a))
            {
              k.this.ah.setVisibility(0);
              return;
            }
            k.this.ah.setVisibility(8);
          }
          
          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        };
        this.ag.addTextChangedListener(this.al);
      }
      return;
      this.Z.setTitle(m().getString(i));
      break;
    }
  }
  
  public void x()
  {
    super.x();
    ad();
    this.as = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */