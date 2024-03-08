package lk.acpt.pharmacy.repo;

import lk.acpt.pharmacy.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine,Integer> {
}
