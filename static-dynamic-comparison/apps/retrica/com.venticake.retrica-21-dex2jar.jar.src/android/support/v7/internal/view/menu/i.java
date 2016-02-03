package android.support.v7.internal.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import android.widget.LinearLayout.LayoutParams;

public class i
  extends LinearLayout.LayoutParams
{
  @ViewDebug.ExportedProperty
  public boolean a;
  @ViewDebug.ExportedProperty
  public int b;
  @ViewDebug.ExportedProperty
  public int c;
  @ViewDebug.ExportedProperty
  public boolean d;
  @ViewDebug.ExportedProperty
  public boolean e;
  public boolean f;
  
  public i(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.a = false;
  }
  
  public i(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public i(i parami)
  {
    super(parami);
    this.a = parami.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */