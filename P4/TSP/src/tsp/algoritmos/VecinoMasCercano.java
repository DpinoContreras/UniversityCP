/*
 * Copyright (C) 2014 Benito Palacios Sánchez
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */

package tsp.algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import tsp.Ciudad;
import tsp.Problema;
import tsp.Ruta;

/**
 * Algoritmo del "Vecino más cercano" para resolver problemas TSP.
 * 
 * @version 1.0
 * @author  Benito Palacios Sánchez
 */
public class VecinoMasCercano implements ITspAlgoritmo {

    @Override
    public Ruta calculaMejorRuta(Problema problema) {
        Ruta mejorRuta = null;
        
        // Para cada ciudad inicial posible, calcula una ruta comenzando por
        // ella y se queda con la que menor coste dé.
        for (int i = 0; i < problema.getNumCiudades(); i++) {
            Ruta rutaActual = calculaRuta(i, problema);
            if (mejorRuta == null || mejorRuta.getCoste() > rutaActual.getCoste())
                mejorRuta = rutaActual;
        }
        
        return mejorRuta;
    }
    
    /**
     * Calcula una ruta usando el algoritmo del "Vecino más cercano" comenznado
     * por la ciudad dada.
     * 
     * @param ciudadInicial Índice de la ciudad por la que se comenzará
     * @param problema Conjunto de ciudades que definen el problema.
     * @return Ruta generada por el algoritmo.
     */
    private static Ruta calculaRuta(int ciudadInicial, Problema problema) {
        // Crea la instancia de ruta y añade la ruta inicial.
        Ruta ruta = new Ruta(problema.getNumCiudades());
        
        // Crea una lista de ciudades sin añadir a la ruta para que puedan
        // ser comparadas y obtener la más cercana.
        ArrayList<Ciudad> ciudadesLibres = new ArrayList<>(
                Arrays.asList(problema.getCiudades())
        );
           
        // Comenzamos por la ciudad inicial dada.
        Ciudad ciudadActual = problema.getCiudad(ciudadInicial);
        
        // Para cada ciudad, se añade y se busca su más cercana
        for (int i = 0; i < problema.getNumCiudades(); i++) {
            ruta.setCiudad(ciudadActual, i);     // La inserta
            ciudadesLibres.remove(ciudadActual);    // La elimina de las libres
           
            // Busca cual es la ciudad más cercana a esta que no se haya añadido
            // todavía a la ruta actual.
            ciudadActual = ciudadMasCercana(ciudadActual, ciudadesLibres);
        }
        
        return ruta;
    }
    
    /**
     * Busca la ciudad más cercana a la dada en una lista.
     * 
     * @param inicio Ciudad que se usará para comparar.
     * @param lista Lista de ciudad para comparar.
     * @return Ciudad más cercana.
     */
    private static Ciudad ciudadMasCercana(Ciudad inicio, ArrayList<Ciudad> lista) {
        double coste = 0;
        Ciudad masCercana = null;
        
        for (Ciudad ciudad : lista) {
            double costeActual = inicio.getDistancia(ciudad);
            if (masCercana == null || costeActual < coste) {
                coste = costeActual;
                masCercana = ciudad;
            } 
        }
        
        return masCercana;
    }
}