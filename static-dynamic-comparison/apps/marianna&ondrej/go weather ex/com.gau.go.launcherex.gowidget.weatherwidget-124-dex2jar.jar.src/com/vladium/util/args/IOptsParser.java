package com.vladium.util.args;

import java.io.PrintWriter;

public abstract interface IOptsParser
{
  public static final int DETAILED_USAGE = 2;
  public static final int SHORT_USAGE = 1;
  
  public abstract IOpts parse(String[] paramArrayOfString);
  
  public abstract void usage(PrintWriter paramPrintWriter, int paramInt1, int paramInt2);
  
  public static abstract class Factory
  {
    public static IOptsParser create(String paramString1, ClassLoader paramClassLoader, String paramString2, String[] paramArrayOfString)
    {
      return new OptsParser(paramString1, paramClassLoader, paramString2, paramArrayOfString);
    }
  }
  
  public static abstract interface IOpt
  {
    public abstract String getCanonicalName();
    
    public abstract String getFirstValue();
    
    public abstract String getName();
    
    public abstract String getPatternPrefix();
    
    public abstract int getValueCount();
    
    public abstract String[] getValues();
  }
  
  public static abstract interface IOpts
  {
    public abstract void error(PrintWriter paramPrintWriter, int paramInt);
    
    public abstract String[] getFreeArgs();
    
    public abstract IOptsParser.IOpt[] getOpts();
    
    public abstract IOptsParser.IOpt[] getOpts(String paramString);
    
    public abstract boolean hasArg(String paramString);
    
    public abstract int usageRequestLevel();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/args/IOptsParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */