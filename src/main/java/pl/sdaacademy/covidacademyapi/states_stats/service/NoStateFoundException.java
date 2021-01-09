package pl.sdaacademy.covidacademyapi.states_stats.service;

public class NoStateFoundException extends RuntimeException {

    public NoStateFoundException(String stateName) {
        super(String.format("No state: %s found !",stateName));
    }
}
