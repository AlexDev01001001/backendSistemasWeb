package com.odontologos.odonto.repositories;
import com.odontologos.odonto.models.Tratamiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Integer> {
    List<Tratamiento> findBySeguimientoId(Integer idSeguimiento);
}
