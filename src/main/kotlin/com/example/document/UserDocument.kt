package com.example.document
import com.example.dto.UserCreateDto
import com.example.dto.UserDto
import nonapi.io.github.classgraph.json.Id
import org.springframework.data.mongodb.core.mapping.Document
@Document("user")
class UserDocument(
    @Id
    var id: String?,
    val color: String,
    val carName: String,
    val licencePlate: String

) {
    fun toDto() = UserDto(
        id!!,
        color,
        carName,
        licencePlate
    )
}


fun UserCreateDto.to(): UserDocument {
    return UserDocument(null, color, carName,licencePlate)
}
