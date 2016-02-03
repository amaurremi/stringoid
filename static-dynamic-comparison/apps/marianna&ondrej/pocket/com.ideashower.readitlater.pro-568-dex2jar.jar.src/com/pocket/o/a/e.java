package com.pocket.o.a;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.pocket.p.v;
import com.pocket.widget.chip.ChipEditText;
import com.pocket.widget.chip.b;
import java.util.ArrayList;

public class e
  extends i
{
  private final ChipEditText a;
  
  public e(l paraml, k paramk, ChipEditText paramChipEditText)
  {
    super(paraml, paramk, paramChipEditText.getContext());
    this.a = paramChipEditText;
    this.a.setMimicChipAdapterStyleEnabled(true);
    this.a.setAdapter(new com.pocket.widget.chip.j()
    {
      public View a(CharSequence paramAnonymousCharSequence, ViewGroup paramAnonymousViewGroup)
      {
        paramAnonymousViewGroup = (TextView)LayoutInflater.from(e.this.g()).inflate(2130903127, paramAnonymousViewGroup, false);
        paramAnonymousViewGroup.setText(paramAnonymousCharSequence);
        return paramAnonymousViewGroup;
      }
    });
    this.a.a(new v()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() == 0) {}
        for (paramAnonymousEditable = "";; paramAnonymousEditable = paramAnonymousEditable.subSequence(0, paramAnonymousEditable.length()))
        {
          e.this.f().a(e.this, paramAnonymousEditable);
          return;
        }
      }
    });
    this.a.setValidator(f().f());
    this.a.setOnChipsChangedListener(new b()
    {
      public void a(CharSequence paramAnonymousCharSequence)
      {
        e.this.f().b(e.this, paramAnonymousCharSequence.toString());
      }
      
      public void a(String paramAnonymousString)
      {
        e.this.f().a(paramAnonymousString);
      }
      
      public void b(CharSequence paramAnonymousCharSequence)
      {
        e.this.f().a(e.this, paramAnonymousCharSequence.toString());
      }
    });
  }
  
  public ListAdapter a()
  {
    return null;
  }
  
  public void a(j paramj)
  {
    paramj.b();
  }
  
  public void a(CharSequence paramCharSequence) {}
  
  public void a(String paramString)
  {
    this.a.g();
    this.a.a(paramString);
  }
  
  protected void a(ArrayList paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      this.a.setHint(g().getString(2131493327));
    }
  }
  
  public View b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void i(boolean paramBoolean) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */