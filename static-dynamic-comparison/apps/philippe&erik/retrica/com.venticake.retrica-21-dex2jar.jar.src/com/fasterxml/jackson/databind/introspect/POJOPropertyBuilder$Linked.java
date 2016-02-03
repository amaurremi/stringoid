package com.fasterxml.jackson.databind.introspect;

final class POJOPropertyBuilder$Linked<T>
{
  public final String explicitName;
  public final boolean isMarkedIgnored;
  public final boolean isVisible;
  public final Linked<T> next;
  public final T value;
  
  public POJOPropertyBuilder$Linked(T paramT, Linked<T> paramLinked, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.value = paramT;
    this.next = paramLinked;
    if (paramString == null) {}
    for (this.explicitName = null;; this.explicitName = paramT)
    {
      this.isVisible = paramBoolean1;
      this.isMarkedIgnored = paramBoolean2;
      return;
      paramT = paramString;
      if (paramString.length() == 0) {
        paramT = null;
      }
    }
  }
  
  private Linked<T> append(Linked<T> paramLinked)
  {
    if (this.next == null) {
      return withNext(paramLinked);
    }
    return withNext(this.next.append(paramLinked));
  }
  
  public String toString()
  {
    String str2 = this.value.toString() + "[visible=" + this.isVisible + "]";
    String str1 = str2;
    if (this.next != null) {
      str1 = str2 + ", " + this.next.toString();
    }
    return str1;
  }
  
  public Linked<T> trimByVisibility()
  {
    Object localObject;
    if (this.next == null) {
      localObject = this;
    }
    do
    {
      Linked localLinked;
      do
      {
        return (Linked<T>)localObject;
        localLinked = this.next.trimByVisibility();
        if (this.explicitName != null)
        {
          if (localLinked.explicitName == null) {
            return withNext(null);
          }
          return withNext(localLinked);
        }
        localObject = localLinked;
      } while (localLinked.explicitName != null);
      if (this.isVisible == localLinked.isVisible) {
        return withNext(localLinked);
      }
      localObject = localLinked;
    } while (!this.isVisible);
    return withNext(null);
  }
  
  public Linked<T> withNext(Linked<T> paramLinked)
  {
    if (paramLinked == this.next) {
      return this;
    }
    return new Linked(this.value, paramLinked, this.explicitName, this.isVisible, this.isMarkedIgnored);
  }
  
  public Linked<T> withValue(T paramT)
  {
    if (paramT == this.value) {
      return this;
    }
    return new Linked(paramT, this.next, this.explicitName, this.isVisible, this.isMarkedIgnored);
  }
  
  public Linked<T> withoutIgnored()
  {
    if (this.isMarkedIgnored)
    {
      if (this.next == null) {
        return null;
      }
      return this.next.withoutIgnored();
    }
    if (this.next != null)
    {
      Linked localLinked = this.next.withoutIgnored();
      if (localLinked != this.next) {
        return withNext(localLinked);
      }
    }
    return this;
  }
  
  public Linked<T> withoutNonVisible()
  {
    if (this.next == null) {}
    for (Linked localLinked1 = null;; localLinked1 = this.next.withoutNonVisible())
    {
      Linked localLinked2 = localLinked1;
      if (this.isVisible) {
        localLinked2 = withNext(localLinked1);
      }
      return localLinked2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */