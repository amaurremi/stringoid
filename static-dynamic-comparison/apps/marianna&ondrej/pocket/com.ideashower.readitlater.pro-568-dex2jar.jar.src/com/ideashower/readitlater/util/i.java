package com.ideashower.readitlater.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ideashower.readitlater.a.g;
import com.pocket.text.CustomTypefaceSpan;
import java.util.Locale;
import org.apache.a.c.k;

public class i
{
  public static final int a = g.b(2131361812);
  public static final int b = g.b(2131361808);
  public static final int c = g.b(2131361809);
  public static final int d = g.b(2131361807);
  public static final int e = g.b(2131361813);
  public static final int f = g.b(2131361811);
  public static final int g = g.b(2131361810);
  public static final int h = g.b(2131361804);
  public static final int i = g.b(2131361805);
  public static final int j = g.b(2131361806);
  public static final int k = g.b(2131361814);
  private static Typeface l;
  private static Typeface m;
  private static Typeface n;
  private static Typeface o;
  private static Typeface p;
  private static Typeface q;
  private static Typeface r;
  private static Typeface s;
  private static Typeface t;
  private static Typeface u;
  private static Typeface v;
  
  private static float a(Typeface paramTypeface)
  {
    if ((paramTypeface != p) && (paramTypeface != n) && (paramTypeface != o) && (paramTypeface != r) && (paramTypeface != l) && (paramTypeface == q)) {}
    return 0.25925F;
  }
  
  public static int a(Layout paramLayout, int paramInt)
  {
    int i1 = paramLayout.getLineTop(paramInt);
    paramInt = paramLayout.getLineBaseline(paramInt);
    float f1 = a(paramLayout.getPaint().getTypeface());
    return (int)(i1 + (paramInt - i1) * f1);
  }
  
  public static Typeface a(int paramInt)
  {
    return a(paramInt, g.c());
  }
  
  public static Typeface a(int paramInt, Context paramContext)
  {
    if (paramInt == a)
    {
      if (l == null) {
        l = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/ProximaNova_Sbold.ttf");
      }
      return l;
    }
    if (paramInt == b)
    {
      if (m == null) {
        m = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/ProximaNova-Light.otf");
      }
      return m;
    }
    if (paramInt == c)
    {
      if (n == null) {
        n = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/ProximaNova_Reg.ttf");
      }
      return n;
    }
    if (paramInt == d)
    {
      if (p == null) {
        p = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/ProximaNova-Bold.otf");
      }
      return p;
    }
    if (paramInt == e)
    {
      if (q == null) {
        q = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/ProximaNova-Xbold.otf");
      }
      return q;
    }
    if (paramInt == f)
    {
      if (r == null) {
        r = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/ProximaNova_SboldIt.ttf");
      }
      return r;
    }
    if (paramInt == g)
    {
      if (o == null) {
        o = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/ProximaNova_RegIt.ttf");
      }
      return o;
    }
    if (paramInt == h)
    {
      if (s == null) {
        s = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/Nimbus-Sans-Novus-D-Medium.otf");
      }
      return s;
    }
    if (paramInt == i)
    {
      if (t == null) {
        t = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/Nimbus-Sans-Novus-D-Semi-Bold.otf");
      }
      return t;
    }
    if (paramInt == j)
    {
      if (u == null) {
        u = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/Nimbus-Sans-Novus-Medium-Italic.otf");
      }
      return u;
    }
    if (paramInt == k)
    {
      if (a(paramContext.getResources().getConfiguration().locale))
      {
        if (v == null) {
          v = Typeface.createFromAsset(paramContext.getAssets(), "assets-extra/c/f/ThirstyScriptRegular.otf");
        }
        return v;
      }
      return a(a);
    }
    return null;
  }
  
  public static CharSequence a(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, c, a, g, f);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!(paramCharSequence instanceof Spanned)) {}
    SpannableStringBuilder localSpannableStringBuilder;
    StyleSpan[] arrayOfStyleSpan;
    do
    {
      return paramCharSequence;
      localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
      arrayOfStyleSpan = (StyleSpan[])localSpannableStringBuilder.getSpans(0, paramCharSequence.length() - 1, StyleSpan.class);
    } while ((arrayOfStyleSpan == null) || (arrayOfStyleSpan.length == 0));
    int i2 = arrayOfStyleSpan.length;
    int i1 = 0;
    while (i1 < i2)
    {
      StyleSpan localStyleSpan = arrayOfStyleSpan[i1];
      switch (localStyleSpan.getStyle())
      {
      default: 
        i1 += 1;
        break;
      case 0: 
        paramCharSequence = new CustomTypefaceSpan(a(paramInt1), false);
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          localSpannableStringBuilder.setSpan(paramCharSequence, localSpannableStringBuilder.getSpanStart(localStyleSpan), localSpannableStringBuilder.getSpanEnd(localStyleSpan), 18);
          localSpannableStringBuilder.removeSpan(localStyleSpan);
          break;
          paramCharSequence = new CustomTypefaceSpan(a(paramInt2), false);
          continue;
          paramCharSequence = new CustomTypefaceSpan(a(paramInt3), false);
          continue;
          paramCharSequence = new CustomTypefaceSpan(a(paramInt4), false);
        }
      }
    }
    return localSpannableStringBuilder;
  }
  
  public static void a(int paramInt, View paramView)
  {
    if ((paramView instanceof TextView))
    {
      ((TextView)paramView).setTypeface(a(paramInt, paramView.getContext()));
      ((TextView)paramView).setPaintFlags(((TextView)paramView).getPaintFlags() | 0x80);
    }
    for (;;)
    {
      return;
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i2 = paramView.getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          a(paramInt, paramView.getChildAt(i1));
          i1 += 1;
        }
      }
    }
  }
  
  private static boolean a(Locale paramLocale)
  {
    paramLocale = paramLocale.getLanguage();
    return (k.b(paramLocale, "en")) || (k.b(paramLocale, "de")) || (k.b(paramLocale, "es")) || (k.b(paramLocale, "fr")) || (k.b(paramLocale, "it")) || (k.b(paramLocale, "pl")) || (k.b(paramLocale, "pt")) || (k.b(paramLocale, "nl"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */