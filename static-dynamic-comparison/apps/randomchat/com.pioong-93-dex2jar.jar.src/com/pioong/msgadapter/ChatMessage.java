package com.pioong.msgadapter;

public class ChatMessage
{
  boolean bTemp = false;
  int imgHeight = 0;
  int imgWidth = 0;
  String mID = null;
  int mIndex = -1;
  String mPath = "";
  String mRoomNo = "";
  private String mSendTime = null;
  private String mText = null;
  String mType = "";
  String mWho = "";
  String sendType = "";
  
  public ChatMessage() {}
  
  public ChatMessage(String paramString1, String paramString2)
  {
    this.mType = paramString1;
    this.mText = paramString2;
  }
  
  public ChatMessage(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, boolean paramBoolean)
  {
    this.mID = paramString1;
    this.mType = paramString2;
    this.mText = paramString3;
    this.imgWidth = paramInt1;
    this.imgHeight = paramInt2;
    this.mWho = paramString4;
    this.bTemp = paramBoolean;
  }
  
  public ChatMessage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mID = paramString1;
    this.mType = paramString2;
    this.mText = paramString3;
    this.mSendTime = paramString4;
    this.mWho = paramString5;
  }
  
  public ChatMessage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.mID = paramString1;
    this.mType = paramString2;
    this.mText = paramString3;
    this.mPath = paramString4;
    this.mSendTime = paramString5;
    this.mWho = paramString6;
    this.mIndex = paramInt;
  }
  
  public ChatMessage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mID = paramString1;
    this.mType = paramString2;
    this.mText = paramString3;
    this.mPath = paramString4;
    this.mSendTime = paramString5;
    this.mWho = paramString6;
    this.mIndex = paramInt1;
    this.imgWidth = paramInt2;
    this.imgHeight = paramInt3;
  }
  
  public ChatMessage(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.mID = paramString1;
    this.mType = paramString2;
    this.mText = paramString3;
    this.mWho = paramString4;
    this.bTemp = paramBoolean;
  }
  
  public String getID()
  {
    return this.mID;
  }
  
  public int getImgHeight()
  {
    return this.imgHeight;
  }
  
  public int getImgWidth()
  {
    return this.imgWidth;
  }
  
  public int getIndex()
  {
    return this.mIndex;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public String getRoom()
  {
    return this.mRoomNo;
  }
  
  public String getSType()
  {
    return this.sendType;
  }
  
  public String getStringIdx()
  {
    return Integer.toString(this.mIndex);
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public String getTime()
  {
    return this.mSendTime;
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public String getWho()
  {
    return this.mWho;
  }
  
  public boolean isTemp()
  {
    return this.bTemp;
  }
  
  public void setID(String paramString)
  {
    this.mID = paramString;
  }
  
  public void setImgHeight(int paramInt)
  {
    this.imgHeight = paramInt;
  }
  
  public void setImgWidth(int paramInt)
  {
    this.imgWidth = paramInt;
  }
  
  public void setIndex(int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.mPath = paramString;
  }
  
  public void setRoom(String paramString)
  {
    this.mRoomNo = paramString;
  }
  
  public void setSType(String paramString)
  {
    this.sendType = paramString;
  }
  
  public void setTemp(boolean paramBoolean)
  {
    this.bTemp = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
  }
  
  public void setTime(String paramString)
  {
    this.mSendTime = paramString;
  }
  
  public void setType(String paramString)
  {
    this.mType = paramString;
  }
  
  public void setWho(String paramString)
  {
    this.mWho = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/msgadapter/ChatMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */