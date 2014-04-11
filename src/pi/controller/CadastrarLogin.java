package pi.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;
import pi.dao.DaoLogin;
import pi.model.ModelLogin;
import static util.ValidaForm.isValid;

public class CadastrarLogin extends DaoLogin {

    public boolean creat(ModelLogin login) {
        try {
            if (isValid(login)) {
                for (int i = 0; i < getLogin().size(); i++) {
                    if (getLogin().get(i).getId() == login.getId()) {
                        DaoLogin.getLogin().get(i).setUsername(login.getUsername());
                        DaoLogin.getLogin().get(i).setPass(login.getPass());
                        DaoLogin.getLogin().get(i).setModulo(login.getModulo());
                        createXml(getLogin());
                        return true;
                    }
                }
                DaoLogin.getLogin().add(login);
                createXml(getLogin());
                return true;
            }
        } catch (GeneralSecurityException | IOException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public ModelLogin autenticaLogin(String username, String pass) {
        try {
            for (int i = 0; i < getLogin().size(); i++) {
                if (getLogin().get(i).getUsername().equals(username) && getLogin().get(i).getPass().equals(pass)) {
                    return getLogin().get(i);
                }
            }
        } catch (IOException | GeneralSecurityException e) {
        }
        return null;
    }
    private static final Logger LOG = getLogger(CadastrarLogin.class.getName());
}
