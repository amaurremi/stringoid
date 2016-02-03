package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;

class Tokeniser
{
  static final char replacementChar = '�';
  private StringBuilder charBuffer = new StringBuilder();
  Token.Comment commentPending;
  StringBuilder dataBuffer;
  Token.Doctype doctypePending;
  private Token emitPending;
  private ParseErrorList errors;
  private boolean isEmitPending = false;
  private Token.StartTag lastStartTag;
  private CharacterReader reader;
  private boolean selfClosingFlagAcknowledged = true;
  private TokeniserState state = TokeniserState.Data;
  Token.Tag tagPending;
  
  Tokeniser(CharacterReader paramCharacterReader, ParseErrorList paramParseErrorList)
  {
    this.reader = paramCharacterReader;
    this.errors = paramParseErrorList;
  }
  
  private void characterReferenceError(String paramString)
  {
    if (this.errors.canAddError()) {
      this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", new Object[] { paramString }));
    }
  }
  
  private void error(String paramString)
  {
    if (this.errors.canAddError()) {
      this.errors.add(new ParseError(this.reader.pos(), paramString));
    }
  }
  
  void acknowledgeSelfClosingFlag()
  {
    this.selfClosingFlagAcknowledged = true;
  }
  
  void advanceTransition(TokeniserState paramTokeniserState)
  {
    this.reader.advance();
    this.state = paramTokeniserState;
  }
  
  String appropriateEndTagName()
  {
    return this.lastStartTag.tagName;
  }
  
  char[] consumeCharacterReference(Character paramCharacter, boolean paramBoolean)
  {
    if (this.reader.isEmpty()) {
      return null;
    }
    if ((paramCharacter != null) && (paramCharacter.charValue() == this.reader.current())) {
      return null;
    }
    if (this.reader.matchesAny(new char[] { 9, 10, 13, 12, 32, 60, 38 })) {
      return null;
    }
    this.reader.mark();
    if (this.reader.matchConsume("#"))
    {
      paramBoolean = this.reader.matchConsumeIgnoreCase("X");
      if (paramBoolean) {}
      for (paramCharacter = this.reader.consumeHexSequence(); paramCharacter.length() == 0; paramCharacter = this.reader.consumeDigitSequence())
      {
        characterReferenceError("numeric reference with no numerals");
        this.reader.rewindToMark();
        return null;
      }
      if (!this.reader.matchConsume(";")) {
        characterReferenceError("missing semicolon");
      }
      if (paramBoolean) {
        i = 16;
      }
      try
      {
        for (;;)
        {
          i = Integer.valueOf(paramCharacter, i).intValue();
          if ((i != -1) && ((i < 55296) || (i > 57343)) && (i <= 1114111)) {
            break;
          }
          characterReferenceError("character outside of valid range");
          return new char[] { 65533 };
          i = 10;
        }
      }
      catch (NumberFormatException paramCharacter)
      {
        for (;;)
        {
          i = -1;
        }
      }
      return Character.toChars(i);
    }
    paramCharacter = this.reader.consumeLetterThenDigitSequence();
    boolean bool = this.reader.matches(';');
    if ((Entities.isBaseNamedEntity(paramCharacter)) || ((Entities.isNamedEntity(paramCharacter)) && (bool))) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.reader.rewindToMark();
      if (bool) {
        characterReferenceError(String.format("invalid named referenece '%s'", new Object[] { paramCharacter }));
      }
      return null;
    }
    if (paramBoolean) {
      if ((!this.reader.matchesLetter()) && (!this.reader.matchesDigit()))
      {
        if (!this.reader.matchesAny(new char[] { 61, 45, 95 })) {}
      }
      else
      {
        this.reader.rewindToMark();
        return null;
      }
    }
    if (!this.reader.matchConsume(";")) {
      characterReferenceError("missing semicolon");
    }
    return new char[] { Entities.getCharacterByName(paramCharacter).charValue() };
  }
  
  void createCommentPending()
  {
    this.commentPending = new Token.Comment();
  }
  
  void createDoctypePending()
  {
    this.doctypePending = new Token.Doctype();
  }
  
  Token.Tag createTagPending(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = new Token.StartTag();; localObject = new Token.EndTag())
    {
      this.tagPending = ((Token.Tag)localObject);
      return this.tagPending;
    }
  }
  
  void createTempBuffer()
  {
    this.dataBuffer = new StringBuilder();
  }
  
  boolean currentNodeInHtmlNS()
  {
    return true;
  }
  
  void emit(char paramChar)
  {
    this.charBuffer.append(paramChar);
  }
  
  void emit(String paramString)
  {
    this.charBuffer.append(paramString);
  }
  
  void emit(Token paramToken)
  {
    Validate.isFalse(this.isEmitPending, "There is an unread token pending!");
    this.emitPending = paramToken;
    this.isEmitPending = true;
    if (paramToken.type == Token.TokenType.StartTag)
    {
      paramToken = (Token.StartTag)paramToken;
      this.lastStartTag = paramToken;
      if (paramToken.selfClosing) {
        this.selfClosingFlagAcknowledged = false;
      }
    }
    while ((paramToken.type != Token.TokenType.EndTag) || (((Token.EndTag)paramToken).attributes == null)) {
      return;
    }
    error("Attributes incorrectly present on end tag");
  }
  
  void emit(char[] paramArrayOfChar)
  {
    this.charBuffer.append(paramArrayOfChar);
  }
  
  void emitCommentPending()
  {
    emit(this.commentPending);
  }
  
  void emitDoctypePending()
  {
    emit(this.doctypePending);
  }
  
  void emitTagPending()
  {
    this.tagPending.finaliseTag();
    emit(this.tagPending);
  }
  
  void eofError(TokeniserState paramTokeniserState)
  {
    if (this.errors.canAddError()) {
      this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[] { paramTokeniserState }));
    }
  }
  
  void error(TokeniserState paramTokeniserState)
  {
    if (this.errors.canAddError()) {
      this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", new Object[] { Character.valueOf(this.reader.current()), paramTokeniserState }));
    }
  }
  
  TokeniserState getState()
  {
    return this.state;
  }
  
  boolean isAppropriateEndTagToken()
  {
    if (this.lastStartTag == null) {
      return false;
    }
    return this.tagPending.tagName.equals(this.lastStartTag.tagName);
  }
  
  Token read()
  {
    if (!this.selfClosingFlagAcknowledged)
    {
      error("Self closing flag not acknowledged");
      this.selfClosingFlagAcknowledged = true;
    }
    while (!this.isEmitPending) {
      this.state.read(this, this.reader);
    }
    if (this.charBuffer.length() > 0)
    {
      String str = this.charBuffer.toString();
      this.charBuffer.delete(0, this.charBuffer.length());
      return new Token.Character(str);
    }
    this.isEmitPending = false;
    return this.emitPending;
  }
  
  void transition(TokeniserState paramTokeniserState)
  {
    this.state = paramTokeniserState;
  }
  
  String unescapeEntities(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (!this.reader.isEmpty())
    {
      localStringBuilder.append(this.reader.consumeTo('&'));
      if (this.reader.matches('&'))
      {
        this.reader.consume();
        char[] arrayOfChar = consumeCharacterReference(null, paramBoolean);
        if ((arrayOfChar == null) || (arrayOfChar.length == 0)) {
          localStringBuilder.append('&');
        } else {
          localStringBuilder.append(arrayOfChar);
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Tokeniser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */