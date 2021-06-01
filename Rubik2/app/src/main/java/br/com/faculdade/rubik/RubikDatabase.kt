package br.com.faculdade.rubik

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Disciplina:: class), version = 1)
abstract class RubikDatabase: RoomDatabase() {

    abstract fun disciplinaDao(): DisciplinaDAO

}