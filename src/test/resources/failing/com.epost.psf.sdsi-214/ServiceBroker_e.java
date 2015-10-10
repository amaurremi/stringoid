package org.jboss.netty.util.internal;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

public final class ServiceBroker_e<K, V>
  extends AbstractMap<K, V>
    implements ConcurrentMap<K, V>
    {
	      final int a;
	        final int b;
		  final ServiceBroker_e.g<K, V>[] c;
		    Set<K> d;
		      Set<Map.Entry<K, V>> e;
		        Collection<V> f;
			  
			  public ServiceBroker_e()
				    {
					        this(16, 0.75F, 16);
						  }
			    
			    public ServiceBroker_e(int paramInt)
				      {
					          this(paramInt, 0.75F, 16);
						    }
			      
			      public ServiceBroker_e(int paramInt, float paramFloat)
				        {
						    this(paramInt, paramFloat, 16);
						      }
			        
			        public ServiceBroker_e(int paramInt1, float paramFloat, int paramInt2)
					  {
						      if ((paramFloat <= 0.0F) || (paramInt1 < 0) || (paramInt2 <= 0)) {
							            throw new IllegalArgumentException();
								        }
						          int i = paramInt2;
							      if (paramInt2 > 65536) {
								            i = 65536;
									        }
							          paramInt2 = 1;
								      int j = 0;
								          while (paramInt2 < i)
										      {
											            paramInt2 <<= 1;
												          j += 1;
													      }
									      this.b = (32 - j);
									          this.a = (paramInt2 - 1);
										      this.c = ServiceBroker_e.g.a(paramInt2);
										          i = paramInt1;
											      if (paramInt1 > 1073741824) {
												            i = 1073741824;
													        }
											          j = i / paramInt2;
												      paramInt1 = j;
												          if (j * paramInt2 < i) {
														        paramInt1 = j + 1;
															    }
													      paramInt2 = 1;
													          while (paramInt2 < paramInt1) {
															        paramInt2 <<= 1;
																    }
														      paramInt1 = 0;
														          while (paramInt1 < this.c.length)
																      {
																	            this.c[paramInt1] = new ServiceBroker_e.g(paramInt2, paramFloat);
																		          paramInt1 += 1;
																			      }
															    }
				  
				  public ServiceBroker_e(Map<? extends K, ? extends V> paramMap)
					    {
						        this(Math.max((int)(paramMap.size() / 0.75F) + 1, 16), 0.75F, 16);
							    putAll(paramMap);
							      }
				    
				    private int a(Object paramObject)
					      {
						          return b(paramObject.hashCode());
							    }
				      
				      private static int b(int paramInt)
					        {
							    paramInt = (paramInt << 15 ^ 0xCD7D) + paramInt;
							        paramInt ^= paramInt >>> 10;
								    paramInt += (paramInt << 3);
								        paramInt ^= paramInt >>> 6;
									    paramInt += (paramInt << 2) + (paramInt << 14);
									        return paramInt ^ paramInt >>> 16;
										  }
				        
				        ServiceBroker_e.g<K, V> a(int paramInt)
						  {
							      return this.c[(paramInt >>> this.b & this.a)];
							        }
					  
					  public void clear()
						    {
							        int i = 0;
								    while (i < this.c.length)
									        {
											      this.c[i].c();
											            i += 1;
												        }
								      }
					    
					    public boolean contains(Object paramObject)
						      {
							          return containsValue(paramObject);
								    }
					      
					      public boolean containsKey(Object paramObject)
						        {
								    int i = a(paramObject);
								        return a(i).b(paramObject, i);
									  }
					        
					        public boolean containsValue(Object paramObject)
							  {
								      int n = 0;
								          int m = 0;
									      if (paramObject == null) {
										            throw new NullPointerException();
											        }
									          ServiceBroker_e.g[] arrayOfG = this.c;
										      int[] arrayOfInt = new int[arrayOfG.length];
										          int i = 0;
											      if (i < 2)
												          {
														        j = 0;
															      int k = 0;
															            while (j < arrayOfG.length)
																	          {
																			          int i1 = arrayOfG[j].b;
																				          arrayOfInt[j] = i1;
																					          k += i1;
																						          if (arrayOfG[j].a(paramObject)) {
																								            return true;
																									            }
																							          j += 1;
																								        }
																          if (k == 0) {
																		          break label265;
																			        }
																	        j = 0;
																		      label99:
																		      if (j >= arrayOfG.length) {
																			              break label265;
																				            }
																		            if (arrayOfInt[j] == arrayOfG[j].b) {}
																			        }
											          label265:
											          for (int j = 0;; j = 1)
													      {
														            if (j != 0)
																          {
																		          return false;
																			          j += 1;
																				          break label99;
																					        }
															          i += 1;
																        break;
																	      i = 0;
																	            while (i < arrayOfG.length)
																			          {
																					          arrayOfG[i].lock();
																						          i += 1;
																							        }
																		          i = 0;
																			        for (;;)
																					      {
																						              try
																								              {
																										                if (i >= arrayOfG.length) {
																													            continue;
																														              }
																												          bool = arrayOfG[i].a(paramObject);
																													            if (!bool) {
																															                continue;
																																	          }
																														              bool = true;
																															                i = m;
																																	        }
																							              finally
																									              {
																											                i = n;
																													          continue;
																														            boolean bool = false;
																															              i = m;
																																                continue;
																																		        }
																								              if (i >= arrayOfG.length) {
																										                continue;
																												        }
																									              arrayOfG[i].unlock();
																										              i += 1;
																											              continue;
																												              i += 1;
																													            }
																				      while (i < arrayOfG.length)
																					            {
																							            arrayOfG[i].unlock();
																								            i += 1;
																									          }
																				            throw paramObject;
																					          return bool;
																						      }
												    }
						  
						  public Enumeration<V> elements()
							    {
								        return new ServiceBroker_e.i(this);
									  }
						    
						    public Set<Map.Entry<K, V>> entrySet()
							      {
								          Object localObject = this.e;
									      if (localObject != null) {
										            return localObject;
											        }
									          localObject = new ServiceBroker_e.b(this);
										      this.e = ((Set)localObject);
										          return localObject;
											    }
						      
						      public V get(Object paramObject)
							        {
									    int i = a(paramObject);
									        return a(i).a(paramObject, i);
										  }
						        
						        public boolean isEmpty()
								  {
									      ServiceBroker_e.g[] arrayOfG = this.c;
									          int[] arrayOfInt = new int[arrayOfG.length];
										      int i = 0;
										          int j = 0;
											      while (i < arrayOfG.length)
												          {
														        if (arrayOfG[i].a != 0) {
																        return false;
																	      }
															      int k = arrayOfG[i].b;
															            arrayOfInt[i] = k;
																          j += k;
																	        i += 1;
																		    }
											          if (j != 0)
													      {
														            i = 0;
															          for (;;)
																	        {
																			        if (i >= arrayOfG.length) {
																					          break label104;
																						          }
																				        if ((arrayOfG[i].a != 0) || (arrayOfInt[i] != arrayOfG[i].b)) {
																						          break;
																							          }
																					        i += 1;
																						      }
																      }
												      label104:
												      return true;
												        }
							  
							  public Set<K> keySet()
								    {
									        Object localObject = this.d;
										    if (localObject != null) {
											          return localObject;
												      }
										        localObject = new ServiceBroker_e.f(this);
											    this.d = ((Set)localObject);
											        return localObject;
												  }
							    
							    public Enumeration<K> keys()
								      {
									          return new ServiceBroker_e.e(this);
										    }
							      
							      public void purgeStaleEntries()
								        {
										    int i = 0;
										        while (i < this.c.length)
												    {
													          this.c[i].b();
														        i += 1;
															    }
											  }
							        
							        public V put(K paramK, V paramV)
									  {
										      if (paramV == null) {
											            throw new NullPointerException();
												        }
										          int i = a(paramK);
											      return a(i).a(paramK, i, paramV, false);
											        }
								  
								  public void putAll(Map<? extends K, ? extends V> paramMap)
									    {
										        paramMap = paramMap.entrySet().iterator();
											    while (paramMap.hasNext())
												        {
														      Map.Entry localEntry = (Map.Entry)paramMap.next();
														            put(localEntry.getKey(), localEntry.getValue());
															        }
											      }
								    
								    public V putIfAbsent(K paramK, V paramV)
									      {
										          if (paramV == null) {
												        throw new NullPointerException();
													    }
											      int i = a(paramK);
											          return a(i).a(paramK, i, paramV, true);
												    }
								      
								      public V remove(Object paramObject)
									        {
											    int i = a(paramObject);
											        return a(i).b(paramObject, i, null, false);
												  }
								        
								        public boolean remove(Object paramObject1, Object paramObject2)
										  {
											      int i = a(paramObject1);
											          if (paramObject2 == null) {}
												      while (a(i).b(paramObject1, i, paramObject2, false) == null) {
													            return false;
														        }
												          return true;
													    }
									  
									  public V replace(K paramK, V paramV)
										    {
											        if (paramV == null) {
													      throw new NullPointerException();
													          }
												    int i = a(paramK);
												        return a(i).a(paramK, i, paramV);
													  }
									    
									    public boolean replace(K paramK, V paramV1, V paramV2)
										      {
											          if ((paramV1 == null) || (paramV2 == null)) {
													        throw new NullPointerException();
														    }
												      int i = a(paramK);
												          return a(i).a(paramK, i, paramV1, paramV2);
													    }
									      
									      public int size()
										        {
												    ServiceBroker_e.g[] arrayOfG = this.c;
												        int[] arrayOfInt = new int[arrayOfG.length];
													    int i = 0;
													        long l2 = 0L;
														    long l1 = 0L;
														        long l3;
															    int j;
															        if (i < 2)
																	    {
																		          l3 = 0L;
																			        l1 = 0L;
																				      int k = 0;
																				            j = 0;
																					          while (j < arrayOfG.length)
																							        {
																									        l1 += arrayOfG[j].a;
																										        int m = arrayOfG[j].b;
																											        arrayOfInt[j] = m;
																												        k += m;
																													        j += 1;
																														      }
																						        l2 = l3;
																							      if (k != 0)
																								            {
																										            j = 0;
																											            label93:
																											            l2 = l3;
																												            if (j < arrayOfG.length)
																														            {
																																              l3 += arrayOfG[j].a;
																																	                if (arrayOfInt[j] != arrayOfG[j].b)
																																				          {
																																						              l2 = -1L;
																																							                  label136:
																																							                  if (l2 != l1) {
																																										                break label189;
																																												            }
																																									            }
																																			        }
																													          }
																							          }
																    for (;;)
																	        {
																			      l3 = l1;
																			            if (l2 != l1)
																					          {
																							          l1 = 0L;
																								          i = 0;
																									          for (;;)
																											          {
																													            if (i < arrayOfG.length)
																															              {
																																	                  arrayOfG[i].lock();
																																			              i += 1;
																																				                  continue;
																																						              j += 1;
																																							                  break label93;
																																									              label189:
																																									              i += 1;
																																										                  break;
																																												            }
																														            }
																										          i = 0;
																											          while (i < arrayOfG.length)
																													          {
																															            l1 += arrayOfG[i].a;
																																              i += 1;
																																	              }
																												          i = 0;
																													          for (;;)
																															          {
																																	            l3 = l1;
																																		              if (i >= arrayOfG.length) {
																																				                  break;
																																						            }
																																			                arrayOfG[i].unlock();
																																					          i += 1;
																																						          }
																														        }
																				          if (l3 > 2147483647L) {
																						          return Integer.MAX_VALUE;
																							        }
																					        return (int)l3;
																						      break label136;
																						          }
																      }
									        
									        public Collection<V> values()
											  {
												      Object localObject = this.f;
												          if (localObject != null) {
														        return localObject;
															    }
													      localObject = new ServiceBroker_e.j(this);
													          this.f = ((Collection)localObject);
														      return localObject;
														        }
    }

