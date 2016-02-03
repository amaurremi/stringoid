package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class Filters
{
  public static Filter and(Filter paramFilter, Filter... paramVarArgs)
  {
    return new LogicalFilter(Operator.Lf, paramFilter, paramVarArgs);
  }
  
  public static Filter and(Iterable<Filter> paramIterable)
  {
    return new LogicalFilter(Operator.Lf, paramIterable);
  }
  
  public static Filter contains(SearchableMetadataField<String> paramSearchableMetadataField, String paramString)
  {
    return new ComparisonFilter(Operator.Li, paramSearchableMetadataField, paramString);
  }
  
  public static <T> Filter eq(SearchableMetadataField<T> paramSearchableMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.La, paramSearchableMetadataField, paramT);
  }
  
  public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> paramSearchableOrderedMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.Ld, paramSearchableOrderedMetadataField, paramT);
  }
  
  public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> paramSearchableOrderedMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.Le, paramSearchableOrderedMetadataField, paramT);
  }
  
  public static <T> Filter in(SearchableCollectionMetadataField<T> paramSearchableCollectionMetadataField, T paramT)
  {
    return new InFilter(paramSearchableCollectionMetadataField, paramT);
  }
  
  public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> paramSearchableOrderedMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.Lb, paramSearchableOrderedMetadataField, paramT);
  }
  
  public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> paramSearchableOrderedMetadataField, T paramT)
  {
    return new ComparisonFilter(Operator.Lc, paramSearchableOrderedMetadataField, paramT);
  }
  
  public static Filter not(Filter paramFilter)
  {
    return new NotFilter(paramFilter);
  }
  
  public static Filter or(Filter paramFilter, Filter... paramVarArgs)
  {
    return new LogicalFilter(Operator.Lg, paramFilter, paramVarArgs);
  }
  
  public static Filter or(Iterable<Filter> paramIterable)
  {
    return new LogicalFilter(Operator.Lg, paramIterable);
  }
  
  public static Filter sharedWithMe()
  {
    return new FieldOnlyFilter(SearchableField.KI);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/query/Filters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */