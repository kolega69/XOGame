package net;


public interface InterTCP {

    void sendCoord(String coordinates) throws Exception;

    String receiveCoord() throws Exception;

}
