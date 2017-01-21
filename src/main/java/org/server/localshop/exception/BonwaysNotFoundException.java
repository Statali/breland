package org.server.localshop.exception;




public class BonwaysNotFoundException extends AbstractPlatformResourceNotFoundException {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BonwaysNotFoundException(final String resource, final Long resourceId) {
        super("error.msg.entity.seller.invalid "+ resource + " with.Identifier " + resourceId + " does.not.exist",
                resource, resourceId);
    }
	
	
}
