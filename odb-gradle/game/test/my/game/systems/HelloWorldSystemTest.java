package my.game.systems;

import com.artemis.*;
import my.game.components.Hello;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Example how you could set up system tests.
 *
 * @author Daan van Yperen
 */
class HelloWorldSystemTest {


    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        // do some magic to be able to test stdout.
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void When_entity_exists_Should_output_cheese_to_screen() {

        World w = new World(new WorldConfigurationBuilder()
                .with(new HelloWorldSystem()).build());

        int entityId = w.create();
        w.edit(entityId).create(Hello.class).message = "cheese";

        w.process();

        assertEquals("cheese", outContent.toString()); // console should've printed this.
    }

}