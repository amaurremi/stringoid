package twitter4j;

public abstract interface EntitySupport
{
  public abstract HashtagEntity[] getHashtagEntities();
  
  public abstract MediaEntity[] getMediaEntities();
  
  public abstract SymbolEntity[] getSymbolEntities();
  
  public abstract URLEntity[] getURLEntities();
  
  public abstract UserMentionEntity[] getUserMentionEntities();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/EntitySupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */