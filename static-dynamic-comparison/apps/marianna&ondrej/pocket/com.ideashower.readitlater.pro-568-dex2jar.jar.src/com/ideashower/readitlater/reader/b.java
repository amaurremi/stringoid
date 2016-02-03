package com.ideashower.readitlater.reader;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.SeekBar;
import com.ideashower.readitlater.activity.ReaderFragment;
import com.ideashower.readitlater.views.ThemedSpinner;
import com.pocket.tts.d;
import com.pocket.tts.g;
import com.pocket.tts.h;
import com.pocket.tts.i;
import com.pocket.tts.m;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.a.c.k;

class b
  extends i
{
  private b(a parama) {}
  
  protected void a()
  {
    if (!a.a(this.a, this)) {
      return;
    }
    new AlertDialog.Builder(a.j(this.a)).setTitle(2131493785).setMessage(2131493778).setNeutralButton(2131492924, null).setPositiveButton(2131493789, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (a.e(b.this.a) != null) {
          a.e(b.this.a).h();
        }
        m.a(a.i(b.this.a));
      }
    }).show();
  }
  
  protected void a(float paramFloat)
  {
    if (!a.a(this.a, this)) {}
    while (a.n(this.a) == null) {
      return;
    }
    a.n(this.a).setProgress(a.a(paramFloat, a.n(this.a)));
  }
  
  public void a(int paramInt)
  {
    if (!a.a(this.a, this)) {
      return;
    }
    new AlertDialog.Builder(a.h(this.a).m()).setTitle(2131493783).setMessage(2131493782).setNegativeButton(2131492924, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        b.this.a.a();
      }
    }).show();
  }
  
  protected void a(d paramd)
  {
    if (!a.a(this.a, this)) {}
    while ((paramd.a()) || (paramd.b == null)) {
      return;
    }
    new com.pocket.webkit.a("article", "ttsScrollTo").a(paramd.b.a).a(paramd.b.b).a(paramd.g).a(a.k(this.a));
  }
  
  public void a(h paramh)
  {
    if (!a.a(this.a, this)) {
      return;
    }
    a.a(this.a, paramh);
    if ((paramh.i()) && (k.a(h.b(), a.a(this.a))))
    {
      if (a.b(this.a) == null) {
        a.c(this.a);
      }
      for (;;)
      {
        paramh = a.e(this.a).p();
        if (paramh == null) {
          break;
        }
        a.f(this.a).a(paramh);
        return;
        a.d(this.a);
      }
    }
    this.a.a(a.a(this.a), a.g(this.a));
  }
  
  public void a(String paramString)
  {
    if (!a.a(this.a, this)) {}
    while (paramString.equals(a.a(this.a))) {
      return;
    }
    this.a.a();
    a.h(this.a).c(paramString);
  }
  
  protected void a(Locale paramLocale)
  {
    if (!a.a(this.a, this)) {}
    while (a.m(this.a) == null) {
      return;
    }
    a.m(this.a).setSelection(a.e(this.a).m().indexOf(paramLocale));
  }
  
  protected void b()
  {
    if (!a.a(this.a, this)) {
      return;
    }
    a.l(this.a);
  }
  
  public void b(int paramInt)
  {
    if (!a.a(this.a, this)) {
      return;
    }
    new AlertDialog.Builder(a.h(this.a).m()).setTitle(2131493090).setMessage(2131493782).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        b.this.a.a();
      }
    }).setPositiveButton(2131492932, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = a.a(b.this.a);
        b.this.a.a();
        b.this.a.a(paramAnonymousDialogInterface, a.g(b.this.a));
      }
    }).show();
  }
  
  public void b(String paramString)
  {
    if (!a.a(this.a, this)) {
      return;
    }
    a.e(this.a).a(a.g(this.a));
    a.d(this.a);
  }
  
  protected void c()
  {
    if (!a.a(this.a, this)) {
      return;
    }
    a.l(this.a);
  }
  
  public void c(int paramInt)
  {
    this.a.a();
  }
  
  public void d()
  {
    this.a.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */