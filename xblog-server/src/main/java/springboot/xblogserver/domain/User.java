package springboot.xblogserver.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CHY
 * @date 2020/3/23 20:45
 * 用户实体类
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private Integer gender;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private Timestamp regTime;
    @Getter
    @Setter
    private Timestamp updTime;
    @Setter
    private Integer enabled;
    @Getter
    @Setter
    private List<Role> roles;

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
