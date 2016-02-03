package logo.quiz.commons;

public class PointsCounter
{
  private int allLogosCount = 0;
  private int allPoints = 0;
  private int completedLogosCount = 0;
  private int completedPoints = 0;
  
  public void add(PointsCounter paramPointsCounter)
  {
    increaseCompleteLogosCount(paramPointsCounter.getCompletedLogosCount());
    increasePoints(paramPointsCounter.getCompletedPoints());
    increaseAllPoints(paramPointsCounter.getCompletedPoints());
    increaseAllLogosCount(paramPointsCounter.getAllLogosCount());
  }
  
  public int getAllLogosCount()
  {
    return this.allLogosCount;
  }
  
  public int getAllPoints()
  {
    return this.allPoints;
  }
  
  public int getCompletedLogosCount()
  {
    return this.completedLogosCount;
  }
  
  public int getCompletedPoints()
  {
    return this.completedPoints;
  }
  
  public void increaseAllLogosCount(int paramInt)
  {
    this.allLogosCount += paramInt;
  }
  
  public void increaseAllPoints(int paramInt)
  {
    this.allPoints += paramInt;
  }
  
  public void increaseCompleteLogosCount(int paramInt)
  {
    this.completedLogosCount += paramInt;
  }
  
  public void increasePoints(int paramInt)
  {
    this.completedPoints += paramInt;
  }
  
  public void setAllLogosCount(int paramInt)
  {
    this.allLogosCount = paramInt;
  }
  
  public void setAllPoints(int paramInt)
  {
    this.allPoints = paramInt;
  }
  
  public void setCompletedLogosCount(int paramInt)
  {
    this.completedLogosCount = paramInt;
  }
  
  public void setCompletedPoints(int paramInt)
  {
    this.completedPoints = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/PointsCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */