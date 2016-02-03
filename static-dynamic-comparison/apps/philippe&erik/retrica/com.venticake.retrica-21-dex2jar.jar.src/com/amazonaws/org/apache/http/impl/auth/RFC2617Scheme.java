package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.auth.ChallengeState;
import com.amazonaws.org.apache.http.auth.MalformedChallengeException;
import com.amazonaws.org.apache.http.message.BasicHeaderValueParser;
import com.amazonaws.org.apache.http.message.HeaderValueParser;
import com.amazonaws.org.apache.http.message.ParserCursor;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class RFC2617Scheme
  extends AuthSchemeBase
{
  private final Map<String, String> params = new HashMap();
  
  public RFC2617Scheme(ChallengeState paramChallengeState)
  {
    super(paramChallengeState);
  }
  
  public String getParameter(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (String)this.params.get(paramString.toLowerCase(Locale.ENGLISH));
  }
  
  protected Map<String, String> getParameters()
  {
    return this.params;
  }
  
  public String getRealm()
  {
    return getParameter("realm");
  }
  
  protected void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2)
  {
    paramCharArrayBuffer = BasicHeaderValueParser.DEFAULT.parseElements(paramCharArrayBuffer, new ParserCursor(paramInt1, paramCharArrayBuffer.length()));
    if (paramCharArrayBuffer.length == 0) {
      throw new MalformedChallengeException("Authentication challenge is empty");
    }
    this.params.clear();
    paramInt2 = paramCharArrayBuffer.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = paramCharArrayBuffer[paramInt1];
      this.params.put(((HeaderElement)localObject).getName(), ((HeaderElement)localObject).getValue());
      paramInt1 += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/RFC2617Scheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */