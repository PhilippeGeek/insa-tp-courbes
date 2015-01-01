/******************************************************************************
 * Copyright (C) 2015 Philippe VIENNE                                         *
 *                                                                            *
 * PolygoneRegulier.java file is part of TP Courbes.                          *
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

/**
 * Created by Philippe on 04/12/2014.
 */
public class PolygoneRegulier extends Polygone {

    private double r;
    private double beta;
    private double alpha;
    private Point centre;
    private Point premier_point;
    private int n_cotes;

    public PolygoneRegulier(Point centre, Point premier_point, Integer n_cotes) {
        this.centre = centre;
        this.premier_point = premier_point;
        this.n_cotes = n_cotes;
        if (n_cotes <= 2) {
            throw new IllegalArgumentException("Le polygône doit avoir 3 côtés au moins");
        }
        r = centre.distance(premier_point);
        beta = Math.atan2(premier_point.y - centre.y, premier_point.x - centre.x);
        alpha = (2 * Math.PI) / n_cotes;
        for (int i = 0; i < n_cotes; i++) {
            addSommet(new Point(r * Math.cos(i * alpha + beta) + centre.x, r * Math.sin(i * alpha + beta) + centre.y));
        }
    }

    @Override
    public double aire() {
        return n_cotes * Math.pow(getLongueurCote(), 2) / (4 * Math.tan(Math.PI / n_cotes));
    }

    public Point barycentre() {
        return new Point(centre.x, centre.y);
    }

    private double getLongueurCote() {
        return r * Math.sin(2 * Math.PI / n_cotes);
    }

    /**
     * Décrit les propriété de la courbe.
     */
    public String toString() {
        return "PolygoneRegulier[" + "longueur=" + longueur() + "," + "barycentre=" + barycentre() + "," + "aire=" + aire() + "]";
    }
}
