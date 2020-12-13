package pl.sdaacademy.covidacademyapi.states_information.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateTrackingApi;

@Service
public class StatesInformationService {

    private StateTrackingApi stateTrackingApi;

    public StatesInformationService(StateTrackingApi stateTrackingApi) {
        this.stateTrackingApi = stateTrackingApi;
    }

    public StateInformation[] getAllStatesInformation() {
        return stateTrackingApi.getAllStatesInformation();
    }


}
