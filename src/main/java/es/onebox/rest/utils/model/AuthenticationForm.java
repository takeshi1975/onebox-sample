package es.onebox.rest.utils.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Bean that stores authentication parameters
 *
 * @author Oreste Luci
 */
public class AuthenticationForm {

    @NotNull
    @Size(min = 5,max = 255, message="{error.validation.authentication.user}")
    private String user;

    @NotNull
    @Size(min = 1,max = 255, message="{error.validation.authentication.terminal}")
    private String terminal;

    @NotNull
    @Size(min = 1,max = 255, message="{error.validation.authentication.channelId}")
    private String channelId;

    @NotNull
    @Size(min = 1,max = 255, message="{error.validation.authentication.pos}")
    private String pos;

    @NotNull
    @Size(min = 18,max = 255, message="{error.validation.authentication.license}")
    private String license;

    @NotNull
    @Size(min = 5,max = 255, message="{error.validation.authentication.password}")
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        StringBuffer output = new StringBuffer("\n");

        output.append("user").append(user).append("\n");
        output.append("terminal").append(terminal).append("\n");
        output.append("channelId").append(channelId).append("\n");
        output.append("license").append(license).append("\n");
        output.append("password").append(password).append("\n");

        return output.toString();
    }
}
