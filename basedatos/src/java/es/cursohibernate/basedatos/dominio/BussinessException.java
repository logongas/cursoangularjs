package es.cursohibernate.basedatos.dominio;

import java.util.ArrayList;
import java.util.List;

public class BussinessException extends Exception {

    private List<BussinessMessage> bussinessMessages = new ArrayList<>();

    public BussinessException(List<BussinessMessage> bussinessMessages) {
        this.bussinessMessages.addAll(bussinessMessages);
    }

    public BussinessException(BussinessMessage bussinessMessage) {
        this.bussinessMessages.add(bussinessMessage);
    }

    public List<BussinessMessage> getBussinessMessages() {
        return bussinessMessages;
    }
}