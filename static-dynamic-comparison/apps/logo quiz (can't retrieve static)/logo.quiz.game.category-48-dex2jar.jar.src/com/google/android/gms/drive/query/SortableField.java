package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.kf;
import java.util.Date;

public class SortableField
{
  public static final SortableMetadataField<Date> CREATED_DATE;
  public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME;
  public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE;
  public static final SortableMetadataField<Date> MODIFIED_DATE;
  public static final SortableMetadataField<Long> QUOTA_USED = kd.Qb;
  public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE;
  public static final SortableMetadataField<String> TITLE = kd.Qe;
  
  static
  {
    CREATED_DATE = kf.Ql;
    MODIFIED_DATE = kf.Qn;
    MODIFIED_BY_ME_DATE = kf.Qo;
    LAST_VIEWED_BY_ME = kf.Qm;
    SHARED_WITH_ME_DATE = kf.Qp;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/query/SortableField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */