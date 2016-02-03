package logo.quiz.commons;

public class Hint
{
  protected int brandId;
  protected int cost;
  protected String dialogMessage;
  protected int drawableOff;
  protected String hint;
  protected int id;
  protected int imageViewId;
  protected boolean isUsed;
  protected int oldHintCost;
  
  public Hint() {}
  
  public Hint(int paramInt, String paramString, boolean paramBoolean)
  {
    this.id = paramInt;
    this.hint = paramString;
    this.isUsed = paramBoolean;
    this.cost = this.cost;
  }
  
  public Hint(int paramInt1, String paramString1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2)
  {
    this.imageViewId = paramInt5;
    this.drawableOff = paramInt6;
    this.cost = paramInt3;
    this.oldHintCost = paramInt4;
    this.brandId = paramInt2;
    this.id = paramInt1;
    this.hint = paramString1;
    this.isUsed = paramBoolean;
    this.dialogMessage = paramString2;
  }
  
  public int getBrandId()
  {
    return this.brandId;
  }
  
  public int getCost()
  {
    return this.cost;
  }
  
  public String getDialogMessage()
  {
    return this.dialogMessage;
  }
  
  public int getDrawableOff()
  {
    return this.drawableOff;
  }
  
  public String getHint()
  {
    return this.hint;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getImageViewId()
  {
    return this.imageViewId;
  }
  
  public int getOldHintCost()
  {
    return this.oldHintCost;
  }
  
  public boolean isUsed()
  {
    return this.isUsed;
  }
  
  public void setBrandId(int paramInt)
  {
    this.brandId = paramInt;
  }
  
  public void setCost(int paramInt)
  {
    this.cost = paramInt;
  }
  
  public void setDialogMessage(String paramString)
  {
    this.dialogMessage = paramString;
  }
  
  public void setDrawableOff(int paramInt)
  {
    this.drawableOff = paramInt;
  }
  
  public void setHint(String paramString)
  {
    this.hint = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImageViewId(int paramInt)
  {
    this.imageViewId = paramInt;
  }
  
  public void setOldHintCost(int paramInt)
  {
    this.oldHintCost = paramInt;
  }
  
  public void setUsed(boolean paramBoolean)
  {
    this.isUsed = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/Hint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */