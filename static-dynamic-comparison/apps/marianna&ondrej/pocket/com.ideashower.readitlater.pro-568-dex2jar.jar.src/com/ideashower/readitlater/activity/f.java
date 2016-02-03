package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.d;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ideashower.readitlater.util.z;
import com.pocket.app.b;
import com.pocket.c.am;
import com.pocket.p.s;
import com.pocket.p.t;
import com.pocket.widget.RainbowProgressCircleView;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class f
  extends d
  implements t
{
  private View Y;
  private View Z;
  private RelativeLayout aa;
  private TextView ab;
  private RainbowProgressCircleView ac;
  private am ad;
  private ArrayList ae;
  
  private void Y()
  {
    if ((S()) || (com.pocket.c.e.c(true))) {
      return;
    }
    a(true, false, d(2131493097));
    a(com.pocket.c.e.h() / 100.0F);
    e(true);
    this.ad = new am()
    {
      public void a() {}
      
      public void a(float paramAnonymousFloat)
      {
        f.this.a(paramAnonymousFloat);
      }
      
      public void b() {}
      
      public void c() {}
      
      public void d()
      {
        f.this.a(false, true, f.this.d(2131493097));
        f.this.e(false);
      }
    };
    com.pocket.c.e.a(this.ad);
  }
  
  public static void a(View paramView)
  {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        Object localObject;
        if (f.this.getHeight() > 0)
        {
          localObject = f.b(f.this);
          if (localObject != null) {
            break label34;
          }
        }
        for (;;)
        {
          f.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          return;
          label34:
          localObject = ((LinearLayout)localObject).getChildAt(0);
          if (localObject != f.this)
          {
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
            localLayoutParams.height = 0;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
      }
    });
  }
  
  public static LinearLayout b(View paramView)
  {
    paramView = paramView.getParent();
    if (paramView != null)
    {
      if ((paramView instanceof LinearLayout)) {
        return (LinearLayout)paramView;
      }
      if ((paramView instanceof View)) {
        return b((View)paramView);
      }
    }
    return null;
  }
  
  public abstract String K();
  
  public void L()
  {
    Y();
  }
  
  public void M() {}
  
  public void N() {}
  
  public void O()
  {
    P();
  }
  
  public void P()
  {
    a locala = (a)m();
    if (locala == null) {
      return;
    }
    ((b)locala.e()).a(this, m());
  }
  
  public boolean Q()
  {
    return com.pocket.p.k.a(this);
  }
  
  public boolean R()
  {
    return com.pocket.p.k.b(this);
  }
  
  protected boolean S()
  {
    return true;
  }
  
  public a T()
  {
    return (a)m();
  }
  
  public int U()
  {
    a locala = T();
    if (locala != null)
    {
      if (e()) {
        return 1;
      }
      return locala.s();
    }
    return 0;
  }
  
  public boolean V()
  {
    a locala = T();
    if ((locala == null) || (e())) {
      return false;
    }
    return locala.t();
  }
  
  public boolean W()
  {
    return false;
  }
  
  public View X()
  {
    if (this.Y != null) {
      return this.Y;
    }
    return this.Z;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (e()) {
      return null;
    }
    this.Z = c(paramLayoutInflater, paramViewGroup, paramBundle);
    return this.Z;
  }
  
  public void a(float paramFloat)
  {
    if ((this.aa == null) || (R())) {
      return;
    }
    this.ac.setProgress(paramFloat);
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    if (!(paramActivity instanceof a)) {
      com.ideashower.readitlater.util.e.a("AbsPocketFragment requires the parent Activity to be a AbsPocketActivity in order to use the additional functionality and APIs");
    }
  }
  
  public void a(g paramg)
  {
    if (this.ae == null) {
      this.ae = new ArrayList();
    }
    this.ae.add(paramg);
  }
  
  public void a(s params) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i = 0;
    boolean bool;
    if (paramBoolean1)
    {
      bool = paramBoolean2;
      if (this.aa != null)
      {
        bool = paramBoolean2;
        if (this.aa.getVisibility() == 0)
        {
          if (org.apache.a.c.k.a(this.ab.getText(), paramString)) {
            return;
          }
          bool = false;
        }
      }
      label48:
      if (this.aa == null)
      {
        this.aa = ((RelativeLayout)LayoutInflater.from(m()).inflate(2130903085, null, false));
        this.aa.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.ab = ((TextView)this.aa.findViewById(2131230759));
        ((ViewGroup)X()).addView(this.aa);
        this.ac = ((RainbowProgressCircleView)this.aa.findViewById(2131230922));
        this.ac.setProgressIndeterminate(true);
      }
      if (paramString == null) {
        break label213;
      }
      this.ab.setText(paramString);
      this.ab.setVisibility(0);
      label166:
      if (bool) {
        break label236;
      }
      paramString = this.aa;
      if (!paramBoolean1) {
        break label229;
      }
      label180:
      paramString.setVisibility(i);
    }
    for (;;)
    {
      f(paramBoolean1);
      return;
      if (this.aa == null) {
        break;
      }
      bool = paramBoolean2;
      if (this.aa.getVisibility() == 0) {
        break label48;
      }
      return;
      label213:
      if (!paramBoolean1) {
        break label166;
      }
      this.ab.setVisibility(8);
      break label166;
      label229:
      i = 8;
      break label180;
      label236:
      z.b(this.aa, paramBoolean1);
    }
  }
  
  public void b(int paramInt)
  {
    z.d(X());
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public Dialog c(Bundle paramBundle)
  {
    a(1, 0);
    com.ideashower.readitlater.views.j localj = null;
    if (com.ideashower.readitlater.util.j.g()) {
      localj = new com.ideashower.readitlater.views.j(m());
    }
    this.Z = c(LayoutInflater.from(m()), localj, paramBundle);
    if (localj != null) {
      localj.addView(this.Z);
    }
    for (this.Y = localj;; this.Y = this.Z)
    {
      paramBundle = new AlertDialog.Builder(m());
      paramBundle.setView(this.Y);
      paramBundle = paramBundle.create();
      paramBundle.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        private boolean b = false;
        
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          boolean bool = false;
          if (paramAnonymousInt == 4) {
            if (this.b)
            {
              this.b = false;
              bool = f.this.W();
            }
          }
          while (paramAnonymousInt != 84)
          {
            return bool;
            this.b = true;
            return false;
          }
          return true;
        }
      });
      paramBundle.getWindow().setLayout(-1, -1);
      paramBundle.getWindow().setSoftInputMode(16);
      a(this.Y);
      return paramBundle;
    }
  }
  
  public View c(int paramInt)
  {
    return X().findViewById(paramInt);
  }
  
  protected abstract View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public String d(int paramInt)
  {
    return com.ideashower.readitlater.a.g.a(paramInt);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (X() != null) {
      X().setClickable(true);
    }
  }
  
  protected void e(boolean paramBoolean) {}
  
  protected void f(boolean paramBoolean) {}
  
  public void g()
  {
    super.g();
    if (e()) {
      ((ViewGroup)this.Y.getParent()).setPadding(0, 0, 0, 0);
    }
    if (!R()) {
      Y();
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (e()) {
      P();
    }
    super.onCancel(paramDialogInterface);
  }
  
  public View v()
  {
    return super.v();
  }
  
  public void w()
  {
    super.w();
    Y();
  }
  
  public void y()
  {
    super.y();
    if (this.ae != null)
    {
      Iterator localIterator = this.ae.iterator();
      while (localIterator.hasNext()) {
        ((g)localIterator.next()).a(this);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */