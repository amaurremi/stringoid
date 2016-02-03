package com.google.analytics.tracking.android;

import java.util.SortedSet;
import java.util.TreeSet;

class GAUsage
{
  private static final GAUsage jA = new GAUsage();
  private SortedSet<Field> jx = new TreeSet();
  private StringBuilder jy = new StringBuilder();
  private boolean jz = false;
  
  public static GAUsage jU()
  {
    return jA;
  }
  
  public void a(Field paramField)
  {
    try
    {
      if (!this.jz)
      {
        this.jx.add(paramField);
        this.jy.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(paramField.ordinal()));
      }
      return;
    }
    finally
    {
      paramField = finally;
      throw paramField;
    }
  }
  
  public String jV()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      int j = 6;
      int i = 0;
      while (this.jx.size() > 0)
      {
        Field localField = (Field)this.jx.first();
        this.jx.remove(localField);
        int k = localField.ordinal();
        while (k >= j)
        {
          ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
          j += 6;
          i = 0;
        }
        i += (1 << localField.ordinal() % 6);
      }
      if ((i > 0) || (((StringBuilder)localObject1).length() == 0)) {
        ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
      }
      this.jx.clear();
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally {}
  }
  
  public String jW()
  {
    try
    {
      if (this.jy.length() > 0) {
        this.jy.insert(0, ".");
      }
      String str = this.jy.toString();
      this.jy = new StringBuilder();
      return str;
    }
    finally {}
  }
  
  public void o(boolean paramBoolean)
  {
    try
    {
      this.jz = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static enum Field
  {
    private Field() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/GAUsage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */