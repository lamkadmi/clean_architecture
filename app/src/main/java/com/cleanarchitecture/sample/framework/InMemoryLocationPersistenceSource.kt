package com.cleanarchitecture.sample.framework

import com.cleanarchitecture.data.LocationPersistenceSource
import com.cleanarchitecture.domain.Location

class InMemoryLocationPersistenceSource : LocationPersistenceSource {

    private var locations: List<Location> = emptyList()

    override fun getPersistedLocations(): List<Location> = locations

    override fun saveNewLocation(location: Location) {
        locations = locations + location
    }
}