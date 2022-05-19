package com.cleanarchitecture.usecases

import com.cleanarchitecture.data.LocationsRepository
import com.cleanarchitecture.domain.Location

class GetLocations(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.getSavedLocations()

}
