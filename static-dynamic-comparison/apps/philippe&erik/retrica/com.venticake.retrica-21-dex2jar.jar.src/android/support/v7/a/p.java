package android.support.v7.a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarImplICS.OnMenuVisibilityListenerWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class p
  extends a
{
  final Activity a;
  final b b;
  final ActionBar c;
  private ArrayList<WeakReference<ActionBarImplICS.OnMenuVisibilityListenerWrapper>> d = new ArrayList();
  
  public p(Activity paramActivity, b paramb)
  {
    this(paramActivity, paramb, true);
  }
  
  p(Activity paramActivity, b paramb, boolean paramBoolean)
  {
    this.a = paramActivity;
    this.b = paramb;
    this.c = paramActivity.getActionBar();
    if ((paramBoolean) && ((a() & 0x4) != 0)) {
      b(true);
    }
  }
  
  public int a()
  {
    return this.c.getDisplayOptions();
  }
  
  public void a(int paramInt)
  {
    this.c.setIcon(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.setDisplayHomeAsUpEnabled(paramBoolean);
  }
  
  public Context b()
  {
    return this.c.getThemedContext();
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.setHomeButtonEnabled(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */