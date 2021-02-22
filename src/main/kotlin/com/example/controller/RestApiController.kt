package com.example.controller
import com.example.annotation.ApiMapping
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.*

@ApiMapping
class RestApiController {
    @GetMapping("rest")
    fun get(): ResponseEntity<String> {
        return ResponseEntity("hello world", HttpStatus.OK)
    }

    @PostMapping("rest/{gam}")
    fun post(
        @PathVariable gam:Int,
        @RequestParam shoru:Int
    )
    : ResponseEntity<String> {
        val b = IntArray(20)
        val stringArray: Array<String?> = arrayOfNulls(b.size)
        for (i in b.indices) {
            b[i] = 1
        }
        for (i in 0..1) {
            var k = 0

            val a = gam
            if (i == 0) {
                var j = shoru
                while (j < 20) {
                    b[j] = 0
                    j += a
                }
            }
            if (i == 1) {
                for (j in 0..19) {
                    if (b[j] == 1) {k += 1}
                    if (k == 0 || k % a == 0) {
                        b[j] = 0
                    }
                }
            }
            for (j in 0..19) stringArray[j] = b[j].toString()

        }
        return ResponseEntity(stringArray.contentToString(),HttpStatus.CREATED)
    }
}