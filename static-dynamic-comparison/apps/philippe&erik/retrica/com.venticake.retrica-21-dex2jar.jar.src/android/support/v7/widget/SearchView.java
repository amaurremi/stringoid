package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayout
  implements android.support.v7.c.b
{
  static final a a = new a();
  private Bundle A;
  private Runnable B;
  private Runnable C;
  private Runnable D;
  private final Intent E;
  private final Intent F;
  private final WeakHashMap<String, Drawable.ConstantState> G;
  private c b;
  private b c;
  private View.OnFocusChangeListener d;
  private d e;
  private View.OnClickListener f;
  private boolean g;
  private boolean h;
  private android.support.v4.widget.a i;
  private View j;
  private View k;
  private View l;
  private ImageView m;
  private View n;
  private View o;
  private SearchView.SearchAutoComplete p;
  private ImageView q;
  private boolean r;
  private CharSequence s;
  private boolean t;
  private boolean u;
  private int v;
  private boolean w;
  private boolean x;
  private int y;
  private SearchableInfo z;
  
  private void a(boolean paramBoolean)
  {
    boolean bool2 = true;
    int i2 = 8;
    this.h = paramBoolean;
    int i1;
    boolean bool1;
    if (paramBoolean)
    {
      i1 = 0;
      if (TextUtils.isEmpty(this.p.getText())) {
        break label115;
      }
      bool1 = true;
      label33:
      this.j.setVisibility(i1);
      b(bool1);
      Object localObject = this.n;
      if (!paramBoolean) {
        break label121;
      }
      i1 = 8;
      label60:
      ((View)localObject).setVisibility(i1);
      localObject = this.q;
      if (!this.g) {
        break label126;
      }
      i1 = i2;
      label81:
      ((ImageView)localObject).setVisibility(i1);
      h();
      if (bool1) {
        break label131;
      }
    }
    label115:
    label121:
    label126:
    label131:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      c(paramBoolean);
      g();
      return;
      i1 = 8;
      break;
      bool1 = false;
      break label33;
      i1 = 0;
      break label60;
      i1 = 0;
      break label81;
    }
  }
  
  static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private CharSequence b(CharSequence paramCharSequence)
  {
    if (!this.g) {
      return paramCharSequence;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.append(paramCharSequence);
    paramCharSequence = getContext().getResources().getDrawable(getSearchIconId());
    int i1 = (int)(this.p.getTextSize() * 1.25D);
    paramCharSequence.setBounds(0, 0, i1, i1);
    localSpannableStringBuilder.setSpan(new ImageSpan(paramCharSequence), 1, 2, 33);
    return localSpannableStringBuilder;
  }
  
  private void b(boolean paramBoolean)
  {
    int i2 = 8;
    int i1 = i2;
    if (this.r)
    {
      i1 = i2;
      if (f())
      {
        i1 = i2;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i1 = i2;
            if (this.w) {}
          }
          else
          {
            i1 = 0;
          }
        }
      }
    }
    this.k.setVisibility(i1);
  }
  
  private void c(boolean paramBoolean)
  {
    int i1;
    if ((this.w) && (!c()) && (paramBoolean))
    {
      i1 = 0;
      this.k.setVisibility(8);
    }
    for (;;)
    {
      this.o.setVisibility(i1);
      return;
      i1 = 8;
    }
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Intent localIntent;
    if (this.z != null)
    {
      bool1 = bool2;
      if (this.z.getVoiceSearchEnabled())
      {
        localIntent = null;
        if (!this.z.getVoiceSearchLaunchWebSearch()) {
          break label68;
        }
        localIntent = this.E;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (localIntent != null)
      {
        bool1 = bool2;
        if (getContext().getPackageManager().resolveActivity(localIntent, 65536) != null) {
          bool1 = true;
        }
      }
      return bool1;
      label68:
      if (this.z.getVoiceSearchLaunchRecognizer()) {
        localIntent = this.F;
      }
    }
  }
  
  private boolean f()
  {
    return ((this.r) || (this.w)) && (!c());
  }
  
  private void g()
  {
    int i2 = 8;
    int i1 = i2;
    if (f()) {
      if (this.k.getVisibility() != 0)
      {
        i1 = i2;
        if (this.o.getVisibility() != 0) {}
      }
      else
      {
        i1 = 0;
      }
    }
    this.l.setVisibility(i1);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(android.support.v7.b.e.abc_search_view_preferred_width);
  }
  
  private int getSearchIconId()
  {
    TypedValue localTypedValue = new TypedValue();
    getContext().getTheme().resolveAttribute(android.support.v7.b.c.searchViewSearchIcon, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  private void h()
  {
    int i4 = 1;
    int i3 = 0;
    int i1;
    int i2;
    label44:
    label56:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.p.getText()))
    {
      i1 = 1;
      i2 = i4;
      if (i1 == 0)
      {
        if ((!this.g) || (this.x)) {
          break label94;
        }
        i2 = i4;
      }
      localObject = this.m;
      if (i2 == 0) {
        break label99;
      }
      i2 = i3;
      ((ImageView)localObject).setVisibility(i2);
      localDrawable = this.m.getDrawable();
      if (i1 == 0) {
        break label105;
      }
    }
    label94:
    label99:
    label105:
    for (Object localObject = ENABLED_STATE_SET;; localObject = EMPTY_STATE_SET)
    {
      localDrawable.setState((int[])localObject);
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label44;
      i2 = 8;
      break label56;
    }
  }
  
  private void i()
  {
    post(this.C);
  }
  
  private void j()
  {
    if (this.s != null) {
      this.p.setHint(b(this.s));
    }
    String str;
    do
    {
      return;
      if (this.z == null) {
        break;
      }
      str = null;
      int i1 = this.z.getHintId();
      if (i1 != 0) {
        str = getContext().getString(i1);
      }
    } while (str == null);
    this.p.setHint(b(str));
    return;
    this.p.setHint(b(""));
  }
  
  private void k()
  {
    int i2 = 1;
    this.p.setThreshold(this.z.getSuggestThreshold());
    this.p.setImeOptions(this.z.getImeOptions());
    int i3 = this.z.getInputType();
    int i1 = i3;
    if ((i3 & 0xF) == 1)
    {
      i3 &= 0xFFFEFFFF;
      i1 = i3;
      if (this.z.getSuggestAuthority() != null) {
        i1 = i3 | 0x10000 | 0x80000;
      }
    }
    this.p.setInputType(i1);
    if (this.i != null) {
      this.i.a(null);
    }
    if (this.z.getSuggestAuthority() != null)
    {
      this.i = new e(getContext(), this, this.z, this.G);
      this.p.setAdapter(this.i);
      e locale = (e)this.i;
      i1 = i2;
      if (this.t) {
        i1 = 2;
      }
      locale.a(i1);
    }
  }
  
  private void l()
  {
    if (TextUtils.isEmpty(this.p.getText()))
    {
      if ((this.g) && ((this.c == null) || (!this.c.a())))
      {
        clearFocus();
        a(true);
      }
      return;
    }
    this.p.setText("");
    this.p.requestFocus();
    setImeVisibility(true);
  }
  
  private void m()
  {
    a(false);
    this.p.requestFocus();
    setImeVisibility(true);
    if (this.f != null) {
      this.f.onClick(this);
    }
  }
  
  private void n()
  {
    a.a(this.p);
    a.b(this.p);
  }
  
  private void setImeVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      post(this.B);
    }
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      removeCallbacks(this.B);
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    } while (localInputMethodManager == null);
    localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  private void setQuery(CharSequence paramCharSequence)
  {
    this.p.setText(paramCharSequence);
    SearchView.SearchAutoComplete localSearchAutoComplete = this.p;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i1 = 0;; i1 = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i1);
      return;
    }
  }
  
  public void a()
  {
    if (this.x) {
      return;
    }
    this.x = true;
    this.y = this.p.getImeOptions();
    this.p.setImeOptions(this.y | 0x2000000);
    this.p.setText("");
    setIconified(false);
  }
  
  void a(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }
  
  public void b()
  {
    clearFocus();
    a(true);
    this.p.setImeOptions(this.y);
    this.x = false;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public void clearFocus()
  {
    this.u = true;
    setImeVisibility(false);
    super.clearFocus();
    this.p.clearFocus();
    this.u = false;
  }
  
  void d()
  {
    a(c());
    i();
    if (this.p.hasFocus()) {
      n();
    }
  }
  
  public int getImeOptions()
  {
    return this.p.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.p.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.v;
  }
  
  public CharSequence getQuery()
  {
    return this.p.getText();
  }
  
  public CharSequence getQueryHint()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.s != null) {
      localObject1 = this.s;
    }
    int i1;
    do
    {
      do
      {
        return (CharSequence)localObject1;
        localObject1 = localObject2;
      } while (this.z == null);
      i1 = this.z.getHintId();
      localObject1 = localObject2;
    } while (i1 == 0);
    return getContext().getString(i1);
  }
  
  public android.support.v4.widget.a getSuggestionsAdapter()
  {
    return this.i;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.C);
    post(this.D);
    super.onDetachedFromWindow();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.z == null) {
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (c())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    switch (i2)
    {
    default: 
      paramInt1 = i1;
    }
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      return;
      if (this.v > 0)
      {
        paramInt1 = Math.min(this.v, i1);
      }
      else
      {
        paramInt1 = Math.min(getPreferredWidth(), i1);
        continue;
        paramInt1 = i1;
        if (this.v > 0)
        {
          paramInt1 = Math.min(this.v, i1);
          continue;
          if (this.v > 0) {
            paramInt1 = this.v;
          } else {
            paramInt1 = getPreferredWidth();
          }
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    i();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.u) {}
    while (!isFocusable()) {
      return false;
    }
    if (!c())
    {
      boolean bool = this.p.requestFocus(paramInt, paramRect);
      if (bool) {
        a(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.A = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      l();
      return;
    }
    m();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.g == paramBoolean) {
      return;
    }
    this.g = paramBoolean;
    a(paramBoolean);
    j();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.p.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.p.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.v = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.c = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.d = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.b = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(d paramd)
  {
    this.e = paramd;
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.s = paramCharSequence;
    j();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.t = paramBoolean;
    e locale;
    if ((this.i instanceof e))
    {
      locale = (e)this.i;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i1 = 2;; i1 = 1)
    {
      locale.a(i1);
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    this.z = paramSearchableInfo;
    if (this.z != null)
    {
      k();
      j();
    }
    this.w = e();
    if (this.w) {
      this.p.setPrivateImeOptions("nm");
    }
    a(c());
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.r = paramBoolean;
    a(c());
  }
  
  public void setSuggestionsAdapter(android.support.v4.widget.a parama)
  {
    this.i = parama;
    this.p.setAdapter(this.i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/widget/SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */