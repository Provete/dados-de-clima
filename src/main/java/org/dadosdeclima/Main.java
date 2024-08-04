package org.dadosdeclima;

import org.dadosdeclima.log.JsonLogger;
import org.dadosdeclima.log.LogAdapter;
import org.dadosdeclima.log.XmlLogger;

import java.nio.file.Paths;


public class Main
{
    public static void main(String[] args)
    {
        LogAdapter logger = new LogAdapter(new XmlLogger(Paths.get(".").toAbsolutePath().normalize().toString()));
        logger.log("inclusão");
    }
}