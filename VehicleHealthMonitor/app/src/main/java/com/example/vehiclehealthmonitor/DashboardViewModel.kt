package com.example.vehiclehealthmonitor

class DashboardViewModel : ViewModel() {
    val engineHealth = MutableLiveData<Float>()
    val oilLevel = MutableLiveData<Float>()
    val tirePressure = MutableLiveData<Float>()

    init {
        // Initialize with default or fetched values
        engineHealth.value = 100f
        oilLevel.value = 75f
        tirePressure.value = 32f
    }

    fun reportIssue() {
        // Implement issue reporting logic
    }

    fun requestMaintenance() {
        // Implement maintenance request logic
    }

    fun goToSettings() {
        // Navigate to settings
    }
}