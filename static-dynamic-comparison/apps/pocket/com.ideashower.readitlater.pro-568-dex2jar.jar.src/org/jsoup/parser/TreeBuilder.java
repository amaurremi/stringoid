package org.jsoup.parser;

import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

abstract class TreeBuilder
{
  protected String baseUri;
  protected Token currentToken;
  protected Document doc;
  protected ParseErrorList errors;
  CharacterReader reader;
  protected DescendableLinkedList stack;
  Tokeniser tokeniser;
  
  protected Element currentElement()
  {
    return (Element)this.stack.getLast();
  }
  
  protected void initialiseParse(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    Validate.notNull(paramString1, "String input must not be null");
    Validate.notNull(paramString2, "BaseURI must not be null");
    this.doc = new Document(paramString2);
    this.reader = new CharacterReader(paramString1);
    this.errors = paramParseErrorList;
    this.tokeniser = new Tokeniser(this.reader, paramParseErrorList);
    this.stack = new DescendableLinkedList();
    this.baseUri = paramString2;
  }
  
  Document parse(String paramString1, String paramString2)
  {
    return parse(paramString1, paramString2, ParseErrorList.noTracking());
  }
  
  Document parse(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    initialiseParse(paramString1, paramString2, paramParseErrorList);
    runParser();
    return this.doc;
  }
  
  protected abstract boolean process(Token paramToken);
  
  protected void runParser()
  {
    Token localToken;
    do
    {
      localToken = this.tokeniser.read();
      process(localToken);
    } while (localToken.type != Token.TokenType.EOF);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/TreeBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */