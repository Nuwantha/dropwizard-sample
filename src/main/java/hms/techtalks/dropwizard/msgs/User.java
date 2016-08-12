package hms.techtalks.dropwizard.msgs;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.hibernate.validator.constraints.NotBlank;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandarenu on 8/10/16.
 */
public class User {

    private String userId;
    @NotBlank
    private String userName;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    private String address;

    @InjectLinks({
            @InjectLink(value = "/user/${instance.userId}", rel = "self")
    })
    @JsonProperty
    List<Link> links = new ArrayList<Link>();

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
