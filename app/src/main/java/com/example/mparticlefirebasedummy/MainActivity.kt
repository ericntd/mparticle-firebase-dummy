package com.example.mparticlefirebasedummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mparticle.MPEvent
import com.mparticle.MParticle
import com.mparticle.MParticleOptions
import com.mparticle.identity.IdentityApiRequest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request: IdentityApiRequest = IdentityApiRequest.withEmptyUser().build()

        val options: MParticleOptions = MParticleOptions.builder(this)
            .credentials(
                "",
                ""
            )
            .logLevel(MParticle.LogLevel.DEBUG)
            .identify(request)
            .environment(MParticle.Environment.Production)
            .build()

        MParticle.start(options)
    }

    override fun onResume() {
        super.onResume()
        MParticle.getInstance()?.logEvent(MPEvent.Builder("My Dummy Event").build())
    }
}