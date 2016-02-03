package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator.AllElements;
import org.jsoup.select.Evaluator.Attribute;
import org.jsoup.select.Evaluator.AttributeStarting;
import org.jsoup.select.Evaluator.AttributeWithValue;
import org.jsoup.select.Evaluator.AttributeWithValueContaining;
import org.jsoup.select.Evaluator.AttributeWithValueEnding;
import org.jsoup.select.Evaluator.AttributeWithValueMatching;
import org.jsoup.select.Evaluator.AttributeWithValueNot;
import org.jsoup.select.Evaluator.AttributeWithValueStarting;
import org.jsoup.select.Evaluator.Class;
import org.jsoup.select.Evaluator.ContainsOwnText;
import org.jsoup.select.Evaluator.ContainsText;
import org.jsoup.select.Evaluator.Id;
import org.jsoup.select.Evaluator.IndexEquals;
import org.jsoup.select.Evaluator.IndexGreaterThan;
import org.jsoup.select.Evaluator.IndexLessThan;
import org.jsoup.select.Evaluator.Matches;
import org.jsoup.select.Evaluator.MatchesOwn;
import org.jsoup.select.Evaluator.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.Selector;

public class Element
  extends Node
{
  private Set classNames;
  private Tag tag;
  
  public Element(Tag paramTag, String paramString)
  {
    this(paramTag, paramString, new Attributes());
  }
  
  public Element(Tag paramTag, String paramString, Attributes paramAttributes)
  {
    super(paramString, paramAttributes);
    Validate.notNull(paramTag);
    this.tag = paramTag;
  }
  
  private static void accumulateParents(Element paramElement, Elements paramElements)
  {
    paramElement = paramElement.parent();
    if ((paramElement != null) && (!paramElement.tagName().equals("#root")))
    {
      paramElements.add(paramElement);
      accumulateParents(paramElement, paramElements);
    }
  }
  
  private static void appendNormalisedText(StringBuilder paramStringBuilder, TextNode paramTextNode)
  {
    String str = paramTextNode.getWholeText();
    Object localObject = str;
    if (!preserveWhitespace(paramTextNode.parent()))
    {
      paramTextNode = TextNode.normaliseWhitespace(str);
      localObject = paramTextNode;
      if (TextNode.lastCharIsWhitespace(paramStringBuilder)) {
        localObject = TextNode.stripLeadingWhitespace(paramTextNode);
      }
    }
    paramStringBuilder.append((String)localObject);
  }
  
  private static void appendWhitespaceIfBr(Element paramElement, StringBuilder paramStringBuilder)
  {
    if ((paramElement.tag.getName().equals("br")) && (!TextNode.lastCharIsWhitespace(paramStringBuilder))) {
      paramStringBuilder.append(" ");
    }
  }
  
  private void html(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext()) {
      ((Node)localIterator.next()).outerHtml(paramStringBuilder);
    }
  }
  
  private static Integer indexInList(Element paramElement, List paramList)
  {
    Validate.notNull(paramElement);
    Validate.notNull(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      if (((Element)paramList.get(i)).equals(paramElement)) {
        return Integer.valueOf(i);
      }
      i += 1;
    }
    return null;
  }
  
  private void ownText(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof TextNode)) {
        appendNormalisedText(paramStringBuilder, (TextNode)localNode);
      } else if ((localNode instanceof Element)) {
        appendWhitespaceIfBr((Element)localNode, paramStringBuilder);
      }
    }
  }
  
  static boolean preserveWhitespace(Node paramNode)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramNode != null)
    {
      bool1 = bool2;
      if ((paramNode instanceof Element))
      {
        paramNode = (Element)paramNode;
        if (!paramNode.tag.preserveWhitespace())
        {
          bool1 = bool2;
          if (paramNode.parent() != null)
          {
            bool1 = bool2;
            if (!paramNode.parent().tag.preserveWhitespace()) {}
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public Element addClass(String paramString)
  {
    Validate.notNull(paramString);
    Set localSet = classNames();
    localSet.add(paramString);
    classNames(localSet);
    return this;
  }
  
  public Element after(String paramString)
  {
    return (Element)super.after(paramString);
  }
  
  public Element after(Node paramNode)
  {
    return (Element)super.after(paramNode);
  }
  
  public Element append(String paramString)
  {
    Validate.notNull(paramString);
    paramString = Parser.parseFragment(paramString, this, baseUri());
    addChildren((Node[])paramString.toArray(new Node[paramString.size()]));
    return this;
  }
  
  public Element appendChild(Node paramNode)
  {
    Validate.notNull(paramNode);
    addChildren(new Node[] { paramNode });
    return this;
  }
  
  public Element appendElement(String paramString)
  {
    paramString = new Element(Tag.valueOf(paramString), baseUri());
    appendChild(paramString);
    return paramString;
  }
  
  public Element appendText(String paramString)
  {
    appendChild(new TextNode(paramString, baseUri()));
    return this;
  }
  
  public Element attr(String paramString1, String paramString2)
  {
    super.attr(paramString1, paramString2);
    return this;
  }
  
  public Element before(String paramString)
  {
    return (Element)super.before(paramString);
  }
  
  public Element before(Node paramNode)
  {
    return (Element)super.before(paramNode);
  }
  
  public Element child(int paramInt)
  {
    return children().get(paramInt);
  }
  
  public Elements children()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof Element)) {
        localArrayList.add((Element)localNode);
      }
    }
    return new Elements(localArrayList);
  }
  
  public String className()
  {
    return attr("class");
  }
  
  public Set classNames()
  {
    if (this.classNames == null) {
      this.classNames = new LinkedHashSet(Arrays.asList(className().split("\\s+")));
    }
    return this.classNames;
  }
  
  public Element classNames(Set paramSet)
  {
    Validate.notNull(paramSet);
    this.attributes.put("class", StringUtil.join(paramSet, " "));
    return this;
  }
  
  public Element clone()
  {
    Element localElement = (Element)super.clone();
    localElement.classNames = null;
    return localElement;
  }
  
  public String data()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof DataNode)) {
        localStringBuilder.append(((DataNode)localNode).getWholeData());
      } else if ((localNode instanceof Element)) {
        localStringBuilder.append(((Element)localNode).data());
      }
    }
    return localStringBuilder.toString();
  }
  
  public List dataNodes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof DataNode)) {
        localArrayList.add((DataNode)localNode);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Map dataset()
  {
    return this.attributes.dataset();
  }
  
  public Integer elementSiblingIndex()
  {
    if (parent() == null) {
      return Integer.valueOf(0);
    }
    return indexInList(this, parent().children());
  }
  
  public Element empty()
  {
    this.childNodes.clear();
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return this == paramObject;
  }
  
  public Element firstElementSibling()
  {
    Elements localElements = parent().children();
    if (localElements.size() > 1) {
      return (Element)localElements.get(0);
    }
    return null;
  }
  
  public Elements getAllElements()
  {
    return Collector.collect(new Evaluator.AllElements(), this);
  }
  
  public Element getElementById(String paramString)
  {
    Validate.notEmpty(paramString);
    paramString = Collector.collect(new Evaluator.Id(paramString), this);
    if (paramString.size() > 0) {
      return paramString.get(0);
    }
    return null;
  }
  
  public Elements getElementsByAttribute(String paramString)
  {
    Validate.notEmpty(paramString);
    return Collector.collect(new Evaluator.Attribute(paramString.trim().toLowerCase()), this);
  }
  
  public Elements getElementsByAttributeStarting(String paramString)
  {
    Validate.notEmpty(paramString);
    return Collector.collect(new Evaluator.AttributeStarting(paramString.trim().toLowerCase()), this);
  }
  
  public Elements getElementsByAttributeValue(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValue(paramString1, paramString2), this);
  }
  
  public Elements getElementsByAttributeValueContaining(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValueContaining(paramString1, paramString2), this);
  }
  
  public Elements getElementsByAttributeValueEnding(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValueEnding(paramString1, paramString2), this);
  }
  
  public Elements getElementsByAttributeValueMatching(String paramString1, String paramString2)
  {
    try
    {
      Pattern localPattern = Pattern.compile(paramString2);
      return getElementsByAttributeValueMatching(paramString1, localPattern);
    }
    catch (PatternSyntaxException paramString1)
    {
      throw new IllegalArgumentException("Pattern syntax error: " + paramString2, paramString1);
    }
  }
  
  public Elements getElementsByAttributeValueMatching(String paramString, Pattern paramPattern)
  {
    return Collector.collect(new Evaluator.AttributeWithValueMatching(paramString, paramPattern), this);
  }
  
  public Elements getElementsByAttributeValueNot(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValueNot(paramString1, paramString2), this);
  }
  
  public Elements getElementsByAttributeValueStarting(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValueStarting(paramString1, paramString2), this);
  }
  
  public Elements getElementsByClass(String paramString)
  {
    Validate.notEmpty(paramString);
    return Collector.collect(new Evaluator.Class(paramString), this);
  }
  
  public Elements getElementsByIndexEquals(int paramInt)
  {
    return Collector.collect(new Evaluator.IndexEquals(paramInt), this);
  }
  
  public Elements getElementsByIndexGreaterThan(int paramInt)
  {
    return Collector.collect(new Evaluator.IndexGreaterThan(paramInt), this);
  }
  
  public Elements getElementsByIndexLessThan(int paramInt)
  {
    return Collector.collect(new Evaluator.IndexLessThan(paramInt), this);
  }
  
  public Elements getElementsByTag(String paramString)
  {
    Validate.notEmpty(paramString);
    return Collector.collect(new Evaluator.Tag(paramString.toLowerCase().trim()), this);
  }
  
  public Elements getElementsContainingOwnText(String paramString)
  {
    return Collector.collect(new Evaluator.ContainsOwnText(paramString), this);
  }
  
  public Elements getElementsContainingText(String paramString)
  {
    return Collector.collect(new Evaluator.ContainsText(paramString), this);
  }
  
  public Elements getElementsMatchingOwnText(String paramString)
  {
    try
    {
      Pattern localPattern = Pattern.compile(paramString);
      return getElementsMatchingOwnText(localPattern);
    }
    catch (PatternSyntaxException localPatternSyntaxException)
    {
      throw new IllegalArgumentException("Pattern syntax error: " + paramString, localPatternSyntaxException);
    }
  }
  
  public Elements getElementsMatchingOwnText(Pattern paramPattern)
  {
    return Collector.collect(new Evaluator.MatchesOwn(paramPattern), this);
  }
  
  public Elements getElementsMatchingText(String paramString)
  {
    try
    {
      Pattern localPattern = Pattern.compile(paramString);
      return getElementsMatchingText(localPattern);
    }
    catch (PatternSyntaxException localPatternSyntaxException)
    {
      throw new IllegalArgumentException("Pattern syntax error: " + paramString, localPatternSyntaxException);
    }
  }
  
  public Elements getElementsMatchingText(Pattern paramPattern)
  {
    return Collector.collect(new Evaluator.Matches(paramPattern), this);
  }
  
  public boolean hasClass(String paramString)
  {
    Iterator localIterator = classNames().iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasText()
  {
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof TextNode))
      {
        if (!((TextNode)localNode).isBlank()) {
          return true;
        }
      }
      else if (((localNode instanceof Element)) && (((Element)localNode).hasText())) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = super.hashCode();
    if (this.tag != null) {}
    for (int i = this.tag.hashCode();; i = 0) {
      return i + j * 31;
    }
  }
  
  public String html()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    html(localStringBuilder);
    return localStringBuilder.toString().trim();
  }
  
  public Element html(String paramString)
  {
    empty();
    append(paramString);
    return this;
  }
  
  public String id()
  {
    String str2 = attr("id");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public Element insertChildren(int paramInt, Collection paramCollection)
  {
    Validate.notNull(paramCollection, "Children collection to be inserted must not be null.");
    int j = childNodeSize();
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + (j + 1);
    }
    if ((i >= 0) && (i <= j)) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "Insert position out of bounds.");
      paramCollection = new ArrayList(paramCollection);
      addChildren(i, (Node[])paramCollection.toArray(new Node[paramCollection.size()]));
      return this;
    }
  }
  
  public boolean isBlock()
  {
    return this.tag.isBlock();
  }
  
  public Element lastElementSibling()
  {
    Elements localElements = parent().children();
    if (localElements.size() > 1) {
      return (Element)localElements.get(localElements.size() - 1);
    }
    return null;
  }
  
  public Element nextElementSibling()
  {
    if (this.parentNode == null) {}
    Elements localElements;
    Integer localInteger;
    do
    {
      return null;
      localElements = parent().children();
      localInteger = indexInList(this, localElements);
      Validate.notNull(localInteger);
    } while (localElements.size() <= localInteger.intValue() + 1);
    return (Element)localElements.get(localInteger.intValue() + 1);
  }
  
  public String nodeName()
  {
    return this.tag.getName();
  }
  
  void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if ((paramStringBuilder.length() > 0) && (paramOutputSettings.prettyPrint()) && ((this.tag.formatAsBlock()) || ((parent() != null) && (parent().tag().formatAsBlock())) || (paramOutputSettings.outline()))) {
      indent(paramStringBuilder, paramInt, paramOutputSettings);
    }
    paramStringBuilder.append("<").append(tagName());
    this.attributes.html(paramStringBuilder, paramOutputSettings);
    if ((this.childNodes.isEmpty()) && (this.tag.isSelfClosing()))
    {
      paramStringBuilder.append(" />");
      return;
    }
    paramStringBuilder.append(">");
  }
  
  void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if ((!this.childNodes.isEmpty()) || (!this.tag.isSelfClosing()))
    {
      if ((paramOutputSettings.prettyPrint()) && (!this.childNodes.isEmpty()) && ((this.tag.formatAsBlock()) || ((paramOutputSettings.outline()) && ((this.childNodes.size() > 1) || ((this.childNodes.size() == 1) && (!(this.childNodes.get(0) instanceof TextNode))))))) {
        indent(paramStringBuilder, paramInt, paramOutputSettings);
      }
      paramStringBuilder.append("</").append(tagName()).append(">");
    }
  }
  
  public String ownText()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ownText(localStringBuilder);
    return localStringBuilder.toString().trim();
  }
  
  public final Element parent()
  {
    return (Element)this.parentNode;
  }
  
  public Elements parents()
  {
    Elements localElements = new Elements();
    accumulateParents(this, localElements);
    return localElements;
  }
  
  public Element prepend(String paramString)
  {
    Validate.notNull(paramString);
    paramString = Parser.parseFragment(paramString, this, baseUri());
    addChildren(0, (Node[])paramString.toArray(new Node[paramString.size()]));
    return this;
  }
  
  public Element prependChild(Node paramNode)
  {
    Validate.notNull(paramNode);
    addChildren(0, new Node[] { paramNode });
    return this;
  }
  
  public Element prependElement(String paramString)
  {
    paramString = new Element(Tag.valueOf(paramString), baseUri());
    prependChild(paramString);
    return paramString;
  }
  
  public Element prependText(String paramString)
  {
    prependChild(new TextNode(paramString, baseUri()));
    return this;
  }
  
  public Element previousElementSibling()
  {
    if (this.parentNode == null) {}
    Elements localElements;
    Integer localInteger;
    do
    {
      return null;
      localElements = parent().children();
      localInteger = indexInList(this, localElements);
      Validate.notNull(localInteger);
    } while (localInteger.intValue() <= 0);
    return (Element)localElements.get(localInteger.intValue() - 1);
  }
  
  public Element removeClass(String paramString)
  {
    Validate.notNull(paramString);
    Set localSet = classNames();
    localSet.remove(paramString);
    classNames(localSet);
    return this;
  }
  
  public Elements select(String paramString)
  {
    return Selector.select(paramString, this);
  }
  
  public Elements siblingElements()
  {
    if (this.parentNode == null) {
      return new Elements(0);
    }
    Object localObject = parent().children();
    Elements localElements = new Elements(((List)localObject).size() - 1);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Element localElement = (Element)((Iterator)localObject).next();
      if (localElement != this) {
        localElements.add(localElement);
      }
    }
    return localElements;
  }
  
  public Tag tag()
  {
    return this.tag;
  }
  
  public String tagName()
  {
    return this.tag.getName();
  }
  
  public Element tagName(String paramString)
  {
    Validate.notEmpty(paramString, "Tag name must not be empty.");
    this.tag = Tag.valueOf(paramString);
    return this;
  }
  
  public String text()
  {
    final StringBuilder localStringBuilder = new StringBuilder();
    new NodeTraversor(new NodeVisitor()
    {
      public void head(Node paramAnonymousNode, int paramAnonymousInt)
      {
        if ((paramAnonymousNode instanceof TextNode))
        {
          paramAnonymousNode = (TextNode)paramAnonymousNode;
          Element.appendNormalisedText(localStringBuilder, paramAnonymousNode);
        }
        do
        {
          do
          {
            return;
          } while (!(paramAnonymousNode instanceof Element));
          paramAnonymousNode = (Element)paramAnonymousNode;
        } while ((localStringBuilder.length() <= 0) || ((!paramAnonymousNode.isBlock()) && (!paramAnonymousNode.tag.getName().equals("br"))) || (TextNode.lastCharIsWhitespace(localStringBuilder)));
        localStringBuilder.append(" ");
      }
      
      public void tail(Node paramAnonymousNode, int paramAnonymousInt) {}
    }).traverse(this);
    return localStringBuilder.toString().trim();
  }
  
  public Element text(String paramString)
  {
    Validate.notNull(paramString);
    empty();
    appendChild(new TextNode(paramString, this.baseUri));
    return this;
  }
  
  public List textNodes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof TextNode)) {
        localArrayList.add((TextNode)localNode);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public String toString()
  {
    return outerHtml();
  }
  
  public Element toggleClass(String paramString)
  {
    Validate.notNull(paramString);
    Set localSet = classNames();
    if (localSet.contains(paramString)) {
      localSet.remove(paramString);
    }
    for (;;)
    {
      classNames(localSet);
      return this;
      localSet.add(paramString);
    }
  }
  
  public String val()
  {
    if (tagName().equals("textarea")) {
      return text();
    }
    return attr("value");
  }
  
  public Element val(String paramString)
  {
    if (tagName().equals("textarea"))
    {
      text(paramString);
      return this;
    }
    attr("value", paramString);
    return this;
  }
  
  public Element wrap(String paramString)
  {
    return (Element)super.wrap(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Element.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */