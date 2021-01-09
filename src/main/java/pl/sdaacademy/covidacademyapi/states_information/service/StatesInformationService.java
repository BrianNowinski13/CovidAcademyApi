package pl.sdaacademy.covidacademyapi.states_information.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateTrackingApi;
import pl.sdaacademy.covidacademyapi.states_information.repository.StatesMetadataDbRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StatesInformationService {

    private final StateTrackingApi stateTrackingApi;
    private final StatesMetadataDbRepository statesMetadataDbRepository;

    public StatesInformationService(StateTrackingApi stateTrackingApi, StatesMetadataDbRepository statesMetadataDbRepository) {
        this.stateTrackingApi = stateTrackingApi;
        this.statesMetadataDbRepository = statesMetadataDbRepository;
    }

    public List<StateInformation> getAllStatesInformation() {
        if (statesMetadataDbRepository.count() > 0) {
            return statesMetadataDbRepository.findAll();
        }

        return fetchMetadata();
    }

    private List<StateInformation> fetchMetadata() {
        List<StateInformation> stateInformation = Arrays.asList(stateTrackingApi.getAllStatesInformation());
        return statesMetadataDbRepository.saveAll(stateInformation);
    }

    public Optional<StateInformation> getStateByName(String name) {

        if (statesMetadataDbRepository.count() == 0) {
            fetchMetadata();
        }
        return statesMetadataDbRepository.findByNameIgnoreCase(name);
    }

    public Optional<StateInformation> getStateById(String id) {
        if(statesMetadataDbRepository.count() == 0) {
            fetchMetadata();
        }
        return statesMetadataDbRepository.findById(id);
    }

}
