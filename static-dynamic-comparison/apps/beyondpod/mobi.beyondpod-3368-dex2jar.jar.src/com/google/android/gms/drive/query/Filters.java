package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.List;

public class Filters
{
  public static Filter and(Filter paramFilter, Filter... paramVarArgs)
  {
    return new LogicalFilter(Operator.si, paramFilter, paramVarArgs);
  }
  
  public static Filter and(List<Filter> paramList)
  {
    return new LogicalFilter(Operator.si, paramList);
  }
  
  public static Filter contains(MetadataField<String> paramMetadataField, String paramString)
  {
    return new ComparisonFilter(Operator.sl, paramMetadataField, paramString);
  }
  
  public static <T> Filter eq(MetadataField<T> paramMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.sd, paramMetadataField, paramT);
  }
  
  public static <T extends Comparable<T>> Filter greaterThan(OrderedMetadataField<T> paramOrderedMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.sg, paramOrderedMetadataField, paramT);
  }
  
  public static <T extends Comparable<T>> Filter greaterThanEquals(OrderedMetadataField<T> paramOrderedMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.sh, paramOrderedMetadataField, paramT);
  }
  
  public static <T> Filter in(CollectionMetadataField<T> paramCollectionMetadataField, T paramT)
  {
    return new InFilter(paramCollectionMetadataField, paramT);
  }
  
  public static <T extends Comparable<T>> Filter lessThan(OrderedMetadataField<T> paramOrderedMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.se, paramOrderedMetadataField, paramT);
  }
  
  public static <T extends Comparable<T>> Filter lessThanEquals(OrderedMetadataField<T> paramOrderedMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.sf, paramOrderedMetadataField, paramT);
  }
  
  public static Filter not(Filter paramFilter)
  {
    return new NotFilter(paramFilter);
  }
  
  public static Filter or(Filter paramFilter, Filter... paramVarArgs)
  {
    return new LogicalFilter(Operator.sj, paramFilter, paramVarArgs);
  }
  
  public static Filter or(List<Filter> paramList)
  {
    return new LogicalFilter(Operator.sj, paramList);
  }
  
  public static Filter sharedWithMe()
  {
    return new FieldOnlyFilter(SearchableField.rM);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/Filters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */