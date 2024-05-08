package com.example.appsuperzound

class Album {
    var idAlbum:Int
    var strAlbum:String
    var strArtist:String
    var strAlbumThumb:String
    var intYearReleased:Int
    var intScore:Float

    constructor(
        idAlbum: Int,
        strAlbum: String,
        strArtist: String,
        strAlbumThumb: String,
        intYearReleased: Int,
        intScore: Float
    ) {
        this.idAlbum = idAlbum
        this.strAlbum = strAlbum
        this.strArtist = strArtist
        this.strAlbumThumb = strAlbumThumb
        this.intYearReleased = intYearReleased
        this.intScore = intScore
    }
    fun getAlbumId():Int{
        return idAlbum
    }

    fun getAlbum():String{
        return strAlbum
    }
    fun getArtist():String{
        return strArtist
    }
    fun getAlbumThumb():String{
        return strAlbumThumb
    }
    fun getYearReleased():Int{
        return intYearReleased
    }
    fun getScore():Float{
        return intScore
    }


    /*
    Nombre del álbum (strAlbum)
    Artista del álbum (strArtist)
    Imagen del álbum (strAlbumThumb)
    Año de lanzamiento (intYearReleased)
    Puntaje del álbum (intScore)
    El puntaje del álbum debe mostrarse con el control ratingbar o similar.
    */
}