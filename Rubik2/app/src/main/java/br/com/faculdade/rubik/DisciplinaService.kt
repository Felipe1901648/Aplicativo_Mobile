package br.com.faculdade.rubik

import android.content.Context

object DisciplinaService {

    fun getDisciplinas (context: Context): List<Disciplina> {
        val disciplinas = mutableListOf<Disciplina>()
        // criar 10 disciplinas
        for (i in 1..5) {
            val d = Disciplina()
            d.nome = "Produto $i"
            d.ementa = "Ementa Disciplina $i"
            d.professor = "Professor Disciplina $i"
            d.foto = "https://saolucasassessoria.com.br/wp-content/uploads/2019/02/loja-de-autopeca-min.png"
            disciplinas.add(d)
        }
        return disciplinas
    }
}