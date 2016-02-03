package com.jirbo.adcolony;

import java.io.PrintStream;

class ADCStringBuilder
  extends ADCWriter
{
  StringBuilder buffer = new StringBuilder();
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new ADCStringBuilder();
    paramArrayOfString.println("A king who was mad at the time");
    paramArrayOfString.println("Declared limerick writing a crime");
    paramArrayOfString.indent += 2;
    paramArrayOfString.println("So late in the night");
    paramArrayOfString.println("All the poets would write");
    paramArrayOfString.indent -= 2;
    paramArrayOfString.println("Verses without any rhyme or meter");
    paramArrayOfString.println();
    paramArrayOfString.indent += 4;
    paramArrayOfString.println("David\nGerrold");
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(4.0D);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(0.0D);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(-100023.0D);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(-6L);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(0L);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(234L);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(Long.MIN_VALUE);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(true);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(false);
    paramArrayOfString.indent += 2;
    System.out.println(paramArrayOfString);
  }
  
  void clear()
  {
    this.buffer.setLength(0);
    this.indent = 0;
  }
  
  public String toString()
  {
    return this.buffer.toString();
  }
  
  void write(char paramChar)
  {
    this.buffer.append(paramChar);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCStringBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */