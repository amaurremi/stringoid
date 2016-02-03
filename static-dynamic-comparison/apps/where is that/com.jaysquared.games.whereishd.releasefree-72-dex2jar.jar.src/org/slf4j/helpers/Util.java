package org.slf4j.helpers;

import java.io.PrintStream;

public class Util
{
  public static final void reportFailure(String paramString)
  {
    System.err.println("SLF4J: " + paramString);
  }
  
  public static final void reportFailure(String paramString, Throwable paramThrowable)
  {
    System.err.println(paramString);
    System.err.println("Reported exception:");
    paramThrowable.printStackTrace();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/helpers/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */