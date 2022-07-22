package giank.com.webfluxmongocrud.service.generic;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericService<T> {

    Mono<T> create(T t);

    Flux<T> findAll();

    Mono<T> findById(String id);

    Mono<T> update(T t);

    Mono<Boolean> delete(String t);
}
