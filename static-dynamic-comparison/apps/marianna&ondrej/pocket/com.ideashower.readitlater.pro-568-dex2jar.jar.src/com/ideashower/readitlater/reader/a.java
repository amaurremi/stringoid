package com.ideashower.readitlater.reader;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ideashower.readitlater.activity.ReaderFragment;
import com.ideashower.readitlater.views.CheckableImageButton;
import com.ideashower.readitlater.views.ThemedSpinner;
import com.ideashower.readitlater.views.aw;
import com.ideashower.readitlater.views.i;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.tts.f;
import com.pocket.tts.h;
import com.pocket.tts.m;
import com.pocket.tts.o;
import com.pocket.tts.p;
import com.pocket.widget.RainbowProgressCircleView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class a
{
  private final ReaderFragment a;
  private final ReaderWebView b;
  private ViewGroup c;
  private StyledIconButton d;
  private StyledIconButton e;
  private StyledIconButton f;
  private ThemedSpinner g;
  private SeekBar h;
  private Dialog i;
  private int j;
  private h k;
  private String l;
  private b m;
  private RainbowProgressCircleView n;
  private StyledToolbar o;
  private StyledToolbar p;
  
  public a(ReaderFragment paramReaderFragment, ReaderWebView paramReaderWebView)
  {
    this.a = paramReaderFragment;
    this.b = paramReaderWebView;
  }
  
  private boolean a(b paramb)
  {
    int i2 = 1;
    int i1;
    if (this.m != null)
    {
      i1 = 1;
      if (this.m != paramb) {
        break label28;
      }
    }
    for (;;)
    {
      return i1 & i2;
      i1 = 0;
      break;
      label28:
      i2 = 0;
    }
  }
  
  private static float b(SeekBar paramSeekBar)
  {
    return paramSeekBar.getProgress() / paramSeekBar.getMax() * 0.7F + 0.8F;
  }
  
  private static int b(float paramFloat, ProgressBar paramProgressBar)
  {
    return (int)((paramFloat - 0.8F) / 0.7F * paramProgressBar.getMax());
  }
  
  private void d()
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        a.o(a.this).setChecked(h.a());
      }
    });
  }
  
  private void e()
  {
    this.c = ((ViewGroup)LayoutInflater.from(j()).inflate(2130903111, null, false));
    if (com.ideashower.readitlater.util.j.c())
    {
      localObject = new com.ideashower.readitlater.views.j(j());
      ((com.ideashower.readitlater.views.j)localObject).addView(this.c);
      this.c = ((ViewGroup)localObject);
    }
    this.o = ((StyledToolbar)this.c.findViewById(2131230966));
    this.o.a(StyledToolbar.f, false);
    this.o.setIsTopToolbar(true);
    this.o.setShadowVisibility(false);
    this.o.b(1, true);
    this.p = ((StyledToolbar)this.c.findViewById(2131230970));
    this.p.a(StyledToolbar.f, false);
    this.p.setIsTopToolbar(true);
    this.p.setShadowVisibility(false);
    this.p.b(1, true);
    Object localObject = new AlertDialog.Builder(j()).setView(this.c).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        a.this.a();
      }
    });
    ArrayList localArrayList1;
    final ArrayList localArrayList2;
    label526:
    int i1;
    label556:
    int i2;
    if (com.ideashower.readitlater.util.q.b(i()).a(true) < 300)
    {
      this.i = ((AlertDialog.Builder)localObject).create();
      localObject = this.i.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).gravity = 81;
      ((WindowManager.LayoutParams)localObject).x = 0;
      ((WindowManager.LayoutParams)localObject).y = com.ideashower.readitlater.util.j.a(15.0F);
      this.i.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      this.d = ((StyledIconButton)this.c.findViewById(2131230968));
      this.d.setCheckable(true);
      this.d.setCheckedUseSourceImage(false);
      this.d.setOnCheckedChangeListener(new i()
      {
        public void a(CheckableImageButton paramAnonymousCheckableImageButton, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            paramAnonymousCheckableImageButton.setImageResource(2130837883);
            return;
          }
          paramAnonymousCheckableImageButton.setImageResource(2130837884);
        }
      });
      this.d.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.e(a.this).g();
        }
      });
      this.d.setTooltip(j().getString(2131493359));
      this.e = ((StyledIconButton)this.c.findViewById(2131230967));
      this.e.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.e(a.this).b(-1);
        }
      });
      this.e.setTooltip(j().getString(2131493360));
      this.f = ((StyledIconButton)this.c.findViewById(2131230969));
      this.f.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.e(a.this).b(1);
        }
      });
      this.e.setTooltip(j().getString(2131493358));
      this.g = ((ThemedSpinner)this.c.findViewById(2131230972));
      this.g.a(2130903112, 2130903113);
      this.g.setSpinnerStyle(1);
      this.g.setStyle(StyledToolbar.f);
      this.g.a();
      this.g.setTooltip(j().getString(2131493362));
      localArrayList1 = new ArrayList();
      localArrayList2 = this.k.m();
      Iterator localIterator1 = localArrayList2.iterator();
      if (!localIterator1.hasNext()) {
        break label651;
      }
      localObject = (Locale)localIterator1.next();
      Iterator localIterator2 = localArrayList2.iterator();
      i1 = 0;
      if (!localIterator2.hasNext()) {
        break label819;
      }
      if (!f.a((Locale)localObject, (Locale)localIterator2.next(), true, false, false)) {
        break label635;
      }
      i2 = 1;
      label588:
      i1 = i2 + i1;
      if (i1 <= 1) {
        break label640;
      }
    }
    label635:
    label640:
    label651:
    label819:
    for (;;)
    {
      if (i1 > 1) {}
      for (localObject = ((Locale)localObject).getDisplayName();; localObject = ((Locale)localObject).getDisplayLanguage())
      {
        localArrayList1.add(new aw((String)localObject));
        break label526;
        ((AlertDialog.Builder)localObject).setTitle(2131493776);
        break;
        i2 = 0;
        break label588;
        break label556;
      }
      localArrayList1.add(new aw(j().getString(2131493357), true));
      this.g.setOptions(localArrayList1);
      this.g.setPrompt(j().getText(2131493361));
      this.g.setSelection(localArrayList2.indexOf(this.k.l()));
      this.g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = a.e(a.this).l();
          if (paramAnonymousInt >= localArrayList2.size())
          {
            if (paramAnonymousInt == localArrayList2.size())
            {
              a.e(a.this).h();
              com.ideashower.readitlater.util.k.a(4, (com.ideashower.readitlater.activity.a)a.i(a.this));
            }
            a.m(a.this).setSelection(localArrayList2.indexOf(paramAnonymousAdapterView));
          }
          do
          {
            return;
            paramAnonymousView = (Locale)localArrayList2.get(paramAnonymousInt);
          } while (paramAnonymousView.equals(paramAnonymousAdapterView));
          if (a.p(a.this))
          {
            a.m(a.this).setSelection(localArrayList2.indexOf(paramAnonymousAdapterView));
            return;
          }
          a.e(a.this).a(paramAnonymousView);
        }
        
        public void onNothingSelected(AdapterView paramAnonymousAdapterView) {}
      });
      this.h = ((SeekBar)this.c.findViewById(2131230971));
      this.h.setProgress(b(this.k.n(), this.h));
      this.h.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        private boolean b = false;
        
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
        
        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
          this.b = h.a();
          a.e(a.this).h();
        }
        
        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
          if (a.p(a.this)) {}
          do
          {
            return;
            float f = a.a(paramAnonymousSeekBar);
            a.e(a.this).a(f);
          } while (!this.b);
          this.b = false;
          a.e(a.this).f();
        }
      });
      this.n = ((RainbowProgressCircleView)this.c.findViewById(2131230973));
      this.i.show();
      f();
      return;
    }
  }
  
  private void f()
  {
    int i3 = 4;
    int i1;
    Object localObject;
    if (this.c != null)
    {
      if ((!this.k.j()) && (this.k.i())) {
        break label170;
      }
      i1 = 1;
      localObject = this.o;
      if (i1 == 0) {
        break label175;
      }
      i2 = 4;
      label43:
      ((StyledToolbar)localObject).setVisibility(i2);
      localObject = this.p;
      if (i1 == 0) {
        break label180;
      }
      i2 = 4;
      label61:
      ((StyledToolbar)localObject).setVisibility(i2);
      localObject = this.g;
      if (i1 == 0) {
        break label185;
      }
      i2 = 4;
      label79:
      ((ThemedSpinner)localObject).setVisibility(i2);
      localObject = this.n;
      if (i1 != 0) {
        break label190;
      }
    }
    label170:
    label175:
    label180:
    label185:
    label190:
    for (int i2 = i3;; i2 = 0)
    {
      ((RainbowProgressCircleView)localObject).setVisibility(i2);
      if ((i1 == 0) && (this.k != null))
      {
        this.h.setProgress(b(this.k.n(), this.h));
        this.d.setChecked(h.a());
        this.g.setSelection(this.k.m().indexOf(this.k.l()));
      }
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label43;
      i2 = 0;
      break label61;
      i2 = 0;
      break label79;
    }
  }
  
  private boolean g()
  {
    boolean bool = this.k.o();
    if (bool) {
      new AlertDialog.Builder(j()).setTitle(2131493788).setMessage(2131493787).setNeutralButton(2131492924, null).setPositiveButton(2131492925, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          m.a(a.i(a.this));
        }
      }).show();
    }
    return bool;
  }
  
  private void h()
  {
    if (this.m != null)
    {
      h.b(j(), this.m);
      this.m = null;
      this.k = null;
    }
  }
  
  private Activity i()
  {
    return (Activity)j();
  }
  
  private Context j()
  {
    return this.b.getContext();
  }
  
  public void a()
  {
    if (this.k != null) {
      this.k.e();
    }
    if (this.i != null)
    {
      this.i.dismiss();
      this.i = null;
    }
    this.l = null;
    h();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    m.a(i(), paramInt, paramIntent);
  }
  
  public void a(final String paramString, final int paramInt)
  {
    p localp = p.a();
    if (localp.b())
    {
      localp.a(j(), new com.pocket.tts.q()
      {
        public void a() {}
        
        public void a(o paramAnonymouso)
        {
          a.this.a(paramString, paramInt);
        }
      });
      return;
    }
    this.j = paramInt;
    if (this.k != null)
    {
      if ((!org.apache.a.c.k.a(this.l, paramString)) || (!org.apache.a.c.k.a(h.b(), paramString)) || (!org.apache.a.c.k.a(h.c(), paramString)) || ((!this.k.i()) && (!this.k.j())))
      {
        this.l = paramString;
        this.k.a(paramString);
      }
      while (this.i == null)
      {
        e();
        return;
        this.k.a(paramInt);
      }
      f();
      return;
    }
    if (this.m != null)
    {
      this.l = paramString;
      return;
    }
    this.l = paramString;
    this.m = new b(this, null);
    h.a(j(), this.m);
  }
  
  public void b()
  {
    h();
  }
  
  public boolean c()
  {
    return this.i != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */