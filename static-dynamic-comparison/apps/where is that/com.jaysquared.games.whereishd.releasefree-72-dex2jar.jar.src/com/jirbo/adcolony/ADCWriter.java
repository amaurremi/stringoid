package com.jirbo.adcolony;

import java.io.PrintStream;

abstract class ADCWriter
{
  boolean beginning_of_line = true;
  int indent = 0;
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println("Test...");
  }
  
  void indent_if_necessary()
  {
    if (this.beginning_of_line)
    {
      this.beginning_of_line = false;
      int i = this.indent;
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          break;
        }
        write(' ');
      }
    }
  }
  
  void print(char paramChar)
  {
    if (this.beginning_of_line) {
      indent_if_necessary();
    }
    write(paramChar);
    if (paramChar == '\n') {
      this.beginning_of_line = true;
    }
  }
  
  void print(double paramDouble)
  {
    if (this.beginning_of_line) {
      indent_if_necessary();
    }
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      print("0.0");
    }
    long l2;
    long l3;
    for (;;)
    {
      return;
      double d = paramDouble;
      if (paramDouble < 0.0D)
      {
        d = -paramDouble;
        write('-');
      }
      if (4 == 0)
      {
        print(Math.round(d));
        return;
      }
      l2 = Math.pow(10.0D, 4);
      l1 = Math.round(l2 * d);
      print(l1 / l2);
      write('.');
      l3 = l1 % l2;
      if (l3 != 0L) {
        break;
      }
      int i = 0;
      while (i < 4)
      {
        write('0');
        i += 1;
      }
    }
    for (long l1 = l3 * 10L; l1 < l2; l1 *= 10L) {
      write('0');
    }
    print(l3);
  }
  
  void print(long paramLong)
  {
    if (this.beginning_of_line) {
      indent_if_necessary();
    }
    if (paramLong == 0L)
    {
      write('0');
      return;
    }
    if (paramLong == -paramLong)
    {
      print("-9223372036854775808");
      return;
    }
    if (paramLong < 0L)
    {
      write('-');
      print(-paramLong);
      return;
    }
    print_recursive(paramLong);
  }
  
  void print(Object paramObject)
  {
    if (this.beginning_of_line) {
      indent_if_necessary();
    }
    if (paramObject == null)
    {
      print("null");
      return;
    }
    print(paramObject.toString());
  }
  
  void print(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      print(paramString.charAt(i));
      i += 1;
    }
  }
  
  void print(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      print("true");
      return;
    }
    print("false");
  }
  
  void print_recursive(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    print_recursive(paramLong / 10L);
    write((char)(int)(48L + paramLong % 10L));
  }
  
  void println()
  {
    print('\n');
  }
  
  void println(char paramChar)
  {
    print(paramChar);
    print('\n');
  }
  
  void println(double paramDouble)
  {
    print(paramDouble);
    print('\n');
  }
  
  void println(long paramLong)
  {
    print(paramLong);
    print('\n');
  }
  
  void println(Object paramObject)
  {
    print(paramObject);
    print('\n');
  }
  
  void println(String paramString)
  {
    print(paramString);
    print('\n');
  }
  
  void println(boolean paramBoolean)
  {
    print(paramBoolean);
    print('\n');
  }
  
  abstract void write(char paramChar);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */