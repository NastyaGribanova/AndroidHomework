package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: SongAdapter? = null
    var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.song_1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = SongAdapter(SongRepository.songsList()) {Song ->
        navigateToSongActivity(Song)
        }
        rv_songs.adapter = adapter
        mediaPlayer.start()
    }

    private fun navigateToSongActivity(
        song: Song) {
        startActivity(SongActivity.createIntent(this, song))
    }
}
