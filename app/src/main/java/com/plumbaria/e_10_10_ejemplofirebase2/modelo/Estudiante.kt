package com.plumbaria.e_10_10_ejemplofirebase2.modelo

class Estudiante {
    var id: String? = null
    var nombre_completo: String? = null
    var edad: Int = 0
    var beca: String? = null

    override fun toString(): String {
        return "Estudiante: \n" +
                " dni=" + id + "\n" +
                " nombre_completo=" + nombre_completo + "\n" +
                " edad=" + edad + "\n" +
                " beca=" + beca + "\n"
    }
}