package com.amazonaws.javax.xml.stream.xerces.xni;

public abstract interface XMLDTDContentModelHandler
{
  public abstract void any(Augmentations paramAugmentations);
  
  public abstract void element(String paramString, Augmentations paramAugmentations);
  
  public abstract void empty(Augmentations paramAugmentations);
  
  public abstract void endContentModel(Augmentations paramAugmentations);
  
  public abstract void endGroup(Augmentations paramAugmentations);
  
  public abstract void occurrence(short paramShort, Augmentations paramAugmentations);
  
  public abstract void pcdata(Augmentations paramAugmentations);
  
  public abstract void separator(short paramShort, Augmentations paramAugmentations);
  
  public abstract void startContentModel(String paramString, Augmentations paramAugmentations);
  
  public abstract void startGroup(Augmentations paramAugmentations);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/XMLDTDContentModelHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */