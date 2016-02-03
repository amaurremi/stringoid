package android.support.v7.a;

import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.y;
import android.view.ActionMode;
import android.view.ActionMode.Callback;

class n
  extends m
  implements y
{
  final NativeActionModeAwareLayout b;
  private ActionMode c;
  
  public n(f paramf, b paramb)
  {
    super(paramf, paramb);
    this.b = ((NativeActionModeAwareLayout)paramf.findViewById(android.support.v7.b.f.action_bar_root));
    if (this.b != null) {
      this.b.setActionModeForChildListener(this);
    }
  }
  
  public ActionMode.Callback a(ActionMode.Callback paramCallback)
  {
    return new o(this, paramCallback);
  }
  
  boolean f()
  {
    return (this.c == null) && (super.f());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */