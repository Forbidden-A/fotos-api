package dev.forb.fotos.api.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false, unique = true, length = 64)
    var email: String,
    @Column(nullable = false, unique = true, length = 16)
     var username: String,
    @Column(nullable = false, unique = true, length = 64)
     var password: String
)
