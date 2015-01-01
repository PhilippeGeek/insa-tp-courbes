/******************************************************************************
 * Copyright (C) 2015 Philippe VIENNE                                         *
 *                                                                            *
 * Main.java file is part of TP Courbes.                                      *
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

public class Main {

    public static void main(String... args) {
        Courbe[] courbes = new Courbe[]{
                new Polygone(new Point(-1, 0), new Point(1, 0), new Point(0, 1)),
                new Cercle(new Point(3, 2), 10 / (2 * Math.PI)),
                new PolygoneRegulier(new Point(0, 0), new Point(2, 2), 4)
        };
        double[] aires = new double[courbes.length];
        double[] longueures = new double[courbes.length];
        for (int i = 0; i < courbes.length; i++) {
            Courbe courbe = courbes[i];
            aires[i] = courbe.aire();
            longueures[i] = courbe.longueur();
            System.out.println("");
            System.out.println("Courbe n°" + i + " :");
            System.out.println("- " + courbe);
            System.out.println("- Distance :");
            for (int j = 0; j < courbes.length; j++) {
                if (j != i)
                    System.out.println("  * Avec la " + j + " : " + courbe.distance(courbes[j]));
            }
        }
        System.out.println("");
        System.out.println("Moyenne des aires : " + moyenne(aires));
        System.out.println("Moyenne des longueurs : " + moyenne(longueures));

    }

    private static double moyenne(double... numbers) {
        double sum = 0;
        for (double d : numbers) {
            sum += d;
        }
        return sum / numbers.length;
    }

}
