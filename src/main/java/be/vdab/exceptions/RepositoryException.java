package be.vdab.exceptions;

public class RepositoryException extends RuntimeException {
    public RepositoryException (Exception oorzaak) {
        super(oorzaak);
    }
}
