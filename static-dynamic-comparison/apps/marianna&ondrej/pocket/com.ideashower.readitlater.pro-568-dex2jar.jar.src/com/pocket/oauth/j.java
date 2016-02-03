package com.pocket.oauth;

import com.google.android.gms.auth.b;
import com.google.android.gms.auth.c;
import com.ideashower.readitlater.a.g;
import java.io.IOException;

public class j
{
  private boolean a = false;
  private String b;
  
  private void a(Throwable paramThrowable, i parami)
  {
    boolean bool2 = false;
    boolean bool1;
    if (parami == null) {
      bool1 = bool2;
    }
    while (!bool1)
    {
      throw new RuntimeException(paramThrowable);
      if ((paramThrowable instanceof c))
      {
        bool1 = parami.a(((c)paramThrowable).a());
      }
      else if ((paramThrowable instanceof com.google.android.gms.auth.e))
      {
        bool1 = parami.a(((com.google.android.gms.auth.e)paramThrowable).b());
      }
      else
      {
        bool1 = bool2;
        if (!(paramThrowable instanceof com.google.android.gms.auth.a))
        {
          bool1 = bool2;
          if ((paramThrowable instanceof IOException)) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public String a(String paramString, i parami)
  {
    try
    {
      this.b = d.b(paramString);
      if (this.b == null) {
        this.a = true;
      }
      paramString = this.b;
      return paramString;
    }
    catch (Throwable paramString)
    {
      if (((paramString instanceof com.google.android.gms.auth.a)) && (!(paramString instanceof c)) && (!(paramString instanceof com.google.android.gms.auth.e))) {
        this.a = true;
      }
      a(paramString, parami);
    }
    return null;
  }
  
  public void a(com.ideashower.readitlater.objects.a parama)
  {
    switch (parama.e())
    {
    default: 
      return;
    }
    try
    {
      b.a(g.c(), this.b);
      this.a = true;
      return;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(parama);
      }
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */