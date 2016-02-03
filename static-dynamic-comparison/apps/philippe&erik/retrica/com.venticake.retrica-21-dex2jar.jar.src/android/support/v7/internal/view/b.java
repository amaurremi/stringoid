package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.c.a;
import android.view.ActionMode;
import android.view.MenuInflater;

public class b
  extends a
{
  final MenuInflater a;
  final ActionMode b;
  
  public b(Context paramContext, ActionMode paramActionMode)
  {
    this.b = paramActionMode;
    this.a = new c(paramContext);
  }
  
  public void a()
  {
    this.b.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */