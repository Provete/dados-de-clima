package org.dadosdeclima.observable;

import org.dadosdeclima.model.DadoClimatico;

public interface Observer
{
    void update(DadoClimatico event);
}
