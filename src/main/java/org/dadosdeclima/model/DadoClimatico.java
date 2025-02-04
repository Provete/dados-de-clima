package org.dadosdeclima.model;

import java.time.LocalDate;
import java.util.Date;

public class DadoClimatico
{
    private LocalDate data;
    private float temperaturaCelsius;
    private float umidadePorcentagem;
    private float pressaoPascal;

    public DadoClimatico(LocalDate data, float temperaturaCelsius, float umidadePorcentagem, float pressaoPascal)
    {
        this.data = data;
        this.temperaturaCelsius = temperaturaCelsius;
        this.umidadePorcentagem = umidadePorcentagem;
        this.pressaoPascal = pressaoPascal;
    }



    public LocalDate getData()
    {
        return data;
    }

    public float getPressaoPascal()
    {
        return pressaoPascal;
    }

    public float getTemperaturaCelsius()
    {
        return temperaturaCelsius;
    }

    public float getUmidadePorcentagem()
    {
        return umidadePorcentagem;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        DadoClimatico other = (DadoClimatico) obj;

        if(!this.data.equals( other.getData() ))
            return false;

        if(this.temperaturaCelsius != other.getTemperaturaCelsius())
            return false;

        if(this.umidadePorcentagem != other.getUmidadePorcentagem())
            return false;

        if(this.pressaoPascal != other.getPressaoPascal())
            return false;

        return true;
    }
}
