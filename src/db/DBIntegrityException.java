package db;

public class DBIntegrityException extends RuntimeException{

	/**
	 * Serial verion UID.
	 */
	private static final long serialVersionUID = 1L;

	public DBIntegrityException( String msg ) {
		super( msg );
	}
	
}
