package pl.sdaacademy.covidacademyapi.states_stats.service;

import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;

public class StateStatsDTO {

    private StateInformation stateInformation;
    private int positive;
    private int negative;
    private int deathConfirmed;
    private int recovered;

    public StateInformation getStateInformation() {
        return stateInformation;
    }

    public void setStateInformation(StateInformation stateInformation) {
        this.stateInformation = stateInformation;
    }

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public int getDeathConfirmed() {
        return deathConfirmed;
    }

    public void setDeathConfirmed(int deathConfirmed) {
        this.deathConfirmed = deathConfirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }
}
