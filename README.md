[![Build Status](http://teamcity.geolatte.org/app/rest/builds/buildType:\(id:bt2\)/statusIcon)](http://teamcity.geolatte.org/viewType.html?buildTypeId=bt2&guest=1)

geolatte-geom 
=============

A geometry model for Java that conforms to the Simple Features For SQL specification 1.2.1.

It is intended as a drop-in replacement for the Java Topology Suite (JTS) geometry model. GeoLatte-geom is fully interoperable with JTS but offers the following additional features:
* immutable data structures (Geometries are value objects).
* support for 3D, 2DM and 3DM geometries
* support for several dialects of WKT/WKB (Postgis, Sql Server, SFS 1.21)
* pluggable, extendable Geometry operations
* CRS-awareness (knowledge of coordinate reference system (projected/geodetic, angular units of metres)
* geodetic operations (length, distance and area calculations)


