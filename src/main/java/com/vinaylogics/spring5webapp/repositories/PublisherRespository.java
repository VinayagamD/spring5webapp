package com.vinaylogics.spring5webapp.repositories;

import com.vinaylogics.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRespository extends CrudRepository<Publisher,Long> {
}
