package com.pocket.widget.chip;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.z;
import com.pocket.p.v;
import com.pocket.p.x;
import java.util.ArrayList;
import java.util.Iterator;

class e
  extends ChipLayout
  implements k
{
  private final ArrayList a = new ArrayList();
  private final ChipEditText b;
  private final f c;
  private View d;
  private x e;
  private b f;
  private CharSequence g;
  private boolean h;
  private boolean i;
  private d j;
  
  public e(ChipEditText paramChipEditText, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramChipEditText.getContext());
    this.b = paramChipEditText;
    c(paramInt2);
    this.c = a(paramString, paramInt3, paramInt4);
    if (paramInt1 == -1)
    {
      setMaxLines(-1);
      this.c.setMaxLines(1);
      this.c.setSingleLine(true);
    }
    for (;;)
    {
      c(true);
      super.setOnClickListener(this);
      super.setOnItemClickListener(this);
      setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
        {
          e.a(e.this);
          e.a(e.this, false);
          e.b(e.this);
          if (e.d(e.this))
          {
            com.b.c.a.a(paramAnonymousView2, 0.0F);
            com.b.c.a.b(paramAnonymousView2, 1.0F);
            com.b.c.a.c(paramAnonymousView2, 1.0F);
            com.b.c.c.a(paramAnonymousView2).a(333L).a(com.pocket.i.a.e.a).k(1.0F).g(1.0F).i(1.0F);
          }
          e.c(e.this);
        }
        
        public void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
        {
          e.a(e.this);
          paramAnonymousView1 = e.this;
          if (e.this.getChipCount() == 0) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(paramAnonymousView1, bool);
            e.b(e.this);
            e.c(e.this);
            return;
          }
        }
      });
      setClickable(true);
      return;
      setMaxLines(paramInt1);
    }
  }
  
  private f a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new f(getContext(), paramString, paramInt1);
    paramString.a(new h()
    {
      public String a(String paramAnonymousString)
      {
        return e.e(e.this).a(paramAnonymousString);
      }
      
      public void a()
      {
        int i = -1;
        if (e.i(e.this) != null) {
          i = e.this.indexOfChild(e.i(e.this));
        }
        for (;;)
        {
          e.a(e.this, null);
          if (i >= 0)
          {
            CharSequence localCharSequence = e.this.b(i);
            e.this.a(i);
            if (e.f(e.this) != null) {
              e.f(e.this).a(localCharSequence);
            }
          }
          e.g(e.this).setIsInputValid(true);
          e.h(e.this);
          return;
          if (e.this.getChipCount() > 0) {
            i = e.this.getChipCount() - 1;
          }
        }
      }
      
      public void a(CharSequence paramAnonymousCharSequence)
      {
        e.this.b(paramAnonymousCharSequence);
        if (e.f(e.this) != null) {
          e.f(e.this).b(paramAnonymousCharSequence);
        }
        e.g(e.this).setIsInputValid(true);
        e.h(e.this);
      }
      
      public void a(ArrayList paramAnonymousArrayList)
      {
        paramAnonymousArrayList = paramAnonymousArrayList.iterator();
        while (paramAnonymousArrayList.hasNext()) {
          a((CharSequence)paramAnonymousArrayList.next());
        }
      }
      
      public void b(ArrayList paramAnonymousArrayList)
      {
        if (e.f(e.this) != null) {
          e.f(e.this).a((String)paramAnonymousArrayList.get(0));
        }
        e.g(e.this).setIsInputValid(false);
        e.h(e.this);
      }
    });
    paramString.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          z.b(true, paramAnonymousView);
        }
        e.b(e.this);
        e.h(e.this);
        if (e.j(e.this) != null) {
          e.j(e.this).a(paramAnonymousBoolean);
        }
      }
    });
    paramString.addTextChangedListener(new v()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        e.a(e.this);
        paramAnonymousEditable = e.this;
        if (e.this.getChipCount() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          e.a(paramAnonymousEditable, bool);
          e.c(e.this);
          e.a(e.this, e.this.b().toString());
          return;
        }
      }
    });
    setIsModifyingChildren(true);
    addView(paramString);
    setIsModifyingChildren(false);
    z.g(paramString, paramInt2);
    return paramString;
  }
  
  private void b(String paramString)
  {
    if (this.e != null)
    {
      if (this.e.a(paramString) != null) {
        break label33;
      }
      this.b.setIsInputValid(true);
    }
    for (;;)
    {
      p();
      return;
      label33:
      this.b.setIsInputValid(false);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setHint(this.g);
      return;
    }
    this.c.setHint(null);
  }
  
  private boolean k()
  {
    if (getAdapter() == null) {}
    View localView;
    do
    {
      return false;
      localView = getAdapter().a("", this);
    } while (localView == null);
    this.c.setLayoutParams(new org.a.a.a.b(-2, localView.getLayoutParams().height));
    this.c.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getPaddingRight(), localView.getPaddingBottom());
    return true;
  }
  
  private void l()
  {
    if (this.d != null)
    {
      this.d.setSelected(false);
      this.d = null;
    }
  }
  
  private void m()
  {
    z.a(true, this.c);
    z.b(true, this.c);
  }
  
  private void n()
  {
    final View localView = o();
    if (localView != null)
    {
      Handler localHandler = localView.getHandler();
      localView.scrollTo(getWidth(), getHeight());
      if (localHandler != null) {
        localHandler.post(new Runnable()
        {
          public void run()
          {
            localView.scrollTo(e.this.getWidth(), e.this.getHeight());
          }
        });
      }
    }
  }
  
  private View o()
  {
    if ((getParent() instanceof HorizontalScrollView)) {
      return (View)getParent();
    }
    if ((z.h(this, 2) instanceof ScrollView)) {
      return z.h(this, 2);
    }
    return null;
  }
  
  private void p()
  {
    invalidate();
    refreshDrawableState();
    this.b.invalidate();
    this.b.refreshDrawableState();
  }
  
  private void q()
  {
    int k = getChipCount();
    CharSequence localCharSequence = b();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(k, localCharSequence);
    }
  }
  
  public void a()
  {
    if (this.c.isFocused())
    {
      this.c.clearFocus();
      z.b(false, this.c);
      getRootView().findViewById(2131230882).requestFocus();
      p();
    }
  }
  
  public void a(TextWatcher paramTextWatcher)
  {
    this.c.addTextChangedListener(paramTextWatcher);
  }
  
  public void a(x paramx)
  {
    this.e = paramx;
  }
  
  public void a(ChipLayout paramChipLayout, View paramView, int paramInt)
  {
    l();
    if (paramView != this.c)
    {
      this.d = paramView;
      this.c.setSelection(0);
      paramView.setSelected(true);
      m();
    }
  }
  
  public void a(a parama)
  {
    this.a.add(parama);
  }
  
  public void a(b paramb)
  {
    this.f = paramb;
  }
  
  public void a(c paramc)
  {
    this.c.a(paramc);
  }
  
  public void a(d paramd)
  {
    this.j = paramd;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.g = paramCharSequence;
    if ((org.apache.a.c.k.c(b())) && (getChipCount() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public CharSequence b()
  {
    return this.c.getText();
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (paramBoolean) {
      k();
    }
  }
  
  public boolean c()
  {
    return this.c.a();
  }
  
  public void d()
  {
    this.c.setText("");
  }
  
  public void e()
  {
    this.c.setText(null);
    i();
  }
  
  public void f()
  {
    l();
    m();
    n();
  }
  
  public boolean g()
  {
    return this.c.isFocused();
  }
  
  public int getChipCount()
  {
    return getChildCount() - 1;
  }
  
  public void h()
  {
    this.c.setSelection(this.c.getText().length());
    g.o().post(new Runnable()
    {
      public void run()
      {
        e.k(e.this).setSelection(e.k(e.this).getText().length());
      }
    });
    n();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    z.a(paramMotionEvent, this.c);
    if (paramMotionEvent.getAction() == 1) {
      f();
    }
    return true;
  }
  
  public void setAdapter(j paramj)
  {
    super.setAdapter(paramj);
    if (this.i) {
      k();
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new UnsupportedOperationException("setOnClickListener() is not allowed with this class.");
  }
  
  public void setOnItemClickListener(k paramk)
  {
    throw new UnsupportedOperationException("setOnItemClickListener() is not allowed with this class.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/chip/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */