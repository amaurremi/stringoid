package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AWSCredentialsProviderChain
  implements AWSCredentialsProvider
{
  private static final Log log = LogFactory.getLog(AWSCredentialsProviderChain.class);
  private List<AWSCredentialsProvider> credentialsProviders = new LinkedList();
  private AWSCredentialsProvider lastUsedProvider;
  private boolean reuseLastProvider = true;
  
  public AWSCredentialsProviderChain(AWSCredentialsProvider... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("No credential providers specified");
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      AWSCredentialsProvider localAWSCredentialsProvider = paramVarArgs[i];
      this.credentialsProviders.add(localAWSCredentialsProvider);
      i += 1;
    }
  }
  
  public AWSCredentials getCredentials()
  {
    if ((this.reuseLastProvider) && (this.lastUsedProvider != null)) {
      return this.lastUsedProvider.getCredentials();
    }
    Iterator localIterator = this.credentialsProviders.iterator();
    while (localIterator.hasNext())
    {
      AWSCredentialsProvider localAWSCredentialsProvider = (AWSCredentialsProvider)localIterator.next();
      try
      {
        AWSCredentials localAWSCredentials = localAWSCredentialsProvider.getCredentials();
        if ((localAWSCredentials.getAWSAccessKeyId() != null) && (localAWSCredentials.getAWSSecretKey() != null))
        {
          log.debug("Loading credentials from " + localAWSCredentialsProvider.toString());
          this.lastUsedProvider = localAWSCredentialsProvider;
          return localAWSCredentials;
        }
      }
      catch (Exception localException)
      {
        log.debug("Unable to load credentials from " + localAWSCredentialsProvider.toString() + ": " + localException.getMessage());
      }
    }
    throw new AmazonClientException("Unable to load AWS credentials from any provider in the chain");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/AWSCredentialsProviderChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */