package org.example;

import java.util.ArrayList;
import java.util.Date;

import org.example.observable.*;

public class DadosPresenter extends Observable
{
    ArrayList<DadoClimatico> dadosClimaticos;

    public DadosPresenter()
    {
        dadosClimaticos = new ArrayList<DadoClimatico>();
    }

    public void adicionarDado(Date data, float temperaturaCelsius, float umidadePorcentagem, float pressaoPascal)
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
}
