package com.example.myapplication

object SongRepository {
    fun songsList(): List<Song> = arrayListOf(
        Song("Whatever it takes", "Imagine Dragons", "Origins", R.drawable.song_1 , R.raw.song_1),
        Song("Все как у людей", "Noize MC", "Без меня", R.drawable.song_2, R.raw.song_2),
        Song("Почитай старших", "Noize MC", "Почитай старших", R.drawable.song_3 , R.raw.song_3),
        Song("The Greatest Show", "Panic! At The Disco", "The Greatest Show", R.drawable.song_4 , R.raw.song_4),
        Song("High Hopes", "Panic! At The Disco", "Pray for the Wicked", R.drawable.song_5 , R.raw.song_5),
        Song("Judgement Day", "Stealth", "Judgement Day", R.drawable.song_6 , R.raw.song_6)
    )
}
