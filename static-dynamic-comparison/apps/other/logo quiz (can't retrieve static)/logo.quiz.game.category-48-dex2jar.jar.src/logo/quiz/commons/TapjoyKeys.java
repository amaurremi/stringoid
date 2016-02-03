package logo.quiz.commons;

public class TapjoyKeys
{
  String appId;
  String currencyId;
  String secret;
  
  public TapjoyKeys(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.secret = paramString2;
    this.currencyId = paramString3;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getCurrencyId()
  {
    return this.currencyId;
  }
  
  public String getSecret()
  {
    return this.secret;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setCurrencyId(String paramString)
  {
    this.currencyId = paramString;
  }
  
  public void setSecret(String paramString)
  {
    this.secret = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/TapjoyKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */