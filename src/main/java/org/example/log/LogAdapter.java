package org.example.log;

import java.util.Date;

public class LogAdapter
{
    Logger logger;

    public LogAdapter(Logger logger)
    {
        this.logger = logger;
    }

    public void setLogger(Logger logger)
    {
        this.logger = logger;
    }

    public void log(String operacao)
    {
        logger.log(operacao);
    }
}
