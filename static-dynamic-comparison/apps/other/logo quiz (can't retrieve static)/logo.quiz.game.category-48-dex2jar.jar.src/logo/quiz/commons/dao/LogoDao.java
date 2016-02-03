package logo.quiz.commons.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.SparseArray;
import logo.quiz.commons.BrandTO;
import logo.quiz.commons.DeviceUtilCommons;

public class LogoDao
  extends SQLiteOpenHelper
{
  private static final String DATABASE_NAME = "bubble_logo_quiz";
  private static final int DATABASE_VERSION = 1;
  private static final String KEY_CATEGORY = "category";
  private static final String KEY_COMPLETE = "complete";
  private static final String KEY_DRAWABLE_NAME = "drawable_name";
  private static final String KEY_HINT1 = "hint1";
  private static final String KEY_HINT2 = "hint2";
  private static final String KEY_HINT3 = "hint3";
  private static final String KEY_ID = "id";
  private static final String KEY_LEVEL = "level";
  private static final String KEY_NAMES = "names";
  private static final String KEY_WIKIPEDIA_LINK = "wikipedia_link";
  private static final String TABLE_LOGOS = "logos";
  private SQLiteDatabase dbConnection = null;
  
  public LogoDao(Context paramContext)
  {
    super(paramContext, "bubble_logo_quiz", null, DeviceUtilCommons.getApplicationVersionCode(paramContext) + 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    onCreate(paramSQLiteDatabase, new SparseArray());
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase, SparseArray<BrandTO> paramSparseArray)
  {
    this.dbConnection = paramSQLiteDatabase;
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/dao/LogoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */