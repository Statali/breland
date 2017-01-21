package org.server.localshop.exception;

public class ImageNotFoundException extends AbstractPlatformResourceNotFoundException {

    public ImageNotFoundException(final String resource, final Long resourceId) {
        super("error.msg.entity.image.invalid", "Image for resource " + resource + " with Identifier " + resourceId + " does not exist",
                resource, resourceId);
    }
}
