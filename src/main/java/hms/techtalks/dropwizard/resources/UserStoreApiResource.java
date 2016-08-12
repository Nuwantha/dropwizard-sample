package hms.techtalks.dropwizard.resources;

import com.codahale.metrics.annotation.Metered;
import hms.techtalks.dropwizard.error.UserApiException;
import hms.techtalks.dropwizard.msgs.User;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.Map;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserStoreApiResource {

    @Context
    private UriInfo uriInfo;

    private Map<String, User> userStore = new HashMap<>();


    @GET
    @Path("/{userId}")
    @Metered
    public User getUser(@PathParam("userId") String userId) throws UserApiException {

        User savedUser = userStore.get(userId);
        if(savedUser != null){
            return savedUser;
        } else {
            throw new UserApiException(UserApiException.ErrorType.NotFound, "User Not Found");
        }
//        User user = new User(userId);
//        user.setFirstName("Harry");
//        user.setLastName("Potter");
//        user.setUserName("potter");
//        user.setAddress("The Cupboard Under the Stairs, No:4, Privet Drive, Little Whinging, Surrey");
//
//        return user;
    }

    @POST
    public User createUser(@Valid User user){
        user.setUserId(String.valueOf(System.currentTimeMillis()));
        userStore.put(user.getUserId(), user);

        return user;
    }


}
