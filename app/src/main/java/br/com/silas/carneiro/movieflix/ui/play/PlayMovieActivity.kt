package br.com.silas.carneiro.movieflix.ui.play

import android.os.Bundle
import android.widget.Toast
import br.com.silas.carneiro.movieflix.R
import kotlinx.android.synthetic.main.activity_play_movie.*
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.VIDEO_ID
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class PlayMovieActivity : YouTubeBaseActivity(),  YouTubePlayer.OnInitializedListener {

    private var idVideo: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_movie)

        idVideo = intent.extras?.getString(VIDEO_ID)
        playerVideo.initialize(idVideo, this)
    }

    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
        p1?.setFullscreen(true)
        p1?.setShowFullscreenButton(false)
        if(!p2){
            p1?.loadVideo(idVideo)
        }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        Toast.makeText(this, getString(R.string.error_open_movie), Toast.LENGTH_SHORT).show()
    }
}
