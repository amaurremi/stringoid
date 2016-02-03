package com.android.b.a;

import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.db.operation.f;
import com.pocket.h.b;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.b.a.a.c;
import org.apache.b.a.a.d;

public class a
{
  private static final Pattern c = Pattern.compile("^<?([^>]+)>?$");
  private static final Pattern d = Pattern.compile("^\"?([^\"]*)\"?$");
  private static final Pattern e = Pattern.compile("\\\\([\\\\\"])");
  private static final a[] f = new a[0];
  private String a;
  private String b;
  
  public a(String paramString1, String paramString2)
  {
    a(paramString1);
    b(paramString2);
  }
  
  public static boolean c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = Rfc822Tokenizer.tokenize(paramString);
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramString[i];
        if (b.a((Rfc822Token)localObject)) {}
        do
        {
          i += 1;
          break;
          localObject = ((Rfc822Token)localObject).getAddress();
        } while ((TextUtils.isEmpty((CharSequence)localObject)) || (e((String)localObject)));
        return false;
      }
    }
    return true;
  }
  
  public static a[] d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return f;
    }
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramString);
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfRfc822Token.length;
    int i = 0;
    if (i < j)
    {
      paramString = arrayOfRfc822Token[i];
      if (b.a(paramString)) {
        localArrayList.add(b.b(paramString));
      }
      for (;;)
      {
        i += 1;
        break;
        String str2 = paramString.getAddress();
        if ((!TextUtils.isEmpty(str2)) && (e(str2)))
        {
          String str1 = paramString.getName();
          paramString = str1;
          if (TextUtils.isEmpty(str1)) {
            paramString = null;
          }
          localArrayList.add(new a(str2, paramString));
        }
      }
    }
    return (a[])localArrayList.toArray(new a[0]);
  }
  
  static boolean e(String paramString)
  {
    int i = paramString.length();
    int j = paramString.indexOf('@');
    int k = paramString.lastIndexOf('@');
    int m = paramString.indexOf('.', k + 1);
    int n = paramString.lastIndexOf('.');
    if ((j > 0) && (j == k) && (k + 1 < m) && (m <= n) && (n < i - 1))
    {
      i = 1;
      if (i == 0) {
        break label83;
      }
    }
    label83:
    while (o.c().b(paramString) != null)
    {
      return true;
      i = 0;
      break;
    }
    return false;
  }
  
  public static String f(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.matches("^\".*\"$"));
    return "\"" + paramString + "\"";
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = c.matcher(paramString).replaceAll("$1");
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      paramString = d.matcher(paramString).replaceAll("$1");
      paramString = d.a(e.matcher(paramString).replaceAll("$1"), c.b);
      str = paramString;
      if (paramString.length() == 0) {
        str = null;
      }
    }
    this.b = str;
  }
  
  public boolean c()
  {
    return b.a(this);
  }
  
  public f d()
  {
    int i = org.apache.a.c.d.a.a(this.b);
    return o.c().b(i);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return a().equals(((a)paramObject).a());
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  
  public String toString()
  {
    if ((this.b != null) && (!this.b.equals(this.a)))
    {
      if (this.b.matches(".*[\\(\\)<>@,;:\\\\\".\\[\\]].*")) {
        return f(this.b) + " <" + this.a + ">";
      }
      return this.b + " <" + this.a + ">";
    }
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */