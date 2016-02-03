package com.google.android.gms.plus;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import java.util.HashSet;
import java.util.Set;

public final class Plus$PlusOptions
  implements Api.ApiOptions.Optional
{
  final String abr;
  final Set<String> abs;
  
  private Plus$PlusOptions()
  {
    this.abr = null;
    this.abs = new HashSet();
  }
  
  private Plus$PlusOptions(Plus.PlusOptions.Builder paramBuilder)
  {
    this.abr = paramBuilder.abr;
    this.abs = paramBuilder.abs;
  }
  
  public static Plus.PlusOptions.Builder builder()
  {
    return new Plus.PlusOptions.Builder();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/Plus$PlusOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */