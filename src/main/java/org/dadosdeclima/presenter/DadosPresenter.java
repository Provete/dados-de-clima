package org.dadosdeclima.presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import org.dadosdeclima.model.DadoClimatico;
import org.dadosdeclima.observable.*;

public class DadosPresenter extends Observable
{
    ArrayList<DadoClimatico> dadosClimaticos;

    public DadosPresenter()
    {
        dadosClimaticos = new ArrayList<DadoClimatico>();
    }

    public void adicionarDado(LocalDate data, float temperaturaCelsius, float umidadePorcentagem, float pressaoPascal)
    {
        DadoClimatico dadoClimatico = new DadoClimatico(data, temperaturaCelsius, umidadePorcentagem, pressaoPascal);
        this.dadosClimaticos.add(dadoClimatico);
        this.notify(dadoClimatico);
    }

    public void removerDado(DadoClimatico dado)
    {
        this.dadosClimaticos.remove(dado);
        this.notify(dado);
    }

    public DadosMedios temperaturaMedia()
    {

        DadosMedios dadosMedios = new DadosMedios();

        for(DadoClimatico d : dadosClimaticos)
        {
            dadosMedios.temperaturaCelsiusMedia += d.getTemperaturaCelsius();
            dadosMedios.humidadePorcentagemMedia += d.getUmidadePorcentagem();
            dadosMedios.pressaoPascalMedia += d.getPressaoPascal();
        }
        dadosMedios.temperaturaCelsiusMedia /= dadosClimaticos.size();
        dadosMedios.humidadePorcentagemMedia /= dadosClimaticos.size();
        dadosMedios.pressaoPascalMedia /= dadosClimaticos.size();
        dadosMedios.numeroRegistros = dadosClimaticos.size();

        return dadosMedios;
    }

    public DadosClimaticosMaximasEMinimas maximasEMinimas()
    {
        if(dadosClimaticos.size() == 0)
        {
            return null;
        }
        DadosClimaticosMaximasEMinimas dados = new DadosClimaticosMaximasEMinimas(dadosClimaticos.get(0));

        for(DadoClimatico d : dadosClimaticos)
        {
            if(dados.temperaturaMaxima.getTemperaturaCelsius() < d.getTemperaturaCelsius())
                dados.temperaturaMaxima = d;

            if(dados.temperaturaMinima.getTemperaturaCelsius() > d.getTemperaturaCelsius())
                dados.temperaturaMinima = d;


            if(dados.humidadeMaxima.getUmidadePorcentagem() < d.getUmidadePorcentagem())
                dados.humidadeMaxima = d;

            if(dados.humidadeMinima.getUmidadePorcentagem() > d.getUmidadePorcentagem())
                dados.humidadeMinima = d;


            if(dados.pressaoMaxima.getPressaoPascal() < d.getPressaoPascal())
                dados.pressaoMaxima = d;

            if(dados.pressaoMinima.getPressaoPascal() > d.getPressaoPascal())
                dados.pressaoMinima = d;
        }

        return dados;
    }

    class DadosMedios
    {
        public float temperaturaCelsiusMedia;
        public float humidadePorcentagemMedia;
        public float pressaoPascalMedia;
        public int numeroRegistros;

        public DadosMedios()
        {
            temperaturaCelsiusMedia = 0.0f;
            humidadePorcentagemMedia = 0.0f;
            pressaoPascalMedia = 0.0f;
            numeroRegistros = 0;
        }
    }

    class DadosClimaticosMaximasEMinimas
    {
        public DadoClimatico temperaturaMinima;
        public DadoClimatico temperaturaMaxima;

        public DadoClimatico humidadeMinima;
        public DadoClimatico humidadeMaxima;

        public DadoClimatico pressaoMinima;
        public DadoClimatico pressaoMaxima;

        public DadosClimaticosMaximasEMinimas(DadoClimatico inicial)
        {
            this.temperaturaMinima = inicial;
            this.temperaturaMaxima = inicial;
            this.humidadeMinima = inicial;
            this.humidadeMaxima = inicial;
            this.pressaoMinima = inicial;
            this.pressaoMaxima = inicial;
        }
    }
}
