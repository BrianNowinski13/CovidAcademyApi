package pl.sdaacademy.covidacademyapi.states_information.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatesMetadataDbRepository extends JpaRepository<StateInformation, String> {

    Optional<StateInformation> findByNameIgnoreCase(String name);

}
