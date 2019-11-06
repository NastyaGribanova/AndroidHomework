package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: SerialAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = SerialAdapter(getDataSource()) { name, duration, description, image, _ ->
            navigateToSerialActivity(name, duration, description, image)
        }

        rv_serials.adapter = adapter
    }

    private fun navigateToSerialActivity(
        name: String,
        director: String,
        description: String,
        image: Int) {
        startActivity(SerialActivity.createIntent(this, name, director, description, image))
    }

    private fun getDataSource(): ArrayList<Serial> = arrayListOf(
        Serial("How I met your mother", "208 episodes", "Comedy", R.drawable.img1),
        Serial("Game Of Thrones", "73 episodes", "Fantasy, book adaptation", R.drawable.img2),
        Serial("Hannibal", "39 episodes", "Detective, horror", R.drawable.img3),
        Serial("Friends", "236 episodes", "Sitcom", R.drawable.img4),
        Serial("Chernobyl", "5 episodes", "Documentary", R.drawable.img5),
        Serial("11.22.63", "8 episodes", "Book adaptation, Stiven King", R.drawable.img6),
        Serial("Hazbin Hotel", "2 episodes", "Cartoon, comedy", R.drawable.img7),
        Serial("The end of the F.ing World", "12 episodes", "Romantic, Drama", R.drawable.img8),
        Serial("Black Mirror", "21 episodes", "Sci-Fi & Fantasy", R.drawable.img9),
        Serial("Love, Death & Robots", "18 episodes", "Animation", R.drawable.img10),
        Serial("Doctor Who", "137episodes", "Sci-Fi", R.drawable.img11),
        Serial("Lucifer", "67 episodes", "Supernatural", R.drawable.img12),
        Serial("Sherlock", "12 episodes", "Detective", R.drawable.img13),
        Serial("Supernatural", "309 episodes", "Supernatural", R.drawable.img14),
        Serial("BoJack Horseman", "68 episodes", "Drama", R.drawable.img15),
        Serial("Mr. Robot", "37 episodes", "Thriller", R.drawable.img16),
        Serial("We Bare Bears", "138 episodes", "Cartoon", R.drawable.img17),
        Serial("Castlevania", "12 episodes", "Horror", R.drawable.img18)
    )
}
