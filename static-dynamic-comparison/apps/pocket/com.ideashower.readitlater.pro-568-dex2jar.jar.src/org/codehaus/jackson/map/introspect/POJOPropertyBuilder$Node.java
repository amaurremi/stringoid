package org.codehaus.jackson.map.introspect;

final class POJOPropertyBuilder$Node
{
  public final String explicitName;
  public final boolean isMarkedIgnored;
  public final boolean isVisible;
  public final Node next;
  public final Object value;
  
  public POJOPropertyBuilder$Node(Object paramObject, Node paramNode, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.value = paramObject;
    this.next = paramNode;
    if (paramString == null) {}
    for (this.explicitName = null;; this.explicitName = ((String)paramObject))
    {
      this.isVisible = paramBoolean1;
      this.isMarkedIgnored = paramBoolean2;
      return;
      paramObject = paramString;
      if (paramString.length() == 0) {
        paramObject = null;
      }
    }
  }
  
  private Node append(Node paramNode)
  {
    if (this.next == null) {
      return withNext(paramNode);
    }
    return withNext(this.next.append(paramNode));
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
  
  public Node trimByVisibility()
  {
    Object localObject;
    if (this.next == null) {
      localObject = this;
    }
    do
    {
      Node localNode;
      do
      {
        return (Node)localObject;
        localNode = this.next.trimByVisibility();
        if (this.explicitName != null)
        {
          if (localNode.explicitName == null) {
            return withNext(null);
          }
          return withNext(localNode);
        }
        localObject = localNode;
      } while (localNode.explicitName != null);
      if (this.isVisible == localNode.isVisible) {
        return withNext(localNode);
      }
      localObject = localNode;
    } while (!this.isVisible);
    return withNext(null);
  }
  
  public Node withNext(Node paramNode)
  {
    if (paramNode == this.next) {
      return this;
    }
    return new Node(this.value, paramNode, this.explicitName, this.isVisible, this.isMarkedIgnored);
  }
  
  public Node withValue(Object paramObject)
  {
    if (paramObject == this.value) {
      return this;
    }
    return new Node(paramObject, this.next, this.explicitName, this.isVisible, this.isMarkedIgnored);
  }
  
  public Node withoutIgnored()
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
      Node localNode = this.next.withoutIgnored();
      if (localNode != this.next) {
        return withNext(localNode);
      }
    }
    return this;
  }
  
  public Node withoutNonVisible()
  {
    if (this.next == null) {}
    for (Node localNode1 = null;; localNode1 = this.next.withoutNonVisible())
    {
      Node localNode2 = localNode1;
      if (this.isVisible) {
        localNode2 = withNext(localNode1);
      }
      return localNode2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/POJOPropertyBuilder$Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */