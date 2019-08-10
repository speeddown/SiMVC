package simvc;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * The View class loads the FXML file and binds outward-facing properties to an internal {@link IModel}
 * object that it shares with an associated {@link Controller} object.
 *
 * All View objects extend {@link AnchorPane} since they are used in FXML to arrange the UI.
 *
 * @param <T> the {@link Controller} subclass type
 * @param <V> the external model type
 */
public abstract class View<T extends Controller, V> extends AnchorPane
{
  protected T controller;
  protected FXMLLoader loader;

  /**
   * Default constructor. Calls the private load() method to begin loading the FXML for the
   * control
   */
  public View()
  {
    try {
      load();
      loadController ();
      start ();
    } catch (Exception e) {
      e.printStackTrace ();
    }
  }

  /**
   * Creates and initializes a new instance of the associated {@link IModel}.
   * Loads the FXML file associated with the {@link Controller}.
   */
  public abstract void load() throws Exception;

  public abstract void loadController ();

  public void start ()
  {
    try {
      loader.load ();
    } catch (IOException e) {
      e.printStackTrace ();
    }
  }

  public void bind (V externalModel)
  {
    controller.bind (externalModel);
  }
}
