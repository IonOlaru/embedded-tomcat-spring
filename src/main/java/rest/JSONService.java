package rest;

import main.Main;
import services.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Ion Olaru
 *         Date: 2014/02/10 - 21:18
 */
@Path("/all")
public class JSONService {

        @GET
    	@Path("/get")
    	@Produces(MediaType.APPLICATION_JSON)
    	public List getTrackInJSON() {
            return Services.getTMService().loadAll();
        }
}
