package org.example;

import java.io.BufferedWriter;
import org.example.DadoClimatico;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.time.LocalDate;
import java.io.PrintWriter;


public class Logger
{
    private String pathArquivo;

    private static String jsonFormat = "" +
            "{\n" +
                "\t\"data\": \"%s\"\n" +
                "\t\"hora\": \"%s\"\n" +
                "\t\"operacao\": \"%s\"\n" +
            "}\n";

    public Logger(String pathArquivo)
    {
        this.pathArquivo = pathArquivo;
    }

    public enum Operacao
    {
        INSERCAO,
        REMOCAO
    }

    public void toJson(Date data, Operacao op) throws IOException
    {
        File arquivo = new File(pathArquivo);

        criarSeInexistente(arquivo);

        String operacao = op == Operacao.INSERCAO? "Inserção" : "Remoção";
        String dataString = data.getDay() + "/" + data.getMonth() + "/" + data.getYear();

        String json = String.format(Logger.jsonFormat, dataString, data.getHours()-3, operacao);

        BufferedWriter bufferedWriter = null;
        try
        {
            FileWriter fileWriter = new FileWriter(arquivo, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(json);
            System.out.println("Json salvo com sucesso\n" + json);

        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try{
                if(arquivo != null)
                    bufferedWriter.close();
            }catch(Exception e){
                System.out.println("Error in closing the BufferedWriter"+e);
            }
        }
    }

    private void criarSeInexistente(File arquivo)
    {
        try
        {
            if(!arquivo.exists())
                arquivo.createNewFile();
        } catch (IOException e)
        {
            System.exit(1);
        }

    }
}
