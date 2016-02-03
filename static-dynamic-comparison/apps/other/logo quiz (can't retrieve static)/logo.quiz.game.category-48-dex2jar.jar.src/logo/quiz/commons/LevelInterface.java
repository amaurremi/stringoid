package logo.quiz.commons;

public abstract interface LevelInterface
{
  public abstract String getCategory();
  
  public abstract int getFrom();
  
  public abstract int getId();
  
  public abstract int getLevelBackgroundResource();
  
  public abstract int getLevelImageResource();
  
  public abstract int getLogosCount();
  
  public abstract String getSubCategory();
  
  public abstract int getTo();
  
  public abstract int getUnlockLimit();
  
  public abstract String getWhatIsThisLabel();
  
  public abstract boolean isLevelBackgroundColor();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/LevelInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */