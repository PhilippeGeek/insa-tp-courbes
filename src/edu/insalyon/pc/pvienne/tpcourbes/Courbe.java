/******************************************************************************
 * Copyright (C) 2015 Philippe VIENNE                                         *
 *                                                                            *
 * Courbe.java file is part of TP Courbes.                                    *
 *                                                                            *
 * TP Courbes is free software: you can redistribute it and/or modify         *
 * it under the terms of the GNU General Public License as published by       *
 * the Free Software Foundation, either version 3 of the License, or          *
 * (at your option) any later version.                                        *
 *                                                                            *
 * TP Courbes is distributed in the hope that it will be useful,              *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the              *
 * GNU General Public License for more details.                               *
 *                                                                            *
 * You should have received a copy of the GNU General Public License          *
 * along with TP Courbes.  If not, see <http://www.gnu.org/licenses/>.        *
 ******************************************************************************/

package edu.insalyon.pc.pvienne.tpcourbes;

public abstract class Courbe {
    /**
     * Définie de façon "humaine" le type de la courbe.
     */
    public static final String TYPE_NAME = "Courbe";

    /**
     * Calcule la longueur de l'arc de la courbe
     *
     * @return le périmètre
     */
    public abstract double longueur();

    /**
     * Calcule l'aire de la courbe.
     * La courbe est supposé fermé et définie donc une surface ayant une aire. Dans le cas contraire c'est l'aire
     * sous la courbe.
     *
     * @return l'aire de la courbe
     */
    public abstract double aire();

    /**
     * Détermine le barycentre de la courbe
     *
     * @return Le point représentant le barycentre
     */
    public abstract Point barycentre();

    /**
     * Calcule la distance entre deux courbes.
     * La distance entre deux courbe est la distance entre les barycentre des courbes
     *
     * @param courbe La courbe avec laquelle on calcule la distance
     * @return La distance (toujours positif)
     */
    public double distance(Courbe courbe) {
        return barycentre().distance(courbe.barycentre());
    }

    /**
     * Décrit les propriété de la courbe.
     */
    public String toString() {
        return "Courbe[" + "longueur=" + longueur() + "," + "barycentre=" + barycentre() + "," + "aire=" + aire() + "]";
    }
}
