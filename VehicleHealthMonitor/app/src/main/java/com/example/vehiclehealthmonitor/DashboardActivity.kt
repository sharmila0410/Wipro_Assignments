package com.example.vehiclehealthmonitor

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Observe LiveData for real-time updates
        viewModel.engineHealth.observe(this, Observer {
            // Update UI if necessary
        })

        viewModel.oilLevel.observe(this, Observer {
            // Update UI if necessary
        })

        viewModel.tirePressure.observe(this, Observer {
            // Update UI if necessary
        })
    }
}