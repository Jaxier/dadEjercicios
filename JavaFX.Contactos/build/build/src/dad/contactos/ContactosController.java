package dad.contactos;

public class ContactosController {
	
	private ContactosView view;
	
	public ContactosController() {
		view = new ContactosView();
	}
	
	public void bind(Agenda agenda) {
		view.getContactosTable().itemsProperty().bind(agenda.contactosProperty());
		view.getContactosList().itemsProperty().bind(agenda.contactosProperty());
	}
	
	public ContactosView getView() {
		return view;
	}

}
