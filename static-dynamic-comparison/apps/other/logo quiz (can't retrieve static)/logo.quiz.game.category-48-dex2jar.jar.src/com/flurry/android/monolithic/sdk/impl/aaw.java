package com.flurry.android.monolithic.sdk.impl;

public class aaw
  extends zf
{
  public aaw(zf paramzf)
  {
    super(paramzf);
  }
  
  public aaw(zf paramzf, ra<Object> paramra)
  {
    super(paramzf, paramra);
  }
  
  protected ra<Object> a(aal paramaal, Class<?> paramClass, ru paramru)
    throws qw
  {
    if (this.o != null) {}
    for (paramaal = paramru.a(paramru.a(this.o, paramClass), this);; paramaal = paramru.a(paramClass, this))
    {
      paramru = paramaal;
      if (!paramaal.b()) {
        paramru = paramaal.a();
      }
      this.j = this.j.a(paramClass, paramru);
      return paramru;
    }
  }
  
  public zf a(ra<Object> paramra)
  {
    if (getClass() != aaw.class) {
      throw new IllegalStateException("UnwrappingBeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
    }
    Object localObject = paramra;
    if (!paramra.b()) {
      localObject = paramra.a();
    }
    return new aaw(this, (ra)localObject);
  }
  
  public void a(Object paramObject, or paramor, ru paramru)
    throws Exception
  {
    Object localObject = a(paramObject);
    if (localObject == null) {}
    do
    {
      return;
      if (localObject == paramObject) {
        b(paramObject);
      }
    } while ((this.l != null) && (this.l.equals(localObject)));
    ra localra = this.i;
    paramObject = localra;
    if (localra == null)
    {
      Class localClass = localObject.getClass();
      aal localaal = this.j;
      localra = localaal.a(localClass);
      paramObject = localra;
      if (localra == null) {
        paramObject = a(localaal, localClass, paramru);
      }
    }
    if (!((ra)paramObject).b()) {
      paramor.a(this.g);
    }
    if (this.n == null)
    {
      ((ra)paramObject).a(localObject, paramor, paramru);
      return;
    }
    ((ra)paramObject).a(localObject, paramor, paramru, this.n);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */