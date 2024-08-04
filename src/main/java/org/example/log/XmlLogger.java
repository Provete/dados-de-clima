package org.example.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class XmlLogger implements Logger
{
    private String pathArquivo;

    public XmlLogger(String pathArquivo)
    {
        this.pathArquivo = pathArquivo;
    }

    private static String xmlFormat = "" +
            "<entry>\n" +
                "\t<data>%s</data>\n" +
                "\t<hora>%s</hora>\n" +
                "\t<operação>%s</operação>\n" +
            "</entry>\n";

    public static String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>";

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


        String xml = String.format(XmlLogger.xmlFormat, dataFormatada, horaFormatada, operacao);

        BufferedWriter bufferedWriter = null;
        try
        {
            FileWriter fileWriter = new FileWriter(arquivo, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(xml);
            System.out.println("XML salvo com sucesso\n" + xml);

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
                arquivo.createNewFile();
                FileWriter fileWriter = new FileWriter(arquivo);
                fileWriter.write(XmlLogger.xmlHeader);

            }
        } catch (IOException e)
        {
            System.exit(1);
        }
    }
}
