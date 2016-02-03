package com.jirbo.adcolony;

import java.io.PrintStream;

public class ADCData
{
  static ADCData.i a = new ADCData.h();
  static ADCData.i b = new ADCData.a();
  static ADCData.i c = new ADCData.d();
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println("==== ADCData Test ====");
    paramArrayOfString = new ADCData.g();
    paramArrayOfString.b("one", 1);
    paramArrayOfString.b("pi", 3.14D);
    paramArrayOfString.b("name", "\"Abe Pralle\"");
    paramArrayOfString.a("list", new ADCData.c());
    paramArrayOfString.a("subtable", new ADCData.g());
    paramArrayOfString.b("subtable").b("five", 5);
    System.out.println("LIST:" + paramArrayOfString.c("list"));
    paramArrayOfString.c("list").a(3);
    System.out.println(paramArrayOfString);
    System.out.println(paramArrayOfString.g("one"));
    System.out.println(paramArrayOfString.f("one"));
    System.out.println(paramArrayOfString.g("pi"));
    System.out.println(paramArrayOfString.f("pi"));
    System.out.println(paramArrayOfString.e("name"));
    System.out.println(paramArrayOfString.f("name"));
    System.out.println(paramArrayOfString.g("name"));
    System.out.println(paramArrayOfString.c("list"));
    System.out.println(paramArrayOfString.c("list2"));
    System.out.println(paramArrayOfString.c("subtable"));
    System.out.println(paramArrayOfString.b("subtable"));
    System.out.println(paramArrayOfString.b("subtable2"));
    System.out.println(paramArrayOfString.b("list"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */