package org.jsoup.nodes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public abstract class Node
  implements Cloneable
{
  Attributes attributes;
  String baseUri;
  List childNodes;
  Node parentNode;
  int siblingIndex;
  
  protected Node()
  {
    this.childNodes = Collections.emptyList();
    this.attributes = null;
  }
  
  protected Node(String paramString)
  {
    this(paramString, new Attributes());
  }
  
  protected Node(String paramString, Attributes paramAttributes)
  {
    Validate.notNull(paramString);
    Validate.notNull(paramAttributes);
    this.childNodes = new ArrayList(4);
    this.baseUri = paramString.trim();
    this.attributes = paramAttributes;
  }
  
  private void addSiblingHtml(int paramInt, String paramString)
  {
    Validate.notNull(paramString);
    Validate.notNull(this.parentNode);
    if ((parent() instanceof Element)) {}
    for (Element localElement = (Element)parent();; localElement = null)
    {
      paramString = Parser.parseFragment(paramString, localElement, baseUri());
      this.parentNode.addChildren(paramInt, (Node[])paramString.toArray(new Node[paramString.size()]));
      return;
    }
  }
  
  private Element getDeepChild(Element paramElement)
  {
    Elements localElements = paramElement.children();
    if (localElements.size() > 0) {
      paramElement = getDeepChild((Element)localElements.get(0));
    }
    return paramElement;
  }
  
  private Document.OutputSettings getOutputSettings()
  {
    if (ownerDocument() != null) {
      return ownerDocument().outputSettings();
    }
    return new Document("").outputSettings();
  }
  
  private void reindexChildren()
  {
    int i = 0;
    while (i < this.childNodes.size())
    {
      ((Node)this.childNodes.get(i)).setSiblingIndex(i);
      i += 1;
    }
  }
  
  private void reparentChild(Node paramNode)
  {
    if (paramNode.parentNode != null) {
      paramNode.parentNode.removeChild(paramNode);
    }
    paramNode.setParentNode(this);
  }
  
  public String absUrl(String paramString)
  {
    Validate.notEmpty(paramString);
    String str = attr(paramString);
    if (!hasAttr(paramString)) {
      return "";
    }
    try
    {
      URL localURL = new URL(this.baseUri);
      paramString = str;
      return "";
    }
    catch (MalformedURLException paramString)
    {
      try
      {
        if (str.startsWith("?")) {
          paramString = localURL.getPath() + str;
        }
        return new URL(localURL, paramString).toExternalForm();
      }
      catch (MalformedURLException paramString) {}
      paramString = paramString;
      paramString = new URL(str).toExternalForm();
      return paramString;
    }
  }
  
  protected void addChildren(int paramInt, Node... paramVarArgs)
  {
    Validate.noNullElements(paramVarArgs);
    int i = paramVarArgs.length - 1;
    while (i >= 0)
    {
      Node localNode = paramVarArgs[i];
      reparentChild(localNode);
      this.childNodes.add(paramInt, localNode);
      i -= 1;
    }
    reindexChildren();
  }
  
  protected void addChildren(Node... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Node localNode = paramVarArgs[i];
      reparentChild(localNode);
      this.childNodes.add(localNode);
      localNode.setSiblingIndex(this.childNodes.size() - 1);
      i += 1;
    }
  }
  
  public Node after(String paramString)
  {
    addSiblingHtml(siblingIndex() + 1, paramString);
    return this;
  }
  
  public Node after(Node paramNode)
  {
    Validate.notNull(paramNode);
    Validate.notNull(this.parentNode);
    this.parentNode.addChildren(siblingIndex() + 1, new Node[] { paramNode });
    return this;
  }
  
  public String attr(String paramString)
  {
    Validate.notNull(paramString);
    if (this.attributes.hasKey(paramString)) {
      return this.attributes.get(paramString);
    }
    if (paramString.toLowerCase().startsWith("abs:")) {
      return absUrl(paramString.substring("abs:".length()));
    }
    return "";
  }
  
  public Node attr(String paramString1, String paramString2)
  {
    this.attributes.put(paramString1, paramString2);
    return this;
  }
  
  public Attributes attributes()
  {
    return this.attributes;
  }
  
  public String baseUri()
  {
    return this.baseUri;
  }
  
  public Node before(String paramString)
  {
    addSiblingHtml(siblingIndex(), paramString);
    return this;
  }
  
  public Node before(Node paramNode)
  {
    Validate.notNull(paramNode);
    Validate.notNull(this.parentNode);
    this.parentNode.addChildren(siblingIndex(), new Node[] { paramNode });
    return this;
  }
  
  public Node childNode(int paramInt)
  {
    return (Node)this.childNodes.get(paramInt);
  }
  
  public final int childNodeSize()
  {
    return this.childNodes.size();
  }
  
  public List childNodes()
  {
    return Collections.unmodifiableList(this.childNodes);
  }
  
  protected Node[] childNodesAsArray()
  {
    return (Node[])this.childNodes.toArray(new Node[childNodeSize()]);
  }
  
  public List childNodesCopy()
  {
    ArrayList localArrayList = new ArrayList(this.childNodes.size());
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Node)localIterator.next()).clone());
    }
    return localArrayList;
  }
  
  public Node clone()
  {
    return doClone(null);
  }
  
  protected Node doClone(Node paramNode)
  {
    Node localNode1;
    for (;;)
    {
      try
      {
        localNode1 = (Node)super.clone();
        localNode1.parentNode = paramNode;
        if (paramNode == null)
        {
          i = 0;
          localNode1.siblingIndex = i;
          if (this.attributes == null) {
            break label139;
          }
          paramNode = this.attributes.clone();
          localNode1.attributes = paramNode;
          localNode1.baseUri = this.baseUri;
          localNode1.childNodes = new ArrayList(this.childNodes.size());
          paramNode = this.childNodes.iterator();
          if (!paramNode.hasNext()) {
            break;
          }
          Node localNode2 = (Node)paramNode.next();
          localNode1.childNodes.add(localNode2.doClone(localNode1));
          continue;
        }
        int i = this.siblingIndex;
      }
      catch (CloneNotSupportedException paramNode)
      {
        throw new RuntimeException(paramNode);
      }
      continue;
      label139:
      paramNode = null;
    }
    return localNode1;
  }
  
  public boolean equals(Object paramObject)
  {
    return this == paramObject;
  }
  
  public boolean hasAttr(String paramString)
  {
    Validate.notNull(paramString);
    if (paramString.toLowerCase().startsWith("abs:"))
    {
      String str = paramString.substring("abs:".length());
      if ((this.attributes.hasKey(str)) && (!absUrl(str).equals(""))) {
        return true;
      }
    }
    return this.attributes.hasKey(paramString);
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.parentNode != null) {}
    for (int i = this.parentNode.hashCode();; i = 0)
    {
      if (this.attributes != null) {
        j = this.attributes.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  protected void indent(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    paramStringBuilder.append("\n").append(StringUtil.padding(paramOutputSettings.indentAmount() * paramInt));
  }
  
  public Node nextSibling()
  {
    if (this.parentNode == null) {}
    List localList;
    Integer localInteger;
    do
    {
      return null;
      localList = this.parentNode.childNodes;
      localInteger = Integer.valueOf(siblingIndex());
      Validate.notNull(localInteger);
    } while (localList.size() <= localInteger.intValue() + 1);
    return (Node)localList.get(localInteger.intValue() + 1);
  }
  
  public abstract String nodeName();
  
  public String outerHtml()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    outerHtml(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  protected void outerHtml(StringBuilder paramStringBuilder)
  {
    new NodeTraversor(new Node.OuterHtmlVisitor(paramStringBuilder, getOutputSettings())).traverse(this);
  }
  
  abstract void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings);
  
  abstract void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings);
  
  public Document ownerDocument()
  {
    if ((this instanceof Document)) {
      return (Document)this;
    }
    if (this.parentNode == null) {
      return null;
    }
    return this.parentNode.ownerDocument();
  }
  
  public Node parent()
  {
    return this.parentNode;
  }
  
  public Node previousSibling()
  {
    if (this.parentNode == null) {}
    List localList;
    Integer localInteger;
    do
    {
      return null;
      localList = this.parentNode.childNodes;
      localInteger = Integer.valueOf(siblingIndex());
      Validate.notNull(localInteger);
    } while (localInteger.intValue() <= 0);
    return (Node)localList.get(localInteger.intValue() - 1);
  }
  
  public void remove()
  {
    Validate.notNull(this.parentNode);
    this.parentNode.removeChild(this);
  }
  
  public Node removeAttr(String paramString)
  {
    Validate.notNull(paramString);
    this.attributes.remove(paramString);
    return this;
  }
  
  protected void removeChild(Node paramNode)
  {
    if (paramNode.parentNode == this) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool);
      int i = paramNode.siblingIndex();
      this.childNodes.remove(i);
      reindexChildren();
      paramNode.parentNode = null;
      return;
    }
  }
  
  protected void replaceChild(Node paramNode1, Node paramNode2)
  {
    if (paramNode1.parentNode == this) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool);
      Validate.notNull(paramNode2);
      if (paramNode2.parentNode != null) {
        paramNode2.parentNode.removeChild(paramNode2);
      }
      Integer localInteger = Integer.valueOf(paramNode1.siblingIndex());
      this.childNodes.set(localInteger.intValue(), paramNode2);
      paramNode2.parentNode = this;
      paramNode2.setSiblingIndex(localInteger.intValue());
      paramNode1.parentNode = null;
      return;
    }
  }
  
  public void replaceWith(Node paramNode)
  {
    Validate.notNull(paramNode);
    Validate.notNull(this.parentNode);
    this.parentNode.replaceChild(this, paramNode);
  }
  
  public void setBaseUri(final String paramString)
  {
    Validate.notNull(paramString);
    traverse(new NodeVisitor()
    {
      public void head(Node paramAnonymousNode, int paramAnonymousInt)
      {
        paramAnonymousNode.baseUri = paramString;
      }
      
      public void tail(Node paramAnonymousNode, int paramAnonymousInt) {}
    });
  }
  
  protected void setParentNode(Node paramNode)
  {
    if (this.parentNode != null) {
      this.parentNode.removeChild(this);
    }
    this.parentNode = paramNode;
  }
  
  protected void setSiblingIndex(int paramInt)
  {
    this.siblingIndex = paramInt;
  }
  
  public int siblingIndex()
  {
    return this.siblingIndex;
  }
  
  public List siblingNodes()
  {
    if (this.parentNode == null) {
      return Collections.emptyList();
    }
    Object localObject = this.parentNode.childNodes;
    ArrayList localArrayList = new ArrayList(((List)localObject).size() - 1);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Node localNode = (Node)((Iterator)localObject).next();
      if (localNode != this) {
        localArrayList.add(localNode);
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return outerHtml();
  }
  
  public Node traverse(NodeVisitor paramNodeVisitor)
  {
    Validate.notNull(paramNodeVisitor);
    new NodeTraversor(paramNodeVisitor).traverse(this);
    return this;
  }
  
  public Node unwrap()
  {
    Validate.notNull(this.parentNode);
    int i = this.siblingIndex;
    if (this.childNodes.size() > 0) {}
    for (Node localNode = (Node)this.childNodes.get(0);; localNode = null)
    {
      this.parentNode.addChildren(i, childNodesAsArray());
      remove();
      return localNode;
    }
  }
  
  public Node wrap(String paramString)
  {
    int i = 0;
    Validate.notEmpty(paramString);
    Object localObject;
    if ((parent() instanceof Element))
    {
      localObject = (Element)parent();
      localObject = Parser.parseFragment(paramString, (Element)localObject, baseUri());
      paramString = (Node)((List)localObject).get(0);
      if ((paramString != null) && ((paramString instanceof Element))) {
        break label65;
      }
      paramString = null;
    }
    label65:
    Element localElement;
    do
    {
      return paramString;
      localObject = null;
      break;
      localElement = (Element)paramString;
      paramString = getDeepChild(localElement);
      this.parentNode.replaceChild(this, localElement);
      paramString.addChildren(new Node[] { this });
      paramString = this;
    } while (((List)localObject).size() <= 0);
    for (;;)
    {
      paramString = this;
      if (i >= ((List)localObject).size()) {
        break;
      }
      paramString = (Node)((List)localObject).get(i);
      paramString.parentNode.removeChild(paramString);
      localElement.appendChild(paramString);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */