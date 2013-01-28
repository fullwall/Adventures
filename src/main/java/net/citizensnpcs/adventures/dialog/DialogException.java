package net.citizensnpcs.adventures.dialog;


public class DialogException extends RuntimeException {
    public DialogException(Exception e) {
        super(e);
    }

    public DialogException(String message) {
        super(message);
    }

    private static final long serialVersionUID = -1956115943827294194L;
}
