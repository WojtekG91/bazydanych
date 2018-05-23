package pl.wojciechgalka.bazydanych.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.wojciechgalka.bazydanych.models.ServiceEntity;

public interface ServiceRepository extends CrudRepository <ServiceEntity, Integer> {
}
