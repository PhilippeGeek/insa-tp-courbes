/******************************************************************************
 * Copyright (C) 2015 Philippe VIENNE                                         *
 *                                                                            *
 * Polygone.java file is part of TP Courbes.                                  *
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

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

/**
 * Created by Philippe on 04/12/2014.
 */
public class Polygone extends Courbe {

    private ArrayList<Point> sommets = new ArrayList<Point>();
    private Point topLeft;

    public Polygone(Point... sommets) {
        for (Point sommet : sommets) {
            this.addSommet(sommet);
        }
    }

    /**
     * Permet d'obtenir un des sommet du polygone en évitant les exception.
     *
     * @param index L'index du sommet
     * @return Le sommet à l'index donnée
     */
    @NotNull
    protected Point getSommet(int index) {
        return sommets.get(index % sommets.size());
    }

    /**
     * Ajoute un sommet au polygone.
     * Le Sommet ne doit pas être null ou déjà présent dans le polygone.
     *
     * @param sommet Le sommet à ajouter
     */
    protected void addSommet(@NotNull Point sommet) {
        if (sommet != null) {
            if (sommets.contains(sommet)) {
                throw new IllegalArgumentException("Le polygone a déjà le sommet " + sommet);
            }
            sommets.add(sommet);
        } else {
            throw new IllegalArgumentException("Le sommet ne peut pas être nulle");
        }
    }

    /**
     * Détermine le périmètre du polygone.
     * La méthode somme les longueurs entre chaques sommets.
     *
     * @return Le périmètre
     */
    @Override
    public double longueur() {
        double longueur = 0;
        for (int i = 0; i < sommets.size(); i++)
            longueur += getSommet(i).distance(getSommet(i + 1));
        return longueur;
    }

    /**
     * Détermine l'aire du polygone.
     * On calcule la somme des triangle définies par chaques points.
     *
     * @return L'aire du polygone
     */
    @Override
    public double aire() {
        double aire = 0;
        for (int i = 0; i < sommets.size(); i++)
            aire += getSommet(i).x * getSommet(i + 1).y - getSommet(i + 1).x * getSommet(i).y;
        return aire * 0.5;
    }

    /**
     * Détermine le barycentre de la figure à partir d'une formule compliqué.
     *
     * @return Le point du barycentre
     */
    @Override
    public Point barycentre() {
        double x = 0, y = 0;
        final double k = 1 / (6 * aire());
        for (int i = 0; i < sommets.size(); i++) {
            double element = getSommet(i).x * getSommet(i + 1).y - getSommet(i + 1).x * getSommet(i).y;
            x += ((getSommet(i).x + getSommet(i + 1).x) * element);
            y += ((getSommet(i).y + getSommet(i + 1).y) * element);
        }
        return new Point(k * x, k * y);
    }

    /**
     * Décrit les propriété de la courbe.
     */
    public String toString() {
        return "Polygone[" + "longueur=" + longueur() + "," + "barycentre=" + barycentre() + "," + "aire=" + aire() + "]";
    }
}
