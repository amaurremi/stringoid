package com.google.tagmanager;

class TypeOrFailure<T>
{
  private LoadCallback.Failure mFailure;
  private T mType;
  
  public TypeOrFailure(LoadCallback.Failure paramFailure)
  {
    this.mFailure = paramFailure;
  }
  
  public TypeOrFailure(T paramT)
  {
    this.mType = paramT;
  }
  
  public LoadCallback.Failure getFailure()
  {
    return this.mFailure;
  }
  
  public T getType()
  {
    return (T)this.mType;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/TypeOrFailure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */