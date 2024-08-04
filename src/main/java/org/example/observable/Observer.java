package org.example.observable;

import org.example.DadoClimatico;

public interface Observer
{
    void update(DadoClimatico event);
}
