package com.cleanarchitecture.usecases

import com.cleanarchitecture.data.LocationsRepository
import com.cleanarchitecture.domain.Location

class RequestNewLocation(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.requestNewLocation()

}
