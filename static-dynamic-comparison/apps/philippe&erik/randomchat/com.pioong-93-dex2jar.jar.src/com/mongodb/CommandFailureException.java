package com.mongodb;

public class CommandFailureException
  extends MongoException
{
  private static final long serialVersionUID = -1180715413196161037L;
  private final CommandResult commandResult;
  
  public CommandFailureException(CommandResult paramCommandResult)
  {
    super(ServerError.getCode(paramCommandResult), paramCommandResult.toString());
    this.commandResult = paramCommandResult;
  }
  
  public CommandResult getCommandResult()
  {
    return this.commandResult;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/CommandFailureException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */