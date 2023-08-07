package shoppy.hexagramme.com.shoppy;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Every method in the controller class returns a domain object as actual JSON, rather than a view, using this notation
@RestController
public class GreetingController {
    //template is used as a format for the greeting method's string response
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //GetMapping annotation ensures that HTTP GET (mapping type -> request type, i.e., GetMapping is for GET requests) requests to /greeting are mapped to the greeting() method
    @GetMapping("/greeting")
    //@RequestParam binds the value of the query string parameter "name" into the greeting (defaultValue is used in the event there is no name)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
