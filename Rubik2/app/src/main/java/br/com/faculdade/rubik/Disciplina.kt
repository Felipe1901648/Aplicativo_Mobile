package br.com.faculdade.rubik

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable


@Entity(tableName= "Disciplina")
class Disciplina : Serializable {

    @PrimaryKey
    var id:Long? = null
    var nome = ""
    var ementa = ""
    var foto = ""
    var professor = ""

    override fun toString(): String {
        return "Disciplina(nome='$nome')"
    }

    fun toJson(): String{
        return GsonBuilder().create().toJson(this)
    }
}