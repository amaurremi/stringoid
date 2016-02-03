package com.vladium.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class XProperties
  extends Properties
{
  public XProperties() {}
  
  public XProperties(Properties paramProperties)
  {
    super(paramProperties);
  }
  
  public void list(PrintStream paramPrintStream)
  {
    Object localObject1 = new TreeSet();
    Object localObject2 = propertyNames();
    while (((Enumeration)localObject2).hasMoreElements()) {
      ((Set)localObject1).add(((Enumeration)localObject2).nextElement());
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      String str = getProperty((String)localObject2);
      paramPrintStream.println((String)localObject2 + ":\t[" + str + "]");
    }
  }
  
  public void list(PrintWriter paramPrintWriter)
  {
    Object localObject1 = new TreeSet();
    Object localObject2 = propertyNames();
    while (((Enumeration)localObject2).hasMoreElements()) {
      ((Set)localObject1).add(((Enumeration)localObject2).nextElement());
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      String str = getProperty((String)localObject2);
      paramPrintWriter.println((String)localObject2 + ":\t[" + str + "]");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/XProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */