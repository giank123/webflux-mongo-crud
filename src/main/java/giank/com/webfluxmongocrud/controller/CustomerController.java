package giank.com.webfluxmongocrud.controller;

import giank.com.webfluxmongocrud.entity.Customer;
import giank.com.webfluxmongocrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/healthcheck")
    public String getHealthCheck(){
        return "{ \"todoOk\" : true }";
    }

    @GetMapping("/list")
    public Flux<Customer> list(){
        return customerService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<ResponseEntity<Customer>> findById(@PathVariable String id){
        return customerService.findById(id)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<Customer>> create(@RequestBody Customer customer){
        return customerService.create(customer)
                .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(customer, HttpStatus.NOT_ACCEPTABLE));
    }

    @PutMapping("/update/{idCustomer}")
    public Mono<ResponseEntity<Customer>> update(@RequestBody Customer customer,
                                                 @PathVariable String idCustomer) {
        return customerService.findById(idCustomer)
                .flatMap(contact1 -> {
                    customer.set_id(contact1.get_id());
                    return customerService.create(customer)
                            .map(contact2 -> new ResponseEntity<>(contact2, HttpStatus.ACCEPTED));
                }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> delete(@PathVariable String id) {
        return customerService.delete(id)
                .filter(deleteCustomer -> deleteCustomer)
                .map(deleteCustomer -> new ResponseEntity<>("{ \"Customer deleted\" : true }", HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>("{ \"Customer deleted\" : false }",HttpStatus.NOT_FOUND));
    }
}
