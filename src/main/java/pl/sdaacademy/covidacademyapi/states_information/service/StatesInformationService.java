package pl.sdaacademy.covidacademyapi.states_information.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateTrackingApi;
import pl.sdaacademy.covidacademyapi.states_information.repository.StatesMetadataDbRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class StatesInformationService {

    private final StateTrackingApi stateTrackingApi;
    private final StatesMetadataDbRepository statesMetadataDbRepository;

    public StatesInformationService(StateTrackingApi stateTrackingApi, StatesMetadataDbRepository statesMetadataDbRepository) {
        this.stateTrackingApi = stateTrackingApi;
        this.statesMetadataDbRepository = statesMetadataDbRepository;
    }

    public List<StateInformation> getAllStatesInformation() {
        if(statesMetadataDbRepository.count() > 0) {
            return statesMetadataDbRepository.findAll();
        }
        List<StateInformation> stateInformation = Arrays.asList(stateTrackingApi.getAllStatesInformation());
        return statesMetadataDbRepository.saveAll(stateInformation);
    }


}
