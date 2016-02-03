package logo.quiz.commons;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.Serializable;
import logo.quiz.commons.utils.DeviceUtils;

public class BrandTO
  implements Serializable
{
  public static final String LOGOS_IMAGES_DOMAIN = "http://d23k9cw38d653j.cloudfront.net/";
  private static final long serialVersionUID = 1L;
  public int brandPosition;
  private BrandToDelegate brandToDelegate = new DefaultBrandToDelegate();
  public String category;
  public boolean complete = false;
  public int drawable;
  public String hint1;
  public String hint2;
  public String hint3;
  public int id = -1;
  public String imgName;
  private boolean isLowQuality = false;
  public int level = 1;
  public String nameCode;
  public String[] names;
  public String wikipediaLink;
  
  public BrandTO(int paramInt1, int paramInt2, String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.brandPosition = paramInt1;
    this.drawable = paramInt2;
    this.names = paramArrayOfString;
    this.complete = paramBoolean;
    this.level = paramInt3;
    this.category = paramString3;
    this.hint1 = paramString4;
    this.hint2 = paramString5;
    this.hint3 = this.hint3;
    this.wikipediaLink = paramString6;
    this.imgName = paramString1;
    this.nameCode = paramString2;
  }
  
  public BrandTO(int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, boolean paramBoolean, int paramInt3, String paramString2, String paramString3, String paramString4)
  {
    this.brandPosition = paramInt1;
    this.drawable = paramInt2;
    this.names = paramArrayOfString;
    this.complete = paramBoolean;
    this.level = paramInt3;
    this.category = paramString2;
    this.hint1 = paramString3;
    this.hint2 = paramString4;
    this.wikipediaLink = null;
    this.imgName = paramString1;
  }
  
  public BrandTO(int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, boolean paramBoolean, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.brandPosition = paramInt1;
    this.drawable = paramInt2;
    this.names = paramArrayOfString;
    this.complete = paramBoolean;
    this.level = paramInt3;
    this.category = paramString2;
    this.hint1 = paramString3;
    this.hint2 = paramString4;
    this.wikipediaLink = paramString5;
    this.imgName = paramString1;
  }
  
  public BrandTO(int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, boolean paramBoolean, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.brandPosition = paramInt1;
    this.drawable = paramInt2;
    this.names = paramArrayOfString;
    this.complete = paramBoolean;
    this.level = paramInt3;
    this.category = paramString2;
    this.hint1 = paramString3;
    this.hint2 = paramString4;
    this.hint3 = paramString5;
    this.wikipediaLink = paramString6;
    this.imgName = paramString1;
  }
  
  public BrandTO(int paramInt1, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.drawable = paramInt1;
    this.names = paramArrayOfString;
    this.level = paramInt2;
    this.category = paramString3;
    this.hint1 = paramString4;
    this.hint2 = paramString5;
    this.wikipediaLink = paramString6;
    this.imgName = paramString1;
    this.nameCode = paramString2;
  }
  
  public BrandTO(int paramInt1, String paramString1, String[] paramArrayOfString, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.drawable = paramInt1;
    this.names = paramArrayOfString;
    this.level = paramInt2;
    this.category = paramString2;
    this.hint1 = paramString3;
    this.hint2 = paramString4;
    this.wikipediaLink = paramString5;
    this.imgName = paramString1;
  }
  
  public BrandTO(int paramInt1, String paramString1, String[] paramArrayOfString, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, Context paramContext)
  {
    this.drawable = paramInt1;
    paramContext = DeviceUtils.getStringResourceByName(paramString1, paramContext);
    if ((paramContext != null) && (!paramContext.trim().equals(""))) {}
    for (this.names = arrayCopyWithFirstElementAdd(paramContext, paramArrayOfString);; this.names = paramArrayOfString)
    {
      this.level = paramInt2;
      this.category = paramString2;
      this.hint1 = paramString3;
      this.hint2 = paramString4;
      this.wikipediaLink = paramString5;
      this.imgName = paramString1;
      return;
    }
  }
  
  private static String[] arrayCopyWithFirstElementAdd(String paramString, String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    arrayOfString[0] = paramString;
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfString[(i + 1)] = paramArrayOfString[i];
      i += 1;
    }
    return arrayOfString;
  }
  
  public int getBrandPosition()
  {
    return this.brandPosition;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public int getDrawable()
  {
    return this.drawable;
  }
  
  public String getDrawableString()
  {
    if (this.drawable == -1) {
      return "http://d23k9cw38d653j.cloudfront.net/" + this.imgName + ".png";
    }
    return String.valueOf(this.drawable);
  }
  
  public String getHint1()
  {
    return this.hint1;
  }
  
  public String getHint2()
  {
    return this.hint2;
  }
  
  public String getHint3()
  {
    return this.hint3;
  }
  
  public int getId()
  {
    if (this.id == -1) {
      return this.brandPosition;
    }
    return this.id;
  }
  
  public String getImgName()
  {
    return this.imgName;
  }
  
  public int getLevel(Context paramContext)
  {
    return this.brandToDelegate.getLevel(this, paramContext);
  }
  
  public int getLevelStars(Context paramContext)
  {
    return this.brandToDelegate.getLevelStars(this, paramContext);
  }
  
  public String getNameCode()
  {
    return this.nameCode;
  }
  
  public String[] getNames()
  {
    return this.names;
  }
  
  public String getWikipediaLink()
  {
    return this.wikipediaLink;
  }
  
  public String getbrandName()
  {
    String str = "";
    if (this.names.length > 0) {
      str = this.names[0];
    }
    return str;
  }
  
  public boolean hasWikipediaLink()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.wikipediaLink != null)
    {
      bool1 = bool2;
      if (!this.wikipediaLink.equals("")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isComplete()
  {
    return this.complete;
  }
  
  public boolean isComplete(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("perfectGuessBrand" + this.id + paramString, 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isLowQuality()
  {
    return this.isLowQuality;
  }
  
  public void setBrandPosition(int paramInt)
  {
    this.brandPosition = paramInt;
  }
  
  public void setBrandToDelegate(BrandToDelegate paramBrandToDelegate)
  {
    this.brandToDelegate = paramBrandToDelegate;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setComplete(boolean paramBoolean)
  {
    this.complete = paramBoolean;
  }
  
  public void setDrawable(int paramInt)
  {
    this.drawable = paramInt;
  }
  
  public void setHint1(String paramString)
  {
    this.hint1 = paramString;
  }
  
  public void setHint2(String paramString)
  {
    this.hint2 = paramString;
  }
  
  public void setHint3(String paramString)
  {
    this.hint3 = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImgName(String paramString)
  {
    this.imgName = paramString;
  }
  
  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public void setLowQuality(boolean paramBoolean)
  {
    this.isLowQuality = paramBoolean;
  }
  
  public void setNameCode(String paramString)
  {
    this.nameCode = paramString;
  }
  
  public void setNames(String[] paramArrayOfString)
  {
    this.names = paramArrayOfString;
  }
  
  public void setWikipediaLink(String paramString)
  {
    this.wikipediaLink = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/BrandTO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */