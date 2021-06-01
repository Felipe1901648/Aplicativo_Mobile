package br.com.faculdade.rubik

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DisciplinaDAO {

    @Query("select * from Disciplina where id = :id")
    fun getById(id: Long): Disciplina?

    @Query("select * from Disciplina")
    fun findAll(): List<Disciplina>

    @Insert
    fun insert(disciplina: Disciplina)

    @Delete
    fun delete(disciplina: Disciplina)

}