package com.ykato.sample.kotlin.surface

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.SurfaceView
import android.view.View
import com.ykato.sample.kotlin.R
import android.hardware.SensorManager
import android.util.Log


class SurfaceViewActivity : AppCompatActivity(), View.OnClickListener, SensorEventListener {
    private var _mainSurfaceHolder : SampleSurfaceHolder? = null
    private var _sensorManager: SensorManager? = null

    private fun initSensor() {
        _sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    private fun setSensor() {
        _sensorManager!!.registerListener(
                this,
                _sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME)
    }

    private fun unsetSensor() {
        _sensorManager!!.unregisterListener(this)
    }

    // AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surface_view)

        initSensor()
    }

    override fun onResume() {
        super.onResume()

        val surfaceView = findViewById<SurfaceView>(R.id.surfaceView)
        surfaceView.setOnClickListener(this)
        _mainSurfaceHolder = SampleSurfaceHolder(surfaceView)

        setSensor()
    }

    override fun onPause() {
        super.onPause()
        _mainSurfaceHolder = null

        unsetSensor()
    }

    // OnClickListener
    override fun onClick(p0: View?) {
        _mainSurfaceHolder!!.jump()
    }

    // SensorEventListener
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Log.d("SurfaceViewActivity", "onAccuracyChanged")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                when {
                    event.values[1] == 0F -> _mainSurfaceHolder!!.stop()
                    event.values[1] > 0 -> _mainSurfaceHolder!!.run(true)
                    else -> _mainSurfaceHolder!!.run(false)
                }
            }
        }
    }
}
