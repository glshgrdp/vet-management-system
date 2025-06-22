import com.vet.entity.Doctor;
import com.vet.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DoctorTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void testCreateAndSaveDoctor() {
        Doctor doctor = new Doctor();
        doctor.setName("Mehmet Kaya");
        doctor.setPhone("05001112233");
        doctor.setEmail("mehmet.kaya@vetclinic.com");
        doctor.setAddress("İstanbul");
        doctor.setCity("İstanbul");

        Doctor savedDoctor = doctorRepository.save(doctor);

        assertThat(savedDoctor).isNotNull();
        assertThat(savedDoctor.getId()).isNotNull();
        assertThat(savedDoctor.getName()).isEqualTo("Mehmet Kaya");
    }
}
