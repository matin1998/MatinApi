package com.example.controller
import com.example.annotation.ApiMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.*
import com.example.service.UserService
import com.example.dto.UserCreateDto
import com.example.dto.UserDto
import com.example.mogodb.TenantContext
@ApiMapping
class RestApiController @Autowired constructor(
    private val userService: UserService
){
    @GetMapping("user/{tenant}")
    fun get(@RequestParam tenant: String): ResponseEntity<List<UserDto>> {
    TenantContext.setCurrentTenant(tenant)
    return ResponseEntity(userService.getAll(), HttpStatus.OK)
}

    @PostMapping("user/adding")
    fun save(@RequestParam tenant: String, @RequestBody create: UserCreateDto): ResponseEntity<UserDto> {
        TenantContext.setCurrentTenant(tenant)
        return ResponseEntity(userService.save(create), HttpStatus.CREATED)
    }

    @GetMapping("user/getting/{id}")
    fun save(@RequestParam tenant: String, @PathVariable id: String): ResponseEntity<UserDto> {
        val user = userService.get(id)
        TenantContext.setCurrentTenant(tenant)
        return if (user == null) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity(user, HttpStatus.OK)
        }
    }

    @GetMapping("user/deleting/{id}")
    fun delete(@RequestParam tenant: String, @PathVariable id: String){
        TenantContext.setCurrentTenant(tenant)
        val user=userService.get(id)
        if(user==null){
            ResponseEntity("Data Not found",HttpStatus.NOT_FOUND)
        }
        else {
            userService.delete(id)
            ResponseEntity("completely deleted!", HttpStatus.OK)
        }
    }
}