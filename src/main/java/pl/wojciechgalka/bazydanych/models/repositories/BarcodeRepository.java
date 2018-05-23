package pl.wojciechgalka.bazydanych.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wojciechgalka.bazydanych.models.BarcodeEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BarcodeRepository extends CrudRepository <BarcodeEntity, Integer> {
    List<BarcodeEntity> findAll();
    List<BarcodeEntity> findAllByBarcodeContainsAndBarcodeContainsAndWeightGreaterThan(String s, String k, Integer i);
    List<BarcodeEntity> findAllByProductCompanyContains(String slowo);
    List<BarcodeEntity> findAllByProductNameContains(String slowo);
}
