package org.jsoup.parser;

import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.XmlDeclaration;

public class XmlTreeBuilder
  extends TreeBuilder
{
  private void insertNode(Node paramNode)
  {
    currentElement().appendChild(paramNode);
  }
  
  private void popStackToClose(Token.EndTag paramEndTag)
  {
    String str = paramEndTag.name();
    Iterator localIterator1 = null;
    Iterator localIterator2 = this.stack.descendingIterator();
    do
    {
      paramEndTag = localIterator1;
      if (!localIterator2.hasNext()) {
        break;
      }
      paramEndTag = (Element)localIterator2.next();
    } while (!paramEndTag.nodeName().equals(str));
    if (paramEndTag == null) {}
    for (;;)
    {
      return;
      localIterator1 = this.stack.descendingIterator();
      while (localIterator1.hasNext())
      {
        if ((Element)localIterator1.next() == paramEndTag)
        {
          localIterator1.remove();
          return;
        }
        localIterator1.remove();
      }
    }
  }
  
  protected void initialiseParse(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    super.initialiseParse(paramString1, paramString2, paramParseErrorList);
    this.stack.add(this.doc);
  }
  
  Element insert(Token.StartTag paramStartTag)
  {
    Tag localTag = Tag.valueOf(paramStartTag.name());
    Element localElement = new Element(localTag, this.baseUri, paramStartTag.attributes);
    insertNode(localElement);
    if (paramStartTag.isSelfClosing())
    {
      this.tokeniser.acknowledgeSelfClosingFlag();
      if (!localTag.isKnownTag()) {
        localTag.setSelfClosing();
      }
      return localElement;
    }
    this.stack.add(localElement);
    return localElement;
  }
  
  void insert(Token.Character paramCharacter)
  {
    insertNode(new TextNode(paramCharacter.getData(), this.baseUri));
  }
  
  void insert(Token.Comment paramComment)
  {
    Comment localComment = new Comment(paramComment.getData(), this.baseUri);
    Object localObject = localComment;
    if (paramComment.bogus)
    {
      paramComment = localComment.getData();
      localObject = localComment;
      if (paramComment.length() > 1) {
        if (!paramComment.startsWith("!"))
        {
          localObject = localComment;
          if (!paramComment.startsWith("?")) {}
        }
        else
        {
          localObject = new XmlDeclaration(paramComment.substring(1), localComment.baseUri(), paramComment.startsWith("!"));
        }
      }
    }
    insertNode((Node)localObject);
  }
  
  void insert(Token.Doctype paramDoctype)
  {
    insertNode(new DocumentType(paramDoctype.getName(), paramDoctype.getPublicIdentifier(), paramDoctype.getSystemIdentifier(), this.baseUri));
  }
  
  List parseFragment(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    initialiseParse(paramString1, paramString2, paramParseErrorList);
    runParser();
    return this.doc.childNodes();
  }
  
  protected boolean process(Token paramToken)
  {
    switch (1.$SwitchMap$org$jsoup$parser$Token$TokenType[paramToken.type.ordinal()])
    {
    default: 
      Validate.fail("Unexpected token type: " + paramToken.type);
    }
    for (;;)
    {
      return true;
      insert(paramToken.asStartTag());
      continue;
      popStackToClose(paramToken.asEndTag());
      continue;
      insert(paramToken.asComment());
      continue;
      insert(paramToken.asCharacter());
      continue;
      insert(paramToken.asDoctype());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/XmlTreeBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */