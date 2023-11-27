package ru.dmitriyt.lesson10.presentation

import com.yandex.mapkit.geometry.BoundingBox
import com.yandex.mapkit.geometry.Point
import kotlin.math.max
import kotlin.math.min

class BoundingBoxBuilder {
    private var south = Double.POSITIVE_INFINITY
    private var north = Double.NEGATIVE_INFINITY
    private var west = Double.NaN
    private var east = Double.NaN

    fun include(point: Point) {
        south = min(south, point.latitude)
        north = max(north, point.latitude)
        val longitude = point.longitude
        if (java.lang.Double.isNaN(west)) {
            west = point.longitude
            east = point.longitude
        } else {
            val currentWest = west
            val currentEast = east
            if (currentWest <= currentEast) {
                if (longitude in currentWest..currentEast) {
                    return
                }
            } else if (currentWest <= longitude || longitude <= currentEast) {
                return
            }
            if ((currentWest - longitude + 360.0) % 360.0 < (longitude - currentEast + 360.0) % 360.0) {
                west = longitude
            } else {
                east = longitude
            }
        }
    }

    fun build(): BoundingBox {
        val southWest = Point(south, west)
        val northEast = Point(north, east)
        return BoundingBox(southWest, northEast)
    }
}