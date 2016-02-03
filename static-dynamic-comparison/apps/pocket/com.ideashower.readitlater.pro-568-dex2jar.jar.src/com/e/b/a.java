package com.e.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class a
{
  private final CharSequence a;
  private final Set b = new HashSet();
  private final Map c = new HashMap();
  private CharSequence d;
  private e e;
  private char f;
  private int g;
  
  private a(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() > 0) {
      c1 = paramCharSequence.charAt(0);
    }
    this.f = c1;
    this.a = paramCharSequence;
    paramCharSequence = null;
    for (;;)
    {
      e locale = a(paramCharSequence);
      if (locale == null) {
        break;
      }
      paramCharSequence = locale;
      if (this.e == null)
      {
        this.e = locale;
        paramCharSequence = locale;
      }
    }
  }
  
  public static a a(Context paramContext, int paramInt)
  {
    return a(paramContext.getResources(), paramInt);
  }
  
  public static a a(Resources paramResources, int paramInt)
  {
    return a(paramResources.getText(paramInt));
  }
  
  public static a a(CharSequence paramCharSequence)
  {
    return new a(paramCharSequence);
  }
  
  private e a(e parame)
  {
    if (this.f == 0) {
      return null;
    }
    if (this.f == '{')
    {
      char c1 = b();
      if (c1 == '{') {
        return d(parame);
      }
      if ((c1 >= 'a') && (c1 <= 'z')) {
        return b(parame);
      }
      throw new IllegalArgumentException("Unexpected character '" + c1 + "'; expected key.");
    }
    return c(parame);
  }
  
  private char b()
  {
    if (this.g < this.a.length() - 1) {
      return this.a.charAt(this.g + 1);
    }
    return '\000';
  }
  
  private b b(e parame)
  {
    Object localObject = new StringBuilder();
    c();
    while (((this.f >= 'a') && (this.f <= 'z')) || (this.f == '_'))
    {
      ((StringBuilder)localObject).append(this.f);
      c();
    }
    if (this.f != '}') {
      throw new IllegalArgumentException("Missing closing brace: }");
    }
    c();
    if (((StringBuilder)localObject).length() == 0) {
      throw new IllegalArgumentException("Empty key: {}");
    }
    localObject = ((StringBuilder)localObject).toString();
    this.b.add(localObject);
    return new b(parame, (String)localObject);
  }
  
  private d c(e parame)
  {
    int i = this.g;
    while ((this.f != '{') && (this.f != 0)) {
      c();
    }
    return new d(parame, this.g - i);
  }
  
  private void c()
  {
    this.g += 1;
    if (this.g == this.a.length()) {}
    for (char c1 = '\000';; c1 = this.a.charAt(this.g))
    {
      this.f = c1;
      return;
    }
  }
  
  private c d(e parame)
  {
    c();
    c();
    return new c(parame);
  }
  
  public a a(String paramString, int paramInt)
  {
    if (!this.b.contains(paramString)) {
      throw new IllegalArgumentException("Invalid key: " + paramString);
    }
    this.c.put(paramString, Integer.toString(paramInt));
    this.d = null;
    return this;
  }
  
  public a a(String paramString, CharSequence paramCharSequence)
  {
    if (!this.b.contains(paramString)) {
      throw new IllegalArgumentException("Invalid key: " + paramString);
    }
    if (paramCharSequence == null) {
      throw new IllegalArgumentException("Null value for '" + paramString + "'");
    }
    this.c.put(paramString, paramCharSequence);
    this.d = null;
    return this;
  }
  
  public CharSequence a()
  {
    if (this.d == null)
    {
      if (!this.c.keySet().containsAll(this.b))
      {
        localObject = new HashSet(this.b);
        ((Set)localObject).removeAll(this.c.keySet());
        throw new IllegalArgumentException("Missing keys: " + localObject);
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.a);
      for (Object localObject = this.e; localObject != null; localObject = e.a((e)localObject)) {
        ((e)localObject).a(localSpannableStringBuilder, this.c);
      }
      this.d = localSpannableStringBuilder;
    }
    return this.d;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */