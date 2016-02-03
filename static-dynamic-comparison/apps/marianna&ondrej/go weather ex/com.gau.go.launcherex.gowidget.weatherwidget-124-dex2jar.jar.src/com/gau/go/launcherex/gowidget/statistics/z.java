package com.gau.go.launcherex.gowidget.statistics;

public class z
{
  public int a = -1;
  public String b = null;
  public String c = null;
  public String d = null;
  public String e = null;
  public String f = null;
  public int g = 0;
  
  public static z a(String paramString)
  {
    z localz = new z();
    if (paramString == null) {}
    for (;;)
    {
      return localz;
      Object localObject = null;
      try
      {
        paramString = paramString.split("\\|\\|\\|");
        if ((paramString == null) || (paramString.length != 7)) {}
      }
      catch (Exception paramString)
      {
        try
        {
          localz.a = Integer.parseInt(paramString[0]);
          localz.b = paramString[1];
          localz.c = paramString[2];
          localz.d = paramString[3];
          localz.e = paramString[4];
          localz.f = paramString[5];
          try
          {
            paramString = paramString[6].replaceAll("\n", "").trim();
            if (!"".equals(paramString)) {
              break label135;
            }
            localz.g = 0;
            return localz;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return localz;
          }
          paramString = paramString;
          paramString.printStackTrace();
          paramString = (String)localObject;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          label135:
          localz.g = Integer.parseInt(paramString);
        }
      }
    }
    return localz;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */