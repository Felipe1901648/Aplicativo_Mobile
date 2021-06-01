package br.com.faculdade.rubik

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: RubikDatabase

    init {
        val context = RubikApplication.get_instance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            RubikDatabase:: class.java,
            "rubik.sqlite"
        ).build()
    }
    fun  getDisciplinaDAO(): DisciplinaDAO{
        return dbInstance.disciplinaDao()
    }
}