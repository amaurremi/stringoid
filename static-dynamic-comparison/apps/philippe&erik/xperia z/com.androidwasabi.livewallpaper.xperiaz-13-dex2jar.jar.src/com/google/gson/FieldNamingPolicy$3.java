package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$3
{
  FieldNamingPolicy$3()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return FieldNamingPolicy.access$100(FieldNamingPolicy.access$200(paramField.getName(), " "));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/FieldNamingPolicy$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */