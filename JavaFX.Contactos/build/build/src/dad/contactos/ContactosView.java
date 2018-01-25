package dad.contactos;

import java.time.LocalDate;

import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class ContactosView extends SplitPane {

	private TableView<Contacto> contactosTable;

	private TableColumn<Contacto, String> nombreColumn;
	private TableColumn<Contacto, LocalDate> fechaNacColumn;
	private TableColumn<Contacto, Number> telefonoColumn;

	private ListView<Contacto> contactosList;

	@SuppressWarnings("unchecked")
	public ContactosView() {
		super();

		nombreColumn = new TableColumn<Contacto, String>("Nombre");
		nombreColumn.setEditable(true);
		nombreColumn.setCellValueFactory(value -> value.getValue().nombreProperty());
		nombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		fechaNacColumn = new TableColumn<Contacto, LocalDate>("Fecha de nacimiento");
		fechaNacColumn.setCellValueFactory(value -> value.getValue().fechaNacimientoProperty());

		telefonoColumn = new TableColumn<Contacto, Number>("Teléfono");
		telefonoColumn.setCellValueFactory(value -> value.getValue().telefonoProperty());

		contactosTable = new TableView<Contacto>();
		contactosTable.setEditable(true);
		contactosTable.getColumns().addAll(nombreColumn, fechaNacColumn, telefonoColumn);

		contactosList = new ListView<Contacto>();

		setOrientation(Orientation.VERTICAL);
		setDividerPositions(0.5);
		getItems().addAll(contactosTable, contactosList);
	}

	public TableView<Contacto> getContactosTable() {
		return contactosTable;
	}

	public ListView<Contacto> getContactosList() {
		return contactosList;
	}

}
