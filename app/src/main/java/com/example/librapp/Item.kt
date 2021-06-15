package com.example.librapp

data class Item(val titolo: String, val autore: String, val genere: String, val tipologia: String, val descrizione: String){
    constructor():this("","","","","")

    override fun toString(): String {
        return "Item(titolo='$titolo', autore='$autore', genere='$genere', tipologia='$tipologia', descrizione='$descrizione')"
    }


}

