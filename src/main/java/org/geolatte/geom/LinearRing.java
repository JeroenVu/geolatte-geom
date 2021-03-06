/*
 * This file is part of the GeoLatte project.
 *
 *     GeoLatte is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     GeoLatte is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with GeoLatte.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2010 - 2011 and Ownership of code is shared by:
 * Qmino bvba - Romeinsestraat 18 - 3001 Heverlee  (http://www.qmino.com)
 * Geovise bvba - Generaal Eisenhowerlei 9 - 2140 Antwerpen (http://www.geovise.com)
 */

package org.geolatte.geom;

/**
 * A <code>LineString</code> that is both closed and simple.
 *
 * @author Karel Maesen, Geovise BVBA
 *         creation-date: 4/14/11
 */
public class LinearRing extends LineString {


    final static LinearRing EMPTY = new LinearRing(EmptyPointSequence.INSTANCE, null);

    public static LinearRing createEmpty(){
        return EMPTY;
    }

    protected LinearRing(LineString lineString) {
        super(lineString);
        checkIsClosed();
    }

    public LinearRing(PointSequence points, GeometryOperations geometryOperations) {
        super(points, geometryOperations);
        checkIsClosed();
    }

    public LinearRing(PointSequence points) {
        this(points, null);
    }


    @Override
    public GeometryType getGeometryType() {
        return GeometryType.LINEAR_RING;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }

    private void checkIsClosed(){
        if (isEmpty() || (isClosed() && getNumPoints() > 3)) return;
        throw new IllegalArgumentException("Cannot create a LinearRing. PointSequence is not closed or contains < 4 points.");
    }
}
