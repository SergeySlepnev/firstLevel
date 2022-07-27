package regex.model;

import regex.utils.RandomUtils;

public class IncomingCall {

    private final String phoneNumber;

    public IncomingCall() {
        this.phoneNumber = RandomUtils.randomPhoneNumber();
    }

    public String phoneNumber() {
        return phoneNumber;
    }
}