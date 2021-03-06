package org.dcsc.core.user.details;

import org.dcsc.core.navigation.NavigationBar;
import org.dcsc.core.user.DcscUser;
import org.dcsc.core.user.role.DcscRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Map;

public class DcscUserDetails extends User {
    private final DcscUser user;
    private DcscRole role;
    private Map<String, Integer> permissions;
    private NavigationBar navigationBar;

    public DcscUserDetails(DcscUser user, Collection<GrantedAuthority> authorities, DcscRole role, Map<String, Integer> permissions, NavigationBar navigationBar) {
        super(user.getUsername(), user.getPassword(), authorities);

        this.user = user;
        this.role = role;
        this.permissions = permissions;
        this.navigationBar = navigationBar;
    }

    public DcscUser getUser() {
        return user;
    }

    public Map<String, Integer> getPermissions() {
        return permissions;
    }

    public int getPermissionLevel(String category) {
        Integer access = permissions.get(category);

        return (access != null) ? access : 0;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
