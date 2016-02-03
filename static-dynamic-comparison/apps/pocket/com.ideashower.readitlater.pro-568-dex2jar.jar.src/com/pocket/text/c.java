package com.pocket.text;

import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;

public class c
  extends a
{
  private int a;
  private boolean b;
  private Typeface c;
  
  public c()
  {
    a(new b()
    {
      public void a(TextPaint paramAnonymousTextPaint)
      {
        if (c.a(c.this)) {
          paramAnonymousTextPaint.setColor(c.b(c.this));
        }
        if (c.c(c.this) != null) {
          paramAnonymousTextPaint.setTypeface(c.c(c.this));
        }
      }
    });
  }
  
  public static void a(int paramInt, Spanned paramSpanned)
  {
    paramSpanned = b(paramSpanned);
    int j = paramSpanned.length;
    int i = 0;
    while (i < j)
    {
      paramSpanned[i].a(paramInt);
      i += 1;
    }
  }
  
  public static void a(Typeface paramTypeface, Spanned paramSpanned)
  {
    paramSpanned = b(paramSpanned);
    int j = paramSpanned.length;
    int i = 0;
    while (i < j)
    {
      paramSpanned[i].a(paramTypeface);
      i += 1;
    }
  }
  
  public static void a(Spanned paramSpanned)
  {
    paramSpanned = b(paramSpanned);
    int j = paramSpanned.length;
    int i = 0;
    while (i < j)
    {
      paramSpanned[i].a();
      i += 1;
    }
  }
  
  private static c[] b(Spanned paramSpanned)
  {
    return (c[])paramSpanned.getSpans(0, paramSpanned.length(), c.class);
  }
  
  public void a()
  {
    this.a = 0;
    this.b = false;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    this.b = true;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.c = paramTypeface;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/text/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */