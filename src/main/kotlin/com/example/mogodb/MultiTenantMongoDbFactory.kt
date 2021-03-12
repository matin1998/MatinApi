package com.example.mogodb

import com.example.mogodb.TenantContext
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory

class MultiTenantMongoDbFactory(
    mongoClient: MongoClient,
    dbName: String
) : SimpleMongoClientDbFactory(mongoClient, dbName) {
   /* private val defaultDB = "test"

    override fun getMongoDatabase(): MongoDatabase {
        return super.getMongoDatabase(defaultDB)
    }

    */
   override fun getMongoDatabase(): MongoDatabase {
       var tenant = TenantContext.getCurrentTenant()
       if (tenant == null)
           tenant = "matin"
       return getMongoDatabase(tenant)
   }
}