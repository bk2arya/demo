package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Rates;

public interface RatesRepo extends CrudRepository<Rates, Integer> {

}
