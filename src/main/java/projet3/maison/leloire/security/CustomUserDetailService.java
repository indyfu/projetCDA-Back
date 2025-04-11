package projet3.maison.leloire.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import projet3.maison.leloire.repository.UserRepository;


@Component
public class CustomUserDetailService implements UserDetailsService {
    /*
    Injecté par son mutateur
     */
    private UserRepository userDao;



    //  Méthodes  //
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userDao.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable : " + login));
    }


    //  Mutateur  //
    @Autowired
    public void setUserDao(UserRepository userDao) {
        this.userDao = userDao;
    }
}
