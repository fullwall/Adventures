package net.citizensnpcs.adventures.dialog;


public class DialogException extends RuntimeException {
    public DialogException(String message) {
        super(message);
    }

    public DialogException(Exception e) {
        super(e);
    }

    private static final long serialVersionUID = -1956115943827294194L;
}
