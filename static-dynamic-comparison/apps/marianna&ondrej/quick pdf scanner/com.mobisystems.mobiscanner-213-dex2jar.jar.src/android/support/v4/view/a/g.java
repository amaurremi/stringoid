package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class g
{
  public static Object a(a parama)
  {
    new AccessibilityNodeProvider()
    {
      public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramAnonymousInt)
      {
        return (AccessibilityNodeInfo)this.cV.s(paramAnonymousInt);
      }
      
      public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
      {
        return this.cV.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
      }
      
      public AccessibilityNodeInfo findFocus(int paramAnonymousInt)
      {
        return (AccessibilityNodeInfo)this.cV.t(paramAnonymousInt);
      }
      
      public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
      {
        return this.cV.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    };
  }
  
  static abstract interface a
  {
    public abstract List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt);
    
    public abstract boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle);
    
    public abstract Object s(int paramInt);
    
    public abstract Object t(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */