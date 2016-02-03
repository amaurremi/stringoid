package com.ideashower.readitlater.reader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import com.ideashower.readitlater.a.k;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.pocket.widget.aj;

public class e
  extends PopupWindow
  implements d
{
  private final Context a;
  private final Handler b;
  private final Runnable c = new Runnable()
  {
    public void run()
    {
      e.this.dismiss();
    }
  };
  private final StyledIconButton d;
  private final StyledIconButton e;
  private final aj f;
  private final StyledIconButton g;
  private final StyledIconButton h;
  private final View i;
  private final View j;
  private final View k;
  private final SeekBar l;
  private boolean m;
  private Toast n;
  private int o;
  
  public e(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(a(paramContext), paramInt1, paramInt2, true);
    this.a = paramContext;
    this.b = new Handler();
    this.d = ((StyledIconButton)c(2131231010));
    this.e = ((StyledIconButton)c(2131231011));
    this.f = ((aj)c(2131231009));
    this.g = ((StyledIconButton)c(2131231014));
    this.h = ((StyledIconButton)c(2131231013));
    this.i = c(2131231016);
    this.j = c(2131231017);
    this.k = c(2131231018);
    this.l = ((SeekBar)c(2131231021));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.a(true);
        e.a(e.this);
        e.a(e.this, true);
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.a(false);
        e.a(e.this);
        e.a(e.this, false);
      }
    });
    this.f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          c.a(paramAnonymousBoolean);
          e.a(e.this);
          e.a(e.this, paramAnonymousBoolean);
          return;
        }
      }
    });
    this.g.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.g();
        e.a(e.this);
      }
    });
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.h();
        e.a(e.this);
      }
    });
    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.a(0);
        e.a(e.this);
      }
    });
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.a(1);
        e.a(e.this);
      }
    });
    this.k.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.a(2);
        e.a(e.this);
      }
    });
    float f1 = k.a((Activity)a());
    this.l.setProgress((int)(f1 * 100.0F) + 25);
    this.l.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          return;
        }
        c.a(paramAnonymousInt / 100.0F, 0.0F);
        e.a(e.this);
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
    if (paramBoolean)
    {
      c(2131231008).setVisibility(8);
      c(2131231015).setVisibility(8);
    }
    z.a(this.l, 0.5F);
    z.a(this);
  }
  
  private static View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130903132, null, false);
  }
  
  private void a(int paramInt)
  {
    if (this.m) {
      return;
    }
    this.m = true;
    this.o = paramInt;
    c.a(this, true, true, false, true);
    c.a(this);
    b();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 2131493509;; i1 = 2131493508)
    {
      d(i1);
      return;
    }
  }
  
  private void b()
  {
    this.b.removeCallbacks(this.c);
    this.b.postDelayed(this.c, 6000L);
  }
  
  private View c(int paramInt)
  {
    return getContentView().findViewById(paramInt);
  }
  
  private void d(int paramInt)
  {
    if (this.n == null)
    {
      this.n = Toast.makeText(a(), paramInt, 1);
      if (this.o != 0) {
        this.n.setGravity(81, 0, this.o);
      }
    }
    for (;;)
    {
      this.n.show();
      return;
      this.n.setText(paramInt);
    }
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    StyledIconButton localStyledIconButton = this.h;
    if (!paramBoolean1)
    {
      paramBoolean1 = true;
      localStyledIconButton.setEnabled(paramBoolean1);
      localStyledIconButton = this.g;
      if (paramBoolean2) {
        break label46;
      }
    }
    label46:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localStyledIconButton.setEnabled(paramBoolean1);
      return;
      paramBoolean1 = false;
      break;
    }
  }
  
  public void b(float paramFloat) {}
  
  public void b(int paramInt)
  {
    z.d(getContentView());
  }
  
  public void dismiss()
  {
    c.b(this);
    super.dismiss();
    this.m = false;
  }
  
  public void i(boolean paramBoolean)
  {
    aj localaj = this.f;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localaj.setChecked(paramBoolean);
      return;
    }
  }
  
  public void j(boolean paramBoolean) {}
  
  public void showAsDropDown(View paramView)
  {
    a(0);
    super.showAsDropDown(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    a(0);
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  @TargetApi(19)
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(0);
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a((int)(a().getResources().getDimensionPixelSize(2131296286) * 3.2F));
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */