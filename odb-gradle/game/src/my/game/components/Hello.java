package my.game.components;

import com.artemis.Component;

/**
 * @author Daan van Yperen
 */
public class Hello extends Component {
    public String message;

    public void set(String message) {
        this.message = message;
    }
}
