package org.server.localshop.api;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.server.localshop.documentmanagment.ContentRepositoryUtils;
import org.server.localshop.documentmanagment.ImageData;
import org.server.localshop.exception.ImageNotFoundException;
import org.server.localshop.services.ImageReadPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lowagie.text.pdf.codec.Base64;

@Path("/image")
@Component
@Scope("singleton")
public class ImageApiResource {

	
		final   ImageReadPlatformService imageReadPlatformService;
		
		@Autowired
		public ImageApiResource (final  ImageReadPlatformService imageReadPlatformService){
			this.imageReadPlatformService = imageReadPlatformService;
		}
	
	
	
	
	@GET
	 @Consumes({ MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN })
	public Response retrieveTradeLogo(@Context final UriInfo uriInfo) throws NumberFormatException, ImageNotFoundException {
   	final ImageData imageData = this.imageReadPlatformService.retrieveTradeLogo(Long.parseLong(uriInfo.getQueryParameters().get("sellerId").get(0)));

       // TODO: Need a better way of determining image type
       String imageDataURISuffix = ContentRepositoryUtils.IMAGE_DATA_URI_SUFFIX.JPEG.getValue();
       if (StringUtils.endsWith(imageData.location(), ContentRepositoryUtils.IMAGE_FILE_EXTENSION.GIF.getValue())) {
           imageDataURISuffix = ContentRepositoryUtils.IMAGE_DATA_URI_SUFFIX.GIF.getValue();
       } else if (StringUtils.endsWith(imageData.location(), ContentRepositoryUtils.IMAGE_FILE_EXTENSION.PNG.getValue())) {
           imageDataURISuffix = ContentRepositoryUtils.IMAGE_DATA_URI_SUFFIX.PNG.getValue();
       }

       final String clientImageAsBase64Text = imageDataURISuffix + Base64.encodeBytes(imageData.getContentOfSize(Integer.parseInt(uriInfo.getQueryParameters().get("maxWidth").get(0)), null));
       return Response.ok(clientImageAsBase64Text).build();
	}
}
