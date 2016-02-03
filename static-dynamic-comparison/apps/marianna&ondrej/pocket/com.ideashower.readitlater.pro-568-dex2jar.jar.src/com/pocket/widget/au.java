package com.pocket.widget;

import com.ideashower.readitlater.activity.f;
import java.util.ArrayList;
import java.util.Iterator;

public class au
{
  private final f a;
  private final DropDownMessageView b;
  private final ArrayList c = new ArrayList();
  
  public au(f paramf, int paramInt)
  {
    this.a = paramf;
    this.b = ((DropDownMessageView)paramf.c(paramInt));
  }
  
  public void a(int paramInt)
  {
    a(this.a.a(paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean, av paramav)
  {
    ValidatedEditText localValidatedEditText = (ValidatedEditText)this.a.c(paramInt);
    localValidatedEditText.setValidator(paramav);
    localValidatedEditText.setInstantValidationEnabled(paramBoolean);
    this.c.add(localValidatedEditText);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.b.a(paramCharSequence, true);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (((ValidatedEditText)localIterator.next()).a() == aw.b) {
        return false;
      }
    }
    return true;
  }
  
  public void b()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ValidatedEditText)localIterator.next()).b();
    }
    this.b.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */