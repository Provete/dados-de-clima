package org.dadosdeclima.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class JsonLogger implements Logger
{
    private String pathArquivo;

    private static String jsonFormat = "" +
            "{\n" +
            "\t\"data\": \"%s\",\n" +
            "\t\"hora\": \"%s\",\n" +
            "\t\"operacao\": \"%s\"\n" +
            "}\n";

    public JsonLogger(String pathArquivo)
    {
        this.pathArquivo = pathArquivo;
    }

    @Override
    public void log(String operacao)
    {
        File arquivo = new File(pathArquivo);

        criarSeInexistente(arquivo);
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        String dataFormatada = agora.format(formatadorData);
        String horaFormatada = agora.format(formatadorHora);

        String json = String.format(JsonLogger.jsonFormat, dataFormatada, horaFormatada, operacao);

        BufferedWriter bufferedWriter = null;
        try
        {
            FileWriter fileWriter = new FileWriter(arquivo, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(json);

        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try{
                if(arquivo != null)
                    bufferedWriter.close();
            }catch(Exception e){
                System.out.println("Error in closing the BufferedWriter" + e);
            }
        }
    }

    private void criarSeInexistente(File arquivo)
    {
        try
        {
            if(!arquivo.exists())
            {
                arquivo.getParentFile().mkdirs();
                System.out.println(arquivo.createNewFile());
            }
        } catch (IOException e)
        {
            System.exit(1);
            e.printStackTrace();
        }

    }
}
