package com.venticake.retrica.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.amazon.inapp.purchasing.Offset;
import com.amazon.inapp.purchasing.PurchaseResponse;
import com.amazon.inapp.purchasing.Receipt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class d
{
  private Activity a;
  private String b;
  private SharedPreferences c;
  
  public d(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  private String a(Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramSet = paramSet.iterator();
    for (;;)
    {
      if (!paramSet.hasNext()) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append((String)paramSet.next());
      if (paramSet.hasNext()) {
        localStringBuilder.append("|");
      }
    }
  }
  
  private void c()
  {
    this.c = null;
  }
  
  private SharedPreferences d()
  {
    if (this.c != null) {
      return this.c;
    }
    this.c = this.a.getSharedPreferences(this.b, 0);
    return this.c;
  }
  
  private void s(String paramString)
  {
    Set localSet = p("REQUEST_IDS");
    localSet.add(paramString);
    b("REQUEST_IDS", localSet);
  }
  
  private void t(String paramString)
  {
    Set localSet = p("REQUEST_IDS");
    localSet.remove(paramString);
    b("REQUEST_IDS", localSet);
  }
  
  private boolean u(String paramString)
  {
    return j(paramString) != null;
  }
  
  private Set<String> v(String paramString)
  {
    HashSet localHashSet = new HashSet();
    if ((paramString == null) || ("".equals(paramString))) {}
    for (;;)
    {
      return localHashSet;
      paramString = new StringTokenizer(paramString, "|");
      while (paramString.hasMoreTokens()) {
        localHashSet.add(paramString.nextToken());
      }
    }
  }
  
  public b a(PurchaseResponse paramPurchaseResponse)
  {
    Object localObject1 = paramPurchaseResponse.getRequestId();
    String str = paramPurchaseResponse.getUserId();
    Object localObject2 = paramPurchaseResponse.getReceipt();
    if (!u((String)localObject1))
    {
      Log.i("amazon_iap", "savePurchaseReceipt: requestId (" + (String)localObject1 + ") does NOT match any requestId sent before!");
      return null;
    }
    paramPurchaseResponse = ((Receipt)localObject2).getPurchaseToken();
    localObject2 = ((Receipt)localObject2).getSku();
    localObject1 = j((String)localObject1);
    ((b)localObject1).a(str);
    ((b)localObject1).a(h.c);
    ((b)localObject1).b(paramPurchaseResponse);
    ((b)localObject1).c((String)localObject2);
    Log.d("amazon_iap", "savePurchaseResponse: saving purchaseToken (" + paramPurchaseResponse + ") sku (" + (String)localObject2 + ") and request state as (" + ((b)localObject1).c() + ")");
    a((b)localObject1);
    c((String)localObject2);
    return (b)localObject1;
  }
  
  public Set<String> a()
  {
    return p("REQUEST_IDS");
  }
  
  protected Set<String> a(String paramString, Set<String> paramSet)
  {
    this.c = d();
    return v(q(paramString));
  }
  
  public void a(Offset paramOffset)
  {
    a("PURCHASE_UPDATES_OFFSET", paramOffset.toString());
  }
  
  public void a(b paramb)
  {
    String str = c.a(paramb);
    Log.d("amazon_iap", "savePurchaseData: saving for requestId (" + paramb.a() + ") json: " + str);
    a(paramb.a(), str);
    paramb = paramb.e();
    if (paramb != null)
    {
      Log.d("amazon_iap", "savePurchaseData: saving for purchaseToken (" + paramb + ") json: " + str);
      a(paramb, str);
    }
  }
  
  public void a(i parami)
  {
    String str = j.a(parami);
    Log.d("amazon_iap", "saveSKUData: saving for sku (" + parami.c() + ") json: " + str);
    a(parami.c(), str);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.c = d();
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    if (this.b == null) {}
    for (;;)
    {
      this.b = paramString;
      Log.d("amazon_iap", "saveCurrentUser: " + paramString);
      c();
      return bool;
      if (this.b.equals(paramString)) {
        bool = false;
      }
    }
  }
  
  public Offset b()
  {
    String str = q("PURCHASE_UPDATES_OFFSET");
    if (str == null)
    {
      Log.i("amazon_iap", "getPurchaseUpdatesOffset: no previous offset saved, use Offset.BEGINNING");
      return Offset.BEGINNING;
    }
    return Offset.fromString(str);
  }
  
  protected String b(String paramString1, String paramString2)
  {
    this.c = d();
    return this.c.getString(paramString1, paramString2);
  }
  
  protected void b(String paramString, Set<String> paramSet)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putString(paramString, a(paramSet));
    localEditor.apply();
  }
  
  public boolean b(String paramString)
  {
    return this.b.equals(paramString);
  }
  
  public void c(String paramString)
  {
    i locali = n(paramString);
    locali.a();
    Log.i("amazon_iap", "skuFulfilledCountUp: fulfilledCountUp to (" + locali.d() + ") for sku (" + paramString + "), save SKU data");
    a(locali);
  }
  
  protected void d(String paramString)
  {
    i locali = m(paramString);
    if (locali == null) {
      return;
    }
    locali.b();
    Log.i("amazon_iap", "skuFulfilledCountDown: fulfilledCountDown to (" + locali.d() + ") for revoked sku (" + paramString + "), save SKU data");
    a(locali);
  }
  
  public boolean e(String paramString)
  {
    paramString = m(paramString);
    if (paramString == null) {}
    while (paramString.d() <= 0) {
      return false;
    }
    return true;
  }
  
  public void f(String paramString)
  {
    b localb = j(paramString);
    localb.a(h.d);
    a(localb);
    Log.i("amazon_iap", "setRequestStateFulfilled: requestId (" + paramString + ") setting requestState to (" + localb.c() + ")");
  }
  
  public boolean g(String paramString)
  {
    paramString = j(paramString);
    if (paramString == null) {}
    while (h.b != paramString.c()) {
      return false;
    }
    return true;
  }
  
  public void h(String paramString)
  {
    b localb = k(paramString);
    localb.g();
    Log.i("amazon_iap", "setPurchaseTokenFulfilled: set purchaseToken (" + paramString + ") as fulfilled");
    a(localb);
  }
  
  public b i(String paramString)
  {
    s(paramString);
    b localb = new b(paramString);
    localb.a(h.b);
    a(localb);
    Log.d("amazon_iap", "newPurchaseData: adding requestId (" + paramString + ") to saved list and setting request state to (" + localb.c() + ")");
    return localb;
  }
  
  public b j(String paramString)
  {
    paramString = q(paramString);
    if (paramString == null) {
      return null;
    }
    return c.a(paramString);
  }
  
  public b k(String paramString)
  {
    paramString = q(paramString);
    if (paramString == null) {
      return null;
    }
    return c.a(paramString);
  }
  
  public i l(String paramString)
  {
    Log.d("amazon_iap", "newSKUData: creating new SKUData for sku (" + paramString + ")");
    return new i(paramString);
  }
  
  public i m(String paramString)
  {
    paramString = q(paramString);
    if (paramString == null) {
      return null;
    }
    return j.a(paramString);
  }
  
  public i n(String paramString)
  {
    i locali2 = m(paramString);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = l(paramString);
    }
    return locali1;
  }
  
  public void o(String paramString)
  {
    r(paramString);
    t(paramString);
  }
  
  protected Set<String> p(String paramString)
  {
    return a(paramString, new HashSet());
  }
  
  protected String q(String paramString)
  {
    return b(paramString, null);
  }
  
  protected void r(String paramString)
  {
    this.c = d();
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */