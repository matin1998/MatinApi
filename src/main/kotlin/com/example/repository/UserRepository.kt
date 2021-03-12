package com.example.repository

import com.example.document.UserDocument
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.repository.MongoRepository

@Repository
interface UserRepository : MongoRepository<UserDocument, String>


