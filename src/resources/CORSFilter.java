package resources;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

@Provider
public class CORSFilter implements ContainerResponseFilter {

	@Override
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
		ResponseBuilder respBuilder = Response.fromResponse(response.getResponse());
		respBuilder.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS")
        .header("Access-Control-Max-Age", "151200")
        .header("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
		
		String reqHeader = request.getHeaderValue("Access-Control-Request-Headers");
		
		if(reqHeader != null && !reqHeader.equals(null)){
			respBuilder.header("Access-Control-Allow-Headers", reqHeader);
		}
		
		response.setResponse(respBuilder.build());
//		response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
//        response.getHttpHeaders().add("Access-Control-Allow-Headers",
//                "origin, content-type, accept, authorization");
//        response.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
//        response.getHttpHeaders().add("Access-Control-Allow-Methods",
//                "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        return response;
	}

}
