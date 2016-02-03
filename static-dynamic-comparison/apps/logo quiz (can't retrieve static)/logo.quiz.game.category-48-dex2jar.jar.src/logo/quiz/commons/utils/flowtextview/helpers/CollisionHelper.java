package logo.quiz.commons.utils.flowtextview.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import logo.quiz.commons.utils.flowtextview.models.Area;
import logo.quiz.commons.utils.flowtextview.models.Line;
import logo.quiz.commons.utils.flowtextview.models.Obstacle;

public class CollisionHelper
{
  private static final ArrayList<Area> mAreas = new ArrayList();
  
  public static Line calculateLineSpaceForGivenYOffset(float paramFloat1, int paramInt, float paramFloat2, ArrayList<Obstacle> paramArrayList)
  {
    Line localLine = new Line();
    localLine.leftBound = 0.0F;
    localLine.rightBound = paramFloat2;
    float f = paramFloat1 - paramInt;
    mAreas.clear();
    Object localObject1 = paramArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Obstacle)((Iterator)localObject1).next();
      if ((((Obstacle)localObject2).topLefty <= paramFloat1) && (((Obstacle)localObject2).bottomRighty >= f))
      {
        Area localArea = new Area();
        localArea.x1 = 0.0F;
        Object localObject3 = paramArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Obstacle)((Iterator)localObject3).next();
          if ((((Obstacle)localObject4).topLefty <= paramFloat1) && (((Obstacle)localObject4).bottomRighty >= f) && (((Obstacle)localObject4).topLeftx < ((Obstacle)localObject2).topLeftx)) {
            localArea.x1 = ((Obstacle)localObject4).bottomRightx;
          }
        }
        localArea.x2 = ((Obstacle)localObject2).topLeftx;
        localArea.width = (localArea.x2 - localArea.x1);
        localObject3 = new Area();
        ((Area)localObject3).x1 = ((Obstacle)localObject2).bottomRightx;
        ((Area)localObject3).x2 = paramFloat2;
        Object localObject4 = paramArrayList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Obstacle localObstacle = (Obstacle)((Iterator)localObject4).next();
          if ((localObstacle.topLefty <= paramFloat1) && (localObstacle.bottomRighty >= f) && (localObstacle.bottomRightx > ((Obstacle)localObject2).bottomRightx)) {
            ((Area)localObject3).x2 = localObstacle.topLeftx;
          }
        }
        ((Area)localObject3).width = (((Area)localObject3).x2 - ((Area)localObject3).x1);
        mAreas.add(localArea);
        mAreas.add(localObject3);
      }
    }
    paramArrayList = null;
    if (mAreas.size() > 0)
    {
      localObject2 = mAreas.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Area)((Iterator)localObject2).next();
        if (paramArrayList == null) {
          paramArrayList = (ArrayList<Obstacle>)localObject1;
        } else if (((Area)localObject1).width > paramArrayList.width) {
          paramArrayList = (ArrayList<Obstacle>)localObject1;
        }
      }
      localLine.leftBound = paramArrayList.x1;
      localLine.rightBound = paramArrayList.x2;
    }
    return localLine;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/flowtextview/helpers/CollisionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */