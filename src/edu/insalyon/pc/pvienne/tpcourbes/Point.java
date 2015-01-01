/******************************************************************************
 * Copyright (C) 2015 Philippe VIENNE                                         *
 *                                                                            *
 * Point.java file is part of TP Courbes.                                     *
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

public class Point {

    public double x, y;

    public Point(double ax, double ay) {
        x = ax;
        y = ay;
    }

    public double distance(Point otherPoint) {
        double dx = x - otherPoint.x;
        double dy = y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
        return "[x=" + x + ",y=" + y + "]";
    }

}

