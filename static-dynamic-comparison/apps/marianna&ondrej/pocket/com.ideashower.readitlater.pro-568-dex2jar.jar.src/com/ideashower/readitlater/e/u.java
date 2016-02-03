package com.ideashower.readitlater.e;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import com.pocket.text.c;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.a.c.k;

public class u
{
  private int a;
  private SpannableStringBuilder b;
  private SpannableStringBuilder c;
  private SpannableStringBuilder d;
  private ArrayList e;
  private SpannableStringBuilder f;
  private SpannableStringBuilder g;
  
  protected u() {}
  
  protected u(u paramu)
  {
    this.a = paramu.a;
    this.c = paramu.c;
    this.b = paramu.b;
    this.d = paramu.d;
    if (paramu.e != null) {}
    for (ArrayList localArrayList = new ArrayList(paramu.e);; localArrayList = null)
    {
      this.e = localArrayList;
      this.f = paramu.f;
      this.g = paramu.g;
      return;
    }
  }
  
  private static SpannableStringBuilder f(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    paramString = new SpannableStringBuilder(Html.fromHtml(paramString));
    StyleSpan[] arrayOfStyleSpan = (StyleSpan[])paramString.getSpans(0, paramString.length(), StyleSpan.class);
    int j = arrayOfStyleSpan.length;
    while (i < j)
    {
      StyleSpan localStyleSpan = arrayOfStyleSpan[i];
      int k = localStyleSpan.getStyle();
      if ((k == 2) || (k == 3))
      {
        paramString.setSpan(new c(), paramString.getSpanStart(localStyleSpan), paramString.getSpanEnd(localStyleSpan), 18);
        paramString.removeSpan(localStyleSpan);
      }
      i += 1;
    }
    return paramString;
  }
  
  public Spanned a(o paramo)
  {
    if (this.f == null) {
      return null;
    }
    paramo = paramo.o();
    if (k.a(paramo, this.f)) {
      return this.f;
    }
    if (!k.a(paramo, this.g))
    {
      this.g = new SpannableStringBuilder(paramo);
      paramo = new c();
      this.g.setSpan(paramo, 0, this.g.length(), 18);
    }
    return this.g;
  }
  
  protected void a()
  {
    this.a = 0;
    this.b = null;
    this.c = null;
    this.d = null;
    this.f = null;
    this.e = null;
    this.g = null;
  }
  
  protected void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected void a(String paramString)
  {
    this.b = f(paramString);
  }
  
  protected void b(String paramString)
  {
    this.d = f(paramString);
    paramString = this.d.toString();
    String str = o.a(paramString);
    int i = paramString.indexOf(str);
    int j = str.length();
    this.f = new SpannableStringBuilder(this.d.subSequence(i, j + i));
    if (((c[])this.f.getSpans(0, this.f.length(), c.class)).length == 0)
    {
      paramString = new c();
      this.f.setSpan(paramString, 0, this.f.length(), 18);
    }
  }
  
  protected boolean b()
  {
    return (this.a != 0) || (c());
  }
  
  protected void c(String paramString)
  {
    this.c = f(paramString);
  }
  
  public boolean c()
  {
    return (this.b != null) || (this.c != null) || (this.d != null) || (this.f != null) || (g());
  }
  
  public Spanned d()
  {
    return this.c;
  }
  
  protected void d(String paramString)
  {
    paramString = f(paramString).toString();
    this.e = new ArrayList(1);
    this.e.add(paramString);
  }
  
  public Spanned e()
  {
    return this.b;
  }
  
  public boolean e(String paramString)
  {
    if (!g()) {
      return false;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      if (k.b(paramString, (String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public int f()
  {
    return this.a;
  }
  
  public boolean g()
  {
    return (this.e != null) && (!this.e.isEmpty());
  }
  
  public boolean h()
  {
    return (this.b != null) && (this.c == null) && (this.d == null) && (this.f == null) && (!g());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */