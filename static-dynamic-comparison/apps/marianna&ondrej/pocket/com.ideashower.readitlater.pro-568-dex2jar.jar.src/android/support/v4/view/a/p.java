package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class p
{
  public static Object a(q paramq)
  {
    new AccessibilityNodeProvider()
    {
      public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramAnonymousInt)
      {
        return (AccessibilityNodeInfo)p.this.a(paramAnonymousInt);
      }
      
      public List findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
      {
        return p.this.a(paramAnonymousString, paramAnonymousInt);
      }
      
      public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
      {
        return p.this.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */