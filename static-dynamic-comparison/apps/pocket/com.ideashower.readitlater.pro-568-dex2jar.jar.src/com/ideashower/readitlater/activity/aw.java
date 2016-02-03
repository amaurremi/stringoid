package com.ideashower.readitlater.activity;

import android.util.SparseArray;
import com.ideashower.readitlater.e.b;

public class aw
{
  private final String b;
  private final SparseArray c;
  
  public aw(ReaderFragment paramReaderFragment, SparseArray paramSparseArray)
  {
    this.c = paramSparseArray;
    this.b = null;
  }
  
  public aw(ReaderFragment paramReaderFragment, b paramb)
  {
    this.c = new SparseArray();
    this.c.put(paramb.b(), paramb);
    this.b = null;
  }
  
  public SparseArray a()
  {
    return this.c;
  }
  
  public boolean a(String paramString)
  {
    int j = this.c.size();
    int i = 0;
    for (;;)
    {
      if ((i >= j) || (paramString.equals(((b)this.c.valueAt(i)).c()))) {
        return true;
      }
      i += 1;
    }
  }
  
  public boolean b()
  {
    return ((b)this.c.valueAt(0)).j();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */