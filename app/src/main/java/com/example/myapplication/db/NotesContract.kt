package com.example.myapplication.db

class NotesContract {

    interface ACTION {
        companion object {
            const val ADD_ACTION = "add"
            const val UPDATE_ACTION = "update"
        }
    }

    interface DATA {
        companion object {
            const val ARG_ACTION = "action"
            const val ARG_ID = "id"
            const val ARG_TITLE = "title"
            const val ARG_DESCRIPTION = "description"
            const val ARG_LONGITUDE = "longitude"
            const val ARG_LATITUDE = "latitude"
        }
    }
}
