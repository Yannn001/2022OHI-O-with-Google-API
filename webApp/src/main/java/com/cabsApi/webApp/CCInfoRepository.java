package com.cabsApi.webApp;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CCInfoRepository extends MongoRepository<CCDailyStore, String> {
}
