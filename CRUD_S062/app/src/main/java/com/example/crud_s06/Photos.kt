package com.example.crud_s06

class Photos {
    var albumId:Int
    var id:Int
    var title:String
    var url:String
    var thumbnailUrl:String

    constructor(albumId: Int, id: Int, title: String, url: String, thumbnailUrl: String) {
        this.albumId = albumId
        this.id = id
        this.title = title
        this.url = url
        this.thumbnailUrl = thumbnailUrl
    }

    /*
        {
        "albumId": 1,
        "id": 1,
        "title": "accusamus beatae ad facilis cum similique qui sunt",
        "url": "https://via.placeholder.com/600/92c952",
        "thumbnailUrl": "https://via.placeholder.com/150/92c952"
        }
        */
}