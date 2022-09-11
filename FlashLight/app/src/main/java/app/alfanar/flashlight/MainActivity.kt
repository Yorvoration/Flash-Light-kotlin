package app.alfanar.flashlight

import android.content.Context
import android.hardware.camera2.CameraManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        var flashLightStatus = false
        val imgclick = findViewById<ImageView>(R.id.imgclick)

        imgclick.setOnClickListener {
            val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            val cameraId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraId, !flashLightStatus)
            flashLightStatus = !flashLightStatus
            if (flashLightStatus) {
                imgclick.setImageResource(R.drawable.flashon)
            } else {
                imgclick.setImageResource(R.drawable.flashoff)
            }
        }
    }
}