package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.cc.a;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class cr
{
  public static cc.a d(cc.a parama)
  {
    cc.a locala = new cc.a();
    locala.type = parama.type;
    locala.FH = ((int[])parama.FH.clone());
    if (parama.FI) {
      locala.FI = parama.FI;
    }
    return locala;
  }
  
  public static class a
  {
    private final Map<String, cc.a> Xd;
    private final cc.a Xe;
    
    public void a(String paramString, cc.a parama)
    {
      this.Xd.put(paramString, parama);
    }
    
    public String toString()
    {
      return "Properties: " + wa() + " pushAfterEvaluate: " + this.Xe;
    }
    
    public Map<String, cc.a> wa()
    {
      return Collections.unmodifiableMap(this.Xd);
    }
    
    public cc.a wb()
    {
      return this.Xe;
    }
  }
  
  public static class b
  {
    private final List<cr.a> Xf;
    private final List<cr.a> Xg;
    private final List<cr.a> Xh;
    private final List<cr.a> Xi;
    private final List<cr.a> Xj;
    private final List<cr.a> Xk;
    private final List<String> Xl;
    private final List<String> Xm;
    
    public String toString()
    {
      return "Positive predicates: " + wc() + "  Negative predicates: " + wd() + "  Add tags: " + we() + "  Remove tags: " + wf() + "  Add macros: " + wg() + "  Remove macros: " + wj();
    }
    
    public List<cr.a> wc()
    {
      return this.Xf;
    }
    
    public List<cr.a> wd()
    {
      return this.Xg;
    }
    
    public List<cr.a> we()
    {
      return this.Xh;
    }
    
    public List<cr.a> wf()
    {
      return this.Xi;
    }
    
    public List<cr.a> wg()
    {
      return this.Xj;
    }
    
    public List<String> wh()
    {
      return this.Xl;
    }
    
    public List<String> wi()
    {
      return this.Xm;
    }
    
    public List<cr.a> wj()
    {
      return this.Xk;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */