package my.game.systems;

import com.artemis.E;
import com.artemis.FluidIteratingSystem;
import com.artemis.annotations.All;
import my.game.components.Hello;

/**
 * @author Daan van Yperen
 */
@All(Hello.class)
public class HelloWorldSystem extends FluidIteratingSystem {
    @Override
    protected void process(E e) {
        System.out.print(e.helloMessage());
    }
}
