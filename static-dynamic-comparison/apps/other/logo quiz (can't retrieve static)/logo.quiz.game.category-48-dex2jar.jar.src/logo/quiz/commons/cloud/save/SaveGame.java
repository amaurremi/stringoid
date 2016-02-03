package logo.quiz.commons.cloud.save;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.bubble.play.services.utils.SerializationUtils;
import java.io.Serializable;
import logo.quiz.commons.ScoreUtilProvider;
import logo.quiz.commons.utils.score.DefaultScoreService;
import logo.quiz.commons.utils.score.ScoreService;

public class SaveGame
  implements Serializable, SameGameState
{
  static final long serialVersionUID = 7119003814146494884L;
  String completeLogos = "0,0";
  int hintsCount = 0;
  transient ScoreService scoreService;
  transient ScoreUtilProvider scoreUtilProvider;
  
  public SaveGame(int paramInt, ScoreUtilProvider paramScoreUtilProvider, ScoreService paramScoreService, Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("COMPLETE_LOGOS", "0,0");
    if (paramContext != null) {}
    for (;;)
    {
      this.completeLogos = paramContext;
      this.hintsCount = paramInt;
      this.scoreUtilProvider = paramScoreUtilProvider;
      this.scoreService = paramScoreService;
      return;
      paramContext = "0,0";
    }
  }
  
  public SaveGame(byte[] paramArrayOfByte, ScoreUtilProvider paramScoreUtilProvider, ScoreService paramScoreService)
  {
    SaveGame localSaveGame;
    if (paramArrayOfByte != null)
    {
      localSaveGame = (SaveGame)SerializationUtils.deserialize(paramArrayOfByte);
      if (localSaveGame != null) {
        if (localSaveGame.getCompleteLogos() == null) {
          break label72;
        }
      }
    }
    label72:
    for (paramArrayOfByte = localSaveGame.getCompleteLogos();; paramArrayOfByte = "0,0")
    {
      this.completeLogos = paramArrayOfByte;
      this.hintsCount = localSaveGame.getHintsCount();
      this.scoreUtilProvider = paramScoreUtilProvider;
      this.scoreService = paramScoreService;
      return;
    }
  }
  
  public byte[] getBytes()
  {
    return SerializationUtils.serialize(this);
  }
  
  public String getCompleteLogos()
  {
    return this.completeLogos;
  }
  
  public int getGuessedLogosCount(Context paramContext)
  {
    return DefaultScoreService.getCompletedLogosCount(this.completeLogos.split(","));
  }
  
  public int getHintsCount()
  {
    return this.hintsCount;
  }
  
  public void loadPurchase(Context paramContext) {}
  
  public void loadState(Context paramContext)
  {
    DefaultScoreService.setCompletedLogos(this.completeLogos, "COMPLETE_LOGOS", paramContext);
  }
  
  public void processStateConflict(SameGameState paramSameGameState1, SameGameState paramSameGameState2, Context paramContext) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/cloud/save/SaveGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */