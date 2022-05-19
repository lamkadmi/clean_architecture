package com.cleanarchitecture.sample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cleanarchitecture.sample.R
import com.cleanarchitecture.sample.framework.FakeLocationSource
import com.cleanarchitecture.sample.framework.InMemoryLocationPersistenceSource
import com.cleanarchitecture.data.LocationsRepository
import com.cleanarchitecture.usecases.GetLocations
import com.cleanarchitecture.usecases.RequestNewLocation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private val locationsAdapter = LocationsAdapter()
    private val presenter: MainPresenter

    init {
        // This would be done by a dependency injector in a complex App
        val persistence = InMemoryLocationPersistenceSource()
        val deviceLocation = FakeLocationSource()
        val locationsRepository = LocationsRepository(persistence, deviceLocation)
        presenter = MainPresenter(
            this,
            GetLocations(locationsRepository),
            RequestNewLocation(locationsRepository)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.adapter = locationsAdapter

        newLocationBtn.setOnClickListener { presenter.newLocationClicked() }

        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun renderLocations(locations: List<Location>) {
        locationsAdapter.items = locations
    }
}