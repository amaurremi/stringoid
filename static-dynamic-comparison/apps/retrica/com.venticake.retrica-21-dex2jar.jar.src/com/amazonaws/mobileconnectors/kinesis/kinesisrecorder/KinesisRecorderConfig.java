package com.amazonaws.mobileconnectors.kinesis.kinesisrecorder;

import com.amazonaws.ClientConfiguration;

public class KinesisRecorderConfig
{
  private ClientConfiguration clientConfiguration;
  private long maxStorageSize = 5242880L;
  
  public KinesisRecorderConfig()
  {
    this(new ClientConfiguration());
  }
  
  public KinesisRecorderConfig(ClientConfiguration paramClientConfiguration)
  {
    if (paramClientConfiguration == null) {
      throw new IllegalArgumentException();
    }
    this.clientConfiguration = new ClientConfiguration(paramClientConfiguration);
  }
  
  public KinesisRecorderConfig(KinesisRecorderConfig paramKinesisRecorderConfig)
  {
    this.maxStorageSize = paramKinesisRecorderConfig.getMaxStorageSize();
    this.clientConfiguration = new ClientConfiguration(paramKinesisRecorderConfig.getClientConfiguration());
  }
  
  public ClientConfiguration getClientConfiguration()
  {
    return this.clientConfiguration;
  }
  
  public long getMaxStorageSize()
  {
    return this.maxStorageSize;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorderConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */