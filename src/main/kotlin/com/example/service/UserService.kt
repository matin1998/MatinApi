package com.example.service
import com.example.document.to
import com.example.dto.UserCreateDto
import com.example.dto.UserDto
import com.example.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired
constructor(
        private val userRepository:UserRepository
) {
    fun save(t:UserCreateDto):UserDto {
        return userRepository.save(t.to()).toDto()
    }

    fun get(id: String): UserDto? {
            val user = userRepository.findById(id)
    return if (user.isPresent) {
        user.get().toDto()
    } else {
        null
    }
    }
    fun delete(id: String) {
        userRepository.deleteById(id)

    }
    fun getAll(): List<UserDto>? {
        return userRepository.findAll().map { it.toDto() }
    }
}
