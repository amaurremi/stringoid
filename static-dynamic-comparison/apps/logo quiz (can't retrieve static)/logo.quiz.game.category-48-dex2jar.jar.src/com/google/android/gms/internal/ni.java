package com.google.android.gms.internal;

import com.google.android.gms.common.internal.n;
import java.util.ArrayList;

public class ni
{
  private int akA;
  private final ArrayList<a> akz = new ArrayList();
  
  public ni()
  {
    this(100);
  }
  
  public ni(int paramInt)
  {
    this.akA = paramInt;
  }
  
  private void mV()
  {
    while (getSize() > getCapacity()) {
      this.akz.remove(0);
    }
  }
  
  public void a(nl paramnl, nh paramnh)
  {
    this.akz.add(new a(paramnl, paramnh, null));
    mV();
  }
  
  public void clear()
  {
    this.akz.clear();
  }
  
  public int getCapacity()
  {
    return this.akA;
  }
  
  public int getSize()
  {
    return this.akz.size();
  }
  
  public boolean isEmpty()
  {
    return this.akz.isEmpty();
  }
  
  public ArrayList<a> mU()
  {
    return this.akz;
  }
  
  public static class a
  {
    public final nl akB;
    public final nh akC;
    public final pq.c akD;
    
    private a(nl paramnl, nh paramnh)
    {
      this.akB = ((nl)n.i(paramnl));
      this.akC = ((nh)n.i(paramnh));
      this.akD = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */