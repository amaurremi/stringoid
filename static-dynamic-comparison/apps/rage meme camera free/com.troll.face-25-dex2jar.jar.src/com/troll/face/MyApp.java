package com.troll.face;

import android.app.Application;
import java.util.ArrayList;

public class MyApp
  extends Application
{
  boolean addFlag;
  private String imagePath;
  private ArrayList<String> mySDCardImagesAbsolutePath = new ArrayList();
  private String mySDCardSingleImagesAbsolutePath;
  int photoToLoad;
  private int position;
  int rotateFlag;
  
  public boolean getAddFlag()
  {
    return this.addFlag;
  }
  
  public String getImagePath()
  {
    return this.imagePath;
  }
  
  public ArrayList<String> getMySDCardImagesAbsolutePath()
  {
    return this.mySDCardImagesAbsolutePath;
  }
  
  public String getMySDCardSingleImagesAbsolutePath()
  {
    return this.mySDCardSingleImagesAbsolutePath;
  }
  
  public int getPhotoToLoad()
  {
    return this.photoToLoad;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getRotateFlag()
  {
    return this.rotateFlag;
  }
  
  public void setAddFlag(boolean paramBoolean)
  {
    this.addFlag = paramBoolean;
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public void setMySDCardImagesAbsolutePath(ArrayList<String> paramArrayList)
  {
    this.mySDCardImagesAbsolutePath = paramArrayList;
  }
  
  public void setMySDCardSingleImagesAbsolutePath(String paramString)
  {
    this.mySDCardSingleImagesAbsolutePath = paramString;
  }
  
  public void setPhotoToLoad(int paramInt)
  {
    this.photoToLoad = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setRotateFlag(int paramInt)
  {
    this.rotateFlag = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/face/MyApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */