package com.google.android.gms.drive.query;

import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class b
{
  public static <T> a a(com.google.android.gms.drive.metadata.a<T> parama, T paramT)
  {
    return new InFilter(parama, paramT);
  }
  
  public static <T> a c(com.google.android.gms.drive.metadata.b<T> paramb, T paramT)
  {
    return new ComparisonFilter(Operator.uD, paramb, paramT);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/query/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */