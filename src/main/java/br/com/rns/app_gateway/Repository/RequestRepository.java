package br.com.rns.app_gateway.Repository;

import br.com.rns.app_gateway.model.RequestDatail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RequestRepository extends MongoRepository<RequestDatail, String> {

    List<RequestDatail> findAllByUri(String uri);
}
