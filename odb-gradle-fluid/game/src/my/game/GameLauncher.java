package my.game;

import com.artemis.*;
import my.game.systems.HelloWorldSystem;

/**
 * Very basic game launcher.
 *
 * @author Daan van Yperen
 */
public class GameLauncher {

    public static void main( String[] args ) {

        // 1. Register any plugins, setup the world.
        WorldConfiguration setup = new WorldConfigurationBuilder()
                .dependsOn(FluidEntityPlugin.class)
                .with(new HelloWorldSystem())
                .build();

        // 2. Create the world.
        World world = new World(setup);

        // 3. Use fluid entity API to create a new entity with `hello` component.
        E.E().hello("\n\rHello world!\n\r");

        // 4. Run the world. HelloWorldSystem will print the hello world message.
        world.process();
    }
}
