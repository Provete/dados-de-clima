package org.dadosdeclima.observable;

import java.util.ArrayList;

import org.dadosdeclima.model.DadoClimatico;

public class Observable
{
    private final ArrayList<Observer> observables;

    public Observable()
    {
        observables = new ArrayList<>();
    }

    public void subscribe(Observer o)
    {
        observables.add(o);
    }

    public void unsubscribe(Observer o)
    {
        observables.remove(o);
    }

    public void notify(DadoClimatico event)
    {
        for(Observer o: observables)
        {
            o.update(event);
        }
    }
}
