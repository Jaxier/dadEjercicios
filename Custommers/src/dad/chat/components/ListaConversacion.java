package dad.chat.components;

import java.net.URL;
import java.util.ResourceBundle;

import dad.chat.models.ConversacionModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ListaConversacion extends ListView<ConversacionView> implements Initializable {

	private ListProperty<ConversacionModel> listaConversacion = new SimpleListProperty<>(this, "listaConversacion",
			FXCollections.observableArrayList());

	public ListaConversacion() {
		initialize(null, null);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		listaConversacion.addListener(new ListChangeListener<ConversacionModel>() {

			@Override
			public void onChanged(Change<? extends ConversacionModel> c) {
				while (c.next()) {
					for (ConversacionModel conversacionView : c.getAddedSubList()) {
						ConversacionView nv = new ConversacionView();
						System.out.println("Añadiendo");
						nv.setConversacion(conversacionView);
						ListaConversacion.this.getItems().add(nv);
					}
				}
			}

		});

	}

	public final ListProperty<ConversacionModel> listaConversacionProperty() {
		return this.listaConversacion;
	}

	public final ObservableList<ConversacionModel> getListaConversacion() {
		return this.listaConversacionProperty().get();
	}

	public final void setListaConversacion(final ObservableList<ConversacionModel> listaConversacion) {
		this.listaConversacionProperty().set(listaConversacion);
	}

}
