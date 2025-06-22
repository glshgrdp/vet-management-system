import com.vet.entity.Customer;
import com.vet.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateAndSaveCustomer() {
        Customer customer = Customer.builder()
                .name("Gülşah Yılmaz")
                .phone("05554443322")
                .email("gulsah@example.com")
                .address("İstanbul")
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isNotNull();
        assertThat(savedCustomer.getName()).isEqualTo("Gülşah Yılmaz");
    }
}
