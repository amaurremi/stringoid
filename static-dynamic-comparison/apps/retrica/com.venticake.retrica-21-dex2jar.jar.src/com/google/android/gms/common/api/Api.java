package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends Api.ApiOptions>
{
  private final Api.b<?, O> Dm;
  private final Api.c<?> Dn;
  private final ArrayList<Scope> Do;
  
  public <C extends Api.a> Api(Api.b<C, O> paramb, Api.c<C> paramc, Scope... paramVarArgs)
  {
    this.Dm = paramb;
    this.Dn = paramc;
    this.Do = new ArrayList(Arrays.asList(paramVarArgs));
  }
  
  public List<Scope> eA()
  {
    return this.Do;
  }
  
  public Api.c<?> eB()
  {
    return this.Dn;
  }
  
  public Api.b<?, O> ez()
  {
    return this.Dm;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */