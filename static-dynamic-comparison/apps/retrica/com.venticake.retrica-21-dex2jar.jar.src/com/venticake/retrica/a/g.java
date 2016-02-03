package com.venticake.retrica.a;

import com.amazon.inapp.purchasing.Receipt;
import java.util.Set;

public class g
{
  private final String a;
  private final Set<Receipt> b;
  private final Set<String> c;
  
  public g(String paramString, Set<Receipt> paramSet, Set<String> paramSet1)
  {
    this.a = paramString;
    this.b = paramSet;
    this.c = paramSet1;
  }
  
  public Set<Receipt> a()
  {
    return this.b;
  }
  
  public Set<String> b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "PurchaseUpdatesData [userId=" + this.a + ", receipts=" + this.b + ", revokedSkus=" + this.c + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */