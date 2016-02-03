package com.pocket.webkit;

import android.webkit.WebView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.u;
import org.codehaus.jackson.JsonNode;

public class a
{
  private StringBuilder a = u.a();
  private String b;
  private boolean c;
  
  public a(String paramString)
  {
    this(null, paramString);
  }
  
  public a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      this.a.append(paramString1).append(".");
    }
    this.a.append(paramString2).append("(");
  }
  
  private void a()
  {
    if (this.c)
    {
      this.a.append(", ");
      return;
    }
    this.c = true;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace("'", "\\'").replace("\n", " ");
  }
  
  public a a(float paramFloat)
  {
    a();
    this.a.append(paramFloat);
    return this;
  }
  
  public a a(int paramInt)
  {
    a();
    this.a.append(paramInt);
    return this;
  }
  
  public a a(String paramString)
  {
    a();
    this.a.append("'").append(b(paramString)).append("'");
    return this;
  }
  
  public a a(JsonNode paramJsonNode)
  {
    a();
    this.a.append(b(paramJsonNode.toString()));
    return this;
  }
  
  public a a(boolean paramBoolean)
  {
    a();
    StringBuilder localStringBuilder = this.a;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localStringBuilder.append(str);
      return this;
    }
  }
  
  public void a(final WebView paramWebView)
  {
    if (!g.q()) {
      g.a(new Runnable()
      {
        public void run()
        {
          a.this.a(paramWebView);
        }
      });
    }
    do
    {
      return;
      if (this.b == null)
      {
        this.a.insert(0, "javascript: ");
        this.a.append(");");
        this.b = this.a.toString();
        u.a(this.a);
        this.a = null;
      }
      paramWebView.loadUrl(this.b);
    } while (!(paramWebView instanceof b));
    ((b)paramWebView).d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/webkit/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */