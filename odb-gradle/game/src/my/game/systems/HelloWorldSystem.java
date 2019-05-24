package my.game.systems;

import com.artemis.ComponentMapper;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import my.game.components.Hello;

/**
 * @author Daan van Yperen
 */
@All(Hello.class)
public class HelloWorldSystem extends IteratingSystem {

    protected ComponentMapper<Hello> mHello;



    @Override
    protected void process(int id) {
        System.out.print(mHello.get(id).message);
    }
}
