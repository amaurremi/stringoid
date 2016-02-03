package com.gtp.a.a.b;

class b
{
  private int a = 100;
  
  b()
  {
    b();
  }
  
  private void b()
  {
    if ("INFO" != null) {}
    for (;;)
    {
      try
      {
        if ("INFO".equals("ASSERT"))
        {
          this.a = 7;
          return;
        }
        if ("INFO".equals("ERROR"))
        {
          this.a = 6;
          continue;
        }
        if (!"INFO".equals("WARN")) {
          break label68;
        }
      }
      finally {}
      this.a = 5;
      continue;
      label68:
      if ("INFO".equals("INFO")) {
        this.a = 4;
      } else if ("INFO".equals("DEBUG")) {
        this.a = 3;
      } else if ("INFO".equals("VERBOSE")) {
        this.a = 2;
      }
    }
  }
  
  final boolean a()
  {
    return false;
  }
  
  final boolean a(int paramInt)
  {
    return paramInt >= this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/a/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */