package com.ideashower.readitlater.activity;

import com.ideashower.readitlater.g.m;
import com.ideashower.readitlater.reader.f;
import com.pocket.webkit.a;
import java.io.File;
import org.apache.a.b.b;
import org.apache.a.c.k;

public class as
  extends m
{
  private final f b;
  private final String c;
  private String d;
  
  protected as(ReaderFragment.JSInterfaceArticle paramJSInterfaceArticle, f paramf, String paramString)
  {
    this.b = paramf;
    this.c = paramString;
  }
  
  protected void a()
  {
    this.d = b.a(new File(k.a(this.c, "file:", "")), "UTF-8");
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if (this.b != ReaderFragment.c(this.a.a)) {
      return;
    }
    if ((paramBoolean) && (this.d != null))
    {
      new a("article", "loadCallback").a(this.d).a(this.a.a.Y);
      return;
    }
    new a("article", "loadHadError").a(this.a.a.Y);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */