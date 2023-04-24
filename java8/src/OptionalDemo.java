import java.util.Arrays;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Customer customer = new Customer(101,"Venu",null, Arrays.asList("12345","34567"));

        //throws NPE
        /*Optional<String> email = Optional.of(customer.getEmail());
        System.out.println(email);*/

        //returns value else Optional.empty
        /*Optional<String> email = Optional.ofNullable(customer.getEmail());
        System.out.println(email);*/

        //return default If value not found
        /*Optional<String> email = Optional.ofNullable(customer.getEmail());
        System.out.println(email.orElse("Venu@gmail.com"));*/


        Optional<String> email = Optional.ofNullable(customer.getEmail());
        //return default value If value not found
        System.out.println(email.orElseGet(()->"venu@gmail.com"));
        //throw exception If value not found
        String result = email.orElseThrow();
        System.out.println(result);
    }
}
