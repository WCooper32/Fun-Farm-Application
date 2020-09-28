package tests;

import javafx.scene.control.ToggleGroup;
import main.engine.Manager;
import main.screens.SettingsScreen;
import main.state.StateSettings;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import tests.utility.JavaFXThreadingRule;

import static org.junit.Assert.*;

public class SettingsTest {
    private static final int TIMEOUT = 200;
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    //this rule allows JavaFX objects to be made in these tests

    private Manager manager;
    private SettingsScreen settingsScreen;

    @Before
    public void setup() {
        manager = new Manager();
        settingsScreen = new SettingsScreen(manager);
    }

    @Test (timeout = TIMEOUT)
    public void testName() {
        assertFalse(settingsScreen.verifyName());

        settingsScreen.getTextfieldName().setText("name");
        assertTrue(settingsScreen.verifyName());

        settingsScreen.getTextfieldName().setText("!!!!!!");
        assertTrue(settingsScreen.verifyName());

        settingsScreen.getTextfieldName().setText("   ");
        assertFalse(settingsScreen.verifyName());
    }

    @Test(timeout = TIMEOUT)
    public void testOptions() {
        ToggleGroup toggleDifficulty = settingsScreen.getToggleDifficulty();
        ToggleGroup toggleSeason = settingsScreen.getToggleSeason();
        ToggleGroup toggleSeed = settingsScreen.getToggleSeed();

        assertFalse(settingsScreen.verifyDifficulty());
        assertFalse(settingsScreen.verifySeason());
        assertFalse(settingsScreen.verifySeed());

        toggleDifficulty.selectToggle(toggleDifficulty.getToggles().get(0));
        assertTrue(settingsScreen.verifyDifficulty());
        assertEquals(1, ((StateSettings.Difficulty) toggleDifficulty.
                getSelectedToggle().getUserData()).getValue());

        toggleSeason.selectToggle(toggleSeason.getToggles().get(3));
        assertTrue(settingsScreen.verifySeason());
        assertEquals(4, ((StateSettings.Season) toggleSeason.
                getSelectedToggle().getUserData()).getValue());

        toggleSeed.selectToggle(toggleSeed.getToggles().get(1));
        assertTrue(settingsScreen.verifySeed());
        assertEquals(2, ((StateSettings.Seed) toggleSeed.
                getSelectedToggle().getUserData()).getValue());
    }
}