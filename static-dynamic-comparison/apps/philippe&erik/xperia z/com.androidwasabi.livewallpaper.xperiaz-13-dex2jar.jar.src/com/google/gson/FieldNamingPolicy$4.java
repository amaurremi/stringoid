package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$4
{
  FieldNamingPolicy$4()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return FieldNamingPolicy.access$200(paramField.getName(), "_").toLowerCase();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/FieldNamingPolicy$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */