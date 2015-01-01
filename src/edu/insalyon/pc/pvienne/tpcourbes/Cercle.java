/******************************************************************************
 * Copyright (C) 2015 Philippe VIENNE                                         *
 *                                                                            *
 * Cercle.java file is part of TP Courbes.                                    *
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
public class Cercle extends Courbe {

    public static final String TYPE_NAME = "Cercle";
    private Point centre;
    private double rayon;

    public Cercle(Point centre, double rayon) {
        this.setCentre(centre);
        this.setRayon(rayon);
    }

    @Override
    public double longueur() {
        return Math.PI * 2 * this.getRayon();
    }

    @Override
    public double aire() {
        return Math.PI * this.getRayon() * this.getRayon();
    }

    @Override
    public Point barycentre() {
        return new Point(centre.x, centre.y);
    }


    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        if (rayon <= 0) {
            throw new IllegalArgumentException("Rayon > 0");
        }
        this.rayon = rayon;
    }

    /**
     * Décrit les propriété de la courbe.
     */
    public String toString() {
        return "Cercle[" + "longueur=" + longueur() + "," + "barycentre=" + barycentre() + "," + "aire=" + aire() + "]";
    }
}
