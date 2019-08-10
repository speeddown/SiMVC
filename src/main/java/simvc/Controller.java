package simvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class is responsible for binding the internal model of the custom
 * control to the UI element properties. Prepares data from the model to be displayed
 * on the UI.
 *
 * @param <V> the external model object type
 * @param <T> the internal view model type
 * @param <U> the view type
 */
public abstract class Controller<V, T extends IModel<V>, U extends View> implements Initializable
{
  @FXML
  protected AnchorPane root;

  protected T internalModel;
  protected U view;
  protected V externalModel;


  /**
   * Instantiates a new Controller.
   *
   * @param internalModel the internal {@link IModel}
   */
  public Controller(T internalModel)
  {
    if (internalModel != null)
    {
      this.internalModel = internalModel;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public abstract void initialize(URL location, ResourceBundle resources);

  protected abstract void bind (V externalModel);
}
