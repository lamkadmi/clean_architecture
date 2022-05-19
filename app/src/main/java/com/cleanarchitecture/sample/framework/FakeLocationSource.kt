package com.cleanarchitecture.sample.framework

import com.cleanarchitecture.data.DeviceLocationSource
import com.cleanarchitecture.domain.Location
import java.util.*

class FakeLocationSource : DeviceLocationSource {

    private val random = Random(System.currentTimeMillis())

    override fun getDeviceLocation(): Location =
        Location(random.nextDouble() * 180 - 90, random.nextDouble() * 360 - 180, Date())
}