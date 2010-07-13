package org.joget.workflow.security;

import org.joget.commons.util.LogUtil;
import org.joget.directory.model.Role;
import org.joget.directory.model.User;
import org.joget.directory.model.service.DirectoryManager;
import org.joget.workflow.util.WorkflowUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;

class WorkflowUserDetails implements UserDetails {

    private User user;

    public WorkflowUserDetails(User user) {
        super();
        this.user = user;
    }

    public GrantedAuthority[] getAuthorities() {
        try {
            ApplicationContext appContext = WorkflowUtil.getApplicationContext();
            DirectoryManager directoryManager = (DirectoryManager) appContext.getBean("directoryManager");
            Collection<Role> roles = directoryManager.getUserRoles(user.getUsername());
            List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();

            for (Role role : roles) {
                GrantedAuthorityImpl ga = new GrantedAuthorityImpl(role.getId());
                gaList.add(ga);
            }

            return gaList.toArray(new GrantedAuthority[gaList.size()]);
        } catch (Exception ex) {
            LogUtil.error(getClass().getName(), ex, "");
            return new GrantedAuthority[]{};
        }
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return user.getActive() == 1;
    }
}
