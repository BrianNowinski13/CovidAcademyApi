package pl.sdaacademy.covidacademyapi.states_information.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatesMetadataDbRepository extends JpaRepository<StateInformation, String> {

}
