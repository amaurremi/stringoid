package com.pioong.msgadapter;

public class SendingMessage
{
  private String mID;
  private String mMsg;
  
  public SendingMessage(String paramString1, String paramString2)
  {
    this.mID = paramString1;
    this.mMsg = paramString2;
  }
  
  public String getID()
  {
    return this.mID;
  }
  
  public String getMsg()
  {
    return this.mMsg;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/msgadapter/SendingMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */