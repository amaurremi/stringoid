package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$5
{
  FieldNamingPolicy$5()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return FieldNamingPolicy.access$200(paramField.getName(), "-").toLowerCase();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/FieldNamingPolicy$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */