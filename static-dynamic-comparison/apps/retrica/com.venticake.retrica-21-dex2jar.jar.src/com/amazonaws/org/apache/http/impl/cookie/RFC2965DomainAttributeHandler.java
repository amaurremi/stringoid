package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.ClientCookie;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieAttributeHandler;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.cookie.SetCookie;
import java.util.Locale;
import org.apache.http.annotation.Immutable;

@Immutable
public class RFC2965DomainAttributeHandler
  implements CookieAttributeHandler
{
  public boolean domainMatch(String paramString1, String paramString2)
  {
    return (paramString1.equals(paramString2)) || ((paramString2.startsWith(".")) && (paramString1.endsWith(paramString2)));
  }
  
  public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (paramCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramCookieOrigin == null) {
      throw new IllegalArgumentException("Cookie origin may not be null");
    }
    paramCookieOrigin = paramCookieOrigin.getHost().toLowerCase(Locale.ENGLISH);
    paramCookie = paramCookie.getDomain();
    if (!domainMatch(paramCookieOrigin, paramCookie)) {}
    while (paramCookieOrigin.substring(0, paramCookieOrigin.length() - paramCookie.length()).indexOf('.') != -1) {
      return false;
    }
    return true;
  }
  
  public void parse(SetCookie paramSetCookie, String paramString)
  {
    if (paramSetCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramString == null) {
      throw new MalformedCookieException("Missing value for domain attribute");
    }
    if (paramString.trim().length() == 0) {
      throw new MalformedCookieException("Blank value for domain attribute");
    }
    String str = paramString.toLowerCase(Locale.ENGLISH);
    paramString = str;
    if (!str.startsWith(".")) {
      paramString = '.' + str;
    }
    paramSetCookie.setDomain(paramString);
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (paramCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramCookieOrigin == null) {
      throw new IllegalArgumentException("Cookie origin may not be null");
    }
    paramCookieOrigin = paramCookieOrigin.getHost().toLowerCase(Locale.ENGLISH);
    if (paramCookie.getDomain() == null) {
      throw new CookieRestrictionViolationException("Invalid cookie state: domain not specified");
    }
    String str = paramCookie.getDomain().toLowerCase(Locale.ENGLISH);
    if (((paramCookie instanceof ClientCookie)) && (((ClientCookie)paramCookie).containsAttribute("domain")))
    {
      if (!str.startsWith(".")) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
      }
      int i = str.indexOf('.', 1);
      if (((i < 0) || (i == str.length() - 1)) && (!str.equals(".local"))) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie.getDomain() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
      }
      if (!domainMatch(paramCookieOrigin, str)) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie.getDomain() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
      }
      if (paramCookieOrigin.substring(0, paramCookieOrigin.length() - str.length()).indexOf('.') != -1) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie.getDomain() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
      }
    }
    else if (!paramCookie.getDomain().equals(paramCookieOrigin))
    {
      throw new CookieRestrictionViolationException("Illegal domain attribute: \"" + paramCookie.getDomain() + "\"." + "Domain of origin: \"" + paramCookieOrigin + "\"");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/RFC2965DomainAttributeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */