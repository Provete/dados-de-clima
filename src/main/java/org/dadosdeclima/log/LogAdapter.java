package org.dadosdeclima.log;

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
