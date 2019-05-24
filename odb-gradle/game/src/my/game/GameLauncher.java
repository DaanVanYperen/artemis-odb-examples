package my.game;

import com.artemis.*;
import my.game.components.Hello;
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
                .with(new HelloWorldSystem())
                .build();

        // 2. Create the world.
        World world = new World(setup);

        // 3. Create entity. You can do it here or inside a system.s
        int entityId = world.create();
        world.edit(entityId).create(Hello.class).message = "\n\rHello world!\n\r";

        // 4. Run the world. HelloWorldSystem will print the hello world message.
        world.process();
    }
}
