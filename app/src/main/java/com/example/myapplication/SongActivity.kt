package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_song.*

class SongActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)
        tv_name_song.text =
            "Name: " + intent?.extras?.getString(KEY_SONG_NAME) ?: "DEFAULT NAME"
        tv_description_song.text =
            "Description:" + intent?.extras?.getString(KEY_SONG_BAND) + " " +
                    intent?.extras?.getString(KEY_SONG_ALBUM) ?: "DEFAULT NAME"
        iv_song.setImageResource(intent?.extras?.getInt(KEY_SONG_COVER) ?: 1)
    }

    companion object {
        private const val KEY_SONG_NAME = "name"
        private const val KEY_SONG_BAND = "band"
        private const val KEY_SONG_ALBUM = "album"
        private const val KEY_SONG_COVER = "cover"
        private const val KEY_SONG_AUDIO = "audio"

        fun createIntent(
            activity: Activity,
            song: Song
        ) = Intent(activity, SongActivity::class.java).apply {
            putExtra(KEY_SONG_NAME, song.name)
            putExtra(KEY_SONG_BAND, song.band)
            putExtra(KEY_SONG_ALBUM, song.album)
            putExtra(KEY_SONG_COVER, song.cover)
            putExtra(KEY_SONG_AUDIO, song.audio)
        }
    }
}
