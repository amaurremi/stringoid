package com.pocket.o.a;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import com.ideashower.readitlater.a.au;
import java.util.ArrayList;

public abstract class i
  implements au
{
  private final l a;
  private final k b;
  private final Context c;
  private boolean d;
  
  public i(l paraml, k paramk, Context paramContext)
  {
    this.a = paraml;
    this.b = paramk;
    this.c = paramContext;
  }
  
  public abstract ListAdapter a();
  
  public abstract void a(j paramj);
  
  public abstract void a(CharSequence paramCharSequence);
  
  public abstract void a(String paramString);
  
  protected void a(ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    this.b.a(this, paramBoolean);
  }
  
  public abstract View b();
  
  public abstract void b(String paramString);
  
  protected l f()
  {
    return this.a;
  }
  
  protected Context g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */